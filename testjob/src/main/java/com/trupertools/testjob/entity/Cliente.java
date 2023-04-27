package com.trupertools.testjob.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {
	
	@Id
	private Integer idCliente;
	private String nombre;
	private String email;
	private Integer activo;
	private String password; 
}
