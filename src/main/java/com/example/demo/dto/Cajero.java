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
@Table(name="cajeros")
public class Cajero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column(name="nom_apels")
	private String nom_apels;
	
	@OneToMany
	@JoinColumn(name="codigo_cajero")
	private List<Venta> venta;
	
	public Cajero() {
		
	}

	/**
	 * Constructor full
	 * @param codigo
	 * @param nom_apels
	 * @param venta
	 */
	public Cajero(int codigo, String nom_apels, List<Venta> venta) {
		this.codigo = codigo;
		this.nom_apels = nom_apels;
		this.venta = venta;
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
	 * @return the nom_apels
	 */
	public String getNom_apels() {
		return nom_apels;
	}

	/**
	 * @param nom_apels the nom_apels to set
	 */
	public void setNom_apels(String nom_apels) {
		this.nom_apels = nom_apels;
	}

	/**
	 * @return the venta
	 */
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVenta() {
		return venta;
	}

	/**
	 * @param venta the venta to set
	 */
	public void setVenta(List<Venta> venta) {
		this.venta = venta;
	}

	@Override
	public String toString() {
		return "Cajero [codigo=" + codigo + ", nom_apels=" + nom_apels + "]";
	}
	
	
	
}
