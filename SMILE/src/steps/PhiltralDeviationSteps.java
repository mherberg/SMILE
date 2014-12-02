package steps;

import javax.swing.JPanel;

import message.Message;
import message.MessageListener;
import model.PhiltralDeviationModel;
import util.math.Circle;
import util.math.Line;
import view.image.ImageHolder;
import view.instructions.PhiltralDeviationInstructions;

public class PhiltralDeviationSteps implements Steps, MessageListener {

	private final PhiltralDeviationModel model;
	private final PhiltralDeviationInstructions instructions;

	public PhiltralDeviationSteps(ImageHolder image) {
		this.model = new PhiltralDeviationModel(image, this);
		this.instructions = new PhiltralDeviationInstructions(
				model.getPanel());
	}

	public JPanel getInstructions() {
		return this.instructions;
	}

	public void focus(Circle leftIris, Circle rightIris, Line midline,
			double pixelsDividedByMM) {

		this.model.focus(leftIris, rightIris, midline,
				pixelsDividedByMM);
	}

	public void unfocus() {
		this.model.unfocus();
	}

	public void handleMessage(Message e) {
		// TODO write something here

	}
}
