package tienda.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tienda.modelos.Venta;
import tienda.servicios.VentaService;

@RestController
@RequestMapping("/ventas") // cuando accedamos a cliente nos llevara al controladorProducto
public class VentaController {

	@Autowired // nos permite utilizar todos los metodos del repositorio
	private VentaService ventaService;
	
	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Venta>> listarVenta() {
		try {
			List<Venta> venta = ventaService.listarVenta();
			return new ResponseEntity<>(venta, HttpStatus.OK); // Codigo 200

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}
	}
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Venta> mostrarVentaPorId(@PathVariable("id") Integer id) {
		try {
			Venta venta = ventaService.mostrarVentaPorId(id);
			if (venta != null) {
				return new ResponseEntity<>(venta, HttpStatus.OK); // Codigo 200
			} else {
				return new ResponseEntity<>(venta, HttpStatus.NOT_FOUND); // Codigo 404
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}
	}
	
	@PostMapping(value = "/agregar", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Venta> agregarVenta(@RequestBody Venta nuevaventa) {
		Venta ventaGuardada = ventaService.agregarVenta(nuevaventa);
		return new ResponseEntity<>(ventaGuardada, HttpStatus.CREATED); // Codigo 201
	}
	
	@PutMapping(value = "/{id}/editar", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Venta> ediarVenta (@PathVariable("id") Integer id, @RequestBody Venta venta){
		Venta ventaEditada = ventaService.editarVentaPorId(id, venta);
		if (ventaEditada != null) {
			return new ResponseEntity<>(ventaEditada, HttpStatus.OK); // Codigo 200
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Error 404
		}
	}
	
	@DeleteMapping(value = "/{id}/eliminar")
	public ResponseEntity<Void> eliminarVenta(@PathVariable("id") Integer id) {
		boolean eliminado = ventaService.eliminarVentaPorDNI(id);
		if (eliminado){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Codigo 204
		} else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Error 404
		}

	}
	
}
