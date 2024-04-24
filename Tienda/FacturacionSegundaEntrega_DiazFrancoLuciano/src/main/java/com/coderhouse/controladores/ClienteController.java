package com.coderhouse.controladores;

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
import com.coderhouse.modelos.Cliente;
import com.coderhouse.servicios.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Cliente>> listarCliente() {
		try {
			List<Cliente> cliente = clienteService.listarCliente();
			return new ResponseEntity<>(cliente, HttpStatus.OK); // Codigo 200

		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500
		}

	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cliente> mostrarClientePorDNI(@PathVariable("id") Integer dni) {
		try {
			Cliente cliente = clienteService.mostrarAlumnoPorDNI(dni);
			if (cliente != null) {
				return new ResponseEntity<>(cliente, HttpStatus.OK); // Codigo 200
			} else {
				return new ResponseEntity<>(cliente, HttpStatus.NOT_FOUND); // Codigo 404
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Error 500

		}
	}
	
	@PostMapping(value = "/agregar", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente) {
		clienteService.agregarCliente(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED); // Codigo 201
	}
	
	@PutMapping(value = "/{id}/editar", consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Cliente> ediarCliente (@PathVariable("id") Integer dni, @RequestBody Cliente cliente){
		Cliente clienteEditado = clienteService.editarClientePorDNI(dni,cliente);
		if (clienteEditado != null) {
			return new ResponseEntity<>(clienteEditado, HttpStatus.OK); // Codigo 200
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Error 404
		}
	}
	
	@DeleteMapping(value = "/{id}/eliminar")
	public ResponseEntity<Void> eliminarCLiente(@PathVariable("id") Integer dni) {
		boolean eliminado = clienteService.eliminarClientePorDNI(dni);
		if (eliminado){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Codigo 204
		} else{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Error 404
		}

	}
	
}
