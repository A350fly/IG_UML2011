package org.ig.uml.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import javax.swing.JComponent;

public class PaintSurface extends JComponent {
	private static final long serialVersionUID = 3224506743591509786L;
	private Point startDrag;
    private ArrayList<Point> points;
    
    public PaintSurface() {
      points = new ArrayList<Point>(); 

      this.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e) {
          startDrag = new Point(e.getX(), e.getY());
          points.add(startDrag);
          repaint();
        } 
      });

      this.addMouseMotionListener(new MouseMotionAdapter() {
        public void mouseDragged(MouseEvent e) {
          startDrag = new Point(e.getX(), e.getY());
          points.add(startDrag);
          repaint();
        }
      });
    }

    public void paint(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      g2.setPaint(Color.RED);
      for(Point point : points) {
        g2.fillRect(point.x, point.y, 1, 1);
      }
    }

}
