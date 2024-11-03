package es.minsait.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ShoppingCart implements Serializable{
	
	@Id
	private String id;
	private String user;
	private List<Order> products = new ArrayList<>();;
	private double amount;
	
	public ShoppingCart() {
		// TODO Auto-generated constructor stub
	}
	
	public ShoppingCart(String user, List<Order> products, double amount) {
		super();
		this.user = user;
		this.products = products;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<Order> getProducts() {
		return products;
	}

	public void setProducts(List<Order> products) {
		this.products = products;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", user=" + user + ", products=" + products + ", amount=" + amount + "]";
	}

}
