package co.edu.uptc.model;

/**
 * Enumerado Género que muestra los distintos tipos de género determinado por un
 * caracter.
 * 
 * @author Daniel Torres
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