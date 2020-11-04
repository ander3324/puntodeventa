package com.analistas.puntodeventa.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ventas")
public class Venta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "La fecha de venta es requerida")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm z")
	@Column(name = "fec_hor")
	private LocalDateTime fechaHora;

	@NotEmpty
	@Column(name = "descrip")
	private String descripcion;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fk_id_ven")
	// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private List<LineaVenta> lineas;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_id_usu")
	// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Usuario usuario;

	public Venta() {
		lineas = new ArrayList<>();
		descripcion = "Ninguna";
		fechaHora = LocalDateTime.now();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<LineaVenta> getLineas() {
		return lineas;
	}

	public void setLineas(List<LineaVenta> lineas) {
		this.lineas = lineas;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void addLinea(LineaVenta linea) {
		lineas.add(linea);
	}

	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		int size = lineas.size();

		for (int i = 0; i < size; i++) {
			total = total.add(BigDecimal.valueOf(lineas.get(i).calcularSubtotal()));
		}
		return total;
	}

}
