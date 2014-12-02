package model;

import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

import message.Message;
import message.MessageListener;
import model.templates.ButtonMouseModel;
import util.graphics.Drawer;
import util.graphics.EyeCropper;
import util.math.Circle;
import view.frame.ZoomFrame;
import view.image.ImageHolder;
import view.panel.EyePanel;

/**
 *  An EyeModel is a Model which helps find the iris
 *  
 *  The user is asked to click on the patient's eye which triggers
 *  a FindIrisModel. The EyeModel then waits for the FindIrisModel to
 *  return a circle which corresponds to the patient's eye.
 *  
 *  The EyeModel will draw the returned circle on the image, outline the patients iris.
 *  
 *  In general, two of these Models will be used, one to find the left iris, one for the right.
 *  
 *  
 * @author Luke
 *
 */
public class EyeModel extends ButtonMouseModel implements MessageListener {
	
	private FindIrisModel findIrisModel;
	private Circle iris;

	public EyeModel(ImageHolder image, MessageListener listener, boolean side) {
		super(image, listener, new EyePanel(side));		
	}

	/**
	 * An EyeModel should only receive IRIS_CALCULATED or IRIS_NOT_CALCULATED messages
	 * If IRIS_NOT_CALCULATED, then retry
	 * If IRIS_CALCULATED, then save the iris information and notify upstream listeners
	 * 		the deed is done
	 */
	public void handleMessage(Message e) {

		if (e.getSource().equals(this.findIrisModel)) {

			if (e.getType() == Message.IRIS_CALCULATED) {
				Circle iris = this.findIrisModel.getScaledIris();
				this.setIris(iris);
				this.deactivate();
				this.activateButtons();
				this.findIrisModel = null;
			}

			if (e.getType() == Message.IRIS_NOT_CALCULATED) {
				this.activate();
			}

		}
	}

	/**
	 * Only one button to listen for, RESET.
	 * If clicked, then clean the image and start over
	 */
	protected void handleButton(String button) {	
		
		this.image.paintBufferedImage(this.cleanImage);			
		notifyListeners(new Message(this, Message.IRIS_MEASUREMENT_RESET));
		
	}

	/**
	 * Save the iris
	 * Draw the iris
	 * Notify listeners
	 * @param iris
	 */
	private void setIris(Circle iris) {

		this.iris = iris;
		BufferedImage circleImage = Drawer.drawCircle(this.image.getScaledBufferedImage(), iris, EyePanel.dotColor);
		this.image.paintBufferedImage(circleImage);

		notifyListeners(new Message(this, Message.IRIS_MEASUREMENT_SCALED_FOUND));

	}

	public Circle getIris() {
		assert (this.iris != null && this.iris.isCircle());
		return this.iris;
	}

	/**
	 * When the image is clicked, create a subimage which attempts to cut
	 * down the whole image into just the eye.
	 * 
	 * Send this subimage to a FindIrisModel and wait for it to get back
	 */
	protected void handleMouseClick(Point2D.Double click) {
		this.deactivate();
		
		double scale = this.image.getOriginalDividedByScaledWidth();
		Point2D.Double scaledClick = new Point2D.Double(click.getX()*scale,
				click.getY()*scale);		
		BufferedImage eyeBlowUp = EyeCropper.getEyeSubImage(this.image.getOriginalBufferedImage(), scaledClick);
		ImageHolder eye = new ImageHolder(eyeBlowUp, ZoomFrame.zoomWidth);
		
		this.findIrisModel = new FindIrisModel(eye, scaledClick, scale, this);
	}

}