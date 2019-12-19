
public class MyThread extends Thread {
	private int count;
	
	@Override
	public void run() {
		Thread t = Thread.currentThread();
		String name = t.getName();
		for(int c=1; c<=50; c++)
			System.out.println(name + ": " + ++ count);
	}
	
	public static void main(String[] args) {
		MyThread m1 = new MyThread();
		MyThread m2 = new MyThread();
		MyThread m3 = new MyThread();
		
		m1.setName("Alfa");
		m2.setName("Beta");
		m3.setName("Gama");
		
		m1.start();
		m2.start();
		m3.start();
		
		Thread t = Thread.currentThread();
		String name = t.getName();
		for(int c=1; c<=50; c++)
			System.out.println(name + ": " + c);
	}
}
