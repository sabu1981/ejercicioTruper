package com.trupertools.testjob.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "producto")
public class Producto {

	@Id
	private Integer idProducto;
	private String clave;
	private String descripcion;
	private Integer activo; 
}
