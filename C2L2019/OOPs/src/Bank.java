
public interface Bank {

	void summary();
	
	void deposit(double amount);
	
	void withdraw(double amount) throws BalanceException;
	
	void statement();
	
	int INIT_ACNT_NO = 1001;
	
	double MIN_SAV_BAL = 1000;
	
	double INIT_CUR_BAL = 5000;
	double MIN_CUR_BAL = 0;
	
	double OD_LIMIT = 10000;
}
