package es.minsait.models;

import java.io.Serializable;

public class Product implements Serializable {

	private Long ID;
	private String description;
	private double price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String description, double price) {
		super();
		this.description = description;
		this.price = price;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Producto [ID=" + ID + ", description=" + description + ", price=" + price + "]";
	}
	
}
