package org.ig.uml.ui;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import org.ig.uml.ui.notifications.ClassDialog;

public class MouseEventHandler extends MouseAdapter {

	private static final long serialVersionUID = -5433034343223349595L;
	
	private PaintSurface surface;
	
	public MouseEventHandler(PaintSurface surface) {
		this.surface = surface;
	}
	
	public void mousePressed(MouseEvent e) {
		surface.setStartDrag(new Point(e.getX(), e.getY()));
		
		ToolBarUML toolBar = surface.getToolBar();
		
		for (ItemDraw itemDraw : surface.getItemDraw()) {
			if (itemDraw.getRectangle().contains(surface.getStartDrag())) {
				surface.setRectangle(itemDraw.getRectangle());
				return;
			}
		}
		
		// On agit en fonction du bouton sélectionné sur la ToolBar
		if (toolBar.getNewClass().isSelected()) {
			new ClassDialog(surface.getView(), surface.getStartDrag());
		}
		else if (toolBar.getNewAggregation().isSelected()) {

		}
		else if (toolBar.getNewAssociation().isSelected()) {
			
		}
		else if (toolBar.getNewAttribute().isSelected()) {
			
		}
		else if (toolBar.getNewComposition().isSelected()) {
			
		}
		else if (toolBar.getNewDependency().isSelected()) {
			
		}
		else if (toolBar.getNewGeneralization().isSelected()) {
			
		}
		else if (toolBar.getNewInterface().isSelected()) {
			
		}
		else if (toolBar.getNewOperation().isSelected()) {
			
		}
		else if (toolBar.getNewRealization().isSelected()) {
			
		}
	}
	
	public void mouseDragged(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		Graphics2D g = (Graphics2D) surface.getGraphics();
		Rectangle rect = surface.getRectangle();
		
		g.setXORMode(surface.getBackground());
		g.fill(rect);
		rect.setLocation(x, y);
		g.fill(rect);
		
		g.dispose();
	}
	
	public Rectangle getRectangle(int x, int y) {
		for (ItemDraw itemDraw : surface.getItemDraw())
			if (itemDraw.getRectangle().contains(x, y))
				return itemDraw.getRectangle();
		return null;
	}
	
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if (getRectangle(x, y) != null)
			surface.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		else
			surface.setCursor(Cursor.getDefaultCursor());
	}
}
