package co.edu.uptc.model;

/**
 * Shoot enum that lists possible sections on the bullseye you can get the
 * archer when making a shoot with their corresponding score.
 * 
 */

public enum Shoot {

	/**
	 * Central section - Score 10.
	 */

	CENTRAL(10),

	/**
	 * Intermediate section - Score 9.
	 */

	INTERMEDIATE(9),

	/**
	 * Outside section - Score 8.
	 */

	OUTSIDE(8),

	/**
	 * Error section - Score 0.
	 */

	ERROR(0);

	/**
	 * shoot int score.
	 */

	private int score;

	/**
	 * 
	 * Constructor method.
	 * 
	 * @param score.
	 */

	private Shoot(int score) {
		this.score = score;
	}

	/**
	 * 
	 * getScore int method.
	 * 
	 * @return int.
	 */

	public int getScore() {
		return score;
	}
}