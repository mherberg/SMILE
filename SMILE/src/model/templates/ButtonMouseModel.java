package model.templates;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;

import javax.swing.JButton;

import message.MessageListener;
import view.FocusableButtonPanel;
import view.image.ImageHolder;

/**
 *  The ButtonMouseModel is an extension of the MouseModel.
 *     A ButtonMouseModel listens to both the mouse and buttons
 *     This allows it to take measurements on an image and do things
 *     like save and reset.
 *     
 * @author Luke
 *
 */
public abstract class ButtonMouseModel extends MouseModel implements
		ActionListener {

	protected final HashSet<JButton> buttons = new HashSet<JButton>();

	/**
	 * Create a new ButtonMouseModel runs the MouseModel constructed and adds
	 * every button in the Model's display to its set of buttons
	 * 
	 * All buttons begin deactivated
	 * @param image
	 * @param listener
	 * @param panel
	 */
	public ButtonMouseModel(ImageHolder image, MessageListener listener,
			FocusableButtonPanel panel) {
		super(image, listener, panel);
		this.buttons.addAll(panel.getButtons());
		
		for(JButton button: buttons) 
			button.addActionListener(this);
		
		this.deactivateButtons();
	}

	/**
	 * When unfocusing, unfocus the MousePanel and deactivate the buttons;
	 */
	public void unfocus() {
		super.unfocus();
		this.deactivateButtons();
	}

	// No change is made to the focus() method. By choice the buttons are not
	//    activated when a Model is focused
	
	
	
	/**
	 * Add the Model to every button's action listener in its display
	 */
	protected void activateButtons() {
		for (JButton button : this.buttons) 
			button.setEnabled(true);		
	}

	/**
	 * Remove the Model from every button's action listener in its display
	 */
	protected void deactivateButtons() {
		for (JButton button : this.buttons) 
			button.setEnabled(false);
	}

	
	/**
	 * When it hears an action, make sure it comes from its buttons
	 * Then find what type of button was clicked and ask the model
	 * to act accordingly
	 */
	public void actionPerformed(ActionEvent e) {
		boolean containedButton = false;

		JButton source = (JButton) e.getSource();

		for (JButton button : this.buttons) {
			if (button.equals(source)) {
				containedButton = true;
				break;
			}
		}

		if (containedButton) {
			String button = source.getText();
			handleButton(button);
		} else {
			throw new RuntimeException(
					"This class is listening in on a button it shouldn't be connected to");
		}

	}

	/**
	 * Every ButtonMouseModel must be able to handle a button action from a certain button
	 * @param button
	 */
	protected abstract void handleButton(String button);
}
