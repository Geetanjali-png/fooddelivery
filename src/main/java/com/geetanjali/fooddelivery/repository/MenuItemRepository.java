package com.geetanjali.fooddelivery.repository;

import com.geetanjali.fooddelivery.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    List<MenuItem> findByRestaurantId(Long restaurantId);

    List<MenuItem> findByRestaurantIdAndCategoryContainingIgnoreCase(
            Long restaurantId,
            String category
    );

    List<MenuItem> findByRestaurantIdAndNameContainingIgnoreCase(
            Long restaurantId,
            String name
    );
}