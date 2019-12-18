import java.util.List;

/**
 * This class represents generalised bank account.
 * @author Zubair
 * @version 1.0
 */
public abstract class Account implements Bank {
	private int acntNo;
	private String holder;
	protected double balance;
	
	protected List<Transaction> txns;
	
	private static int autogen;
	
	static {
		autogen = INIT_ACNT_NO;
	}
	
	public Account() {
	}

	public Account(String holder, double balance) {
		this.acntNo = autogen ++;
		this.holder = holder;
		this.balance = balance;
	}

	public void summary() {
		System.out.println("A/C No: " + acntNo);
		System.out.println("Holder: " + holder);
		System.out.println("Balance: " + balance);
	}
	
	// BL methods
	public void deposit(double amount) {
		balance += amount;
		txns.add(new Transaction("CR", amount, balance));
	}
	
	public abstract void withdraw(double amount) throws BalanceException;
	
	public void statement() {
		for(Transaction t : txns)
			System.out.println(t);
	}
}
