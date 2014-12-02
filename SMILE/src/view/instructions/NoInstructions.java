package view.instructions;

import java.awt.Color;

import javax.swing.JLabel;

import view.FocusablePanel;


public class NoInstructions extends FocusablePanel {

	private static final long serialVersionUID = 1L;
	private final JLabel NoMeasureLabel = new JLabel("No Measurement Selected:");
	private final JLabel NoMeasureInstruct1 = new JLabel(
			"-Select a measurement from");
	private final JLabel NoMeasureInstruct2 = new JLabel("drop down menu above");

	public NoInstructions() {
		super();
		setLayout();
		unfocus();
	}

	public void focus() {
		this.NoMeasureLabel.setForeground(Color.BLACK);
		this.NoMeasureInstruct1.setForeground(Color.BLACK);
		this.NoMeasureInstruct2.setForeground(Color.BLACK);
	}

	public void unfocus() {
		this.NoMeasureLabel.setForeground(Color.GRAY);
		this.NoMeasureInstruct1.setForeground(Color.GRAY);
		this.NoMeasureInstruct2.setForeground(Color.GRAY);
	}

	private void setLayout() {
		javax.swing.GroupLayout NoMeasurementLayout = new javax.swing.GroupLayout(
				this);
		this.setLayout(NoMeasurementLayout);
		NoMeasurementLayout
				.setHorizontalGroup(NoMeasurementLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								NoMeasurementLayout
										.createSequentialGroup()
										.addGroup(
												NoMeasurementLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																NoMeasurementLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				NoMeasureLabel))
														.addGroup(
																NoMeasurementLayout
																		.createSequentialGroup()
																		.addGap(
																				22,
																				22,
																				22)
																		.addGroup(
																				NoMeasurementLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								NoMeasurementLayout
																										.createSequentialGroup()
																										.addGap(
																												10,
																												10,
																												10)
																										.addComponent(
																												NoMeasureInstruct2))
																						.addComponent(
																								NoMeasureInstruct1))))
										.addContainerGap(69, Short.MAX_VALUE)));
		NoMeasurementLayout
				.setVerticalGroup(NoMeasurementLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								NoMeasurementLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(NoMeasureLabel)
										.addGap(18, 18, 18)
										.addComponent(NoMeasureInstruct1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(NoMeasureInstruct2)
										.addContainerGap(197, Short.MAX_VALUE)));
	}
}
