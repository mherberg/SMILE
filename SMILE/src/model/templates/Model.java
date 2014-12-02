package model.templates;

import java.awt.image.BufferedImage;
import java.util.HashSet;

import javax.swing.JPanel;

import message.Message;
import message.MessageListener;
import view.FocusablePanel;
import view.image.ImageHolder;


/**
 *  Generic Model class
 *  	A model will take in information and run some sort of process on it
 *      Each model is paired with some sort of display (panel or frame) which will display
 *      the end result to the user
 *      
 * @author Luke
 *
 */
public abstract class Model {

	protected ImageHolder image;
	protected final HashSet<MessageListener> listeners = new HashSet<MessageListener>();
	protected final FocusablePanel panel;
	
	//Before anything is drawn on an image, the original clean version of it is saved so every action can be reversed
	protected BufferedImage cleanImage;

	/**
	 * Every model class will contain an image they are manipulating
	 *  			 				   a set of listeners waiting for them to do something
	 *  							   and a panel which displays information
	 * @param image
	 * @param listener
	 * @param panel
	 */
	public Model(ImageHolder image, MessageListener listener,
			FocusablePanel panel) {
		this.image = image;
		this.listeners.add(listener);
		this.panel = panel;

		// Initialize every panel as unfocused
		this.panel.unfocus();
	}

	/**
	 * Focusing a model will focus its panel and reset its clean image (the image before any sort of manipulation)
	 */
	public void focus() {
		this.panel.focus();
		this.cleanImage = this.image.getScaledBufferedImage();
	}

	public void unfocus() {
		this.panel.unfocus();
	}

	protected void notifyListeners(Message e) {
		for (MessageListener listener : this.listeners) {
			listener.handleMessage(e);
		}
	}

	public JPanel getPanel() {
		return this.panel;
	}

}
