package com.geetanjali.fooddelivery.service.impl;

import com.geetanjali.fooddelivery.entity.Restaurant;
import com.geetanjali.fooddelivery.repository.RestaurantRepository;
import com.geetanjali.fooddelivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> getRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public List<Restaurant> searchRestaurants(String name) {
        return restaurantRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Restaurant> filterByCuisine(String cuisine) {
        return restaurantRepository.findByCuisineContainingIgnoreCase(cuisine);
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }
}