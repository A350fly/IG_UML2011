package org.ig.uml.entities;

public class Attribute {
	private String name;
	private String classType;
	private Visibility visibility;
	private boolean isFinal;
	private boolean isStatic;
	
	public Attribute(String name, Class classType) {
		this.name = name;
		this.classType = classType.getName();
		visibility = Visibility.Package;
		isFinal = false;
		isStatic = false;
	}

}
