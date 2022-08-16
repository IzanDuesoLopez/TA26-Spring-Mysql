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
@Table(name="proyectos")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	@Column(name="nombre")
	private String nombre;
	@Column(name="horas")
	private int horas;
	
	@OneToMany
	@JoinColumn(name="proyecto")
	private List<Asignado_a> asignado_a;
	
	public Proyecto() {
		
	}

	/**
	 * Constructor full params
	 * @param id
	 * @param nombre
	 * @param horas
	 * @param asignado_a
	 */
	public Proyecto(String id, String nombre, int horas, List<Asignado_a> asignado_a) {
		this.id = id;
		this.nombre = nombre;
		this.horas = horas;
		this.asignado_a = asignado_a;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	 * @return the horas
	 */
	public int getHoras() {
		return horas;
	}

	/**
	 * @param horas the horas to set
	 */
	public void setHoras(int horas) {
		this.horas = horas;
	}

	/**
	 * @return the asignado_a
	 */
	public List<Asignado_a> getAsignado_a() {
		return asignado_a;
	}

	/**
	 * @param asignado_a the asignado_a to set
	 */
	public void setAsignado_a(List<Asignado_a> asignado_a) {
		this.asignado_a = asignado_a;
	}

	@JsonIgnore
	@OneToMany(fetch =  FetchType.LAZY, mappedBy = "Asignado_a")
		public List<Asignado_a> getAsignadoA(){
			return asignado_a;
		}
	
	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", nombre=" + nombre + ", horas=" + horas + "]";
	}
	
	
}
