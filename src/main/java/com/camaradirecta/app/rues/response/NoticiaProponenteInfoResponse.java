package com.camaradirecta.app.rues.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoticiaProponenteInfoResponse implements Serializable {
	
	public String numero_interno;
    public String usuario;
    public String camara_comercio_proponente;
    public String inscripcion_proponente;
    public String numero_identificacion;
    public String digito_verificacion;
    public String razon_social;
    public String codigo_libro;
    public String numero_inscripcion_libro;
    public String codigo_acto_rup;
    public String noticia;
    public String codigo_estado_noticia;
    public String fecha_inscripcion_camara;
    public String hora_inscripcion_camara;
    public String numero_publicacion_noticia;
    public String codigo_error;
    public String mensaje_error;
    public String fecha_respuesta;
    public String hora_respuesta;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
