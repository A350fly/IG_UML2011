package org.ig.uml.actions;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import org.ig.uml.ui.JFrameUml;

public class SaveFile {

	private JFileChooser fileChooser;
	private boolean firstSaved;
	
	/*
	 * save indique si une sauvegarde a déjà été effectuée
	 * si oui, le bouton Sauver ne proposera pas le gestionnaire de fichiers
	 */
	public SaveFile(JFrameUml frame, boolean save) {
		fileChooser = new JFileChooser();
		fileChooser.setSelectedFile(new File("."));
		fileChooser.setApproveButtonText("Sauvegarder");
		
		int state = fileChooser.showOpenDialog(frame);
		if (state == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			
			try {
				ImageIO.write(null, "JPEG", new File(file.getPath()));
			} catch (IOException e) {
			}
		}
	}
}
