package org.ig.uml;

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
}