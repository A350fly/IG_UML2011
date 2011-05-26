package org.ig.uml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;

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
import org.ig.uml.events.DrawItemsEvent;
import org.ig.uml.events.DrawLinkEvent;
import org.ig.uml.events.SetFrameTitleEvent;
import org.ig.uml.managers.ComponentManager;
import org.ig.uml.utils.XmlTools;

public class UmlModel implements UmlConstants {
	private EventListenerList listeners;
	private ComponentManager componentManager;
	private UmlListener[] listenerList;
	private String currentLanguage;
	private File fileToSave;
	private boolean needSave;
	
	// Si on vient d'ouvrir un fichier ou si on a enregistré, il n'est pas 
	// nécessaire de lancer le fileChooser.
	private boolean needFilePathToSave;

	public UmlModel() {
		listeners = new EventListenerList();
		componentManager = new ComponentManager(this);
		listenerList = null;
		setCurrentLanguage("Java");
		needSave = false;
		needFilePathToSave = true;
		fileToSave = null;
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
	
	public void fireDrawItems(HashSet<Item> items) {
		for (UmlListener listener : listenerList) {
			listener.drawItems(new DrawItemsEvent(this, items));
		}
	}

	public void fireDrawLink(Link link, Item item) {
		for (UmlListener listener : listenerList) {
			listener.drawLink(new DrawLinkEvent(this, link, item));
		}
	}

	public void generateCode(File folder) {
		System.out.println("Generate in " + currentLanguage + "...");
		for(Item item : componentManager.getItems()) {
			item.generateCode(folder, currentLanguage);
		}
		System.out.println("Generate is done.");
	}

	public void setCurrentLanguage(String currentLanguage) {
		this.currentLanguage = currentLanguage;
	}

	public String getCurrentLanguage() {
		return currentLanguage;
	}

	public void saveToXml(File file) {
		try {
			XmlTools.encodeToFile(componentManager.getItems(), file);
			fileToSave = file;
			fireSetFrameTitle();
			needSave = false;
			needFilePathToSave = false;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveToXml() {
		try {
			XmlTools.encodeToFile(componentManager.getItems(), fileToSave);
			needSave = false;
			needFilePathToSave = false;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openXmlFile(File file) {
		try {
			HashSet<Item> items = (HashSet<Item>) XmlTools.decodeFromFile(file);
			fileToSave = file;
			componentManager.setItems(items);
			needSave = false;
			needFilePathToSave = false;
			fireDrawItems(componentManager.getItems());
			fireSetFrameTitle();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void fireSetFrameTitle() {
		for (UmlListener listener : listenerList) {
			listener.setFrameTitle(new SetFrameTitleEvent(this, getTitle()));
		}
	}
	
	private String getTitle() {
		String finalTitle = "";
		if(!needFilePathToSave) {
			finalTitle = fileToSave.getName() + " (" + fileToSave.getAbsolutePath() + ")" 
			+ " - "+ TITLE;
		} else {
			finalTitle = UNSAVED_FILE + " - "+ TITLE;
		}
		return finalTitle;
	}

	public UmlListener[] getListenerList() {
		return listenerList;
	}

	public void setListenerList(UmlListener[] listenerList) {
		this.listenerList = listenerList;
	}

	public void setListeners(EventListenerList listeners) {
		this.listeners = listeners;
	}

	public void setNeedSave(boolean needSave) {
		this.needSave = needSave;
	}

	public boolean isNeedSave() {
		return needSave;
	}

	public void setNeedFilePathToSave(boolean needFilePathToSave) {
		this.needFilePathToSave = needFilePathToSave;
	}

	public boolean isNeedFilePathToSave() {
		return needFilePathToSave;
	}

	public File getFileToSave() {
		return fileToSave;
	}

	public void setFileToSave(File fileToSave) {
		this.fileToSave = fileToSave;
	}

	public void newDraw() {
		HashSet<Item> items = new HashSet<Item>(); 
		componentManager.setItems(items);
		needSave = false;
		needFilePathToSave = true;
		fileToSave = null;
		fireSetFrameTitle();
		fireDrawItems(componentManager.getItems());
	}

}