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

import com.tienda.dtos.UsersDTO;
import com.tienda.entities.Users;
import com.tienda.mapper.UsersMapper;
import com.tienda.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UsersDTO>> getAllUsers() {
		ResponseEntity<List<UsersDTO>> response;
		try {
			List<UsersDTO> userDtoList = userService.listAllUsuarios()
					.stream()
					.map(user -> UsersMapper.mapToDTO(user))
					.collect(Collectors.toList());
			if (userDtoList.size() > 0) {
				response = new ResponseEntity<List<UsersDTO>>(userDtoList, HttpStatus.OK);
			} else {
				response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return response;
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsersDTO> getUser(@PathVariable Long id) {
		UsersDTO getUser = UsersMapper.mapToDTO(userService.getUsuario(id));
		return ResponseEntity.status(HttpStatus.OK).body(getUser);
	}

	@PostMapping
	public ResponseEntity<UsersDTO> createUser(@RequestBody Users user) {
		UsersDTO createUser = UsersMapper.mapToDTO(userService.saveUsuario(user));
		return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
	}

	@PutMapping("/{id}")
	public ResponseEntity<UsersDTO> updateUser(@RequestBody Users user) {
		UsersDTO updateUser = UsersMapper.mapToDTO(userService.updateUsuario(user));
		return ResponseEntity.status(HttpStatus.OK).body(updateUser);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<UsersDTO> deleteUser(Long id) {
		UsersDTO deleteUser = UsersMapper.mapToDTO(userService.deleteUsuario(id));
		if (deleteUser != null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<UsersDTO> deleteUser(Long id) {
//		UsersDTO deleteUser = UsersMapper.mapToDTO(userService.deleteUsuario(id));
//		if (deleteUser != null) {
//			return ResponseEntity.noContent().build();
//		}
//		return ResponseEntity.notFound().build();
//	}

}
