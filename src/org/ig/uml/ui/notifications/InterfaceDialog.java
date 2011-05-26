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
import org.ig.uml.ui.events.DrawInterface;

public class InterfaceDialog extends JDialog implements ActionListener {
	
	private static final long serialVersionUID = 448652272255923022L;
	
	private JPanel mainPanel;
	private JPanel informationsPanel;
	private JLabel nameLabel;
	private JTextField nameField;
	private JButton validate;
	private JButton addMethod;
	private Box methodsInformationBox;

	private SwingUmlView view;
	private Point point;					// coordonnées du clique ayant amené au Jdialog
	private MethodDialog methods;			// permet de récupérer la liste des méthodes de classe

	public InterfaceDialog(SwingUmlView view, Point point) {
		this.view = view;
		this.point = point;
		methods = null;
		mainPanel = new JPanel(new BorderLayout());
		informationsPanel = new JPanel(new BorderLayout());
		methodsInformationBox = Box.createVerticalBox();
		
		buildComponent();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(true);
		setTitle("Nouvelle classe");
		setModal(true);
		setContentPane(mainPanel);
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

	private void buildComponent() {
		DrawInterface listener = new DrawInterface(view, this);
		mainPanel.add(new JLabel("<html><h3>Création d'une interface</h3></html>",
				JLabel.CENTER), BorderLayout.NORTH);

		nameLabel = new JLabel("Nom de l'interface :");
		nameField = new JTextField(10);
		
		validate = new JButton("Valider");
		validate.setActionCommand("Validate");
		validate.addActionListener(listener);
		
		addMethod = new JButton("Ajouter Méthodes");
		addMethod.setActionCommand("AddMethods");
		addMethod.addActionListener(this);
		
		
		Box vbox = Box.createVerticalBox();
		vbox.add(Box.createVerticalStrut(10));
		
		// Nom de l'interface
		Box hbox = Box.createHorizontalBox();
		hbox.setPreferredSize(new Dimension(300, 20));
		hbox.setMaximumSize(new Dimension(500, 25));
		hbox.add(Box.createHorizontalStrut(10));
		hbox.add(nameLabel);
		hbox.add(Box.createHorizontalStrut(10));
		hbox.add(nameField);
		hbox.add(Box.createHorizontalStrut(50));
		vbox.add(hbox);
		
		// méthodes de l'interface
		hbox = Box.createHorizontalBox();
		hbox.add(addMethod);
		vbox.add(Box.createVerticalStrut(20));
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
		
		mainPanel.add(vbox, BorderLayout.CENTER);
		mainPanel.add(informationsPanel, BorderLayout.SOUTH); 
	}
	
	public JTextField getNameField() {
		return nameField;
	}
	
	public Point getPoint() {
		return point;
	}
	
	public JPanel getInformationsPanel() {
		return informationsPanel;
	}
	
	public MethodDialog getMethods() {
		return methods;
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
	}
}
