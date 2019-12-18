
public class Product implements Comparable<Product> {
	private String name;
	private double price;
	
	public Product() {
	}

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public int compareTo(Product p) {
		return this.name.compareTo(p.name);
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
}
