package com.trupertools.testjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trupertools.testjob.entity.Producto;

public interface ProductoRepositoryJpa extends JpaRepository<Producto, Integer>{

}
