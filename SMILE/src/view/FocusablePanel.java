package view;

import java.awt.Color;
import java.awt.Component;
import java.util.HashSet;

import javax.swing.JPanel;

public abstract class FocusablePanel extends JPanel {

	private static final long serialVersionUID = -4102512964776510589L;
	protected final HashSet<Component> text = new HashSet<Component>();

	public void focus() {
		for (Component component : this.text) {
			component.setForeground(Color.BLACK);
		}
	}

	public void unfocus() {
		for (Component component : this.text) {
			component.setForeground(Color.GRAY);
		}
	}

}
