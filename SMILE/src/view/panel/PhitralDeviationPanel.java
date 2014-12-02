package view.panel;

import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.FocusableButtonPanel;

public class PhitralDeviationPanel extends FocusableButtonPanel{
	

	private static final long serialVersionUID = 1L;

	private final JLabel step1 = new JLabel("Step 1:");
	private final JLabel step11 = new JLabel("-Select where the upper lip intersects");
	private final JLabel step12 = new JLabel("the midline");
	private final JLabel step2 = new JLabel("Step 2:");
	private final JLabel step21 = new JLabel("-Select the healthy corner of the mouth");
	private final JLabel step3 = new JLabel("Step 3:");
	private final JLabel step31 = new JLabel("-Select the affected corner of the mouth");
	private final JLabel step4 = new JLabel("Step 4:");
	private final JLabel step41 = new JLabel("-Select the point where the drop down");
	private final JLabel step42 = new JLabel("line meets the flesh of the healthy lip");
	private final JLabel step5 = new JLabel("Step 5:");
	private final JLabel step51 = new JLabel("-Select the point where the drop down");
	private final JLabel step52 = new JLabel("line meets the flesh of the affected lip");
	private final JLabel deviation = new JLabel("Deviation:");
	
	private final JButton save = new JButton("Save");
	private final JButton reset = new JButton("Reset");	
	
	private final String defaultValue = "0 mm";
	private final JTextField deviationField = new JTextField(defaultValue);

	public static final Color dotColor = Color.YELLOW;
	public static final Color cornerToTopColor = Color.BLUE;
	public static final Color bisectingColor = Color.RED;

	public PhitralDeviationPanel() {
		super();

		this.text.add(step1);
		this.text.add(step11);
		this.text.add(step12);
		this.text.add(step2);
		this.text.add(step21);
		this.text.add(step3);
		this.text.add(step31);
		this.text.add(step4);
		this.text.add(step41);
		this.text.add(step42);
		this.text.add(step5);
		this.text.add(step51);
		this.text.add(step52);
		this.text.add(deviation);
		this.text.add(deviationField);
		
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
		this.step11.setForeground(Color.BLACK);
		this.step12.setForeground(Color.BLACK);
	}

	public void focusStep2() {
		this.step2.setForeground(Color.BLACK);
		this.step21.setForeground(Color.BLACK);
	}

	public void focusStep3() {
		this.step3.setForeground(Color.BLACK);
		this.step31.setForeground(Color.BLACK);		
	}
	
	public void focusStep4() {
		this.step4.setForeground(Color.BLACK);
		this.step41.setForeground(Color.BLACK);
		this.step42.setForeground(Color.BLACK);
	}
	
	public void focusStep5() {
		this.step5.setForeground(Color.BLACK);
		this.step51.setForeground(Color.BLACK);
		this.step52.setForeground(Color.BLACK);
	}

	public void focusDeviationDisplay() {
		this.deviation.setForeground(Color.BLACK);
		this.deviationField.setForeground(Color.BLACK);
		
	}
	
	public void updateDeviationDisplay(double deviation) {
		DecimalFormat format = new DecimalFormat("#########.##");
		this.deviationField.setText(format.format(deviation) + " mm");
	}
	
	private void setLayout() { javax.swing.GroupLayout this1Layout = new javax.swing.GroupLayout(this);
    this.setLayout(this1Layout);
    this1Layout.setHorizontalGroup(
        this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, this1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(step1)
                .addGroup(this1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(this1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(step12))
                        .addComponent(step11)))
                .addGroup(this1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(step31))
                .addGroup(this1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(step21))
                .addComponent(step2)
                .addComponent(step3)
                .addComponent(step4)
                .addGroup(this1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(this1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(step42))
                        .addComponent(step41)))
                .addComponent(step5)
                .addGroup(this1Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(step51)
                        .addGroup(this1Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(step52)))))
            .addContainerGap())
        .addGroup(this1Layout.createSequentialGroup()
            .addGap(43, 43, 43)
            .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(save)
                .addComponent(deviation))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(deviationField)
                .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap(55, Short.MAX_VALUE))
    );
    this1Layout.setVerticalGroup(
        this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(this1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(step1)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(step11)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(step12)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(step2)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(step21)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(step3)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(step31)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(step4)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(step41)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(step42)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(step5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(step51)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(step52)
            .addGap(12, 12, 12)
            .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(deviationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(deviation))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(this1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(save)
                .addComponent(reset))
            .addContainerGap(19, Short.MAX_VALUE))
    );
	}

}
