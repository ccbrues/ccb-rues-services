package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProponenteKardexDTO implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	
	private String numero_interno;
	private String usuario;
	private String codigo_camara_proponente;
	private String inscripcion_proponente;
	private String numero_registro;
	private ArrayList<ProponenteKardexInscripciones> inscripciones;
	
}
