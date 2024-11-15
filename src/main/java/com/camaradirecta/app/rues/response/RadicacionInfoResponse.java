package com.camaradirecta.app.rues.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RadicacionInfoResponse implements Serializable{

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
    public String referencia_operacion;
    public String numero_factura;
    public BigDecimal total_pagado;
    public String forma_pago;
    public String numero_unico_consulta;    
    public String estado;    
    public Integer empleados;
    public Integer indicador_beneficio;
    public ArrayList<LiquidacionDetalleResponse> servicios;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
