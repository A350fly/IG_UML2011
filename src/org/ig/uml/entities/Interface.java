package org.ig.uml.entities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Interface extends Item {
	
	public Interface(String name) {
		super(name);
	}

	/**
	 * public class Yellow extends Color { }
	 */
	public String toStringJava() {
		String res = "";
		res += importNeeded();
		res += getVisibility().toStringJava() + "interface" + " " + getName() + " " 
		+ toStringExtendClassJava() + toStringImplementsInterfaceJava() 
		+ "{" + "\n";
		res += toStringMethodsJava();
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
		res += "class" + " " + getName() + toStringExtendAndImplementClassHpp() + "{" + "\n";
		res += toStringMethodsHpp();
		res += tosStringAttributesLinkHpp();
		
		res += "};" + "\n\n";
		res += "#endif";
		return res;
	}
	
	private String toStringExtendClassJava() {
		String res = "";
		for(Link link : getLinks()) {
			if(link.getLinkType() == LinkType.GENERALIZATION) {
				return "extends " + link.getItem().getName() + " ";
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
				generalizationFound = true;
			} else if (link.getLinkType() == LinkType.REALIZATION) {
				res += "virtual public " + link.getItem().getName() + ", ";
				generalizationFound = true;
			}
		}
		if(generalizationFound) {
			res = " : " + res;
			// On enlève le ', ' à la fin
			res = res.substring(0, res.length() - 2);
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
		String toInclude = "";
		boolean includeFound = false;
		List<String> includes = new ArrayList<String>();
		for(Link link : getLinks()) {
			toInclude = link.getItem().getName();
			if(link.getLinkType() == LinkType.GENERALIZATION
					&& !includes.contains(toInclude)) {
				res += "#include \"" + toInclude + ".hpp\"\n";
				includes.add(toInclude);
				includeFound = true;
			}
		}
		for(Method method : getMethods()) {
			// fait un include des types de retour des méthodes
			toInclude = method.getReturnType().getName(); 
			if(!includes.contains(toInclude)) {
				res += "#include \"" + toInclude + ".hpp\"\n";
				includes.add(toInclude);
				includeFound = true;
			}
			for(Argument arg : method.getArguments()) {
				// fait un include des arguments de la méthode
				toInclude = arg.getItem().getName();
				if(!includes.contains(toInclude)) {
					res += "#include \"" + toInclude + ".hpp\"\n";
					includes.add(toInclude);
					includeFound = true;
				}
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
				realizationFound = true;
			}
		}
		if(realizationFound) {
			res = "implements " + res;
			// On enlève le ', ' à la fin
			res = res.substring(0, res.length() - 2);
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
			res += method.toStringJavaInterface();
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
				publicMethods += "\t" + method.toStringHpp() + " = 0;\n";
			} else if(method.getVisibility() == Visibility.PRIVATE) {
				privateMethodFound = true;
				privateMethods += "\t" + method.toStringHpp() + " = 0;\n";
			}
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
	
	private String tosStringAttributesLinkHpp() {
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
				res += "\t" + link.getItem().getName();
				if(link.getLinkType() == LinkType.AGGREGATION) {
					res += " " + attributeName + ";\n";
				} else {
					res += " *" + attributeName + ";\n";
				}
				classesName.add(attributeName);
			}
		}
		if(!res.equals(""))
			res = "public:\n" + res;
		return res;
	}	
	
	@Override
	public void save(File folder, String currentLanguage) {
		try {
			File fileFinal;
			BufferedWriter out;
			if(currentLanguage.equals("Java")){
				fileFinal = new File(folder, getName() + ".java");
				out = new BufferedWriter(new FileWriter(fileFinal));
				out.write(toStringJava());
				out.close();
			} else if(currentLanguage.equals("C++")){
				fileFinal = new File(folder, getName() + ".hpp");
				out = new BufferedWriter(new FileWriter(fileFinal));
			    out.write(toStringHpp());
				out.close();
			}
		} catch (IOException e) {
		}
	}
}
