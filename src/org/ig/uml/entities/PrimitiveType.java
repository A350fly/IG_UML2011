package org.ig.uml.entities;

public enum PrimitiveType {
	Void("Void"),
	Integer("Integer"),
	String("String"),
	Boolean("Boolean"),
	Decimal("Decimal");
	
	private String name;
	
	PrimitiveType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
