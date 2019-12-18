import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class PersonReflection {
	public static void main(String[] args) throws Exception {
		
		Class pc = Class.forName("Person");
		
		Constructor cnst = pc.getConstructor(String.class,int.class);
		
		Object obj = cnst.newInstance("Polo", 21);
		
		System.out.println(obj);
		
//		Method mthd = pc.getMethod("print", null);
//		mthd.invoke(obj, null);
		
		Method mthd = pc.getDeclaredMethod("print", null);
		mthd.setAccessible(true);
		mthd.invoke(obj, null);
	}
}


