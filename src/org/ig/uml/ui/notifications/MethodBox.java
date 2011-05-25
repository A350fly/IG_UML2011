package org.ig.uml.ui.notifications;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MethodBox extends JComponent {

	private static final long serialVersionUID = -7604193805166351437L;
	
	private Box box;
	private JButton addParameter;
	private JLabel label;
	private JTextField nameField;
	
	public MethodBox(String labelName) {
		label = new JLabel(labelName);
		nameField = new JTextField(15);
		addParameter = new JButton("+");
		box = Box.createVerticalBox();
		
		Box hbox = Box.createHorizontalBox();
		hbox.add(Box.createHorizontalStrut(20));
		hbox.add(label);
		hbox.add(Box.createHorizontalStrut(10));
		hbox.add(nameField);
		hbox.add(Box.createHorizontalStrut(50));
		box.add(hbox);
	}
	
	public Box getBox() {
		return box;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public JLabel getLabel() {
		return label;
	}
	
	public void setLabelName(String name) {
		label.setName(name);
	}
}
