package org.ig.uml.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import org.ig.uml.entities.Item;

public class PaintSurface extends JComponent {
	private static final long serialVersionUID = 3224506743591509786L;
	
	private Point startDrag;			// point de clique pour créer le rectangle
	private Rectangle rectangleCourant;	// Rectangle courant sélectionné
	private ArrayList<Point> points;
	private List<ItemDraw> itemDraw;
	private ToolBarUML toolBar;
	private SwingUmlView view;

	public PaintSurface(ToolBarUML toolBar, SwingUmlView view) {
		rectangleCourant = null;
		points = new ArrayList<Point>();
		itemDraw = new ArrayList<ItemDraw>();
		this.view = view;
		this.toolBar = toolBar;

		this.addMouseListener(new MouseEventHandler(this));
		this.addMouseMotionListener(new MouseEventHandler(this));
	}
	
	/*
	 * Dessine la classe associé à l'Item donné en paramètre
	 * Si firstDraw est vrai, on créé un nouveau rectangle,
	 * sinon on travaille sur le rectangle courant
	 */
	public void paintClass(Item item, boolean firstDraw) {
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		Rectangle rectangle;
		super.paintComponents(g2d);
		
		if (firstDraw)
			rectangle = new Rectangle(startDrag.x, startDrag.y, 100, 100);
		else
			rectangle = rectangleCourant;
			
		g2d.setPaint(Color.WHITE);
		g2d.fill(rectangle);
		g2d.setPaint(Color.BLACK);
		g2d.draw(rectangle);
		
		if (item != null)
			itemDraw.add(new ItemDraw(item, rectangle));	// association de l'item en rectangle créé
		
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	public void setStartDrag(Point startDrag) {
		this.startDrag = startDrag;
	}

	public Point getStartDrag() {
		return startDrag;
	}

	public void setToolBar(ToolBarUML toolBar) {
		this.toolBar = toolBar;
	}

	public ToolBarUML getToolBar() {
		return toolBar;
	}

	public SwingUmlView getView() {
		return view;
	}

	public void setPoints(ArrayList<Point> points) {
		this.points = points;
	}

	public ArrayList<Point> getPoints() {
		return points;
	}
	
	public List<ItemDraw> getItemDraw() {
		return itemDraw;
	}

	public void setRectangleCourant(Rectangle rectangle) {
		this.rectangleCourant = rectangle;
	}

	public Rectangle getRectangleCourant() {
		return rectangleCourant;
	}
}
