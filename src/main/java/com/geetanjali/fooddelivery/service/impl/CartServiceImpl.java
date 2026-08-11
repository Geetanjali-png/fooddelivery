package com.geetanjali.fooddelivery.service.impl;

import com.geetanjali.fooddelivery.entity.Cart;
import com.geetanjali.fooddelivery.entity.CartItem;
import com.geetanjali.fooddelivery.entity.MenuItem;
import com.geetanjali.fooddelivery.entity.User;
import com.geetanjali.fooddelivery.repository.CartItemRepository;
import com.geetanjali.fooddelivery.repository.CartRepository;
import com.geetanjali.fooddelivery.repository.MenuItemRepository;
import com.geetanjali.fooddelivery.service.CartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final MenuItemRepository menuItemRepository;

    public CartServiceImpl(
            CartRepository cartRepository,
            CartItemRepository cartItemRepository,
            MenuItemRepository menuItemRepository) {

        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public Cart getOrCreateCart(User user) {

        return cartRepository.findByUser(user)
                .orElseGet(() -> {

                    Cart cart = new Cart();
                    cart.setUser(user);

                    return cartRepository.save(cart);
                });
    }

    @Override
    public void addToCart(User user, Long menuItemId) {

        Cart cart = getOrCreateCart(user);

        MenuItem menuItem = menuItemRepository
                .findById(menuItemId)
                .orElseThrow(() ->
                        new RuntimeException("Menu item not found"));

        CartItem cartItem = cartItemRepository
                .findByCartAndMenuItem(cart, menuItem)
                .orElse(null);

        if (cartItem == null) {

            cartItem = new CartItem();
            cartItem.setCart(cart);
            cartItem.setMenuItem(menuItem);
            cartItem.setQuantity(1);

        } else {

            cartItem.setQuantity(
                    cartItem.getQuantity() + 1
            );
        }

        cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItem> getCartItems(User user) {

        Cart cart = getOrCreateCart(user);

        return cartItemRepository.findByCart(cart);
    }

    @Override
    public void removeFromCart(
            User user,
            Long cartItemId) {

        Cart cart = getOrCreateCart(user);

        CartItem cartItem = cartItemRepository
                .findById(cartItemId)
                .orElseThrow(() ->
                        new RuntimeException("Cart item not found"));

        if (cartItem.getCart().getId().equals(cart.getId())) {

            cartItemRepository.delete(cartItem);
        }
    }

    @Override
    public void clearCart(User user) {

        Cart cart = getOrCreateCart(user);

        List<CartItem> cartItems =
                cartItemRepository.findByCart(cart);

        cartItemRepository.deleteAll(cartItems);
    }
}