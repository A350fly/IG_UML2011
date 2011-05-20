package org.ig.uml.ui;

import org.ig.uml.UmlController;
import org.ig.uml.UmlView;
import org.ig.uml.events.DrawClassEvent;
import org.ig.uml.events.DrawInterfaceEvent;
import org.ig.uml.events.DrawLinkEvent;

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
	public void drawClass(DrawClassEvent drawClassEvent) {
		jframe.drawClass(drawClassEvent);
	}

	@Override
	public void drawInterface(DrawInterfaceEvent drawInterfaceEvent) {
		jframe.addInterface(drawInterfaceEvent);
	}

	@Override
	public void drawLink(DrawLinkEvent drawLinkEvent) {
		jframe.drawLink(drawLinkEvent);
	}
}
