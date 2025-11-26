package com.lvnr.demo.micro.compraventa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lvnr.demo.micro.compraventa.entity.CompraVentaCocheEntity;
import java.util.List;


@Repository
public interface CompraVentaCocheRepository extends JpaRepository<CompraVentaCocheEntity, Integer> {

	CompraVentaCocheEntity findByCodigoFactura(String codigoFactura);
	
	boolean existsByCodigoFactura (String codigoFactura);
	
	void deleteByCodigoFactura (String codigoFactura);
	
}
