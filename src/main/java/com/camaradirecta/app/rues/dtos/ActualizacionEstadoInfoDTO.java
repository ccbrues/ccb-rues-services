package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActualizacionEstadoInfoDTO implements Serializable{

	public String numero_interno;
    public String usuario;
    public String estado_transaccion;
    public String anexos;
    public String estado;
    public String fecha_respuesta;
    public String hora_respuesta;
    public String codigo_error;
    public String mensaje_error;
    public String firma_digital;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
