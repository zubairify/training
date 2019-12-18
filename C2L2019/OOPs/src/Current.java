import java.util.ArrayList;

public class Current extends Account {
	private double overdraft;

	public Current() {
		super();
	}

	public Current(String holder) {
		super(holder, INIT_CUR_BAL);
		this.overdraft = OD_LIMIT;
		
		txns = new ArrayList<Transaction>();
		txns.add(new CurrentTransaction("OB", INIT_CUR_BAL, balance, OD_LIMIT));
	}

	@Override
	public void summary() {
		super.summary();
		System.out.println("Overdraft: " + overdraft);
	}

	@Override
	public void deposit(double amount) {
		overdraft += amount;
		if(overdraft > OD_LIMIT) {
			balance += (overdraft - OD_LIMIT);
			overdraft = OD_LIMIT;
		}
		txns.add(new CurrentTransaction("CR", amount, balance, overdraft));
	}

	@Override
	public void withdraw(double amount) throws BalanceException {
		if(amount <= (balance + overdraft)) {
			balance -= amount;
			if(balance < MIN_CUR_BAL) {
				overdraft += balance;
				balance = MIN_CUR_BAL;
			}
			txns.add(new CurrentTransaction("DR", amount, balance, overdraft));
		} else
			throw new BalanceException("Insufficient balance");
	}
}

