package com.exercise.spring_testing_exercises.integration;

import com.exercise.spring_testing_exercises.entity.User;
import com.exercise.spring_testing_exercises.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserIntegrationTest {

    @Autowired
    UserRepository repository;

    @Test
    void testSaveAndFindUser() {

        User user = new User(1L, "John");

        repository.save(user);

        User found = repository.findById(1L).orElse(null);

        assertNotNull(found);

        assertEquals("John", found.getName());
    }
}