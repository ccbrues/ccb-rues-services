package com.camaradirecta.app.rues.response;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProponenteNitInfoResponse implements Serializable{

	public String numero_interno;
    public String usuario;
    public int cantidad_registros_out;
    public String numero_identificacion_consulta;
    public String digito_verificacion_consulta;
    public ArrayList<ProponenteNitBasicResponse> datos_respuesta;
    public String codigo_error;
    public String mensaje_error;
    public String fecha_respuesta;
    public String hora_respuesta;
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
