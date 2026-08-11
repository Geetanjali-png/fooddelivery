package com.geetanjali.fooddelivery.service;

import com.geetanjali.fooddelivery.entity.Cart;
import com.geetanjali.fooddelivery.entity.CartItem;
import com.geetanjali.fooddelivery.entity.User;

import java.util.List;

public interface CartService {

    Cart getOrCreateCart(User user);

    void addToCart(User user, Long menuItemId);

    List<CartItem> getCartItems(User user);

    void removeFromCart(User user, Long cartItemId);

    void clearCart(User user);
}