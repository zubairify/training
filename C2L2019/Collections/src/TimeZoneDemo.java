import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneDemo {
	public static void main(String[] args) {
		TimeZone zone = TimeZone.getTimeZone("PST");
		Calendar cal = Calendar.getInstance(zone);
		
		System.out.println(cal.get(Calendar.HOUR_OF_DAY));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		
		Date dt = new Date();
		System.out.println("Current Zone: " + dt);
	}
}
