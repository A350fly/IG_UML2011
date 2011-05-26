package org.ig.uml.ui.notifications;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
	private Box methodsInformationBox;
	private Box attributesInformationBox;

	private SwingUmlView view;
	private Point point;					// coordonnées du clique ayant amené au Jdialog
	private MethodDialog methods;			// permet de récupérer la liste des méthodes de classe
	private AttributesDialog attributes; 	//permet de récupérer la liste des attributs de classe

	public ClassDialog(SwingUmlView view, Point point) {
		this.view = view;
		this.point = point;
		methods = null;
		attributes = null;
		informationsPanel = new JPanel(new BorderLayout());
		methodsInformationBox = Box.createVerticalBox();
		attributesInformationBox = Box.createVerticalBox();
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(true);
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
		hbox.setPreferredSize(new Dimension(300, 20));
		hbox.setMaximumSize(new Dimension(500, 25));
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
		
		methodsInformationBox.add(new JLabel("Liste des méthodes :"), BorderLayout.NORTH);
		informationsPanel.add(methodsInformationBox);
		
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
	
	public MethodDialog getMethods() {
		return methods;
	}
	
	public AttributesDialog getAttributes() {
		return attributes;
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "AddMethods") {
			methods = new MethodDialog(view);

			for (MethodBox set : methods.getMethodBoxList()) {
				if (set.getNameField().getText().equals(""))
					continue;
				
				Box hbox = Box.createHorizontalBox();
				String params = " ";
				String r = set.getReturnType().getSelectedItem().toString();
				String m = set.getVisibilitiy().getSelectedItem().toString()+" "+r+" "+
				set.getNameField().getText()+"("+
				params+");";
				
				hbox.add(new JLabel(m), BorderLayout.CENTER);
				methodsInformationBox.add(hbox);
			}
			
			this.setSize(getWidth(), getHeight()+25);
			informationsPanel.validate();
			informationsPanel.repaint();
		}
		else if (e.getActionCommand() == "AddAttributes") {
			attributes = new AttributesDialog(view);
			
			for (AttributesBox set : attributes.getAttributesBoxList()) {
				if (set.getNameField().getText().equals(""))
					continue;
				
				Box hbox = Box.createHorizontalBox();
				String r = set.getType().getSelectedItem().toString();
				String m = set.getVisibilitiy().getSelectedItem().toString()+" "+r+" "+
				set.getNameField().getText()+";";
				
				hbox.add(new JLabel(m), BorderLayout.SOUTH);
				attributesInformationBox.add(hbox);
			}
			
			this.setSize(getWidth(), getHeight()+25);
			informationsPanel.validate();
			informationsPanel.repaint();
		}
	}
}
