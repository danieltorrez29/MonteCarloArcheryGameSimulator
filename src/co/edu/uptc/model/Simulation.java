package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Simulation class which simulates 20000 games
 * 
 */

public class Simulation {

	private ArrayList<Game> listGame;
	private int countWonRoundsMale;
	private int countWonRoundsFemale;
	private int totalPointsTeam1;
	private int totalPointsTeam2;
	private Team team1;
	private Team team2;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param games
	 */

	public Simulation(int games) {
		listGame = new ArrayList<Game>();
		countWonRoundsMale = 0;
		countWonRoundsFemale = 0;
		totalPointsTeam1 = 0;
		totalPointsTeam2 = 0;
		initSimulation(games);
	}

	/**
	 * 
	 * initTeams void method method that initializes each team from scratch
	 */

	private void initTeams() {
		team1 = new Team(new ArrayList<Archer>(
				Arrays.asList(new Archer(1), new Archer(2), new Archer(3), new Archer(4), new Archer(5))), 1);
		team2 = new Team(new ArrayList<Archer>(
				Arrays.asList(new Archer(6), new Archer(7), new Archer(8), new Archer(9), new Archer(10))), 2);
	}

	/**
	 * 
	 * initSimulation void method
	 * 
	 * @param games
	 */

	private void initSimulation(int games) {
		for (int i = 0; i < games; i++) { // Games loop
			initTeams();
			Game currentGame = new Game(team1, team2);
			listGame.add(currentGame); // Add new game to list
			for (int j = 0; j < 10; j++) { // Rounds loop
				for (Team team : listGame.get(i).getTeams()) { // Teams loop
					for (Archer archer : team.getArchers()) { // Archer loop
						archer.launch();
					}
				}
				currentGame.raffleShoot(); // Raffle shoot
				if (j >= 2) {
					currentGame.giveExtraThrowByThreeThrows(); // Give extra shoot
				}
				currentGame.determineRoundWinnerArcher(); // Determine round winner archer
				currentGame.determineTeamRoundWinner(); // Determine team round winner
				currentGame.increaseRounds(); // Increase game rounds
				currentGame.regainRoundPoints(); // Regain players round points
			}
			currentGame.determineWinByGender();
		}
	}

	/**
	 * 
	 * obtainTotalWinByGender Gender method that initializes gets the winning gender
	 * per game and counts it.
	 * 
	 * @return Gender
	 */

	private Gender obtainTotalWinByGender() {
		for (Game game : listGame)
			if (game.getWinnerGender().getGender() == 'M')
				countWonRoundsMale++;
			else
				countWonRoundsFemale++;
		return (countWonRoundsMale > countWonRoundsFemale) ? Gender.MALE : Gender.FEMALE;
	}

	/**
	 * 
	 * determineTeamWinner void method that counts the total points of all games.
	 */

	private void determineTeamWinner() {
		for (Game game : listGame) {
			totalPointsTeam1 += game.obtainTeamScore(0);
			totalPointsTeam2 += game.obtainTeamScore(1);
		}
	}

	/**
	 * 
	 * obtainLuckyArchers String method that gets the list of lucky archers in each
	 * game in a String.
	 * 
	 * @return String
	 */

	public String obtainLuckyArchers() {
		String luckyArchersString = "> Archers with more lucky\n";
		for (int i = 0; i < listGame.size(); i++)
			luckyArchersString += "Game " + (i + 1) + " : Archer " + listGame.get(i).obtainMostLuckArcher().getCode()
					+ "\n";
		return luckyArchersString;
	}

	/**
	 * 
	 * obtainExperienceArchers String methodgets the most experienced archers in a
	 * string
	 * 
	 * @return String
	 */

	public String obtainExperienceArchers() {
		String experienceArchersString = "> Archers with more experience  \n";
		for (int i = 0; i < listGame.size(); i++) {
			experienceArchersString += "Game " + (i + 1) + " : Archer "
					+ listGame.get(i).obtainExperienceWinner().getCode() + "\n";
		}
		return experienceArchersString;
	}

	/**
	 * 
	 * obtainWinnerTeam String method that gets the winning team of all games in a
	 * String.
	 * 
	 * @return String
	 */

	public String obtainWinnerTeam() {
		determineTeamWinner();
		Team targetTeam = null;
		int targetPoints = 0;
		if (totalPointsTeam1 > totalPointsTeam2) {
			targetTeam = team1;
			targetPoints = totalPointsTeam1;
		} else {
			targetTeam = team2;
			targetPoints = totalPointsTeam2;
		}
		return "TEAM WIN GAME: " + targetTeam.getCode() + " with " + targetPoints + " points";
	}

	/**
	 * 
	 * obtainGenderTotalWin String method the message of the genre that wins more
	 * games
	 * 
	 * @return String
	 */

	public String obtainGenderTotalWin() {
		return "GENDER WIN GAME: " + this.obtainTotalWinByGender();
	}

	/**
	 * 
	 * obtainGendersByGame String method which gets a message setting the winning
	 * gender per game
	 * 
	 * @return String message
	 */

	public String obtainGendersByGame() {
		String gendersByGameString = "> Gender winners  \n";
		for (int i = 0; i < listGame.size(); i++) {
			gendersByGameString += "Game " + (i + 1) + " : " + listGame.get(i).getWinnerGender().getGender() + "\n";
		}
		return gendersByGameString;
	}

	/**
	 * 
	 * obtainArchersByGame ArrayList<Archer> method that gets the list of archers of
	 * a game.
	 * 
	 * @param game
	 * @return ArrayList<Archer>
	 */

	public ArrayList<Archer> obtainArchersByGame(int game) {
		return listGame.get(game - 1).getArchers();
	}
}