package com.geetanjali.fooddelivery.controller;

import com.geetanjali.fooddelivery.entity.Cart;
import com.geetanjali.fooddelivery.entity.CartItem;
import com.geetanjali.fooddelivery.entity.User;
import com.geetanjali.fooddelivery.service.CartService;
import com.geetanjali.fooddelivery.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final UserService userService;

    public CartController(
            CartService cartService,
            UserService userService) {

        this.cartService = cartService;
        this.userService = userService;
    }

    @GetMapping
    public String viewCart(
            @RequestParam Long userId,
            Model model) {

        User user = userService
                .getUserById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Cart cart = cartService.getOrCreateCart(user);

        List<CartItem> cartItems =
                cartService.getCartItems(user);

        model.addAttribute("cart", cart);
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("user", user);

        return "cart";
    }

    @PostMapping("/add")
    public String addToCart(
            @RequestParam Long userId,
            @RequestParam Long menuItemId) {

        User user = userService
                .getUserById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        cartService.addToCart(user, menuItemId);

        return "redirect:/cart?userId=" + userId;
    }

    @GetMapping("/remove/{id}")
    public String removeFromCart(
            @PathVariable Long id,
            @RequestParam Long userId) {

        User user = userService
                .getUserById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        cartService.removeFromCart(user, id);

        return "redirect:/cart?userId=" + userId;
    }

    @GetMapping("/clear")
    public String clearCart(
            @RequestParam Long userId) {

        User user = userService
                .getUserById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        cartService.clearCart(user);

        return "redirect:/cart?userId=" + userId;
    }
}