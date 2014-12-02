package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;

import message.Message;
import message.MessageListener;
import model.templates.Model;
import steps.Steps;
import view.image.ImageHolder;
import view.panel.SelectPanel;

/**
 * 
 * 		A SelectModel allows the user to select different types of measurements.
 * 
 * @author Luke
 *
 */
public class SelectModel extends Model implements ActionListener {

	private static final SelectPanel panel = new SelectPanel();
	private final JButton measure;
	private final JComboBox comboBox;
	private String selection;

	public SelectModel(ImageHolder image, MessageListener listener) {
		super(image, listener, SelectModel.panel);

		//
		// IF ADDING ANOTHER ITEM TO DROP DOWN LIST
		// ALTER MeasurementConnector AS WELL IN THE
		// public void handleMessage(Message e)
		// FUNCTION 
		//
		
		SelectModel.panel.addItem(Steps.NO_SELECTION);
		SelectModel.panel.addItem(Steps.SMILE);
		SelectModel.panel.addItem(Steps.EYE_MEASUREMENTS);
		SelectModel.panel.addItem(Steps.NASAL_BASE);
		SelectModel.panel.addItem(Steps.PHILTRAL_DEVIATION);
		SelectModel.panel.addItem(Steps.LIP_MEASUREMENT);

		this.measure = SelectModel.panel.getButton();
		this.comboBox = SelectModel.panel.getComboBox();
		
		this.measure.addActionListener(this);
		this.unfocus();
	}

	public void actionPerformed(ActionEvent arg0) {

		String selection = SelectModel.panel.getSelectedItem();
		if (arg0.getSource().equals(this.measure)) {

			this.selection = selection;
			SelectModel.panel.redo();
			this.image.paintBufferedImage(this.cleanImage);
			notifyListeners(new Message(this, Message.MEASUREMENT_SELECTED));

		}
	}

	public void focus() {
		super.focus();
		this.comboBox.setEnabled(true);
		this.measure.setEnabled(true);
	}

	public void unfocus() {
		super.unfocus();
		this.comboBox.setEnabled(false);
		this.measure.setEnabled(false);
	}

	public String getSelection() {
		return this.selection;
	}

}
