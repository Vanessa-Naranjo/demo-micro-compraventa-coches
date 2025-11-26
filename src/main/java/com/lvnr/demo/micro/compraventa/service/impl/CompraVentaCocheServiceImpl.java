package com.lvnr.demo.micro.compraventa.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lvnr.demo.micro.compraventa.dto.CompraVentaCocheDto;
import com.lvnr.demo.micro.compraventa.dto.auto.AutoDto;
import com.lvnr.demo.micro.compraventa.dto.cliente.ClienteDto;
import com.lvnr.demo.micro.compraventa.dto.vendedores.VendedorDto;
import com.lvnr.demo.micro.compraventa.entity.CompraVentaCocheEntity;
import com.lvnr.demo.micro.compraventa.repository.CompraVentaCocheRepository;
import com.lvnr.demo.micro.compraventa.service.CompraVentaCocheService;
import com.lvnr.demo.micro.compraventa.service.cliente.ClienteServiceRest;

@Service
public class CompraVentaCocheServiceImpl implements CompraVentaCocheService {

	@Autowired
	private CompraVentaCocheRepository compraVentaCocheRepository;

	@Autowired
	private ClienteServiceRest clienteServiceRest;

	@Override
	public CompraVentaCocheDto crearCompraventa(CompraVentaCocheDto compraVentaCocheDto) {

		ClienteDto clienteDto = clienteServiceRest.consultarCliente(compraVentaCocheDto.getCodigoCliente());

		if (clienteDto == null) {
			throw new IllegalArgumentException("El cliente no existe" + compraVentaCocheDto.getCodigoCliente());
		}

		VendedorDto vendedorDto = clienteServiceRest.consultarVendedor(compraVentaCocheDto.getCodigoVendedor());

		if (vendedorDto == null) {
			throw new IllegalArgumentException("El vendedor no existe" + compraVentaCocheDto.getCodigoVendedor());
		}

		AutoDto autoDto = clienteServiceRest.consultarAuto(compraVentaCocheDto.getMatricula());

		if (autoDto == null) {
			throw new IllegalArgumentException("La matricula no existe" + compraVentaCocheDto.getMatricula());

		}

		CompraVentaCocheEntity compraVentaCocheEntity = new CompraVentaCocheEntity();
		compraVentaCocheEntity.setTipoTransaccion(compraVentaCocheDto.getTipoTransaccion());
		compraVentaCocheEntity.setFechaTransaccion(compraVentaCocheDto.getFechaTransaccion());
		compraVentaCocheEntity.setCodigoFactura(compraVentaCocheDto.getCodigoFactura());
		compraVentaCocheEntity.setCodigoCliente(compraVentaCocheDto.getCodigoCliente());
		compraVentaCocheEntity.setCodigoVendedor(compraVentaCocheDto.getCodigoVendedor());
		compraVentaCocheEntity.setMatricula(compraVentaCocheDto.getMatricula());
		compraVentaCocheRepository.save(compraVentaCocheEntity);

		return compraVentaCocheDto;
	}

	@Override
	public List<CompraVentaCocheDto> consultarCompraventas() {
		List<CompraVentaCocheDto> compraVentaCochesDto = new ArrayList<>();
		List<CompraVentaCocheEntity> compraVentaCochesEntity = this.compraVentaCocheRepository.findAll();

		for (CompraVentaCocheEntity compraVentaCocheEntity : compraVentaCochesEntity) {
			CompraVentaCocheDto compraVentaCocheDto = new CompraVentaCocheDto();
			compraVentaCocheDto.setCodigoFactura(compraVentaCocheEntity.getCodigoFactura());
			compraVentaCocheDto.setTipoTransaccion(compraVentaCocheEntity.getTipoTransaccion());
			compraVentaCocheDto.setFechaTransaccion(compraVentaCocheEntity.getFechaTransaccion());
			compraVentaCocheDto.setCodigoCliente(compraVentaCocheEntity.getCodigoCliente());
			compraVentaCocheDto.setCodigoVendedor(compraVentaCocheEntity.getCodigoVendedor());
			compraVentaCocheDto.setMatricula(compraVentaCocheEntity.getMatricula());

			compraVentaCochesDto.add(compraVentaCocheDto);
		}

		return compraVentaCochesDto;
	}

	@Override
	public CompraVentaCocheDto consultarCompraventaCodigoFactura(String codigoFactura) {
		CompraVentaCocheEntity compraVentaCocheEntity = this.compraVentaCocheRepository
				.findByCodigoFactura(codigoFactura);
		CompraVentaCocheDto compraVentaCocheDto = new CompraVentaCocheDto();
		compraVentaCocheDto.setCodigoFactura(compraVentaCocheEntity.getCodigoFactura());
		compraVentaCocheDto.setTipoTransaccion(compraVentaCocheEntity.getTipoTransaccion());
		compraVentaCocheDto.setFechaTransaccion(compraVentaCocheEntity.getFechaTransaccion());
		compraVentaCocheDto.setCodigoCliente(compraVentaCocheEntity.getCodigoCliente());
		compraVentaCocheDto.setCodigoVendedor(compraVentaCocheEntity.getCodigoVendedor());
		compraVentaCocheDto.setMatricula(compraVentaCocheEntity.getMatricula());

		return compraVentaCocheDto;
	}

	@Override
	public CompraVentaCocheDto actualizarCompraventa(CompraVentaCocheDto compraVentaCocheDto, String codigoFactura) {

		if (!compraVentaCocheRepository.existsByCodigoFactura(codigoFactura)) {
			throw new IllegalArgumentException("El codigo de factura ya existe: " + codigoFactura);
		}

		if (!codigoFactura.equals(compraVentaCocheDto.getCodigoFactura())) {
			if (this.compraVentaCocheRepository.existsByCodigoFactura(compraVentaCocheDto.getCodigoFactura())) {
				throw new IllegalArgumentException("El codigo de factura no existe: " + codigoFactura);
			}
		}

		CompraVentaCocheEntity compraVentaCocheEntity = this.compraVentaCocheRepository
				.findByCodigoFactura(codigoFactura);
		compraVentaCocheEntity.setTipoTransaccion(compraVentaCocheDto.getTipoTransaccion());
		compraVentaCocheEntity.setFechaTransaccion(compraVentaCocheDto.getFechaTransaccion());
		compraVentaCocheEntity.setCodigoFactura(compraVentaCocheDto.getCodigoFactura());
		compraVentaCocheEntity.setCodigoCliente(compraVentaCocheDto.getCodigoCliente());
		compraVentaCocheEntity.setCodigoVendedor(compraVentaCocheDto.getCodigoVendedor());
		compraVentaCocheEntity.setMatricula(compraVentaCocheDto.getMatricula());

		compraVentaCocheRepository.save(compraVentaCocheEntity);

		return compraVentaCocheDto;
	}

	@Override
	@Transactional
	public String eliminarCompraventa(String codigoFactura) {
		if (this.compraVentaCocheRepository.existsByCodigoFactura(codigoFactura)) {
			this.compraVentaCocheRepository.deleteByCodigoFactura(codigoFactura);
			return "La factura se ha eliminado" + codigoFactura;
		}
		return "La factura no existe: " + codigoFactura;
	}

}
