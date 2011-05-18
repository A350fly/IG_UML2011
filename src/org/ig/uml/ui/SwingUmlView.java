package org.ig.uml.ui;

import org.ig.uml.UmlController;
import org.ig.uml.UmlView;

public class SwingUmlView extends UmlView {

	private JFrameUml jframe;
	
	public SwingUmlView(UmlController controller) {
		super(controller);
		jframe = new JFrameUml(this);
	}
	
	public void display() {
		jframe.setVisible(true);
	}

	public void close() {
		jframe.dispose();
	}
}
