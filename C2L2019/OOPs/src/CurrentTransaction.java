
public class CurrentTransaction extends Transaction {
	private double overdraft;

	public CurrentTransaction() {
		super();
	}

	public CurrentTransaction(String txnType, double txnAmount, double balance, double overdraft) {
		super(txnType, txnAmount, balance);
		this.overdraft = overdraft;
	}

	@Override
	public String toString() {
		return super.toString() + "\t" + overdraft;
	}
}
