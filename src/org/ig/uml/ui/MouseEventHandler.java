package org.ig.uml.ui;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.ig.uml.ui.notifications.ClassDialog;

public class MouseEventHandler extends MouseAdapter {

	private PaintSurface surface;
	private Point point;			// coordonnées du dernier clique
	
	public MouseEventHandler(PaintSurface surface) {
		this.surface = surface;
		point = new Point();
	}
	
	public void mousePressed(MouseEvent e) {
		surface.setStartDrag(new Point(e.getX(), e.getY()));
		surface.getPoints().add(surface.getStartDrag());
		point.setLocation(e.getX(), e.getY());
		
		ToolBarUML toolBar = surface.getToolBar();
		
		// On agit en fonction du bouton sélectionné sur la ToolBar
		if (toolBar.getNewClass().isSelected()) {
			new ClassDialog(surface.getView(), point);
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
		
		//surface.repaint();
	}
	
	public void mouseDragged(MouseEvent e) {
		surface.setStartDrag(new Point(e.getX(), e.getY()));
		surface.getPoints().add(surface.getStartDrag());
		surface.repaint();
	}
}
