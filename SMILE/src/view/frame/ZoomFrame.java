package view.frame;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.templates.FrameModel;
import view.image.ImageHolder;

public class ZoomFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public static final int zoomWidth = 500;
	
	private final JPanel instructions;
	private final ImageHolder imageHolder;
	private final JPanel mainPanel = new JPanel();
	private final FrameModel worker;

	public ZoomFrame(ImageHolder image, JPanel instructions, FrameModel worker) {
		super();
		this.instructions = instructions;
		this.imageHolder = image;
		this.worker = worker;

		setLayout();
	}

	public JPanel getInstructions() {
		return this.instructions;
	}

	public ImageHolder getImageHolder() {
		return this.imageHolder;
	}

	public void defaultCloseOperation() {		
		this.worker.handleCloseOperation();
	}

	private void setLayout() {
		this.setVisible(true);
		
		int imageWidth = this.imageHolder.getScaledBufferedImage().getWidth();
		int imageHeight = this.imageHolder.getScaledBufferedImage().getHeight();
		
		this.setSize(imageWidth+220, imageHeight+60);
		
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);

		this.add(mainPanel);

		javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(
				mainPanel);
		mainPanel.setLayout(mainPanelLayout);
		mainPanelLayout
				.setHorizontalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								mainPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												instructions,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
										.addComponent(
												imageHolder,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addContainerGap()));
		mainPanelLayout
				.setVerticalGroup(mainPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								mainPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												mainPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addComponent(
																imageHolder,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE)
														.addComponent(
																instructions,
																javax.swing.GroupLayout.Alignment.LEADING,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
										.addContainerGap()));
		
		

		
	}
}
