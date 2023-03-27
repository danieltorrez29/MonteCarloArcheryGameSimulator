package co.edu.uptc.view;

import java.util.Scanner;

/**
 * IOManager class which manages the entire console, with all the results
 * obtained during the simulation
 * 
 */

public class IOManager {

	private Scanner console;

	public IOManager() {
		console = new Scanner(System.in);
	}

	public void showMessage(String message) {
		System.out.println(message);
	}

	public int readInt(String message) {
		System.out.print(message);
		return console.nextInt();
	}
}