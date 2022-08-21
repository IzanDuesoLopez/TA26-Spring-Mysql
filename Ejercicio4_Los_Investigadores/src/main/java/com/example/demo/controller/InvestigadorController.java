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

import com.example.demo.dto.Investigador;
import com.example.demo.service.InvestigadorServiceImpl;

@RestController
@RequestMapping("/api")
public class InvestigadorController {

	@Autowired
	InvestigadorServiceImpl investigadorServiceImpl;
	
	@GetMapping("/investigadores")
	public List<Investigador> listarInvestigadores(){
		return investigadorServiceImpl.listarInvestigadores();
	}
	
	@PostMapping("/investigadores")
	public Investigador guardarInvestigador(@RequestBody Investigador investigador) {
		return investigadorServiceImpl.guardarInvestigador(investigador);
	}
	
	@GetMapping("/investigadores/{dni}")
	public Investigador investigadorXDni(@PathVariable(name="dni") String dni) {
		Investigador investigador = new Investigador();
		investigador = investigadorServiceImpl.investigadorXdni(dni);
		return investigador;
	}
	
	@PutMapping("/investigadores/{dni}")
	public Investigador actualizarInvestigador(@PathVariable(name = "dni") String dni, Investigador investigador) {
		Investigador investigador_seleccionado = new Investigador();
		Investigador investigador_actualizado = new Investigador();

		investigador_seleccionado = investigadorServiceImpl.investigadorXdni(dni);

		investigador_seleccionado.setNom_apels(investigador.getNom_apels());
		investigador_seleccionado.setFacultad(investigador.getFacultad());

		investigador_actualizado = investigadorServiceImpl.actualizarInvestigador(investigador_seleccionado);

		return investigador_actualizado;
	}

	@DeleteMapping("/investigadores/{dni}")
	public void eliminarInvestigador(@PathVariable(name = "dni") String dni) {
		investigadorServiceImpl.eliminarInvestigador(dni);
	}
	
}
