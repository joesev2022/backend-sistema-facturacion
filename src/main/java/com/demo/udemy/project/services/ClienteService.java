package com.demo.udemy.project.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.udemy.project.entities.ClienteEntity;
/*
 * Aquí se preparan los métodos que serán implementados en ClienteServiceImpl.
 */
public interface ClienteService {
	//Listar clientes
	public List<ClienteEntity> findAll();
	//Listado para paginar
	public Page<ClienteEntity> findAll(Pageable pagable);
	//Encontrar cliente por id
	public ClienteEntity findById(Long id);
	//Guardar cliente
	public ClienteEntity save(ClienteEntity cliente);
	//Eliminar cliente por id
	public void delete(Long id);
	
}
