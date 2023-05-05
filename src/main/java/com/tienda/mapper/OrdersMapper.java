package com.tienda.mapper;

import com.tienda.dtos.OrdersDTO;
import com.tienda.entities.Orders;

/*el mapper mapea objetos de un cliente a otro ej : 
* una entidad se convierte en DTO y viceversa.
*/

// lombok y mapStruct dependencia.
public class OrdersMapper {
	public static OrdersDTO mapToDTO(Orders ordersEntity) {
		OrdersDTO ordersdto = new OrdersDTO();
		ordersdto.setId(ordersEntity.getId());
		ordersdto.setFecha(ordersEntity.getFecha());
		return ordersdto;
	}

	public static Orders mapToEntity(OrdersDTO ordersdto) {
		Orders ordersEntity = new Orders();
		ordersEntity.setId(ordersdto.getId());
		ordersEntity.setFecha(ordersdto.getFecha());
		return ordersEntity;
	}
}
