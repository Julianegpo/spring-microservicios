package es.minsait.rest;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.minsait.business.IProductsBS;
import es.minsait.models.Product;

@RestController
public class ProductsREST {
	
	@Autowired
	private HttpServletRequest request;
	
//	ya no funciona con los puertos dinamicos
//	@Value("${server.port}")
//	private Integer port;
	
	@Autowired
	private IProductsBS bs;
	
//	http://localhost:8001/list
	@GetMapping("/list")
	public List<Product> list() {
// 		1 - one by one
//		List<Product> list = bs.consultarTodos();
//		for(Product product : list) {
//			product.setPort(port);
//		}
//		return list;
		
// 		2 - java 8 streams
		return bs.consultarTodos()
				.stream()
				.map(prod -> {
//					prod.setPort(port);
					prod.setPort(request.getLocalPort());
					return prod;
				}).collect(Collectors.toList());
	}
	
//	@GetMapping("/search/{codigo}")
//	public Product search(@PathVariable(name="codigo") Long id) {
//	http://localhost:8001/search/2
	@GetMapping("/search/{id}")
	public Product search(@PathVariable Long id) throws InterruptedException {
		Product product = bs.buscarProducto(id);
		
//		Si no ha encontrado producto, se recibe una instancia vacia
//		y lanzaremos una excepcion
		if(product.getDescription() == null) {
			throw new RuntimeException("Error al buscar el producto");
		}
		
//		Por defecto, los microservicios esperan un maximo de 1 segundo en obtener una response
//		si se supera ese segundo, devuelve TimeOut
//		provocamos un timeout
//		Thread.sleep(5000);
		
//		probamos peticiones lentas que superen los 2s
		if (id == 1L) {
//			Thread.sleep(5000);			
		}
		
//		product.setPort(port);
		product.setPort(request.getLocalPort());
		return product;
	}

}
