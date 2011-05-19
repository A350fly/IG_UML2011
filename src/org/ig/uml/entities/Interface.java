package org.ig.uml.entities;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class Interface {
	private String name;
	private Visibility visibility;
	private Interface baseInterface;
	private Set<Method> methods;
	private Point positionOnSurface;
	
	public Interface(String name) {
		this.name = name;
		visibility = Visibility.PACKAGE;
		methods = new HashSet<Method>();
		baseInterface = null;
		positionOnSurface.setLocation(-1, -1);
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

	public Interface getBaseInterface() {
		return baseInterface;
	}

	public void setBaseInterface(Interface baseInterface) {
		this.baseInterface = baseInterface;
	}

	public Set<Method> getMethods() {
		return methods;
	}

	public void setMethods(Set<Method> methods) {
		this.methods = methods;
	}	
	
	public Point getPositionOnSurface() {
		return positionOnSurface;
	}

	public void setPositionOnSurface(Point positionOnSurface) {
		this.positionOnSurface = positionOnSurface;
	}
}
