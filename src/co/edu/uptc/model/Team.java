package co.edu.uptc.model;

import java.util.ArrayList;

/**
 * Team class
 * 
 * @author Daniel Torres
 */

public class Team {

	private ArrayList<Archer> archers;
	private int score;
	private int code;

	/**
	 * Constructor method
	 * 
	 * @param archers
	 * @param score
	 * @param code
	 */

	public Team(ArrayList<Archer> archers, int code) {
		this.archers = archers;
		this.code = code;
		score = 0;
	}

	/**
	 * 
	 * getLuckyArcher Archer method
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
	 * increaseLuckToArcher void method
	 */

	public void increaseLuckToArcher() {
		getLuckyArcher().increaseCountLuck();
	}

	/**
	 * 
	 * grantThrowByLuckyArcher void method
	 * 
	 * @param round
	 */

	public void grantThrowByLuckyArcher(int round) {
		Archer archer = getLuckyArcher();
		score += archer.individualLaunch();
		archer.increaseWonRaffles(round);
	}

	/**
	 * 
	 * giveExtraThrowByThreeThrows void method
	 */

	public void giveExtraThrowByThreeThrows() {
		for (Archer archer : archers) {
			if (archer.getWonRaffles() == 3)
				score += archer.individualLaunch();
		}
	}

	/**
	 * 
	 * obtainMostScoredArcher Archer method
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
	 * obtainMostWonRounds Archer method
	 * 
	 * @return Archer
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
	 * obtainRoundScore int method
	 * 
	 * @return int
	 */

	public int obtainRoundScore() {
		int roundScore = 0;
		for (Archer archer : archers)
			roundScore += archer.getRoundPoints();
		return roundScore;
	}

	/**
	 * 
	 * obtainTotalScore int method
	 * 
	 * @return int
	 */

	public int obtainTotalScore() {
		int totalScore = 0;
		for (Archer archer : archers)
			totalScore += archer.getPoints();
		return totalScore;
	}

	/**
	 * 
	 * obtainMostLuckArcher Archer method
	 * 
	 * @return Archer
	 */

	public Archer obtainMostLuckArcher() {
		Archer target = archers.get(0);
		for (int i = 1; i < archers.size(); i++)
			target = archers.get(i).getCountLuck() > target.getCountLuck() ? archers.get(i) : target;
		return target;
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
}