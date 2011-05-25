package org.ig.uml.ui;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import org.ig.uml.ui.notifications.ClassDialog;
import org.ig.uml.ui.notifications.InterfaceDialog;

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
			if (itemDraw.getMainFrame().contains(surface.getStartDrag())) {
				surface.setCurrentItemDraw(itemDraw);
	            last_x = surface.getCurrentItemDraw().getMainFrame().x - e.getX();
	            last_y = surface.getCurrentItemDraw().getMainFrame().y - e.getY();
	            updateLocation(e);
				return;
			}
		}
		
		// On agit en fonction du bouton sélectionné sur la ToolBar
		if (toolBar.getNewClass().isSelected()) {
			new ClassDialog(surface.getView(), surface.getStartDrag());
		}
		else if (toolBar.getNewInterface().isSelected()) {
			new InterfaceDialog(surface.getView(), surface.getStartDrag());
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
		ItemDraw item = surface.getCurrentItemDraw();
		
		if (item == null)
			return;

		item.setLocation(last_x + e.getX(), last_y + e.getY());
		surface.paintItem(null);
	}
	
	public Rectangle getRectangle(int x, int y) {
		for (ItemDraw itemDraw : surface.getItemDraw())
			if (itemDraw.getMainFrame().contains(x, y))
				return itemDraw.getMainFrame();
		return null;
	}
}
