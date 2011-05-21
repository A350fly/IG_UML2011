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
	
	private Point startDrag;
	private Rectangle rectangle;		// Rectangle courant sélectionné
	private ArrayList<Point> points;
	private List<ItemDraw> itemDraw;
	private ToolBarUML toolBar;
	private SwingUmlView view;

	public PaintSurface(ToolBarUML toolBar, SwingUmlView view) {
		rectangle = new Rectangle();
		points = new ArrayList<Point>();
		itemDraw = new ArrayList<ItemDraw>();
		this.view = view;
		this.toolBar = toolBar;

		this.addMouseListener(new MouseEventHandler(this));
		this.addMouseMotionListener(new MouseEventHandler(this));
	}
	
	public void paintClass(Item item) {
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		super.paintComponents(g2d);
		
		Rectangle rectangle = new Rectangle(startDrag.x, startDrag.y, 100, 100);
		g2d.setPaint(Color.WHITE);
		g2d.fill(rectangle);
		g2d.setPaint(Color.BLACK);
		g2d.draw(rectangle);
		
		itemDraw.add(new ItemDraw(item, rectangle));
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

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}
}
