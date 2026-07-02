package com.exercise.spring_testing_exercises.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {

    CalculatorService calculatorService = new CalculatorService();

    @Test
    void testAdd() {

        assertEquals(8, calculatorService.add(5,3));

    }
}