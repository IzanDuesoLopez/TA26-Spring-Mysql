package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Venta;

public interface IVentaService {

	// Metodos del full CRUD
	public List<Venta> listarVentas();
	public Venta guardarVenta(Venta venta);
	public Venta ventaXId(int id);
	public Venta actualizarVenta(Venta venta);
	public void eliminarVenta(int id);
	
}
