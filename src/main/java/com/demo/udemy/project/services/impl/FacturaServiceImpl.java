package com.demo.udemy.project.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.udemy.project.entities.FacturaEntity;
import com.demo.udemy.project.repositories.FacturaRepository;
import com.demo.udemy.project.services.FacturaService;

@Service
public class FacturaServiceImpl implements FacturaService{
	
	@Autowired
	private FacturaRepository facturaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public FacturaEntity findById(Long id) {
		return facturaRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public FacturaEntity save(FacturaEntity factura) {
		return facturaRepository.save(factura);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		facturaRepository.deleteById(id);
	}

}
