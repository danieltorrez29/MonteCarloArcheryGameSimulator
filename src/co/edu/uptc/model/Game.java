package co.edu.uptc.model;

/**
 * Game class
 * 
 * @author Daniel Torres
 */

public class Game {

	private Team[] teams;
	private int rounds;
	private Gender winnerGender;

	/**
	 * Constructor method
	 */

	public Game(Team team1, Team team2) {
		teams = new Team[2];
		teams[0] = team1;
		teams[1] = team2;
		rounds = 1;
	}

	/**
	 * 
	 * raffleShoot void method
	 */

	public void raffleShoot() {
		for (Team team : teams)
			team.grantThrowByLuckyArcher(rounds);
	}

	/**
	 * 
	 * obtainRoundWinner Archer method
	 * 
	 * @return Archer
	 */

	public Archer obtainRoundWinner() {
		return tieBreakerRound(teams[0].obtainMostScoredArcher(), teams[1].obtainMostScoredArcher());
	}

	/**
	 * 
	 * tieBreakerRound Archer method
	 * 
	 * @param a
	 * @param b
	 * @return Archer
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
	 * obtainIndividualWinner Archer method
	 * 
	 * @return Archer
	 */

	public Archer obtainIndividualWinner() {
		Archer a = teams[0].obtainMostWonRounds();
		Archer b = teams[1].obtainMostWonRounds();
		return a.getWonRounds() > b.getWonRounds() ? a : b;
	}

	/**
	 * 
	 * determineTeamRoundWinner Team method
	 * 
	 * @return Team
	 */

	public Team determineTeamRoundWinner() {
		int scoreTeam1 = teams[0].obtainRoundScore();
		int scoreTeam2 = teams[1].obtainRoundScore();
		return (scoreTeam1 == scoreTeam2) ? null : (scoreTeam1 > scoreTeam2) ? teams[0] : teams[1];
	}

	/**
	 * 
	 * obtainTeamWinner Team method
	 * 
	 * @return Team
	 */

	public Team obtainTeamWinner() {
		int scoreTeam1 = teams[0].obtainTotalScore();
		int scoreTeam2 = teams[1].obtainTotalScore();
		return (scoreTeam1 == scoreTeam2) ? null : (scoreTeam1 > scoreTeam2) ? teams[0] : teams[1];
	}

	/**
	 * 
	 * obtainWinByGender void method
	 */

	public void obtainWinByGender() {
		winnerGender = obtainIndividualWinner().getGender();
	}

	/**
	 * 
	 * obtainMostLuckArcher Archer method
	 * 
	 * @return Archer
	 */

	public Archer obtainMostLuckArcher() {
		Archer countLuckArcherTeam1 = teams[0].obtainMostLuckArcher();
		Archer countLuckArcherTeam2 = teams[1].obtainMostLuckArcher();
		return (countLuckArcherTeam1.getCountLuck() == countLuckArcherTeam2.getCountLuck()) ? null
				: (countLuckArcherTeam1.getCountLuck() > countLuckArcherTeam2.getCountLuck()) ? countLuckArcherTeam1
						: countLuckArcherTeam2;
	}
}