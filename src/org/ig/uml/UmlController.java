package org.ig.uml;

import java.io.File;

import org.ig.uml.entities.Attribute;
import org.ig.uml.entities.Classe;
import org.ig.uml.entities.Item;
import org.ig.uml.entities.Link;
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
	
	public void notifyDrawItem(Item item) {
		umlModel.getComponentManager().addItem(item);
	}
	
	public void notifyDrawLink(Link link, Item item) {
		umlModel.getComponentManager().addLink(link, item);
	}
	
	public void notifyAddAttribute(Attribute a, Classe classe) {
		umlModel.getComponentManager().addAttribute(a, classe);
	}
	
	public void notifyAddMethod(Method method, Item item) {
		umlModel.getComponentManager().addMethod(method, item);
	}

	public void notifyGenerateCode(File file) {
		umlModel.generateCode(file);
	}

	public void notifyCurrentLanguage(String language) {
		umlModel.setCurrentLanguage(language);
	}

	public void notifySaveToXml(File file) {
		umlModel.saveToXml(file);
	}

	public void notifyOpenXmlFile(File file) {
		umlModel.openXmlFile(file);
	}

	public void notifySaveToXml() {
		umlModel.saveToXml();
	}
}