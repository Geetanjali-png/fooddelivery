package com.geetanjali.fooddelivery.service.impl;

import com.geetanjali.fooddelivery.entity.MenuItem;
import com.geetanjali.fooddelivery.repository.MenuItemRepository;
import com.geetanjali.fooddelivery.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    @Override
    public MenuItem saveMenuItem(MenuItem menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public Optional<MenuItem> getMenuItemById(Long id) {
        return menuItemRepository.findById(id);
    }

    @Override
    public List<MenuItem> getMenuItemsByRestaurant(Long restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId);
    }

    @Override
    public List<MenuItem> searchMenuItems(Long restaurantId, String name) {
        return menuItemRepository
                .findByRestaurantIdAndNameContainingIgnoreCase(
                        restaurantId,
                        name
                );
    }

    @Override
    public List<MenuItem> filterMenuItems(Long restaurantId, String category) {
        return menuItemRepository
                .findByRestaurantIdAndCategoryContainingIgnoreCase(
                        restaurantId,
                        category
                );
    }

    @Override
    public void deleteMenuItem(Long id) {
        menuItemRepository.deleteById(id);
    }
}