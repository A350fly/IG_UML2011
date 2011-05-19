package org.ig.uml.entities;

public class Argument {
	private String name;
	private Classe classe;
	private boolean isFinal;

	public Argument(String name, Classe classe) {
		this.name = name;
		this.classe = classe;
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

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}
}
