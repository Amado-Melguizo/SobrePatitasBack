package com.tienda.mapper;

import com.tienda.dtos.ProductsDTO;
import com.tienda.entities.Products;

/*el mapper mapea objetos de un cliente a otro ej : 
* una entidad se convierte en DTO y viceversa.
*/

// lombok y mapStruct dependencia.
public class ProductsMapper {
	public static ProductsDTO mapToDTO(Products productosEntity) {
		ProductsDTO productosdto = new ProductsDTO();
		productosdto.setSKU(productosEntity.getSKU());
		productosdto.setProd_name(productosEntity.getProd_name());
		productosdto.setDescription(productosdto.getDescription());
		productosdto.setPrice(productosdto.getPrice());
		productosdto.setStock(productosEntity.getStock());
		productosdto.setProd_img(productosEntity.getProd_img());
		return productosdto;
	}

	public static Products mapToEntity(ProductsDTO productosdto) {
		Products productosEntity = new Products();
		productosEntity.setSKU(productosdto.getSKU());
		productosEntity.setProd_name(productosdto.getProd_name());
		productosEntity.setDescription(productosdto.getDescription());
		productosEntity.setPrice(productosdto.getPrice());
		productosEntity.setStock(productosdto.getStock());
		productosEntity.setProd_img(productosdto.getProd_img());
		return productosEntity;
	}
}
