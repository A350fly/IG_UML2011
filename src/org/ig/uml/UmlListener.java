package org.ig.uml;

import java.util.EventListener;

import org.ig.uml.events.DrawItemEvent;
import org.ig.uml.events.DrawItemsEvent;
import org.ig.uml.events.DrawLinkEvent;
import org.ig.uml.events.SetFrameTitleEvent;

public interface UmlListener extends EventListener {

	void drawLink(DrawLinkEvent drawLinkEvent);
	void drawItem(DrawItemEvent drawItemEvent);
	void drawItems(DrawItemsEvent drawItemsEvent);
	void setFrameTitle(SetFrameTitleEvent setFrameTitleEvent);
}