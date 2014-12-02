package view.instructions;

import javax.swing.JPanel;

public class NasalBaseAnalysisInstructions extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel nasalBaseAnalysisPanel;

	public NasalBaseAnalysisInstructions(JPanel nasalBaseAnalysisPanel) {
		super();
		this.nasalBaseAnalysisPanel = nasalBaseAnalysisPanel;
		setLayout();
	}

	private void setLayout() {

		javax.swing.GroupLayout instructionLayout = new javax.swing.GroupLayout(
				this);
		this.setLayout(instructionLayout);
		instructionLayout.setHorizontalGroup(instructionLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						instructionLayout.createSequentialGroup()
								.addContainerGap().addComponent(
										nasalBaseAnalysisPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(33, Short.MAX_VALUE)));
		instructionLayout.setVerticalGroup(instructionLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						instructionLayout.createSequentialGroup()
								.addContainerGap().addComponent(
										nasalBaseAnalysisPanel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(31, Short.MAX_VALUE)));
	}
}
