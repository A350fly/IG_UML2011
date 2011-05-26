package org.ig.uml.ui.events;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.ig.uml.UmlConstants;
import org.ig.uml.ui.SwingUmlView;

public class CloseWindow implements WindowListener, UmlConstants {
	
	private SwingUmlView view;
	
	public CloseWindow(SwingUmlView view) {
		this.view = view;
	}

	public void windowActivated(WindowEvent arg0) { }
	public void windowClosed(WindowEvent arg0) { }
	public void windowClosing(WindowEvent arg0) { 
		manageClosing();
	}
	public void manageClosing() {
		if(view.getController().getumlModel().isNeedSave()) {    
			String[] choices = {
			      SAVE_QUIT, NO_SAVE_QUIT, CANCEL 
			};
		    int result = JOptionPane.showOptionDialog(view.getJframe(),
		    	      UNSAVED_CHANGE, WARNING,
		    	      JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, 
		    	      null, choices, choices[0]);
		    switch(result) {
		    case -1:
//		      System.out.println("You killed my die-alog - it died");
		    case 0:  // save and quit	
		    	if(view.getController().getumlModel().isNeedFilePathToSave()){
			    	File file;
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setApproveButtonText(CHOOSE_FOLDER);
					int state = fileChooser.showOpenDialog(view.getJframe());
					if (state == JFileChooser.APPROVE_OPTION) {
						file = fileChooser.getSelectedFile();
						view.getController().notifySaveToXml(file);
					}
				} else {
						view.getController().notifySaveToXml();
				}
		    case 1:  // just quit
		    	System.exit(0);
		    	break;
		    case 2:  // cancel
		    	break;
		    default:
		      throw new IllegalArgumentException("Unexpected return " + result);
		    }
		} else {
			System.exit(0);
		}
	}
	public void windowDeactivated(WindowEvent arg0) { }
	public void windowDeiconified(WindowEvent arg0) { }
	public void windowIconified(WindowEvent arg0) { }
	public void windowOpened(WindowEvent arg0) { }
}