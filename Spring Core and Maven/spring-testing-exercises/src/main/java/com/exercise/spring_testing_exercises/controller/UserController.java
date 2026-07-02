package com.exercise.spring_testing_exercises.controller;

import com.exercise.spring_testing_exercises.entity.User;
import com.exercise.spring_testing_exercises.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {

        return ResponseEntity.ok(userService.getUserById(id));

    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {

        return ResponseEntity.ok(userService.saveUser(user));

    }
}