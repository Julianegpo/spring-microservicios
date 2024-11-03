package es.minsait.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import es.minsait.business.IShoppingCartBS;
import es.minsait.models.ShoppingCart;

@RestController
public class ShoppingCartREST {
	
	@Autowired
	private IShoppingCartBS bs;
	
	// http://localhost:8003/createShoppingCart/julian
	@PostMapping("/createShoppingCart/{user}")
	public ShoppingCart createShoppingCart(@PathVariable String user) {
		return bs.createShoppingCart(user);
	}

	// http://localhost:8003/addOrder/item/1/quantity/100/user/julian
	@PutMapping("/addOrder/item/{id}/quantity/{quantity}/user/{user}")
	public ShoppingCart addOrder(@PathVariable Long id, @PathVariable int quantity, @PathVariable String user) {
		return bs.addOrder(id, quantity, user);
	}
	
	// http://localhost:8003/getShoppingCart/julian
	@GetMapping("/getShoppingCart/{user}")
	public ShoppingCart getOrder(@PathVariable String user) {
		return bs.getShoppingCart(user);
	}
	
	// http://localhost:8003/deleteOrder/1/user/julian
	@DeleteMapping("/deleteOrder/{id}/user/{user}")
	public ShoppingCart deleteShoppingCart(@PathVariable Long id, @PathVariable String user) {
		return bs.deleteOrder(id, user);
	}
	
}
