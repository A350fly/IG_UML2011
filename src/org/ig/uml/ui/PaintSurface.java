package org.ig.uml.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PaintSurface extends JComponent {
	private static final long serialVersionUID = 3224506743591509786L;
	
	private Point startDrag;
	private ArrayList<Point> points;
	private ToolBarUML toolBar;
	private SwingUmlView view;

	public PaintSurface(ToolBarUML toolBar, SwingUmlView view) {
		setPoints(new ArrayList<Point>());
		this.view = view;
		this.toolBar = toolBar;

		this.addMouseListener(new MouseEventHandler(this));
		//this.addMouseMotionListener(new MouveEventHandler());
	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		for (Point point : points) {
			g2d.setPaint(Color.BLACK);
			g2d.drawRect(point.x, point.y, 100, 100);
			g2d.setPaint(Color.WHITE);
			g2d.fillRect(point.x, point.y, 100, 100);
		}
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
}
