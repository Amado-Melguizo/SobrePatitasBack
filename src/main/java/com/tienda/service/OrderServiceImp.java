package com.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.entities.Orders;
import com.tienda.entities.Users;
import com.tienda.interfaces.OrdersRepo;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class OrderServiceImp implements OrderService {

	
	@Autowired
	private OrdersRepo repoOrders;
		
	/*					User Methods				*/
	
//	listar pedidos
	@Override
	public List<Orders> listAllOrders() {
		return repoOrders.findAll();
	}
	
	
	@Override
	public Orders getOrder(Long id) {
		Optional<Orders> order = repoOrders.findById(id);
		return order.orElse(null);
	}

	@Override
	public Orders saveOrder(Orders order) {
		return repoOrders.save(order);
	}

	@Override
	public Orders updateOrder(Orders order) {
		if (order.getId() == null && repoOrders.existsById(order.getId())) {
			return repoOrders.save(order);
		}
		return null;
	}

	@Override
	public Orders deleteOrder(Long id) {
		repoOrders.deleteById(id);
		return null;
	}
	
//	@Override
//	public boolean deleteOrder(Long id) {
//		boolean result = false;
//		if (id != null && repoOrders.existsById(id)) {
//			repoOrders.deleteById(id);
//			result = true;
//		}
//
//		return result;
//	}
}
