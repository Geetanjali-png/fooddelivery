package com.geetanjali.fooddelivery.service;

import com.geetanjali.fooddelivery.entity.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    Restaurant saveRestaurant(Restaurant restaurant);

    List<Restaurant> getAllRestaurants();

    Optional<Restaurant> getRestaurantById(Long id);

    List<Restaurant> searchRestaurants(String name);

    List<Restaurant> filterByCuisine(String cuisine);

    void deleteRestaurant(Long id);
}