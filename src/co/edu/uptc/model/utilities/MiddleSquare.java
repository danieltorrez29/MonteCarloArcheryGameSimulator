package co.edu.uptc.model.utilities;

import java.security.SecureRandom;

/**
 * MiddleSquare class that generates a pseudorandom number using middle square
 * method.
 * 
 */

public class MiddleSquare {

	/**
	 * Define an instance variable for the seed.
	 */

	private long seed;

	/**
	 * Define a lower limit.
	 */

	private int min;

	/**
	 * Define an upper limit.
	 */

	private int max;

	/**
	 * 
	 * Constructor method that generates a random seed using SecureRandom.
	 * 
	 * @param min.
	 * @param max.
	 */

	public MiddleSquare(int min, int max) {
		seed = new SecureRandom().nextLong();
		this.min = min;
		this.max = max;
	}

	/**
	 * 
	 * generateRi double method.
	 * 
	 * @return double.
	 */

	private double generateRi() {
		// Calculate the square of the seed
		long square = seed * seed;
		// Convert the square to a string
		String squareStr = String.format("%012d", square);
		// Get the length of the string and calculate the indices of the middle number
		int size = squareStr.length();
		int start = (size - 8) / 2;
		int end = start + 4;
		// Extract the characters representing the middle number
		String numberStr = squareStr.substring(start, end);
		// Convert the string to a numeric value and divide it by 10000 to get a number
		// in the range [0, 1)
		double number = Double.parseDouble(numberStr) / 10000.0;
		// Update the seed for the next iteration
		seed = Long.parseLong(squareStr.substring(2, 10));
		return number;
	}

	/**
	 * 
	 * generateNi double method.
	 * 
	 * @return double.
	 */

	public double generateNi() {
		return min + (max - min) * generateRi();
	}
}