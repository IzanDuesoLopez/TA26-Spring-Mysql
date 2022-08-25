package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Cientifico;
import com.example.demo.dto.Proyecto;
import com.example.demo.service.ProyectoServiceImpl;

@RestController
@RequestMapping("/api")
public class ProyectoController {
	
	@Autowired
	ProyectoServiceImpl proyectoServiceImpl;
	
	@GetMapping("/proyectos")
	public List<Proyecto> listarProyectos(){
		return proyectoServiceImpl.listarProyectos();
	}
	
	@GetMapping("/proyectos/nombre/{nombre}")
	public List<Proyecto> listarProyectoNombre(@PathVariable(name="nombre") String nombre){
		return proyectoServiceImpl.listarProyectoNombre(nombre);
	}
	
	@PostMapping("/proyectos")
	public Proyecto guardarProyecto(@RequestBody Proyecto proyecto) {
		return proyectoServiceImpl.guardarProyecto(proyecto);
	}
	
	@GetMapping("/proyectos/{id}")
	public Proyecto proyectoXId(@PathVariable(name="id") String id) {
		Proyecto proyecto = new Proyecto();
		proyecto = proyectoServiceImpl.proyectoXId(id);
		return proyecto;
	}
	
	@PutMapping("/proyectos/{id}")
	public Proyecto actualizarProyecto(@PathVariable(name = "id") String id, Proyecto proyecto) {
		Proyecto proyecto_seleccionado = new Proyecto();
		Proyecto proyecto_actualizado = new Proyecto();

		proyecto_seleccionado = proyectoServiceImpl.proyectoXId(id);

		proyecto_seleccionado.setNombre(proyecto.getNombre());
		proyecto_seleccionado.setHoras(proyecto.getHoras());

		proyecto_actualizado = proyectoServiceImpl.actualizarProyecto(proyecto_seleccionado);

		return proyecto_actualizado;
	}

	@DeleteMapping("/proyectos/{id}")
	public void eliminarProyecto(@PathVariable(name = "id") String id) {
		proyectoServiceImpl.eliminarProyecto(id);
	}

}
