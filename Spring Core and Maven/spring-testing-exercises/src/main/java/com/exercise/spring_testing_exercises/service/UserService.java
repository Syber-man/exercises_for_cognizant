package com.exercise.spring_testing_exercises.service;

import com.exercise.spring_testing_exercises.entity.User;
import com.exercise.spring_testing_exercises.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}