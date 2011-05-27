package org.ig.uml.ui;

import java.awt.BasicStroke;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class LineDraw {

	private ItemDraw firstItem;
	private ItemDraw secondItem;
	private Line2D line;
	private int x1, x2, y1, y2;
	private Stroke stroke;
	private boolean isFilled;		// indique si la forme doit être rempli
	
	// Transformations pour le rendu des flèches
	private AffineTransform affineTransform ;
	private Polygon polygon;
	private Shape arrow;
	private double theta;
	
	public LineDraw(ItemDraw firstItem, ItemDraw secondItem, Polygon p, Stroke s, boolean f) {
		this.firstItem = firstItem;
		this.secondItem = secondItem;
		
		x1 = firstItem.getMainFrame().x;
		y1 = firstItem.getMainFrame().y;
		x2 = secondItem.getMainFrame().x;
		y2 = secondItem.getMainFrame().y;
		line = new Line2D.Float(x1, y1, x2, y2);
		
		polygon = p;
		
		if (s == null)
			stroke = new BasicStroke();
		else
			stroke = s;
		
		isFilled = f;
		
		if (polygon != null) {
			affineTransform = new AffineTransform();
			theta = Math.atan(y2 - y1) / (x2 - x1);
			affineTransform.setToRotation(theta);
			arrow = affineTransform.createTransformedShape(polygon);
			affineTransform.setToTranslation(x2, y2);
		}
	}

	public boolean isFilled() {
		return isFilled;
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
	
	/*
	 * Créé la forme au bout de la ligne (flèche, aggrégation, composition)
	 */
	public Shape createArrow() {
		Shape arrowShape = affineTransform.createTransformedShape(arrow);
		return arrowShape;
	}

	public Polygon getPolygon() {
		return polygon;
	}

	public Stroke getStroke() {
		return stroke;
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
			
			if (polygon != null) {
				theta = Math.atan(y - y1) / (x - x1);
				affineTransform.setToRotation(theta);
				arrow = affineTransform.createTransformedShape(polygon);
				affineTransform.setToTranslation(x, y);
			}
		}
	}
}
