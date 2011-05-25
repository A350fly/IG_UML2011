package org.ig.uml.ui.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.ig.uml.UmlView;
import org.ig.uml.ui.SwingUmlView;
import org.ig.uml.ui.notifications.InterfaceDialog;

public class DrawInterface implements ActionListener {
	
	private UmlView view;
	private InterfaceDialog dialog;

	public DrawInterface(SwingUmlView view, InterfaceDialog dialog){
		this.view = view;
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {

	}
}
