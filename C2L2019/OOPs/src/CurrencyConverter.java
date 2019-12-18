
public class CurrencyConverter {

	public double convert(Currency src, Currency tgt, double amount) {
		double rate = tgt.dollarValue() / src.dollarValue();
		return rate * amount;
	}
}
