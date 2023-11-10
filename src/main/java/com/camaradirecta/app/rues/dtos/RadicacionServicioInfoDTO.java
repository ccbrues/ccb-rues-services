package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RadicacionServicioInfoDTO implements Serializable{

	public String codigo_servicio;
    public String descripcion_servicio;
    public int orden_servicio;
    public int orden_servicio_asociado;
    public String nombre_base;
    public int valor_base;
    public int valor_liquidacion;
    public int cantidad_servicio;
    public String indicador_base;
    public String indicador_renovacion;
    public String matricula_servicio;
    public String nombre_matriculado;
    public String ano_renovacion;
    public int valor_activos_sin_ajustes;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
