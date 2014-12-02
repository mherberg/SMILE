package view.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExcelErrorFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = -2201482042454831539L;
	private final JPanel mainPanel = new JPanel();
	private final JButton jButton1 = new JButton("Okay");

	private final JLabel jLabel1 = new JLabel(
			"There was a problem saving your data.");
	private final JLabel jLabel2 = new JLabel(
			"-Try closing any open Excel files");
	private final JLabel jLabel3 = new JLabel(
			" you may have open and try again");

	public ExcelErrorFrame() {
		super();

		jButton1.addActionListener(this);
		setLayout();
	}

	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}

	private void setLayout() {

		this.setVisible(true);
		this.setSize(230, 180);
		this.setLocation(400, 400);
		this.add(mainPanel);

		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(
				mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout
				.setHorizontalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								mainPanelLayout.createSequentialGroup().addGap(
										83, 83, 83).addComponent(jButton1)
										.addContainerGap(90, Short.MAX_VALUE))
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								mainPanelLayout
										.createSequentialGroup()
										.addContainerGap(24, Short.MAX_VALUE)
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																mainPanelLayout
																		.createSequentialGroup()
																		.addGap(
																				10,
																				10,
																				10)
																		.addGroup(
																				mainPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel2)
																						.addComponent(
																								jLabel3)))
														.addComponent(jLabel1))
										.addGap(18, 18, 18)));
		mainPanelLayout
				.setVerticalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								mainPanelLayout
										.createSequentialGroup()
										.addGap(27, 27, 27)
										.addComponent(jLabel1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jLabel2).addGap(4, 4, 4)
										.addComponent(jLabel3).addGap(18, 18,
												18).addComponent(jButton1)
										.addContainerGap(19, Short.MAX_VALUE)));
	}

}
