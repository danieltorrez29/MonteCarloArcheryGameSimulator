package co.edu.uptc.model.business;

/**
 * Gender enum that lists the different types of gender determined by a
 * character.
 *
 */

public enum Gender {

	/**
	 * Male constant.
	 */

	MALE('M'),

	/**
	 * Female constant.
	 */

	FEMALE('F');

	/**
	 * char gender variable.
	 */

	private char gender;

	/**
	 * 
	 * Constructor method.
	 * 
	 * @param gender.
	 */

	private Gender(char gender) {
		this.gender = gender;
	}

	/**
	 * 
	 * getGender char method.
	 * 
	 * @return char.
	 */

	public char getGender() {
		return gender;
	}
}