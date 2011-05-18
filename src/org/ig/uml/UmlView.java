package org.ig.uml;

public abstract class UmlView implements UmlListener {
	private UmlController controller;

	public UmlView(UmlController controller) {
		this.controller = controller;
	}
	
	public final UmlController getController() {
		return controller;
	}
	
	public abstract void display();
	public abstract void close();
}
