package es.minsait.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.minsait.business.IOrdersBS;
import es.minsait.models.Order;
import es.minsait.models.Product;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class OrdersREST {
	
	@Autowired
	private IOrdersBS bs;
	
//	en caso de recibir una excepcion llamaremos al metodo alternativo handleError()
//	http://localhost:8002/create/2/quantity/1
//	@HystrixCommand(fallbackMethod = "handleError")
	@CircuitBreaker(name = "orders", fallbackMethod = "handleError")
	@GetMapping("/create/{id}/quantity/{quantity}")
	public Order createOrder(@PathVariable Long id, @PathVariable int quantity) {
		return bs.createOrder(id, quantity);
	}
	
//	metodo alternativo tiene que tener los mismos argumentos + un throwable/exception
	public Order handleError(Long id, int quantity, Throwable ex) {
		System.out.println("*****************" + ex.getMessage() + "*****************");
		System.out.println("------------------" + ex.getClass()+ "------------------");
		Product product = new Product();
		product.setID(id);
		product.setDescription("Producto vacio");
		product.setPrice(0);
		
		return new Order(product, quantity);
	}

}
