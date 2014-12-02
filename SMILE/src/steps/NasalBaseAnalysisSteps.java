package steps;

import javax.swing.JPanel;

import message.Message;
import message.MessageListener;
import model.NasalModel;
import util.math.Circle;
import util.math.Line;
import view.image.ImageHolder;
import view.instructions.NasalBaseAnalysisInstructions;

public class NasalBaseAnalysisSteps implements Steps, MessageListener {

	private final NasalModel nasalBaseAnalysisModel;
	private final NasalBaseAnalysisInstructions instructions;

	public NasalBaseAnalysisSteps(ImageHolder image) {
		this.nasalBaseAnalysisModel = new NasalModel(image, this);
		this.instructions = new NasalBaseAnalysisInstructions(
				nasalBaseAnalysisModel.getPanel());
	}

	public JPanel getInstructions() {
		return this.instructions;
	}

	public void focus(Circle leftIris, Circle rightIris, Line midline,
			double pixelsDividedByMM) {

		this.nasalBaseAnalysisModel.focus(leftIris, rightIris, midline,
				pixelsDividedByMM);
	}

	public void unfocus() {
		this.nasalBaseAnalysisModel.unfocus();
	}

	public void handleMessage(Message e) {
		// TODO write something here

	}
}
