package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    private Calculator calc;

    // Setup method (runs before each test)
    @Before
    public void setUp() {
        System.out.println("Setting up...");
        calc = new Calculator();  // Arrange
    }

    // Teardown method (runs after each test)
    @After
    public void tearDown() {
        System.out.println("Cleaning up...");
        calc = null;
    }

    // Test method using AAA pattern
    @Test
    public void testAdd() {
        // Arrange done in @Before

        // Act
        int result = calc.add(2, 3);

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testMultiply() {
        int result = calc.multiply(4, 5);  // Act
        assertEquals(20, result);         // Assert
    }
}
