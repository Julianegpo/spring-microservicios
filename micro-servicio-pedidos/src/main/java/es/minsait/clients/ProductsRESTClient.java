package es.minsait.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import es.minsait.models.Product;

@FeignClient(url = "localhost:8001", name = "servicio-productos" )
public interface ProductsRESTClient {

	//Mapeamos a donde va la request
	@GetMapping("/search/{id}")
	public Product search(@PathVariable Long id);
	
}
