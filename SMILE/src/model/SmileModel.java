package model;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import message.Message;
import message.MessageListener;
import model.templates.MeasureButtonModel;
import util.excelio.ExcelSaver;
import util.excelio.LipAndSmileAnaylsisEntry;
import util.excelio.LipAndSmileAnaylsisSheet;
import util.excelio.MasterExcelFile;
import util.graphics.Drawer;
import util.math.Circle;
import util.math.Line;
import view.FocusableButtonPanel;
import view.frame.ExcelErrorFrame;
import view.frame.SaveDataFrame;
import view.image.ImageHolder;
import view.panel.SmilePanel;

/**
 *  A SmileModel allows the user to measure the angles and lengths from the midline
 *  to the corner of the mouth
 *  
 *  Previous to running a SmileModel, it must be given a point which is the location of
 *  the bottom of the lip on the midline. From here it waits for the user to click a
 *  location on the image. It expects this click to be the corner of the mouth.
 *  
 *  From here, a right angle triangle is drawn on the original image. The base of the
 *  triangle is perpedicular to midline.
 *  
 *  The lengths of all sides are saved and displayed. The angle from the midline to
 *  the line from the bottom lip to the mouth corner is also saved and displayed.
 *  
 *  
 * @author Luke
 *
 */
public class SmileModel extends MeasureButtonModel implements ExcelSaver {

	private Point2D.Double bottomLipEdge;

	private Boolean leftSide;
	private Double xVal;
	private Double yVal;
	private Double zVal;
	private Double thetaVal;

	private static final SmilePanel panel = new SmilePanel();

	public SmileModel(ImageHolder image, MessageListener listener) {
		super(image, listener, SmileModel.panel);

	}

	/**
	 *  This function will compute and paint a triangle based on a click
	 *  
	 * @param click
	 */
	private void computeTriangle(Point2D.Double click) {

		// original triangle
                double m1 = midline.getSlope();
		double m2 = -1 / midline.getSlope();

		double b2 = bottomLipEdge.getY() - m2 * bottomLipEdge.getX();
		double b1 = click.getY() - m1 * click.getX();

		double x = ((b1 - b2) / (m2 - m1));
		double y = (m2 * x + b2);

		if (m2 == 0) {
			x = click.getX();
			y = bottomLipEdge.getY();
		}
                
                // fix triangle - MEH
                //double x = bottomLipEdge.getX();
		//double y = click.getY();
		
                // This is using the first nomenclature of a right triangle I could
		// find.
		Point2D.Double a = bottomLipEdge;
		Point2D.Double b = click;
		Point2D.Double c = new Point2D.Double(x, y);

		Line hypotenuse = new Line(a, b);
		Line adjacent = new Line(a, c);
		Line opposite = new Line(b, c);

		this.xVal = adjacent.getLength() / this.pxDividedByMM;
		this.yVal = opposite.getLength() / this.pxDividedByMM;
		this.zVal = hypotenuse.getLength() / this.pxDividedByMM;

		double intercanthalDegrees = midline.getDegrees();

		if (intercanthalDegrees < 0) 
			intercanthalDegrees += 180;
		
                //meh: old thetaVal
		//this.thetaVal = intercanthalDegrees - hypotenuse.getDegrees();
                //meh: new thetaVal quick fix
                this.thetaVal = intercanthalDegrees - hypotenuse.getDegrees() - 90;
                
		if (bottomLipEdge.getX() > click.getX()) 
                    //meh: old
//			this.thetaVal = this.thetaVal - 180;
//meh: new quick fix
                    this.thetaVal = this.thetaVal * -1;
                    
		// Measurement is on the left side of the face if the point c is to the
		// left of point a
		this.leftSide = (c.getX() > a.getX());
		
		// Display
		SmileModel.panel.displayValues(xVal, yVal, zVal, thetaVal);
		paintTriangle(click, intercanthalDegrees, hypotenuse, adjacent, opposite);
		
		notifyListeners(new Message(this, Message.MOUTH_CORNER_LOCATED));
	}

	/**
	 * Paints the triangle 
	 * 
	 * @param click
	 * @param intercanthalDegrees
	 * @param hypotenuse
	 * @param adjacent
	 * @param opposite
	 */
	private void paintTriangle(Point2D.Double click, double intercanthalDegrees, Line hypotenuse,
			Line adjacent, Line opposite){
		// Draw
		BufferedImage updatedImage = Drawer.drawDot(this.image
				.getScaledBufferedImage(), click, SmilePanel.dotColor);
		updatedImage = Drawer.drawArc(updatedImage, bottomLipEdge,
				-intercanthalDegrees, this.thetaVal, SmilePanel.thetaColor);
		updatedImage = Drawer.drawLine(updatedImage, hypotenuse,
				SmilePanel.cColor);
		updatedImage = Drawer.drawLine(updatedImage, adjacent,
				SmilePanel.bColor);
		updatedImage = Drawer.drawLine(updatedImage, opposite,
				SmilePanel.aColor);
		this.image.paintBufferedImage(updatedImage);
		
	}
	
	protected void handleButton(String button) {

		if (button.equals(FocusableButtonPanel.reselect)) {
			// If reselecting, repaint and reinitialize
			this.image.paintBufferedImage(this.cleanImage);
			SmileModel.panel.uninitalizeFields();

			uninitializeFields();
			activate();
		}

		if (button.equals(FocusableButtonPanel.save)
				&& this.measurementHasBeenTaken())
			new SaveDataFrame(this, false, true, true);

	}

	public boolean measurementHasBeenTaken() {
		// None of these fields should be null if a measurement has been taken
		return (this.leftSide != null && this.xVal != null && this.yVal != null
				&& this.zVal != null && this.thetaVal != null);
	}

	public void focus(Circle leftIris, Circle rightIris, Line midline,
			double pxDividedByMM, Point2D.Double bottomLipEdge) {
		super.focus(leftIris, rightIris, midline, pxDividedByMM);
		this.bottomLipEdge = bottomLipEdge;
		this.uninitializeFields();
	}

	private void uninitializeFields() {
		this.leftSide = null;
		this.xVal = null;
		this.yVal = null;
		this.zVal = null;
		this.thetaVal = null;
	}

	public void handleMouseClick(Point2D.Double click) {
		computeTriangle(click);
		deactivate();
		activateButtons();
		
	}

	public void saveData(int id, int session, boolean preIntervention,
			boolean healthySide, boolean rest) {
		
		try {
			MasterExcelFile file = new MasterExcelFile();
			LipAndSmileAnaylsisSheet sheet = file.getLipAndSmileAnaylsisSheet();
			LipAndSmileAnaylsisEntry entry = sheet.getEntry(id, session);

			entry.setABCTheta(xVal, yVal, zVal, thetaVal, preIntervention, healthySide);
			
			sheet.addEntry(entry);
			

			file.updateSheets();
			file.closeBook();
		} catch (Exception e) {
			new ExcelErrorFrame();
		}
	}

}
