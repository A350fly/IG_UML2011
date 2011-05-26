package org.ig.uml.ui.notifications;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.ig.uml.ui.SwingUmlView;

public class AttributesDialog extends JDialog implements ActionListener {

	private static final long serialVersionUID = 4913896455890642934L;

	private JPanel mainPanel;
	private JPanel buttonsPanel;
	private JPanel attributes;
	private JScrollPane methodsPanel;
	private JButton addAttribute;
	private JButton validate;
	private List<AttributesBox> attributesBoxList;
	private Box mainBox;
	
	private SwingUmlView view;
	
	public AttributesDialog(SwingUmlView view) {
		mainPanel = new JPanel(new BorderLayout());
		buttonsPanel = new JPanel(new BorderLayout());
		attributes = new JPanel(new GridLayout());
		attributesBoxList = new ArrayList<AttributesBox>();
		addAttribute = new JButton("Ajouter attribut");
		validate = new JButton("Valider");
		this.view = view;
		
		addAttribute.setActionCommand("AddAttributes");
		addAttribute.addActionListener(this);
		validate.setActionCommand("Validate");
		validate.addActionListener(this);
		 
		buildComponents();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(true);
		setTitle("Méthodes");
		setContentPane(mainPanel);
		setModal(true);
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
	
	public void buildComponents() {
		JLabel label = new JLabel("<html><h3>Définition des méthodes de classe</h3></html>",
				JLabel.CENTER);
		
		methodsPanel = new JScrollPane(attributes,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		methodsPanel.getVerticalScrollBar().setUnitIncrement(20);

		mainBox = Box.createVerticalBox();
		mainBox.add(Box.createVerticalStrut(10));
		
		AttributesBox box = new AttributesBox("Attribut 1 :", view);
		mainBox.add(box.getBox());
		attributesBoxList.add(box);
		
		attributes.add(mainBox);
		mainBox.add(Box.createVerticalStrut(10));
		
		Box buttonsBox = Box.createHorizontalBox();
		Box hbox = Box.createHorizontalBox();
		hbox.add(addAttribute, Box.CENTER_ALIGNMENT);
		hbox.add(Box.createHorizontalStrut(10));
		hbox.add(validate, Box.CENTER_ALIGNMENT);
		buttonsBox.add(Box.createVerticalStrut(10));
		buttonsBox.add(hbox);
		buttonsBox.add(Box.createVerticalStrut(10));
		buttonsPanel.add(buttonsBox, BorderLayout.CENTER);
		
		mainPanel.add(label, BorderLayout.NORTH);
        mainPanel.add(methodsPanel, BorderLayout.CENTER);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "AddAttributes") {
			int num = attributesBoxList.size()+1;	// numéro de l'attribut
			AttributesBox box = new AttributesBox("Attribut "+num+" :", view);
			mainBox.add(box.getBox());
			mainBox.add(Box.createVerticalStrut(10));
			attributesBoxList.add(box);
			
			this.setSize(getWidth(), getHeight()+25);
			mainPanel.validate();
			mainPanel.repaint();
		}
		else if (e.getActionCommand() == "Validate") {
			this.dispose();
		}
	}
	
	public List<AttributesBox> getAttributesBoxList() {
		return attributesBoxList;
	}
}
