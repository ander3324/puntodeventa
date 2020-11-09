package com.analistas.puntodeventa.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Entity
@Table(name = "articulos")
public class Articulo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pk_id_art")
	private int id;

	@Column(name = "bar_cod", length = 13)
	private String codBarras;

	@Column(name = "descr", nullable = false, unique = true, length = 110)
	@NotBlank(message = "La descripción es requerida...")
	private String descripcion;

	@NotNull(message = "El Stock Actual es requerido")
	@Column(name = "cant")
	private int cantidad;

	@NotNull(message = "El Precio es requerido")
	@Digits(fraction = 2, integer = 10, message = "El Precio ingresado no es válido")
	@DecimalMin(value = "0.00", message = "El Precio ingresado no es válido")
	@NumberFormat(pattern="#.##", style = Style.CURRENCY)
	private Double precio;

	@Column(name = "link_img", nullable = true, length = 255)
	private String linkImagen;

	public Articulo() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getLinkImagen() {
		return linkImagen;
	}

	public void setLinkImagen(String linkImagen) {
		this.linkImagen = linkImagen;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return descripcion;
	}

}
