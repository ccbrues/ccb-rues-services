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

	private String numero_interno;
    private String usuario;
    private int cod_indicador_envio;
    private String nit_proponente;
    private String dv_proponente;
    private String nit_entidad;
    private String dv_entidad;
    private String municipio_entidad;
    private String numero_contrato;
    private String nombre_entidad;
    private String nombre_proponente;
    private String seccional_entidad;
    private String numero_contrato_secop;
    private String fecha_adjudicacion;
    private String fecha_perfeccionamiento;
    private String fecha_inicio;
    private String fecha_ejecutado;
    private String fecha_terminacion_ejecucion;
    private String fecha_terminacion;
    private String fecha_liquidacion;
    private int valor_contrato;
    private int valor_pagado;
    private int cod_estado_contrato;
    private String objeto_contrato;
    private int cod_tipo_contratista;
    private String motivo_terminacion_anticipada;
    private int fecha_terminacion_anticipada;
    private String motivo_cesion;
    private String fecha_cesion;
    private int cod_actividad;
    private ArrayList<ContratoCiiuInfoDTO> actividad_ciiu;
    private ArrayList<ContratoUnspscInfoDTO> clasificacion_unspsc;
    private String observaciones;
    private String codigo_camara;
    private String codigo_libro_registro;
    private String numero_inscripcion_camara;
    private String numero_inscripcion_libro;
    private String fecha_inscripcion_camara;
    private String clasificasiones1464;
    private String numero_radicacion_rue;
    private String fecha_radicacion_rue;
    private String hora_radicacion_rue;
    private String codigo_error;
    private String mensaje_error;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
