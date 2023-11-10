package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IdentificacionInfoDTO implements Serializable{

	private String numero_interno;
	private String usuario;
	private String codigo_clase_identificacion;
	private String numero_identificacion;
	private String digito_verificacion;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
