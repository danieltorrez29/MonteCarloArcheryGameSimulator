package co.edu.uptc.model;

import java.util.Random;

/**
 * Archer class
 * 
 * @author Daniel Torres
 */

public class Archer {

	private int code;
	private Gender gender;
	private int initialResistance;
	private int resistance;
	private int experience;
	private double luck;
	private int points;
	private int roundPoints;
	private int wonRounds;
	private int wonRaffles;
	private int numberRound = -1;
	private int countLuck;

	/**
	 * 
	 * Constructor method
	 * 
	 * @param code
	 */

	public Archer(int code) {
		this.code = code;
		gender = generateGender();
		initialResistance = generateResistance();
		resistance = initialResistance;
		experience = 10;
		luck = generateLuck();
		points = 0;
		roundPoints = 0;
		wonRounds = 0;
		wonRaffles = 0;
		countLuck = 0;
	}

	public int getCode() {
		return code;
	}

	public Gender getGender() {
		return gender;
	}

	public int getResistance() {
		return resistance;
	}

	public int getExperience() {
		return experience;
	}

	public double getLuck() {
		return luck;
	}

	public int getPoints() {
		return points;
	}

	public int getWonRounds() {
		return wonRounds;
	}

	public int getWonRaffles() {
		return wonRaffles;
	}

	public int getRoundPoints() {
		return roundPoints;
	}

	public int getCountLuck() {
		return countLuck;
	}

	/**
	 * 
	 * launch void method
	 */

	public void launch() {
		int launch = 0;
		while (this.resistance > 0) {
			launch = individualLaunch();
			points += launch;
			roundPoints += launch;
			resistance -= 5;
		}
		regainResistanceRound();
		regainLuck();
	}

	/**
	 * 
	 * individualLaunch int method
	 * 
	 * @return int
	 */

	public int individualLaunch() {
		return (gender.getGender() == 'M') ? throwingMale() : throwingFemale();
	}

	/**
	 * 
	 * throwingMale int method
	 * 
	 * @param random
	 * @return
	 */

	private int throwingMale() {
		int score = 0;
		double random = Math.random();
		if (random > 0 && random <= 0.2)
			score = Shoot.CENTRAL.getScore();
		else if (random > 0.2 && random <= 0.53)
			score = Shoot.INTERMEDIATE.getScore();
		else if (random > 0.53 && random <= 0.93)
			score = Shoot.INTERMEDIATE.getScore();
		else
			score = Shoot.ERROR.getScore();
		return score;
	}

	/**
	 * 
	 * throwingFemale int method
	 * 
	 * @param random
	 * @return
	 */

	private int throwingFemale() {
		double random = Math.random();
		int score = 0;
		if (random > 0 && random <= 0.3)
			score = Shoot.CENTRAL.getScore();
		else if (random > 0.3 && random <= 0.68)
			score = Shoot.INTERMEDIATE.getScore();
		else if (random > 0.68 && random <= 0.95)
			score = Shoot.INTERMEDIATE.getScore();
		else
			score = Shoot.ERROR.getScore();
		return score;
	}

	/**
	 * 
	 * increaseWonRounds void method
	 */

	public void increaseWonRounds() {
		wonRounds++;
	}

	/**
	 * 
	 * increaseWonRaffles void method
	 */

	public void increaseWonRaffles(int round) {
		if (numberRound == -1) {
			numberRound = round;
			wonRaffles++;
		} else if (numberRound + 1 == round) {
			numberRound = round;
			wonRaffles++;
		} else {
			wonRaffles = 1;
			numberRound = round;
		}
	}

	/**
	 * 
	 * generateGender Gender method that gets a random Gender based on Monte Carlo
	 * method.
	 * 
	 * @return Gender
	 */

	private Gender generateGender() {
		return Math.random() >= 0.5 ? Gender.MALE : Gender.FEMALE;
	}

	/**
	 * 
	 * generateresistence method that gets a random resistence based on Normal
	 * method.
	 * 
	 * @return int
	 */

	private int generateResistance() {
		return (int) (Math.random() * (45 - 25 + 1)) + 25;
	}

	/**
	 * 
	 * generateLuck method that gets a random luck based on Uniform method.
	 * 
	 * @return int
	 */

	private double generateLuck() {
		return new Random().nextDouble() * 2 + 1;
	}

	/**
	 * 
	 * regainLuck void method
	 */

	private void regainLuck() {
		luck = generateLuck();
	}

	/**
	 * 
	 * regainResistanceRound void method that decrease archer resistance regards a
	 * random fatigue per round.
	 */

	private void regainResistanceRound() {
		resistance = initialResistance - generateFatigue();
		initialResistance = resistance;
	}

	/**
	 * 
	 * regainResistance void method that regain resistance
	 */

	public void regainResistance() {
		resistance = initialResistance;
	}

	/**
	 * 
	 * generateFatigue void method that generates between one and two for fatigue
	 */

	public int generateFatigue() {
		return (int) (Math.random() * 2) + 1;
	}

	/**
	 * 
	 * gainExperience void method to increase in 3 units the experience of the
	 * Archer
	 */

	public void gainExperience() {
		experience += 3;
	}

	/**
	 * 
	 * decreaseResistance void method to decrease the resistance through the
	 * experience
	 */

	public void decreaseResistanceByExperience() {
		this.resistance--;
	}

	/**
	 * 
	 * regainRoundPoints void method
	 */

	public void regainRoundPoints() {
		roundPoints = 0;
	}

	/**
	 * 
	 * increaseCountLuck void method
	 */

	public void increaseCountLuck() {
		countLuck++;
	}

	/**
	 * 
	 * regainCountLuck void method
	 */

	public void regainCountLuck() {
		countLuck = 0;
	}

	/**
	 * toString overwrite method
	 */

	@Override
	public String toString() {
		return "Archer [code=" + code + ", gender=" + gender + ", resistance=" + resistance + ", experience="
				+ experience + ", luck=" + luck + ", points=" + points + ", roundPoints=" + roundPoints + ", wonRounds="
				+ wonRounds + ", wonRaffles=" + wonRaffles + "]";
	}
}