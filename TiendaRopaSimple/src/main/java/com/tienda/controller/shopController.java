package com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.entidades.Products;
import com.tienda.entidades.Users;
import com.tienda.interfaces.RepProducts;
import com.tienda.interfaces.RepUsers;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class shopController {

	// standard constructors
	@Autowired
	private RepUsers userRepository;
	@Autowired
	private RepProducts prodRepository;

	@GetMapping("/users")
	public List<Users> getUsers() {
		return userRepository.findAll();
	}

	@PostMapping("/users")
	void addUser(@RequestBody Users user) {
		userRepository.save(user);
	}

	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
	}

	@PutMapping("/users/{id}")
	public Users updateUser(@RequestBody Users newUser, @PathVariable Long id) {
		return userRepository.findById(id).map(user -> {
			user.setUsername(newUser.getUsername());
			user.setEmail(newUser.getEmail());
			user.setPass(newUser.getPass());
			user.setUser_img(newUser.getUser_img());
			return userRepository.save(user);
		}).orElseGet(() -> {
			newUser.setId(id);
			return userRepository.save(newUser);
		});
	}

	@GetMapping("/products")
	public List<Products> getProducts() {
		return prodRepository.findAll();
	}

	@PostMapping("/products")
	void addProduct(@RequestBody Products product) {
		prodRepository.save(product);
	}

	@DeleteMapping("/products/{SKU}")
	public void deleteProduct(@PathVariable Long SKU) {
		prodRepository.deleteById(SKU);
	}

	@PutMapping("/products/{SKU}")
	public Products updateUser(@RequestBody Products newProduct, @PathVariable Long SKU) {
		return prodRepository.findById(SKU).map(prod -> {
			prod.setSKU(newProduct.getSKU());
			prod.setProd_name(newProduct.getProd_name());
			prod.setDescription(newProduct.getDescription());
			prod.setPrice(newProduct.getPrice());
			prod.setStock(newProduct.getStock());
			prod.setProd_img(newProduct.getProd_img());
			return prodRepository.save(prod);
		}).orElseGet(() -> {
			newProduct.setSKU(SKU);
			return prodRepository.save(newProduct);
		});
	}

}