package com.lvnr.demo.micro.compraventa.service;

import java.util.List;

import com.lvnr.demo.micro.compraventa.dto.CompraVentaCocheDto;

public interface CompraVentaCocheService {

	public CompraVentaCocheDto crearCompraventa(CompraVentaCocheDto compraVentaCocheDto);

	public List<CompraVentaCocheDto> consultarCompraventas();

	public CompraVentaCocheDto consultarCompraventaCodigoFactura(String codigoFactura);

	public CompraVentaCocheDto actualizarCompraventa(CompraVentaCocheDto compraVentaCocheDto, String codigoFactura);

	public String eliminarCompraventa(String codigoFactura);

}