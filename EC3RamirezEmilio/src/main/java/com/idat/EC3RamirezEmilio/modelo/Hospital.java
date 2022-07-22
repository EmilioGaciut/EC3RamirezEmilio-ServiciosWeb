package com.idat.EC3RamirezEmilio.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="hospital")
public class Hospital {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idHospital")
	private int idHospital;

	@Column(name="nombre", length=64)
	private String nombre;

	@Column(name="descripcion", length=64)
	private String descripcion;

	@Column(name="distrito", length=64)
	private String distrito;
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(
		name="hospital_cliente",
		joinColumns =
			@JoinColumn(
					name="id_cliente", 
					nullable = false, 
					unique = true, 
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_cliente) references cliente (id_cliente)")),
			
		inverseJoinColumns = 
			@JoinColumn(
					name="id_hospital", 
					nullable = false, 
					unique = true, 
					foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key(id_hospital) references hospital (id_hospital)"))
	)
	private List<Cliente> cliente = new ArrayList<Cliente>();
	public Hospital() {
		super();
	}

	public Hospital(int idHospital, String nombre, String descripcion, String distrito) {
		super();
		this.idHospital = idHospital;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.distrito = distrito;
	}

	public int getIdHospital() {
		return idHospital;
	}

	public void setIdHospital(int idHospital) {
		this.idHospital = idHospital;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	@Override
	public String toString() {
		return "Hospital [idHospital=" + idHospital + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", distrito=" + distrito + "]";
	}


}
