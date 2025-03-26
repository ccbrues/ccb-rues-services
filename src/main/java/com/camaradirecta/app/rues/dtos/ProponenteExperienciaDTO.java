package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProponenteExperienciaDTO implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private String numero_interno;
	private String usuario;
	private String control_reporte_al_rues;
	private String codigo_camara_proponente;
	private String inscripcion_proponente;
	private ArrayList<ProponenteExperienciaContratoDTO> experiencia;
	
}
