package view.instructions;

import javax.swing.JPanel;

public class LipInstructions extends JPanel {

	private static final long serialVersionUID = 1L;
	private final JPanel panel;

	public LipInstructions(JPanel panel) {
		super();
		this.panel = panel;
		setLayout();
	}

	private void setLayout() {

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				this);
		this.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(panel,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE).addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout.createSequentialGroup().addContainerGap()
						.addComponent(panel,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(164, Short.MAX_VALUE)));
	}
}