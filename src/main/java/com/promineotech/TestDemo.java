package com.promineotech;

import java.util.Random;

public class TestDemo {

	// Method to add two positive integers together
	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException
			("Both parameters must be positive!");
		}
	}
	
	// The opposite of the first, will only take negative integers
	public int addNegative(int c, int d) {
		if (c < 0 && d < 0) {
			return c + d;
		} else {
			throw new IllegalArgumentException
			("Both parameters must be negative!");
		}
	}
	
	// Method to multiply a random integer by itself
	public int randomNumberSquared() {
		int squareNumber = getRandomInt();
		return squareNumber * squareNumber;
	}

	// Method to obtain random integer
	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
}
