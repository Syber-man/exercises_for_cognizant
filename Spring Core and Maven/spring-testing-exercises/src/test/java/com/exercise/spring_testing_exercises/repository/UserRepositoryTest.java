package com.exercise.spring_testing_exercises.repository;

import com.exercise.spring_testing_exercises.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository repository;

    @Test
    void testFindByName() {

        User user = new User(1L, "John");

        repository.save(user);

        User found = repository.findByName("John");

        assertNotNull(found);
        assertEquals("John", found.getName());
    }
}