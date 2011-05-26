package org.ig.uml.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.ig.uml.UmlModel;
import org.ig.uml.UmlUndoableModification;
import org.ig.uml.managers.UmlUndoRedoManager;

public class UmlUndoRedoListener implements ActionListener {
	
	private UmlModel model;
	private UmlUndoRedoManager manager;
	
	public UmlUndoRedoListener(UmlModel model, UmlUndoRedoManager manager) {
		this.model = model;
		this.manager = manager;
	}
	
	public void actionPerformed(ActionEvent e) {
		manager.addEdit(new UmlUndoableModification(model));
	}
}
