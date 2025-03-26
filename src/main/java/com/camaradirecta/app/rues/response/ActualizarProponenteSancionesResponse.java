package com.camaradirecta.app.rues.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizarProponenteSancionesResponse implements Serializable{
	

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	
	private String numero_interno;
    private String usuario;
    private String codigo_camara_proponente;
    private String inscripcion_proponente;
    private String codigo_error;
    private String mensaje_error;
    private String fecha_respuesta;
    private String hora_respuesta;

}
