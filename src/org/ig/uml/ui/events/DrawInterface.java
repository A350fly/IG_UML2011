package org.ig.uml.ui.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import org.ig.uml.UmlView;
import org.ig.uml.entities.Classe;
import org.ig.uml.entities.Interface;
import org.ig.uml.entities.Method;
import org.ig.uml.ui.SwingUmlView;
import org.ig.uml.ui.notifications.InterfaceDialog;
import org.ig.uml.ui.notifications.MethodBox;
import org.ig.uml.ui.notifications.MethodDialog;

public class DrawInterface implements ActionListener {
	
	private UmlView view;
	private InterfaceDialog dialog;

	public DrawInterface(SwingUmlView view, InterfaceDialog dialog){
		this.view = view;
		this.dialog = dialog;
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Validate")) {
			String name = "<< "+dialog.getNameField().getText()+" >>";
			Interface i = new Interface(name);			// on créé notre interface
			i.setPositionOnSurface(dialog.getPoint());
			
			Set<Method> m = makeMethodList();
			
			if (m != null)
				i.setMethods(m);
			
			view.getController().notifyDrawItem(i);
			dialog.dispose();
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
}
