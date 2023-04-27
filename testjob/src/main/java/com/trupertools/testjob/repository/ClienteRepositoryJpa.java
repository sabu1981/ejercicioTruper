package com.trupertools.testjob.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trupertools.testjob.entity.Cliente;

public interface ClienteRepositoryJpa extends JpaRepository<Cliente, Integer> {

	Optional<Cliente> findOneByEmail(String email);
}
