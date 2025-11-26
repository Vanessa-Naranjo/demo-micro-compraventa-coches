package com.lvnr.demo.micro.compraventa.service.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lvnr.demo.micro.compraventa.dto.auto.AutoDto;
import com.lvnr.demo.micro.compraventa.dto.cliente.ClienteDto;
import com.lvnr.demo.micro.compraventa.dto.vendedores.VendedorDto;

@Service
public class ClienteServiceRest {

	@Autowired
	private RestTemplate restTemplate;

	public ClienteDto consultarCliente(String codigoCliente) {
		try {
			ClienteDto respuestacliente = restTemplate
					.getForObject("http://localhost:8082/consultarClienteCodigo/" + codigoCliente, ClienteDto.class);

			return respuestacliente;

		} catch (Exception e) {
			return null;
		}
	}

	public VendedorDto consultarVendedor(String codigoVendedor) {
		try {
			VendedorDto respuestaVendedor = restTemplate.getForObject(
					"http://localhost:8083/consultarVendedorPorCodigo/" + codigoVendedor, VendedorDto.class);

			return respuestaVendedor;
		} catch (Exception e) {
			return null;
		}
	}

	public AutoDto consultarAuto(String matricula) {
		try {
			AutoDto respuestaAuto = restTemplate
					.getForObject("http://localhost:8081/consultarpormatricula/" + matricula, AutoDto.class);

			return respuestaAuto;
		} catch (Exception e) {
			return null;
		}
	}

}
