package org.ig.uml.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.ig.uml.UmlConstants;
import org.ig.uml.actions.SaveFile;
import org.ig.uml.ui.events.OpenFileXmlFile;
import org.ig.uml.ui.events.SaveFileToXml;
import org.ig.uml.ui.notifications.AboutJFrame;
import org.ig.uml.ui.notifications.LanguageChoiceDialog;

public class MenuBarListener implements ActionListener {

	private SwingUmlView view;
	
	public MenuBarListener(SwingUmlView view) {
		this.view = view;
	}
	
    public void actionPerformed(ActionEvent e) {
    	if (e.getActionCommand().equals(UmlConstants.NEW)) {
    		
    	}
    	else if (e.getActionCommand().equals(UmlConstants.OPEN)) {
    		new OpenFileXmlFile(view);
    	}
    	else if (e.getActionCommand().equals(UmlConstants.SAVE)) {
    		new SaveFileToXml(view);
    	}
    	else if (e.getActionCommand().equals(UmlConstants.SAVE_AS)) {
    		new SaveFileToXml(view);
    	}
    	else if (e.getActionCommand().equals(UmlConstants.QUIT)) {
    		System.exit(0);
    	}
    	else if (e.getActionCommand().equals(UmlConstants.REDO)) {
    		
    	}
    	else if (e.getActionCommand().equals(UmlConstants.UNDO)) {
    		
    	}
    	else if (e.getActionCommand().equals(UmlConstants.CUT)) {
    		
    	}
    	else if (e.getActionCommand().equals(UmlConstants.COPY)) {
    		
    	}
    	else if (e.getActionCommand().equals(UmlConstants.PASTE)) {
    		
    	}
    	else if (e.getActionCommand().equals(UmlConstants.HELP)) {
    		
    	}
    	else if (e.getActionCommand().equals(UmlConstants.GENERATE_CODE)) {
    		new LanguageChoiceDialog(view);
    	}
    	else if (e.getActionCommand().equals(UmlConstants.A_PROPOS)) {
    		new AboutJFrame(view);
    	}
    	else if (e.getActionCommand().equals(UmlConstants.EXPORT_GRAPHIC)) {
    		new SaveFile(view.getJframe(), true);
    	}
    	else if (e.getActionCommand().equals(UmlConstants.PREFERENCES)) {
    		
    	}
    }
}
