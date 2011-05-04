package org.ig.uml;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class ToolBarUML extends JToolBar {
	
	private static final long serialVersionUID = 7662874994619958728L;
	private JButton testButton;

	public ToolBarUML() {
		testButton = new JButton("test");
		addComponents(); 
	} 
	
	public void addComponents() {
		add(testButton);
	}
}
