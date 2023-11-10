package com.camaradirecta.app.rues.response;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NombreBasicResponse implements Serializable{

	public String numero_interno;
    public String usuario;
    public String razon_social;
    public ArrayList<NombreDetailResponse> datos_respuesta;
    public String codigo_error;
    public String mensaje_error;
    
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

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public ArrayList<NombreDetailResponse> getDatos_respuesta() {
		return datos_respuesta;
	}

	public void setDatos_respuesta(ArrayList<NombreDetailResponse> datos_respuesta) {
		this.datos_respuesta = datos_respuesta;
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
	
}
