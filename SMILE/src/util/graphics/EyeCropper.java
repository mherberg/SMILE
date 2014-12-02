package util.graphics;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class EyeCropper {

	/**
	 *  This function will segment out just the eye from the original image.
	 *  It will cut out a chunk centered at the Point2D.Double point that is
	 *  1/5 the width of the original image, and 1/7.5 the height.
	 *  
	 *  These ratios are a complete guess
	 *  
	 * @param image
	 * @param point
	 * @return
	 */
		
	private static final int eyeWidth = 3;
	private static final int eyeHeight = 4;
	
	public static BufferedImage getEyeSubImage(BufferedImage image,
			Point2D.Double point) {

		int imageWidth = image.getWidth();
		int imageHeight = image.getHeight();

		// For a picture of just the face, the eye will be roughly 1/5 the image
		// width
		int eyeWidth = image.getWidth()/EyeCropper.eyeWidth;
		int eyeHeight = image.getHeight()/EyeCropper.eyeHeight; // No idea here,
																// just guessing

		/*
		 * Recalculate the x & y position using image coordinates, not panel
		 * coordinates
		 */
		int x = (int) point.getX() - eyeWidth / 2;
		int y = (int) point.getY() - eyeHeight / 2;

		/* Check Boundary conditions */
		if (x < 0)
			x = 0;

		if (y < 0)
			y = 0;

		if (x + eyeWidth > imageWidth)
			x = imageWidth - eyeWidth;

		if (y + eyeHeight > imageHeight)
			y = imageHeight - eyeHeight;		
		/*--------------------------- */
		
		BufferedImage subImage = image.getSubimage(x, y, eyeWidth, eyeHeight);
		
		return subImage;
	}

	public static int getEyeWidth(int imageWidth) {
		return imageWidth / eyeWidth;
	}

	public static int getEyeHeight(int imageHeight) {
		return (int) (((double) imageHeight) / eyeHeight);
	}

}
