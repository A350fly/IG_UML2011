package org.ig.uml.events;

import org.ig.uml.UmlModel;

public class SetFrameTitleEvent {
	private String title;
	
	public SetFrameTitleEvent(UmlModel umlModel, String title) {
		this.title = title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

}
