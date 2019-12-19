import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleDemo {
	public static void main(String[] args) {
		// Creating custom locale for Hindi language
		Locale hi = new Locale("hi");
		
		// It loads respective properties file based on specified/system locale
		ResourceBundle bundle = ResourceBundle.getBundle("msgs", hi);
		System.out.println("Greeting: " + bundle.getString("greeting"));
		System.out.println("Message: " + bundle.getString("message"));
	}
}
