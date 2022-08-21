package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="equipos")
public class Equipo {

	@Id
	@Column(name="num_serie")
	private String num_serie;
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="num_serie")
	private List<Reserva> reserva;
	
	@ManyToOne
	@JoinColumn(name="facultad")
	Facultad facultad;
	
	public Equipo() {
		
	}

	/**
	 * Constructor full params
	 * @param num_serie
	 * @param nombre
	 * @param reserva
	 * @param facultad
	 */
	public Equipo(String num_serie, String nombre, List<Reserva> reserva, Facultad facultad) {
		this.num_serie = num_serie;
		this.nombre = nombre;
		this.reserva = reserva;
		this.facultad = facultad;
	}

	/**
	 * @return the num_serie
	 */
	public String getNum_serie() {
		return num_serie;
	}

	/**
	 * @param num_serie the num_serie to set
	 */
	public void setNum_serie(String num_serie) {
		this.num_serie = num_serie;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the reserva
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReserva() {
		return reserva;
	}

	/**
	 * @param reserva the reserva to set
	 */
	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	/**
	 * @return the facultad
	 */
	public Facultad getFacultad() {
		return facultad;
	}

	/**
	 * @param facultad the facultad to set
	 */
	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@Override
	public String toString() {
		return "Equipo [num_serie=" + num_serie + ", nombre=" + nombre + ", facultad=" + facultad + "]";
	}
}
