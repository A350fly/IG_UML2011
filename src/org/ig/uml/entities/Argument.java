package org.ig.uml.entities;

public class Argument {
	private String name;
	private String classType;
	private boolean isFinal;
	
	public Argument(String name, Class classType) {
		this.name = name;
		this.classType = classType.getName();
	}
}
