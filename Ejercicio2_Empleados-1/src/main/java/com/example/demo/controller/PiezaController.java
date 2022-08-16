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

import com.example.demo.service.PiezaServiceImpl;
import com.example.demo.dto.Pieza;

@RestController
@RequestMapping("/api")
public class PiezaController {

	@Autowired
	PiezaServiceImpl piezaServiceImpl;
	
	// Listamos piezas
	@GetMapping("/piezas")
	public List<Pieza> listarPiezas(){
		return piezaServiceImpl.listarPiezas();
	}
		
	// Listamos pieza por nombre
	@GetMapping("/piezas/nombre/{nombre}")
	public List<Pieza> listarPiezaNombre(@PathVariable(name="nombre") String nombre){
		return piezaServiceImpl.listarPiezaNombre(nombre);
	}
	
	// Post de pieza
	@PostMapping("/piezas")
	public Pieza guardarPiezas(@RequestBody Pieza pieza) {
		return piezaServiceImpl.guardarPieza(pieza);
	}
	
	// Listamos piezas por codigo
	@GetMapping("/piezas/{codigo}")
	public Pieza piezaXCodigo(@PathVariable(name="codigo") int codigo) {
		Pieza pieza = new Pieza();
		pieza = piezaServiceImpl.piezaXCodigo(codigo);
		return pieza;
	}
	
	// Update piezas por codigo
	@PutMapping("/piezas/{codigo}")
	public Pieza actualizarPieza(@PathVariable(name="codigo")int codigo, @RequestBody Pieza pieza) {
		Pieza pieza_sel = new Pieza();
		Pieza pieza_upd = new Pieza();
		
		pieza_sel = piezaServiceImpl.piezaXCodigo(codigo);
		
		pieza_sel.setNombre(pieza.getNombre());
		
		pieza_upd = piezaServiceImpl.actualizarPieza(pieza_sel);
		
		return pieza_upd;
	}
	
	// Eliminamos pieza x codigo
	@DeleteMapping("/piezas/{codigo}")
	public void eliminarPiezas(@PathVariable(name="codigo") int codigo) {
		piezaServiceImpl.eliminarPieza(codigo);
	}
}
