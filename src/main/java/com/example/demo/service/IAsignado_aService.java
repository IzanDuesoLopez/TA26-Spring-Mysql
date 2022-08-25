package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Asignado_a;
public interface IAsignado_aService {

	// Metodos del crud Asignado_a
	public List<Asignado_a> listarAsignados();
	public Asignado_a guardarAsignado(Asignado_a asignado_a);
	public Asignado_a asignadoXId(int id);
	public Asignado_a actualizarAsignado(Asignado_a asignado_a);
	public void eliminarAsignado(int id);
	
}
