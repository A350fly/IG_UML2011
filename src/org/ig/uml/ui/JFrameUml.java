package org.ig.uml.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.ig.uml.UmlConstants;
import org.ig.uml.events.DrawItemEvent;
import org.ig.uml.events.DrawLinkEvent;

public class JFrameUml extends JFrame implements UmlConstants {

	private static final long serialVersionUID = -7551368803304492966L;

	private JMenuBarUML jmenuBarUML;
	private PaintSurface paintSurface;
	private ToolBarUML toolBarUML;
	private JScrollPane paintSurfaceScrollPane;
	private SwingUmlView view;

	public JFrameUml(SwingUmlView view) {
		jmenuBarUML = new JMenuBarUML(this);
		toolBarUML = new ToolBarUML(this);
		paintSurface = new PaintSurface(toolBarUML, view);
		paintSurfaceScrollPane = new JScrollPane(paintSurface);
		this.view = view;

		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(HEIGHT_FRAME, WIDTH_FRAME));
		setMinimumSize(new Dimension(HEIGHT_MIN_FRAME, WIDTH_MIN_FRAME));
		addComponents();
		pack();
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
		getContentPane().add(paintSurfaceScrollPane, BorderLayout.CENTER);
	}

	/**
	 * Dessine l'item à partir des informations de l'évènement (le nom de
	 * l'item, la liste des méthodes et la liste des attributs). On rajoutera la
	 * chaîne "<<interface>>" au dessus du nom si l'item est une l'interface.
	 */
	public void drawItem(DrawItemEvent drawItemEvent) {
		paintSurface.paintClass();
	}

	/**
	 * Dessine une droite entre deux Item. La forme de la droite dépend du champ
	 * link du paramètre drawLinkEvent. Pour savoir quel sont les deux item
	 * concernés, on regarde le champ item du paramètre et on regarde le champ
	 * item du link.
	 */
	public void drawLink(DrawLinkEvent drawLinkEvent) {
		// TODO Auto-generated method stub

	}
}
