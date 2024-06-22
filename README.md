<h3 align="center">Monte Carlo Archery Game Simulator</h3>

---

<p align="center"> Archery game simulator based on Monte Carlo method.
    <br> 
</p>


## **About**

This simulator based on the Monte Carlo method recreates 20,000 archery games between two teams based on pre-established game conditions that affect both the score and endurance of the archer and the overall score of the team. To do so, X shots are fired until the archer's endurance is exhausted. These shots are determined by generating a pseudo-random number through the method of mean squares. This score will be determined by the probabilities associated with the sections of the target and the gender of the archer. Each game will have 10 rounds in which the archers of both teams will play. At the end of the simulation, statistics (values and graphs) are obtained according to cumulative calculated variables.

**Game Conditions**

Each player has the following skills:

- Endurance: 35 ± 10
- Experience: 10
- Luck: 1 - 3

The accuracy, score and error data for the pitches would be as follows:

| Targets      | Women | Men | Score |
| ------------ | ----- | --- | ----- |
| Central      | 30%   | 20% | 10    |
| Intermediate | 38%   | 33% | 9     |
| Outside      | 27%   | 40% | 8     |
| Error        | 5%    | 7%  | 0     |

The conditional of the simulation is as follows:

- Each throw uses 5 points of resistance.
- Each archer makes X throws until the end of his endurance. These throws make up a round. At the end of each round, the archer recovers the stamina points of his previous round minus one or two units (fatigue). At the end of each game the archer recovers his original stamina.
- In each round one throw per team is drawn, which will be awarded to the luckiest player in each team. This throw will be taken into account for the overall score of the group, but not to determine the winner of the individual round.
- If a player wins three extra throws in a row he is entitled to one extra throw, regardless of the value of his resistance. This throw will be taken into account for the overall group score, but not for determining the winner of the individual round.
- The archer of the two teams who scores the most points in their throws wins an individual round, and in case of a tie, the contestants will have extra throws until a winner is determined. The points of these throws will not be taken into account for the total score of the groups, and these throws will have no resistance value.
- When an archer wins a round, he/she gains 3 experience points.
- If an archer scores 9 experience points, he loses only one endurance point in his next two rounds.
- The winner of a group round is the team that obtains the most points in its throws. In case of a tie, no winner will be determined.
- The team with the most points after ten rounds wins the game.
- The archer with the most rounds won in a game is declared the individual winner.
- The luck factor is calculated at the beginning of each round.

**Statistics**

- Player with the most luck in each of the games.
- Player who has gained the most experience at the end of each of the games.
- Winning team including scores.
- Gender with more victories in each game and with more total victories.
- Graph of the points obtained by each player vs 250 games.

## **Getting Started**

For the proper functioning of the application it is recommended the next prerequisites.

### **Prerequisites**

- Java SE 17 or older.

## **Usage**

- Run the main method found inside the Runner class.
- You can set the number of games as a parameter inside the main method of the Runner class.
- Simulation takes about 17 seconds.

## **Built Using**

- [JDK 17](https://docs.oracle.com/en/java/javase/17/docs/api/index.html) - Java Development Kit.
- [JFreeChart 1.0.19](https://www.jfree.org/jfreechart/api/javadoc/index.html) - Chart Library.
- [Eclipse IDE 2022-09](https://eclipseide.org) - Integrated Development Environment.

## **Project Especification**

- Java Documentation - Open index.html inside doc folder.

## **Authors**

- [@danieltorrez29](https://github.com/danieltorrez29)
- [@JorgeEdilMz](https://github.com/JorgeEdilMz)

## **License**

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
