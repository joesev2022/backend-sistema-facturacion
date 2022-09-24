package com.demo.udemy.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.udemy.project.entities.ClienteEntity;
import com.demo.udemy.project.entities.RegionEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{
	
	@Query("from RegionEntity")
	public List<RegionEntity> findAllRegiones();
	
}
