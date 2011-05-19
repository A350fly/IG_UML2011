package org.ig.uml.entities;

public enum PrimitiveType {
	VOID("Void"),
	INTEGER("Integer"),
	STRING("String"),
	BOOLEAN("Boolean"),
	DECIMAL("Decimal");
	
	private String name;
	
	PrimitiveType(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
