package org.ig.uml.ui.events;

import java.io.File;

import javax.swing.JFileChooser;

import org.ig.uml.ui.SwingUmlView;

public class OpenFileXmlFile {
	
	private SwingUmlView view;
	private File file;
	private JFileChooser fileChooser;
	
	public OpenFileXmlFile(SwingUmlView view) {
		this.view = view;
		fileChooser = new JFileChooser();
		fileChooser.setApproveButtonText("Choisir un dossier");
		int state = fileChooser.showOpenDialog(view.getJframe());
		if (state == JFileChooser.APPROVE_OPTION) {
			file = fileChooser.getSelectedFile();
			view.getController().notifyOpenXmlFile(file);
		}
	}
}