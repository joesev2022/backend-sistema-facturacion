package com.demo.udemy.project.services;

import com.demo.udemy.project.entities.UsuarioEntity;

public interface UsuarioService {
	
	public UsuarioEntity findByUsername(String username);
	
}
