
public class TestAccount {

	public static void main(String[] args) {
		Bank b = new Current("Polo");
		
		b.deposit(3000);
		try {
			b.withdraw(10000);
		} catch (BalanceException e) {
//			e.printStackTrace();	// debug - developers
//			System.out.println(e);	// logging
			System.out.println(e.getMessage());
		}
		b.deposit(2000);
		
		b.statement();
	}
}
