package entity;

public class Item {
	private product product;
	private double price;
	private int quantity;
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public Item(entity.product product, double price, int quantity) {
		super();
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}
	public product getProduct() {
		return product;
	}
	public void setProduct(product product) {
		this.product = product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
