package com.camaradirecta.app.rues.response;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentificacionBasicResponse implements Serializable{
	
	public String numero_interno;
    public String usuario;
    public String codigo_clase_identificacion;
    public String numero_identificacion;
    public String digito_verificacion;
    public ArrayList<IdentificacionDetailResponse> datos_respuesta;
    public String firma_digital;
    public String codigo_error;
    public String mensaje_error;
    public String fecha_respuesta;
    public String hora_respuesta;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getNumero_interno() {
		return numero_interno;
	}

	public void setNumero_interno(String numero_interno) {
		this.numero_interno = numero_interno;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getCodigo_clase_identificacion() {
		return codigo_clase_identificacion;
	}

	public void setCodigo_clase_identificacion(String codigo_clase_identificacion) {
		this.codigo_clase_identificacion = codigo_clase_identificacion;
	}

	public String getNumero_identificacion() {
		return numero_identificacion;
	}

	public void setNumero_identificacion(String numero_identificacion) {
		this.numero_identificacion = numero_identificacion;
	}

	public String getDigito_verificacion() {
		return digito_verificacion;
	}

	public void setDigito_verificacion(String digito_verificacion) {
		this.digito_verificacion = digito_verificacion;
	}

	public ArrayList<IdentificacionDetailResponse> getDatos_respuesta() {
		return datos_respuesta;
	}

	public void setDatos_respuesta(ArrayList<IdentificacionDetailResponse> datos_respuesta) {
		this.datos_respuesta = datos_respuesta;
	}

	public String getFirma_digital() {
		return firma_digital;
	}

	public void setFirma_digital(String firma_digital) {
		this.firma_digital = firma_digital;
	}

	public String getCodigo_error() {
		return codigo_error;
	}

	public void setCodigo_error(String codigo_error) {
		this.codigo_error = codigo_error;
	}

	public String getMensaje_error() {
		return mensaje_error;
	}

	public void setMensaje_error(String mensaje_error) {
		this.mensaje_error = mensaje_error;
	}

	public String getFecha_respuesta() {
		return fecha_respuesta;
	}

	public void setFecha_respuesta(String fecha_respuesta) {
		this.fecha_respuesta = fecha_respuesta;
	}

	public String getHora_respuesta() {
		return hora_respuesta;
	}

	public void setHora_respuesta(String hora_respuesta) {
		this.hora_respuesta = hora_respuesta;
	}

	
}
