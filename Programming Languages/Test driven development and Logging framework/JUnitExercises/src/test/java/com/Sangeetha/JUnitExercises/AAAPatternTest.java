package com.Sangeetha.JUnitExercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private int num1;
    private int num2;

    // Setup method - runs before each test
    @BeforeEach
    void setup() {
        System.out.println("Before each test");
        num1 = 10;
        num2 = 20;
    }

    // Test method using AAA Pattern
    @Test
    void testAddition() {

        // Arrange
        // Variables are already initialized in @BeforeEach

        // Act
        int result = num1 + num2;

        // Assert
        assertEquals(30, result, "The sum should be 30");
    }

    // Another test
    @Test
    void testMultiplication() {

        // Arrange
        // Variables are already initialized in @BeforeEach

        // Act
        int result = num1 * num2;

        // Assert
        assertEquals(200, result, "The product should be 200");
    }

    // TearDown method - runs after each test
    @AfterEach
    void teardown() {
        System.out.println("After each test");
    }
}