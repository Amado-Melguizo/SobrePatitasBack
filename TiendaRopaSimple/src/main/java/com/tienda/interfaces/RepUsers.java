package com.tienda.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.entidades.Users;

@Repository
public interface RepUsers extends JpaRepository<Users,Long>{
	
}