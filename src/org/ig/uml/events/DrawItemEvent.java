package org.ig.uml.events;

import java.util.EventObject;

import org.ig.uml.entities.Item;

public class DrawItemEvent extends EventObject {
	private Item item;
	private static final long serialVersionUID = 7270402749502813082L;
	
	public DrawItemEvent(Object source, Item item) {
		super(source);
		this.item = item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return item;
	}

}
