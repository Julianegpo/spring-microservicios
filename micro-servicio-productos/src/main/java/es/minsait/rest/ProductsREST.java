package es.minsait.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.minsait.business.IProductsBS;
import es.minsait.models.Product;

@RestController
public class ProductsREST {
	
	@Autowired
	private IProductsBS bs;
	
//	http://localhost:8001/list
	@GetMapping("/list")
	public List<Product> list() {
		return bs.consultarTodos();
	}
	
//	@GetMapping("/search/{codigo}")
//	public Product search(@PathVariable(name="codigo") Long id) {
//	http://localhost:8001/search/2
	@GetMapping("/search/{id}")
	public Product search(@PathVariable Long id) {
		return bs.buscarProducto(id);
	}

}
