package org.ig.uml.actions;

import java.io.File;

import javax.swing.JFileChooser;

import org.ig.uml.ui.JFrameUml;

public class OpenFile {

	private JFileChooser fileChooser;
	
	public OpenFile(JFrameUml frame) {
		fileChooser = new JFileChooser();
		fileChooser.setApproveButtonText("Ouvrir");
		
		int state = fileChooser.showOpenDialog(frame);
		if (state == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
		}
	}
}
