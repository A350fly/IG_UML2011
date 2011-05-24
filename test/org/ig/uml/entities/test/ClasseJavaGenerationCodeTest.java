package org.ig.uml.entities.test;

import static org.junit.Assert.assertTrue;

import org.ig.uml.entities.Attribute;
import org.ig.uml.entities.Classe;
import org.ig.uml.entities.Link;
import org.ig.uml.entities.LinkType;
import org.ig.uml.entities.Method;
import org.ig.uml.entities.Visibility;
import org.junit.Before;
import org.junit.Test;

public class ClasseJavaGenerationCodeTest {
	Classe c = new Classe("HelloWorld");
	Classe c2 = new Classe("Integer");
	Attribute a = new Attribute("taille", c2);
	Attribute b = new Attribute("age", c2);
	Method m1 = new Method("getInstance", c2);
	Method m2 = new Method("getFactory", c2);
	Link l = new Link(LinkType.ASSOCIATION, c2);
	Link l2 = new Link(LinkType.ASSOCIATION, c2);
	Link l3 = new Link(LinkType.GENERALIZATION, c2);
	Link l4 = new Link(LinkType.REALIZATION, c2);
	Link l5 = new Link(LinkType.REALIZATION, c2);
	
	@Before
	public void addElements() {
		c.getAttributes().add(a);
		c.getAttributes().add(b);
		c.getMethods().add(m1);
		c.getMethods().add(m2);
		c.getLinks().add(l);
		c.getLinks().add(l2);
		c.getLinks().add(l3);
		c.getLinks().add(l4);
		c.getLinks().add(l5);
	}

	@Test
	public void toStringJava() {
		System.out.println(c.toStringJava());
		assertTrue(true);
	}
	
	@Test
	public void toStringVisibilyPackageClassJava() {
		c.setVisibility(Visibility.PACKAGE);
		System.out.println(c.toStringJava());
		assertTrue(true);
	}
	
	@Test
	public void toStringVisibilyPrivateClassJava() {
		c.setVisibility(Visibility.PRIVATE);
		System.out.println(c.toStringJava());
		assertTrue(true);
	}
	
	@Test
	public void toStringVisibilyMethodJava() {
		m1.setVisibility(Visibility.PACKAGE); 
		m2.setVisibility(Visibility.PRIVATE);
		System.out.println(c.toStringJava());
		assertTrue(true);
	}
	
	@Test
	public void toStringVisibilyAttributeJava() {
		a.setVisibility(Visibility.PUBLIC);
		b.setVisibility(Visibility.PACKAGE);
		System.out.println(c.toStringJava());
		assertTrue(true);
	}
	
	@Test
	public void toStringFinalStaticAttributeJava() {
		a.setVisibility(Visibility.PUBLIC);
		b.setVisibility(Visibility.PRIVATE);
		a.setFinal(true);
		a.setStatic(true);
		System.out.println(c.toStringJava());
		assertTrue(true);
	}
}
