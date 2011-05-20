package org.ig.uml.ui.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.ig.uml.UmlView;
import org.ig.uml.entities.Classe;
import org.ig.uml.ui.SwingUmlView;
import org.ig.uml.ui.notifications.ClassDialog;

public class DrawClass implements ActionListener {
	
	private UmlView view;
	private ClassDialog dialog;

	public DrawClass(SwingUmlView view, ClassDialog dialog){
		this.view = view;
		this.dialog = dialog;
	}

	public void actionPerformed(ActionEvent e) {
		
		Classe classe = new Classe("");
		view.getController().notifyDrawClass(classe);
	}
}
