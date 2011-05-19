package org.ig.uml.ui;

import org.ig.uml.UmlController;
import org.ig.uml.UmlView;
import org.ig.uml.events.DrawClassEvent;
import org.ig.uml.events.DrawInterfaceEvent;

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

	@Override
	public void drawClass(DrawClassEvent addClassEvent) {
		jframe.drawClass(addClassEvent);
	}

	@Override
	public void addInterface(DrawInterfaceEvent addInterfaceEvent) {
		jframe.addInterface(addInterfaceEvent);
	}
}
