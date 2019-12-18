
public interface Currency {
	double dollarValue();
	
	Currency INR = new Currency() {
		@Override
		public double dollarValue() {
			return 71.20;
		}
	}; 

	Currency USD = new Currency() {
		@Override
		public double dollarValue() {
			return 1;
		}
	};
	
	static double convert(Currency src, Currency tgt, double amount) {
		double rate = tgt.dollarValue() / src.dollarValue();
		return rate * amount;
	}
}
