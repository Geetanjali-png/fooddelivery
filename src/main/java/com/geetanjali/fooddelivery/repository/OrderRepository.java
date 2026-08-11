package com.geetanjali.fooddelivery.repository;

import com.geetanjali.fooddelivery.entity.Order;
import com.geetanjali.fooddelivery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);
}