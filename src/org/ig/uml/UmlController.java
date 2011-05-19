package org.ig.uml;

import org.ig.uml.entities.Attribute;
import org.ig.uml.entities.Classe;
import org.ig.uml.entities.Interface;
import org.ig.uml.entities.Method;
import org.ig.uml.ui.SwingUmlView;

public class UmlController {
	private UmlView umlView;
	private UmlModel umlModel;

	public UmlController(UmlModel model) {
		umlModel = model;
		umlView = new SwingUmlView(this);
		addListenersToModel();
	}

	public void addListenersToModel() {
		umlModel.addUmlListener(umlView);
	}

	public UmlView getumlView(){
		return umlView;
	}

	public UmlModel getumlModel() {
		return umlModel;
	}
	
	public void displayViews() {
		umlView.display();
	}

	public void closeViews() {
		umlView.close();
	}
	
	public void notifyAddClass(Classe classe) {
		umlModel.getComponentManager().addClass(classe);
	}
	
	public void notifyAddInterface(Interface i) {
		umlModel.getComponentManager().addInterface(i);
	}
	
	public void notifyAddAttribute(Attribute a, Classe classe) {
		umlModel.getComponentManager().addAttribute(a, classe);
	}
	
	public void notifyAddMethod(Method method, Classe classe) {
		umlModel.getComponentManager().addMethod(method, classe);
	}
}