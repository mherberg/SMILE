package view.panel;

import javax.swing.JButton;
import javax.swing.JComboBox;

import view.FocusablePanel;


public class SelectPanel extends FocusablePanel {

	private static final long serialVersionUID = 1L;
	private final String measure = "Measure";
	private final String reset = "Reset";
	private final JComboBox measurementComboBox = new JComboBox();
	private final JButton measurementButton = new JButton(measure);

	public SelectPanel() {
		super();
		
		this.text.add(measurementComboBox);
		this.text.add(measurementButton);		
		
		unfocus();	
		setLayout();
	}

	public JButton getButton() {
		return this.measurementButton;
	}
	
	public JComboBox getComboBox() {
		return this.measurementComboBox;
	}

	public void addItem(String item) {
		this.measurementComboBox.addItem(item);
	}

	public String getSelectedItem() {
		return (String) this.measurementComboBox.getSelectedItem();
	}


	public void redo() {
		this.measurementButton.setText(this.reset);
	}

	public void unfocus() {
		super.unfocus();
		this.measurementButton.setText(this.measure);
	}

	private void setLayout() {

		javax.swing.GroupLayout selectMeasurementPanelLayout = new javax.swing.GroupLayout(
				this);
		this.setLayout(selectMeasurementPanelLayout);
		selectMeasurementPanelLayout
				.setHorizontalGroup(selectMeasurementPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								selectMeasurementPanelLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												measurementComboBox,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												124,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												29, Short.MAX_VALUE)
										.addComponent(
												measurementButton,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												73,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		selectMeasurementPanelLayout
				.setVerticalGroup(selectMeasurementPanelLayout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								selectMeasurementPanelLayout
										.createSequentialGroup()
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addGroup(
												selectMeasurementPanelLayout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																measurementComboBox,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																measurementButton))
										.addGap(36, 36, 36)));
	}
}
