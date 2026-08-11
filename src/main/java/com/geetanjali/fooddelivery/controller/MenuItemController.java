package com.geetanjali.fooddelivery.controller;

import com.geetanjali.fooddelivery.entity.MenuItem;
import com.geetanjali.fooddelivery.entity.Restaurant;
import com.geetanjali.fooddelivery.service.MenuItemService;
import com.geetanjali.fooddelivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/list")
    public String menuList(
            @RequestParam Long restaurantId,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String category,
            Model model) {

        Restaurant restaurant = restaurantService
                .getRestaurantById(restaurantId)
                .orElseThrow(() ->
                        new RuntimeException("Restaurant not found"));

        model.addAttribute("restaurant", restaurant);
        model.addAttribute("search", search);
        model.addAttribute("category", category);

        if (search != null && !search.trim().isEmpty()) {

            model.addAttribute(
                    "menuItems",
                    menuItemService.searchMenuItems(
                            restaurantId,
                            search
                    )
            );

        } else if (category != null && !category.trim().isEmpty()) {

            model.addAttribute(
                    "menuItems",
                    menuItemService.filterMenuItems(
                            restaurantId,
                            category
                    )
            );

        } else {

            model.addAttribute(
                    "menuItems",
                    menuItemService.getMenuItemsByRestaurant(
                            restaurantId
                    )
            );
        }

        return "menu-list";
    }

    @GetMapping("/add")
    public String showAddMenuItemForm(
            @RequestParam Long restaurantId,
            Model model) {

        Restaurant restaurant = restaurantService
                .getRestaurantById(restaurantId)
                .orElseThrow(() ->
                        new RuntimeException("Restaurant not found"));

        MenuItem menuItem = new MenuItem();
        menuItem.setRestaurant(restaurant);

        model.addAttribute("menuItem", menuItem);
        model.addAttribute("restaurant", restaurant);

        return "add-menu-item";
    }

    @PostMapping("/save")
    public String saveMenuItem(
            @ModelAttribute MenuItem menuItem) {

        menuItemService.saveMenuItem(menuItem);

        return "redirect:/menu/list?restaurantId="
                + menuItem.getRestaurant().getId();
    }

    @GetMapping("/delete/{id}")
    public String deleteMenuItem(
            @PathVariable Long id,
            @RequestParam Long restaurantId) {

        menuItemService.deleteMenuItem(id);

        return "redirect:/menu/list?restaurantId="
                + restaurantId;
    }
}