package org.ig.uml.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Classe extends Item {
	private Set<Attribute> attributes;
	private boolean isFinal;
	private boolean isAbstract;
	
	public Classe(String name) {
		super(name);
		attributes = new HashSet<Attribute>();
	}
	
	public Classe (PrimitiveType primitiveType) {
		this(primitiveType.getName());
	}

	public Set<Attribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(Set<Attribute> attributes) {
		this.attributes = attributes;
	}


	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	public boolean isAbstract() {
		return isAbstract;
	}

	public void setAbstract(boolean isAbstract) {
		this.isAbstract = isAbstract;
	}

	/**
	 * public class Yellow extends Color { }
	 */
	public String toStringJava() {
		String res = "";
		res += importNeeded();
		res += getVisibility().toStringJava() + "class" + " " + getName() + " " 
		+ toStringExtendClassJava() + toStringImplementsInterfaceJava() 
		+ "{" + "\n";
		res += toStringAttributesJava();
		res += toStringMethodsJava();
		res += toStringGettersSettersJava();
		res += "}";
		return res;
	}

	private String importNeeded() {
		String res = "";
		for(Link link : getLinks()) {
			if(link.getLinkType() == LinkType.ASSOCIATION
					|| link.getLinkType() == LinkType.UNI_ASSOCIATION
					|| link.getLinkType() == LinkType.COMPOSITION
					|| link.getLinkType() == LinkType.AGGREGATION) {
				res = "import java.util.Vector;\n\n";
				return res;
			}
		}
		return res;
	}

	/**
	 * #ifndef test_h
	 * #define test_h
	 * 
	 * class test : public test2, public test3 {};
	 * 
	 * #endif // test_h
	 */
	public String toStringHpp() {
		String res = "";
		res += "#ifndef" + " " + getName().toUpperCase() + "_H" + "\n";
		res += "#define" + " " + getName().toUpperCase() + "_H" + "\n\n";
		res += toStringIncludeClassHpp();
		res += "class" + " " + getName() + toStringExtendAndImplementClassHpp() + " {" + "\n";
		res += toStringAttributesHpp();
		res += toStringMethodsHpp();
		
		res += "};" + "\n\n";
		res += "#endif";
		return res;
	}

	/**
	 * #include "test3.h"
	 */
	public String toStringCpp() {
		String res = "";
		res += "#include \"" + getName() + ".hpp\"\n\n";
		res += toStringMethodsCpp();
		res += toStringGettersSettersCpp();
		
		return res;
	}

	/**
	 * CREATE TABLE test (
	 * 		PRIMARY KEY ()
	 * );
	 */
	public String toStringSql() {
		String res = "";
		res += "CREATE TABLE " + getName() + " " + "(";
		res += "PRIMARY KEY ()" + "\n";
		res += toStringAttributesSql();
		res += ");";
		return res;
	}
	
	private String toStringExtendClassJava() {
		String res = "";
		for(Link link : getLinks()) {
			if(link.getLinkType() == LinkType.GENERALIZATION) {
				return "extends" + link.getItem().getName() + " ";
			}
		}
		return res;
	}
	
	/**
	 * class test : public test2, public test3, virtual public interfaceTest {};
	 */
	private String toStringExtendAndImplementClassHpp() {
		String res = "";
		boolean generalizationFound = false;
		for(Link link : getLinks()) {
			if(link.getLinkType() == LinkType.GENERALIZATION) {
				res += "public " + link.getItem().getName() + ", ";
			} else if (link.getLinkType() == LinkType.REALIZATION) {
				res += "virtual public " + link.getItem().getName() + ", ";
			}
			generalizationFound = true;
		}
		if(generalizationFound) {
			res = ": " + res;
			// On enlève le ', ' à la fin
			res = res.substring(0, res.length() - 1);
			res += " ";
		}
		return res;
	}
	
	/**
	 * #include "test2.hpp"
	 * #include "test3.hpp"
	 */
	private String toStringIncludeClassHpp() {
		String res = "";
		boolean includeFound = false;
		for(Link link : getLinks()) {
			if(link.getLinkType() == LinkType.GENERALIZATION) {
				res += "#include " + link.getItem().getName() + ".hpp\n";
				includeFound = true;
			}
		}
		if(includeFound)
			res += "\n";
		return res;
	}
	
	/**
	 * class test implements testInterface, testInterface2 {}
	 */
	private String toStringImplementsInterfaceJava() {
		String res = "";
		boolean realizationFound = false;
		for(Link link : getLinks()) {
			if(link.getLinkType() == LinkType.REALIZATION) {
				res += link.getItem().getName() + ", ";
			}
			realizationFound = true;
		}
		if(realizationFound) {
			res = "implements " + res;
			// On enlève le ', ' à la fin
			res = res.substring(0, res.length() - 1);
			res += " ";
		}
		return res;
	}
	
	/**
	 * public void newOperation(String arg2) { }
	 */
	private String toStringMethodsJava() {
		String res = "";
		for(Method method : getMethods()) {
			res += "\t" + method.toStringJava();
		}
		res = "\n" + res;
		//Enlève le dernier saut de ligne
		res = res.substring(0, res.length() - 1);
		
		return res;
	}

	/**
 	 * public:
     * 		virtual void newOperation(String arg2);
     * private:
     * 		virtual void operation2(int i);
	 */
	private String toStringMethodsHpp() {
		String res = "";
		String privateMethods = "";
		String publicMethods = "";
		boolean publicMethodFound = false;
		boolean privateMethodFound = false;
		
		for(Method method : getMethods()) {
			if(method.getVisibility() == Visibility.PUBLIC) {
				publicMethodFound = true;
				publicMethods += "\t" + method.toStringHpp();
			} else if(method.getVisibility() == Visibility.PRIVATE) {
				privateMethodFound = true;
				privateMethods += "\t" + method.toStringHpp();
			}
		}
		for(Attribute attribute : attributes) {	
			//Getter
			String firstLetterName = "" + attribute.getName().charAt(0);
			firstLetterName = firstLetterName.toUpperCase();
			String nameForMethod = firstLetterName + attribute.getName().substring(1);
			publicMethods += "\t" + attribute.getClasse().getName() + " ";
			publicMethods += "get" + nameForMethod;
			publicMethods += "();\n";
			//Setter
			publicMethods += "\tvoid set" + nameForMethod + "(";
			publicMethods += attribute.getClasse().getName() + " ";
			publicMethods += attribute.getName();
			publicMethods += ");\n";
		}
		if(publicMethodFound) {
			res += "public : \n";
			res += publicMethods;
		}
		
		if(privateMethodFound) {
			res += "private : \n";
			res += privateMethods;
		}
		return res;
	}	
	
	/**
	 * void test::newOperation(String arg2) { }
	 */
	private String toStringMethodsCpp() {
		String res = "";
		for(Method method : getMethods()) {
			if(method.getVisibility() == Visibility.PUBLIC
					|| method.getVisibility() == Visibility.PRIVATE) {
				res += method.getReturnType().getName() + " ";
				res += getName() + "::" + method.toStringCpp();
			}
		}
		return res;
	}
	
	/**
	 * class test {
	 * 		public static final Integer newAttr;
	 * }
	 */
	private String toStringAttributesJava() {
		String res = "";
		for(Attribute attribute : attributes) {
			res += "\t" + attribute.toStringJava();
		}
		res += tosStringAttributesLinkJava();
		return res;
	}	
	
	/**
	 * Si la classe est HelloWorld, le nom de l'attribut est myHelloWorld.
	 * Si on a 2 associations vers une même classe, la deuxième prend le nom
	 * name1, puis name2 et ainsi de suite. On prend donc soin d'incrémenter
	 * i et de l'ajouter à la fin du nom de l'attribut lorsqu'on tombe sur un 
	 * double.
	 */
	private String tosStringAttributesLinkJava() {
		String res = "";
		String attributeName = "";
		
		int i = 1;
		
		List<String> classesName = new ArrayList<String>();
		for(Link link : getLinks()) {
			if(link.getLinkType() == LinkType.ASSOCIATION
					|| link.getLinkType() == LinkType.UNI_ASSOCIATION
					|| link.getLinkType() == LinkType.COMPOSITION
					|| link.getLinkType() == LinkType.AGGREGATION) {
				attributeName = "my" + link.getItem().getName();
				if(classesName.contains(attributeName))
					attributeName = attributeName + i++;
				res += "\tpublic Vector<" + link.getItem().getName() + ">";
				res += " " + attributeName + ";\n";
				classesName.add(attributeName);
			}
		}
		
		return res;
	}
	
	private String tosStringAttributesLinkHpp() {
		String res = "";
		String attributeName = "";
		
		int i = 1;
		
		List<String> classesName = new ArrayList<String>();
		for(Link link : getLinks()) {
			if(link.getLinkType() == LinkType.ASSOCIATION
					|| link.getLinkType() == LinkType.UNI_ASSOCIATION
					|| link.getLinkType() == LinkType.COMPOSITION) {
				attributeName = "my" + link.getClass().getName();
				if(classesName.contains(attributeName))
					attributeName = attributeName + i++;
				res += "\t" + link.getClass().getName();
				res += " *" + attributeName + "\n";
				classesName.add(attributeName);
			}
		}
		
		return res;
	}

	/**
	 * class test {
	 *  public:
	 *  	static const Integer newAttr;
	 *  }
	 */
	private String toStringAttributesHpp() {
		String res = "";
		String privateAttributes = "";
		String publicAttributes = "";
		boolean publicAttributesFound = false;
		boolean privateAttributesFound = false;
		
		for(Attribute attribute : getAttributes()) {
			if(attribute.getVisibility() == Visibility.PUBLIC) {
				publicAttributesFound = true;
				publicAttributes += "\t" + attribute.toStringHpp();
			} else if(attribute.getVisibility() == Visibility.PRIVATE) {
				privateAttributesFound = true;
				privateAttributes += "\t" + attribute.toStringHpp();
			}
		}
		if(publicAttributesFound) {
			res += "public : \n";
			res += publicAttributes;
		}
		
		if(privateAttributesFound) {
			res += "private : \n";
			res += privateAttributes;
		}
		return res;
	}	
	
	/**
	 * CREATE TABLE test (
	 * 		newAttr Integer,
	 * PRIMARY KEY ()
	 * );
	 */
	private String toStringAttributesSql() {		
		String res = "";
		for(Attribute attribute : attributes) {
			res += "\t" + attribute.toStringSql();
		}
		return res;
	}
	
	private String toStringGettersSettersJava() {
		String res = "";
		for(Attribute attribute : attributes) {
			//Getter
			String firstLetterName = "" + attribute.getName().charAt(0);
			firstLetterName = firstLetterName.toUpperCase();
			String nameForMethod = firstLetterName + attribute.getName().substring(1);
			res += "\n\tpublic " + attribute.getClasse().getName() + " ";
			res += "get" + nameForMethod;
			res += "() {\n";
			res += "\t\treturn " + attribute.getName() + ";\n";
			res += "\t}\n\n";
			//Setter
			res += "\tpublic void set" + nameForMethod + "(";
			res += attribute.getClasse().getName() + " ";
			res += attribute.getName();
			res += ") {\n";
			res += "\t\tthis." + attribute.getName() + " = ";
			res += attribute.getName();
			res += ";\n";
			res += "\t}\n";
		}
		res += toStringGettersSettersLink();
		return res;
	}
	
	private String toStringGettersSettersLink() {
		String res = "";
		
		return res;
	}

	private String toStringGettersSettersCpp() {
		String res = "";
		for(Attribute attribute : attributes) {
			//Getter
			String firstLetterName = "" + attribute.getName().charAt(0);
			firstLetterName = firstLetterName.toUpperCase();
			String nameForMethod = firstLetterName + attribute.getName().substring(1);
			res += attribute.getClasse().getName() + " ";
			res += getName() + "::";
			res += "get" + nameForMethod;
			res += "() {\n";
			res += "\treturn " + attribute.getName() + ";\n";
			res += "}\n\n";
			//Setter
			res += "void ";
			res += getName() + "::";
			res += "set" + nameForMethod + "(";
			res += attribute.getClasse().getName() + " ";
			res += "new" + nameForMethod; 
			res += ") {\n";
			res += "\t" + attribute.getName() + " = ";
			res += "new" + nameForMethod + ";\n";
			res += "}\n\n";
		}
		return res;
	}
}
