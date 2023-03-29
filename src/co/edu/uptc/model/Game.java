package co.edu.uptc.model;

import java.util.ArrayList;

/**
 * Game class representing an archery game.
 *
 */

public class Game {

	/**
	 * Team list.
	 */

	private Team[] teams;

	/**
	 * Game rounds.
	 */

	private int rounds;

	/**
	 * Winning gender.
	 */

	private Gender winnerGender;

	/**
	 * 
	 * Constructor method.
	 * 
	 * @param team1.
	 * @param team2.
	 */

	public Game(Team team1, Team team2) {
		teams = new Team[2];
		teams[0] = team1;
		teams[1] = team2;
		rounds = 1;
	}

	/**
	 * 
	 * raffleShoot void method that raffle a launch between teams.
	 */

	public void raffleShoot() {
		for (Team team : teams)
			team.grantThrowByLuckyArcher(rounds);
	}

	/**
	 * 
	 * determineRoundWinnerArcher void method that determines the winning player in
	 * the round.
	 */

	public void determineRoundWinnerArcher() {
		Archer winnerRoundArcher = tieBreakerRound(teams[0].obtainMostScoredArcher(),
				teams[1].obtainMostScoredArcher());
		winnerRoundArcher.gainExperience();
	}

	/**
	 * 
	 * tieBreakerRound Archer method that makes a tiebreaker between the archers who
	 * had more points of groups and return round winning archer.
	 * 
	 * @param a archer with highest team 1 round score.
	 * @param b archer with highest team 2 round score.
	 * @return Archer.
	 */

	private Archer tieBreakerRound(Archer a, Archer b) {
		Archer winner = null;
		int shootA = a.getRoundPoints();
		int shootB = b.getRoundPoints();
		while (shootA == shootB) {
			shootA = a.individualLaunch();
			shootB = b.individualLaunch();
		}
		winner = shootA > shootB ? a : b;
		winner.increaseWonRounds();
		return winner;
	}

	/**
	 * 
	 * obtainIndividualWinner Archer method who gets the individual winner of the
	 * game.
	 * 
	 * @return Archer.
	 */

	private Archer obtainIndividualWinner() {
		Archer a = teams[0].obtainMostWonRounds();
		Archer b = teams[1].obtainMostWonRounds();
		return a.getWonRounds() > b.getWonRounds() ? a : b;
	}

	/**
	 * 
	 * obtainExperienceWinner Archer method who gets the most experienced archer of
	 * the teams.
	 * 
	 * @return Archer.
	 */

	public Archer obtainExperienceWinner() {
		Archer a = teams[0].obtainMostExperienced();
		Archer b = teams[1].obtainMostExperienced();
		return a.getExperience() > b.getExperience() ? a : b;
	}

	/**
	 * 
	 * determineTeamRoundWinner void method which determines the winning team of the
	 * round.
	 */

	public void determineTeamRoundWinner() {
		int scoreTeam1 = teams[0].obtainRoundScore();
		int scoreTeam2 = teams[1].obtainRoundScore();
		teams[0].setScore(teams[0].getScore() + teams[0].obtainRoundScore());
		teams[1].setScore(teams[1].getScore() + teams[1].obtainRoundScore());
		Team teamWinner = (scoreTeam1 == scoreTeam2) ? null : (scoreTeam1 > scoreTeam2) ? teams[0] : teams[1];
		if (teamWinner != null)
			teamWinner.increaseWonRounds();
	}

	/**
	 * 
	 * obtainTeamWinner Team method that gets the game winning team.
	 * 
	 * @return Team.
	 */

	public Team obtainTeamWinner() {
		int scoreTeam1 = teams[0].obtainTotalScore();
		int scoreTeam2 = teams[1].obtainTotalScore();
		return (scoreTeam1 == scoreTeam2) ? null : (scoreTeam1 > scoreTeam2) ? teams[0] : teams[1];
	}

	/**
	 * 
	 * determineWinByGender void method that determines the gender of the archer who
	 * won the game.
	 */

	public void determineWinByGender() {
		winnerGender = obtainIndividualWinner().getGender();
	}

	/**
	 * 
	 * obtainMostLuckArcher Archer method that gets the player with more luck of the
	 * 2 teams.
	 * 
	 * @return Archer.
	 */

	public Archer obtainMostLuckArcher() {
		Archer countLuckArcherTeam1 = teams[0].obtainMostLuckArcher();
		Archer countLuckArcherTeam2 = teams[1].obtainMostLuckArcher();
		return (countLuckArcherTeam1.getCountLuck() == countLuckArcherTeam2.getCountLuck()) ? countLuckArcherTeam1
				: (countLuckArcherTeam1.getCountLuck() > countLuckArcherTeam2.getCountLuck()) ? countLuckArcherTeam1
						: countLuckArcherTeam2;
	}

	/**
	 * 
	 * obtainTeamScore int method that gets specific team score.
	 * 
	 * @param position.
	 * @return int.
	 */

	public int obtainTeamScore(int position) {
		return teams[position].getScore();
	}

	/**
	 * 
	 * obtainTeam Team method that gets a specific team.
	 * 
	 * @param position.
	 * @return Team.
	 */

	public Team obtainTeam(int position) {
		return teams[position];
	}

	/**
	 * 
	 * getRounds int method.
	 * 
	 * @return int.
	 */

	public int getRounds() {
		return rounds;
	}

	/**
	 * 
	 * getTeams Team[] method.
	 * 
	 * @return Team[].
	 */

	public Team[] getTeams() {
		return teams;
	}

	/**
	 * 
	 * increaseRounds void method that increases rounds in 1 unit.
	 */

	public void increaseRounds() {
		rounds++;
	}

	/**
	 * 
	 * giveExtraThrowByThreeThrows void method which gives an extra shot to each
	 * team.
	 */

	public void giveExtraThrowByThreeThrows() {
		teams[0].giveExtraThrowByThreeThrows();
		teams[1].giveExtraThrowByThreeThrows();
	}

	/**
	 * 
	 * decreaseResistanceByExperience void method that decreases the resistance by
	 * experience of each team.
	 */

	public void decreaseResistanceByExperience() {
		teams[0].decreaseResistanceByExperience();
		teams[1].decreaseResistanceByExperience();
	}

	/**
	 * 
	 * regainRoundPoints void method that restores round points for each team.
	 */

	public void regainRoundPoints() {
		for (Team team : teams)
			team.regainRoundPoints();
	}

	/**
	 * 
	 * getWinnerGender Gender method.
	 * 
	 * @return Gender.
	 */

	public Gender getWinnerGender() {
		return winnerGender;
	}

	/**
	 * 
	 * getArchers Archer ArrayList method who gets the archers of both teams.
	 * 
	 * @return Archer ArrayList.
	 */

	public ArrayList<Archer> getArchers() {
		ArrayList<Archer> archers = new ArrayList<Archer>();
		for (Team team : teams)
			for (Archer archer : team.getArchers())
				archers.add(archer);
		return archers;
	}
}