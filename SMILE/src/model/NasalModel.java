package model;

import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.awt.image.BufferedImage;

import message.MessageListener;
import model.templates.MeasureButtonModel;
import util.excelio.ExcelSaver;
import util.excelio.MasterExcelFile;
import util.excelio.NasalBaseAnalysisEntry;
import util.excelio.NasalBaseAnalysisSheet;
import util.graphics.Drawer;
import view.FocusableButtonPanel;
import view.frame.ExcelErrorFrame;
import view.frame.SaveDataFrame;
import view.image.ImageHolder;
import view.panel.NasalPanel;

public class NasalModel extends MeasureButtonModel implements ActionListener,
		ExcelSaver {

	private static final NasalPanel panel = new NasalPanel();

	private Point2D.Double bottomOfNose;
	private Point2D.Double healthyNostril;
	private Point2D.Double affectedNostril;

	private double healthyDeviation;
	private double affectedDeviation;

	public NasalModel(ImageHolder image, MessageListener listener) {
		super(image, listener, panel);
	}

	protected void handleButton(String button) {
		
		if (button.equals(FocusableButtonPanel.reset)) {
			this.unfocus();
			this.deactivate();
			this.deactivateButtons();
			
			this.image.paintBufferedImage(this.cleanImage);
			this.focus();
		}

		if (button.equals(FocusableButtonPanel.save)) {
			new SaveDataFrame(this, false, true, false);
		}

	}

	protected void handleMouseClick(Double click) {

		Point2D.Double dot = click;
		
		switch (clickCount) {
		case 1:
			assert (this.midline != null);		

			this.bottomOfNose = this.midline.getClosestPointOnLine(click);
			NasalModel.panel.focusStep2();
			dot = this.bottomOfNose;

			break;
		case 2:

			this.healthyNostril = click;
			NasalModel.panel.focusStep3();

			Point2D.Double projection1 = this.midline.getClosestPointOnLine(this.healthyNostril);
			this.healthyDeviation = projection1.distance(this.bottomOfNose)/this.pxDividedByMM;			
			NasalModel.panel.updateHealthyDeviationDisplay(this.healthyDeviation);

			dot = this.healthyNostril;

			break;
		case 3:
			this.affectedNostril = click;

			Point2D.Double projection2 = this.midline.getClosestPointOnLine(this.affectedNostril);
			this.affectedDeviation = projection2.distance(this.bottomOfNose)/this.pxDividedByMM;
			NasalModel.panel.updateAffectedDeviationDisplay(this.affectedDeviation);

			dot = this.affectedNostril;

			this.activateButtons();
			break;
		default:
			// Do nothing
		}
		
		BufferedImage update = this.image.getScaledBufferedImage();		
		update = Drawer.drawSmallDot(update, dot, NasalPanel.dotColor);
		this.image.paintBufferedImage(update);

	}

	public void saveData(int id, int session, boolean preIntervention,
			boolean healthySide, boolean rest) {

		try {
			MasterExcelFile file = new MasterExcelFile();
			NasalBaseAnalysisSheet sheet = file.getNasalBaseAnalysisSheet();
			NasalBaseAnalysisEntry entry = sheet.getEntry(id, session);

			entry.setDeviation(this.healthyDeviation - this.affectedDeviation,
					preIntervention);
			sheet.addEntry(entry);

			file.updateSheets();
			file.closeBook();
		} catch (Exception e) {
			new ExcelErrorFrame();
		}

	}

}
