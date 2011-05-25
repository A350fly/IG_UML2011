package org.ig.uml.utils;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public final class XmlTools {

    private XmlTools() {}
	
    /**
     * Serialisation d'un objet dans un fichier
     * @param object objet a serialiser
     * @param filename chemin du fichier
     */
    public static void encodeToFile(Object object, File file) 
    		throws FileNotFoundException, IOException {
        // ouverture de l'encodeur vers le fichier
        XMLEncoder encoder = new XMLEncoder(new FileOutputStream(file));
        try {
            // serialisation de l'objet
            encoder.writeObject(object);
            encoder.flush();
        } finally {
            // fermeture de l'encodeur
            encoder.close();
        }
    }
    
	/**
	 * Deserialisation d'un objet depuis un fichier
	 * @param filename chemin du fichier
	 */
	public static Object decodeFromFile(File file) 
			throws FileNotFoundException, IOException {
	    Object object = null;
	    // ouverture de decodeur
	    XMLDecoder decoder = new XMLDecoder(new FileInputStream(file));
	    try {
	        // deserialisation de l'objet
	        object = decoder.readObject();
	    } finally {
	        // fermeture du decodeur
	        decoder.close();
	    }
	    return object;
	}
}