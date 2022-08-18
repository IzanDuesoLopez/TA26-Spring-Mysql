package com.example.demo.service;
import java.util.List;

import com.example.demo.dto.Proveedor;

public interface IProveedorService {

	// Metodos para el FULL CRUD de Proveedor
	public List<Proveedor> listarProveedores();
	public Proveedor guardarProveedor(Proveedor proveedor);
	public Proveedor proveedorXId(String id);
	public List<Proveedor> listarProveedorNombre(String nombre);
	public Proveedor actualizarProveedor(Proveedor proveedor);
	public void eliminarProveedor(String id);
	
}
