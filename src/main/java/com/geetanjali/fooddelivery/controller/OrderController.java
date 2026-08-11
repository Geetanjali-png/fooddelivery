package com.geetanjali.fooddelivery.controller;

import com.geetanjali.fooddelivery.entity.Order;
import com.geetanjali.fooddelivery.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public String viewOrder(
            @PathVariable Long id,
            Model model) {

        Order order = orderService
                .getOrderById(id)
                .orElseThrow(() ->
                        new RuntimeException("Order not found"));

        model.addAttribute("order", order);

        return "order-confirmation";
    }
}