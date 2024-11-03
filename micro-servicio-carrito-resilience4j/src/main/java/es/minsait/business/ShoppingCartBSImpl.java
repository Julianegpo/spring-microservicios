package es.minsait.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.minsait.clients.OrdersRESTClient;
import es.minsait.models.Order;
import es.minsait.models.ShoppingCart;
import es.minsait.persistence.ShoppingCartsDAO;

@Service
public class ShoppingCartBSImpl implements IShoppingCartBS {
	
	@Autowired
	private ShoppingCartsDAO dao;
	
	@Autowired
	private OrdersRESTClient ordersFeignClient;

	@Override
	public ShoppingCart createShoppingCart(String user) {
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.setUser(user);
		return dao.save(shoppingCart);
	}

	@Override
	public ShoppingCart addOrder(Long id, Integer quantity, String user) {
		Order order = ordersFeignClient.createOrder(id, quantity);
		ShoppingCart userCart = getShoppingCart(user);
		userCart.getProducts().add(order);
		double shoppingCartAmount = userCart.getAmount() + (order.getProduct().getPrice() * quantity);
		userCart.setAmount(shoppingCartAmount);
		return dao.save(userCart);
	}

	@Override
	public ShoppingCart getShoppingCart(String user) {
		return dao.findByUser(user);
	}

	@Override
	public ShoppingCart deleteOrder(Long id, String user) {
		ShoppingCart userCart = getShoppingCart(user);
		List<Order> userCartProducts = userCart.getProducts();
		
//		Order foundOrder = null;
//		for (Order order : userCartProducts) {
//			if(id == order.getProduct().getID()) {
//				foundOrder = order;
//				break;
//			}
//		}
		
		// Java 8
		Order foundOrder = userCartProducts
				.stream()
				.filter(order -> id == order.getProduct().getID())
				.findFirst().get();
		
		userCartProducts.remove(foundOrder);
		
		double amount = userCart.getAmount() - 
				(foundOrder.getProduct().getPrice() * foundOrder.getQuantity());
		userCart.setAmount(amount);
		return dao.save(userCart);
	}
	
}
