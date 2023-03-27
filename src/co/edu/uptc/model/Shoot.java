package co.edu.uptc.model;

/**
 * Def: Shoot class listed of possible positions on the bullseye you can get the
 * goalkeeper when making a pitch with their corresponding score
 * 
 */

public enum Shoot {

	CENTRAL(10), INTERMEDIATE(9), OUTSIDE(8), ERROR(0);

	private int score;

	private Shoot(int score) {
		this.score = score;
	}

	public int getScore() {
		return score;
	}
}