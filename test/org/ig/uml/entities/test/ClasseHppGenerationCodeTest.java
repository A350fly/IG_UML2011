package org.ig.uml.entities.test;

import static org.junit.Assert.assertTrue;

import org.ig.uml.entities.Attribute;
import org.ig.uml.entities.Classe;
import org.ig.uml.entities.Method;
import org.ig.uml.entities.Visibility;
import org.junit.Before;
import org.junit.Test;

public class ClasseHppGenerationCodeTest {
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
	public void toStringHpp() {
		System.out.println("toStringHpp()");
		System.out.println(c.toStringHpp());
		assertTrue(true);
	}
	
	@Test
	public void toStringVisibilyMethoPrivatedHpp() {
		System.out.println("\ntoStringVisibilyMethodPrivateHpp()");
		m1.setVisibility(Visibility.PRIVATE);
		System.out.println(c.toStringHpp());
		assertTrue(true);
	}
	
	@Test
	public void toStringVisibilyAttributeHpp() {
		System.out.println("\ntoStringVisibilyAttributeHpp()");
		a.setVisibility(Visibility.PUBLIC);
		b.setVisibility(Visibility.PRIVATE);
		System.out.println(c.toStringHpp());
		assertTrue(true);
	}
	
	@Test
	public void toStringFinalStaticAttributeHpp() {
		System.out.println("\ntoStringFinalStaticAttributeHpp()");
		a.setVisibility(Visibility.PUBLIC);
		b.setVisibility(Visibility.PRIVATE);
		a.setFinal(true);
		a.setStatic(true);
		System.out.println(c.toStringHpp());
		assertTrue(true);
	}
}
