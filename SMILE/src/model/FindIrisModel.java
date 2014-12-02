package model;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import message.Message;
import message.MessageListener;
import model.templates.ButtonMouseModel;
import model.templates.FrameModel;
import util.graphics.Drawer;
import util.math.Circle;
import util.math.CircleComputer;
import view.FocusableButtonPanel;
import view.frame.ZoomFrame;
import view.image.ImageHolder;
import view.panel.FindIrisPanel;

/**
 * A FindIrisModel is used to locate the iris of the patient in the blown up image
 * 
 * A FindIrisModel will ask the user to click 4 locations around the rim of the 
 * patient's iris, which uses to compute a circle.
 * 
 * The FindIrisModel must deal with scaling issues, and return a properly scaled
 * circle to the listening EyeModel
 * 
 * @author Luke
 *
 */
public class FindIrisModel extends ButtonMouseModel implements FrameModel {

	private final ZoomFrame frame;

	private static final FindIrisPanel panel = new FindIrisPanel();
	private final double origWDivMainW;
	
	private Point2D.Double click;
	private int width;
	private int height;

	private Circle scaledIris;


	public FindIrisModel(ImageHolder image, Point2D.Double click, double scale, MessageListener listener) {
		super(image, listener, panel);

		this.origWDivMainW = scale;

		this.width = image.getImageWidth();
		this.height = image.getImageHeight();				
		
		this.click = click;
		
		this.frame = new ZoomFrame(image, FindIrisModel.panel, this);
		this.image = this.frame.getImageHolder();

		this.focus();

	}

	/**
	 * If the frame is closed, then let the listening models know that the
	 * iris was not computed
	 */
	public void handleCloseOperation() {
		this.frame.setVisible(false);
		notifyListeners(new Message(this, Message.IRIS_NOT_CALCULATED));
	}

	
	/**
	 *  Two Buttons a FindIrisModel listens to
	 *  
	 *  Done - let the listening models know the iris has been calculated
	 *  Reset - clear all the information and start over
	 *  
	 */
	protected void handleButton(String button) {

		if (button.equals(FocusableButtonPanel.done) && this.scaledIris != null) {
			notifyListeners(new Message(this, Message.IRIS_CALCULATED));
			this.frame.setVisible(false);
		}

		if (button.equals(FocusableButtonPanel.reset)) {
			this.clickLocations.clear();
			this.clickCount = 0;
			this.scaledIris = null;
			this.image.paintBufferedImage(this.cleanImage);
			FindIrisModel.panel.initialize();
		}

	}

	public Circle getScaledIris() {
		return this.scaledIris;
	}

	/**
	 * Given 4 click locations, attempt to find a circle which best fits them
	 */
	private void findCircle() {

		Circle iris = CircleComputer
				.findBestCircleFromFourPoints(this.clickLocations);

		if (iris.isCircle()) {

			//Draw iris on blow up image
			BufferedImage circleImage = Drawer.drawCircle(this.image
					.getScaledBufferedImage(), iris, FindIrisPanel.dotColor);
			this.image.paintBufferedImage(circleImage);

			//Scale and shift the circle to the original image
			double x = iris.getCenter().getX()
					* this.image.getOriginalDividedByScaledWidth()
					+ this.click.getX() - this.width / 2;
			double y = iris.getCenter().getY()
					* this.image.getOriginalDividedByScaledWidth()
					+ this.click.getY() - this.height / 2;
			double r = iris.getRadius()
					* this.image.getOriginalDividedByScaledWidth();

			x = x / this.origWDivMainW;
			y = y / this.origWDivMainW;
			r = r / this.origWDivMainW;
			
			Point2D.Double center = new Point2D.Double(x, y);			
			this.scaledIris = new Circle(center, r);
			
			// From paper XXXXXX, we know the average iris diameter is 11.5
			// Divide the number of pixels by this value to get the scaling factor
			FindIrisModel.panel.setScale((2 * r) / ScaleModel.avgIrisDiameterInMM);
		}
	}

	
	/**
	 * Handle 4 clicks
	 * After the 4 click, compute the best circle which runs through them
	 */
	protected void handleMouseClick(Point2D.Double click) {

		if (this.clickCount <=  CircleComputer.requiredNumberOfPointsToFindCircle) {

			BufferedImage dotImage = Drawer.drawDot(this.image
					.getScaledBufferedImage(), click, FindIrisPanel.dotColor);
			this.image.paintBufferedImage(dotImage);
			this.image.repaint();

			switch (clickCount) {
			case 1:
				this.activateButtons();
				FindIrisModel.panel.boldOne();
				break;
			case 2:
				FindIrisModel.panel.boldTwo();
				break;
			case 3:
				FindIrisModel.panel.boldThree();
				break;
			case 4:
				FindIrisModel.panel.boldFour();
				break;
			}

			if (this.clickCount == CircleComputer.requiredNumberOfPointsToFindCircle) {
				this.findCircle();
			}
		}

	}

}
