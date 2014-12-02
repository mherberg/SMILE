package model.templates;

import message.MessageListener;
import util.math.Circle;
import util.math.Line;
import view.FocusableButtonPanel;
import view.image.ImageHolder;

/**
 * The MeasureButtonModel is an extension of the ButtonMouseModel
 * 		A MeasureButtonModel is like a ButtonMouseModel, but it contains
 * 		information about the image. This information is the location of
 * 		both eyes, the midline, and the ratio of pixels to mm.
 * 
 * There is a MeasureButtonModel and MeasureMouseModel because there are
 * both ButtonMouseModels and MouseModels which have this information.
 * These classes may be removed in the future.
 * 
 * @author Luke
 *
 */
public abstract class MeasureButtonModel extends ButtonMouseModel {

	protected Circle leftIris;
	protected Circle rightIris;
	protected Line midline;
	protected double pxDividedByMM;

	public MeasureButtonModel(ImageHolder image, MessageListener listener,
			FocusableButtonPanel panel) {
		super(image, listener, panel);
	}

	public void focus(Circle leftIris, Circle rightIris, Line midline,
			double pxDividedByMM) {
		super.focus();

		this.leftIris = leftIris;
		this.rightIris = rightIris;
		this.midline = midline;
		this.pxDividedByMM = pxDividedByMM;

	}

}
