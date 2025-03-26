package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProponenteSancionesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String numero_interno;
	private String usuario;
	private String codigo_camara_proponente;
	private String inscripcion_proponente;
	private String numero_registro;
	private String nit_proponente;
	private String digito_verificacion_proponente;
	private String nit_entidad;
	private String digito_verificacion_entidad;
	private String numero_acto_administrativo;
	private String control_reporte_al_rues;
	private String nombre_entidad;
	private String muncipio_entidad;
	private String division_area;
	private String identificacion_responsable;
	private String nombre_reponsable;
	private String cargo_responsable;
	private String fecha_reporte;
	private String fecha_radicacion;
	private String fecha_ejecutoria_acto_administrativo;
	private String numero_contrato;
	private String numero_contrato_secop;
	private String numero_acto_suspension;
	private String fecha_acto_suspension;
	private String numero_acto_confirmacion;
	private String fecha_acto_confirmacion;
}
