package tienda.modelos;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Schema(description = "Modelo de Producto")
@Entity
@Table(name = "producto")
public class Producto {
	@Schema(description = "Id del Producto", requiredMode = Schema.RequiredMode.REQUIRED, example ="8")
	@Id
	@Column(name = "ID_PRODUCTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_producto;
	@Schema(description = "Tipo de Producto", requiredMode = Schema.RequiredMode.REQUIRED, example ="Remera")
	@Column(name = "TIPO")
	private String tipo;
	@Schema(description = "Rama que pertenece el Producto", requiredMode = Schema.RequiredMode.REQUIRED, example ="Unidad")
	@Column(name = "RAMA")
	private String rama;
	@Schema(description = "Descripccion del Producto", requiredMode = Schema.RequiredMode.REQUIRED, example ="Manga larga color Gris")
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@Schema(description = "Valor del Producto", requiredMode = Schema.RequiredMode.REQUIRED, example ="6400")
	@Column(name = "VALOR")
	private Integer valor;
	
	@Schema(description = "Lista de Productos de los Clientes")
	@OneToMany(mappedBy = "producto")
	private List<Cliente> cliente;
	
	@Schema(description = "Id de la Venta")
	@ManyToOne
	@JoinColumn(name = "Id_VENTA")
	private Venta venta;
	
	public Venta getVenta() {
		return this.venta;
	}
	public void setVenta(Venta venta) {
		this.venta =venta;
	}
	
	public Producto(){
		//Constructor
	}

	public Integer getId_producto() {
		return this.id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getRama() {
		return this.rama;
	}

	public void setRama(String rama) {
		this.rama = rama;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Integer getValor() {
		return this.valor;
	}
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	

	public List<Cliente> getCliente() {
		return cliente;
	}
	public void setCliente(List<Cliente> cliente) {
		this.cliente = cliente;
	}
	
	
	
	
	
}
