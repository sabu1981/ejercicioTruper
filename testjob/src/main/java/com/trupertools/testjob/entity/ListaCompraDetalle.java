package com.trupertools.testjob.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "lista_compra_detalle")
public class ListaCompraDetalle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ListaCompraDetalleId listaCompraDetalleId;
	
	private Integer cantidad;
}
