package es.minsait.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.minsait.business.IOrdersBS;
import es.minsait.models.Order;

@RestController
public class OrdersREST {
	
	@Autowired
	private IOrdersBS bs;
	
	// http://localhost:8002/create/2/quantity/1
	@GetMapping("/create/{id}/quantity/{quantity}")
	public Order createOrder(@PathVariable Long id, @PathVariable int quantity) {
		return bs.createOrder(id, quantity);
	}

}
