package com.camaradirecta.app.rues.response;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiquidacionDetalleResponse implements Serializable{

	public String codigo_servicio;
	public String descripcion_servicio;
	public String orden_servicio;
	public String orden_servicio_asociado;
	public String nombre_base;
	public Integer valor_base;
	public Integer valor_liquidacion;
	public Integer cantidad_servicio;
	public String indicador_base;
	public String indicador_renovacion;
	public String matricula_servicio;
	public String nombre_matriculado;
	public String ano_renovacion;
	public Integer valor_activos_sin_ajustes;
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
