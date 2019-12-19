
public class SyncDemo implements Runnable {

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		display(name);
	}

//	private synchronized void display(String name) {
//		try {
//			System.out.print("[");
//			Thread.sleep(100);
//			System.out.print(name);
//			Thread.sleep(100);
//			System.out.println("]");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//	}

	private void display(String name) {
		try {
			synchronized (this) {
				System.out.print("[");
				Thread.sleep(100);
				System.out.print(name);
				Thread.sleep(100);
				System.out.println("]");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SyncDemo sd = new SyncDemo();
		
		Thread t1 = new Thread(sd, "Alfa");
		Thread t2 = new Thread(sd, "Beta");
		Thread t3 = new Thread(sd, "Gama");
		
		t1.start();
		t2.start();
		t3.start();
	}
}

