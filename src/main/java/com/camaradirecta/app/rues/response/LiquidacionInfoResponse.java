package com.camaradirecta.app.rues.response;

import java.io.Serializable;
import java.util.ArrayList;

import com.camaradirecta.app.rues.dtos.FirmaDigitalDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiquidacionInfoResponse implements Serializable{

	public String numero_interno;
    public String usuario;
    public String camara_receptora;
    public String camara_destino;
    public String matricula;
    public String inscripcion;
    public String origen_documento;
    public String fecha_documento;
    public String indicador_origen;
    public String estado;
    public ArrayList<LiquidacionDetalleResponse> servicios;
    public int empleados;
    public int indicador_beneficio;
    public FirmaDigitalResponse firma_digital;
    public String codigo_error;
    public String mensaje_error;
    public String fecha_respuesta;
    public String hora_respuesta;
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
