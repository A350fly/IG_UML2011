package org.ig.uml.ui;

import java.awt.Rectangle;

import org.ig.uml.entities.Item;

public class ItemDraw {

	private Item item;
	private Rectangle rectangle;
	
	public ItemDraw(Item item, Rectangle rectangle) {
		this.item = item;
		this.rectangle = rectangle;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	public Rectangle getRectangle() {
		return rectangle;
	}
}
