package com.camaradirecta.app.rues.response;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoInfoResponse {
	
	public String numero_interno;
    public String usuario;
    public Integer cod_indicador_envio;
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
    public Integer valor_contrato;
    public Integer valor_pagado;
    public String cod_estado_contrato;
    public String objeto_contrato;
    public String cod_tipo_contratista;
    public String motivo_terminacion_anticipada;
    public String fecha_terminacion_anticipada;
    public String motivo_cesion;
    public String fecha_cesion;
    public Integer cod_actividad;
    public ArrayList<ContratoCiiuInfoResponse> actividad_ciiu;
    public ArrayList<ContratoUnspscInfoResponse> clasificacion_unspsc;
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
    public String fecha_respuesta;
    public String hora_respuesta;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ContratoCiiuInfoResponse {
    	public String codigo_ciiu;
    }
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ContratoUnspscInfoResponse {
    	public String codigo_unspsc;
    }

}

