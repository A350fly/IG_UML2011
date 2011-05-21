package org.ig.uml.ui;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import org.ig.uml.ui.notifications.ClassDialog;

public class MouseEventHandler extends MouseAdapter {

	private static final long serialVersionUID = -5433034343223349595L;
	
	private PaintSurface surface;
	private int last_x;
	private int last_y;

	public MouseEventHandler(PaintSurface surface) {
		this.surface = surface;
	}
	
	public void mousePressed(MouseEvent e) {
		surface.setStartDrag(new Point(e.getX(), e.getY()));
		
		ToolBarUML toolBar = surface.getToolBar();
		
		for (ItemDraw itemDraw : surface.getItemDraw()) {
			if (itemDraw.getRectangle().contains(surface.getStartDrag())) {
				surface.setRectangleCourant(itemDraw.getRectangle());
	            last_x = surface.getRectangleCourant().x - e.getX();
	            last_y = surface.getRectangleCourant().y - e.getY();
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
		updateLocation(e);
	}
	
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if (getRectangle(x, y) != null)
			surface.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		else
			surface.setCursor(Cursor.getDefaultCursor());
	}
	
	public void updateLocation(MouseEvent e){
		Rectangle rect = surface.getRectangleCourant();
		
		if (rect == null)
			return;
		
		rect.setLocation(last_x + e.getX(), last_y + e.getY());
		surface.paintClass(null, false);
	}
	
	public Rectangle getRectangle(int x, int y) {
		for (ItemDraw itemDraw : surface.getItemDraw())
			if (itemDraw.getRectangle().contains(x, y))
				return itemDraw.getRectangle();
		return null;
	}
}
