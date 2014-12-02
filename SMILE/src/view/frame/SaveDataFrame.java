package view.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import util.excelio.ExcelSaver;


public class SaveDataFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel savePanel = new JPanel();
	private final JLabel ID = new JLabel("ID:");
	private final JLabel session = new JLabel("Session:");
	private final JLabel prepost = new JLabel("Pre/Post:");
	private final JLabel side = new JLabel("Side:");
	private final JLabel title = new JLabel("Save to 'My Documents'");
	private final JLabel gesturelabel = new JLabel("Gesture:");

	private final JTextField idText = new JTextField();
	private final JTextField sessionText = new JTextField();

	private final JRadioButton pre = new JRadioButton("Pre-intervention");
	private final JRadioButton post = new JRadioButton("Post-intervention");
	private final JRadioButton healthy = new JRadioButton("Healthy");
	private final JRadioButton affected = new JRadioButton("Affected");
	private final JRadioButton gesture = new JRadioButton("Gesture");
	private final JRadioButton rest = new JRadioButton("Rest");

	private final JButton save = new JButton("Save");
	private final JButton cancel = new JButton("Cancel");

	private final ButtonGroup prePostGroup = new ButtonGroup();
	private final ButtonGroup sideGroup = new ButtonGroup();
	private final ButtonGroup restGroup = new ButtonGroup();

	private final ExcelSaver saver;

	private final boolean includeGesture;
	private final boolean includeIntervention;
	private final boolean includeSide;

	public SaveDataFrame(ExcelSaver saver) {
		this(saver, true, true, true);
	}

	public SaveDataFrame(ExcelSaver saver, boolean gesture,
			boolean intervention, boolean side) {
		super();

		Font f = this.title.getFont();
		this.title.setFont(f.deriveFont(f.getStyle() ^ Font.BOLD));

		this.saver = saver;

		this.add(savePanel);
		this.save.addActionListener(this);
		this.cancel.addActionListener(this);

		this.setLocation(300, 300);

		this.includeGesture = gesture;
		this.includeIntervention = intervention;
		this.includeSide = side;

		if (!this.includeGesture) {
			this.rest.setForeground(Color.GRAY);
			this.rest.setEnabled(false);
			this.gesture.setForeground(Color.GRAY);
			this.gesture.setEnabled(false);

			this.gesturelabel.setForeground(Color.GRAY);
		}

		if (!this.includeIntervention) {
			this.pre.setForeground(Color.GRAY);
			this.pre.setEnabled(false);
			this.post.setForeground(Color.GRAY);
			this.post.setEnabled(false);
			this.prepost.setForeground(Color.GRAY);
		}

		if (!this.includeSide) {
			this.healthy.setForeground(Color.GRAY);
			this.healthy.setEnabled(false);

			this.affected.setForeground(Color.GRAY);
			this.affected.setEnabled(false);
			this.side.setForeground(Color.GRAY);

		}

		createButtonGroup();
		setLayout();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(this.save)) {
			try {
				Integer session = Integer.parseInt(this.sessionText.getText());
				Integer id = Integer.parseInt(this.idText.getText());
				if (id != null
						&& session != null
						&& ((this.includeIntervention && (pre.isSelected() || post
								.isSelected())) || !this.includeIntervention)
						&& ((this.includeSide && (healthy.isSelected() || affected
								.isSelected())) || !this.includeSide)
						&& ((this.includeGesture && (rest.isSelected() || gesture
								.isSelected())) || !this.includeGesture)) {

					boolean preIntervention = pre.isSelected();
					boolean healthySide = healthy.isSelected();
					boolean atRest = rest.isSelected();

					this.saver.saveData(id, session, preIntervention,
							healthySide, atRest);

					this.setVisible(false);

				}
			} catch (NumberFormatException e1) {
				// Do nothing if incorrect number format is used
				System.err.println("Incorrect Format: ["
						+ this.session.getText()
						+ "] is not a parsable interger contained in a string");
			}
		}
		if (e.getSource().equals(this.cancel)) {
			this.setVisible(false);
		}
		// cleanSelections();
	}

	public void cleanSelections() {
		this.idText.setText(null);
		this.sessionText.setText(null);
		this.prePostGroup.clearSelection();
		this.sideGroup.clearSelection();
	}

	private void createButtonGroup() {
		prePostGroup.add(this.pre);
		prePostGroup.add(this.post);

		sideGroup.add(this.affected);
		sideGroup.add(this.healthy);

		restGroup.add(this.rest);
		restGroup.add(this.gesture);
	}

	private void setLayout() {

		this.setVisible(true);

		this.setSize(400, 247);
		this.setLocation(300, 300);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);

		this.add(savePanel);

		javax.swing.GroupLayout this1Layout = new javax.swing.GroupLayout(
				savePanel);
		savePanel.setLayout(this1Layout);
		this1Layout
				.setHorizontalGroup(this1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								javax.swing.GroupLayout.Alignment.TRAILING,
								this1Layout
										.createSequentialGroup()
										.addGap(44, 44, 44)
										.addGroup(
												this1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																this1Layout
																		.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.TRAILING)
																		.addGroup(
																				this1Layout
																						.createSequentialGroup()
																						.addGroup(
																								this1Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING)
																										.addComponent(
																												session)
																										.addComponent(
																												ID))
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addGroup(
																								this1Layout
																										.createParallelGroup(
																												javax.swing.GroupLayout.Alignment.TRAILING,
																												false)
																										.addComponent(
																												idText)
																										.addComponent(
																												sessionText,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												74,
																												Short.MAX_VALUE)))
																		.addGroup(
																				this1Layout
																						.createSequentialGroup()
																						.addComponent(
																								save)
																						.addPreferredGap(
																								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																						.addComponent(
																								cancel)))
														.addComponent(title))
										.addGap(18, 18, 18)
										.addGroup(
												this1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																this1Layout
																		.createSequentialGroup()
																		.addComponent(
																				prepost)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				72,
																				Short.MAX_VALUE)
																		.addComponent(
																				gesturelabel)
																		.addGap(
																				25,
																				25,
																				25))
														.addComponent(healthy)
														.addComponent(affected)
														.addComponent(side)
														.addGroup(
																this1Layout
																		.createSequentialGroup()
																		.addGroup(
																				this1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								pre)
																						.addComponent(
																								post))
																		.addGap(
																				12,
																				12,
																				12)
																		.addGroup(
																				this1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								rest)
																						.addComponent(
																								gesture))))
										.addGap(23, 23, 23)));
		this1Layout
				.setVerticalGroup(this1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								this1Layout
										.createSequentialGroup()
										.addGap(37, 37, 37)
										.addGroup(
												this1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.TRAILING)
														.addGroup(
																this1Layout
																		.createSequentialGroup()
																		.addGroup(
																				this1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								prepost)
																						.addComponent(
																								gesturelabel))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addGroup(
																				this1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								pre)
																						.addComponent(
																								gesture))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				this1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								post)
																						.addComponent(
																								rest))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addComponent(
																				side)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				healthy)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				affected))
														.addGroup(
																this1Layout
																		.createSequentialGroup()
																		.addComponent(
																				title)
																		.addGap(
																				18,
																				18,
																				18)
																		.addGroup(
																				this1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								idText,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								ID))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
																		.addGroup(
																				this1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								sessionText,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								session))
																		.addGap(
																				30,
																				30,
																				30)
																		.addGroup(
																				this1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								save)
																						.addComponent(
																								cancel))))
										.addContainerGap(34, Short.MAX_VALUE)));
	}

}
