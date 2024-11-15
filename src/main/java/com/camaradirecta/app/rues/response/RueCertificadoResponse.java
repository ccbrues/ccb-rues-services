package com.camaradirecta.app.rues.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.camaradirecta.rue.RR04N.TextoCertificado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RueCertificadoResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	public BigDecimal total_pagado;
	public String forma_pago;
	public String fecha_generado;
	public String hora_generado;
	public Integer caracteres_por_linea;
	public List<String>	texto_certificado;
	public String numero_unico_consulta;
	public String firma_mecanica;
	public String firma_digital;			
	public String codigo_error;
	public String mensaje_error;
	public String fecha_respuesta;
	public String hora_respuesta;

	
	List<String> getTexto_certificado() {
        if (texto_certificado == null) {
        	texto_certificado = new ArrayList<String>();
        }
        return this.texto_certificado;
    }
	
}
