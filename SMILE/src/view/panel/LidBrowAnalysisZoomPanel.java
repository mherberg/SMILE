package view.panel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;

import view.FocusableButtonPanel;


public class LidBrowAnalysisZoomPanel extends FocusableButtonPanel {

	private static final long serialVersionUID = 1L;
	private final JLabel click = new JLabel("Click the intersecting line:");
	private final JLabel bottomLid = new JLabel("- at the lower eyelid margin");
	private final JLabel upperLid = new JLabel("- at the upper eyelid margin");
	private final JLabel brow = new JLabel("- at the superior brow edge");

	private final JButton done = new JButton(FocusableButtonPanel.done);
	private final JButton reselect = new JButton(FocusableButtonPanel.reselect);

	public static final Color dotColor = Color.RED;
	public static final Color lineColor = Color.BLUE;

	public LidBrowAnalysisZoomPanel() {
		super();

		this.text.add(click);
		this.text.add(bottomLid);
		this.text.add(upperLid);
		this.text.add(brow);

		this.click.setFont(new Font(this.click.getFont().getFontName(),
				Font.BOLD, this.click.getFont().getSize()));

		this.buttons.add(done);
		this.buttons.add(reselect);

		initialize();
		setLayout();
	}

	public void focus() {
		super.focus();
		this.initialize();
	}

	public void initialize() {
		this.unfocus();
		this.click.setForeground(Color.BLACK);
		this.bottomLid.setForeground(Color.BLACK);

		this.done.setForeground(Color.BLACK);
		this.reselect.setForeground(Color.BLACK);
	}

	public void selectBottomLid() {
		this.click.setForeground(Color.BLACK);
		this.bottomLid.setForeground(Color.BLACK);
	}

	public void selectUpperLid() {
		this.upperLid.setForeground(Color.BLACK);
	}

	public void selectBrow() {
		this.brow.setForeground(Color.BLACK);
	}

	public void setLayout() {
		this.setBorder(javax.swing.BorderFactory.createEtchedBorder());

		javax.swing.GroupLayout browSuperiorInferiorLayout = new javax.swing.GroupLayout(
				this);
		this.setLayout(browSuperiorInferiorLayout);
		browSuperiorInferiorLayout
				.setHorizontalGroup(browSuperiorInferiorLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								browSuperiorInferiorLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												browSuperiorInferiorLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																browSuperiorInferiorLayout
																		.createSequentialGroup()
																		.addGap(
																				10,
																				10,
																				10)
																		.addGroup(
																				browSuperiorInferiorLayout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								upperLid)
																						.addComponent(
																								bottomLid)
																						.addComponent(
																								brow)
																						.addGroup(
																								browSuperiorInferiorLayout
																										.createSequentialGroup()
																										.addComponent(
																												done)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												reselect))))
														.addComponent(click))
										.addContainerGap(25, Short.MAX_VALUE)));
		browSuperiorInferiorLayout
				.setVerticalGroup(browSuperiorInferiorLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								browSuperiorInferiorLayout
										.createSequentialGroup()
										.addGap(58, 58, 58)
										.addComponent(click)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(bottomLid)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(upperLid)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(brow)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addGroup(
												browSuperiorInferiorLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(done)
														.addComponent(reselect))
										.addContainerGap(66, Short.MAX_VALUE)));

	}
}
