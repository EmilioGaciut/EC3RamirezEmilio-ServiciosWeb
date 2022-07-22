package com.idat.EC3RamirezEmilio.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idCliente")
	private int idCliente;

	@Column(name="nombre", length=64)
	private String nombre;

	@Column(name="celular", length=32)
	private String celular;
	@ManyToMany(mappedBy = "cliente", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Hospital> hospital = new ArrayList<Hospital>();
	public Cliente() {
		super();
	}

	public Cliente(int idCliente, String nombre, String celular) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.celular = celular;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", celular=" + celular + "]";
	}




}
