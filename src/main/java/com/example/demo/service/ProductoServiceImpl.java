package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProductoDAO;
import com.example.demo.dto.Producto;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	IProductoDAO iProductoDAO;
	
	@Override
	public List<Producto> listarProductos() {
		return iProductoDAO.findAll();
	}

	@Override
	public Producto guardarProducto(Producto producto) {
		return iProductoDAO.save(producto);
	}

	@Override
	public Producto productoXCodigo(int codigo) {
		return iProductoDAO.findById(codigo).get();
	}

	@Override
	public List<Producto> listarProductoNombre(String nombre) {
		return iProductoDAO.findByNombre(nombre);
	}

	@Override
	public Producto actualizarProducto(Producto producto) {
		return iProductoDAO.save(producto);
	}

	@Override
	public void eliminarProducto(int codigo) {
		iProductoDAO.deleteById(codigo);
		
	}

}
