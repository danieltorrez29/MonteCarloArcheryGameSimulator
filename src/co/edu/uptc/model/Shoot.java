package co.edu.uptc.model;

/**
 * Def: Shoot class enumerado de las posibles posiciones en la diana que puede
 * obtener el arquero al realizar un lanzamiento con su correspondiente puntaje
 * 
 * @author Daniel Torres
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