package es.minsait.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.minsait.business.IProductsBS;
import es.minsait.models.Product;

@RestController
public class ProductsREST {
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IProductsBS bs;
	
//	http://localhost:8001/list
	@GetMapping("/list")
	public List<Product> list() {
		// 1 - one by one
//		List<Product> list = bs.consultarTodos();
//		for(Product product : list) {
//			product.setPort(port);
//		}
//		return list;
		
		// 2 - java 8 streams
		return bs.consultarTodos()
				.stream()
				.map(prod -> {
					prod.setPort(port);
					return prod;
				}).collect(Collectors.toList());
	}
	
//	@GetMapping("/search/{codigo}")
//	public Product search(@PathVariable(name="codigo") Long id) {
//	http://localhost:8001/search/2
	@GetMapping("/search/{id}")
	public Product search(@PathVariable Long id) {
		Product product = bs.buscarProducto(id);
		product.setPort(port);
		return product;
	}

}
