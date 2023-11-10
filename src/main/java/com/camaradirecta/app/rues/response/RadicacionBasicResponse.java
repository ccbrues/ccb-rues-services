package com.camaradirecta.app.rues.response;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RadicacionBasicResponse implements Serializable{

	public String numero_interno;
    public String usuario;
    public String codigo_servicio_radicar;
    public String camara_receptora;
    public String camara_destino;
    public String matricula;
    public String inscripcion;
    public String nombre_registrado;
    public String clase_identificacion;
    public String numero_identificacion;
    public String digito_verificacion;
    public String estado_transaccion;
    public String nombre_pagador;
    public String origen_documento;
    public String fecha_documento;
    public String fecha_pago;
    public String numero_factura;
    public String referencia_operacion;
    public double total_pagado;
    public String forma_pago;
    public ArrayList<RadicacionDetailResponse> servicios;
    public String numero_unico_consulta;
    public String estado;
    public int empleados;
    public int indicador_beneficio;
    public String firma_digital;
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
