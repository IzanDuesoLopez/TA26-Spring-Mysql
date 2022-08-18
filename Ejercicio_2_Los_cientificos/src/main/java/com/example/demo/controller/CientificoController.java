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
import com.example.demo.service.CientificoServiceImpl;

@RestController
@RequestMapping("/api")
public class CientificoController {
	
	@Autowired
	CientificoServiceImpl cientificoServiceImpl;
	
	@GetMapping("/cientificos")
	public List<Cientifico> listarCientificos(){
		return cientificoServiceImpl.listarCientificos();
	}
	
	@PostMapping("/cientificos")
	public Cientifico guardarCientifico(@RequestBody Cientifico cientifico) {
		return cientificoServiceImpl.guardarCientifico(cientifico);
	}
	
	@GetMapping("/cientificos/{dni}")
	public Cientifico cientificoXDni(@PathVariable(name="dni") String dni) {
		Cientifico cientifico = new Cientifico();
		cientifico = cientificoServiceImpl.cientificoXDni(dni);
		return cientifico;
	}
	
	@PutMapping("/cientificos/{dni}")
	public Cientifico actualizarCientifico(@PathVariable(name = "dni") String dni, Cientifico cientifico) {
		Cientifico cientifico_seleccionado = new Cientifico();
		Cientifico cientifico_actualizado = new Cientifico();

		cientifico_seleccionado = cientificoServiceImpl.cientificoXDni(dni);

		cientifico_seleccionado.setNom_apels(cientifico.getNom_apels());

		cientifico_actualizado = cientificoServiceImpl.actualizarCientifico(cientifico_seleccionado);

		return cientifico_actualizado;
	}

	@DeleteMapping("/cientificos/{dni}")
	public void eliminarCientifico(@PathVariable(name = "dni") String dni) {
		cientificoServiceImpl.eliminarCientifico(dni);
	}

}
