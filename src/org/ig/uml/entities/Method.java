package org.ig.uml.entities;
import java.util.Set;

public class Method {
	private String name;
	private Visibility visibility;
	private Classe returnType;
	private Set<Argument> arguments;
	private boolean isFinal;
	private boolean isStatic;

	public Method(String name, Classe classe) {
		this.name = name;
		visibility = Visibility.Package;
		returnType = classe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	public Classe getReturnType() {
		return returnType;
	}

	public void setReturnType(Classe returnType) {
		this.returnType = returnType;
	}

	public Set<Argument> getArguments() {
		return arguments;
	}

	public void setArguments(Set<Argument> arguments) {
		this.arguments = arguments;
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
