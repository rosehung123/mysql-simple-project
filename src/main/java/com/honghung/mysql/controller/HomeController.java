package com.honghung.mysql.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.honghung.mysql.entity.User;
import com.honghung.mysql.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class HomeController {
    private final UserRepository userRepository;

    @GetMapping("")
    public String getMethodName() {
        return "<h1>Welcome to MySQL Spring Boot Application!</h1>";
    }

    @PostMapping("/insert")
    public ResponseEntity<User> postMethodName() {
        //TODO: process POST request
        var user = new User();
        user.setName("Dam Hong Hung");
        user.setEmail("jJyqH@example.com");
        user.setPassword("123456");
        var entity = userRepository.save(user);
        return ResponseEntity.ok().body(entity);
    }
    
    
}