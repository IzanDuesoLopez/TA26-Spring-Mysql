package com.example.demo.service;
import java.util.List;

import com.example.demo.dto.Suministra;

public interface ISuministraService {

	// Metodos para el FULL CRUD de Suministra
	public List<Suministra> listarSuministra();
	public Suministra guardarSuministra(Suministra suministra);
	public Suministra suministraXId(int id);
	public Suministra actualizarSuministra(Suministra suministra);
	public void eliminarSuministra(int id);
	
}
