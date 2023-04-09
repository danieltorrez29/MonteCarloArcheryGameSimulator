package co.edu.uptc.present;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.uptc.model.business.Simulation;
import co.edu.uptc.view.PlotFrame;
import co.edu.uptc.view.StatsFrame;

/**
 * Presenter class.
 * 
 */

public class Presenter implements ActionListener {

	/**
	 * Simulation object.
	 */

	private Simulation simulation;

	/**
	 * 
	 * Constructor method.
	 * 
	 * @param games.
	 */

	public Presenter(int games) {
		simulation = new Simulation(games);
		new StatsFrame(this, simulation.obtainLuckyArchers(), simulation.obtainExperiencedArchers(),
				simulation.obtainWinningTeam(), simulation.obtainGendersByGame(), simulation.obtainGenderTotalWin());
	}

	/**
	 * 
	 * actionPerformed overwrite method
	 */

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Plotting":
			new PlotFrame(simulation.getArchersPerGame());
			break;

		default:
			break;
		}
	}
}