package com.trupertools.testjob.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trupertools.testjob.dto.ListaDetalleDTO;
import com.trupertools.testjob.dto.ProductoCantidadDTO;
import com.trupertools.testjob.entity.ListaCompraDetalle;
import com.trupertools.testjob.entity.ListaCompraDetalleId;
import com.trupertools.testjob.entity.ListaCompras;
import com.trupertools.testjob.repository.ListaComprasDetRepoJpa;
import com.trupertools.testjob.repository.ListaComprasRepoJpa;

@Service
public class ListaComprasService {
	
	public static final Integer ACTIVO = 1;
	public static final Integer INACTIVO = 0;
	
	@Autowired
	private ListaComprasRepoJpa lcRepo;
	
	@Autowired
	private ListaComprasDetRepoJpa lcdRepo;
	
	/**
	 * 
	 * @param compra
	 * @throws Exception 
	 */
	public void addCompras(ListaDetalleDTO compra) {
	
		ListaCompras lc = new ListaCompras();
		
		lc.setFechaRegistro(new Date(System.currentTimeMillis()));
		lc.setFechaUltimaActualizacion(new Date(System.currentTimeMillis()));
		lc.setIdCliente(compra.getIdCliente());
		lc.setNombreLista(compra.getNombreLista());
		lc.setActivo(ACTIVO);
		lc = lcRepo.saveAndFlush(lc);
		
		Integer newListaCompraId = lc.getIdListaCompra();
		
		for(ProductoCantidadDTO pcdto : compra.getProductoCantidad()) {
			ListaCompraDetalleId lcdId = new ListaCompraDetalleId();
			ListaCompraDetalle lcd = new ListaCompraDetalle();
		
			lcdId.setIdProducto(pcdto.getIdProducto());
			lcdId.setIdListaCompra(newListaCompraId);
			lcd.setCantidad(pcdto.getCantidad());
			lcd.setListaCompraDetalleId(lcdId);
		
			lcdRepo.save(lcd);
		
		}		
	}
	
	/**
	 * 
	 * @param compra
	 * @throws Exception 
	 */
	public void updateCompras(ListaDetalleDTO compra) throws Exception {
		
		System.out.println("0- "+compra.getIdCliente());
		
		try {
			List<ListaCompras> listaCompras = lcRepo.findByIdCliente(compra.getIdCliente());
			for(ListaCompras compraDelCliente : listaCompras) {
				
				compraDelCliente.setNombreLista(compra.getNombreLista());
				compraDelCliente.setFechaUltimaActualizacion(new Date(System.currentTimeMillis()));
				
				lcRepo.save(compraDelCliente);
				//-------------------
				for(ProductoCantidadDTO pcdto : compra.getProductoCantidad()) {
					ListaCompraDetalleId lcdId = new ListaCompraDetalleId();
					lcdId.setIdProducto(pcdto.getIdProducto());
					lcdId.setIdListaCompra(compraDelCliente.getIdListaCompra());
					
					ListaCompraDetalle lcdObj = new ListaCompraDetalle();
					lcdObj.setCantidad(pcdto.getCantidad());
					lcdObj.setListaCompraDetalleId(lcdId);
					
					lcdRepo.saveAndFlush(lcdObj);
				}
			}
		} catch(Exception ex) {
			throw new Exception ("Error generico al actualizar la(s) compra(s)");
		}
		
	}
	
	/**
	 * 
	 * @param idCompra
	 * @throws Exception
	 */
	public void deleteCompra(Integer idCompra) throws Exception{
		ListaCompras compra;
		Optional<ListaCompras> lcObj = lcRepo.findById(idCompra);
		
		if(lcObj.isPresent()) {
			compra = lcObj.get();
			if(compra.getActivo() == ACTIVO) {
				compra.setActivo(INACTIVO);
				
				lcRepo.save(compra);
			}
		} else {
			throw new Exception ("La compra no existe");
		}		
		
	}

}
