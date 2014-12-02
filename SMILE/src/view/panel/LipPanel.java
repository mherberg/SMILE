package view.panel;

import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.FocusableButtonPanel;

public class LipPanel extends FocusableButtonPanel{
	

	private static final long serialVersionUID = 1L;

	private final JLabel step1 = new JLabel("Step 1:");
	private final JLabel instruct11 = new JLabel("- Click midline of upper lip");
	private final JLabel instruct12 = new JLabel("- Click midline of lower lip");
	
	private final JLabel step2 = new JLabel("Step 2:");
	private final JLabel instruct21 = new JLabel("- Click corner of non-paralyzed lip");
	private final JLabel instruct22 = new JLabel("- Click bisector (red) line at top of the upper lip");
	private final JLabel instruct23 = new JLabel("- Click bisector (red) line at bottom of the lower lip");
	private final JLabel instruct24 = new JLabel("lower lip");
	
	private final JLabel step3 = new JLabel("Step 3:");
	private final JLabel instruct31 = new JLabel("-Click corner of affected lip");
	private final JLabel instruct32 = new JLabel("-Click bisector (red) line at the top of upper lip");
	private final JLabel instruct33 = new JLabel("-Click bisector (red) line at the bottom of the lower lip");
	private final JLabel instruct34 = new JLabel("lower lip");
	
	final JLabel cornerDeviationLabel = new JLabel("Deviation:");
	final JLabel lowerLipDeviationLabel = new JLabel("Deviation:");
	final JLabel upperLipDeviationLabel = new JLabel("Deviation:");
	
	private final JButton save = new JButton("Save");
	private final JButton reset = new JButton("Reset");	
	
	private final String defaultValue = "0 mm";
	private final JTextField cornerDeviation = new JTextField(defaultValue);
	private final JTextField upperLipDeviation = new JTextField(defaultValue);
	private final JTextField lowerLipDeviation = new JTextField(defaultValue);

	public static final Color dotColor = Color.YELLOW;
	public static final Color lineColor = Color.BLUE;
	public static final Color bisectingLineColor = Color.RED;

	public LipPanel() {
		super();

		this.text.add(step1);
		this.text.add(instruct11);
		this.text.add(instruct12);
		
		this.text.add(step2);
		this.text.add(instruct21);
		this.text.add(instruct22);
		this.text.add(instruct23);
		this.text.add(instruct24);
		
		this.text.add(step3);
		this.text.add(instruct31);
		this.text.add(instruct32);
		this.text.add(instruct33);
		this.text.add(instruct34);
		
		this.text.add(cornerDeviationLabel);
		this.text.add(upperLipDeviationLabel);
		this.text.add(lowerLipDeviationLabel);
		
		this.text.add(cornerDeviation);
		this.text.add(upperLipDeviation);
		this.text.add(lowerLipDeviation);
		
		this.buttons.add(save);
		this.buttons.add(reset);
		
		this.unfocus();
		setLayout();
	}

	public void focus() {
		super.unfocus();
		focusStep1();
	}

	public void focusStep1() {
		this.step1.setForeground(Color.BLACK);
		this.instruct11.setForeground(Color.BLACK);
		this.instruct12.setForeground(Color.BLACK);
	}


	public void focusStep2() {
		this.step2.setForeground(Color.BLACK);
		this.instruct21.setForeground(Color.BLACK);
		this.instruct22.setForeground(Color.BLACK);
		this.instruct23.setForeground(Color.BLACK);
		this.instruct24.setForeground(Color.BLACK);
	}
	
	public void focusStep3() {
		this.step3.setForeground(Color.BLACK);
		this.instruct31.setForeground(Color.BLACK);
		this.instruct32.setForeground(Color.BLACK);
		this.instruct33.setForeground(Color.BLACK);
		this.instruct34.setForeground(Color.BLACK);
	}

	public void focusDeviationDisplay() {
		this.cornerDeviationLabel.setForeground(Color.BLACK);
		this.cornerDeviation.setForeground(Color.BLACK);
		this.lowerLipDeviationLabel.setForeground(Color.BLACK);
		this.lowerLipDeviation.setForeground(Color.BLACK);
		this.upperLipDeviationLabel.setForeground(Color.BLACK);
		this.upperLipDeviation.setForeground(Color.BLACK);
		
	}
	
	public void updateDeviationDisplay(double cornerDeviation, double lowerDeviation, double upperDeviation) {
		DecimalFormat format = new DecimalFormat("#########.##");
		this.cornerDeviation.setText(format.format(cornerDeviation) + " mm");
		this.lowerLipDeviation.setText(format.format(lowerDeviation) + " mm");
		this.upperLipDeviation.setText(format.format(upperDeviation) + " mm");
	}
	
	private void setLayout() { javax.swing.GroupLayout this1Layout = new javax.swing.GroupLayout(this);

	this.setLayout(this1Layout);
     this1Layout.setHorizontalGroup(
         this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(this1Layout.createSequentialGroup()
             .addContainerGap()
             .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addGroup(this1Layout.createSequentialGroup()
                     .addGap(21, 21, 21)
                     .addComponent(save)
                     .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                     .addComponent(reset)
                     .addContainerGap())
                 .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(this1Layout.createSequentialGroup()
                         .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(step1)
                             .addComponent(step3)
                             .addGroup(this1Layout.createSequentialGroup()
                                 .addGap(10, 10, 10)
                                 .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                     .addComponent(instruct31)
                                     .addComponent(instruct32)
                                     .addGroup(this1Layout.createSequentialGroup()
                                         .addGap(24, 24, 24)
                                         .addComponent(instruct34))
                                     .addComponent(instruct33)))
                             .addGroup(this1Layout.createSequentialGroup()
                                 .addGap(8, 8, 8)
                                 .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                     .addComponent(instruct12)
                                     .addComponent(instruct11)))
                             .addComponent(step2)
                             .addGroup(this1Layout.createSequentialGroup()
                                 .addGap(10, 10, 10)
                                 .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                     .addComponent(instruct21)
                                     .addComponent(instruct22)
                                     .addComponent(instruct23)
                                     .addGroup(this1Layout.createSequentialGroup()
                                         .addGap(24, 24, 24)
                                         .addComponent(instruct24)))))
                         .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, this1Layout.createSequentialGroup()
                         .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(upperLipDeviationLabel)
                             .addComponent(lowerLipDeviationLabel)
                             .addComponent(cornerDeviationLabel))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                             .addComponent(cornerDeviation)
                             .addComponent(upperLipDeviation)
                             .addComponent(lowerLipDeviation, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                         .addContainerGap(45, Short.MAX_VALUE)))))
     );
     this1Layout.setVerticalGroup(
         this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGroup(this1Layout.createSequentialGroup()
             .addComponent(step1)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addComponent(instruct11)
             .addGap(4, 4, 4)
             .addComponent(instruct12)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
             .addComponent(step2)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addComponent(instruct21)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addComponent(instruct22)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addComponent(instruct23)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addComponent(instruct24)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addComponent(step3)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addComponent(instruct31)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addComponent(instruct32)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addComponent(instruct33)
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addComponent(instruct34)
             .addGap(18, 18, 18)
             .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                 .addComponent(cornerDeviationLabel)
                 .addComponent(cornerDeviation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                 .addComponent(upperLipDeviationLabel)
                 .addComponent(upperLipDeviation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                 .addComponent(lowerLipDeviationLabel)
                 .addComponent(lowerLipDeviation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
             .addGap(18, 18, 18)
             .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                 .addComponent(save)
                 .addComponent(reset))
             .addContainerGap(47, Short.MAX_VALUE))
     );
	}

}
