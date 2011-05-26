package org.ig.uml.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.ig.uml.UmlConstants;
import org.ig.uml.ui.events.NewFile;
import org.ig.uml.ui.events.OpenFileXmlFile;
import org.ig.uml.ui.events.SaveFileToXml;

public class ToolBarListener implements ActionListener {

	private SwingUmlView view;
	
	public ToolBarListener(SwingUmlView view) {
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
	}
}
