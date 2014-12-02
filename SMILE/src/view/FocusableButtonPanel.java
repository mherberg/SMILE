package view;

import java.util.HashSet;

import javax.swing.JButton;

public abstract class FocusableButtonPanel extends FocusablePanel {

	private static final long serialVersionUID = 9118703805221099652L;
	protected final HashSet<JButton> buttons = new HashSet<JButton>();
	protected boolean areButtonsFocused = false;

	public static final String reset = "Reset";
	public static final String done = "Done";
	public static final String measure = "Measure";

	public static final String save = "Save";
	public static final String reselect = "Reselect";

	public HashSet<JButton> getButtons() {
		return this.buttons;
	}
}
