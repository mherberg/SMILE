package steps;

import javax.swing.JPanel;

import message.Message;
import message.MessageListener;
import model.LipModel;
import util.math.Circle;
import util.math.Line;
import view.image.ImageHolder;
import view.instructions.LipInstructions;

public class LipSteps implements Steps, MessageListener {

	private final LipModel model;
	private final LipInstructions instructions;

	public LipSteps(ImageHolder image) {
		this.model = new LipModel(image, this);
		this.instructions = new LipInstructions(
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