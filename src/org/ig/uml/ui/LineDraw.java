package org.ig.uml.ui;

import java.awt.Point;
import java.awt.geom.Line2D;

public class LineDraw {

	private ItemDraw firstItem;
	private ItemDraw secondItem;
	private Line2D line;
	private int x1, x2, y1, y2;
	
	public LineDraw(ItemDraw firstItem, ItemDraw secondItem) {
		this.firstItem = firstItem;
		this.secondItem = secondItem;

		x1 = firstItem.getMainFrame().x;
		y1 = firstItem.getMainFrame().y;
		x2 = secondItem.getMainFrame().x;
		y2 = secondItem.getMainFrame().y;
		line = new Line2D.Float(x1, y1, x2, y2);
	}

	public Line2D getLine() {
		return line;
	}
	
	public ItemDraw getFirstItem() {
		return firstItem;
	}

	public ItemDraw getSecondItem() {
		return secondItem;
	}
	
	public void setLocation(ItemDraw item, int x, int y) {
		if (item.equals(firstItem)) {
			firstItem.setLocation(x, y);
			x1 = firstItem.getMainFrame().x;
			y1 = firstItem.getMainFrame().y;
			line.setLine(x, y, x2, y2);
		}
		else if (item.equals(secondItem)) {
			secondItem.setLocation(x, y);
			x2 = secondItem.getMainFrame().x;
			y2 = secondItem.getMainFrame().y;
			line.setLine(x1, y1, x, y);
		}
	}
}
