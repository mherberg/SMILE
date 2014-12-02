package model;

import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import message.Message;
import message.MessageListener;
import model.templates.MeasureButtonModel;
import util.excelio.BrowPositionAnalysisEntry;
import util.excelio.BrowPositionAnalysisSheet;
import util.excelio.ExcelSaver;
import util.excelio.EyeLidAnalysisEntry;
import util.excelio.EyeLidAnalysisSheet;
import util.excelio.MasterExcelFile;
import util.graphics.Drawer;
import util.graphics.EyeCropper;
import util.math.Line;
import view.FocusableButtonPanel;
import view.frame.ExcelErrorFrame;
import view.frame.SaveDataFrame;
import view.frame.ZoomFrame;
import view.image.ImageHolder;
import view.panel.LidBrowAnalysisPanel;

/**
 * The LidBrowAnalysisModel is used to compute the position of the
 * inferior lid, superior lid, and the brow
 * 
 * The LidBrowAnalysis asks the user to select an eye. A blow up
 * frame is then created, using the LidBrowAnalysisZoomModel.
 * 
 * Once the LidBrowAnalysisZoomModel is loaded, the LidBrowAnalysisModel
 * will wait until the LidBrowAnalysisZoomModel is finished
 * 
 * After the LidBrowAnalysisZoomModel finishs, the LidBrowAnalysisModel
 * will display the values to the user
 * 
 * @author Luke
 *
 */
public class LidBrowAnalysisModel extends MeasureButtonModel implements
		ActionListener, MessageListener, ExcelSaver {

	private static final LidBrowAnalysisPanel panel = new LidBrowAnalysisPanel();
	private LidBrowAnalysisZoomModel zoomWorker;

	private Point2D.Double center;
	private java.lang.Double brow = null;
	private java.lang.Double superior = null;
	private java.lang.Double inferior = null;


	public LidBrowAnalysisModel(ImageHolder image, MessageListener listener) {
		super(image, listener, LidBrowAnalysisModel.panel);

	}

	public void handleMessage(Message e) {

		if (e.getType() == Message.EYE_MEASURED) {

			this.center = this.zoomWorker.getCenter();
			Line browLine = new Line(this.zoomWorker.getBrow(), this.center);
			Line superiorLine = new Line(this.zoomWorker.getUpperLid(),
					this.center);
			Line inferiorLine = new Line(this.zoomWorker.getBottomLid(),
					this.center);

			this.brow = browLine.getLength() / pxDividedByMM;
			this.superior = superiorLine.getLength() / pxDividedByMM;
			this.inferior = inferiorLine.getLength() / pxDividedByMM;

			LidBrowAnalysisModel.panel.updateFields(this.brow, this.superior,
					this.inferior);

			BufferedImage updateImage = this.image.getScaledBufferedImage();
			updateImage = Drawer.drawSmallDot(updateImage, this.zoomWorker
					.getCenter(), LidBrowAnalysisPanel.dotColor);
			updateImage = Drawer.drawSmallDot(updateImage, this.zoomWorker
					.getBrow(), LidBrowAnalysisPanel.dotColor);
			updateImage = Drawer.drawSmallDot(updateImage, this.zoomWorker
					.getBottomLid(), LidBrowAnalysisPanel.dotColor);
			updateImage = Drawer.drawSmallDot(updateImage, this.zoomWorker
					.getUpperLid(), LidBrowAnalysisPanel.dotColor);

			this.image.paintBufferedImage(updateImage);
			this.image.repaint();

			this.activateButtons();
		}

		if (e.getType() == Message.EYE_NOT_MEASURED) {
			LidBrowAnalysisModel.panel.unfocus();
			this.focus(leftIris, rightIris, midline, pxDividedByMM);
		}
	}

	
	public void unfocus() {
		super.unfocus();
		this.zoomWorker = null;
	}

	
	/**
	 * Wait for the first click, then blowup the closest eye with
	 * the blown up image centered at the center of the eye.
	 * 
	 */
	protected void handleMouseClick(Point2D.Double click) {

		this.deactivate();

		//Find the closest eye
		double distanceFromLeftIris = Math.sqrt(Math.pow(this.leftIris.getCenter().getX()
				- click.getX(), 2)
				+ Math.pow(this.leftIris.getCenter().getY() - click.getY(), 2));

		double distanceFromRightIris = Math.sqrt(Math.pow(this.rightIris.getCenter().getX()
				- click.getX(), 2)
				+ Math.pow(this.rightIris.getCenter().getY() - click.getY(), 2));
		
		Point2D.Double centerOfEye;		
		if(distanceFromLeftIris < distanceFromRightIris)
			centerOfEye = this.leftIris.getCenter();
		else
			centerOfEye = this.rightIris.getCenter();
		
		
		// Create a blow up frame around the closest eye
		double scale = this.image.getOriginalDividedByScaledWidth();
		Point2D.Double scaledClick = new Point2D.Double(centerOfEye.getX()*scale,
				centerOfEye.getY()*scale);
		
		BufferedImage eyeBlowUp = EyeCropper.getEyeSubImage(this.image.getOriginalBufferedImage(), scaledClick);
		ImageHolder eye = new ImageHolder(eyeBlowUp, ZoomFrame.zoomWidth);
		
		this.zoomWorker = new LidBrowAnalysisZoomModel(eye, centerOfEye, scale, this.midline, this);
		
	}

	
	/**
	 * 2 Buttons to listen to:
	 * 
	 * Reselect - clear everything and start over
	 * Save - save data to Excel
	 */
	protected void handleButton(String button) {

		if (button.equals(FocusableButtonPanel.reselect)) {			
			this.deactivate();
			this.deactivateButtons();
			this.activate();
			this.image.paintBufferedImage(this.cleanImage);
		}

		if (button.equals(FocusableButtonPanel.save)) {
			new SaveDataFrame(this);
		}
	}

	/**
	 * Save data to the Excel file
	 */
	public void saveData(int id, int session, boolean preIntervention,
			boolean healthySide, boolean rest) {


		try {
			MasterExcelFile file = new MasterExcelFile();
			EyeLidAnalysisSheet eyeLidAnalysisSheet = file.getEyeLidAnalysisSheet();
			EyeLidAnalysisEntry eyeLidAnalysisEntry = eyeLidAnalysisSheet.getEntry(id, session);

			eyeLidAnalysisEntry.setLowerLid(inferior, preIntervention, healthySide, rest);
			eyeLidAnalysisEntry.setUpperLid(superior, preIntervention, healthySide, rest);
		
			eyeLidAnalysisSheet.addEntry(eyeLidAnalysisEntry);
			
			BrowPositionAnalysisSheet browPositionAnalysisSheet = file.getBrowPositionAnalysisSheet();
			BrowPositionAnalysisEntry browPositionAnalysisEntry = browPositionAnalysisSheet.getEntry(id, session);
			browPositionAnalysisEntry.setBrowExcursion(brow, preIntervention, healthySide, rest);
			browPositionAnalysisSheet.addEntry(browPositionAnalysisEntry);

			file.updateSheets();
			file.closeBook();
		} catch (Exception e) {
			new ExcelErrorFrame();
		}
	}

}
