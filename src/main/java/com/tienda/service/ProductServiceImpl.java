package com.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.entities.Products;
import com.tienda.entities.Users;
import com.tienda.interfaces.ProductsRepo;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductsRepo repoProducts;

	
	/*					Products Methods				*/
	
	// Listar Productos	
	@Override
	public List<Products> listAllProducts() {
		return repoProducts.findAll();
	}
	
	// Listar Producto
	@Override
	public Products getProduct(Long SKU) {
		Optional<Products> product = repoProducts.findById(SKU);
		return product.orElse(null);
	}

	// Ver Producto
	@Override
	public Products saveProduct(Products product) {
		return repoProducts.save(product);
	}

	// Actualizar Producto
	@Override
	public Products updateProduct(Products product) {
		if (product.getSKU() == null && repoProducts.existsById(product.getSKU())) {
			return repoProducts.save(product);
		}
		return null;
	}
	
	// Borrar Producto
	
	@Override
	public Products deleteProduct(Long SKU) {
		repoProducts.deleteById(SKU);
		return null;
	}
	
//	@Override
//	public boolean deleteProduct(Long SKU) {
//		boolean result = false;
//		if (SKU != null && repoProducts.existsById(SKU)) {
//			repoProducts.deleteById(SKU);
//			result = true;
//		}
//
//		return result;
//	}
	

}
