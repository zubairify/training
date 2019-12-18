import java.security.BasicPermission;
import java.security.Permission;

public class Person {
	private String name;
	private int age;
	
	public Person() {
		// Constructor calling another constructor - Constructor chaining
		this("Anonymous", -1);
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	private void print() {
		SecurityManager mgr = new SecurityManager();
		Permission p = new BasicPermission("Private method") {};
		mgr.checkPermission(p);
		System.out.println("Name: " + name + "\tAge: " + age);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p = (Person) obj;
			if(p.name.equals(name) && p.age == this.age)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\tAge: " + age;
	}	
}
