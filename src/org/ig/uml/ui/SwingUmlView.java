package org.ig.uml.ui;

import org.ig.uml.UmlController;
import org.ig.uml.UmlView;
import org.ig.uml.events.DrawItemEvent;
import org.ig.uml.events.DrawItemsEvent;
import org.ig.uml.events.DrawLinkEvent;
import org.ig.uml.events.SetFrameTitleEvent;

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

	public void drawItem(DrawItemEvent drawItemEvent) {
		jframe.drawItem(drawItemEvent);
	}

	public void drawLink(DrawLinkEvent drawLinkEvent) {
		jframe.drawLink(drawLinkEvent);
	}
	
	public JFrameUml getJframe() {
		return jframe;
	}

	@Override
	public void drawItems(DrawItemsEvent drawItemsEvent) {
		jframe.drawItems(drawItemsEvent);
	}

	@Override
	public void setFrameTitle(SetFrameTitleEvent setFrameTitleEvent) {
		jframe.setTitle(setFrameTitleEvent.getTitle());
	}
}
