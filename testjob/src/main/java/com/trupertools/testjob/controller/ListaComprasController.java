package com.trupertools.testjob.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trupertools.testjob.dto.ListaDetalleDTO;
import com.trupertools.testjob.dto.ProductoCantidadDTO;
import com.trupertools.testjob.entity.ListaCompras;
import com.trupertools.testjob.repository.ListaComprasRepoJpa;
import com.trupertools.testjob.service.ListaComprasService;

@RestController
@RequestMapping(path = "/listaCompras")
public class ListaComprasController {
	
	@Autowired
	private ListaComprasRepoJpa lcRepo;
	
	@Autowired
	private ListaComprasService lcService;
	
	

	@GetMapping(path = "/allCompras")
    public Iterable <ListaCompras> getAllCompras() {
        return lcRepo.findAll();
    }
	
	@GetMapping(path = "/allComprasById")
    public List<ListaCompras> getAllCompras(@RequestParam(name = "idCliente") Integer idCliente) {
		
		List<ListaCompras> listaCompras = lcRepo.findByIdCliente(idCliente); 
		
        return listaCompras;
    }
	
	
	@PostMapping("/addNuevaCompra")
	public void createNuevaCompra(@RequestBody ListaDetalleDTO compra) {
		
		lcService.addCompras(compra);
		
		System.out.println("Se han metido los nuevos registros");
		
    }
	
	@PutMapping("/updateCompra")
	public void updateCompra(@RequestBody ListaDetalleDTO compra) {
		try {
			lcService.updateCompras(compra);
		
			System.out.println("Se han actualizado los registros");
		} catch(Exception ex) {
			System.out.println("Ha ocurrido un error (update): "+ex.getMessage());
		}
    }
	
	@DeleteMapping("/deleteCompra")
	public void deleteCompra(@RequestParam(name = "id") Integer id) {
		try {
			
			lcService.deleteCompra(id);
			
		} catch (Exception ex) {
			System.out.println("Ha ocurrido un error (delete): "+ex.getMessage());
		}
	}
	
	
}
