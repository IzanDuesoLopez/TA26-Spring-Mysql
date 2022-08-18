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

import com.example.demo.dto.Asignado_a;
import com.example.demo.service.Asignado_aServiceImpl;

@RestController
@RequestMapping("/api")
public class Asignado_aController {
	
	@Autowired
	Asignado_aServiceImpl asignado_aServiceImpl;
	
	@GetMapping("/asignados")
	public List<Asignado_a> listarAsignado_a(){
		return asignado_aServiceImpl.listarAsignados();
	}
	
	@PostMapping("/asignados")
	public Asignado_a guardarAsignado_a(@RequestBody Asignado_a asignado_a) {
		return asignado_aServiceImpl.guardarAsignado(asignado_a);
	}
	
	@GetMapping("/asignados/{id}")
	public Asignado_a asignado_aXId(@PathVariable(name="id") int id) {
		Asignado_a asignado_a = new Asignado_a();
		asignado_a = asignado_aServiceImpl.asignadoXId(id);
		return asignado_a;
	}
	
	@PutMapping("/asignados/{id}")
	public Asignado_a actualizarAsignado_a(@PathVariable(name = "id") int id, Asignado_a asignado_a) {
		Asignado_a asignado_a_seleccionado = new Asignado_a();
		Asignado_a asignado_a_actualizado = new Asignado_a();

		asignado_a_seleccionado = asignado_aServiceImpl.asignadoXId(id);

		asignado_a_seleccionado.setCientifico(asignado_a.getCientifico());
		asignado_a_seleccionado.setProyecto(asignado_a.getProyecto());

		asignado_a_actualizado = asignado_aServiceImpl.actualizarAsignado(asignado_a_seleccionado);

		return asignado_a_actualizado;
	}

	@DeleteMapping("/asignados/{id}")
	public void eliminarAsignado_a(@PathVariable(name = "id") int id) {
		asignado_aServiceImpl.eliminarAsignado(id);
	}

}
