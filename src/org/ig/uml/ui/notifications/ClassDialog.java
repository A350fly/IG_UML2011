package org.ig.uml.ui.notifications;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.ig.uml.ui.SwingUmlView;
import org.ig.uml.ui.events.DrawClass;

public class ClassDialog extends JDialog {
	
	private static final long serialVersionUID = 448652272255923022L;
	
	private JLabel nameLabel;
	private JTextField nameField;
	private JButton validate;

	private SwingUmlView view;
	private Point point;		// coordonnées du clique ayant amené au Jdialog

	public ClassDialog(SwingUmlView view, Point point) {
		this.view = view;
		this.point = point;
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setTitle("Nouvelle classe");
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
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(new JLabel("<html><h3>Création d'une classe</h3></html>",
				JLabel.CENTER), BorderLayout.NORTH);

		nameLabel = new JLabel("Nom de classe :");
		nameField = new JTextField(10);
		validate = new JButton("Valider");
		validate.addActionListener(new DrawClass(view, this));
		
		Box vbox = Box.createVerticalBox();
		vbox.add(Box.createVerticalStrut(10));
		
		Box hbox = Box.createHorizontalBox();
		hbox.add(Box.createHorizontalStrut(10));
		hbox.add(nameLabel);
		hbox.add(Box.createHorizontalStrut(10));
		hbox.add(nameField);
		hbox.add(Box.createHorizontalStrut(50));
		vbox.add(hbox);
		
		hbox = Box.createHorizontalBox();
		hbox.add(validate);
		vbox.add(Box.createVerticalStrut(10));
		vbox.add(hbox);
		
		panel.add(vbox, BorderLayout.CENTER);
		return panel;
	}
	
	public JTextField getNameField() {
		return nameField;
	}
	
	public Point getPoint() {
		return point;
	}
}
