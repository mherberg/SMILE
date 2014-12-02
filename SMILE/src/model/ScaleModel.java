package model;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import message.Message;
import message.MessageListener;
import model.templates.Model;
import util.graphics.Drawer;
import util.math.Circle;
import util.math.Line;
import util.math.LineComputer;
import view.image.ImageHolder;
import view.panel.ScalePanel;

/**
 * A ScaleModel computes the scaling factor from pixels to mm
 * 
 * It does it by averaging the two iris the user previously found
 * by the user
 * 
 * @author Luke
 *
 */
public class ScaleModel extends Model {

	private static final ScalePanel panel = new ScalePanel();

	private double pixelsDividedByMM;
	private Line midline;
	public static final double avgIrisDiameterInMM = 11.71;

	public ScaleModel(ImageHolder image, MessageListener listener) {
		super(image, listener, ScaleModel.panel);
	}

	public void focus(Circle left, Circle right) {

		super.focus();

		double avgRadius = (left.getRadius() + right.getRadius()) / 2;
		this.pixelsDividedByMM = (2 * avgRadius) / avgIrisDiameterInMM;
		ScaleModel.panel.setScale(pixelsDividedByMM);

		Point2D.Double leftIris = left.getCenter();
		Point2D.Double rightIris = right.getCenter();

		Line intercanthal = new Line(leftIris, rightIris);
		double slope = intercanthal.getSlope();
		double length = intercanthal.getLength();
		Point2D.Double midPoint = new Point2D.Double(
				(leftIris.getX() + rightIris.getX()) / 2,
				(leftIris.getY() + rightIris.getY()) / 2);

		this.midline = LineComputer.getLineThroughPointWithGivenSlope(-1
				/ slope, midPoint, length / 2, 5 * length);

		BufferedImage updatedImage = Drawer.drawLine(this.image
				.getScaledBufferedImage(), intercanthal, ScalePanel.lineColor);
		updatedImage = Drawer.drawLine(updatedImage, this.midline,
				ScalePanel.lineColor);
		this.image.paintBufferedImage(updatedImage);

		notifyListeners(new Message(this, Message.SCALE_SET));
	}

	public Line getMidline() {
		return this.midline;
	}

	public double getPixelsDividedbyMM() {
		return pixelsDividedByMM;
	}
}
