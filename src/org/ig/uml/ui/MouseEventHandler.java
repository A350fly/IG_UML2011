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
	private int xItem;
	private int yItem;
	private int x1;
	private int y1;
	private int x2;
	private int y2;

	public MouseEventHandler(PaintSurface surface) {
		this.surface = surface;
	}
	
	public void mousePressed(MouseEvent e) {
		Point clickPoint = new Point(e.getX(), e.getY());
		surface.setStartDrag(clickPoint);
		
		ToolBarUML toolBar = surface.getToolBar();
		
		for (ItemDraw itemDraw : surface.getItemDraw()) {
			if (itemDraw.getMainFrame().contains(surface.getStartDrag())) {
				surface.setCurrentItemDraw(itemDraw);
	            setxItem(itemDraw.getItem().getPositionOnSurface().x);
	            yItem = itemDraw.getItem().getPositionOnSurface().y;
				return;
			}
		}
		// On agit en fonction du bouton sélectionné sur la ToolBar
		if (toolBar.getNewClass().isSelected()) {
			new ClassDialog(surface.getView(), clickPoint); 
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
			surface.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		else
			surface.setCursor(Cursor.getDefaultCursor());
	}
	
	public void updateLocation(MouseEvent e){		
		ItemDraw item = surface.getCurrentItemDraw();
		if (item == null) 
			return;
        xItem = item.getItem().getPositionOnSurface().x;
        yItem = item.getItem().getPositionOnSurface().y;
        x2 = e.getX();
        y2 = e.getY();
        x1 = surface.getStartDrag().x;
        y1 = surface.getStartDrag().y;
        
        xItem = xItem + x2 - x1;
        yItem = yItem + y2 - y1;
        surface.setStartDrag(new Point(x2, y2));
		item.setLocation(xItem, yItem);
		surface.paintItem(null);
	}
	
	public Rectangle getRectangle(int x, int y) {
		for (ItemDraw itemDraw : surface.getItemDraw())
			if (itemDraw.getMainFrame().contains(x, y))
				return itemDraw.getMainFrame();
		return null;
	}

	public int getxItem() {
		return xItem;
	}

	public void setxItem(int xItem) {
		this.xItem = xItem;
	}
}
