package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMaquinaRegistradoraDAO;
import com.example.demo.dto.MaquinaRegistradora;

@Service
public class MaquinaRegistradoraServiceImpl implements IMaquinaRegistradoraService{

	@Autowired
	IMaquinaRegistradoraDAO iMaquinaRegistradoraDAO;
	
	@Override
	public List<MaquinaRegistradora> listarMaquinasRegistradoras() {
		return iMaquinaRegistradoraDAO.findAll();
	}

	@Override
	public MaquinaRegistradora guardarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora) {
		return iMaquinaRegistradoraDAO.save(maquinaRegistradora);
	}

	@Override
	public MaquinaRegistradora maquinaRegistradoraXCodigo(int codigo) {
		return iMaquinaRegistradoraDAO.findById(codigo).get();
	}

	@Override
	public MaquinaRegistradora actualizarMaquinaRegistradora(MaquinaRegistradora maquinaRegistradora) {
		return iMaquinaRegistradoraDAO.save(maquinaRegistradora);
	}

	@Override
	public void eliminarMaquinaRegistradora(int codigo) {
		iMaquinaRegistradoraDAO.deleteById(codigo);
		
	}

}
