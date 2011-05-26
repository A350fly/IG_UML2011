package org.ig.uml.ui.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import org.ig.uml.ui.SwingUmlView;

public class SaveFileToXml implements ActionListener {
	
	private SwingUmlView view;
	private File file;
	private JFileChooser fileChooser;
	
	public SaveFileToXml(SwingUmlView view) {
		this.view = view;
		if(view.getController().getumlModel().isNeedFilePathToSave()) {
			fileChooser = new JFileChooser();
			fileChooser.setApproveButtonText("Choisir un dossier");
			int state = fileChooser.showOpenDialog(view.getJframe());
			if (state == JFileChooser.APPROVE_OPTION) {
				file = fileChooser.getSelectedFile();
				view.getController().notifySaveToXml(file);
			}
		} else {
			view.getController().notifySaveToXml();
		}
	}
	
	public void actionPerformed(ActionEvent arg0) {
	}
}
