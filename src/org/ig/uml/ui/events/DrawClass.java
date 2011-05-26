package org.ig.uml.ui.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.Set;

import org.ig.uml.UmlView;
import org.ig.uml.entities.Attribute;
import org.ig.uml.entities.Classe;
import org.ig.uml.entities.Method;
import org.ig.uml.ui.SwingUmlView;
import org.ig.uml.ui.notifications.AttributesBox;
import org.ig.uml.ui.notifications.AttributesDialog;
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
			
			Set<Attribute> a = makeAttributesList();
			Set<Method> m = makeMethodList();
			
			if (m != null)
				classe.setMethods(m);
			
			if (a != null)
				classe.setAttributes(a);
			
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
	
	private Set<Method> makeMethodList() {
		MethodDialog methods = dialog.getMethods();
		Set<Method> set = new HashSet<Method>();	// méthodes "valides"
		if (methods != null) {
			
			for (MethodBox box : methods.getMethodBoxList()) {
				String mName = box.getNameField().getText();
				
				if (mName.equals(""))
					continue;
				
				String ret = box.getReturnType().getSelectedItem().toString();
				set.add(new Method(mName, new Classe(ret)));
			}
		}
		
		return set;
	}
	
	private Set<Attribute> makeAttributesList() {
		AttributesDialog attributes = dialog.getAttributes();
		Set<Attribute> set = new HashSet<Attribute>();	// attributs "valides"
		if (attributes != null) {
			
			for (AttributesBox box : attributes.getAttributesBoxList()) {
				String aName = box.getNameField().getText();
				
				if (aName.equals(""))
					continue;
				
				String type = box.getType().getSelectedItem().toString();
				set.add(new Attribute(aName, new Classe(type)));
			}
		}
		
		return set;
	}
}
