package es.minsait.business;

import es.minsait.models.Order;

public interface IOrdersBS {
	
	public Order createOrder(Long id, int quantity);

}
