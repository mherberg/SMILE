package view.panel;

import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.FocusableButtonPanel;


public class NasalPanel extends FocusableButtonPanel {

	private static final long serialVersionUID = 1L;
	private final JLabel step1 = new JLabel("Step 1:");
	private final JLabel instruct11 = new JLabel(
			"- Click the midline at the bottom of:");
	private final JLabel instruct12 = new JLabel("the nose.");

	private final JLabel step2 = new JLabel("Step 2:");
	private final JLabel instruct21 = new JLabel(
			"- Click on the bottom edge of the");
	private final JLabel instruct22 = new JLabel("healthy nostril");

	private final JLabel step3 = new JLabel("Step 3:");
	private final JLabel instruct31 = new JLabel(
			"- Click on the bottom edge of the");
	private final JLabel instruct32 = new JLabel("affected nostril");

	private final JLabel deviation2 = new JLabel("Difference:");
	private final JLabel deviation3 = new JLabel("Difference:");

	private final JButton save = new JButton(FocusableButtonPanel.save);
	private final JButton reset = new JButton(FocusableButtonPanel.reset);

	private static final String defaultValue = "0 mm";

	private final JTextField display2 = new JTextField(defaultValue);
	private final JTextField display3 = new JTextField(defaultValue);

	public static final Color dotColor = Color.YELLOW;

	public NasalPanel() {
		super();

		this.text.add(step1);
		this.text.add(instruct11);
		this.text.add(instruct12);

		this.text.add(step2);
		this.text.add(instruct21);
		this.text.add(instruct22);

		this.text.add(step3);
		this.text.add(instruct31);
		this.text.add(instruct32);

		this.text.add(deviation2);
		this.text.add(deviation3);

		this.text.add(display2);
		this.text.add(display3);

		this.buttons.add(save);
		this.buttons.add(reset);

		this.unfocus();
		setLayout();
	}

	public void focus() {
		super.unfocus();
		focusStep1();
	}

	public void focusStep1() {
		this.step1.setForeground(Color.BLACK);
		this.instruct11.setForeground(Color.BLACK);
		this.instruct12.setForeground(Color.BLACK);
	}

	public void focusStep2() {
		this.step2.setForeground(Color.BLACK);
		this.instruct21.setForeground(Color.BLACK);
		this.instruct22.setForeground(Color.BLACK);

		this.deviation2.setForeground(Color.BLACK);
		this.display2.setForeground(Color.BLACK);
	}

	public void focusStep3() {
		this.step3.setForeground(Color.BLACK);
		this.instruct31.setForeground(Color.BLACK);
		this.instruct32.setForeground(Color.BLACK);

		this.deviation3.setForeground(Color.BLACK);
		this.display3.setForeground(Color.BLACK);
		
	}

	public void updateHealthyDeviationDisplay(double deviation) {
		DecimalFormat format = new DecimalFormat("#########.##");
		this.display2.setText(format.format(deviation) + " mm");
	}

	public void updateAffectedDeviationDisplay(double deviation) {
		DecimalFormat format = new DecimalFormat("#########.##");
		this.display3.setText(format.format(deviation) + " mm");
	}

	private void setLayout() {
		javax.swing.GroupLayout this1Layout = new javax.swing.GroupLayout(this);
		this.setLayout(this1Layout);
		this1Layout
				.setHorizontalGroup(this1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								this1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												this1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(step1)
														.addGroup(
																this1Layout
																		.createSequentialGroup()
																		.addGap(
																				20,
																				20,
																				20)
																		.addComponent(
																				instruct12))
														.addGroup(
																this1Layout
																		.createSequentialGroup()
																		.addGap(
																				10,
																				10,
																				10)
																		.addComponent(
																				instruct11,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				178,
																				javax.swing.GroupLayout.PREFERRED_SIZE))
														.addComponent(step2)
														.addGroup(
																this1Layout
																		.createSequentialGroup()
																		.addGap(
																				10,
																				10,
																				10)
																		.addGroup(
																				this1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								instruct21)
																						.addGroup(
																								this1Layout
																										.createSequentialGroup()
																										.addGap(
																												10,
																												10,
																												10)
																										.addGroup(
																												this1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addGroup(
																																this1Layout
																																		.createSequentialGroup()
																																		.addGap(
																																				10,
																																				10,
																																				10)
																																		.addComponent(
																																				deviation2)
																																		.addGap(
																																				18,
																																				18,
																																				18)
																																		.addComponent(
																																				display2,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				53,
																																				javax.swing.GroupLayout.PREFERRED_SIZE))
																														.addComponent(
																																instruct22)))))
														.addComponent(step3)
														.addGroup(
																this1Layout
																		.createSequentialGroup()
																		.addGap(
																				10,
																				10,
																				10)
																		.addGroup(
																				this1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								instruct31)
																						.addGroup(
																								this1Layout
																										.createSequentialGroup()
																										.addGap(
																												10,
																												10,
																												10)
																										.addGroup(
																												this1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																instruct32)
																														.addGroup(
																																this1Layout
																																		.createParallelGroup(
																																				javax.swing.GroupLayout.Alignment.TRAILING,
																																				false)
																																		.addGroup(
																																				javax.swing.GroupLayout.Alignment.LEADING,
																																				this1Layout
																																						.createSequentialGroup()
																																						.addGap(
																																								12,
																																								12,
																																								12)
																																						.addComponent(
																																								save)
																																						.addPreferredGap(
																																								javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																																								javax.swing.GroupLayout.DEFAULT_SIZE,
																																								Short.MAX_VALUE)
																																						.addComponent(
																																								reset))
																																		.addGroup(
																																				javax.swing.GroupLayout.Alignment.LEADING,
																																				this1Layout
																																						.createSequentialGroup()
																																						.addGap(
																																								10,
																																								10,
																																								10)
																																						.addComponent(
																																								deviation3)
																																						.addGap(
																																								18,
																																								18,
																																								18)
																																						.addComponent(
																																								display3,
																																								javax.swing.GroupLayout.PREFERRED_SIZE,
																																								54,
																																								javax.swing.GroupLayout.PREFERRED_SIZE))))))))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		this1Layout
				.setVerticalGroup(this1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								this1Layout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(step1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(instruct11)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(instruct12)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(step2)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(instruct21)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(instruct22)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												this1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																deviation2)
														.addComponent(
																display2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(step3)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(instruct31)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(instruct32)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												this1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																deviation3)
														.addComponent(
																display3,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												this1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(save)
														.addComponent(reset))
										.addGap(14, 14, 14)));
	}
}
