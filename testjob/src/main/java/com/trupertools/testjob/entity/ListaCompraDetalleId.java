package com.trupertools.testjob.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Id;

import lombok.Data;

@Data
@Embeddable
public class ListaCompraDetalleId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idListaCompra;
	
	private Integer idProducto;
}