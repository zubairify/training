
public class Executive extends Employee {
	private double commission;

	public Executive() {
		super();
	}

	public Executive(int empNo, String empName, double salary, double commission) {
		super(empNo, empName, salary);
		this.commission = commission;
	}

	@Override
	public void payslip() {
		super.payslip();
		System.out.println("Commission: " + commission);
	}

	@Override
	public double getSalary() {
		return super.getSalary() + commission;
	}
}
