package co.edu.uptc.test;

import java.util.ArrayList;
import java.util.Arrays;

import co.edu.uptc.model.Archer;
import co.edu.uptc.model.Game;
import co.edu.uptc.model.Team;

/**
 * Tester class
 * 
 * @author Daniel Torres
 */

public class Tester {

	/**
	 * main void method
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		Archer archer1 = new Archer(0);
		archer1.launch();
		archer1.launch();
		archer1.increaseWonRaffles(1);
		archer1.launch();
		archer1.increaseWonRaffles(2);
		archer1.launch();
		archer1.increaseWonRaffles(4);
		System.out.println(archer1);
		System.out.println();

		Archer archer2 = new Archer(1);
		archer2.launch();
		archer2.launch();
		archer2.launch();
		archer2.launch();
		System.out.println(archer2);
		System.out.println();

		Archer archer3 = new Archer(2);
		archer3.launch();
		archer3.launch();
		archer3.launch();
		archer3.launch();
		System.out.println(archer3);
		System.out.println();

		Team team1 = new Team(new ArrayList<Archer>(Arrays.asList(archer1, archer2, archer3)), 0);

		Archer archer4 = new Archer(3);
		archer4.launch();
		archer4.launch();
		archer4.launch();
		archer4.launch();
		System.out.println(archer4);
		System.out.println();
		Archer archer5 = new Archer(4);
		archer5.launch();
		archer5.launch();
		archer5.launch();
		archer5.launch();
		System.out.println(archer5);
		System.out.println();
		Archer archer6 = new Archer(5);
		archer6.launch();
		archer6.launch();
		archer6.launch();
		archer6.launch();
		System.out.println(archer6);
		System.out.println();

		Team team2 = new Team(new ArrayList<Archer>(Arrays.asList(archer4, archer5, archer6)), 1);

		System.out.println();
		System.out.println();
		System.out.println(team1.obtainMostScoredArcher());
		System.out.println(team2.obtainMostScoredArcher());
		System.out.println();
		System.out.println();

		Game game = new Game(team1, team2);

		System.out.println(game.obtainRoundWinner());

	}

}
