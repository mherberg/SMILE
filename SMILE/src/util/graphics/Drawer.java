package util.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import util.math.Circle;
import util.math.Line;

/**
 *  The Drawer class will paint shapes onto BufferedImages
 *  
 *  This class is used by Models to give the user feedback from their input
 *  
 * @author Luke
 *
 */
public class Drawer {

	private static final int dotBigRadiusInPixels = 3;
	private static final int dotSmallRadiusInPixels = 2;
	
	public static BufferedImage drawDot(BufferedImage image,
			Point2D.Double point, Color color) {

		Graphics g = image.getGraphics();
		int x = (int) point.getX();
		int y = (int) point.getY();
		g.setColor(color);
		g.fillOval(x - dotBigRadiusInPixels, y - dotBigRadiusInPixels,
				2 * dotBigRadiusInPixels, 2 * dotBigRadiusInPixels);
		return image;
	}

	public static BufferedImage drawSmallDot(BufferedImage image,
			Point2D.Double point, Color color) {

		Graphics g = image.getGraphics();
		int x = (int) point.getX();
		int y = (int) point.getY();
		g.setColor(color);
		g.fillOval(x - dotSmallRadiusInPixels, y - dotSmallRadiusInPixels, 
				2 * dotSmallRadiusInPixels, 2 * dotSmallRadiusInPixels);
		
		return image;
	}

	public static BufferedImage drawLine(BufferedImage image, Line line,
			Color color) {

		Graphics g = image.getGraphics();
		g.setColor(color);
		
		Point2D.Double one = line.getStart();
		Point2D.Double two = line.getEnd();

		g.drawLine((int) one.getX(), (int) one.getY(), (int) two.getX(),
				(int) two.getY());

		return image;
	}

	public static BufferedImage drawCircle(BufferedImage image, Circle circle,
			Color color) {

		Graphics g = image.getGraphics();
		g.setColor(color);

		int r = (int) circle.getRadius();
		int x = (int) circle.getCenter().getX() - r;
		int y = (int) circle.getCenter().getY() - r;
		int diameter = 2 * r;

		g.drawOval(x, y, diameter, diameter);

		return image;
	}

	public static BufferedImage drawArc(BufferedImage image,
			Point2D.Double loc, double startAngle, double arc, Color color) {

		Graphics g = image.getGraphics();
		g.setColor(color);

		int radius = 30;
		int x = (int) loc.getX() - radius;
		int y = (int) loc.getY() - radius;

		int width = radius * 2;
		int height = radius * 2;

		g.drawArc(x, y, width, height, (int) startAngle, (int) arc);
		return image;
	}
}
