import java.util.ArrayList;

public class Savings extends Account {

	public Savings() {
		super();
	}

	public Savings(String holder) {
		super(holder, MIN_SAV_BAL);
		txns = new ArrayList<Transaction>();
		txns.add(new Transaction("OB", MIN_SAV_BAL, balance));
	}

	@Override
	public void withdraw(double amount) throws BalanceException {
		if(amount <= (balance - MIN_SAV_BAL)) {
			balance -= amount;
			txns.add(new Transaction("DR", amount, balance));
		} else
			throw new BalanceException("Insufficient balance");
	}
}
