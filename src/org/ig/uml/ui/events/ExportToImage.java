package org.ig.uml.ui.events;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import org.ig.uml.UmlConstants;
import org.ig.uml.ui.JFrameUml;

public class ExportToImage implements UmlConstants {

	private JFileChooser fileChooser;
	
	public ExportToImage(JFrameUml frame) {
		fileChooser = new JFileChooser();
		fileChooser.setSelectedFile(new File("."));
		fileChooser.setApproveButtonText(EXPORT_IMAGE);
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		
		int state = fileChooser.showOpenDialog(frame);
		if (state == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			
			BufferedImage image = new BufferedImage(frame.getPaintSurface().getWidth(),
					frame.getPaintSurface().getHeight(), BufferedImage.TYPE_INT_ARGB);
			frame.getPaintSurface().paint(image.getGraphics());
			try {
				ImageIO.write(image, "PNG", new File(file, "diagramme.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
