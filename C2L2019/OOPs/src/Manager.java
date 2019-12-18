
public class Manager extends Employee {
	private double incentives;

	public Manager() {
		super();
	}

	public Manager(int empNo, String empName, double salary, double incentives) {
		super(empNo, empName, salary);
		this.incentives = incentives;
	}

	@Override
	public void payslip() {
		super.payslip();
		System.out.println("Incentives: " + incentives);
	}

	@Override
	public double getSalary() {
		return super.getSalary() + incentives;
	}
	
}
