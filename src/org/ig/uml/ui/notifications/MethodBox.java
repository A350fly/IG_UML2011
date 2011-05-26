package org.ig.uml.ui.notifications;

import java.awt.Dimension;
import java.util.HashSet;
import java.util.Set;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.ig.uml.entities.Classe;
import org.ig.uml.entities.Item;
import org.ig.uml.entities.Visibility;
import org.ig.uml.ui.SwingUmlView;

public class MethodBox extends JComponent {

	private static final long serialVersionUID = -7604193805166351437L;
	
	private Box box;
	private JButton addParameter;
	private JLabel label;
	private JTextField nameField;
	private JComboBox visibility;
	private JComboBox returnType;
	
	public MethodBox(String labelName, SwingUmlView view) {
		label = new JLabel(labelName);
		nameField = new JTextField(15);
		addParameter = new JButton("+");
		visibility = new JComboBox(new Visibility[] { 
				Visibility.PUBLIC,
				Visibility.PACKAGE,
				Visibility.PROTECTED,
				Visibility.PRIVATE});
		visibility.setSelectedIndex(0);
		
		// Récupérer la liste des items existants
		// TODO : vraiment améliorer cette partie...
		Set<Classe> set = makeReturnTypeList(view);
		String[] types = new String[set.size()];
		int i = 0;
		for (Classe c : set) {
			types[i] = c.getName();
			i++;
		}
		
		returnType = new JComboBox(types);
		returnType.setSelectedIndex(0);
		
		//returnType = new JComboBox(new Item)
		box = Box.createVerticalBox();
		
		Box hbox = Box.createHorizontalBox();
		hbox.setPreferredSize(new Dimension(600, 20));
		hbox.setMaximumSize(new Dimension(600, 25));
		hbox.add(Box.createHorizontalStrut(20));
		hbox.add(label);
		hbox.add(Box.createHorizontalStrut(10));
		hbox.add(nameField);
		hbox.add(Box.createHorizontalStrut(10));
		hbox.add(visibility);
		hbox.add(Box.createHorizontalStrut(10));
		hbox.add(returnType);
		hbox.add(Box.createHorizontalStrut(10));
		hbox.add(addParameter);
		hbox.add(Box.createHorizontalStrut(40));
		box.add(hbox);
	}
	
	/*
	 * Sélectionne uniquement les types de retour valides
	 */
	private Set<Classe> makeReturnTypeList(SwingUmlView view) {
		Set<Classe> set = new HashSet<Classe>();
		
		for (Item i : view.getController().notifyGetItems()) {
			if (i instanceof Classe)		// hack ?
				set.add((Classe) i);
		}
		
		assert(set == null);	// Il y a toujours des types primitifs
		return set;
	}
	
	public Box getBox() {
		return box;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public JLabel getLabel() {
		return label;
	}
	
	public void setLabelName(String name) {
		label.setName(name);
	}
	
	public JComboBox getVisibilitiy() {
		return visibility;
	}
	
	public JComboBox getReturnType() {
		return returnType;
	}
}
