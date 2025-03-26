package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProponenteKardexInscripciones implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private String control_reporte_al_rues;
	private String numero_registro;
	private String fecha_registro;
	private String acto;
	private String noticia;
	private String fecha_publicacion_rues;
	private String numero_publicacion_rues;
	private String control_revocacion;
	private String numero_registro_revocacion;
	private String fecha_registro_revocacion;

}
