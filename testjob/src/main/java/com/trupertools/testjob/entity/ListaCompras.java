package com.trupertools.testjob.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "lista_compra")
public class ListaCompras {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@SequenceGenerator(name = "LISTA_COMPRAS_SEQ", sequenceName = "LISTA_COMPRAS_SEQ", initialValue = 4)
	private Integer idListaCompra;
	//@OneToOne
	//@JoinColumn(name="idCliente")
	private Integer idCliente;
	private String nombreLista;
	private Date fechaRegistro;
	private Date fechaUltimaActualizacion;
	private Integer activo;

}
