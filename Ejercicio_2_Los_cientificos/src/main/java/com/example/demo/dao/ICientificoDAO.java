package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Cientifico;

public interface ICientificoDAO extends JpaRepository<Cientifico, String>{

	// Cientifico por nombre
	public List<Cientifico> findByNombre(String nombre);
	
}
