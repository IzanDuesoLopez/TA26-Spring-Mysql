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

import com.example.demo.service.ProveedorServiceImpl;
import com.example.demo.dto.Proveedor;

@RestController
@RequestMapping("/api")
public class ProveedorController {

	@Autowired
	ProveedorServiceImpl proveedorServiceImpl;
	
	// Listamos proveedores
	@GetMapping("/proveedores")
	public List<Proveedor> listarProveedores(){
		return proveedorServiceImpl.listarProveedores();
	}
		
	// Listamos proveedor por nombre
	@GetMapping("/proveedores/nombre/{nombre}")
	public List<Proveedor> listarProveedorNombre(@PathVariable(name="nombre") String nombre){
		return proveedorServiceImpl.listarProveedorNombre(nombre);
	}
	
	// Post de proveedor
	@PostMapping("/proveedores")
	public Proveedor guardarProveedores(@RequestBody Proveedor proveedor) {
		return proveedorServiceImpl.guardarProveedor(proveedor);
	}
	
	// Listamos proveedores por id
	@GetMapping("/proveedores/{id}")
	public Proveedor proveedorXId(@PathVariable(name="id") String id) {
		Proveedor proveedor = new Proveedor();
		proveedor = proveedorServiceImpl.proveedorXId(id);
		return proveedor;
	}
	
	// Update proveedores por id
	@PutMapping("/proveedores/{id}")
	public Proveedor actualizarProveedor(@PathVariable(name="id")String id, @RequestBody Proveedor proveedor) {
		Proveedor proveedor_sel = new Proveedor();
		Proveedor proveedor_upd = new Proveedor();
		
		proveedor_sel = proveedorServiceImpl.proveedorXId(id);
		
		proveedor_sel.setNombre(proveedor.getNombre());
		
		proveedor_upd = proveedorServiceImpl.actualizarProveedor(proveedor_sel);
		
		return proveedor_upd;
	}
	
	// Eliminamos proveedor x id
	@DeleteMapping("/proveedores/{id}")
	public void eliminarProveedores(@PathVariable(name="id") String id) {
		proveedorServiceImpl.eliminarProveedor(id);
	}
}
