package org.ig.uml.ui;

import java.awt.Point;
import java.awt.Rectangle;

import org.ig.uml.entities.Item;

public class ItemDraw {

	private Item item;
	private Rectangle mainFrame;
	private Rectangle atributesFrame;
	private Rectangle methodsFrame;
	
	public ItemDraw(Item item, Rectangle rectangle) {
		int height = (rectangle.height/3);
		int width = rectangle.width;
		int x = rectangle.x;
		int y = rectangle.y;
		
		this.item = item;
		mainFrame = rectangle;
		atributesFrame = new Rectangle(x, y+height, width, height);
		methodsFrame = new Rectangle(x, y+(2*height), width, height);
	}
	
	public Rectangle getAtributesFrame() {
		return atributesFrame;
	}

	public void setAtributesFrame(Rectangle atributesFrame) {
		this.atributesFrame = atributesFrame;
	}

	public Rectangle getMethodsFrame() {
		return methodsFrame;
	}

	public void setMethodsFrame(Rectangle methodsFrame) {
		this.methodsFrame = methodsFrame;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
	public Item getItem() {
		return item;
	}
	
	public void setMainFrame(Rectangle rectangle) {
		this.mainFrame = rectangle;
	}
	
	public Rectangle getMainFrame() {
		return mainFrame;
	}
	
	public void setLocation(int x, int y) {
		int height = (mainFrame.height/3);
		item.setPositionOnSurface(new Point(x, y));
		
		mainFrame.setLocation(x, y);
		atributesFrame.setLocation(x, y+height);
		methodsFrame.setLocation(x, y+(2*height));
	}
}
