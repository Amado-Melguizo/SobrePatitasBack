package com.tienda.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.tienda.dtos.ProductsDTO;
import com.tienda.entities.Products;
import com.tienda.mapper.ProductsMapper;
import com.tienda.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductsController {

	@Autowired
	private ProductService prodService;
	
	@GetMapping
	public ResponseEntity<List<ProductsDTO>> getAllUsers() {
		ResponseEntity<List<ProductsDTO>> response;
		try {
			List<ProductsDTO>prodDtoList = prodService.listAllProducts()
					.stream()
					.map(prod->ProductsMapper.mapToDTO(prod))
					.collect(Collectors.toList());
			if (prodDtoList.size() > 0) {
				response = new ResponseEntity<List<ProductsDTO>>(prodDtoList, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
		
	}
	
	@GetMapping("/{SKU}")
	public ResponseEntity<ProductsDTO> getProduct(@PathVariable Long SKU ) {
		ProductsDTO getProd = ProductsMapper.mapToDTO(prodService.getProduct(SKU));
		return ResponseEntity.status(HttpStatus.OK).body(getProd);
	}
	
	@PostMapping
	public ResponseEntity<ProductsDTO> createProduct(@RequestBody Products product) {
		ProductsDTO createProd = ProductsMapper.mapToDTO(prodService.saveProduct(product));
		return ResponseEntity.status(HttpStatus.CREATED).body(createProd);
	}

	@PutMapping("/{SKU}")
	public ResponseEntity<ProductsDTO> updateProduct(@RequestBody Products product) {
		ProductsDTO updateProd = ProductsMapper.mapToDTO(prodService.updateProduct(product));
		return ResponseEntity.status(HttpStatus.OK).body(updateProd);
	}

	@DeleteMapping("/{SKU}")
	public ResponseEntity<ProductsDTO> deleteUser(Long SKU) {
		ProductsDTO deleteProd = ProductsMapper.mapToDTO(prodService.deleteProduct(SKU));
		if (deleteProd != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

}
