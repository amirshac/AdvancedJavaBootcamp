package json;

import java.util.ArrayList;
import java.util.List;

public class Pastry {
	String name;
	int callories;
	PastryLabel label;
	List<Ingridient> ingridients;
	
	public Pastry() {
		
	}
	
	public Pastry(String name, int callories, PastryLabel label, List<Ingridient> ingridients) {
		this.name = name;
		this.callories = callories;
		this.label = label;
		this.ingridients = ingridients;
	}
	
	public Pastry(String name, int callories, PastryLabel label) {
		this(name, callories, label, new ArrayList<Ingridient>());
	}

	public void addIngridient(Ingridient ingridient) {
		ingridients.add(ingridient);
	}
	
	@Override
	public String toString() {
		return "Pastry [name=" + name + ", callories=" + callories + ", label=" + label + ", ingridients=" + ingridients
				+ "]";
	}
}
