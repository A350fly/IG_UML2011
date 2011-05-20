package org.ig.uml.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.ig.uml.UmlConstants;
import org.ig.uml.events.DrawClassEvent;
import org.ig.uml.events.DrawInterfaceEvent;
import org.ig.uml.events.DrawLinkEvent;

public class JFrameUml extends JFrame implements UmlConstants {

	private static final long serialVersionUID = -7551368803304492966L;
	
	private JMenuBarUML jmenuBarUML;
	private PaintSurface paintSurface;
	private ToolBarUML toolBarUML;
	private JScrollPane paintSurfaceScrollPane;
	private SwingUmlView view;

	public JFrameUml(SwingUmlView view) {
		jmenuBarUML = new JMenuBarUML();
		paintSurface = new PaintSurface();
		toolBarUML = new ToolBarUML();
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
	 * Dessine la classe à partir des informations de l'évènement (le nom de la
	 * la classe, la liste des méthodes et la liste des attributs).
	 */
	public void drawClass(DrawClassEvent drawClassEvent) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Même que drawClass() sauf que c'est une interface.
	 * On rajoutera la chaîne "<<interface>>" au dessus du nom de l'interface.
	 */
	public void addInterface(DrawInterfaceEvent drawInterfaceEvent) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Dessine une droite entre deux objets (une interface ou une classe).
	 * La forme de la droite dépend du champ link du paramètre drawLinkEvent.
	 * Pour savoir quel sont les deux objets concernés, on regarde le champ 
	 * classe du paramètre et on regarde le champ classe du link.
	 */
	public void drawLink(DrawLinkEvent drawLinkEvent) {
		// TODO Auto-generated method stub
		
	}
}
