package com.trupertools.testjob.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trupertools.testjob.entity.ListaCompraDetalle;
import com.trupertools.testjob.entity.ListaCompraDetalleId;

public interface ListaComprasDetRepoJpa extends JpaRepository<ListaCompraDetalle, ListaCompraDetalleId> {

}
