package com.example.demo.service;
import java.util.List;

import com.example.demo.dto.Pieza;

public interface IPiezaService {

	// Metodos para el FULL CRUD de Pieza
	public List<Pieza> listarPiezas();
	public Pieza guardarPieza(Pieza pieza);
	public Pieza piezaXCodigo(int codigo);
	public List<Pieza> listarPiezaNombre(String nombre);
	public Pieza actualizarPieza(Pieza pieza);
	public void eliminarPieza(int codigo);
	
}
