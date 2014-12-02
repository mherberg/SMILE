package steps;

import java.awt.geom.Point2D;

import javax.swing.JPanel;

import message.Message;
import message.MessageListener;
import model.LipOnMidlineModel;
import model.SmileModel;
import util.math.Circle;
import util.math.Line;
import view.image.ImageHolder;
import view.instructions.SmileInstructions;

public class SmileSteps implements Steps, MessageListener {

	private final LipOnMidlineModel bottomLipEdgeOnIntercanthal;
	private final SmileModel smileMouthCorner;

	protected Circle leftIris;
	protected Circle rightIris;
	private Line midline;
	private Point2D.Double bottomLipEdge;
	private double pxDividedByMM;
	private int stepCount = 1;

	private final SmileInstructions smileStepsContainer;

	public SmileSteps(ImageHolder image) {

		this.bottomLipEdgeOnIntercanthal = new LipOnMidlineModel(image, this);
		this.smileMouthCorner = new SmileModel(image, this);
		this.smileStepsContainer = new SmileInstructions(
				this.bottomLipEdgeOnIntercanthal.getPanel(),
				this.smileMouthCorner.getPanel());
	}

	public JPanel getInstructions() {
		return this.smileStepsContainer;
	}

	public void handleMessage(Message e) {
		// TODO Auto-generated method stub

		if (e.getSource().equals(this.bottomLipEdgeOnIntercanthal)) {
			this.bottomLipEdge = this.bottomLipEdgeOnIntercanthal
					.getBottomLipEdge();
			this.nextStep();
		}
	}

	public void focus(Circle leftIris, Circle rightIris, Line midline,
			double pixelsDividedByMM) {
		this.leftIris = leftIris;
		this.rightIris = rightIris;
		this.midline = midline;
		this.pxDividedByMM = pixelsDividedByMM;

		this.bottomLipEdgeOnIntercanthal.unfocus();
		this.smileMouthCorner.unfocus();

		stepCount = 1;
		this.nextStep();
	}

	public void unfocus() {
		this.bottomLipEdgeOnIntercanthal.unfocus();
		this.smileMouthCorner.unfocus();
	}

	public void nextStep() {

		switch (stepCount) {
		case 1:
			bottomLipEdgeOnIntercanthal.focus(this.midline);
			break;
		case 2:
			smileMouthCorner.focus(leftIris, rightIris, midline, pxDividedByMM,
					bottomLipEdge);
			break;
		}
		this.stepCount++;
	}

}
