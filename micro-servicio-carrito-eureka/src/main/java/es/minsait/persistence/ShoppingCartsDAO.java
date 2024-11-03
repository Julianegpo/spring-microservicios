package es.minsait.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.minsait.models.ShoppingCart;

@RepositoryRestResource(collectionResourceRel = "SHOPPINGCARTS", path ="shoppingcarts")
public interface ShoppingCartsDAO extends MongoRepository<ShoppingCart, String>{
	
	/*
	 * todos los carritos
	 * http://localhost:8003/shoppingcarts
	 */
	
//	http://localhost:8003/shoppingcarts/search/findByUsuario?user=Julian
	ShoppingCart findByUser(String user);

}
