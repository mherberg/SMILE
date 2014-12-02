package view.panel;

import java.awt.Color;

import javax.swing.JLabel;

import view.FocusablePanel;


public class LipOnMidlinePanel extends FocusablePanel {

	private static final long serialVersionUID = 1L;
	private final JLabel bottomLipEdgeStep = new JLabel("Step 1:");
	private final JLabel bottomLipEdgeInstruct1 = new JLabel(
			"- Click on the line at bottom vermillion border");
	private final JLabel bottomLipEdgeInstruct2 = new JLabel(
			"(demarcation between the red colored lip and the adjacent normal skin)");

	public static final Color dotColor = Color.BLUE;

	public LipOnMidlinePanel() {
		super();
		this.text.add(bottomLipEdgeStep);
		this.text.add(bottomLipEdgeInstruct1);
		this.text.add(bottomLipEdgeInstruct2);
		setLayout();
		unfocus();
	}

	private void setLayout() {

		javax.swing.GroupLayout bottomLipEdgeLayout = new javax.swing.GroupLayout(
				this);
		this.setLayout(bottomLipEdgeLayout);
		bottomLipEdgeLayout
				.setHorizontalGroup(bottomLipEdgeLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								bottomLipEdgeLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												bottomLipEdgeLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																bottomLipEdgeStep)
														.addComponent(
																bottomLipEdgeInstruct1)
														.addComponent(
																bottomLipEdgeInstruct2))
										.addContainerGap(71, Short.MAX_VALUE)));
		bottomLipEdgeLayout
				.setVerticalGroup(bottomLipEdgeLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								bottomLipEdgeLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(bottomLipEdgeStep)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(bottomLipEdgeInstruct1)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(bottomLipEdgeInstruct2)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
	}

}
