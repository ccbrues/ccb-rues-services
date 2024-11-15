package com.camaradirecta.app.rues.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class RadicacionRueResponse implements Serializable{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RadicacionInfoResponse respuesta;
    public String codigo_error;
    public String mensaje_error;
    public String fecha_respuesta;
    public String hora_respuesta;
	
}
