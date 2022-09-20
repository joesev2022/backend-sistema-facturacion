package com.demo.udemy.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.udemy.project.entities.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long>{

}
