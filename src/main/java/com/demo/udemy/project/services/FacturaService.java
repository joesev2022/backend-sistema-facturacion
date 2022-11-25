package com.demo.udemy.project.services;

import com.demo.udemy.project.entities.FacturaEntity;

public interface FacturaService {
	public FacturaEntity findById(Long id);
	public FacturaEntity save(FacturaEntity factura);
	public void delete(Long id);
}
