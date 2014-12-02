package view.panel;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.FocusableButtonPanel;


public class FindIrisPanel extends FocusableButtonPanel {

	private static final long serialVersionUID = 1L;
	private final JLabel title = new JLabel("Measure the Iris:");
	private final JLabel instruct1 = new JLabel("- Click four points");
	private final JLabel instruct2 = new JLabel("around the iris");

	private final JLabel one = new JLabel("1");
	private final JLabel two = new JLabel("2");
	private final JLabel three = new JLabel("3");
	private final JLabel four = new JLabel("4");

	private final JLabel scale = new JLabel("Scale:");
	private final JTextField scaleField = new JTextField();

	private final JButton done = new JButton(FocusableButtonPanel.done);
	private final JButton reset = new JButton(FocusableButtonPanel.reset);

	private final String fontName;
	private final int fontSize;

	public static final Color dotColor = Color.BLUE;

	public FindIrisPanel() {
		super();

		this.text.add(title);
		this.text.add(instruct1);
		this.text.add(instruct2);

		this.text.add(scale);
		this.text.add(scaleField);

		this.buttons.add(done);
		this.buttons.add(reset);

		setLayout();

		this.fontName = this.one.getFont().getFontName();
		this.fontSize = 18;
		int fontType = Font.PLAIN;

		this.one.setFont(new Font(fontName, fontType, fontSize));
		this.two.setFont(new Font(fontName, fontType, fontSize));
		this.three.setFont(new Font(fontName, fontType, fontSize));
		this.four.setFont(new Font(fontName, fontType, fontSize));
		initialize();
		this.title.setFont(new Font(this.title.getFont().getFontName(),
				Font.BOLD, this.title.getFont().getSize()));

	}

	public void initialize() {
		this.one.setForeground(Color.GRAY);
		this.two.setForeground(Color.GRAY);
		this.three.setForeground(Color.GRAY);
		this.four.setForeground(Color.GRAY);
		this.scaleField.setText("Measuring ..");
	}

	public void boldOne() {
		this.one.setForeground(Color.BLACK);
	}

	public void boldTwo() {
		this.two.setForeground(Color.BLACK);
	}

	public void boldThree() {
		this.three.setForeground(Color.BLACK);
	}

	public void boldFour() {
		this.four.setForeground(Color.BLACK);
	}

	public void setScale(double scale) {
		DecimalFormat decimalFormat = new DecimalFormat("#########.##");
		this.scaleField.setText(decimalFormat.format(scale) + " px/mm");
	}

	private void setLayout() {

		this.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		javax.swing.GroupLayout irisCalculatorPanelLayout = new javax.swing.GroupLayout(
				this);
		this.setLayout(irisCalculatorPanelLayout);
		irisCalculatorPanelLayout
				.setHorizontalGroup(irisCalculatorPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								irisCalculatorPanelLayout
										.createSequentialGroup()
										.addGroup(
												irisCalculatorPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																irisCalculatorPanelLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				irisCalculatorPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								irisCalculatorPanelLayout
																										.createSequentialGroup()
																										.addGap(
																												14,
																												14,
																												14)
																										.addGroup(
																												irisCalculatorPanelLayout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.TRAILING)
																														.addComponent(
																																instruct2)
																														.addComponent(
																																instruct1)))
																						.addComponent(
																								title)
																						.addGroup(
																								irisCalculatorPanelLayout
																										.createSequentialGroup()
																										.addGap(
																												6,
																												6,
																												6)
																										.addComponent(
																												done)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												reset))))
														.addGroup(
																irisCalculatorPanelLayout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				scale)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addGroup(
																				irisCalculatorPanelLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								irisCalculatorPanelLayout
																										.createSequentialGroup()
																										.addComponent(
																												one)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																										.addComponent(
																												two)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																										.addComponent(
																												three)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																										.addComponent(
																												four))
																						.addComponent(
																								scaleField,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								87,
																								javax.swing.GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(23, Short.MAX_VALUE)));
		irisCalculatorPanelLayout
				.setVerticalGroup(irisCalculatorPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								irisCalculatorPanelLayout
										.createSequentialGroup()
										.addGap(22, 22, 22)
										.addComponent(title)
										.addGap(18, 18, 18)
										.addComponent(instruct1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(instruct2)
										.addGap(27, 27, 27)
										.addGroup(
												irisCalculatorPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(scale)
														.addComponent(
																scaleField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(
												irisCalculatorPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(three)
														.addComponent(two)
														.addComponent(one)
														.addComponent(four))
										.addGap(27, 27, 27)
										.addGroup(
												irisCalculatorPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(done)
														.addComponent(reset))
										.addContainerGap(54, Short.MAX_VALUE)));

	}
}
