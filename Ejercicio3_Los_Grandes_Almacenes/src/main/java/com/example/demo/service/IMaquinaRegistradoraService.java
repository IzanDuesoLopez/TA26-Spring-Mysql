package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MaquinaRegistradora;

public interface IMaquinaRegistradoraService {

	// Metodos del full CRUD
	public List<MaquinaRegistradora> listarMaquinasRegistradoras();
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora);
	public MaquinaRegistradora maquinaRegistradoraXCodigo(int codigo);
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora);
	public void eliminarMaquinaRegistradora(int codigo);
	
}
