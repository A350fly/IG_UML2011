package org.ig.uml.managers;

import java.util.HashSet;
import java.util.Set;

import org.ig.uml.UmlModel;
import org.ig.uml.entities.Attribute;
import org.ig.uml.entities.Classe;
import org.ig.uml.entities.Interface;
import org.ig.uml.entities.Method;

public class ComponentManager {

	private Set<Classe> classes;
	private Set<Interface> interfaces;
	private UmlModel model;

	public ComponentManager(UmlModel model) {
		this.model = model;
		classes = new HashSet<Classe>();
		interfaces = new HashSet<Interface>();
	}

	public Set<Classe> getClasses() {
		return classes;
	}

	public void setClasses(Set<Classe> classes) {
		this.classes = classes;
	}

	public Set<Interface> getInterfaces() {
		return interfaces;
	}

	public void setInterfaces(Set<Interface> interfaces) {
		this.interfaces = interfaces;
	}

	public void addClass(Classe newClass) {
		classes.add(newClass);
		model.fireDrawClass(newClass);
	}

	public void addInterface(Interface i) {
		interfaces.add(i);
		model.fireAddInterface(i);
	}

	public void addAttribute(Attribute attribute, Classe classe) {
		classe.getAttributes().add(attribute);
		model.fireDrawClass(classe);
	}
	
	public void addMethod(Method method, Classe classe) {
		classe.getMethods().add(method);
		model.fireDrawClass(classe);
	}
	
}