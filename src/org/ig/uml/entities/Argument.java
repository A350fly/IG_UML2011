package org.ig.uml.entities;

public class Argument {
	private String name;
	private Class classType;
	private boolean isFinal;

	public Argument(String name, Class classType) {
		this.name = name;
		this.classType = classType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Class getClassType() {
		return classType;
	}

	public void setClassType(Class classType) {
		this.classType = classType;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}
}
