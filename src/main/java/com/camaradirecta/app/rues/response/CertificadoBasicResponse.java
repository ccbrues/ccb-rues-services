package com.camaradirecta.app.rues.response;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificadoBasicResponse implements Serializable{

	public String fecha_respuesta;
    public String hora_respuesta;
    public String numero_interno;
    public String usuario;
    public String camara_receptora;
    public String camara_responsable;
    public String desc_camara;
    public String codigo_servicio;
    public String clase_identificacion;
    public String numero_identificacion;
    public String digito_verificacion;
    public String fecha_pago;
    public String numero_factura;
    public String referencia_operacion;
    public double total_pagado;
    public String forma_pago;
    public String fecha_generado;
    public String hora_generado;
    public int caracteres_por_linea;
    public ArrayList<String> texto_certificado;
    public String firma_mecanica;
    public String codigo_error;
    public String mensaje_error;
    public String firma_digital;
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
