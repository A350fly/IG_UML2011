package org.ig.uml.entities;

import java.util.HashSet;
import java.util.Set;

public class Class {
	private String name;
	private Visibility visibility;
	private Class baseClass;
	private Set<Attribute> attributes;
	private Set<Method> methods;
	private Set<Interface> interfaces;
	private boolean isFinal;
	private boolean isAbstract;
	
	public Class(String name) {
		this.name = name;
		visibility = Visibility.Package;
		attributes = new HashSet<Attribute>();
		methods = new HashSet<Method>();
		interfaces = new HashSet<Interface>();
		baseClass = null;
	}

	public String getName() {
		return name;
	}
}
