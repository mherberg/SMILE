package model;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;

import message.MessageListener;
import model.templates.MeasureButtonModel;
import util.excelio.ExcelSaver;
import util.excelio.LipAndSmileAnaylsisEntry;
import util.excelio.LipAndSmileAnaylsisSheet;
import util.excelio.MasterExcelFile;
import util.graphics.Drawer;
import util.math.Line;
import util.math.LineComputer;
import view.FocusableButtonPanel;
import view.frame.ExcelErrorFrame;
import view.frame.SaveDataFrame;
import view.image.ImageHolder;
import view.panel.LipPanel;

public class LipModel extends MeasureButtonModel implements ExcelSaver{
	
	private static final LipPanel panel = new LipPanel();
	
	private Point2D.Double midlineUpperLip;
	private Point2D.Double midlineLowerLip;
	private Point2D.Double healthyCorner;
	private Point2D.Double affectedCorner;
	
	private Point2D.Double healthyMidUpperLip;
	private Point2D.Double healthyMidLowerLip;
	private Point2D.Double affectedMidUpperLip;
	private Point2D.Double affectedMidLowerLip;
	
	private Line healthyMidUpperLipLine;
	private Line healthyMidLowerLipLine;
	private Line affectedMidUpperLipLine;
	private Line affectedMidLowerLipLine;
	
	private double midUpperLipDeviation;
	private double midLowerLipDeviation;
	private double mouthCornerDeviation;
	
	
	private int stepIndex = 1;
	
	public LipModel(ImageHolder image, MessageListener listener) {
		super(image, listener, panel);
	
	}

	
	protected void handleButton(String button) {
		if (button.equals(FocusableButtonPanel.reselect)) {
			// If reselecting, repaint and reinitialize
			this.image.paintBufferedImage(this.cleanImage);
			activate();
		}

		if (button.equals(FocusableButtonPanel.save))
			new SaveDataFrame(this, true, true, false);

	}

	public void unfocus() {
		super.unfocus();
		this.stepIndex = 1;
	}
	
