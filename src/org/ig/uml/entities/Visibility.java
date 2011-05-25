package org.ig.uml.entities;

public enum Visibility {
	PUBLIC("public"),
	PACKAGE("package"),
	PROTECTED("protected"),
	PRIVATE("private");
	
	String name;
	
	Visibility(String name) {
		this.name = name;
	}
	
	public String toStringJava() {
		if (name.equals("package"))
			return "";
		return name + " ";
	}
}
