package org.ig.uml.entities;

import java.awt.Point;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

public abstract class Item {

	private String name;
	private Visibility visibility;
	private Set<Method> methods;
	private Set<Link> links;
	private Point positionOnSurface;
	
	public Item(String name) {
		this.name = name;
		visibility = Visibility.PUBLIC;
		methods = new HashSet<Method>();
		links = new HashSet<Link>();
		positionOnSurface = new Point();
		positionOnSurface.setLocation(-1, -1);
	}
	
	public Set<Method> getMethods() {
		return methods;
	}

	public void setMethods(Set<Method> methods) {
		this.methods = methods;
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

	public abstract void save(File folder, String currentLanguage);
}