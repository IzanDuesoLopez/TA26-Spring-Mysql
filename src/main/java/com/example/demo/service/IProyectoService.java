package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Proyecto;
public interface IProyectoService {

	// Metodos del crud proyecto
	public List<Proyecto> listarProyectos();
	public Proyecto guardarProyecto(Proyecto proyecto);
	public Proyecto proyectoXId(String id);
	public List<Proyecto> listarProyectoNombre(String nombre);
	public Proyecto actualizarProyecto(Proyecto proyecto);
	public void eliminarProyecto(String id);
	
}