	protected void handleMouseClick(Double click) {
		
		Point2D.Double dot = click;
		BufferedImage update = this.image.getScaledBufferedImage();
		
		switch(stepIndex) {
		
		case 1:
			// Intersection of upper lip with midline
			this.midlineUpperLip = this.midline.getClosestPointOnLine(dot);
			dot = this.midlineUpperLip;
			break;
		case 2:
			// Intersection of lower lip with midline
			this.midlineLowerLip = this.midline.getClosestPointOnLine(dot);
			dot = this.midlineLowerLip;
			this.panel.focusStep2();
			break;
		case 3:
			// Healthy lip corner
			this.healthyCorner = dot;
			
			Line upperMidToHealthyCorner = new Line(this.healthyCorner, this.midlineUpperLip);
			Line lowerMidToHealthyCorner = new Line(this.healthyCorner, this.midlineLowerLip);	
			
			double bisectingHealthyLineLength = upperMidToHealthyCorner.getLength()/8;
			
			Point2D.Double upperHealthyMidPoint = new Point2D.Double((this.healthyCorner.x+this.midlineUpperLip.x)/2,
					(this.healthyCorner.y+this.midlineUpperLip.y)/2);
			
			Point2D.Double lowerHealthyMidPoint = new Point2D.Double((this.healthyCorner.x+this.midlineLowerLip.x)/2,
					(this.healthyCorner.y+this.midlineLowerLip.y)/2);
			
			this.healthyMidUpperLipLine = LineComputer.getLineThroughPointWithGivenSlope(this.midline.getSlope(), upperHealthyMidPoint,
					bisectingHealthyLineLength, bisectingHealthyLineLength);

			this.healthyMidLowerLipLine = LineComputer.getLineThroughPointWithGivenSlope(this.midline.getSlope(), lowerHealthyMidPoint,
					bisectingHealthyLineLength, bisectingHealthyLineLength);
			
			
			update = Drawer.drawLine(update, upperMidToHealthyCorner, LipPanel.lineColor);
			update = Drawer.drawLine(update, lowerMidToHealthyCorner, LipPanel.lineColor);

			update = Drawer.drawLine(update, healthyMidUpperLipLine, LipPanel.bisectingLineColor);
			update = Drawer.drawLine(update, healthyMidLowerLipLine, LipPanel.bisectingLineColor);

			break;
		case 4:
			// Midline of upper healthy lip
			this.healthyMidUpperLip = this.healthyMidUpperLipLine.getClosestPointOnLine(dot);
			dot = this.healthyMidUpperLip;
	
			break;			
		case 5:
			// Midline of lower healthy lip
			this.healthyMidLowerLip = this.healthyMidLowerLipLine.getClosestPointOnLine(dot);
			dot = this.healthyMidLowerLip;
	
			this.panel.focusStep3();
			break;
		case 6:
			// Affected lip corner
			this.affectedCorner = dot;
			
			Line upperMidToAffectedCorner = new Line(this.affectedCorner, this.midlineUpperLip);
			Line lowerMidToAffectedCorner = new Line(this.affectedCorner, this.midlineLowerLip);	
			
			double bisectingAffectedLineLength = upperMidToAffectedCorner.getLength()/8;
			
			Point2D.Double upperAffectedMidPoint = new Point2D.Double((this.affectedCorner.x+this.midlineUpperLip.x)/2,
					(this.affectedCorner.y+this.midlineUpperLip.y)/2);
			
			Point2D.Double lowerAffectedMidPoint = new Point2D.Double((this.affectedCorner.x+this.midlineLowerLip.x)/2,
					(this.affectedCorner.y+this.midlineLowerLip.y)/2);
			
			this.affectedMidUpperLipLine = LineComputer.getLineThroughPointWithGivenSlope(this.midline.getSlope(), upperAffectedMidPoint,
					bisectingAffectedLineLength, bisectingAffectedLineLength);

			this.affectedMidLowerLipLine = LineComputer.getLineThroughPointWithGivenSlope(this.midline.getSlope(), lowerAffectedMidPoint,
					bisectingAffectedLineLength, bisectingAffectedLineLength);
			
			
			update = Drawer.drawLine(update, upperMidToAffectedCorner, LipPanel.lineColor);
			update = Drawer.drawLine(update, lowerMidToAffectedCorner, LipPanel.lineColor);

			update = Drawer.drawLine(update, affectedMidUpperLipLine, LipPanel.bisectingLineColor);
			update = Drawer.drawLine(update, affectedMidLowerLipLine, LipPanel.bisectingLineColor);
			
			break;
		case 7:
			// Midline of upper affected lip
			this.affectedMidUpperLip = this.affectedMidUpperLipLine.getClosestPointOnLine(dot);
			dot = this.affectedMidUpperLip;
			
		
			break;
		case 8:
			// Midline of lower affected lip
			this.affectedMidLowerLip = this.affectedMidLowerLipLine.getClosestPointOnLine(dot);
			dot = this.affectedMidLowerLip;
			
				
			// Compute deviations
			this.midUpperLipDeviation = computeDistanceBetweenTwoPointsProjectedOntoALine(this.healthyMidUpperLip, 
					this.affectedMidUpperLip, this.midline)/this.pxDividedByMM;
			this.midLowerLipDeviation = computeDistanceBetweenTwoPointsProjectedOntoALine(this.healthyMidLowerLip, 
					this.affectedMidLowerLip, this.midline)/this.pxDividedByMM;
			this.mouthCornerDeviation = computeDistanceBetweenTwoPointsProjectedOntoALine(this.healthyCorner, 
					this.affectedCorner, this.midline)/this.pxDividedByMM;
			
			
			this.panel.focusDeviationDisplay();
			this.panel.updateDeviationDisplay(mouthCornerDeviation, midLowerLipDeviation, midUpperLipDeviation);
			
			this.activateButtons();
			
			break;
		}
		
				
		update = Drawer.drawSmallDot(update, dot, LipPanel.dotColor);
		this.image.paintBufferedImage(update);
		
		this.stepIndex++;
	}

	private double computeDistanceBetweenTwoPointsProjectedOntoALine(Point2D.Double one, Point2D.Double two, Line line) {
		
		Point2D.Double projectionOne = line.getClosestPointOnLine(one);
		Point2D.Double projectionTwo = line.getClosestPointOnLine(two);
		Point2D.Double start = line.getStart();
		
		Line oneToStart = new Line(projectionOne, start);
		Line twoToStart = new Line(projectionTwo, start);
		
		double deviation = twoToStart.getLength()-oneToStart.getLength();
		
		return deviation;
		
	}
	
	public void saveData(int id, int session, boolean preIntervention,
			boolean healthySide, boolean rest) {
		try {
			MasterExcelFile file = new MasterExcelFile();
			LipAndSmileAnaylsisSheet sheet = file.getLipAndSmileAnaylsisSheet();
			LipAndSmileAnaylsisEntry entry = sheet.getEntry(id, session);

			entry.setLipDeviations(midLowerLipDeviation, midUpperLipDeviation,
					mouthCornerDeviation, preIntervention, rest);
			
			sheet.addEntry(entry);
			file.updateSheets();
			file.closeBook();
		} catch (Exception e) {
			new ExcelErrorFrame();
		}
	}

}
