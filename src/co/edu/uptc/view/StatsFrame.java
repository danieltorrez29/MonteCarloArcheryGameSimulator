package co.edu.uptc.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JButton;

/**
 * StatsFrame class that shows simulation statistics.
 * 
 */

public class StatsFrame extends JFrame {

	/**
	 * Constant.
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * JFrame content pane.
	 */

	private JPanel contentPane;

	/**
	 * First stat label.
	 */

	private JLabel firstStatistic;

	/**
	 * Separator.
	 */

	private JSeparator firstSeparator;

	/**
	 * First stat text area.
	 */

	private JTextArea firstStatisticTextArea;

	/**
	 * First stat scroll pane.
	 */

	private JScrollPane firstStatisticScrollPane;

	/**
	 * Second stat scroll pane.
	 */

	private JScrollPane secondStatisticScrollPane;

	/**
	 * Fourth stat scroll pane.
	 */

	private JScrollPane fourthStatisticScrollPane;

	/**
	 * Second stat label.
	 */

	private JLabel secondtStatistic;

	/**
	 * Second stat text area.
	 */

	private JTextArea secondStatistictTextArea;

	/**
	 * Separator.
	 */

	private JSeparator secondSeparator;

	/**
	 * Separator.
	 */

	private JSeparator thirdSeparator;

	/**
	 * Separator.
	 */

	private JSeparator fourthSeparator;

	/**
	 * Third stat label.
	 */

	private JLabel thirdtStatistic;

	/**
	 * Fourth stat label.
	 */

	private JLabel fourthStatistic;

	/**
	 * Fourth stat text area.
	 */

	private JTextArea fourthStatisticTextArea;

	/**
	 * Third stat text area.
	 */

	private JTextArea thirdStatisticTextArea;

	/**
	 * Separator.
	 */

	private JSeparator fifthSeparator;

	/**
	 * Fifth stat label.
	 */

	private JLabel fifthStatistic;

	/**
	 * Fifth stat text area.
	 */

	private JTextArea fifthStatisticTextArea;

	/**
	 * Plotting button.
	 */

	private JButton plotButton;

	/**
	 * 
	 * Constructor method.
	 * 
	 * @param listener.
	 * @param firstStatisticString.
	 * @param secondStatisticString.
	 * @param thirdStatisticString.
	 * @param fourthStatisticString.
	 * @param fifthStatisticString.
	 */

