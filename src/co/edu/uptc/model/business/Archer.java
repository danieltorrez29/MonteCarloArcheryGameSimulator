package co.edu.uptc.model.business;

import co.edu.uptc.model.utilities.MiddleSquare;

/**
 * Archer class representing the attributes and actions of an archer.
 * 
 */

public class Archer {

	/**
	 * Archer's code.
	 */

	private int code;

	/**
	 * Archer's gender.
	 */

	private Gender gender;

	/**
	 * Archer's initial resistance.
	 */

	private int initialResistance;

	/**
	 * Archer's resistance per round.
	 */

	private int resistance;

	/**
	 * Archer's experience per round.
	 */

	private int experience;

	/**
	 * Archer's luck per round.
	 */

	private double luck;

	/**
	 * Archer's points per game.
	 */

	private int points;

	/**
	 * Archer's points per round.
	 */

	private int roundPoints;

	/**
	 * Archer's won rounds per game.
	 */

	private int wonRounds;

	/**
	 * Archer's won raffles per game.
	 */

	private int wonRaffles;

	/**
	 * Archer's consecutive won raffle number round.
	 */

	private int consecutiveWonRaflleNumberRound;

	/**
	 * Archer's counter luck per game.
	 */

	private int countLuck;

	/**
	 * Random Number object.
	 */

	private MiddleSquare generator;

	/**
	 * 
	 * Constructor method.
	 * 
	 * @param code.
	 */

	public Archer(int code) {
		generator = new MiddleSquare(0, 1);
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
		consecutiveWonRaflleNumberRound = -1;
		countLuck = 0;
	}

	/**
	 * 
	 * getCode int method.
	 * 
	 * @return int.
	 */

	public int getCode() {
		return code;
	}

	/**
	 * 
	 * getGender Gender method.
	 * 
	 * @return Gender.
	 */

	public Gender getGender() {
		return gender;
	}

	/**
	 * 
	 * getResistance int method.
	 * 
	 * @return int.
	 */

	public int getResistance() {
		return resistance;
	}

	/**
	 * 
	 * getExperience int method.
	 * 
	 * @return int.
	 */

	public int getExperience() {
		return experience;
	}

	/**
	 * 
	 * getLuck double method.
	 * 
	 * @return double.
	 */

	public double getLuck() {
		return luck;
	}

	/**
	 * 
	 * getPoints int method.
	 * 
	 * @return int.
	 */

	public int getPoints() {
		return points;
	}

	/**
	 * 
	 * getWonRounds int method.
	 * 
	 * @return int.
	 */

	public int getWonRounds() {
		return wonRounds;
	}

	/**
	 * 
	 * getWonRaffles int method.
	 * 
	 * @return int.
	 */

	public int getWonRaffles() {
		return wonRaffles;
	}

	/**
	 * 
	 * getRoundPoints int method.
	 * 
	 * @return int.
	 */

	public int getRoundPoints() {
		return roundPoints;
	}

	/**
	 * 
	 * getCountLuck int method.
	 * 
	 * @return int.
	 */

	public int getCountLuck() {
		return countLuck;
	}

	/**
	 * 
	 * launch void method that which allows you to throw the player and adds the
	 * respective score to your throw and subtracts 5 resistance points.
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
	 * individualLaunch int method that determines the release taking into account
	 * the values associated with each gender.
	 * 
	 * @return int.
	 */

	public int individualLaunch() {
		return (gender.getGender() == 'M') ? throwingMale() : throwingFemale();
	}

	/**
	 * 
	 * throwingMale int method that determines man launch score using the Monte
	 * Carlo method regarding the specified values.
	 * 
	 * @return int.
	 */

	private int throwingMale() {
		int score = 0;
		double random = generator.generateNi();
		if (random > 0 && random <= 0.2)
			score = Shoot.CENTRAL.getScore();
		else if (random > 0.2 && random <= 0.53)
			score = Shoot.INTERMEDIATE.getScore();
		else if (random > 0.53 && random <= 0.93)
			score = Shoot.OUTSIDE.getScore();
		else if (random > 0.93 && random <= 1)
			score = Shoot.ERROR.getScore();
		return score;
	}

	/**
	 * 
	 * throwingFemale int method that determines woman launch score using the Monte
	 * Carlo method regarding the specified values.
	 *
	 * @return int.
	 */

	private int throwingFemale() {
		double random = generator.generateNi();
		int score = 0;
		if (random > 0 && random <= 0.3)
			score = Shoot.CENTRAL.getScore();
		else if (random > 0.3 && random <= 0.68)
			score = Shoot.INTERMEDIATE.getScore();
		else if (random > 0.68 && random <= 0.95)
			score = Shoot.OUTSIDE.getScore();
		else if (random > 0.95 && random <= 1)
			score = Shoot.ERROR.getScore();
		return score;
	}

	/**
	 * 
	 * increaseWonRounds void method that increases rounds won by one unit.
	 */

	public void increaseWonRounds() {
		wonRounds++;
	}

	/**
	 * 
	 * increaseWonRaffles void method that increases consecutive raffles won by one
	 * unit in the case of fulfilling the condition, if you do not set the value 1.
	 * 
	 * @param round.
	 */

	public void increaseWonRaffles(int round) {
		if (consecutiveWonRaflleNumberRound == -1) {
			consecutiveWonRaflleNumberRound = round;
			wonRaffles++;
		} else if (consecutiveWonRaflleNumberRound + 1 == round) {
			consecutiveWonRaflleNumberRound = round;
			wonRaffles++;
		} else {
			wonRaffles = 1;
			consecutiveWonRaflleNumberRound = round;
		}
	}

	/**
	 * 
	 * generateGender Gender method that gets a random Gender based on Normal
	 * Distribution.
	 * 
	 * @return Gender.
	 */

	private Gender generateGender() {
		return generator.generateNi() >= 0.5 ? Gender.MALE : Gender.FEMALE;
	}

	/**
	 * 
	 * generateresistence method that gets a random resistence based on Normal
	 * Distribution.
	 * 
	 * @return int.
	 */

	private int generateResistance() {
		return (int) (generator.generateNi() * (45 - 25 + 1)) + 25;
	}

	/**
	 * 
	 * generateLuck method that gets a random luck based on Uniform Distribution.
	 * 
	 * @return double.
	 */

	private double generateLuck() {
		return generator.generateNi() * 2 + 1;
	}

	/**
	 * 
	 * regainLuck void method that regenerates archer's luck per round.
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
	 * regainResistance void method that regenerates archer's resistance.
	 */

	public void regainResistance() {
		resistance = initialResistance;
	}

	/**
	 * 
	 * generateFatigue void method that generates between one and two for fatigue.
	 * 
	 * @return int.
	 */

	public int generateFatigue() {
		return (int) (generator.generateNi() * 2) + 1;
	}

	/**
	 * 
	 * gainExperience void method to increase archer's experience in 3 units.
	 */

	public void gainExperience() {
		experience += 3;
	}

	/**
	 * 
	 * decreaseResistance void method to decrease the resistance in 1 unit.
	 */

	public void decreaseResistanceByExperience() {
		this.resistance--;
	}

	/**
	 * 
	 * regainRoundPoints void method that sets round points to zero.
	 */

	public void regainRoundPoints() {
		roundPoints = 0;
	}

	/**
	 * 
	 * increaseCountLuck void method that increases luck in 1 unit.
	 */

	public void increaseCountLuck() {
		countLuck++;
	}

	/**
	 * 
	 * regainCountLuck void method that sets count luck to zero.
	 */

	public void regainCountLuck() {
		countLuck = 0;
	}
}