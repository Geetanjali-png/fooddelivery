package com.geetanjali.fooddelivery.repository;

import com.geetanjali.fooddelivery.entity.OrderItem;
import com.geetanjali.fooddelivery.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    List<OrderItem> findByOrder(Order order);
}