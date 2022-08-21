package com.example.demo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservas")
public class Reserva {

	@Id
	@ManyToOne
	@JoinColumn(name="dni")
	Investigador investigador;
	
	@Id
	@ManyToOne
	@JoinColumn(name="num_serie")
	Equipo equipo;
	
	@Column(name="comienzo")
	private Date comienzo;
	@Column(name="fin")
	private Date fin;
	
	public Reserva() {
		
	}

	/**
	 * Constructor full params
	 * @param investigador
	 * @param equipo
	 * @param comienzo
	 * @param fin
	 */
	public Reserva(Investigador investigador, Equipo equipo, Date comienzo, Date fin) {
		this.investigador = investigador;
		this.equipo = equipo;
		this.comienzo = comienzo;
		this.fin = fin;
	}

	/**
	 * @return the investigador
	 */
	public Investigador getInvestigador() {
		return investigador;
	}

	/**
	 * @param investigador the investigador to set
	 */
	public void setInvestigador(Investigador investigador) {
		this.investigador = investigador;
	}

	/**
	 * @return the equipo
	 */
	public Equipo getEquipo() {
		return equipo;
	}

	/**
	 * @param equipo the equipo to set
	 */
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	/**
	 * @return the comienzo
	 */
	public Date getComienzo() {
		return comienzo;
	}

	/**
	 * @param comienzo the comienzo to set
	 */
	public void setComienzo(Date comienzo) {
		this.comienzo = comienzo;
	}

	/**
	 * @return the fin
	 */
	public Date getFin() {
		return fin;
	}

	/**
	 * @param fin the fin to set
	 */
	public void setFin(Date fin) {
		this.fin = fin;
	}

	@Override
	public String toString() {
		return "Reserva [investigador=" + investigador + ", equipo=" + equipo + ", comienzo=" + comienzo + ", fin="
				+ fin + "]";
	}
}
