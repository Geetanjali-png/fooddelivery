package com.geetanjali.fooddelivery.service;

import com.geetanjali.fooddelivery.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User registerUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    Optional<User> getUserByEmail(String email);

    void deleteUser(Long id);
}