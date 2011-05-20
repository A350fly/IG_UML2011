package org.ig.uml;

import java.util.EventListener;

import org.ig.uml.events.DrawClassEvent;
import org.ig.uml.events.DrawInterfaceEvent;
import org.ig.uml.events.DrawLinkEvent;

public interface UmlListener extends EventListener {

	void drawClass(DrawClassEvent addClassEvent);
	void drawInterface(DrawInterfaceEvent addInterfaceEvent);
	void drawLink(DrawLinkEvent drawLinkEvent);
}