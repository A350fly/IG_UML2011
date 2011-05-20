package org.ig.uml.events;

import java.util.EventObject;

import org.ig.uml.entities.Classe;
import org.ig.uml.entities.Interface;
import org.ig.uml.entities.Link;

public class DrawLinkEvent extends EventObject {
	private Object object;
	private Link link;
	private static final long serialVersionUID = -7739986023687067380L;
	
	public DrawLinkEvent(Object source, Link link, Classe classe) {
		super(source);
		this.link = link;
		this.object = classe;
	}
	
	public DrawLinkEvent(Object source, Link link, Interface i) {
		super(source);
		this.link = link;
		this.object = i;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}
}
