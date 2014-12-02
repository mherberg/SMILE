package model.templates;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.HashSet;
import java.util.Set;

import message.MessageListener;
import view.FocusablePanel;
import view.image.ImageHolder;


/**
 *  The MouseModel is an extension of the Model generic class
 *  	The MouseModel is a work which has access to mouse click
 *  
 * @author Luke
 *
 */
public abstract class MouseModel extends Model implements MouseListener {

	protected int clickCount = 0;
	protected final Set<Point2D.Double> clickLocations = new HashSet<Point2D.Double>();

	/**
	 * All MouseModels begins not listening to the mouse
	 * 
	 * @param image
	 * @param listener
	 * @param panel
	 */
	public MouseModel(ImageHolder image, MessageListener listener,
			FocusablePanel panel) {
		super(image, listener, panel);
		this.deactivate();
	}

	/**
	 *  When the mouse is clicked, update click count, save location,
	 *   and tell the model to handle the click
	 */
	public void mousePressed(MouseEvent e) {
		Point2D.Double click = new Point2D.Double(e.getX(), e.getY());
		this.clickCount++;
		this.clickLocations.add(click);
		this.handleMouseClick(click);
	}

	// Do nothing here
	public void mouseClicked(MouseEvent e) {/*Nothing*/}
	public void mouseEntered(MouseEvent e) {/*Nothing*/}
	public void mouseExited(MouseEvent e) {/*Nothing*/}
	public void mouseReleased(MouseEvent e) {/*Nothing*/}

	/**
	 *  Every MouseModel must have a handleMouseClick action which handles mouse clicks
	 * @param click
	 */
	protected abstract void handleMouseClick(Point2D.Double click);
	
	/**
	 * Let Model listen to the mouse
	 */
	protected void activate() {
		this.image.addMouseListener(this);
	}

	/**
	 * Remove the Model from the MouseListeners
	 */
	protected void deactivate() {
		this.clickCount = 0;
		this.clickLocations.clear();
		this.image.removeMouseListener(this);		
	}

	/**
	 * When ever focused, focus panel and activate the mouse
	 */
	public void focus() {
		super.focus();
		this.activate();
	}

	/**
	 * When ever unfocused; unfocs the panel and deactivate the mouse
	 */
	public void unfocus() {
		super.unfocus();
		this.deactivate();
	}

}
