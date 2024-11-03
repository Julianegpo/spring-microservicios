package es.minsait.models;

import java.io.Serializable;

public class Product implements Serializable {

	private Long ID;
	private String description;
	private double price;
	private Integer port;
	
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

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public String toString() {
		return "Product [ID=" + ID + ", description=" + description + ", price=" + price + ", port=" + port + "]";
	}
	
}
