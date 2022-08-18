package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Cajero;

public interface ICajeroDAO extends JpaRepository<Cajero, Integer>{

	public List<Cajero> findByNombre(String nom_apels);
	
}
