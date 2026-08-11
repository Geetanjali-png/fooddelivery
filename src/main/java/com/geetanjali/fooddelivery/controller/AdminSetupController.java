package com.geetanjali.fooddelivery.controller;

import com.geetanjali.fooddelivery.entity.User;
import com.geetanjali.fooddelivery.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminSetupController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/create-admin")
    public String createAdmin() {

        if (userRepository.findByEmail("admin@gmail.com").isPresent()) {
            return "redirect:/login";
        }

        User admin = new User();

        admin.setFullName("Admin");
        admin.setEmail("admin@gmail.com");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setPhone("9999999999");
        admin.setAddress("Admin Address");
        admin.setRole("ADMIN");

        userRepository.save(admin);

        return "redirect:/login";
    }
}