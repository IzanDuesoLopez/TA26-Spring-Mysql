package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProveedorDAO;
import com.example.demo.dto.Proveedor;

@Service
public class ProveedorServiceImpl implements IProveedorService{

	// Utilizamos interfaz
	@Autowired
	IProveedorDAO iProveedorDAO;
	
	@Override
	public List<Proveedor> listarProveedores() {
		return iProveedorDAO.findAll();
	}

	@Override
	public Proveedor guardarProveedor(Proveedor proveedor) {
		return iProveedorDAO.save(proveedor);
	}

	@Override
	public Proveedor proveedorXId(char id) {
		return iProveedorDAO.findById(id).get();
	}

	@Override
	public List<Proveedor> listarProveedorNombre(String nombre) {
		return iProveedorDAO.findByNombre(nombre);
	}

	@Override
	public Proveedor actualizarProveedor(Proveedor proveedor) {
		return iProveedorDAO.save(proveedor);
	}

	@Override
	public void eliminarProveedor(char id) {
		iProveedorDAO.deleteById(id);
		
	}
}
