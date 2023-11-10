package com.camaradirecta.app.rues.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RadicarProponenteInfoResponse implements Serializable{

	public String numero_interno;
    public String codigo_error;
    public String mensaje_error;
    public String hora_respuesta;
    public String fecha_respuesta;
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
