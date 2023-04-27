package com.trupertools.testjob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trupertools.testjob.entity.Producto;
import com.trupertools.testjob.repository.ProductoRepositoryJpa;

@RestController
@RequestMapping(path = "/producto")
public class ProductoController {

	@Autowired
	private ProductoRepositoryJpa productoRepo;
	
	@GetMapping(path = "/allProductos")
    public Iterable <Producto> getAllProductos() {
        return productoRepo.findAll();
    }
}
