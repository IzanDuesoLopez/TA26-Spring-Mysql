package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Cientifico;
import com.example.demo.dto.Proyecto;

public interface ICientificoDAO extends JpaRepository<Cientifico, String>{
	
	// Cientifico por nombre
	//public List<Cientifico> findByNombre(String nom_apels);
	
}
