package org.ig.uml.managers;

import java.util.HashSet;

import org.ig.uml.UmlModel;
import org.ig.uml.entities.Attribute;
import org.ig.uml.entities.Classe;
import org.ig.uml.entities.Item;
import org.ig.uml.entities.Link;
import org.ig.uml.entities.Method;

public class ComponentManager {

	private HashSet<Item> items;
	private UmlModel model;

	public ComponentManager() {
		this.model = null;
		items = new HashSet<Item>();
		
		// Types primitifs
		// TODO : Créer une classe Primitives représentant les types primitifs
		items.add(new Classe("int"));
		items.add(new Classe("float"));
		items.add(new Classe("long"));
		items.add(new Classe("boolean"));
		items.add(new Classe("String"));
	}
	
	public ComponentManager(UmlModel model) {
		this.model = model;
		items = new HashSet<Item>();
		
		// Types primitifs
		// TODO : Créer une classe Primitives représentant les types primitifs
		items.add(new Classe("int"));
		items.add(new Classe("float"));
		items.add(new Classe("long"));
		items.add(new Classe("boolean"));
		items.add(new Classe("String"));
		items.add(new Classe("void"));
	}

	public void addItem(Item item) {
		items.add(item);
		model.setNeedSave(true);
		model.fireDrawItem(item);
	}

	public void addLink(Link link, Item item) {
		item.getLinks().add(link);
		model.setNeedSave(true);
		model.fireDrawLink(link, item);
	}
	
	public void addAttribute(Attribute attribute, Classe classe) {
		classe.getAttributes().add(attribute);
		model.setNeedSave(true);
		model.fireDrawItem(classe);
	}
	
	public void addMethod(Method method, Item item) {
		item.getMethods().add(method);
		model.setNeedSave(true);
		model.fireDrawItem(item);
	}

	public HashSet<Item> getItems() {
		return items;
	}

	public UmlModel getModel() {
		return model;
	}

	public void setModel(UmlModel model) {
		this.model = model;
	}

	public void setItems(HashSet<Item> items) {
		this.items = items;
	}
}