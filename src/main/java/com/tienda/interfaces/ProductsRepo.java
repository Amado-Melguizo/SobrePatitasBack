package com.tienda.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.dtos.ProductsDTO;
import com.tienda.entities.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products,Long>{

	static List<ProductsDTO> obtenerProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	static ProductsDTO obtenerProductoPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	static void crear(ProductsDTO productoDTO) {
		// TODO Auto-generated method stub
		
	}

	static void eliminarProducto(Long id) {
		// TODO Auto-generated method stub
		
	}

	static void actualizar(Long id, ProductsDTO productoDTO) {
		// TODO Auto-generated method stub
		
	}

}