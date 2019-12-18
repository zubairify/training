
public class TestEmployee {
	public static void main(String[] args) {
		Manager m1 = new Manager(102, "Lili", 7000, 3000);
		
		Executive x1 = new Executive(103, "Mili", 6000, 2000);
		
		showSalary(m1);
		
		showSalary(x1);
	}

	private static void showSalary(Employee e) {
		if(e instanceof Manager)
			System.out.println("Manager Salary: " + e.getSalary());
		else
			System.out.println("Executive Salary: " + e.getSalary());
	}
	
//	private static void showSalary(Executive x1) {
//		System.out.println("Executive Salary: " + x1.getSalary());
//	}
//
//	private static void showSalary(Manager m1) {
//		System.out.println("Manager Salary: " + m1.getSalary());
//	}

}
