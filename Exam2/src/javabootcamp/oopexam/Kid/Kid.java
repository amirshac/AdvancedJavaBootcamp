package javabootcamp.oopexam.Kid;

public class Kid {
	private String name;
	private int age;
	
	public Kid(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// setters getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "<Kid> [name=" + name + ", age=" + age + "]";
	}
	
}
