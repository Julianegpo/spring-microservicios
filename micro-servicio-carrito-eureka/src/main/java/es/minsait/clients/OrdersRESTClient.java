package es.minsait.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.minsait.models.Order;

@FeignClient(name = "servicio-pedidos")
public interface OrdersRESTClient {

	//Mapeamos a donde va la request
	@GetMapping("/create/{id}/quantity/{quantity}")
	public Order createOrder(@PathVariable Long id, @PathVariable int quantity);

}
