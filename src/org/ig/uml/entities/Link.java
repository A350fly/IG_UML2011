package org.ig.uml.entities;

public class Link {
	private LinkType linkType;
	private Item item;

	public Link() {
		this.linkType = null;
		this.item = null;
	}
	
	public Link(LinkType linkType, Item item) {
		this.linkType = linkType;
		this.item = item;
	}
	
	public void setLinkType(LinkType linkType) {
		this.linkType = linkType;
	}

	public LinkType getLinkType() {
		return linkType;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Item getItem() {
		return item;
	}
}
