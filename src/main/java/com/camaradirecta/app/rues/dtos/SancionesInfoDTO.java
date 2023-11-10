package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SancionesInfoDTO implements Serializable {

	public String numero_interno;
	public String usuario;
	public String cod_indicador_envio;
	public String nit_proponente;
	public String dv_proponente;
	public String nit_entidad;
	public String dv_entidad;
	public String municipio_entidad;
	public String numero_contrato;
	public String nombre_entidad;
	public String nombre_proponente;
	public String seccional_entidad;
	public String numero_acto_administrativo;
	public String fecha_acto_administrativo;
	public String numero_acto_ejecutoria;
	public String fecha_ejecutoria;
	public String descripcion_sancion;
	public String vigencia_sancion;
	public String fundamento_legal;
	public String condicion_incumplimiento;
	public String cod_estado;
	public String codigo_camara;
	public String codigo_libro_registro;
	public String numero_inscripcion_libro;
	public String fecha_inscripcion_camara;
	public String numero_contrato_secop;
	public int numero_radicacion_rue;
	public String codigo_error;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
