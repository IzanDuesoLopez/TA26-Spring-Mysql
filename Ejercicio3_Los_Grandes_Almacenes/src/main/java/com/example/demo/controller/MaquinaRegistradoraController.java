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

import com.example.demo.dto.MaquinaRegistradora;
import com.example.demo.service.MaquinaRegistradoraServiceImpl;

@RestController
@RequestMapping("/api")
public class MaquinaRegistradoraController {

	@Autowired
	MaquinaRegistradoraServiceImpl maquinaRegistradoraServiceImpl;
	
	@GetMapping("/maquinas")
	public List<MaquinaRegistradora> listarMaquinas(){
		return maquinaRegistradoraServiceImpl.listarMaquinasRegistradoras();
	}
	
	@PostMapping("/maquinas")
	public MaquinaRegistradora guardarMaquinaRegistradora(@RequestBody MaquinaRegistradora maquinaRegistradora) {
		return maquinaRegistradoraServiceImpl.guardarMaquinaRegistradora(maquinaRegistradora);
	}
	
	@GetMapping("/maquinas/{codigo}")
	public MaquinaRegistradora maquinaRegistradoraXCodigo(@PathVariable(name="codigo") int codigo) {
		MaquinaRegistradora maquinaRegistradora = new MaquinaRegistradora();
		maquinaRegistradora = maquinaRegistradoraServiceImpl.maquinaRegistradoraXCodigo(codigo);
		return maquinaRegistradora;
	}
	
	@PutMapping("/maquinas/{codigo}")
	public MaquinaRegistradora actualizarMaquinaRegistradora(@PathVariable(name="codigo") int codigo, @RequestBody MaquinaRegistradora maquinaRegistradora) {
		MaquinaRegistradora maquinaRegistradora_seleccionado = new MaquinaRegistradora();
		MaquinaRegistradora maquinaRegistradora_actualizado = new MaquinaRegistradora();
		
		maquinaRegistradora_seleccionado = maquinaRegistradoraServiceImpl.maquinaRegistradoraXCodigo(codigo);
		
		maquinaRegistradora_seleccionado.setPiso(maquinaRegistradora.getPiso());
		
		maquinaRegistradora_actualizado = maquinaRegistradoraServiceImpl.actualizarMaquinaRegistradora(maquinaRegistradora_seleccionado);
		
		return maquinaRegistradora_actualizado;
	}
	
	@DeleteMapping("/maquinas/{codigo}")
	public void eliminarMaquinaRegistradora(@PathVariable(name="codigo") int codigo) {
		maquinaRegistradoraServiceImpl.eliminarMaquinaRegistradora(codigo);
	}
}
