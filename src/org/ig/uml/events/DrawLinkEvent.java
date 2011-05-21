package org.ig.uml.events;

import java.util.EventObject;
import org.ig.uml.entities.Item;
import org.ig.uml.entities.Link;

public class DrawLinkEvent extends EventObject {
	private Item item;
	private Link link;
	private static final long serialVersionUID = -7739986023687067380L;
	
	public DrawLinkEvent(Object source, Link link, Item item) {
		super(source);
		this.link = link;
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}
}
