package org.ig.uml.ui.events;

import javax.swing.JOptionPane;

import org.ig.uml.UmlConstants;
import org.ig.uml.ui.SwingUmlView;

public class NewFile implements UmlConstants {
	SwingUmlView view;
	
	public NewFile(SwingUmlView view) {
		this.view = view;		
		if(view.getController().getumlModel().isNeedSave()) {    
			String[] choices = {
				      SAVE_NEW, NO_SAVE_NEW, CANCEL 
				};
			    int result = JOptionPane.showOptionDialog(view.getJframe(),
			    	      UNSAVED_CHANGE_NEW, WARNING,
			    	      JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, 
			    	      null, choices, choices[0]);
			    switch(result) {
			    case -1:
			    	break;
			    case 0:  // save and open	
			    	new SaveFileToXml(view);
			    	view.getController().notifyNewDraw();
			    	break;
			    case 1:  // just open
			    	view.getController().notifyNewDraw();
			    	break;
			    case 2:  // cancel
			    	break;
			    default:
			      throw new IllegalArgumentException("Unexpected return " + result);
			    }
			} else {
		    	view.getController().notifyNewDraw();
			}
	}
}
