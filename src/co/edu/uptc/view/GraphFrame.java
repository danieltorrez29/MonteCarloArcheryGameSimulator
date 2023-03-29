package co.edu.uptc.view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import co.edu.uptc.model.Archer;

/**
 * GraphFrame class that generates the archers graph vs game.
 * 
 */

public class GraphFrame extends JFrame {

	/**
	 * Constant.
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * JFrame content pane.
	 */

	private JPanel contentPane;

	/**
	 * 
	 * Constructor method.
	 * 
	 * @param archers.
	 * @param gameNumber.
	 */

	public GraphFrame(ArrayList<Archer> archers, int gameNumber) {
		super("Archers vs Game");
		setSize(800, 500);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLookAndFeel();
		initComponents(archers, gameNumber);
		setVisible(true);
	}

	/**
	 * 
	 * setLookAndFeel void method.
	 */

	private void setLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * initComponents void method.
	 * 
	 * @param archers.
	 * @param gameNumber.
	 */

	private void initComponents(ArrayList<Archer> archers, int gameNumber) {
		contentPane = new JPanel();

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		for (Archer archer : archers)
			dataset.setValue(archer.getPoints(), "Archer", String.valueOf(archer.getCode()));

		JFreeChart barChart = ChartFactory.createBarChart("Game " + gameNumber, "Archer", "Points", dataset,
				PlotOrientation.VERTICAL, true, false, false);

		ChartPanel graphPanel = new ChartPanel(barChart);
		graphPanel.setMouseWheelEnabled(true);

		contentPane.add(graphPanel);

		setContentPane(contentPane);
	}
}