package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Cajero;
import com.example.demo.service.CajeroServiceImpl;

@RestController
@RequestMapping("/api")
public class CajeroController {

	@Autowired
	CajeroServiceImpl cajeroServiceImpl;
	
	@GetMapping("/cajeros")
	public List<Cajero> listarCajeros(){
		return cajeroServiceImpl.listarCajeros();
	}
	
	@GetMapping("/cajeros/nom_apels/{nom_apels}")
	public List<Cajero> listarCajeroNombre(@PathVariable(name="nom_apels") String nom_apels){
		return cajeroServiceImpl.listarCajeroNombre(nom_apels);
	}
	
	@PostMapping("/cajeros")
	public Cajero guardarCajero(@RequestBody Cajero cajero) {
		
	}
}
