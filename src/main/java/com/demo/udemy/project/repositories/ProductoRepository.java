package com.demo.udemy.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.udemy.project.entities.ProductoEntity;

public interface ProductoRepository extends CrudRepository<ProductoEntity, Long>{
	
	@Query("select p from ProductoEntity p where p.nombre like %?1%")
	public List<ProductoEntity> findByNombre(String term);
	
	public List<ProductoEntity> findByNombreContainingIgnoreCase(String term);
	
	public List<ProductoEntity> findByNombreStartingWithIgnoreCase(String term);
	
}
