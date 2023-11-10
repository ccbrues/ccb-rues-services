package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NombreInfoDTO implements Serializable{
	
	public String numero_interno;
    public String usuario;
    public String razon_social;
    
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
}
