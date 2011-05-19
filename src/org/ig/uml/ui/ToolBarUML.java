package org.ig.uml.ui;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import org.ig.uml.UmlConstants;

public class ToolBarUML extends JToolBar implements UmlConstants {

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
