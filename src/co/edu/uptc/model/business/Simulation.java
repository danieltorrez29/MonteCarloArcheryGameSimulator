package co.edu.uptc.model.business;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Simulation class which simulates n games.
 * 
 */

public class Simulation {

	/**
	 * Game list.
	 */

	private ArrayList<Game> listGame;

	/**
	 * Won rounds male counter.
	 */

	private int countWonRoundsMale;

	/**
	 * Won rounds female counter.
	 */

	private int countWonRoundsFemale;

	/**
	 * Total points team 1.
	 */

	private int totalPointsTeam1;

	/**
	 * Total points team 2.
	 */

	private int totalPointsTeam2;

	/**
	 * Team 1.
	 */

	private Team team1;

	/**
	 * Team 2.
	 */

	private Team team2;

	/**
	 * 
	 * Constructor method.
	 * 
	 * @param games.
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
	 * initTeams void method method that initializes each team from scratch.
	 */

	private void initTeams() {
		team1 = new Team(new ArrayList<Archer>(
				Arrays.asList(new Archer(1), new Archer(2), new Archer(3), new Archer(4), new Archer(5))), 1);
		team2 = new Team(new ArrayList<Archer>(
				Arrays.asList(new Archer(6), new Archer(7), new Archer(8), new Archer(9), new Archer(10))), 2);
	}

	/**
	 * 
	 * initSimulation void method that contains all the simulation logic.
	 * 
	 * @param games.
	 */

	private void initSimulation(int games) {
		for (int i = 0; i < games; i++) { // Games loop
			initTeams();
			Game currentGame = new Game(team1, team2);
			listGame.add(currentGame); // Add new game to list
			for (int j = 0; j < 10; j++) { // Rounds loop
				for (Team team : listGame.get(i).getTeams()) // Teams loop
					for (Archer archer : team.getArchers()) // Archer loop
						archer.launch();
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
	 * obtainTotalWinByGender Gender method that gets the winning gender per game
	 * and counts it.
	 * 
	 * @return Gender.
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
	 * @return String.
	 */

	public String obtainLuckyArchers() {
		String luckyArchersString = "";
		for (int i = 0; i < listGame.size(); i++)
			luckyArchersString += "Game " + (i + 1) + " : Archer " + listGame.get(i).obtainMostLuckArcher().getCode()
					+ "\n";
		return luckyArchersString;
	}

	/**
	 * 
	 * obtainExperiencedArchers String methodgets the most experienced archers in a
	 * String.
	 * 
	 * @return String.
	 */

	public String obtainExperiencedArchers() {
		String experienceArchersString = "";
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
	 * @return String.
	 */

	public String obtainWinningTeam() {
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
		return "TEAM " + targetTeam.getCode() + " with " + new DecimalFormat("#,###,###,##0").format(targetPoints)
				+ " points";
	}

	/**
	 * 
	 * obtainGenderTotalWin String method that returns message of the gender that
	 * wins more games.
	 * 
	 * @return String.
	 */

	public String obtainGenderTotalWin() {
		return obtainTotalWinByGender().getGender() == 'F' ? "FEMALE" : "MALE";
	}

	/**
	 * 
	 * obtainGendersByGame String method which gets a message setting the winning
	 * gender per game.
	 * 
	 * @return String.
	 */

	public String obtainGendersByGame() {
		String gendersByGameString = "";
		for (int i = 0; i < listGame.size(); i++) {
			gendersByGameString += "Game " + (i + 1) + " : " + listGame.get(i).getWinnerGender().getGender() + "\n";
		}
		return gendersByGameString;
	}

	/**
	 * 
	 * obtainArchersByGame Archer ArrayList method that gets the list of archers on
	 * a specific game.
	 * 
	 * @param game.
	 * @return Archer ArrayList.
	 */

	public ArrayList<Archer> obtainArchersByGame(int game) {
		return listGame.get(game - 1).getArchers();
	}

	/**
	 * 
	 * getArchersPerGame Archer ArrayList method that gets the list of archers per
	 * game.
	 * 
	 * @return Archer ArrayList.
	 */

	public ArrayList<Archer> getArchersPerGame() {
		ArrayList<Archer> archers = new ArrayList<Archer>();
		for (Game game : listGame)
			for (Archer archer : game.getArchers())
				archers.add(archer);
		return archers;
	}
}