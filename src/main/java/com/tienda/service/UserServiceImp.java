package com.tienda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.entities.Users;
import com.tienda.interfaces.UsersRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UsersRepo repoUsers;

	/* User Methods */

	// Listar Usuarios
	@Override
	public List<Users> listAllUsuarios() {
		return repoUsers.findAll();
	}

	// Ver Usuario
	@Override
	public Users getUsuario(Long id) {
		Optional<Users> user = repoUsers.findById(id);
		return user.orElse(null);
	}

	// Guardar Usuario
	@Override
	public Users saveUsuario(Users user) {
		return repoUsers.save(user);
	}

	// Actualizar Usuario
	@Override
	public Users updateUsuario(Users user) {
		if (user.getId() == null && repoUsers.existsById(user.getId())) {
			return repoUsers.save(user);
		}
		return null;
	}

	// Borrar Usuario
	@Override
	public Users deleteUsuario(Long id) {
		repoUsers.deleteById(id);
		return null;
	}

//	@Override
//	public boolean deleteUsuario(Long id) {
//		boolean result = false;
//		if (id != null && repoUsers.existsById(id)) {
//			repoUsers.deleteById(id);
//			result = true;
//		}
//
//		return result;
//	}

}