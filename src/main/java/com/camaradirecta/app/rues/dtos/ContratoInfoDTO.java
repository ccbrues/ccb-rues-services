package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoInfoDTO implements Serializable{

	public String numero_interno;
    public String usuario;
    public int cod_indicador_envio;
    public String nit_proponente;
    public String dv_proponente;
    public String nit_entidad;
    public String dv_entidad;
    public String municipio_entidad;
    public String numero_contrato;
    public String nombre_entidad;
    public String nombre_proponente;
    public String seccional_entidad;
    public String numero_contrato_secop;
    public String fecha_adjudicacion;
    public String fecha_perfeccionamiento;
    public String fecha_inicio;
    public String fecha_ejecutado;
    public String fecha_terminacion_ejecucion;
    public String fecha_terminacion;
    public String fecha_liquidacion;
    public int valor_contrato;
    public int valor_pagado;
    public int cod_estado_contrato;
    public String objeto_contrato;
    public int cod_tipo_contratista;
    public String motivo_terminacion_anticipada;
    public int fecha_terminacion_anticipada;
    public String motivo_cesion;
    public String fecha_cesion;
    public int cod_actividad;
    public ArrayList<ContratoCiiuInfoDTO> actividad_ciiu;
    public ArrayList<ContratoUnspscInfoDTO> clasificacion_unspsc;
    public String observaciones;
    public String codigo_camara;
    public String codigo_libro_registro;
    public String numero_inscripcion_camara;
    public String numero_inscripcion_libro;
    public String fecha_inscripcion_camara;
    public String clasificasiones1464;
    public String numero_radicacion_rue;
    public String fecha_radicacion_rue;
    public String hora_radicacion_rue;
    public String codigo_error;
    public String mensaje_error;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
