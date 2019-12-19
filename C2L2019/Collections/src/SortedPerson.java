import java.util.TreeSet;

public class SortedPerson {
	
	public static void main(String[] args) {
		
//		PersonComparator pc = new PersonComparator();
//		TreeSet<Person> people = new TreeSet<>(pc);
		
		TreeSet<Person> people = new TreeSet<>();
		
		people.add(new Person("Polo", 21));
		people.add(new Person("Lili", 19));
		people.add(new Person("Mili", 20));
		
		for (Person p : people) 
			System.out.println(p);

	}
}	
