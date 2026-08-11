package com.geetanjali.fooddelivery.service;

import com.geetanjali.fooddelivery.entity.Order;
import com.geetanjali.fooddelivery.entity.User;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order createOrder(User user, String deliveryAddress);

    List<Order> getOrdersByUser(User user);

    Optional<Order> getOrderById(Long id);
}