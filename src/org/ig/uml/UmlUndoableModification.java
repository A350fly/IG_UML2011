package org.ig.uml;

import javax.swing.undo.AbstractUndoableEdit;

public class UmlUndoableModification extends AbstractUndoableEdit {
	
	private static final long serialVersionUID = 494725240462117457L;
	
	private UmlModel model;
	
	public UmlUndoableModification(UmlModel model) {
		this.model = model;
	}
	
	public String getPresentationName() {
		return "";
	}
	
	public boolean canRedo() {
		return true;
	}
	
	public boolean canUndo() {
		return true;
	}
	
	public void undo() {

	}
	
	public void redo() {

	}
}