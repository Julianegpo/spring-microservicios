package es.minsait.business;

import java.util.List;

import es.minsait.models.Product;
import es.minsait.models.ShoppingCart;


public interface IManagementBS {
	
	List<Product> getAll();
	Product findProduct(Long id);
	ShoppingCart findShoppingCart(String user);
	ShoppingCart create(String user);
	void add(Long id, int quantity, String user);
	void delete(Long id, String user);
	
}
