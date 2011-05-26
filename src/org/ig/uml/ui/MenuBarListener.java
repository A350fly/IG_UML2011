package org.ig.uml.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.ig.uml.UmlConstants;
import org.ig.uml.ui.events.CloseWindow;
import org.ig.uml.ui.events.ExportToImage;
import org.ig.uml.ui.events.NewFile;
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
    		new NewFile(view);
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
    		(new CloseWindow(view)).manageClosing();
    	}
    	else if (e.getActionCommand().equals(UmlConstants.CUT)) {
    		
    	}
    	else if (e.getActionCommand().equals(UmlConstants.COPY)) {
    		
    	}
    	else if (e.getActionCommand().equals(UmlConstants.PASTE)) {
    		
    	}
    	else if (e.getActionCommand().equals(UmlConstants.HELP)) {
    		new ManualFrame();
    	}
    	else if (e.getActionCommand().equals(UmlConstants.GENERATE_CODE)) {
    		new LanguageChoiceDialog(view);
    	}
    	else if (e.getActionCommand().equals(UmlConstants.A_PROPOS)) {
    		new AboutJFrame(view);
    	}
    	else if (e.getActionCommand().equals(UmlConstants.EXPORT_GRAPHIC)) {
    		new ExportToImage(view.getJframe());
    	}
    	else if (e.getActionCommand().equals(UmlConstants.PREFERENCES)) {
    		
    	}
    }
}
