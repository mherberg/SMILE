package view.panel;

import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.FocusableButtonPanel;


public class LidBrowAnalysisPanel extends FocusableButtonPanel {

	private static final long serialVersionUID = 1L;
	private final JLabel eyeLabel = new JLabel("Step 1:");
	private final JLabel eyeInstruct1 = new JLabel(
			"-Click the center of an eye");
	private final JLabel eyeInstruct2 = new JLabel("");

	private final JLabel brow = new JLabel("Brow Height:");
	private final JLabel superior = new JLabel("Superior Lid Malposition:");
	private final JLabel inferior = new JLabel("Inferior Lid Malposition:");

	private final JTextField browField = new JTextField();
	private final JTextField superiorField = new JTextField();
	private final JTextField inferiorField = new JTextField();

	private final JButton reselect = new JButton(FocusableButtonPanel.reselect);
	private final JButton save = new JButton(FocusableButtonPanel.save);

	public static final Color dotColor = Color.RED;
	public static final Color lineColor = Color.BLUE;

	public LidBrowAnalysisPanel() {
		super();
		this.text.add(eyeLabel);
		this.text.add(eyeInstruct1);
		this.text.add(eyeInstruct2);

		this.text.add(brow);
		this.text.add(superior);
		this.text.add(inferior);

		this.text.add(browField);
		this.text.add(superiorField);
		this.text.add(inferiorField);

		this.buttons.add(reselect);
		this.buttons.add(save);

		unfocus();
		setLayout();
	}

	public void focus() {
		super.focus();

		String resetValue = "0 mm";
		this.browField.setText(resetValue);
		this.superiorField.setText(resetValue);
		this.inferiorField.setText(resetValue);

		this.brow.setForeground(Color.GRAY);
		this.browField.setForeground(Color.GRAY);
		this.superior.setForeground(Color.GRAY);
		this.superiorField.setForeground(Color.GRAY);
		this.inferior.setForeground(Color.GRAY);
		this.inferiorField.setForeground(Color.GRAY);
	}

	public void updateFields(double brow, double superior, double inferior) {
		DecimalFormat format = new DecimalFormat("#########.##");

		this.browField.setText(format.format(brow) + " mm");
		this.superiorField.setText(format.format(superior) + " mm");
		this.inferiorField.setText(format.format(inferior) + " mm");

		this.brow.setForeground(Color.BLACK);
		this.superior.setForeground(Color.BLACK);
		this.inferior.setForeground(Color.BLACK);

		this.browField.setForeground(Color.BLACK);
		this.superiorField.setForeground(Color.BLACK);
		this.inferiorField.setForeground(Color.BLACK);

		this.reselect.setForeground(Color.BLACK);
		this.save.setForeground(Color.BLACK);
	}

	private void setLayout() {
		javax.swing.GroupLayout eyeLayout = new javax.swing.GroupLayout(this);
		this.setLayout(eyeLayout);
		eyeLayout
				.setHorizontalGroup(eyeLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								eyeLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												eyeLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																eyeLayout
																		.createSequentialGroup()
																		.addGroup(
																				eyeLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								eyeLabel)
																						.addGroup(
																								eyeLayout
																										.createSequentialGroup()
																										.addGap(
																												10,
																												10,
																												10)
																										.addGroup(
																												eyeLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																eyeInstruct1)
																														.addGroup(
																																eyeLayout
																																		.createSequentialGroup()
																																		.addGap(
																																				10,
																																				10,
																																				10)
																																		.addComponent(
																																				eyeInstruct2)))))
																		.addGap(
																				38,
																				38,
																				38))
														.addGroup(
																eyeLayout
																		.createSequentialGroup()
																		.addGroup(
																				eyeLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								brow)
																						.addComponent(
																								superior)
																						.addGroup(
																								eyeLayout
																										.createSequentialGroup()
																										.addGroup(
																												eyeLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																inferior)
																														.addGroup(
																																eyeLayout
																																		.createParallelGroup(
																																				javax.swing.GroupLayout.Alignment.TRAILING,
																																				false)
																																		.addComponent(
																																				inferiorField,
																																				javax.swing.GroupLayout.Alignment.LEADING)
																																		.addComponent(
																																				superiorField,
																																				javax.swing.GroupLayout.Alignment.LEADING)
																																		.addComponent(
																																				browField,
																																				javax.swing.GroupLayout.Alignment.LEADING,
																																				javax.swing.GroupLayout.PREFERRED_SIZE,
																																				86,
																																				javax.swing.GroupLayout.PREFERRED_SIZE)))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																												12,
																												Short.MAX_VALUE)
																										.addGroup(
																												eyeLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING,
																																false)
																														.addComponent(
																																save,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																Short.MAX_VALUE)
																														.addComponent(
																																reselect))))
																		.addContainerGap()))));
		eyeLayout
				.setVerticalGroup(eyeLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								eyeLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(eyeLabel)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(eyeInstruct1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(eyeInstruct2)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												39, Short.MAX_VALUE)
										.addGroup(
												eyeLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																eyeLayout
																		.createSequentialGroup()
																		.addComponent(
																				brow)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				browField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				superior)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				superiorField,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				inferior))
														.addComponent(reselect))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												eyeLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																inferiorField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(save))
										.addContainerGap()));
	}

}
