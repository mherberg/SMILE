package view.panel;

import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.FocusableButtonPanel;


public class SmilePanel extends FocusableButtonPanel {

	private static final long serialVersionUID = 1L;
	private final JLabel smileMouthCornerStep = new JLabel("Step 2:");
	private final JLabel smileMouthCornerInstruct = new JLabel(
			"-Select a corner of the mouth");

	private final JLabel xLabel = new JLabel("b:");
	private final JLabel yLabel = new JLabel("a:");
	private final JLabel zLabel = new JLabel("c:");
	private final JLabel thetaLabel = new JLabel("A:");

	private final JTextField xDisplay = new JTextField();
	private final JTextField yDisplay = new JTextField();
	private final JTextField zDisplay = new JTextField();
	private final JTextField thetaDisplay = new JTextField();

	private final String distanceUnit = " mm";
	private final String angleUnit = " deg";
	private final String distanceStartingField = "0" + distanceUnit;
	private final String angleStartingField = "0" + angleUnit;

	public static final Color dotColor = Color.BLUE;
	public static final Color aColor = Color.BLUE;
	public static final Color bColor = Color.RED;
	public static final Color cColor = Color.GREEN;
	public static final Color thetaColor = Color.DARK_GRAY;

	private final JButton reselect = new JButton(FocusableButtonPanel.reselect);
	private final JButton save = new JButton(FocusableButtonPanel.save);

	public SmilePanel() {
		super();

		this.text.add(smileMouthCornerStep);
		this.text.add(smileMouthCornerInstruct);
		this.text.add(xLabel);
		this.text.add(yLabel);
		this.text.add(zLabel);
		this.text.add(thetaLabel);

		this.text.add(xDisplay);
		this.text.add(yDisplay);
		this.text.add(zDisplay);
		this.text.add(thetaDisplay);

		this.buttons.add(reselect);
		this.buttons.add(save);

		uninitalizeFields();
		setLayout();
		unfocus();

	}

	public void uninitalizeFields() {
		this.xDisplay.setText(this.distanceStartingField);
		this.yDisplay.setText(this.distanceStartingField);
		this.zDisplay.setText(this.distanceStartingField);
		this.thetaDisplay.setText(this.angleStartingField);
	}

	public void displayValues(double x, double y, double z, double theta) {

		DecimalFormat format = new DecimalFormat("#########.##");

		this.xDisplay.setText(format.format(x) + this.distanceUnit);
		this.yDisplay.setText(format.format(y) + this.distanceUnit);
		this.zDisplay.setText(format.format(z) + this.distanceUnit);
		this.thetaDisplay.setText(format.format(theta) + this.angleUnit);
	}

	public void focus() {

		super.focus();

		this.xLabel.setForeground(bColor);
		this.yLabel.setForeground(aColor);
		this.zLabel.setForeground(cColor);
		this.thetaLabel.setForeground(thetaColor);

		uninitalizeFields();
	}

	private void setLayout() {

		javax.swing.GroupLayout smileMouthCornerLayout = new javax.swing.GroupLayout(
				this);
		this.setLayout(smileMouthCornerLayout);
		smileMouthCornerLayout
				.setHorizontalGroup(smileMouthCornerLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								smileMouthCornerLayout
										.createSequentialGroup()
										.addGroup(
												smileMouthCornerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																smileMouthCornerLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				smileMouthCornerLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								smileMouthCornerStep)
																						.addComponent(
																								smileMouthCornerInstruct)))
														.addGroup(
																smileMouthCornerLayout
																		.createSequentialGroup()
																		.addGap(
																				20,
																				20,
																				20)
																		.addGroup(
																				smileMouthCornerLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								smileMouthCornerLayout
																										.createSequentialGroup()
																										.addGroup(
																												smileMouthCornerLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																yLabel)
																														.addComponent(
																																zLabel)
																														.addComponent(
																																thetaLabel))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												smileMouthCornerLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																yDisplay,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																73,
																																Short.MAX_VALUE)
																														.addComponent(
																																zDisplay,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																73,
																																Short.MAX_VALUE)
																														.addComponent(
																																thetaDisplay,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																73,
																																Short.MAX_VALUE)))
																						.addGroup(
																								smileMouthCornerLayout
																										.createSequentialGroup()
																										.addComponent(
																												xLabel)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												xDisplay,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												74,
																												Short.MAX_VALUE)))
																		.addGap(
																				18,
																				18,
																				18)
																		.addGroup(
																				smileMouthCornerLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								save,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.addComponent(
																								reselect,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE))
																		.addGap(
																				18,
																				18,
																				18)))
										.addContainerGap()));

		smileMouthCornerLayout
				.setVerticalGroup(smileMouthCornerLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								smileMouthCornerLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(smileMouthCornerStep)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(smileMouthCornerInstruct)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												smileMouthCornerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(xLabel)
														.addComponent(
																xDisplay,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												smileMouthCornerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(yLabel)
														.addComponent(
																yDisplay,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(reselect))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												smileMouthCornerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(zLabel)
														.addComponent(
																zDisplay,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(save))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												smileMouthCornerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																thetaLabel)
														.addComponent(
																thetaDisplay,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap(14, Short.MAX_VALUE)));
	}
}
