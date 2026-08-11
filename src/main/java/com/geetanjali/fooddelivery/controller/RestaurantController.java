package com.geetanjali.fooddelivery.controller;

import com.geetanjali.fooddelivery.entity.Restaurant;
import com.geetanjali.fooddelivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/list")
    public String restaurantList(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String cuisine,
            Model model) {

        if (search != null && !search.trim().isEmpty()) {

            model.addAttribute(
                    "restaurants",
                    restaurantService.searchRestaurants(search)
            );

        } else if (cuisine != null && !cuisine.trim().isEmpty()) {

            model.addAttribute(
                    "restaurants",
                    restaurantService.filterByCuisine(cuisine)
            );

        } else {

            model.addAttribute(
                    "restaurants",
                    restaurantService.getAllRestaurants()
            );
        }

        model.addAttribute("search", search);
        model.addAttribute("cuisine", cuisine);

        return "restaurant-list";
    }

    @GetMapping("/{id}")
    public String restaurantDetails(
            @PathVariable Long id,
            Model model) {

        Restaurant restaurant = restaurantService
                .getRestaurantById(id)
                .orElseThrow(() ->
                        new RuntimeException("Restaurant not found"));

        model.addAttribute("restaurant", restaurant);

        return "restaurant-details";
    }

    @GetMapping("/add")
    public String showAddRestaurantForm(Model model) {

        model.addAttribute("restaurant", new Restaurant());

        return "add-restaurant";
    }

    @PostMapping("/save")
    public String saveRestaurant(
            @ModelAttribute Restaurant restaurant) {

        restaurantService.saveRestaurant(restaurant);

        return "redirect:/restaurant/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteRestaurant(
            @PathVariable Long id) {

        restaurantService.deleteRestaurant(id);

        return "redirect:/restaurant/list";
    }
}