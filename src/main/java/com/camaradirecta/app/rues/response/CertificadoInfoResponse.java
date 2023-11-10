package com.camaradirecta.app.rues.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificadoInfoResponse implements Serializable{

	public CertificadoBasicResponse respuesta;
    public String codigo_error;
    public String mensaje_error;
    public String fecha_respuesta;
    public String hora_respuesta;
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
