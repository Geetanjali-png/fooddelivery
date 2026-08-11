package com.geetanjali.fooddelivery.repository;

import com.geetanjali.fooddelivery.entity.Cart;
import com.geetanjali.fooddelivery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByUser(User user);
}