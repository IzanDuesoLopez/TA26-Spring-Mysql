package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Producto;

public interface IProductoService {

	// Metodos del full CRUD
	public List<Producto> listarProductos();
	public Producto guardarProducto(Producto producto);
	public Producto productoXCodigo(int codigo);
	public List<Producto> listarProductoNombre(String nombre);
	public Producto actualizarProducto(Producto producto);
	public void eliminarProducto(int codigo);
	
}
