package com.shopNest.product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	public List <Product> items;
	
	public Cart() {
		items = new ArrayList<>();
	}
	
	public void addItems(Product product) {
		items.add(product);
	}
	public List getItems() {
		return items;
	}
	
	public double getTotal() {
		double total = 0;
		for(Product item: items) {
			total += item.getpPrice();
		}
		return total;
	}
}
