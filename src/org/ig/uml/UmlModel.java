package org.ig.uml;

import java.io.File;

import javax.swing.event.EventListenerList;

import org.ig.uml.entities.Argument;
import org.ig.uml.entities.Attribute;
import org.ig.uml.entities.Classe;
import org.ig.uml.entities.Interface;
import org.ig.uml.entities.Item;
import org.ig.uml.entities.Link;
import org.ig.uml.entities.LinkType;
import org.ig.uml.entities.Method;
import org.ig.uml.events.DrawItemEvent;
import org.ig.uml.events.DrawLinkEvent;
import org.ig.uml.managers.ComponentManager;

public class UmlModel {
	private EventListenerList listeners;
	private ComponentManager componentManager;
	private UmlListener[] listenerList;
	private String currentLanguage;

	public UmlModel() {
		listeners = new EventListenerList();
		componentManager = new ComponentManager(this);
		listenerList = null;
		setCurrentLanguage("Java");
		
		//test
		Classe c = new Classe("CarToy");
		Classe c2 = new Classe("Car");
		Classe c3 = new Classe("Engine");
		Interface toy = new Interface("Toy");
		Attribute a = new Attribute("voiture", c2);
		Attribute b = new Attribute("camion", c2);
		Argument arg1 = new Argument("engine", c3);
		Method m1 = new Method("getInstance", c2);
		Method m2 = new Method("getFactory", c2);
		Method m3 = new Method("getSource", c2);
		Link l = new Link(LinkType.ASSOCIATION, c2);
		Link l2 = new Link(LinkType.ASSOCIATION, c3);
		Link l3 = new Link(LinkType.GENERALIZATION, c3);
		Link l4 = new Link(LinkType.GENERALIZATION, c2);
		Link l5 = new Link(LinkType.REALIZATION, toy);
		
		c.getAttributes().add(a);
		c.getAttributes().add(b);
		c.getMethods().add(m1);
		c.getMethods().add(m2);
		c.getLinks().add(l);
		c.getLinks().add(l2);
		c.getLinks().add(l3);
		c.getLinks().add(l4);
		c.getLinks().add(l5);
		m3.getArguments().add(arg1);
		toy.getMethods().add(m3);
		componentManager.getItems().add(c);
		componentManager.getItems().add(c2);
		componentManager.getItems().add(c3);
		componentManager.getItems().add(toy);
	}

	public void addUmlListener(UmlListener listener) {
		listeners.add(UmlListener.class, listener);
		listenerList = (UmlListener[]) listeners.getListeners(UmlListener.class);
	}

	public void removeUmlListener(UmlListener listener) {
		listeners.remove(UmlListener.class, listener);
		listenerList = (UmlListener[]) listeners.getListeners(UmlListener.class);
	}

	public EventListenerList getListeners() {
		return listeners;
	}

	public void start() {
	}

	public void setComponentManager(ComponentManager componentManager) {
		this.componentManager = componentManager;
	}

	public ComponentManager getComponentManager() {
		return componentManager;
	}

	public void fireDrawItem(Item item) {
		for (UmlListener listener : listenerList) {
			listener.drawItem(new DrawItemEvent(this, item));
		}
	}

	public void fireDrawLink(Link link, Item item) {
		for (UmlListener listener : listenerList) {
			listener.drawLink(new DrawLinkEvent(this, link, item));
		}
	}

	public void save(File folder) {
		System.out.println("Generate in " + currentLanguage + "...");
		for(Item item : componentManager.getItems()) {
			item.save(folder, currentLanguage);
		}
		System.out.println("Generate is done.");
	}

	public void setCurrentLanguage(String currentLanguage) {
		this.currentLanguage = currentLanguage;
	}

	public String getCurrentLanguage() {
		return currentLanguage;
	}
}