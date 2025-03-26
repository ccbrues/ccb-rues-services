package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MultaInfoDTO implements Serializable{

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
    private String numero_acto_administrativo;
    private String fecha_acto_administrativo;
    private String numero_acto_ejecutoria;
    private String fecha_ejecutoria;
    private int valor_multa;
    private int valor_pagado_multa;
    private String cod_estado;
    private String numero_acto_suspension;
    private String fecha_acto_suspension;
    private String numero_acto_confirmacion;
    private String fecha_acto_confirmacion;
    private String numero_acto_revocacion;
    private String fecha_acto_revocacion;
    private String observaciones;
    private String codigo_camara;
    private String codigo_libro_registro;
    private String numero_inscripcion_libro;
    private String fecha_inscripcion_camara;
    private String fecha_registro_inicial_rue;
    private String numero_contrato_secop;
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
