package es.minsait.business;

import java.util.List;

import es.minsait.models.Product;

// business service
public interface IProductsBS {
	
	List<Product> consultarTodos();
	
	Product buscarProducto(Long id);
	
}
