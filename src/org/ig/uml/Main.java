package org.ig.uml;

public class Main {
	
	public static void main(String[]args){
		UmlModel model = new UmlModel();
		UmlController controller = new UmlController(model);
		controller.displayViews();
	 }
}