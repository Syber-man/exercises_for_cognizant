package com.exercise.spring_testing_exercises.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorParameterizedTest {

    CalculatorService calculator = new CalculatorService();

    @ParameterizedTest
    @CsvSource({
            "2,3,5",
            "4,5,9",
            "10,20,30",
            "100,200,300"
    })
    void testAdd(int a, int b, int expected) {

        assertEquals(expected, calculator.add(a, b));

    }
}