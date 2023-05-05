package com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.dtos.OrdersDTO;
import com.tienda.entities.Orders;
import com.tienda.mapper.OrdersMapper;
import com.tienda.service.OrderService;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdersController {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<?> getAll() {
		ResponseEntity<?> response;
		try {
			List<Orders> listOrders = orderService.listAllOrders();
			if (listOrders.size() > 0) {
				response = new ResponseEntity<List<Orders>>(HttpStatus.OK);
			} else {
				response = new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response = new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdersDTO> getOrder(@PathVariable Long id ) {
		OrdersDTO getOrder = OrdersMapper.mapToDTO(orderService.getOrder(id));
		return ResponseEntity.status(HttpStatus.OK).body(getOrder);
	}

	@PostMapping
	public ResponseEntity<OrdersDTO> createOrder(@RequestBody Orders order) {
		OrdersDTO createOrder = OrdersMapper.mapToDTO(orderService.saveOrder(order));
		return ResponseEntity.status(HttpStatus.CREATED).body(createOrder);
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrdersDTO> updateOrder(@RequestBody Orders order) {
		OrdersDTO updateOrder = OrdersMapper.mapToDTO(orderService.updateOrder(order));
		return ResponseEntity.status(HttpStatus.OK).body(updateOrder);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<OrdersDTO> deleteOrder(Long id) {
		OrdersDTO deleteOrder = OrdersMapper.mapToDTO(orderService.deleteOrder(id));
		if (deleteOrder != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
