package com.trupertools.testjob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trupertools.testjob.entity.ListaCompras;

public interface ListaComprasRepoJpa extends JpaRepository<ListaCompras, Integer>{
	
	List<ListaCompras> findByIdCliente(Integer idCliente);

}
