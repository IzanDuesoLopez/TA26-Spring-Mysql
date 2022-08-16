package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Pieza;

public interface IPiezaDAO extends JpaRepository<Pieza, Integer>{

	// Piezas por nombre
	public List<Pieza> findByNombre(String nombre);
	
}
