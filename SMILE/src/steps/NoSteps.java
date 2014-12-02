package steps;

import javax.swing.JPanel;

import util.math.Circle;
import util.math.Line;
import view.instructions.NoInstructions;


public class NoSteps implements Steps {

	private final NoInstructions noMeasurementSelectedPanel;

	public NoSteps() {
		this.noMeasurementSelectedPanel = new NoInstructions();
	}

	public JPanel getInstructions() {
		return this.noMeasurementSelectedPanel;
	}

	public void focus(Circle leftIris, Circle rightIris, Line midline,
			double pixelsDividedByMM) {
		// TODO Auto-generated method stub
		// No steps, do nothing
		this.noMeasurementSelectedPanel.focus();
	}

	public void unfocus() {
		this.noMeasurementSelectedPanel.unfocus();
	}

}
