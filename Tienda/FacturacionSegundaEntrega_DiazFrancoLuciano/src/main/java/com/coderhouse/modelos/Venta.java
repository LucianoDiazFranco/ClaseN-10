package com.coderhouse.modelos;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "venta")
public class Venta {

	@Id
	@Column(name = "ID_VENTA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_venta;
	@Column(name = "FECHA")
	private Integer fecha;
	@Column(name = "TIPO_DE_VENTA")
	private String Tipo_de_venta;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@OneToMany(mappedBy = "venta")
	private List<Producto> producto;
	
	public Venta() {
		
	}

	public Integer getId_venta() {
		return this.id_venta;
	}

	public void setId_venta(Integer id_venta) {
		this.id_venta = id_venta;
	}

	public Integer getFecha() {
		return this.fecha;
	}

	public void setFecha(Integer fecha) {
		this.fecha = fecha;
	}

	public String getTipo_de_venta() {
		return this.Tipo_de_venta;
	}

	public void setTipo_de_venta(String tipo_de_venta) {
		Tipo_de_venta = tipo_de_venta;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
