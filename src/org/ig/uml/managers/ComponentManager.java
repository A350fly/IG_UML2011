package org.ig.uml.managers;

import java.util.HashSet;
import java.util.Set;

import org.ig.uml.UmlModel;
import org.ig.uml.entities.Attribute;
import org.ig.uml.entities.Classe;
import org.ig.uml.entities.Item;
import org.ig.uml.entities.Link;
import org.ig.uml.entities.Method;

public class ComponentManager {

	private Set<Item> items;
	private UmlModel model;

	public ComponentManager(UmlModel model) {
		this.model = model;
		items = new HashSet<Item>();
	}

	public void addItem(Item item) {
		items.add(item);
		model.fireDrawItem(item);
	}

	public void addLink(Link link, Item item) {
		item.getLinks().add(link);
		model.fireDrawLink(link, item);
	}
	
	public void addAttribute(Attribute attribute, Classe classe) {
		classe.getAttributes().add(attribute);
		model.fireDrawItem(classe);
	}
	
	public void addMethod(Method method, Item item) {
		item.getMethods().add(method);
		model.fireDrawItem(item);
	}

	public Set<Item> getItems() {
		return items;
	}
}