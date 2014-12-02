package view.panel;

import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JTextField;

import view.FocusablePanel;


public class ScalePanel extends FocusablePanel {

	private static final long serialVersionUID = 1L;
	private final JLabel scaleLabel = new JLabel("Scale:");
	private final JTextField scaleField = new JTextField("0");

	public static final Color lineColor = Color.BLUE;

	public ScalePanel() {
		super();

		this.text.add(scaleField);
		this.text.add(scaleLabel);

		this.scaleLabel
				.setFont(new Font(this.scaleLabel.getFont().getFontName(),
						Font.BOLD, this.scaleLabel.getFont().getSize()));

		unfocus();
		setLayout();
	}

	public void setScale(Double px2mm) {
		DecimalFormat format = new DecimalFormat("#########.##");
		this.scaleField.setText(format.format(px2mm) + " px/mm");
	}

	public void setLayout() {

		this.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		javax.swing.GroupLayout scalePanelLayout = new javax.swing.GroupLayout(
				this);
		this.setLayout(scalePanelLayout);
		scalePanelLayout
				.setHorizontalGroup(scalePanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								scalePanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(scaleLabel)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												55, Short.MAX_VALUE)
										.addComponent(
												scaleField,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												94,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		scalePanelLayout
				.setVerticalGroup(scalePanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								scalePanelLayout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												scalePanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																scaleLabel)
														.addComponent(
																scaleField,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));
	}
}
