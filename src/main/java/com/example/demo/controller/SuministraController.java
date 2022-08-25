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

import com.example.demo.service.SuministraServiceImpl;
import com.example.demo.dto.Suministra;

@RestController
@RequestMapping("/api")
public class SuministraController {

	@Autowired
	SuministraServiceImpl suministraServiceImpl;
	
	// Listamos suministros
	@GetMapping("/suministros")
	public List<Suministra> listaSuministros(){
		return suministraServiceImpl.listarSuministra();
	}
	
	// Post de suministros
	@PostMapping("/suministros")
	public Suministra guardarSuministros(@RequestBody Suministra suministra) {
		return suministraServiceImpl.guardarSuministra(suministra);
	}
	
	// Listamos suministros por id
	@GetMapping("/suministros/{id}")
	public Suministra suministroXId(@PathVariable(name="id") int id) {
		Suministra suministro = new Suministra();
		suministro = suministraServiceImpl.suministraXId(id);
		return suministro;
	}
	
	// Update suministros por id
	@PutMapping("/suministros/{id}")
	public Suministra actualizarSuministro(@PathVariable(name="id")int id, @RequestBody Suministra suministra) {
		Suministra suministro_sel = new Suministra();
		Suministra suministro_upd = new Suministra();
		
		suministro_sel = suministraServiceImpl.suministraXId(id);
		
		suministro_sel.setPieza(suministra.getPieza());
		suministro_sel.setProveedor(suministra.getProveedor());
		suministro_sel.setPrecio(suministra.getPrecio());
		
		suministro_upd = suministraServiceImpl.actualizarSuministra(suministro_sel);
		
		return suministro_upd;
	}
	
	// Eliminamos suministro x id
	@DeleteMapping("/suministros/{id}")
	public void eliminarSUministro(@PathVariable(name="id") int id) {
		suministraServiceImpl.eliminarSuministra(id);
	}
}
