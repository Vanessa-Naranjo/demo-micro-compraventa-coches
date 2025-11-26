package com.lvnr.demo.micro.compraventa.dto.vendedores;

public class VendedorDto {

	
	private String nombres;
	private String primerApellido;
	private String segundoApellido;
	private Integer codigoVendedor;


	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public Integer getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(Integer codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

}
