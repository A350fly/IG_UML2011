package org.ig.uml.ui.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import org.ig.uml.ui.SwingUmlView;
import org.ig.uml.ui.notifications.LanguageChoiceDialog;

public class GenerateCode implements ActionListener {

	private SwingUmlView view;
	private LanguageChoiceDialog languageChoiceDialog;
	private JFileChooser fileChooser;

	public GenerateCode(LanguageChoiceDialog lcd, SwingUmlView view) {
		fileChooser = new JFileChooser();
		this.languageChoiceDialog = lcd;
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		this.view = view;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		languageChoiceDialog.dispose();
		fileChooser.setApproveButtonText("Choisir un dossier");

		int state = fileChooser.showOpenDialog(view.getJframe());
		if (state == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			view.getController().notifySave(file);
		}

	}
}
