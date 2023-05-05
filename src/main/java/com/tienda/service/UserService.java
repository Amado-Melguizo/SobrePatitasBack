package com.tienda.service;

import java.util.List;

import com.tienda.entities.Users;

public interface UserService {
	
	List<Users> listAllUsuarios();
	
	Users getUsuario (Long id);

	Users saveUsuario(Users user);

	Users updateUsuario(Users user);

	// lo que tenia
//	boolean deleteUsuario(Long id);
	
	// lo que me sugiere
	Users deleteUsuario(Long id);

}
