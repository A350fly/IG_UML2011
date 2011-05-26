package org.ig.uml.ui;

import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class LineDraw {

	private ItemDraw firstItem;
	private ItemDraw secondItem;
	private Line2D line;
	private int x1, x2, y1, y2;
	
	// Transformations pour le rendu des flèches
	private AffineTransform affineTransform ;
	private Polygon triangle = new Polygon(new int[] {0,0,10},new int[] {-5,5,0},3);
	private Shape arrow;
	private double theta;
	
	public LineDraw(ItemDraw firstItem, ItemDraw secondItem) {
		this.firstItem = firstItem;
		this.secondItem = secondItem;
		
		x1 = firstItem.getMainFrame().x;
		y1 = firstItem.getMainFrame().y;
		x2 = secondItem.getMainFrame().x;
		y2 = secondItem.getMainFrame().y;
		line = new Line2D.Float(x1, y1, x2, y2);
		
		affineTransform = new AffineTransform();
		theta = Math.atan(y2 - y1) / (x2 - x1);
		affineTransform.setToRotation(theta);
		arrow = affineTransform.createTransformedShape(triangle);
		affineTransform.setToTranslation(x2, y2);
	}

	public Line2D getLine() {
		return line;
	}
	
	public ItemDraw getFirstItem() {
		return firstItem;
	}

	public Shape getArrow() {
		return arrow;
	}

	public ItemDraw getSecondItem() {
		return secondItem;
	}
	
	public Shape createArrow() {
		Shape arrowShape = affineTransform.createTransformedShape(arrow);
		return arrowShape;
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
			
			theta = Math.atan(y - y1) / (x - x1);
			affineTransform.setToRotation(theta);
			arrow = affineTransform.createTransformedShape(triangle);
			affineTransform.setToTranslation(x, y);
		}
	}
}
