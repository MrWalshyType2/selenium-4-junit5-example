package com.qa.selenium_example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	
	Calculator calculator;
	
	@BeforeAll
	static void setUpBeforeAll() {
		// @BeforeAll must annotate a static method by default
		System.out.println("Runs once before all tests and then never again for this class");
	}
	
	@AfterAll
	static void teardownAfterAll() {
		// @AfterAll must annotate a static method by default
		System.out.println("Runs once after all tests");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Setting up before each test");
		calculator = new Calculator();
	}
	
	@AfterEach
	void teardown() {
		System.out.println("Runs after each test");
	}

	@Test
	void smallNumbersTest() {
		// Arrange (setup test data and prerequisites)
		double num1 = 50, num2 = 50, expectedResult = 100;
		// Act (perform the action)
		double actualResult = calculator.add(num1, num2);
		// Assert (the result was as expected)
		Assertions.assertEquals(expectedResult, actualResult);
	}

	@Test
	void largeNumbersTest() {
		// Arrange (setup test data and prerequisites)
		double num1 = 50_000, num2 = 50_000, expectedResult = 100_000;
		// Act (perform the action)
		double actualResult = calculator.add(num1, num2);
		// Assert (the result was as expected)
		Assertions.assertEquals(expectedResult, actualResult);
	}
}
