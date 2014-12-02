package steps;

import javax.swing.JPanel;

import message.Message;
import message.MessageListener;
import model.LidBrowAnalysisModel;
import util.math.Circle;
import util.math.Line;
import view.image.ImageHolder;
import view.instructions.EyeAnalysisInstructions;

public class EyeAnalysisSteps implements Steps, MessageListener {

	private final LidBrowAnalysisModel browSuperiorInferiorWorker;
	private final EyeAnalysisInstructions instructions;
	private Circle leftIris;
	private Circle rightIris;
	private Line midline;
	private double pixelsDividedByMM;

	public EyeAnalysisSteps(ImageHolder image) {
		this.browSuperiorInferiorWorker = new LidBrowAnalysisModel(image, this);
		this.instructions = new EyeAnalysisInstructions(
				browSuperiorInferiorWorker.getPanel());
	}

	public JPanel getInstructions() {
		return this.instructions;
	}

	public void handleMessage(Message e) {
		// TODO Auto-generated method stub

	}

	public void focus(Circle leftIris, Circle rightIris, Line midline,
			double pixelsDividedByMM) {

		this.leftIris = leftIris;
		this.rightIris = rightIris;

		this.pixelsDividedByMM = pixelsDividedByMM;
		this.midline = midline;

		this.nextStep();
	}

	public void unfocus() {
		this.browSuperiorInferiorWorker.unfocus();
	}

	public void nextStep() {

		this.browSuperiorInferiorWorker.focus(leftIris, rightIris, midline,
				pixelsDividedByMM);
	}

}
