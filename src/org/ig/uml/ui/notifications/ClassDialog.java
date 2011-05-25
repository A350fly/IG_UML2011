package org.ig.uml.ui.notifications;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.ig.uml.ui.SwingUmlView;
import org.ig.uml.ui.events.DrawClass;

public class ClassDialog extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 448652272255923022L;
	
	private JPanel informationsPanel;
	private JLabel nameLabel;
	private JTextField nameField;
	private JCheckBox isFinal;
	private JCheckBox isAbstract;
	private JButton validate;
	private JButton addMethod;
	private JButton addAttributes;

	private SwingUmlView view;
	private Point point;		// coordonnées du clique ayant amené au Jdialog

	public ClassDialog(SwingUmlView view, Point point) {
		this.view = view;
		this.point = point;
		informationsPanel = new JPanel(new BorderLayout());
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setTitle("Nouvelle classe");
		setModal(true);
		setContentPane(buildComponent());
		pack();
		setDialogLocation(view.getJframe());
		setVisible(true);
	}

	private void setDialogLocation(Frame f) {
		Rectangle r = f.getBounds();
		int x = r.x + (r.width - getSize().width)/2;
		int y = r.y + (r.height - getSize().height)/2;
		setLocation(x, y);
	}

	private JPanel buildComponent() {
		DrawClass listener = new DrawClass(view, this);
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(new JLabel("<html><h3>Création d'une classe</h3></html>",
				JLabel.CENTER), BorderLayout.NORTH);

		nameLabel = new JLabel("Nom de classe :");
		nameField = new JTextField(10);
		
		isFinal = new JCheckBox("Final");
		isFinal.addItemListener(listener);
		
		isAbstract = new JCheckBox("Abstract");
		isAbstract.addItemListener(listener);
		
		validate = new JButton("Valider");
		validate.setActionCommand("Validate");
		validate.addActionListener(listener);
		
		addMethod = new JButton("Ajouter Méthodes");
		addMethod.setActionCommand("AddMethods");
		addMethod.addActionListener(this);
		
		addAttributes = new JButton("Ajouter Attributs");
		addAttributes.setActionCommand("AddAttributes");
		addAttributes.addActionListener(this);
		
		Box vbox = Box.createVerticalBox();
		vbox.add(Box.createVerticalStrut(10));
		
		// Nom de classe
		Box hbox = Box.createHorizontalBox();
		hbox.add(Box.createHorizontalStrut(10));
		hbox.add(nameLabel);
		hbox.add(Box.createHorizontalStrut(10));
		hbox.add(nameField);
		hbox.add(Box.createHorizontalStrut(50));
		vbox.add(hbox);
		
		// Propriétés de la classe
		vbox.add(Box.createVerticalStrut(10));
		vbox.add(isFinal);
		vbox.add(isAbstract);
		vbox.add(Box.createVerticalStrut(30));
		
		// méthodes de la classe
		hbox = Box.createHorizontalBox();
		hbox.add(addMethod);
		hbox.add(Box.createHorizontalStrut(10));
		hbox.add(addAttributes);
		vbox.add(hbox);
		vbox.add(Box.createVerticalStrut(10));
		
		// Bouton valider
		hbox = Box.createHorizontalBox();
		hbox.add(validate);
		vbox.add(Box.createVerticalStrut(10));
		vbox.add(hbox);
		vbox.add(Box.createVerticalStrut(20));
		
		informationsPanel.add(new JLabel("Liste des méthodes :"));
		
		panel.add(vbox, BorderLayout.CENTER);
		panel.add(informationsPanel, BorderLayout.SOUTH); 
		return panel;
	}
	
	public JTextField getNameField() {
		return nameField;
	}
	
	public Point getPoint() {
		return point;
	}
	
	public JCheckBox getIsFinal() {
		return isFinal;
	}

	public JCheckBox getIsAbstract() {
		return isAbstract;
	}
	
	public JPanel getInformationsPanel() {
		return informationsPanel;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "AddMethods")
			new MethodDialog(view);
		else if (e.getActionCommand() == "AddAttributes")
			return;
	}
}
