import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws Exception {
		Properties p = new Properties();
		p.load(new FileInputStream("src/person.info"));
		
		System.out.println("Name: " + p.getProperty("name"));
		System.out.println("Age: " + p.getProperty("age"));
		System.out.println("City: " + p.getProperty("city"));
	}
}
