package org.ig.uml.entities;

public class Argument {
	private String name;
	private Item item;
	private boolean isFinal;

	public Argument() {
		this.name = "anonymous";
		this.item = null;
	}
	
	public Argument(String name, Item item) {
		this.name = name;
		this.item = item;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}
}
