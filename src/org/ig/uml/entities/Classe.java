package org.ig.uml.entities;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

public class Classe {
	private String name;
	private Visibility visibility;
	private Set<Attribute> attributes;
	private Set<Method> methods;
	private Set<Link> links;
	private boolean isFinal;
	private boolean isAbstract;
	private Point positionOnSurface;
	
	public Classe(String name) {
		this.name = name;
		visibility = Visibility.PACKAGE;
		attributes = new HashSet<Attribute>();
		methods = new HashSet<Method>();
		links = new HashSet<Link>();
		positionOnSurface.setLocation(-1, -1);
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

	public Point getPositionOnSurface() {
		return positionOnSurface;
	}

	public void setPositionOnSurface(Point positionOnSurface) {
		this.positionOnSurface = positionOnSurface;
	}

	public void setLinks(Set<Link> links) {
		this.links = links;
	}

	public Set<Link> getLinks() {
		return links;
	}
}
