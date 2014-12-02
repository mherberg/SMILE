package view.instructions;

import javax.swing.JPanel;

public class EyeAnalysisInstructions extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel browSuperiorInferior;

	public EyeAnalysisInstructions(JPanel browSuperiorInferior) {
		super();
		this.browSuperiorInferior = browSuperiorInferior;
		setLayout();
	}

	private void setLayout() {

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				this);
		this.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(browSuperiorInferior,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(browSuperiorInferior,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(164, Short.MAX_VALUE)));
	}
}
