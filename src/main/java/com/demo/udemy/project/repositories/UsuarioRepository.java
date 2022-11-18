package com.demo.udemy.project.repositories;

import org.springframework.data.repository.CrudRepository;

import com.demo.udemy.project.entities.UsuarioEntity;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long>{
	
	public UsuarioEntity findByUsername(String username);
	
}
