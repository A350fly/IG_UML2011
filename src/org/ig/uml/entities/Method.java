package org.ig.uml.entities;
import java.util.Set;

public class Method {
	private String name;
	private Visibility visibility;
	private Item returnType;
	private Set<Argument> arguments;
	private boolean isFinal;
	private boolean isStatic;

	public Method(String name, Item returnType) {
		this.name = name;
		this.visibility = Visibility.PACKAGE;
		this.returnType = returnType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	public Item getReturnType() {
		return returnType;
	}

	public void setReturnType(Item returnType) {
		this.returnType = returnType;
	}

	public Set<Argument> getArguments() {
		return arguments;
	}

	public void setArguments(Set<Argument> arguments) {
		this.arguments = arguments;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}

	/**
	 * public void newOperation() { }
	 */
	public String toStringJava() {
		String res = "";
		res += visibility.toStringJava() + " ";
		res += returnType.getName() + " ";
		res += getName() + "(";
		res += toStringArguments();
		res += ") {\n\n}\n\n";
		return res;
	}
	
	/**
	 * public void newOperation(Test t) { }
	 */
	public String toStringArguments() {
		String res = "";
		boolean argFound = false;
		for(Argument argument : arguments) {
			res += argument.getClass().getName() + " " + argument.getName() + ", ";
			argFound = true;
		}
		if(argFound) {
			// On enlève le ', ' à la fin
			res = res.substring(0, res.length() - 1);
		}
		return res;
	}
	
	/**
	 * void test::newOperation(String arg2) { }
	 */
	public String toStringCpp() {
		String res = "";
		res += returnType.getName() + " ";
		res += getName() + "(";
		res += toStringArguments();
		res += ") {\n\n}\n\n";
		return res;
	}

	/**
	 * virtual void newOperation(String arg2);
	 */
	public String toStringHpp() {
		String res = "";
		res += "virtual" + " " + returnType.getName() + " ";
		res += getName() + "(";
		res += toStringArguments();
		res += ");\n";
		return res;
	}
}
