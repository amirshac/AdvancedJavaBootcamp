package json;

public class Ingridient {
	String name;
	double weight;
	
	public Ingridient() {
		
	}
	
	public Ingridient(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Ingridient [name=" + name + ", weight=" + weight + "]";
	}
	
}
