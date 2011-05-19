package org.ig.uml.entities;

import java.util.HashSet;
import java.util.Set;

public class Interface {
	private String name;
	private Visibility visibility;
	private Interface baseInterface;
	private Set<Method> methods;
	
	public Interface(String name) {
		this.name = name;
		visibility = Visibility.Package;
		methods = new HashSet<Method>();
		baseInterface = null;
	}
}
