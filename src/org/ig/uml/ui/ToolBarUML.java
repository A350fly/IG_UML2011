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
	
	private JFrameUml frame;
	
	public ToolBarUML(JFrameUml frame) {
		this.frame = frame;
		
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
		
		addCommandsListener();
		addComponents();
		addToButtonGroup();
		addTooltipText();
	}

	private void addComponents() {
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
	
	private void addToButtonGroup() {
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
	
	private void addTooltipText() {
		newClass.setToolTipText(NEW_CLASS);
		newAssociation.setToolTipText(NEW_ASSOCIATION);
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
		newAggregation.setActionCommand(NEW_AGGREGATION);
		newGeneralization.setActionCommand(NEW_GENELIZATION);
		newComposition.setActionCommand(NEW_COMPOSITION);
		newInterface.setActionCommand(NEW_INTERFACE);
		newRealization.setActionCommand(NEW_REALIZATION);
		newDependency.setActionCommand(NEW_DEPENDENCY);
		newAttribute.setActionCommand(NEW_ATTRIBUTE);
		newOperation.setActionCommand(NEW_OPERATION);
	    
		newClass.addActionListener(new ToolBarListener(frame));
		newAssociation.addActionListener(new ToolBarListener(frame));
		newAggregation.addActionListener(new ToolBarListener(frame));
		newGeneralization.addActionListener(new ToolBarListener(frame));
		newComposition.addActionListener(new ToolBarListener(frame));
		newInterface.addActionListener(new ToolBarListener(frame));
		newRealization.addActionListener(new ToolBarListener(frame));
		newDependency.addActionListener(new ToolBarListener(frame));
		newAttribute.addActionListener(new ToolBarListener(frame));
		newOperation.addActionListener(new ToolBarListener(frame));
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
