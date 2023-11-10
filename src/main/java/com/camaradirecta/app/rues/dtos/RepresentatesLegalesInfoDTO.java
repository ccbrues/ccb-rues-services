package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepresentatesLegalesInfoDTO implements Serializable{

	public String codigo_clase_identificacion;
    public String numero_identificacion;
    @JsonProperty("Razon_social") 
    public String razon_social;
    public String primer_nombre;
    public Object segundo_nombre;
    public String primer_apellido;
    public String segundo_apellido;
    public String descripcion_cargo;
    public String tipo_representacion;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
