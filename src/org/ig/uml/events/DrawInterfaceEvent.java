package org.ig.uml.events;

import java.util.EventObject;
import org.ig.uml.entities.Interface;

public class DrawInterfaceEvent extends EventObject {
	private Interface newInterface;
	private static final long serialVersionUID = 7270402749502813082L;
	
	public DrawInterfaceEvent(Object source, Interface newInterface) {
		super(source);
		this.newInterface = newInterface;
	}

	public void setnewInterface(Interface newInterface) {
		this.newInterface = newInterface;
	}

	public Interface getnewInterface() {
		return newInterface;
	}
}
