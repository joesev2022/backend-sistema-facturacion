package com.demo.udemy.project.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.udemy.project.entities.ProductoEntity;
import com.demo.udemy.project.repositories.ProductoRepository;
import com.demo.udemy.project.services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<ProductoEntity> findByNombre(String term) {
		return productoRepository.findByNombre(term);
	}

}
