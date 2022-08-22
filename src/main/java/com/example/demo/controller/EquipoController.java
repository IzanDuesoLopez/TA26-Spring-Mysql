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

import com.example.demo.dto.Equipo;
import com.example.demo.service.EquipoServiceImpl;

@RestController
@RequestMapping("/api")
public class EquipoController {

	@Autowired
	EquipoServiceImpl equipoServiceImpl;
	
	@GetMapping("/equipos")
	public List<Equipo> listarEquipos(){
		return equipoServiceImpl.listarEquipos();
	}
	
	@PostMapping("/equipos")
	public Equipo guardarEquipo(@RequestBody Equipo equipo) {
		return equipoServiceImpl.guardarEquipo(equipo);
	}
	
	@GetMapping("/equipos/{num}")
	public Equipo EquipoXnum(@PathVariable(name="num") String num) {
		Equipo equipo = new Equipo();
		equipo = equipoServiceImpl.equipoXNum(num);
		return equipo;
	}
	
	@PutMapping("/equipos/{num}")
	public Equipo actualizarEquipo(@PathVariable(name = "num") String num, Equipo equipo) {
		Equipo equipo_seleccionado = new Equipo();
		Equipo equipo_actualizado = new Equipo();

		equipo_seleccionado = equipoServiceImpl.equipoXNum(num);

		equipo_seleccionado.setNombre(equipo.getNombre());
		equipo_seleccionado.setFacultad(equipo.getFacultad());

		equipo_actualizado = equipoServiceImpl.actualizarEquipo(equipo_seleccionado);

		return equipo_actualizado;
	}

	@DeleteMapping("/equipos/{num}")
	public void eliminarEquipo(@PathVariable(name = "num") String num) {
		equipoServiceImpl.eliminarEquipo(num);
	}
	
}
