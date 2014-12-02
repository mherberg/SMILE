package model;

import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;

import message.MessageListener;
import model.templates.MeasureButtonModel;
import util.excelio.ExcelSaver;
import util.excelio.MasterExcelFile;
import util.excelio.PhiltralDeviationAnalysisEntry;
import util.excelio.PhiltralDeviationAnalysisSheet;
import util.graphics.Drawer;
import util.math.Line;
import util.math.LineComputer;
import view.FocusableButtonPanel;
import view.frame.ExcelErrorFrame;
import view.frame.SaveDataFrame;
import view.image.ImageHolder;
import view.panel.PhitralDeviationPanel;

public class PhiltralDeviationModel extends MeasureButtonModel implements ExcelSaver{
	
	private static final PhitralDeviationPanel panel = new PhitralDeviationPanel();
	
	private Point2D.Double topLip;
	private Point2D.Double healthyCorner;
	private Point2D.Double affectedCorner;
	private Point2D.Double healthyIntersect;
	private Point2D.Double affectedIntersect;
	
	private Line topToHealthy;
	private Line topToAffected;
	
	private Line healthyBisecting;
	private Line affectedBisecting;
	
	private double deviation;
	
	private int stepIndex = 1;
	
	public PhiltralDeviationModel(ImageHolder image, MessageListener listener) {
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
			dot = this.midline.getClosestPointOnLine(click);
			this.topLip = dot;
			this.panel.focusStep2();
			break;
		case 2:
			this.healthyCorner = click;
			this.topToHealthy = new Line(this.topLip, this.healthyCorner);
			update = Drawer.drawLine(update, topToHealthy, PhitralDeviationPanel.cornerToTopColor);
			
			this.panel.focusStep3();
			break;
		case 3:
			this.affectedCorner = click;
			this.topToAffected = new Line(this.affectedCorner, this.topLip);
			update = Drawer.drawLine(update, topToAffected, PhitralDeviationPanel.cornerToTopColor);
			
			//Compute Bisecting Lines
			Point2D.Double midpoint = new Point2D.Double((this.topLip.getX()+this.healthyCorner.getX())/2,(this.topLip.getY()+this.healthyCorner.getY())/2);			
			double healthyLength = this.topToHealthy.getLength()/4;
			this.healthyBisecting = LineComputer.getLineThroughPointWithGivenSlope(this.midline.getSlope(), midpoint, healthyLength, healthyLength);
			update = Drawer.drawLine(update, healthyBisecting, PhitralDeviationPanel.bisectingColor);
			
			 //This is ugly bare with			
			double theta = this.topToAffected.getDegrees();
			
			if(this.healthyCorner.getX() < this.affectedCorner.getX())
				theta += 180;
			
			
			double x_star = this.affectedCorner.getX()+this.topToHealthy.getLength()/2*Math.cos(Math.PI/180*theta);
			double y_star = this.affectedCorner.getY()+this.topToHealthy.getLength()/2*Math.sin(Math.PI/180*theta);
			Point2D.Double desiredPoint = new Point2D.Double(x_star, y_star);
			System.out.println(desiredPoint);

			double affectedLength = this.topToHealthy.getLength()/4;
			this.affectedBisecting = LineComputer.getLineThroughPointWithGivenSlope(this.midline.getSlope(), 
					desiredPoint, affectedLength, affectedLength);
			update = Drawer.drawLine(update, affectedBisecting, PhitralDeviationPanel.bisectingColor);
			this.panel.focusStep4();
			break;
			
		case 4:
			dot = this.healthyBisecting.getClosestPointOnLine(click);
			this.healthyIntersect = dot;
			this.panel.focusStep5();
			break;
			
		case 5:
			dot = this.affectedBisecting.getClosestPointOnLine(click);
			this.affectedIntersect = dot;
			
			//Project intersections onto the midline
			// Compute distance between those projections
			Point2D.Double projectionOne = midline.getClosestPointOnLine(healthyIntersect);
			Point2D.Double projectionTwo = midline.getClosestPointOnLine(affectedIntersect);
			
			Line lineBetweenProjections = new Line(projectionOne, projectionTwo);
				 						
			this.deviation = lineBetweenProjections.getLength()/this.pxDividedByMM;
			
			this.panel.updateDeviationDisplay(deviation);
			
			this.panel.focusDeviationDisplay();
			this.activateButtons();
			break;		
		}
		
				
		update = Drawer.drawSmallDot(update, dot, PhitralDeviationPanel.dotColor);
		this.image.paintBufferedImage(update);
		
		this.stepIndex++;
	}

	public void saveData(int id, int session, boolean preIntervention,
			boolean healthySide, boolean rest) {
		try {
			MasterExcelFile file = new MasterExcelFile();
			PhiltralDeviationAnalysisSheet sheet = file.getPhiltralDeviationAnalysisSheet();
			PhiltralDeviationAnalysisEntry entry = sheet.getEntry(id, session);

			entry.setPhiltralDeviation(deviation, preIntervention, rest);
			
			sheet.addEntry(entry);
			

			file.updateSheets();
			file.closeBook();
		} catch (Exception e) {
			new ExcelErrorFrame();
		}
	}

}
