package com.lvnr.demo.micro.compraventa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lvnr.demo.micro.compraventa.dto.CompraVentaCocheDto;
import com.lvnr.demo.micro.compraventa.service.CompraVentaCocheService;

@RestController
public class CompraVentaCocheController {

	@Autowired
	private CompraVentaCocheService compraVentaCocheService;

	@PostMapping
	public ResponseEntity<CompraVentaCocheDto> crearCompraventa(@RequestBody CompraVentaCocheDto compraVentaCocheDto) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(compraVentaCocheService.crearCompraventa(compraVentaCocheDto));

	}

	@GetMapping
	public ResponseEntity<List<CompraVentaCocheDto>> consultarCompraventas() {
		return ResponseEntity.ok(compraVentaCocheService.consultarCompraventas());
	}

	@GetMapping("/consultarporcodigofactura/{codigoFactura}")
	public ResponseEntity<CompraVentaCocheDto> consultarCompraventaCodigoFactura(@PathVariable String codigoFactura) {
		return ResponseEntity.ok(compraVentaCocheService.consultarCompraventaCodigoFactura(codigoFactura));
	}

	@PutMapping("/{codigoFactura}")
	public ResponseEntity<CompraVentaCocheDto> actualizarCompraventa(
			@RequestBody CompraVentaCocheDto compraVentaCocheDto, @PathVariable String codigoFactura) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(compraVentaCocheService.actualizarCompraventa(compraVentaCocheDto, codigoFactura));
	}

	@DeleteMapping("/{codigoFactura}")
	public ResponseEntity<String> eliminarCompraventa(@PathVariable String codigoFactura) {
		return ResponseEntity.status(HttpStatus.NO_CONTENT)
				.body(compraVentaCocheService.eliminarCompraventa(codigoFactura));
	}
}