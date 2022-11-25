package com.demo.udemy.project.services;

import java.util.List;

import com.demo.udemy.project.entities.ProductoEntity;

public interface ProductoService {
	public List<ProductoEntity> findByNombre(String term);
}
