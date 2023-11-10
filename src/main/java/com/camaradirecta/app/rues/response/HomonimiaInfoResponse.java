package com.camaradirecta.app.rues.response;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomonimiaInfoResponse implements Serializable{

	public String numero_interno;
    public String usuario;
    public String razon_social;
    public ArrayList<HomonimiaBasicResponse> datos_respuesta;
    public String codigo_error;
    public String mensaje_error;
    public String fecha_respuesta;
    public String hora_respuesta;
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
