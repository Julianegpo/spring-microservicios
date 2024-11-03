package es.minsait.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import es.minsait.clients.ProductsRESTClient;
import es.minsait.models.Order;
import es.minsait.models.Product;

@Service
@Primary
public class OrdersBSImpl implements IOrdersBS {
	
	@Autowired
	private ProductsRESTClient feignClient;

	@Override
	public Order createOrder(Long id, int quantity) {
		// Buscar producto con ese id
		Product product = feignClient.search(id);
		// Crear pedido y retornarlo
		return new Order(product, quantity);
	}

}
