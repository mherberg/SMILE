package connector;

import java.util.HashSet;

import javax.swing.JPanel;

import message.Message;
import message.MessageListener;
import model.SelectModel;
import steps.EyeAnalysisSteps;
import steps.LipSteps;
import steps.NasalBaseAnalysisSteps;
import steps.NoSteps;
import steps.PhiltralDeviationSteps;
import steps.SmileSteps;
import steps.Steps;
import util.math.Circle;
import util.math.Line;
import view.container.MeasurementContainer;
import view.image.ImageHolder;

public class MeasurementConnector implements MessageListener {

	private final HashSet<MessageListener> listeners = new HashSet<MessageListener>();

	private final SelectModel selectMeasurementWorker;
	private final MeasurementContainer measurementContainer;
	private final ImageHolder image;

	private Steps steps;

	private Circle leftIris;
	private Circle rightIris;
	private double pxDividedByMM;
	private Line midline;

	private String selection = "none";

	public MeasurementConnector(ImageHolder image, MessageListener listener) {

		this.steps = new NoSteps();
		this.image = image;
		this.selectMeasurementWorker = new SelectModel(image, this);
		this.measurementContainer = new MeasurementContainer(
				this.selectMeasurementWorker.getPanel(), steps
						.getInstructions());

		this.listeners.add(listener);
	}

	public JPanel getContainer() {
		return this.measurementContainer;
	}

	public void focus(Circle leftIris, Circle rightIris, Line midline,
			double pxDividedByMM) {
		this.selectMeasurementWorker.focus();
		this.steps.focus(leftIris, rightIris, midline, pxDividedByMM);

		this.leftIris = leftIris;
		this.rightIris = rightIris;
		this.pxDividedByMM = pxDividedByMM;
		this.midline = midline;
	}

	public void unfocus() {
		this.steps.unfocus();		
		this.selectMeasurementWorker.unfocus();
	}

	@Override
	public void handleMessage(Message e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(this.selectMeasurementWorker)
				&& e.getType() == Message.MEASUREMENT_SELECTED) {			
						
			String selection = this.selectMeasurementWorker.getSelection();
			this.steps.unfocus();
			
			if (!selection.equals(Steps.NO_SELECTION)
					&& !selection.equals(this.selection)) {

				if (selection.equals(Steps.SMILE))
					this.steps = new SmileSteps(image);

				if (selection.equals(Steps.EYE_MEASUREMENTS))
					this.steps = new EyeAnalysisSteps(image);

				if (selection.equals(Steps.NASAL_BASE))
					this.steps = new NasalBaseAnalysisSteps(image);

				if(selection.equals(Steps.PHILTRAL_DEVIATION))
					this.steps = new PhiltralDeviationSteps(image);
				
				if(selection.equals(Steps.LIP_MEASUREMENT)) 
					this.steps = new LipSteps(image);
				
				this.measurementContainer.updateInstructions(this.steps
						.getInstructions());
				this.selection = selection;
			}

			this.steps.focus(leftIris, rightIris, midline, pxDividedByMM);
		}
	}

}
