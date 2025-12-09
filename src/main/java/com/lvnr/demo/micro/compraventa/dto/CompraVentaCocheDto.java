package com.lvnr.demo.micro.compraventa.dto;

import java.time.LocalDate;

import com.lvnr.demo.micro.compraventa.dto.auto.AutoDto;
import com.lvnr.demo.micro.compraventa.dto.cliente.ClienteDto;
import com.lvnr.demo.micro.compraventa.dto.vendedores.VendedorDto;

public class CompraVentaCocheDto {

	private String codigoFactura;
	private String codigoVendedor;
	private String codigoCliente;
	private String matricula;
	private String tipoTransaccion;
	private LocalDate fechaTransaccion;
	private AutoDto autoDto;
	private ClienteDto clienteDto;
	private VendedorDto vendedorDto;

	public String getCodigoFactura() {
		return codigoFactura;
	}

	public void setCodigoFactura(String codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	public String getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(String codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public LocalDate getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDate fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public AutoDto getAutoDto() {
		return autoDto;
	}

	public void setAutoDto(AutoDto autoDto) {
		this.autoDto = autoDto;
	}

	public ClienteDto getClienteDto() {
		return clienteDto;
	}

	public void setClienteDto(ClienteDto clienteDto) {
		this.clienteDto = clienteDto;
	}

	public VendedorDto getVendedorDto() {
		return vendedorDto;
	}

	public void setVendedorDto(VendedorDto vendedorDto) {
		this.vendedorDto = vendedorDto;
	}

}
