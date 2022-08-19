package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Producto;

public interface IProductoDAO extends JpaRepository<Producto, Integer>{

	public List<Producto> findByNombre(String nombre);
	
}
