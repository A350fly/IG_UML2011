package org.ig.uml.ui.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import org.ig.uml.UmlConstants;
import org.ig.uml.ui.SwingUmlView;

public class SaveFileToXml implements ActionListener, UmlConstants {
	
	private SwingUmlView view;
	private JFileChooser fileChooser;
	
	public SaveFileToXml(SwingUmlView view) {
		this.view = view;
		if(view.getController().getumlModel().isNeedFilePathToSave()) {
			fileChooser = new JFileChooser();
			fileChooser.setApproveButtonText(CHOOSE_FOLDER);
			int state = fileChooser.showOpenDialog(view.getJframe());
			if (state == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				view.getController().notifySaveToXml(file);
			}
		} else {
			view.getController().notifySaveToXml();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	}
	
}
