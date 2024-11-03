package es.minsait.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.minsait.models.Product;
import es.minsait.persistence.ProductsDAO;

//business service implementation
@Service
public class ProductsBSImpl implements IProductsBS {
	
	@Autowired
	private ProductsDAO dao; //inyeccion de dependencias (dependency injection - DI)

	@Override
	public List<Product> consultarTodos() {
		return dao.findAll();
	}

	@Override
	public Product buscarProducto(Long id) {
		return dao.findById(id).orElse(new Product());
	}
	
}
