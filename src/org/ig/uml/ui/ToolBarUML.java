package org.ig.uml.ui;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import org.ig.uml.UmlConstants;
import org.ig.uml.ui.events.NewFile;

public class ToolBarUML extends JToolBar implements UmlConstants {

	private static final long serialVersionUID = 7662874994619958728L;
	
	private ButtonGroup buttonGroup;
	private JToggleButton newClass;
	private JToggleButton newAssociation;
	private JToggleButton newUniAssociation;
	private JToggleButton newAggregation;
	private JToggleButton newGeneralization;
	private JToggleButton newComposition;
	private JToggleButton newInterface;
	private JToggleButton newRealization;
	private JToggleButton newDependency;
	private JToggleButton newAttribute;
	private JToggleButton newOperation;
	private JButton newFile;
	private JButton open;
	private JButton save;
	private JButton save_as;
	
	
	private SwingUmlView view;
	
	public ToolBarUML(SwingUmlView view) {
		this.view = view;
		
		buttonGroup = new ButtonGroup();
		newClass = new JToggleButton(ICON_NEW_CLASS);
		newAssociation = new JToggleButton(ICON_NEW_ASSOCIATION);
		newUniAssociation = new JToggleButton(ICON_NEW_UNI_ASSOCIATION);
		newAggregation = new JToggleButton(ICON_NEW_AGGREGATION);
		newGeneralization = new JToggleButton(ICON_NEW_GENERALIZATION);
		newComposition = new JToggleButton(ICON_NEW_COMPOSITION);
		newInterface = new JToggleButton(ICON_NEW_INTERFACE);
		newRealization = new JToggleButton(ICON_NEW_REALIZATION);
		newDependency = new JToggleButton(ICON_NEW_DEPENDENCY);
		newAttribute = new JToggleButton(ICON_NEW_ATTRIBUTE);
		newOperation = new JToggleButton(ICON_NEW_OPERATION);
		newFile = new JButton(ICON_NEW_FILE);
		open = new JButton(ICON_OPEN);
		save = new JButton(ICON_SAVE);
		save_as = new JButton(ICON_SAVE_AS);
		
		addCommandsListener();
		addComponents();
		addToButtonGroup();
		addTooltipText();
	}

	private void addComponents() {
		add(newFile);
		add(open);
		add(save);
		add(save_as);
		this.addSeparator();
		add(newClass);
		add(newInterface);
		add(newAttribute);
		add(newOperation);
		add(newAssociation);
		add(newUniAssociation);
		add(newAggregation);
		add(newGeneralization);
		add(newComposition);
		add(newRealization);
		add(newDependency);
	}
	
	private void addToButtonGroup() {
		buttonGroup.add(newClass);
		buttonGroup.add(newInterface);
		buttonGroup.add(newAttribute);
		buttonGroup.add(newOperation);
		buttonGroup.add(newAssociation);
		buttonGroup.add(newUniAssociation);
		buttonGroup.add(newAggregation);
		buttonGroup.add(newGeneralization);
		buttonGroup.add(newComposition);
		buttonGroup.add(newRealization);
		buttonGroup.add(newDependency);
	}
	
	private void addTooltipText() {
		newClass.setToolTipText(NEW_CLASS);
		newAssociation.setToolTipText(NEW_ASSOCIATION);
		newUniAssociation.setToolTipText(NEW_UNI_ASSOCIATION);
		newAggregation.setToolTipText(NEW_AGGREGATION);
		newGeneralization.setToolTipText(NEW_GENELIZATION);
		newComposition.setToolTipText(NEW_COMPOSITION);
		newInterface.setToolTipText(NEW_INTERFACE);
		newRealization.setToolTipText(NEW_REALIZATION);
		newDependency.setToolTipText(NEW_DEPENDENCY);
		newAttribute.setToolTipText(NEW_ATTRIBUTE);
		newOperation.setToolTipText(NEW_OPERATION);
	}
	
	private void addCommandsListener() {
		newClass.setActionCommand(NEW_CLASS);
		newAssociation.setActionCommand(NEW_ASSOCIATION);
		newUniAssociation.setActionCommand(NEW_UNI_ASSOCIATION);
		newAggregation.setActionCommand(NEW_AGGREGATION);
		newGeneralization.setActionCommand(NEW_GENELIZATION);
		newComposition.setActionCommand(NEW_COMPOSITION);
		newInterface.setActionCommand(NEW_INTERFACE);
		newRealization.setActionCommand(NEW_REALIZATION);
		newDependency.setActionCommand(NEW_DEPENDENCY);
		newAttribute.setActionCommand(NEW_ATTRIBUTE);
		newOperation.setActionCommand(NEW_OPERATION);
		newFile.setActionCommand(NEW);
		open.setActionCommand(OPEN);
		save_as.setActionCommand(SAVE_AS);
		save.setActionCommand(SAVE);
	    
		newClass.addActionListener(new ToolBarListener(view));
		newAssociation.addActionListener(new ToolBarListener(view));
		newUniAssociation.addActionListener(new ToolBarListener(view));
		newAggregation.addActionListener(new ToolBarListener(view));
		newGeneralization.addActionListener(new ToolBarListener(view));
		newComposition.addActionListener(new ToolBarListener(view));
		newInterface.addActionListener(new ToolBarListener(view));
		newRealization.addActionListener(new ToolBarListener(view));
		newDependency.addActionListener(new ToolBarListener(view));
		newAttribute.addActionListener(new ToolBarListener(view));
		newOperation.addActionListener(new ToolBarListener(view));
		
		newFile.addActionListener(new ToolBarListener(view));
		open.addActionListener(new ToolBarListener(view));
		save.addActionListener(new ToolBarListener(view));
		save_as.addActionListener(new ToolBarListener(view));
	}
	
	public JToggleButton getNewClass() {
		return newClass;
	}

	public JToggleButton getNewAssociation() {
		return newAssociation;
	}

	public JToggleButton getNewAggregation() {
		return newAggregation;
	}

	public JToggleButton getNewGeneralization() {
		return newGeneralization;
	}

	public JToggleButton getNewComposition() {
		return newComposition;
	}

	public JToggleButton getNewInterface() {
		return newInterface;
	}

	public JToggleButton getNewRealization() {
		return newRealization;
	}

	public JToggleButton getNewAttribute() {
		return newAttribute;
	}

	public JToggleButton getNewDependency() {
		return newDependency;
	}

	public JToggleButton getNewOperation() {
		return newOperation;
	}
}
