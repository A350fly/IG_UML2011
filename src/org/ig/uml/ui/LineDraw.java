package org.ig.uml.ui;

import java.awt.geom.Line2D;

public class LineDraw {

	private ItemDraw firstItem;
	private ItemDraw secondItem;
	private Line2D line;
	
	public LineDraw(ItemDraw firstItem, ItemDraw secondItem) {
		this.firstItem = firstItem;
		this.secondItem = secondItem;
		
		int x1 = firstItem.getMainFrame().width/2;
		int y1 = firstItem.getMainFrame().height/2;
		int x2 = secondItem.getMainFrame().width/2;
		int y2 = secondItem.getMainFrame().height/2;
		line = new Line2D.Float(x1, y1, x2, y2);
	}

	public Line2D getLine() {
		return line;
	}
}
