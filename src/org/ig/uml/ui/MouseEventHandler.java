package org.ig.uml.ui;

import java.awt.Cursor;
import java.awt.Dimension;
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
	private Rectangle paintZone;

	public MouseEventHandler(PaintSurface surface) {
		this.surface = surface;
		Dimension dim = surface.getSize();
		paintZone = new Rectangle(dim);
	}
	
	public void mousePressed(MouseEvent e) {
		surface.getView().getController().getumlModel().setNeedSave(true);
		Point clickPoint = new Point(e.getX(), e.getY());
		surface.setStartDrag(clickPoint);
		
		ToolBarUML toolBar = surface.getToolBar();
		
		for (ItemDraw itemDraw : surface.getItemDraw()) {
			if (itemDraw.getMainFrame().contains(surface.getStartDrag())) {
				surface.setCurrentItemDraw(itemDraw);
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
	
	public boolean checkPanelLimit() {
		ItemDraw item = surface.getCurrentItemDraw();
		Rectangle rect = item.getMainFrame();
		
		if (paintZone == null)
			return false;

		if (paintZone.contains(rect.x, rect.y, rect.width, rect.height))
			return true;
			
		int new_x = rect.x;
		int new_y = rect.y;

		if ((rect.x + rect.width) > paintZone.getWidth())
			new_x = (int)paintZone.getWidth()-99;
		
		if (rect.x < 0)
			new_x = -1;
		
		if ((rect.y + rect.height) > paintZone.getHeight())
			new_y = (int)paintZone.getHeight()-49;
		
		if (rect.y < 0)
			new_y = -1;
		
		item.setLocation(new_x, new_y);
		return false;
	}
}
