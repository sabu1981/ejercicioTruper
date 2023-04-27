package com.trupertools.testjob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trupertools.testjob.entity.Cliente;
import com.trupertools.testjob.repository.ClienteRepositoryJpa;


@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepositoryJpa clienteRepo;
	
	@GetMapping(path = "/allClientes")
    public Iterable <Cliente> getAllClientes() {
        return clienteRepo.findAll();
    }
}
