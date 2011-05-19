package org.ig.uml.entities;
import java.util.Set;

public class Method {
	private String name;
	private Visibility visibility;
	private String returnType;
	private Set<Argument> arguments;
	private boolean isFinal;
	private boolean isStatic;

	public Method(String name, Class classType) {
		this.name = name;
		visibility = Visibility.Package;
		returnType = classType.getName();	
	}
}
