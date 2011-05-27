package org.ig.uml.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import org.ig.uml.entities.Item;
import org.ig.uml.events.DrawItemsEvent;
import org.ig.uml.entities.Method;

public class PaintSurface extends JComponent {
	private static final long serialVersionUID = 3224506743591509786L;

	private Point startDrag; 			// point de clique pour créer le rectangle
	private ItemDraw currentItemDraw; 	// Objet courant sélectionné
	private ArrayList<Point> points;
	private List<ItemDraw> itemDraw;
	private List<LineDraw> lineDraw;
	private ToolBarUML toolBar;
	private SwingUmlView view;

	public PaintSurface(ToolBarUML toolBar, SwingUmlView view) {
		currentItemDraw = null;
		points = new ArrayList<Point>();
		itemDraw = new ArrayList<ItemDraw>();
		lineDraw = new ArrayList<LineDraw>();
		this.view = view;
		this.toolBar = toolBar;
		this.addMouseListener(new MouseEventHandler(this));
		this.addMouseMotionListener(new MouseEventHandler(this));
	}

	/*
	 * Dessine la classe associé à l'Item donné en paramètre Si un item est
	 * donné, alors on créé un nouveau rectangle
	 */
	public void paintItem(Item item) {
		if (item != null)
			itemDraw.add(new ItemDraw(item, new Rectangle(item
					.getPositionOnSurface().x, item.getPositionOnSurface().y,
					120, 120)));
		repaint();
	}
	
	/*
	 * Dessine la ligne reliant deux objets de forme définie par
	 * polygone (flèche...) et stroke (pointillé...)
	 */
	public void paintLine(ItemDraw item1, ItemDraw item2, Polygon p, Stroke s) {
		if (item1 != null && item2 != null)
			lineDraw.add(new LineDraw(item1, item2, p, s));
		
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		FontRenderContext frc = g2d.getFontRenderContext();
		Font font = g2d.getFont()/* .deriveFont(16f) */;

		for (ItemDraw draw : itemDraw) {
			Rectangle main = draw.getMainFrame();
			Rectangle atributs = draw.getAtributesFrame();
			Rectangle methods = draw.getMethodsFrame();
			String name = draw.getItem().getName();
			float sw = (float) font.getStringBounds(name, frc).getWidth();
			LineMetrics lm = font.getLineMetrics(name, frc);
			float sh = lm.getAscent() + lm.getDescent();
			float sx = main.x + (main.width - sw) / 2;
			float sy = main.y + (main.height + sh) / 6 - lm.getDescent();

			g2d.setPaint(Color.WHITE);
			g2d.fill(main);
			
			if (draw.equals(currentItemDraw))
				g2d.setPaint(Color.RED);
			else
				g2d.setPaint(Color.BLACK);
			
			g2d.draw(main);
			g2d.draw(atributs);
			g2d.draw(methods);
			g2d.drawString(draw.getItem().getName(), sx, sy);
			
			for (Method set : draw.getItem().getMethods()) {
				String m = set.getName();
				//g2d.drawString(m, sx, sy);
			}
			
			/*for (Attribute set : draw.getItem().getAttributes()) {
				String a = set.getName()+" : ";
				System.out.println(m);
				g2d.drawString(a, sx, sy);
			}*/
		}
		
		for (LineDraw line : lineDraw) {
			g2d.setPaint(Color.BLACK);
			g2d.setStroke(line.getStroke());
			g2d.draw(line.getLine());
			if (line.getPolygon() != null)
				g2d.fill(line.createArrow());
		}
	}
	
	public void drawItems(DrawItemsEvent drawItemsEvent) {
		itemDraw.clear();
		for (Item item : drawItemsEvent.getItems()) {
			// association de l'item au rectangle créé
			itemDraw.add(new ItemDraw(item, new Rectangle(item
					.getPositionOnSurface().x, item.getPositionOnSurface().y,
					100, 100)));
		}
		repaint();
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
	
	public List<LineDraw> getLineDraw() {
		return lineDraw;
	}

	public void setCurrentItemDraw(ItemDraw itemDraw) {
		this.currentItemDraw = itemDraw;
	}

	public ItemDraw getCurrentItemDraw() {
		return currentItemDraw;
	}
}
