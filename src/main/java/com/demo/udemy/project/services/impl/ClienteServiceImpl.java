package com.demo.udemy.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.udemy.project.entities.ClienteEntity;
import com.demo.udemy.project.repositories.ClienteRepository;
import com.demo.udemy.project.services.ClienteService;
/*
 * Aquí se preparan los métodos del ClienteService y luego poder ser usados en algún Controlador.
 */
@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<ClienteEntity> findAll() {
		return (List<ClienteEntity>) clienteRepository.findAll();
	}
	
	//Método que obtiene clientes para una paginación.
	@Override
	@Transactional(readOnly = true)
	public Page<ClienteEntity> findAll(Pageable pagable) {
		return clienteRepository.findAll(pagable);
	}

	@Override
	@Transactional(readOnly = true)
	public ClienteEntity findById(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public ClienteEntity save(ClienteEntity cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteRepository.deleteById(id);
	}

}
