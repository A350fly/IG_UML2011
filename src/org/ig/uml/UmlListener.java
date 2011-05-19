package org.ig.uml;

import java.util.EventListener;

import org.ig.uml.events.DrawClassEvent;
import org.ig.uml.events.DrawInterfaceEvent;

public interface UmlListener extends EventListener {

	void drawClass(DrawClassEvent addClassEvent);
	void addInterface(DrawInterfaceEvent addInterfaceEvent);
}