package co.edu.uptc.model;

import java.util.ArrayList;

/**
 * Team class that manages the team that integrates the game
 * 
 */

public class Team {

	private ArrayList<Archer> archers;
	private int score;
	private int code;
	private int wonRounds;

	/**
	 * Constructor method that manages the team that integrates the game
	 * 
	 * @param archers archers belonging to the team
	 * @param score   team score
	 * @param code    team code
	 */

	public Team(ArrayList<Archer> archers, int code) {
		this.archers = archers;
		this.code = code;
		score = 0;
		wonRounds = 0;
	}

	/**
	 * 
	 * getLuckyArcher Archer method who gets the luckiest player
	 * 
	 * @return Archer
	 */

	private Archer getLuckyArcher() {
		Archer luckyArcher = null;
		double maxLucky = 0;
		for (Archer archer : archers) {
			if (archer.getLuck() > maxLucky) {
				maxLucky = archer.getLuck();
				luckyArcher = archer;
			}
		}
		return luckyArcher;
	}

	/**
	 * 
	 * increaseLuckToArcher void method which increases the luck of the player who
	 * won the riffle
	 */

	public void increaseLuckToArcher() {
		getLuckyArcher().increaseCountLuck();
	}

	/**
	 * 
	 * grantThrowByLuckyArcher void method that grants an additional throw to the
	 * luckiest player
	 * 
	 * @param round
	 */

	public void grantThrowByLuckyArcher(int round) {
		Archer archer = getLuckyArcher();
		score += archer.individualLaunch();
		archer.increaseWonRaffles(round);
		archer.increaseCountLuck();
	}

	/**
	 * 
	 * giveExtraThrowByThreeThrows void methodwhich gives an extra throw for 3 shots
	 * won
	 */

	public void giveExtraThrowByThreeThrows() {
		for (Archer archer : archers) {
			if (archer.getWonRaffles() == 3)
				score += archer.individualLaunch();
		}
	}

	/**
	 * 
	 * obtainMostScoredArcher Archer method that the player with the highest score
	 * 
	 * @return Archer
	 */

	public Archer obtainMostScoredArcher() {
		Archer mostScoredArcher = archers.get(0);
		for (int i = 1; i < archers.size(); i++)
			if (archers.get(i).getRoundPoints() > mostScoredArcher.getRoundPoints())
				mostScoredArcher = archers.get(i);
		return mostScoredArcher;
	}

	/**
	 * 
	 * obtainMostWonRounds Archer method which the archer obtains with more rounds
	 * won
	 * 
	 * @return Archer archer with more rounds won
	 */

	public Archer obtainMostWonRounds() {
		Archer mostWonRoundsArcher = archers.get(0);
		for (int i = 1; i < archers.size(); i++)
			if (archers.get(i).getWonRounds() > mostWonRoundsArcher.getWonRounds())
				mostWonRoundsArcher = archers.get(i);
		return mostWonRoundsArcher;
	}

	/**
	 * 
	 * obtainRoundScore int method who gets the score for each round
	 * 
	 * @return int score per round
	 */

	public int obtainRoundScore() {
		int roundScore = 0;
		for (Archer archer : archers)
			roundScore += archer.getRoundPoints();
		return roundScore;
	}

	/**
	 * 
	 * obtainTotalScore int method who gets the total team score
	 * 
	 * @return int total team score
	 */

	public int obtainTotalScore() {
		int totalScore = 0;
		for (Archer archer : archers)
			totalScore += archer.getPoints();
		return totalScore;
	}

	/**
	 * 
	 * obtainMostLuckArcher Archer method who gets the luckiest archer on the team
	 * 
	 * @return Archer luckiest archer
	 */

	public Archer obtainMostLuckArcher() {
		Archer target = archers.get(0);
		for (int i = 1; i < archers.size(); i++)
			target = archers.get(i).getCountLuck() > target.getCountLuck() ? archers.get(i) : target;
		return target;
	}

	/**
	 * 
	 * obtainMostExperienced Archer method that gets the most experienced archer
	 * 
	 * @return Archer experienced archer
	 */

	public Archer obtainMostExperienced() {
		Archer mostExperiencedArcher = archers.get(0);
		for (int i = 1; i < archers.size(); i++)
			if (archers.get(i).getExperience() > mostExperiencedArcher.getExperience())
				mostExperiencedArcher = archers.get(i);
		return mostExperiencedArcher;
	}

	public int getScore() {
		return score;
	}

	public int getCode() {
		return code;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public ArrayList<Archer> getArchers() {
		return archers;
	}

	public int getWonRounds() {
		return wonRounds;
	}

	public void increaseWonRounds() {
		wonRounds++;
	}

	/**
	 * 
	 * decreaseResistanceByExperience void method that lowers the archer’s
	 * resistance when he has 9 experience points
	 */

	public void decreaseResistanceByExperience() {
		for (Archer archer : archers)
			if (archer.getExperience() == 9)
				archer.decreaseResistanceByExperience();
	}

	/**
	 * 
	 * regainRoundPoints void method that restores rounds to their original values
	 */

	public void regainRoundPoints() {
		for (Archer archer : archers)
			archer.regainRoundPoints();
	}
}