package view.instructions;

import javax.swing.JPanel;

public class SmileInstructions extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel bottomLipEdge;
	private final JPanel smileMouthCorner;

	public SmileInstructions(JPanel bottomLip, JPanel mouthCorner) {
		super();
		this.bottomLipEdge = bottomLip;
		this.smileMouthCorner = mouthCorner;

		setLayout();
	}

	private void setLayout() {

		javax.swing.GroupLayout smileStepsContainerLayout = new javax.swing.GroupLayout(
				this);
		this.setLayout(smileStepsContainerLayout);
		smileStepsContainerLayout
				.setHorizontalGroup(smileStepsContainerLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								smileStepsContainerLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												smileStepsContainerLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(
																bottomLipEdge,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																smileMouthCorner,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		smileStepsContainerLayout
				.setVerticalGroup(smileStepsContainerLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								smileStepsContainerLayout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(
												bottomLipEdge,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												smileMouthCorner,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)));

	}
}
