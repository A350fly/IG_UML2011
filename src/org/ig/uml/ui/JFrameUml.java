package org.ig.uml.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.text.Position;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import org.ig.uml.UmlConstants;
import org.ig.uml.entities.Item;
import org.ig.uml.events.DrawItemEvent;
import org.ig.uml.events.DrawItemsEvent;
import org.ig.uml.events.DrawLinkEvent;
import org.ig.uml.ui.events.CloseWindow;

public class JFrameUml extends JFrame implements UmlConstants {

	private static final long serialVersionUID = -7551368803304492966L;

	private JMenuBarUML jmenuBarUML;
	private PaintSurface paintSurface;
	private ToolBarUML toolBarUML;
	private JScrollPane paintSurfaceScrollPane;
	private JScrollPane jtreeScrollPane;
	private SwingUmlView view;
	private JTreeElements jtreeElements;
	private JSplitPane splitPane;

	public JFrameUml(SwingUmlView view) {
		String finalTitle = "";
		jmenuBarUML = new JMenuBarUML(view);
		toolBarUML = new ToolBarUML(view);
		paintSurface = new PaintSurface(toolBarUML, view);
		jtreeElements = new JTreeElements();
		paintSurfaceScrollPane = new JScrollPane(paintSurface);
		jtreeScrollPane = new JScrollPane(jtreeElements);
		this.view = view; 
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(jtreeScrollPane);
        jtreeScrollPane.setMinimumSize(new Dimension(100, 100));
        paintSurfaceScrollPane.setMinimumSize(new Dimension(300, 100));
        splitPane.setRightComponent(paintSurfaceScrollPane);
        splitPane.setDividerLocation(150);
		addWindowListener(new CloseWindow(view));
		finalTitle = UNSAVED_FILE + " - " + TITLE;
		setTitle(finalTitle);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setPreferredSize(new Dimension(HEIGHT_FRAME, WIDTH_FRAME));
		setMinimumSize(new Dimension(HEIGHT_MIN_FRAME, WIDTH_MIN_FRAME));
		addComponents();
		pack();
	}

	public JScrollPane getPaintSurfaceScrollPane() {
		return paintSurfaceScrollPane;
	}

	public void setView(SwingUmlView view) {
		this.view = view;
	}

	public SwingUmlView getView() {
		return view;
	}

	private void addComponents() {
		setJMenuBar(jmenuBarUML);
		getContentPane().add(toolBarUML, BorderLayout.PAGE_START);
		getContentPane().add(splitPane, BorderLayout.CENTER);
	}

	/**
	 * Dessine l'item à partir des informations de l'évènement (le nom de
	 * l'item, la liste des méthodes et la liste des attributs). On rajoutera la
	 * chaîne "<<interface>>" au dessus du nom si l'item est une l'interface.
	 */
	public void drawItem(DrawItemEvent drawItemEvent) {
		paintSurface.paintItem(drawItemEvent.getItem());
		displayItemOnTree(drawItemEvent);
	}

	private void displayItemOnTree(DrawItemEvent drawItemEvent) {
		DefaultTreeModel modelTree = (DefaultTreeModel)jtreeElements.getModel();
		// Find node to which new node is to be added
		int startRow = 0;
		String prefix = "Elements";
		TreePath path = jtreeElements.getNextMatch(prefix, startRow, Position.Bias.Forward);
		MutableTreeNode node = (MutableTreeNode)path.getLastPathComponent();

		// Create new node
		MutableTreeNode newNode = new DefaultMutableTreeNode(drawItemEvent.getItem().getName());

		// Insert new node as last child of node
		modelTree.insertNodeInto(newNode, node, node.getChildCount());
	}

	/**
	 * Dessine une droite entre deux Items. La forme de la droite dépend du champ
	 * link du paramètre drawLinkEvent. Pour savoir quel sont les deux item
	 * concernés, on regarde le champ item du paramètre et on regarde le champ
	 * item du link.
	 */
	public void drawLink(DrawLinkEvent drawLinkEvent) {
		// TODO Auto-generated method stub

	}

	public void drawItems(DrawItemsEvent drawItemsEvent) {
		paintSurface.drawItems(drawItemsEvent);
		displayItemsOnTree(drawItemsEvent);
	}
	
	public void displayItemsOnTree(DrawItemsEvent drawItemsEvent) {
	    DefaultMutableTreeNode root;
        DefaultMutableTreeNode child;
        
        root = new DefaultMutableTreeNode("Elements");
		DefaultMutableTreeNode diagram = new DefaultMutableTreeNode("Diagramme");
		root.add(diagram);
        for(Item item : drawItemsEvent.getItems()) {
        	child = new DefaultMutableTreeNode(item.getName());
        	root.add(child);
        }
		jtreeElements.setModel(new DefaultTreeModel(root));
	}

	public PaintSurface getPaintSurface() {
		return paintSurface;
	}

	public void setPaintSurface(PaintSurface paintSurface) {
		this.paintSurface = paintSurface;
	}
}
