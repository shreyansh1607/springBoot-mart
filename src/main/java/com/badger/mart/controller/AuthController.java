package com.badger.mart.controller;
import com.badger.mart.model.User;
import com.badger.mart.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        // 1. Hash the plain text password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // 2. Save to DB
        userRepository.save(user);
        return "User registered successfully with BCrypt!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "If you see this, you are authenticated!";
    }
}
