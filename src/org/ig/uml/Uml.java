package org.ig.uml;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Uml extends JFrame implements UMLConstants {

	private static final long serialVersionUID = -7551368803304492966L;
	private JMenuBarUML jmenuBarUML;
	private PaintSurface paintSurface;
	private ToolBarUML toolBarUML;
	private JScrollPane paintSurfaceScrollPane;
	    
	public Uml() { 
		jmenuBarUML = new JMenuBarUML();
		paintSurface = new PaintSurface();
		toolBarUML = new ToolBarUML();
		paintSurfaceScrollPane = new JScrollPane(paintSurface);
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setPreferredSize(new Dimension(HEIGHT_FRAME, WIDTH_FRAME));
	    setMinimumSize(new Dimension(HEIGHT_MIN_FRAME, WIDTH_MIN_FRAME));
		addComponents();
		pack();
		setVisible(true);
	}

	private void addComponents() {
	    setJMenuBar(jmenuBarUML);
	    getContentPane().add(toolBarUML, BorderLayout.PAGE_START);
	    getContentPane().add(paintSurfaceScrollPane, BorderLayout.CENTER);
	}
}
