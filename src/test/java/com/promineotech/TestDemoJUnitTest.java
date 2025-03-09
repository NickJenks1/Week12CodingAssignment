package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	// Parameterized Test for the addPositive method in TestDemo
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, 
			int expected, boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy( () -> testDemo.addPositive(a, b))
			.isInstanceOf(IllegalArgumentException.class);
		}
	}

	static Stream<Arguments> argumentsForAddPositive() {
			return Stream.of(
				arguments(2, 4, 6, false),
				arguments(0, 2, 2, true),
				arguments(5, 10, 15, false),
				arguments(10, 20, 30, false),
				arguments(-1, -2, -3, true),
				arguments(0, 0, 0, true),
				arguments(-10, -20, -30, true),
				arguments(3, 6, 9, false),
				arguments(4, 6, 10, false)
			);
	}

	// Test for the addPositive method in TestDemo
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(30, 20)).isEqualTo(50);
		assertThat(testDemo.addPositive(50, 50)).isEqualTo(100);
		assertThat(testDemo.addPositive(500, 500)).isEqualTo(1000);
		assertThat(testDemo.addPositive(1, 2)).isEqualTo(3);
		assertThat(testDemo.addPositive(5, 5)).isEqualTo(10);
		assertThat(testDemo.addPositive(12, 48)).isEqualTo(60);
	}
	
	// Parameterized test for the addNegative method in TestDemo
	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddNegative")
	void assertThatTwoNegativeNumbersAreAddedCorrectly(int c, int d, 
			int expected, boolean expectException) {
		
		if(!expectException) {
			assertThat(testDemo.addNegative(c, d)).isEqualTo(expected);
		} else {
			assertThatThrownBy( () -> testDemo.addNegative(c, d))
			.isInstanceOf(IllegalArgumentException.class);
		}
	}

	static Stream<Arguments> argumentsForAddNegative() {
			return Stream.of(
				arguments(-2, -4, -6, false),
				arguments(0, -2, -2, true),
				arguments(-5, -10, -15, false),
				arguments(-10, -20, -30, false),
				arguments(1, 2, 3, true),
				arguments(0, 0, 0, true),
				arguments(10, 20, 30, true),
				arguments(-3, -6, -9, false),
				arguments(-4, -6, -10, false)
			);
	}
	
	// Test for the addNegative method in TestDemo
	@Test
	void assertThatPairsOfNegativeNumbersAreAddedCorrectly() {
		assertThat(testDemo.addNegative(-10, -20)).isEqualTo(-30);
		assertThat(testDemo.addNegative(-1, -2)).isEqualTo(-3);
		assertThat(testDemo.addNegative(-4, -2)).isEqualTo(-6);
		assertThat(testDemo.addNegative(-1, -1)).isEqualTo(-2);
		assertThat(testDemo.addNegative(-7, -8)).isEqualTo(-15);
		assertThat(testDemo.addNegative(-12, -24)).isEqualTo(-36);
		assertThat(testDemo.addNegative(-30, -50)).isEqualTo(-80);
	}
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}
	
}