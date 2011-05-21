package org.ig.uml.ui;

import org.ig.uml.UmlController;
import org.ig.uml.UmlView;
import org.ig.uml.events.DrawItemEvent;
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
	public void drawItem(DrawItemEvent drawItemEvent) {
		jframe.drawItem(drawItemEvent);
	}

	public void drawLink(DrawLinkEvent drawLinkEvent) {
		jframe.drawLink(drawLinkEvent);
	}
	
	public JFrameUml getJframe() {
		return jframe;
	}
}
