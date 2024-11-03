package es.minsait.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.minsait.models.Product;

@RepositoryRestResource(collectionResourceRel = "PRODUCTS", path ="products")
public interface ProductsDAO extends JpaRepository<Product, Long> {
	
	/**
	 *  Podemos crear nuestros metodos personalizados segun nuestras necesidades
	 *  usamos palabras clave
	 *  https://docs.spring.io/spring-data/jpa/reference/repositories/query-keywords-reference.html
	 */
	
	/**
	 * Consultar todos los productos
	 * http://localhost:8001/products
	 */
	
	/**
	 * Buscar un producto
	 * http://localhost:8001/products/1
	 */
	
	/**
	 * Ver todos los metodos personalizados
	 * http://localhost:8001/products/search
	 */
	
	//	http://localhost:8001/products/search/findByDescription?descripcion=Raton
	public List<Product> findByDescription(String description);
	
	// http://localhost:8001/products/search/orderByPrice
	public List<Product> OrderByPrice();

	//	http://localhost:8001/products/search/findByPriceBetween?min=80&max=200
	public List<Product> findByPriceBetween(double min, double max);

}
