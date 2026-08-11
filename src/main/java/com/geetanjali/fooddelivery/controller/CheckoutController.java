package com.geetanjali.fooddelivery.controller;

import com.geetanjali.fooddelivery.entity.Order;
import com.geetanjali.fooddelivery.entity.User;
import com.geetanjali.fooddelivery.service.OrderService;
import com.geetanjali.fooddelivery.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    private final OrderService orderService;
    private final UserService userService;

    public CheckoutController(
            OrderService orderService,
            UserService userService) {

        this.orderService = orderService;
        this.userService = userService;
    }

    @GetMapping
    public String checkoutPage(
            @RequestParam Long userId,
            Model model) {

        User user = userService
                .getUserById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        model.addAttribute("user", user);

        return "checkout";
    }

    @PostMapping("/place-order")
    public String placeOrder(
            @RequestParam Long userId,
            @RequestParam String deliveryAddress) {

        User user = userService
                .getUserById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Order order = orderService.createOrder(
                user,
                deliveryAddress
        );

        return "redirect:/orders/" + order.getId();
    }
}