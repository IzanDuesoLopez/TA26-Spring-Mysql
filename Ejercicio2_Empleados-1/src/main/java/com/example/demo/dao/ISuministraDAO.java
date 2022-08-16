package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Suministra;

public interface ISuministraDAO extends JpaRepository<Suministra, Integer>{

	// Suministra por id
	public List<Suministra> findByNombre(int id);
	
}
