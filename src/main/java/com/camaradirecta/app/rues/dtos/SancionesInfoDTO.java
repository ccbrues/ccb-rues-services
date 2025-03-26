package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SancionesInfoDTO implements Serializable {

	private String numero_interno;
	private String usuario;
	private String cod_indicador_envio;
	private String nit_proponente;
	private String dv_proponente;
	private String nit_entidad;
	private String dv_entidad;
	private String municipio_entidad;
	private String numero_contrato;
	private String nombre_entidad;
	private String nombre_proponente;
	private String seccional_entidad;
	private String numero_acto_administrativo;
	private String fecha_acto_administrativo;
	private String numero_acto_ejecutoria;
	private String fecha_ejecutoria;
	private String descripcion_sancion;
	private String vigencia_sancion;
	private String fundamento_legal;
	private String condicion_incumplimiento;
	private String cod_estado;
	private String codigo_camara;
	private String codigo_libro_registro;
	private String numero_inscripcion_libro;
	private String fecha_inscripcion_camara;
	private String numero_contrato_secop;
	private int numero_radicacion_rue;
	private String codigo_error;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
