package org.ig.uml.events;

import java.util.EventObject;
import org.ig.uml.entities.Classe;

public class DrawClassEvent extends EventObject {
	private Classe newClass;
	private static final long serialVersionUID = 7270402749502813082L;
	
	public DrawClassEvent(Object source, Classe newClass) {
		super(source);
		this.newClass = newClass;
	}

	public void setnewClass(Classe newClass) {
		this.newClass = newClass;
	}

	public Classe getnewClass() {
		return newClass;
	}
}
