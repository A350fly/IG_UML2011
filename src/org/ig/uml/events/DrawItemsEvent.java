package org.ig.uml.events;

import java.util.EventObject;
import java.util.HashSet;

import org.ig.uml.entities.Item;

public class DrawItemsEvent extends EventObject {
	private HashSet<Item> items;
	private static final long serialVersionUID = 7270402749502813082L;
	
	public DrawItemsEvent(Object source, HashSet<Item> items) {
		super(source);
		this.items = items;
	}

	public void setItems(HashSet<Item> items) {
		this.items = items;
	}

	public HashSet<Item> getItems() {
		return items;
	}

}