class Hello extends Thread {

	@Override
	public void run() {
		while(true) {
			System.out.println("Hello");
			yield();
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
}

class World extends Thread {
	
	@Override
	public void run() {
		while(true) {
			System.out.println("World");
			yield();
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
}

public class YieldDemo {
	public static void main(String[] args) {
		Hello hello = new Hello();
		World world = new World();
		
		hello.start();
		world.start();
		
	}
}
