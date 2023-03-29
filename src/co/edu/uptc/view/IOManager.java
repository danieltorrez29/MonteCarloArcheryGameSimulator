package co.edu.uptc.view;

import java.util.Scanner;

/**
 * IOManager class which manages the entire console, with all the results
 * obtained during the simulation.
 * 
 */

public class IOManager {

	/**
	 * Scanner object.
	 */

	private Scanner console;

	/**
	 * 
	 * Constructor method.
	 */

	public IOManager() {
		console = new Scanner(System.in);
	}

	/**
	 * 
	 * showMessage void method.
	 * 
	 * @param message.
	 */

	public void showMessage(String message) {
		System.out.println(message);
	}

	/**
	 * 
	 * readInt int method that read a integer value through console.
	 * 
	 * @param message.
	 * @return int.
	 */

	public int readInt(String message) {
		System.out.print(message);
		return console.nextInt();
	}
}