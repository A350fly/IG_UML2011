package org.ig.uml.ui;

import java.awt.Dimension;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;

public class JTreeElements extends JTree {

	private static final long serialVersionUID = -5631205988341518524L;

	public JTreeElements() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Elements");
		DefaultMutableTreeNode diagram = new DefaultMutableTreeNode("Diagramme");
		root.add(diagram);
		setModel(new DefaultTreeModel(root));
		setPreferredSize(new Dimension(150, 200));
		getSelectionModel().setSelectionMode(
				TreeSelectionModel.SINGLE_TREE_SELECTION);
	}    
	
}