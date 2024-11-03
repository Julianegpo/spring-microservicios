package es.minsait.business;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.minsait.models.Product;
import es.minsait.models.ShoppingCart;

@Service
public class IManagementBSImpl implements IManagementBS {
	
	@Autowired
	private RestTemplate restClient;

	@Override
	public List<Product> getAll() {
		String url = "http://localhost:8091/api/products/list";
		ResponseEntity<Object[]> responseEntity =
		restClient.getForEntity(url, Object[].class);

		Object[] array = responseEntity.getBody();

		ObjectMapper mapper = new ObjectMapper();

		return Arrays.stream(array)
		.map(object -> mapper.convertValue(object, Product.class))
		.collect(Collectors.toList());
	}

	@Override
	public Product findProduct(Long id) {
		String url = "http://localhost:8091/api/products/search/{id}";
		return restClient.getForObject(url, Product.class, id);
	}

	@Override
	public ShoppingCart findShoppingCart(String user) {
		String url = "http://localhost:8091/api/shoppingcarts/getShoppingCart/{user}";
		return restClient.getForObject(url,  ShoppingCart.class, user);
	}

	@Override
	public ShoppingCart create(String user) {
		String url = "http://localhost:8091/api/shoppingcarts/createShoppingCart/{user}";
		return restClient.postForObject(url, null, ShoppingCart.class, user);
	}

	@Override
	public void add(Long id, int quantity, String user) {
		String url ="http://localhost:8091/api/shoppingcart/addOrder/item/{id}/quantity/{quantity}/user/{user}";
		restClient.put(url,  null, id, quantity, user);
	}

	@Override
	public void delete(Long id, String user) {
		String url ="http://localhost:8090/api/shoppingcart/deleteOrder/{id}/user/{user}";
		restClient.delete(url, id, user);
	}

}
