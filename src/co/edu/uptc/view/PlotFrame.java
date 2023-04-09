package co.edu.uptc.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import co.edu.uptc.model.business.Archer;

/**
 * PlotFrame class that generates the archers score vs 250 games plot.
 * 
 */

public class PlotFrame extends JFrame {

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
	 */

	public PlotFrame(ArrayList<Archer> archers) {
		super("Archers vs Game");
		setSize(1800, 1000);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLookAndFeel();
		initComponents(archers);
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
	 */

	private void initComponents(ArrayList<Archer> archers) {

		XYDataset dataset = createDataset(archers);

		JFreeChart chart = ChartFactory.createXYLineChart("Archer Total Points vs 250 Games", "Game", "Points",
				dataset);

		customizeChart(chart);

		contentPane = new ChartPanel(chart);

		setContentPane(contentPane);
	}

	/**
	 * 
	 * createDataset XYDataset method.
	 * 
	 * @param archers.
	 * @return XYDataset.
	 */

	private XYDataset createDataset(ArrayList<Archer> archers) {

		XYSeriesCollection dataset = new XYSeriesCollection();

		XYSeries archer1 = new XYSeries("Archer 1");
		XYSeries archer2 = new XYSeries("Archer 2");
		XYSeries archer3 = new XYSeries("Archer 3");
		XYSeries archer4 = new XYSeries("Archer 4");
		XYSeries archer5 = new XYSeries("Archer 5");
		XYSeries archer6 = new XYSeries("Archer 6");
		XYSeries archer7 = new XYSeries("Archer 7");
		XYSeries archer8 = new XYSeries("Archer 8");
		XYSeries archer9 = new XYSeries("Archer 9");
		XYSeries archer10 = new XYSeries("Archer 10");

		Archer auxArcher = null;

		for (int i = 0; i < 250; i++) {

			auxArcher = archers.get(i);

			switch (auxArcher.getCode()) {
			case 1:
				archer1.add(i + 1, auxArcher.getPoints());
				break;

			case 2:
				archer2.add(i + 1, auxArcher.getPoints());
				break;

			case 3:
				archer3.add(i + 1, auxArcher.getPoints());
				break;

			case 4:
				archer4.add(i + 1, auxArcher.getPoints());
				break;

			case 5:
				archer5.add(i + 1, auxArcher.getPoints());
				break;

			case 6:
				archer6.add(i + 1, auxArcher.getPoints());
				break;

			case 7:
				archer7.add(i + 1, auxArcher.getPoints());
				break;

			case 8:
				archer8.add(i + 1, auxArcher.getPoints());
				break;

			case 9:
				archer9.add(i + 1, auxArcher.getPoints());
				break;

			case 10:
				archer10.add(i + 1, auxArcher.getPoints());
				break;

			default:
				break;
			}
		}
		dataset.addSeries(archer1);
		dataset.addSeries(archer2);
		dataset.addSeries(archer3);
		dataset.addSeries(archer4);
		dataset.addSeries(archer5);
		dataset.addSeries(archer6);
		dataset.addSeries(archer7);
		dataset.addSeries(archer8);
		dataset.addSeries(archer9);
		dataset.addSeries(archer10);

		return dataset;
	}

	/**
	 * 
	 * customizeChart void method.
	 * 
	 * @param chart.
	 */

	private void customizeChart(JFreeChart chart) {
		XYPlot plot = chart.getXYPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		// Set paint color for each series
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesPaint(1, Color.BLUE);
		renderer.setSeriesPaint(2, Color.CYAN);
		renderer.setSeriesPaint(3, Color.GREEN);
		renderer.setSeriesPaint(4, Color.LIGHT_GRAY);
		renderer.setSeriesPaint(5, Color.MAGENTA);
		renderer.setSeriesPaint(6, Color.ORANGE);
		renderer.setSeriesPaint(7, Color.PINK);
		renderer.setSeriesPaint(8, Color.WHITE);
		renderer.setSeriesPaint(9, Color.YELLOW);

		// Set thickness for series (using strokes)
		renderer.setSeriesStroke(0, new BasicStroke(1.0f));
		renderer.setSeriesStroke(1, new BasicStroke(1.0f));
		renderer.setSeriesStroke(2, new BasicStroke(1.0f));
		renderer.setSeriesStroke(3, new BasicStroke(1.0f));
		renderer.setSeriesStroke(4, new BasicStroke(1.0f));
		renderer.setSeriesStroke(5, new BasicStroke(1.0f));
		renderer.setSeriesStroke(6, new BasicStroke(1.0f));
		renderer.setSeriesStroke(7, new BasicStroke(1.0f));
		renderer.setSeriesStroke(8, new BasicStroke(1.0f));
		renderer.setSeriesStroke(9, new BasicStroke(1.0f));

		// Hides shapes filled
		renderer.setBaseShapesFilled(false);
		renderer.setDrawOutlines(false);

		// Sets renderer for lines
		plot.setRenderer(renderer);

		// Sets plot background
		plot.setBackgroundPaint(Color.DARK_GRAY);

		// Sets paint color for the grid lines
		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);
	}
}