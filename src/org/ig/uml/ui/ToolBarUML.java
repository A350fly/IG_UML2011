package org.ig.uml.ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import org.ig.uml.UMLConstants;
//TODO Uniformiser la taille des icônes de la barre d'outils

public class ToolBarUML extends JToolBar implements UMLConstants {
	
	private static final long serialVersionUID = 7662874994619958728L;
	private JButton newClass;
	private JButton newAssociation;
	private JButton newAggregation;
	private JButton newGeneralization;
	private JButton newComposition;
	private JButton newInterface;
	private JButton newRealization;
	private JButton newDependency;
	private JButton newAttribute;
	private JButton newOperation;
	private static final ImageIcon ICON_NEW_CLASS = new ImageIcon("res/drawable/Class.gif");
	private static final ImageIcon ICON_NEW_ASSOCIATION = new ImageIcon("res/drawable/Association.gif");
	private static final ImageIcon ICON_NEW_AGGREGATION = new ImageIcon("res/drawable/Aggregation.gif");
	private static final ImageIcon ICON_NEW_GENERALIZATION = new ImageIcon("res/drawable/Generalization.gif");
	private static final ImageIcon ICON_NEW_COMPOSITION = new ImageIcon("res/drawable/Composition.gif");
	private static final ImageIcon ICON_NEW_INTERFACE = new ImageIcon("res/drawable/Interface.gif");
	private static final ImageIcon ICON_NEW_REALIZATION = new ImageIcon("res/drawable/Realization.gif");
	private static final ImageIcon ICON_NEW_DEPENDENCY = new ImageIcon("res/drawable/Dependency.gif");
	private static final ImageIcon ICON_NEW_ATTRIBUTE = new ImageIcon("res/drawable/Attribute.gif");
	private static final ImageIcon ICON_NEW_OPERATION = new ImageIcon("res/drawable/AddOperation.gif");
	
	public ToolBarUML() {
		newClass = new JButton(ICON_NEW_CLASS);
		newAssociation = new JButton(ICON_NEW_ASSOCIATION);
		newAggregation = new JButton(ICON_NEW_AGGREGATION);
		newGeneralization = new JButton( ICON_NEW_GENERALIZATION);
		newComposition = new JButton(ICON_NEW_COMPOSITION);
		newInterface = new JButton(ICON_NEW_INTERFACE);
		newRealization = new JButton(ICON_NEW_REALIZATION);
		newDependency = new JButton(ICON_NEW_DEPENDENCY);
		newAttribute = new JButton(ICON_NEW_ATTRIBUTE);
		newOperation = new JButton(ICON_NEW_OPERATION);
		addComponents();
	}

	public void addComponents() {
		add(newClass);		
		add(newInterface) ;
		add(newAttribute);
		add(newOperation);
		add(newAssociation);
		add(newAggregation);
		add(newGeneralization);
		add(newComposition) ;
		add(newRealization);
		add(newDependency);
	}
}
