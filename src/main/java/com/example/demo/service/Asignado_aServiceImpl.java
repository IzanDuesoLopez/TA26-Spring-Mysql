package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAsignado_aDAO;
import com.example.demo.dto.Asignado_a;

@Service
public class Asignado_aServiceImpl implements IAsignado_aService{

	// Utilizamos metodos interfaz
	@Autowired
	IAsignado_aDAO iAsignado_aDAO;
	
	@Override
	public List<Asignado_a> listarAsignados() {
		return iAsignado_aDAO.findAll();
	}

	@Override
	public Asignado_a guardarAsignado(Asignado_a asignado_a) {
		return iAsignado_aDAO.save(asignado_a);
	}

	@Override
	public Asignado_a asignadoXId(int id) {
		return iAsignado_aDAO.findById(id).get();
	}

	@Override
	public Asignado_a actualizarAsignado(Asignado_a asignado_a) {
		return iAsignado_aDAO.save(asignado_a);
	}

	@Override
	public void eliminarAsignado(int id) {
		iAsignado_aDAO.deleteById(id);
		
	}
	
	
	

}
