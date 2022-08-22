package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="facultades")
public class Facultad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="facultad")
	private List<Equipo> equipo;
	
	@OneToMany
	@JoinColumn(name="facultad")
	private List<Investigador> investigador;
	
	// Constructor por defecto facultad
	public Facultad() {
		
	}

	/**
	 * Constructor with all params
	 * @param codigo
	 * @param nombre
	 * @param equipo
	 * @param investigador
	 */
	public Facultad(int codigo, String nombre, List<Equipo> equipo, List<Investigador> investigador) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.equipo = equipo;
		this.investigador = investigador;
	}

	/**
	 * @return the codigo
	 */
	public int getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	 * @return the equipo
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipo")
	public List<Equipo> getEquipo() {
		return equipo;
	}

	/**
	 * @param equipo the equipo to set
	 */
	public void setEquipo(List<Equipo> equipo) {
		this.equipo = equipo;
	}

	/**
	 * @return the investigador
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigador")
	public List<Investigador> getInvestigador() {
		return investigador;
	}

	/**
	 * @param investigador the investigador to set
	 */
	public void setInvestigador(List<Investigador> investigador) {
		this.investigador = investigador;
	}

	@Override
	public String toString() {
		return "Facultad [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
}
