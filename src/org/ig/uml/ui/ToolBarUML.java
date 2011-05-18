package org.ig.uml.ui;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import org.ig.uml.UMLConstants;

//TODO : Uniformiser la taille des icônes de la barre d'outils

public class ToolBarUML extends JToolBar implements UMLConstants {

	private static final long serialVersionUID = 7662874994619958728L;
	
	private ButtonGroup buttonGroup;
	private JToggleButton newClass;
	private JToggleButton newAssociation;
	private JToggleButton newAggregation;
	private JToggleButton newGeneralization;
	private JToggleButton newComposition;
	private JToggleButton newInterface;
	private JToggleButton newRealization;
	private JToggleButton newDependency;
	private JToggleButton newAttribute;
	private JToggleButton newOperation;
	
	private static final ImageIcon ICON_NEW_CLASS = new ImageIcon(
			"res/drawable/Class.gif");
	private static final ImageIcon ICON_NEW_ASSOCIATION = new ImageIcon(
			"res/drawable/Association.gif");
	private static final ImageIcon ICON_NEW_AGGREGATION = new ImageIcon(
			"res/drawable/Aggregation.gif");
	private static final ImageIcon ICON_NEW_GENERALIZATION = new ImageIcon(
			"res/drawable/Generalization.gif");
	private static final ImageIcon ICON_NEW_COMPOSITION = new ImageIcon(
			"res/drawable/Composition.gif");
	private static final ImageIcon ICON_NEW_INTERFACE = new ImageIcon(
			"res/drawable/Interface.gif");
	private static final ImageIcon ICON_NEW_REALIZATION = new ImageIcon(
			"res/drawable/Realization.gif");
	private static final ImageIcon ICON_NEW_DEPENDENCY = new ImageIcon(
			"res/drawable/Dependency.gif");
	private static final ImageIcon ICON_NEW_ATTRIBUTE = new ImageIcon(
			"res/drawable/Attribute.gif");
	private static final ImageIcon ICON_NEW_OPERATION = new ImageIcon(
			"res/drawable/AddOperation.gif");

	public ToolBarUML() {
		buttonGroup = new ButtonGroup();
		newClass = new JToggleButton(ICON_NEW_CLASS);
		newAssociation = new JToggleButton(ICON_NEW_ASSOCIATION);
		newAggregation = new JToggleButton(ICON_NEW_AGGREGATION);
		newGeneralization = new JToggleButton(ICON_NEW_GENERALIZATION);
		newComposition = new JToggleButton(ICON_NEW_COMPOSITION);
		newInterface = new JToggleButton(ICON_NEW_INTERFACE);
		newRealization = new JToggleButton(ICON_NEW_REALIZATION);
		newDependency = new JToggleButton(ICON_NEW_DEPENDENCY);
		newAttribute = new JToggleButton(ICON_NEW_ATTRIBUTE);
		newOperation = new JToggleButton(ICON_NEW_OPERATION);
		addComponents();
		addToButtonGroup();
	}

	public void addComponents() {
		add(newClass);
		add(newInterface);
		add(newAttribute);
		add(newOperation);
		add(newAssociation);
		add(newAggregation);
		add(newGeneralization);
		add(newComposition);
		add(newRealization);
		add(newDependency);
	}
	
	public void addToButtonGroup() {
		buttonGroup.add(newClass);
		buttonGroup.add(newInterface);
		buttonGroup.add(newAttribute);
		buttonGroup.add(newOperation);
		buttonGroup.add(newAssociation);
		buttonGroup.add(newAggregation);
		buttonGroup.add(newGeneralization);
		buttonGroup.add(newComposition);
		buttonGroup.add(newRealization);
		buttonGroup.add(newDependency);
	}
}
