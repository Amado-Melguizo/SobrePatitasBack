package com.tienda.service;

import java.util.List;

import com.tienda.entities.Orders;

public interface OrderService {

	List<Orders> listAllOrders();

	Orders getOrder (Long id);
	
	Orders saveOrder(Orders order);

	Orders updateOrder(Orders order);

	Orders deleteOrder(Long id);


}