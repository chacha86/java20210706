package example.test;

public class Person {

	int age;
	String name;
	
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	void introduce() {
		System.out.println("나이 : " + age);
		System.out.println("이름 : " + name);
	}
}
