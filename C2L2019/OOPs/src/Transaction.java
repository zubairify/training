
public class Transaction {
	private String txnType;
	private double txnAmount;
	private double balance;
	
	public Transaction() {
	}

	public Transaction(String txnType, double txnAmount, double balance) {
		this.txnType = txnType;
		this.txnAmount = txnAmount;
		this.balance = balance;
	}

	@Override
	public String toString() {
		return txnType + "\t" + txnAmount + "\t" + balance;
	}
}
