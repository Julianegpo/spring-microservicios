package es.minsait.business;

import es.minsait.models.ShoppingCart;

public interface IShoppingCartBS {

	public ShoppingCart createShoppingCart(String user);
	public ShoppingCart addOrder(Long id, Integer quantity, String user);
	public ShoppingCart getShoppingCart(String user);
	public ShoppingCart deleteOrder(Long id, String user);
	
}
