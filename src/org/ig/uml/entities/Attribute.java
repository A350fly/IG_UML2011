package org.ig.uml.entities;

public class Attribute {
	private String name;
	private Classe classe;
	private Visibility visibility;
	private boolean isFinal;
	private boolean isStatic;

	public Attribute(String name, Classe classe) {
		this.name = name;
		this.classe = classe;
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

	public Classe getClasse() {
		return classe;
	}

	public void setClassType(Classe classe) {
		this.classe = classe;
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
