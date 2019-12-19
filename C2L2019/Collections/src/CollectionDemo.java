import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Vector;

public class CollectionDemo {
	
	public static void main(String[] args) {
		ArrayList<String> lst = new ArrayList<>();
		lst.add("Oracle");
		lst.add("Microsoft");
		lst.add(1, "Apache");
		lst.add("JBoss");
		
		System.out.println("-- Traversing over list using for-loop");
		for (int i = 0; i < lst.size(); i++) 
			System.out.println(lst.get(i));
			
		System.out.println("-- Traversing over list using Iterator");
		Iterator<String> itr = lst.iterator();
		while(itr.hasNext())
			System.out.println(itr.next());
		
		System.out.println("-- Traversing over list using for-each");
		for (String item : lst) 
			System.out.println(item);
		
		Vector<String> vtr = new Vector<>();
		vtr.add("IBM");
		vtr.add("Oracle");
		vtr.add("Google");
		
		lst.addAll(vtr);	// merging vector into list
		
		System.out.println("-- Traversing over updated list");
		for (String item : lst) 
			System.out.println(item);
		
		// Converting List to Set collection
		HashSet<String> set = new HashSet<>(lst);
		System.out.println("-- Traversing over set");
		for (String item : set) 
			System.out.println(item);
		
		TreeSet<String> tree = new TreeSet<>(set);
		System.out.println("-- Traversing over tree set");
		for (String item : tree) 
			System.out.println(item);
	}
}




