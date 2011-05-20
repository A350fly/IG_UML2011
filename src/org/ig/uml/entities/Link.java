package org.ig.uml.entities;

public class Link {
	private LinkType linkType;
	private Object object;
	
	public Link(LinkType linkType, Interface i) {
		this.linkType = linkType;
		this.object = i;
	}
	
	public Link(LinkType linkType, Classe classe) {
		this.linkType = linkType;
		this.object = classe;
	}

	public void setLinkType(LinkType linkType) {
		this.linkType = linkType;
	}

	public LinkType getLinkType() {
		return linkType;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Object getObject() {
		return object;
	}

}
