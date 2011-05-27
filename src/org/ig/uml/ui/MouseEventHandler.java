package org.ig.uml.ui;

import java.awt.BasicStroke;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import org.ig.uml.entities.Link;
import org.ig.uml.entities.LinkType;
import org.ig.uml.ui.notifications.ClassDialog;
import org.ig.uml.ui.notifications.InterfaceDialog;

public class MouseEventHandler extends MouseAdapter {

	private static final long serialVersionUID = -5433034343223349595L;
	private static final float DASH[] = {5.0f};
	
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
		ToolBarUML toolBar = surface.getToolBar();
		Point clickPoint = new Point(e.getX(), e.getY());
		ItemDraw selected = getItemDraw(clickPoint.x, clickPoint.y);
		ItemDraw current = surface.getCurrentItemDraw();
		surface.setStartDrag(clickPoint);
		
		/*
		 * Cas où un trait doit relier deux objets
		 * On les traite avant les opérations suivantes
		 */
		if (toolBar.getNewAssociation().isSelected()) {
			if (checkLinkableItems(current, selected)) {
				Link link = new Link(LinkType.ASSOCIATION, current.getItem());
				
				surface.paintLine(current, selected, null, null);
				surface.getView().getController().notifyDrawLink(link, selected.getItem());
			}
		}
		else if (toolBar.getNewUniAssociation().isSelected()) {
			if (checkLinkableItems(current, selected)) {
				Link link = new Link(LinkType.UNI_ASSOCIATION, current.getItem());
				Polygon triangle =
					new Polygon(new int[] {-15,0,-15,-5,-15}, new int[] {-5,0,5,0,-5}, 5);
				
				surface.paintLine(current, selected, triangle, null);
				surface.getView().getController().notifyDrawLink(link, selected.getItem());
			}
		}
		else if (toolBar.getNewAggregation().isSelected()) {
			if (checkLinkableItems(current, selected)) {
				Link link = new Link(LinkType.AGGREGATION, current.getItem());
				Polygon losange =
					new Polygon(new int[] {-7,-15,-7,0}, new int[] {-5,0,5,0}, 4);
				
				surface.paintLine(current, selected, losange, null);
				surface.getView().getController().notifyDrawLink(link, selected.getItem());
			}
		}
		else if (toolBar.getNewComposition().isSelected()) {
			if (checkLinkableItems(current, selected)) {
				Link link = new Link(LinkType.COMPOSITION, current.getItem());
				Polygon losange =
					new Polygon(new int[] {-7,-15,-7,0}, new int[] {-5,0,5,0}, 4);
				
				surface.paintLine(current, selected, losange, null);
				surface.getView().getController().notifyDrawLink(link, selected.getItem());
			}
		}
		else if (toolBar.getNewDependency().isSelected()) {
			if (checkLinkableItems(current, selected)) {
				Link link = new Link(LinkType.DEPENDENCY, current.getItem());
				Polygon triangle =
					new Polygon(new int[] {-15,0,-15,-5,-15}, new int[] {-5,0,5,0,-5}, 5);
				BasicStroke stroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER, 10.0f, DASH, 0.0f);

				surface.paintLine(current, selected, triangle, stroke);
				surface.getView().getController().notifyDrawLink(link, selected.getItem());
			}
		}
		else if (toolBar.getNewGeneralization().isSelected()) {
			if (checkLinkableItems(current, selected)) {
				Link link = new Link(LinkType.GENERALIZATION, current.getItem());
				Polygon triangle = new Polygon(new int[] {0,0,10}, new int[] {-5,5,0}, 3);
				
				surface.paintLine(current, selected, triangle, null);
				surface.getView().getController().notifyDrawLink(link, selected.getItem());
			}
		}
		else if (toolBar.getNewRealization().isSelected()) {
			if (checkLinkableItems(current, selected)) {
				Link link = new Link(LinkType.REALIZATION, current.getItem());
				Polygon triangle = new Polygon(new int[] {0,0,10}, new int[] {-5,5,0}, 3);
				BasicStroke stroke = new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER, 10.0f, DASH, 0.0f);
				
				surface.paintLine(current, selected, triangle, stroke);
				surface.getView().getController().notifyDrawLink(link, selected.getItem());
			}
		}
		
		surface.setCurrentItemDraw(selected);
		surface.repaint();
		
		// On agit en fonction du bouton sélectionné sur la ToolBar
		if (toolBar.getNewClass().isSelected()) {
			if (surface.getCurrentItemDraw() == null)
				new ClassDialog(surface.getView(), clickPoint); 
		}
		else if (toolBar.getNewInterface().isSelected()) {
			if (surface.getCurrentItemDraw() == null)
				new InterfaceDialog(surface.getView(), surface.getStartDrag());
		}
		
		else if (toolBar.getNewOperation().isSelected()) {
			
		}
		else if (toolBar.getNewAttribute().isSelected()) {
			
		}
		
		surface.getView().getController().getumlModel().setNeedSave(true);
	}
	
	public void mouseDragged(MouseEvent e) {
		updateLocation(e);
	}
	
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if (getItemDraw(x, y) != null)
			surface.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		else
			surface.setCursor(Cursor.getDefaultCursor());
	}
	
	public int getxItem() {
		return xItem;
	}

	public void setxItem(int xItem) {
		this.xItem = xItem;
	}
	
	/*
	 * Récupère l'objet aux coordonnées x, y
	 */
	private ItemDraw getItemDraw(int x, int y) {
		for (ItemDraw itemDraw : surface.getItemDraw())
			if (itemDraw.getMainFrame().contains(x, y))
				return itemDraw;
		return null;
	}
	
	private void updateLocation(MouseEvent e){		
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
		
		for (LineDraw line : surface.getLineDraw())
			line.setLocation(item, xItem, yItem);
		
		surface.paintItem(null);
	}
	
	/*
	 * Vérifie s'il est possible de fabriquer un lien entre deux objets
	 */
	private boolean checkLinkableItems(ItemDraw item1, ItemDraw item2) {
		if (item1 != null && item2 != null) {
			if (!item2.equals(item1)) {
				for (LineDraw line : surface.getLineDraw()) {
					// On vérifie qu'un même lien n'existe pas déjà
					if ((line.getFirstItem().equals(item1) && 
							line.getSecondItem().equals(item2)) ||
							(line.getFirstItem().equals(item2) &&
							line.getSecondItem().equals(item1)))
						return false;
				}
			}
			else
				return false;
			
			return true;
		}

		return false;
	}
	
	private boolean checkPanelLimit() {
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
