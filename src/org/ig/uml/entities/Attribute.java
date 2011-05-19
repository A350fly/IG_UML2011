package org.ig.uml.entities;

public class Attribute {
	private String name;
	private Class classType;
	private Visibility visibility;
	private boolean isFinal;
	private boolean isStatic;

	public Attribute(String name, Class classType) {
		this.name = name;
		this.classType = classType;
		visibility = Visibility.Package;
		isFinal = false;
		isStatic = false;
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

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}
}
