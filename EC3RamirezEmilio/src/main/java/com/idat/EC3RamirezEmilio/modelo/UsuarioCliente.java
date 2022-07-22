package com.idat.EC3RamirezEmilio.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario_cliente")
public class UsuarioCliente {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUsuario")
	private int idUsuario;

	@Column(name="usuario", length=64)
	private String usuario;

	@Column(name="password", length=32)
	private String password;

	@Column(name="rol", length=32)
	private String rol;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name="idCliente")
	private Cliente cliente;

	public UsuarioCliente() {
		super();
	}

	public UsuarioCliente(int idUsuario, String usuario, String password, String rol, Cliente cliente) {
		super();
		this.idUsuario = idUsuario;
		this.usuario = usuario;
		this.password = password;
		this.rol = rol;
		this.cliente = cliente;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "UsuarioCliente [idUsuario=" + idUsuario + ", usuario=" + usuario + ", password=" + password + ", rol="
				+ rol + ", cliente=" + cliente + "]";
	}




}
