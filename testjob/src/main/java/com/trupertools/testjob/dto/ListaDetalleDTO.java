package com.trupertools.testjob.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ListaDetalleDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idCliente;
	private String nombreLista;
	private List<ProductoCantidadDTO> productoCantidad;
	
	
}
