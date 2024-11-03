package es.minsait.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import es.minsait.models.Order;
import es.minsait.models.Product;

@Service
@Primary
public class OrdersBSImplRestTemplate implements IOrdersBS {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Order createOrder(Long id, int quantity) {
		// Buscar producto con ese id
		Product product = restTemplate.getForObject(
				"http://servicio-productos/search/{id}", Product.class, id);
		// Crear pedido y retornarlo
		Order order = new Order(product, quantity);
		return order;
	}

}
