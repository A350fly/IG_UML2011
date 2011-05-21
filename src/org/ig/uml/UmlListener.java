package org.ig.uml;

import java.util.EventListener;

import org.ig.uml.events.DrawItemEvent;
import org.ig.uml.events.DrawLinkEvent;

public interface UmlListener extends EventListener {

	void drawLink(DrawLinkEvent drawLinkEvent);
	void drawItem(DrawItemEvent drawItemEvent);
}