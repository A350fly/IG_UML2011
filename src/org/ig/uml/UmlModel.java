package org.ig.uml;

import javax.swing.event.EventListenerList;

import org.ig.uml.entities.Classe;
import org.ig.uml.entities.Interface;
import org.ig.uml.entities.Link;
import org.ig.uml.events.DrawClassEvent;
import org.ig.uml.events.DrawInterfaceEvent;
import org.ig.uml.events.DrawLinkEvent;
import org.ig.uml.managers.ComponentManager;

public class UmlModel {
	private EventListenerList listeners;
	private ComponentManager componentManager;
	private UmlListener[] listenerList;

	public UmlModel() {
		listeners = new EventListenerList();
		componentManager = new ComponentManager(this);
		listenerList = null;
	}

	public void addUmlListener(UmlListener listener) {
		listeners.add(UmlListener.class, listener);
		listenerList = (UmlListener[]) listeners.getListeners(UmlListener.class);
	}

	public void removeUmlListener(UmlListener listener) {
		listeners.remove(UmlListener.class, listener);
		listenerList = (UmlListener[]) listeners.getListeners(UmlListener.class);
	}

	public EventListenerList getListeners() {
		return listeners;
	}

	public void start() {
	}

	public void setComponentManager(ComponentManager componentManager) {
		this.componentManager = componentManager;
	}

	public ComponentManager getComponentManager() {
		return componentManager;
	}

	public void fireDrawClass(Classe newClass) {
		for (UmlListener listener : listenerList) {
			listener.drawClass(new DrawClassEvent(this, newClass));
		}
	}

	public void fireAddInterface(Interface i) {
		for (UmlListener listener : listenerList) {
			listener.drawInterface(new DrawInterfaceEvent(this, i));
		}
	}

	public void fireDrawLink(Link link, Classe classe) {
		for (UmlListener listener : listenerList) {
			listener.drawLink(new DrawLinkEvent(this, link, classe));
		}
	}

	public void fireDrawLink(Link link, Interface i) {
		for (UmlListener listener : listenerList) {
			listener.drawLink(new DrawLinkEvent(this, link, i));
		}
	}
}