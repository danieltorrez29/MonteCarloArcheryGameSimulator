package co.edu.uptc.model;

/**
 * Enumerated Gender showing the different types of gender determined by a
 * character.
 *
 */

public enum Gender {

	MALE('M'), FEMALE('F');

	private char gender;

	private Gender(char gender) {
		this.gender = gender;
	}

	public char getGender() {
		return gender;
	}
}