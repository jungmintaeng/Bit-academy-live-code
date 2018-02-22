package chapter03;

public class Person {
	int age;
	public String name;
	protected int height;
	private int weight;
	
	/**
	 * Constructor
	 */
	
	public Person() {
		System.out.println("부모 생성자 호출 Person()");
	}
	
	public Person(int age) {
		this.age = age;
		System.out.println("부모 생성자 호출 Person(int)");
	}
	
	/**
	 * getter-setter
	 */

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
