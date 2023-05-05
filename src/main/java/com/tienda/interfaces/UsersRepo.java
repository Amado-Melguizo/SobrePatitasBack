package com.tienda.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.entities.Users;

@Repository
public interface UsersRepo extends JpaRepository<Users,Long>{
	
}