package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cajero;

public interface ICajeroService {

	// Metodos del full CRUD
	public List<Cajero> listarCajeros();
	public Cajero guardarCajero(Cajero cajero);
	public Cajero cajeroXCodigo(int codigo);
	public Cajero actualizarCajero(Cajero cajero);
	public void eliminarCajero(int codigo);
	
}
