package com.geetanjali.fooddelivery.service;

import com.geetanjali.fooddelivery.entity.MenuItem;

import java.util.List;
import java.util.Optional;

public interface MenuItemService {

    MenuItem saveMenuItem(MenuItem menuItem);

    List<MenuItem> getAllMenuItems();

    Optional<MenuItem> getMenuItemById(Long id);

    List<MenuItem> getMenuItemsByRestaurant(Long restaurantId);

    List<MenuItem> searchMenuItems(Long restaurantId, String name);

    List<MenuItem> filterMenuItems(Long restaurantId, String category);

    void deleteMenuItem(Long id);
}