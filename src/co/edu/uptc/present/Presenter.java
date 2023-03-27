package co.edu.uptc.present;

import co.edu.uptc.model.Simulation;
import co.edu.uptc.view.GraphFrame;
import co.edu.uptc.view.IOManager;

/**
 * Presenter class
 * 
 */

public class Presenter {

	/**
	 * Attributes
	 */

	private Simulation simulation;
	private IOManager ioManager;

	/**
	 * Constructor method
	 */

	public Presenter(int games) {
		simulation = new Simulation(games);
		ioManager = new IOManager();
		initApp();
	}

	/**
	 * 
	 * plotArchersByGame void method that graphs archers points in a game.
	 * 
	 * @param game
	 */

	private void plotArchersByGame(int gameNumber) {
		new GraphFrame(simulation.obtainArchersByGame(gameNumber), gameNumber);
	}

	/**
	 * 
	 * initApp void method that shows main menu and read options.
	 */

	private void initApp() {
		int option = 0;
		do {
			option = ioManager.readInt(
					"\nMONTECARLO ARCHERY GAME SIMULATOR\n\n1. Player with the luckiest in each of the games.\n2. Player who has gained more experience at the end of each of the games.\n3. Winning team including scores.\n4. Gender with more wins in each game and with more total wins.\n5. Graph of the points obtained by each of the players vs game.\n0. Exit.\n\nChoose an option: ");
			switch (option) {
			case 1:
				ioManager.showMessage("\n\n" + simulation.obtainLuckyArchers());
				break;

			case 2:
				ioManager.showMessage("\n\n" + simulation.obtainExperienceArchers());
				break;

			case 3:
				ioManager.showMessage("\n\n" + simulation.obtainWinnerTeam());
				break;

			case 4:
				ioManager.showMessage(
						"\n\n" + simulation.obtainGendersByGame() + "\n\n" + simulation.obtainGenderTotalWin());
				break;

			case 5:
				int gameNumber = ioManager.readInt("Enter number game: ");
				plotArchersByGame(gameNumber);
				break;

			case 0:
				ioManager.showMessage("Exitting...");
				System.exit(0);
				break;

			default:
				break;
			}
		} while (option != 0);
	}
}