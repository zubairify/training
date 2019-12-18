import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleDemo {
	public static void main(String[] args) {
		
		Locale hind = new Locale("hi");
		ResourceBundle bundle = ResourceBundle.getBundle("msgs", hind);
		
		System.out.println(bundle.getString("greeting"));
		System.out.println(bundle.getString("message"));
	}
}
