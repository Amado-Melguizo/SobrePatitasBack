package com.tienda.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.entidades.Products;

@Repository
public interface RepProducts extends JpaRepository<Products,Long>{

	
}