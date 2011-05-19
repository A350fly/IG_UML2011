package org.ig.uml.entities;

import java.util.HashSet;
import java.util.Set;

public class Classe {
	private String name;
	private Visibility visibility;
	private Set<Classe> baseClasses;
	private Set<Attribute> attributes;
	private Set<Method> methods;
	private Set<Interface> interfaces;
	private boolean isFinal;
	private boolean isAbstract;
	
	public Classe(String name) {
		this.name = name;
		visibility = Visibility.Package;
		attributes = new HashSet<Attribute>();
		methods = new HashSet<Method>();
		interfaces = new HashSet<Interface>();
		baseClasses = new HashSet<Classe>();
	}
	
	public Classe (PrimitiveType primitiveType) {
		this(primitiveType.getName());
	}

	public String getName() {
		return name;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	public Set<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<Attribute> attributes) {
		this.attributes = attributes;
	}

	public Set<Method> getMethods() {
		return methods;
	}

	public void setMethods(Set<Method> methods) {
		this.methods = methods;
	}

	public Set<Interface> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(Set<Interface> interfaces) {
		this.interfaces = interfaces;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	public boolean isAbstract() {
		return isAbstract;
	}

	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBaseClasses(Set<Classe> baseClasses) {
		this.baseClasses = baseClasses;
	}

	public Set<Classe> getBaseClasses() {
		return baseClasses;
	}
}
