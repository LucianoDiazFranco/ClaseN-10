package tienda.modelos;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Schema(description = "Modelo de Venta")
@Entity
@Table(name = "venta")
public class Venta {
	@Schema(description = "Id de Venta", requiredMode = Schema.RequiredMode.REQUIRED, example ="7")
	@Id
	@Column(name = "ID_VENTA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_venta;
	@Schema(description = "Fecha de la Venta", requiredMode = Schema.RequiredMode.REQUIRED, example ="22-2-2004")
	@Column(name = "FECHA")
	private Integer fecha;
	@Schema(description = "Tipo de Venta", requiredMode = Schema.RequiredMode.REQUIRED, example ="Efectivo")
	@Column(name = "TIPO_DE_VENTA")
	private String Tipo_de_venta;
	@Schema(description = "Descripccion de la Venta", requiredMode = Schema.RequiredMode.REQUIRED, example ="Venta Confirmada")
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Schema(description = "Lista de Ventas de los Productos")
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
