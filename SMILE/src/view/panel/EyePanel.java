package view.panel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import view.FocusableButtonPanel;


public class EyePanel extends FocusableButtonPanel {

	private static final long serialVersionUID = 1L;
	private final JButton irisButton = new JButton(FocusableButtonPanel.reset);
	private final JLabel irisLabel;
	private final JLabel irisInstructions;

	public static final Color dotColor = Color.BLUE;

	public EyePanel(boolean right) {

		super();
		String side;	
		
		if (right)
			side = "Right";
		else
			side = "Left";

		this.irisLabel = new JLabel("Measure " + side + " Iris:");
		this.irisInstructions = new JLabel("-Click the " + side.toLowerCase()
				+ " eye");

		this.text.add(irisLabel);
		this.text.add(irisInstructions);
		this.buttons.add(irisButton);

		this.irisLabel.setFont(new Font(this.irisLabel.getFont().getFontName(),
				Font.BOLD, this.irisLabel.getFont().getSize()));

		setLayout();
		this.unfocus();
	}

	/**
	 * This is code generated by the NetBeans GUI creator. It has been cut and
	 * pasted here to provide more flexibility.
	 */
	private void setLayout() {

		this.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		javax.swing.GroupLayout eyePanelLayout = new javax.swing.GroupLayout(
				this);
		this.setLayout(eyePanelLayout);
		eyePanelLayout
				.setHorizontalGroup(eyePanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								eyePanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												eyePanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(irisLabel)
														.addGroup(
																eyePanelLayout
																		.createSequentialGroup()
																		.addGap(
																				10,
																				10,
																				10)
																		.addComponent(
																				irisInstructions)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												53, Short.MAX_VALUE)
										.addComponent(
												irisButton,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												74,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		eyePanelLayout
				.setVerticalGroup(eyePanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								eyePanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												eyePanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																irisButton)
														.addGroup(
																eyePanelLayout
																		.createSequentialGroup()
																		.addComponent(
																				irisLabel)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				irisInstructions)))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
	}

}
