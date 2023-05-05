package com.tienda.service;

import java.util.List;

import com.tienda.entities.Products;

public interface ProductService {
	
	List<Products> listAllProducts();
	
	Products getProduct (Long SKU);

	Products saveProduct(Products product);

	Products updateProduct(Products product);

	Products deleteProduct(Long SKU);

}
