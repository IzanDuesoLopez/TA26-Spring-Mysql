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
@Table(name="proveedores")
public class Proveedor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private char id;
	@Column(name="nombre")
	private String nombre;
	
	@OneToMany
	@JoinColumn(name="idProveedor")
	private List<Suministra> suministra;
	
	// Constructor default
	public Proveedor() {
		
	}

	/**
	 * Constructor con todos los params
	 * @param id
	 * @param nombre
	 * @param suministra
	 */
	public Proveedor(char id, String nombre, List<Suministra> suministra) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.suministra = suministra;
	}

	/**
	 * @return the id
	 */
	public char getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(char id) {
		this.id = id;
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
	 * @return the suministra
	 */
	public List<Suministra> getSuministra1() {
		return suministra;
	}

	/**
	 * @param suministra the suministra to set
	 */
	public void setSuministra(List<Suministra> suministra) {
		this.suministra = suministra;
	}

	@JsonIgnore
	@OneToMany(fetch =  FetchType.LAZY, mappedBy = "suministra")
	public List<Suministra> getSuministra(){
		return suministra;
	}
	
	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + "]";
	}
}
