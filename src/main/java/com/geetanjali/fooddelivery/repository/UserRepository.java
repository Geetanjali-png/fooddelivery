package com.geetanjali.fooddelivery.repository;

import com.geetanjali.fooddelivery.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}