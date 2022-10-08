package entity;

import java.awt.ItemSelectable;
import java.util.ArrayList;
import java.util.HashSet;

public class Cart {
	private ArrayList<Item> items;
	public Cart() {
		items = new ArrayList<Item>();
	}
	public Cart(ArrayList<Item> items) {
		super();
		this.items = items;
	}
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
}
