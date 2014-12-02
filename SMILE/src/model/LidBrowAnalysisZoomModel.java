package model;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;

import message.Message;
import message.MessageListener;
import model.templates.ButtonMouseModel;
import model.templates.FrameModel;
import util.graphics.Drawer;
import util.math.Line;
import util.math.LineComputer;
import view.FocusableButtonPanel;
import view.frame.ZoomFrame;
import view.image.ImageHolder;
import view.panel.LidBrowAnalysisZoomPanel;

/**
 * A LidBrowAnaylsisZoomModel is used to find the position of the
 * inferior lid, superior lid, and brow
 * 
 * It expects the ImageHolder to have an image centered on the iris
 * It will draw the bisecting midline to help the user select the location 
 * of the lids and brow.
 * 
 * The user's click will automatically be projected onto this bisecting line
 * in a hopes of increasing accuracy
 * 
 * All distances are computed using the center of the iris as a
 * reference point
 * 
 * 
 * @author Luke
 *
 */
public class LidBrowAnalysisZoomModel extends ButtonMouseModel implements
		FrameModel {

	private final ZoomFrame frame;
	private static final LidBrowAnalysisZoomPanel panel = new LidBrowAnalysisZoomPanel();
	private double origWdivMainW;
	private int width;
	private int height;

	private Point2D.Double center;

	//This line is parallel to the midline and runs through the center of the eye
	private Line bisector;

	
	private Point2D.Double bottomLid;
	private Point2D.Double upperLid;
	private Point2D.Double brow;

	public LidBrowAnalysisZoomModel(ImageHolder image, Point2D.Double eye, double scale, Line midline,
			MessageListener listener) {
		super(image, listener, panel);

		this.origWdivMainW = scale;		
		this.width = image.getImageWidth();
		this.height = image.getImageHeight();
						
		this.center = eye;

		this.frame = new ZoomFrame(image, LidBrowAnalysisZoomModel.panel, this);
		this.image = this.frame.getImageHolder();

		Point2D.Double center = new Point2D.Double(this.image
				.getScaledBufferedImage().getWidth() / 2, this.image
				.getScaledBufferedImage().getHeight() / 2);
		
		this.bisector = LineComputer.getLineThroughPointWithGivenSlope(midline
				.getSlope(), center, this.image.getScaledBufferedImage()
				.getHeight() / 2, this.image.getScaledBufferedImage()
				.getHeight() / 2);
		
		BufferedImage updateImage = Drawer.drawLine(this.image
				.getScaledBufferedImage(), bisector,
				LidBrowAnalysisZoomPanel.lineColor);

		this.image.paintBufferedImage(updateImage);
		//Save the bisecting line to the clean image
		this.cleanImage = this.image.getScaledBufferedImage();

		this.focus();
	}

	
	/**
	 * The first click is saved as the inferior lid position
	 * The second click is saved as the superior lid position
	 * The third click is saved as the brow position
	 * 
	 * All clicks are projected onto the bisecting line
	 */
	protected void handleMouseClick(Double click) {

		Point2D.Double projectedClick = this.bisector.getClosestPointOnLine(click);
		
		BufferedImage updateImage = Drawer.drawDot(this.image.getScaledBufferedImage(),
				projectedClick, LidBrowAnalysisZoomPanel.dotColor);
		this.image.paintBufferedImage(updateImage);		
		
		double x = projectedClick.getX()
			* this.image.getOriginalDividedByScaledWidth()
			+ this.center.getX()* origWdivMainW - this.width / 2;
		double y = projectedClick.getY()
			* this.image.getOriginalDividedByScaledWidth()
			+ this.center.getY()* origWdivMainW - this.height / 2;		
		
		x /= this.origWdivMainW;
		y /= this.origWdivMainW;
		
		Point2D.Double scaledProjection = new Point2D.Double(x,y);
		
		switch (clickCount) {
		case 1:
			this.activateButtons();
			LidBrowAnalysisZoomModel.panel.selectUpperLid();
			this.bottomLid = scaledProjection;
			
			break;
		case 2:
			LidBrowAnalysisZoomModel.panel.selectBrow();
			this.upperLid = scaledProjection;
			
			break;
		case 3:			
			this.deactivate();
			this.brow = scaledProjection;
			break;

		default:
			throw new RuntimeException("Wrong Click Count");
		}		
		
	}

	public Point2D.Double getBottomLid() { return this.bottomLid; }
	public Point2D.Double getUpperLid() { return this.upperLid; }
	public Point2D.Double getBrow() { return this.brow;	}
	public Point2D.Double getCenter() {	return this.center; }
	
	
	/** 
	 * If the frame has been 'x'ed out of, notify listeners that the
	 * eye was not measured
	 */
	public void handleCloseOperation() {
		notifyListeners((new Message(this, Message.EYE_NOT_MEASURED)));
	}
	
	
	/**
	 * 2 Buttons:
	 * 
	 * Reset - Clear information and start over
	 * Done - Close and notifty listeners
	 */
	protected void handleButton(String button) {

		if (button.equals(FocusableButtonPanel.done) && this.bottomLid != null
				&& this.upperLid != null && this.brow != null) {

			this.deactivateButtons();
			this.frame.setVisible(false);
			notifyListeners((new Message(this, Message.EYE_MEASURED)));

		}

		if (button.equals(FocusableButtonPanel.reselect)) {

			this.deactivate();
			this.activate();
			this.image.paintBufferedImage(this.cleanImage);

			this.clickCount = 0;
			this.clickLocations.clear();
			this.bottomLid = null;
			this.upperLid = null;
			this.brow = null;

			LidBrowAnalysisZoomModel.panel.initialize();
		}

	}

}
