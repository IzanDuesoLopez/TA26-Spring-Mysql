package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Cientifico;
public interface ICientificoService {

	// Metodos del crud cientifico
	public List<Cientifico> listarCientificos();
	public Cientifico guardarCientifico(Cientifico cientifico);
	public Cientifico cientificoXDni(String dni);
	public Cientifico actualizarCientifico(Cientifico cientifico);
	public void eliminarCientifico(String dni);
	
}
