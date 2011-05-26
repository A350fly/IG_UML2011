package org.ig.uml.ui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import org.ig.uml.UmlConstants;
import org.ig.uml.UmlModel;
import org.ig.uml.managers.UmlUndoRedoManager;

public class JMenuBarUML extends JMenuBar implements UmlConstants {
	
	private static final long serialVersionUID = 7869107930309653383L;
	
	private JMenu fileMenu;
	private JMenu editMenu;
	private JMenu helpMenu;
	private JMenu generationMenu;
	private JMenuItem nouveau;
	private JMenuItem ouvrir;
	private JMenuItem enregistrer;
	private JMenuItem enregistrerSous;
	private JMenuItem quitter;
	private JMenuItem annuler;
	private JMenuItem retablir;
	private JMenuItem couper;
	private JMenuItem copier;
	private JMenuItem coller;
	private JMenuItem help;
	private JMenuItem generateCode;
	private JMenuItem aPropos;
	private JMenuItem exportGraphic;
	private JMenuItem preferences;
	
	private SwingUmlView view;

	public JMenuBarUML(SwingUmlView view) {
		this.view = view;
		
		fileMenu = new JMenu(FILE);
		editMenu = new JMenu(EDIT);
		helpMenu = new JMenu(HELP);
		generationMenu = new JMenu(GENERATION);
		nouveau = new JMenuItem(NEW);
		ouvrir = new JMenuItem(OPEN);
		enregistrer = new JMenuItem(SAVE);
		enregistrerSous = new JMenuItem(SAVE_AS);
		quitter = new JMenuItem(QUIT);
		annuler = new JMenuItem(REDO);
		retablir = new JMenuItem(UNDO);
		couper = new JMenuItem(CUT);
		copier = new JMenuItem(COPY);
		coller = new JMenuItem(PASTE);
		help = new JMenuItem(HELP);
		generateCode = new JMenuItem(GENERATE_CODE);
		aPropos = new JMenuItem(A_PROPOS);
		exportGraphic = new JMenuItem(EXPORT_GRAPHIC);
		preferences = new JMenuItem(PREFERENCES);
		
		addComponents();
		setAccelerators();
		setMnemonics();
		setCommandListener();
	}

	private void addComponents() {
		add(fileMenu);
		add(editMenu);
		add(generationMenu);
		add(helpMenu);
		fileMenu.add(nouveau);
		fileMenu.add(ouvrir);
		fileMenu.addSeparator();
		fileMenu.add(enregistrer);
		fileMenu.add(enregistrerSous);
		fileMenu.addSeparator();
		fileMenu.add(exportGraphic);
		fileMenu.addSeparator();
		fileMenu.add(quitter);
		editMenu.add(annuler);
		editMenu.add(retablir);
		editMenu.addSeparator();
		editMenu.add(couper);
		editMenu.add(copier);
		editMenu.add(coller);
		editMenu.addSeparator();
		editMenu.add(preferences);
		helpMenu.add(help);
		helpMenu.add(aPropos);
		generationMenu.add(generateCode);
	}

	private void setMnemonics() {
		fileMenu.setMnemonic(KeyEvent.VK_F);
		editMenu.setMnemonic(KeyEvent.VK_N);
		helpMenu.setMnemonic(KeyEvent.VK_E);
		generationMenu.setMnemonic(KeyEvent.VK_G);
		nouveau.setMnemonic(KeyEvent.VK_U);
		ouvrir.setMnemonic(KeyEvent.VK_O);
		enregistrer.setMnemonic(KeyEvent.VK_E);
		enregistrerSous.setMnemonic(KeyEvent.VK_N);
		quitter.setMnemonic(KeyEvent.VK_Q);
		annuler.setMnemonic(KeyEvent.VK_U);
		retablir.setMnemonic(KeyEvent.VK_R);
		couper.setMnemonic(KeyEvent.VK_C);
		copier.setMnemonic(KeyEvent.VK_P);
		coller.setMnemonic(KeyEvent.VK_O);
		help.setMnemonic(KeyEvent.VK_A);
		generateCode.setMnemonic(KeyEvent.VK_A);
	}

	private void setAccelerators() {
		nouveau.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
				ActionEvent.CTRL_MASK));
		ouvrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
				ActionEvent.CTRL_MASK));
		enregistrer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK));
		enregistrerSous.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
				ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				ActionEvent.CTRL_MASK));
		annuler.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
				ActionEvent.CTRL_MASK));
		retablir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
				ActionEvent.CTRL_MASK));
		couper.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
				ActionEvent.CTRL_MASK));
		copier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				ActionEvent.CTRL_MASK));
		coller.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				ActionEvent.CTRL_MASK));
		help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		generateCode.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,
				ActionEvent.CTRL_MASK));
	}
	
	private void setCommandListener() {
		UmlUndoRedoManager manager = new UmlUndoRedoManager(annuler, retablir);
		UmlModel model = view.getController().getumlModel();
		
		nouveau.setActionCommand(NEW);
		ouvrir.setActionCommand(OPEN);
		enregistrer.setActionCommand(SAVE);
		enregistrerSous.setActionCommand(SAVE_AS);
		quitter.setActionCommand(QUIT);
		annuler.setActionCommand(REDO);
		retablir.setActionCommand(UNDO);
		couper.setActionCommand(CUT);
		copier.setActionCommand(COPY);
		coller.setActionCommand(PASTE);
		help.setActionCommand(HELP);
		generateCode.setActionCommand(GENERATE_CODE);
		aPropos.setActionCommand(A_PROPOS);
		exportGraphic.setActionCommand(EXPORT_GRAPHIC);
		preferences.setActionCommand(PREFERENCES);
		
		nouveau.addActionListener(new MenuBarListener(view));
		ouvrir.addActionListener(new MenuBarListener(view));
		enregistrer.addActionListener(new MenuBarListener(view));
		enregistrerSous.addActionListener(new MenuBarListener(view));
		quitter.addActionListener(new MenuBarListener(view));
		annuler.addActionListener(new UmlUndoRedoListener(model, manager));
		retablir.addActionListener(new UmlUndoRedoListener(model, manager));
		couper.addActionListener(new MenuBarListener(view));
		copier.addActionListener(new MenuBarListener(view));
		coller.addActionListener(new MenuBarListener(view));
		help.addActionListener(new MenuBarListener(view));
		generateCode.addActionListener(new MenuBarListener(view));
		aPropos.addActionListener(new MenuBarListener(view));
		exportGraphic.addActionListener(new MenuBarListener(view));
		preferences.addActionListener(new MenuBarListener(view));
	}
}
