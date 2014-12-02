package connector;

import javax.swing.JPanel;

import message.Message;
import message.MessageListener;
import model.EyeModel;
import model.LoadModel;
import model.ScaleModel;
import util.math.Circle;
import util.math.Line;
import view.container.InstrumentsContainer;
import view.image.ImageHolder;

public class InstrumentsConnector implements MessageListener {

	private final LoadModel loadWorker;
	private final EyeModel leftEyeModel;
	private final EyeModel rightEyeModel;
	private final ScaleModel scaleModel;
	private final MeasurementConnector measurementConnector;

	private final InstrumentsContainer instrumentsContainer;

	private Circle leftIris;
	private Circle rightIris;
	private double pxDividedByMM;
	private Line midline;

	public InstrumentsConnector(ImageHolder image) {

		this.loadWorker = new LoadModel(image, this);
		this.leftEyeModel = new EyeModel(image, this, false);
		this.rightEyeModel = new EyeModel(image, this, true);
		this.scaleModel = new ScaleModel(image, this);
		this.measurementConnector = new MeasurementConnector(image, this);

		this.instrumentsContainer = new InstrumentsContainer(loadWorker
				.getPanel(), leftEyeModel.getPanel(), rightEyeModel.getPanel(),
				scaleModel.getPanel(), measurementConnector.getContainer());
	}

	public JPanel getContainer() {
		return this.instrumentsContainer;
	}

	public void handleMessage(Message e) {

		if (e.getSource().equals(this.loadWorker)) {
			
			this.leftEyeModel.unfocus();
			this.rightEyeModel.unfocus();
			this.scaleModel.unfocus();
			this.measurementConnector.unfocus();
			
			this.leftEyeModel.focus();
			
		}

		if (e.getSource().equals(this.leftEyeModel)) {

			this.rightEyeModel.unfocus();
			this.measurementConnector.unfocus();

			if (e.getType() == Message.IRIS_MEASUREMENT_RESET) {
				this.leftEyeModel.focus();
			}
			if (e.getType() == Message.IRIS_MEASUREMENT_SCALED_FOUND) {
				this.leftIris = this.leftEyeModel.getIris();
				this.rightEyeModel.focus();
			}
		}

		if (e.getSource().equals(this.rightEyeModel)) {
			this.measurementConnector.unfocus();
			this.scaleModel.unfocus();

			if (e.getType() == Message.IRIS_MEASUREMENT_RESET) {
				this.rightEyeModel.focus();
			}
			if (e.getType() == Message.IRIS_MEASUREMENT_SCALED_FOUND) {
				this.rightIris = this.rightEyeModel.getIris();
				this.scaleModel.focus(this.leftIris, this.rightIris);
			}
		}

		if (e.getSource().equals(this.scaleModel)) {
			this.measurementConnector.unfocus();

			if (e.getType() == Message.SCALE_SET) {
				this.pxDividedByMM = this.scaleModel.getPixelsDividedbyMM();
				this.midline = this.scaleModel.getMidline();

				this.measurementConnector.focus(leftIris, rightIris, midline,
						pxDividedByMM);
			}
		}

	}

}
