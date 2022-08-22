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

import com.example.demo.dto.Reserva;
import com.example.demo.service.ReservaServiceImpl;

@RestController
@RequestMapping("/api")
public class ReservaController {

	@Autowired
	ReservaServiceImpl reservaServiceImpl;
	
	@GetMapping("/reservas")
	public List<Reserva> listarReservas(){
		return reservaServiceImpl.listarReservas();
	}
	
	@PostMapping("/reservas")
	public Reserva guardarReserva(@RequestBody Reserva reserva) {
		return reservaServiceImpl.guardarReserva(reserva);
	}
	
	@GetMapping("/reservas/{id}")
	public Reserva reservaXid(@PathVariable(name="id") String id) {
		Reserva reserva = new Reserva();
		reserva = reservaServiceImpl.reservaXId(id);
		return reserva;
	}
	
	@PutMapping("/reservas/{id}")
	public Reserva actualizarReserva(@PathVariable(name = "id") String id, Reserva reserva) {
		Reserva reserva_seleccionado = new Reserva();
		Reserva reserva_actualizado = new Reserva();

		reserva_seleccionado = reservaServiceImpl.reservaXId(id);

		reserva_seleccionado.setComienzo(reserva.getComienzo());
		reserva_seleccionado.setFin(reserva.getFin());

		reserva_actualizado = reservaServiceImpl.actualizarReserva(reserva_seleccionado);

		return reserva_actualizado;
	}

	@DeleteMapping("/reservas/{id}")
	public void eliminarReserva(@PathVariable(name = "id") String id) {
		reservaServiceImpl.eliminarReserva(id);
	}
	
}
