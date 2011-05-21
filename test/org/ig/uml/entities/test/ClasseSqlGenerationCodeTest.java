package org.ig.uml.entities.test;

import static org.junit.Assert.assertTrue;

import org.ig.uml.entities.Attribute;
import org.ig.uml.entities.Classe;
import org.ig.uml.entities.Method;
import org.junit.Before;
import org.junit.Test;

public class ClasseSqlGenerationCodeTest {
	Classe c = new Classe("HelloWorld");
	Classe c2 = new Classe("Integer");
	Attribute a = new Attribute("taille", c2);
	Attribute b = new Attribute("age", c2);
	Method m1 = new Method("getInstance", c2);
	Method m2 = new Method("getFactory", c2);

	@Before
	public void addElements() {
		c.getAttributes().add(a);
		c.getAttributes().add(b);
		c.getMethods().add(m1);
		c.getMethods().add(m2);
	}

	@Test
	public void toStringSql() {
		System.out.println("toStringSql()");
		System.out.println(c.toStringSql());
		assertTrue(true);
	}
}