	public StatsFrame(ActionListener listener, String firstStatisticString, String secondStatisticString,
			String thirdStatisticString, String fourthStatisticString, String fifthStatisticString) {
		super("Monte Carlo Archery Game Simulator");
		setSize(900, 450);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLookAndFeel();
		initComponents(listener, firstStatisticString, secondStatisticString, thirdStatisticString,
				fourthStatisticString, fifthStatisticString);
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
	 * @param listener.
	 * @param firstStatisticString.
	 * @param secondStatisticString.
	 * @param thirdStatisticString.
	 * @param fourthStatisticString.
	 * @param fifthStatisticString.
	 */

	private void initComponents(ActionListener listener, String firstStatisticString, String secondStatisticString,
			String thirdStatisticString, String fourthStatisticString, String fifthStatisticString) {

		contentPane = new JPanel();
		contentPane.setLayout(null);

		firstStatistic = new JLabel("Most Lucky Archers");
		firstStatistic.setHorizontalAlignment(SwingConstants.CENTER);
		firstStatistic.setFont(new Font("Ebrima", Font.BOLD, 12));
		firstStatistic.setBounds(10, 25, 411, 26);
		contentPane.add(firstStatistic);

		firstSeparator = new JSeparator();
		firstSeparator.setOrientation(SwingConstants.VERTICAL);
		firstSeparator.setBounds(441, 25, 2, 132);
		contentPane.add(firstSeparator);

		firstStatisticTextArea = new JTextArea(firstStatisticString);
		firstStatisticTextArea.setEditable(false);
		firstStatisticTextArea.setWrapStyleWord(true);
		firstStatisticTextArea.setLineWrap(true);
		firstStatisticTextArea.setBounds(20, 62, 411, 91);
		contentPane.add(firstStatisticTextArea);

		firstStatisticScrollPane = new JScrollPane(firstStatisticTextArea);
		firstStatisticScrollPane.setBounds(20, 62, 411, 97);
		contentPane.add(firstStatisticScrollPane);

		secondtStatistic = new JLabel("Most Experienced Archers");
		secondtStatistic.setHorizontalAlignment(SwingConstants.CENTER);
		secondtStatistic.setFont(new Font("Ebrima", Font.BOLD, 12));
		secondtStatistic.setBounds(453, 25, 421, 26);
		contentPane.add(secondtStatistic);

		secondStatistictTextArea = new JTextArea(secondStatisticString);
		secondStatistictTextArea.setEditable(false);
		secondStatistictTextArea.setWrapStyleWord(true);
		secondStatistictTextArea.setLineWrap(true);
		secondStatistictTextArea.setBounds(453, 63, 421, 94);
		contentPane.add(secondStatistictTextArea);

		secondStatisticScrollPane = new JScrollPane(secondStatistictTextArea);
		secondStatisticScrollPane.setBounds(453, 62, 421, 95);
		contentPane.add(secondStatisticScrollPane);

		secondSeparator = new JSeparator();
		secondSeparator.setBounds(19, 170, 402, 2);
		contentPane.add(secondSeparator);

		thirdSeparator = new JSeparator();
		thirdSeparator.setBounds(463, 172, 411, 2);
		contentPane.add(thirdSeparator);

		fourthSeparator = new JSeparator();
		fourthSeparator.setOrientation(SwingConstants.VERTICAL);
		fourthSeparator.setBounds(441, 185, 2, 132);
		contentPane.add(fourthSeparator);

		thirdtStatistic = new JLabel("Game Winning Team");
		thirdtStatistic.setHorizontalAlignment(SwingConstants.CENTER);
		thirdtStatistic.setFont(new Font("Ebrima", Font.BOLD, 12));
		thirdtStatistic.setBounds(20, 183, 411, 26);
		contentPane.add(thirdtStatistic);

		thirdStatisticTextArea = new JTextArea(thirdStatisticString);
		thirdStatisticTextArea.setEditable(false);
		thirdStatisticTextArea.setWrapStyleWord(true);
		thirdStatisticTextArea.setLineWrap(true);
		thirdStatisticTextArea.setBounds(20, 220, 411, 22);
		contentPane.add(thirdStatisticTextArea);

		fourthStatistic = new JLabel("Gender Winners");
		fourthStatistic.setHorizontalAlignment(SwingConstants.CENTER);
		fourthStatistic.setFont(new Font("Ebrima", Font.BOLD, 12));
		fourthStatistic.setBounds(453, 185, 411, 26);
		contentPane.add(fourthStatistic);

		fourthStatisticTextArea = new JTextArea(fourthStatisticString);
		fourthStatisticTextArea.setEditable(false);
		fourthStatisticTextArea.setWrapStyleWord(true);
		fourthStatisticTextArea.setLineWrap(true);
		fourthStatisticTextArea.setBounds(453, 222, 411, 87);
		contentPane.add(fourthStatisticTextArea);

		fourthStatisticScrollPane = new JScrollPane(fourthStatisticTextArea);
		fourthStatisticScrollPane.setBounds(453, 222, 421, 88);
		contentPane.add(fourthStatisticScrollPane);

		fifthSeparator = new JSeparator();
		fifthSeparator.setBounds(10, 328, 864, 2);
		contentPane.add(fifthSeparator);

		fifthStatistic = new JLabel("Game Winning Gender");
		fifthStatistic.setHorizontalAlignment(SwingConstants.CENTER);
		fifthStatistic.setFont(new Font("Ebrima", Font.BOLD, 12));
		fifthStatistic.setBounds(20, 253, 411, 26);
		contentPane.add(fifthStatistic);

		fifthStatisticTextArea = new JTextArea(fifthStatisticString);
		fifthStatisticTextArea.setEditable(false);
		fifthStatisticTextArea.setWrapStyleWord(true);
		fifthStatisticTextArea.setLineWrap(true);
		fifthStatisticTextArea.setBounds(20, 288, 411, 22);
		contentPane.add(fifthStatisticTextArea);

		plotButton = new JButton("Archers Score vs 250 Games - Plot");
		plotButton.setFont(new Font("Ebrima", Font.BOLD, 14));
		plotButton.setFocusPainted(false);
		plotButton.addActionListener(listener);
		plotButton.setActionCommand("Plotting");
		plotButton.setBounds(296, 356, 282, 34);
		contentPane.add(plotButton);

		getRootPane().setDefaultButton(plotButton);

		setContentPane(contentPane);
	}
}