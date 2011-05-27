package org.ig.uml.managers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEdit;


public class UmlUndoRedoManager extends UndoManager {

	private static final long serialVersionUID = 113955108414391380L;
	
	private JMenuItem undo;
	private JMenuItem redo;
	
	public UmlUndoRedoManager(JMenuItem undo, JMenuItem redo) {
		this.undo = undo;
		this.redo = redo;
		undo.setEnabled(false);
		redo.setEnabled(false);
		
		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UmlUndoRedoManager.this.undo();
			}
		});
		
		redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UmlUndoRedoManager.this.redo();
			}
		});
	}
	
	public boolean addEdit(UndoableEdit e) {
		boolean b = super.addEdit(e);
		updateItems();
		return b;
	}
	
	public void redo() {
		super.redo();
		updateItems();
	}
	
	public void undo() {
		super.undo();
		updateItems();
	}
	
	private void updateItems() {
		redo.setEnabled(canRedo());
		undo.setEnabled(canUndo());
	}
}
