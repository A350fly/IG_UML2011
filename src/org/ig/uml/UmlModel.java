package org.ig.uml;

import javax.swing.event.EventListenerList;

public class UmlModel {
	private EventListenerList listeners;

	public UmlModel() {
		listeners = new EventListenerList();
	}

	public void addUmlListener(UmlListener listener) {
		listeners.add(UmlListener.class, listener);
	}

	public void removeUmlListener(UmlListener listener) {
		listeners.remove(UmlListener.class, listener);
	}

	public EventListenerList getListeners() {
		return listeners;
	}
	
	public void start() {
	}
}