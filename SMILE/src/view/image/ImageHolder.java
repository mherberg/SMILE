package view.image;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageHolder extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel image = new JLabel();
	private BufferedImage originalImage;
	private BufferedImage scaledImage;

	private int originalWidth = 0;
	private int scaledWidth = 0;

	public ImageHolder(ImageIcon icon, int scaledWidth) {

		super();
		this.scaledImage = convertImageToBufferedImage(icon.getImage());
		this.image.setIcon(icon);
		this.scaledWidth = scaledWidth;
		this.add(image);
		setLayout();

	}

	public ImageHolder(BufferedImage image, int width) {
		this(new ImageIcon(image.getScaledInstance(width, -1,
				BufferedImage.SCALE_FAST)), width);
		this.originalImage = image;
		this.originalWidth = image.getWidth();
	}

	public int getImageHeight() { return this.originalImage.getHeight(); }
	public int getImageWidth() { return this.originalImage.getWidth(); }
	
	private BufferedImage convertImageToBufferedImage(Image image) {
		int height = image.getHeight(this);
		int width = image.getWidth(this);

		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_ARGB);
		Graphics g = bufferedImage.getGraphics();
		g.drawImage(image, 0, 0, null);
		return bufferedImage;
	}

	public void paintBufferedImage(BufferedImage image) {

		Image scaled = image.getScaledInstance(this.scaledWidth, -1,
				BufferedImage.SCALE_FAST);
		this.scaledImage = convertImageToBufferedImage(scaled);
		this.image.setIcon(new ImageIcon(this.scaledImage));
		setLayout();
	}

	public void loadBufferedImage(BufferedImage image) {

		this.originalImage = null;
		this.scaledImage = null;

		this.originalImage = image;
		this.originalWidth = image.getWidth();
		paintBufferedImage(image);
	}

	public double getOriginalDividedByScaledWidth() {
		return ((double) this.originalWidth) / ((double) this.scaledWidth);
	}

	public BufferedImage getOriginalBufferedImage() {
		return this.originalImage;
	}

	public BufferedImage getScaledBufferedImage() {

		BufferedImage scaledImage = this.scaledImage;

		// Repaint image, so next alteration won't effect this image
		this.paintBufferedImage(scaledImage);
		return scaledImage;
	}

	private void setLayout() {
		image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		image.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		image.setName("image");

		javax.swing.GroupLayout imageHolderLayout = new javax.swing.GroupLayout(
				this);
		this.setLayout(imageHolderLayout);
		imageHolderLayout.setHorizontalGroup(imageHolderLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(image));
		imageHolderLayout.setVerticalGroup(imageHolderLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(image));

		this.setSize(this.image.getIcon().getIconHeight(), this.image.getIcon()
				.getIconWidth());

	}

}
