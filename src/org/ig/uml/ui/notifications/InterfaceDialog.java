package org.ig.uml.ui.notifications;

import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JDialog;
import javax.swing.JPanel;

import org.ig.uml.ui.SwingUmlView;

public class InterfaceDialog extends JDialog {
	
	private static final long serialVersionUID = -4330676277339797373L;
	
	private SwingUmlView view;
	private Point point;		// coordonnées du clique ayant amené au Jdialog
	
	public InterfaceDialog(SwingUmlView view, Point point) {
		this.view = view;
		this.point = point;
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Nouvelle interface");
		this.setModal(true);
		this.setContentPane(buildComponent());
		this.pack();
		this.setDialogLocation(view.getJframe());
		this.setVisible(true);
	}
	
	private void setDialogLocation(Frame f) {
		Rectangle r = f.getBounds();
		int x = r.x + (r.width - getSize().width)/2;
		int y = r.y + (r.height - getSize().height)/2;
		setLocation(x, y);
	}

	private JPanel buildComponent() {
		return null;
	}
	
	public Point getPoint() {
		return point;
	}
}
