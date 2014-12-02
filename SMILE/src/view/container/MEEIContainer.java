package view.container;

import javax.swing.JPanel;

public class MEEIContainer extends JPanel {

	private static final long serialVersionUID = 3391772339589764089L;
	private final JPanel imagePanel;
	private final JPanel instrumentsContainer;

	public MEEIContainer(JPanel image, JPanel instrumentsContainer) {
		super();
		this.imagePanel = image;
		this.instrumentsContainer = instrumentsContainer;

		setLayout();
	}

	private void setLayout() {
		
        javax.swing.GroupLayout MEEIContainerLayout = new javax.swing.GroupLayout(this);
        this.setLayout(MEEIContainerLayout);
        MEEIContainerLayout.setHorizontalGroup(
            MEEIContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MEEIContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(instrumentsContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        MEEIContainerLayout.setVerticalGroup(
            MEEIContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MEEIContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MEEIContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MEEIContainerLayout.createSequentialGroup()
                        .addComponent(imagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(MEEIContainerLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(instrumentsContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

	}

}
