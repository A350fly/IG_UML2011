package org.ig.uml.ui.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.Set;

import org.ig.uml.UmlView;
import org.ig.uml.entities.Classe;
import org.ig.uml.entities.Item;
import org.ig.uml.entities.Method;
import org.ig.uml.ui.SwingUmlView;
import org.ig.uml.ui.notifications.ClassDialog;
import org.ig.uml.ui.notifications.MethodBox;
import org.ig.uml.ui.notifications.MethodDialog;

public class DrawClass implements ActionListener, ItemListener {
	
	private UmlView view;
	private ClassDialog dialog;
	private boolean isFinal;
	private boolean isAbstract;

	public DrawClass(SwingUmlView view, ClassDialog dialog){
		this.view = view;
		this.dialog = dialog;
		isFinal = false;
		isAbstract = false;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Validate")) {
			String name = dialog.getNameField().getText();
			Classe classe = new Classe(name);				// on créé notre classe
			classe.setPositionOnSurface(dialog.getPoint());
			classe.setFinal(isFinal);
			classe.setAbstract(isAbstract);
			
			MethodDialog methods = dialog.getMethods();
			if (methods != null) {
				Set<Method> set = new HashSet<Method>();	// méthodes "valides"
				
				for (MethodBox box : methods.getMethodBoxList()) {
					String mName = box.getNameField().getText();
					
					if (mName.equals(""))
						continue;
					
					String ret = box.getReturnType().getSelectedItem().toString();
					set.add(new Method(mName, new Classe(ret)));
				}
				
				classe.setMethods(set);
			}
			
			view.getController().notifyDrawItem(classe);
			dialog.dispose();
		}
	}

	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItemSelectable();

		if (e.getStateChange() == ItemEvent.SELECTED) {
			if (source.equals(dialog.getIsAbstract()))
				isAbstract = true;
			else if (source.equals(dialog.getIsFinal()))
				isFinal = true;
		}
		else if (e.getStateChange() == ItemEvent.DESELECTED) {
			if (source.equals(dialog.getIsAbstract()))
				isAbstract = false;
			else if (source.equals(dialog.getIsFinal()))
				isFinal = false;
		}
	}
}
