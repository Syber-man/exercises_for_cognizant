package com.exercise.spring_testing_exercises.repository;

import com.exercise.spring_testing_exercises.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByName(String name);

}