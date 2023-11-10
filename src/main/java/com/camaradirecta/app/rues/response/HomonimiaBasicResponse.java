package com.camaradirecta.app.rues.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomonimiaBasicResponse implements Serializable{

	public String codigo_clase_identificacion;
    public String desc_clase_identificacion;
    public String numero_identificacion;
    public String digito_verificacion;
    public String razon_social;
    public String sigla;
    public String codigo_camara;
    public String desc_camara;
    public String matricula;
    public String codigo_camara_proponente;
    public String desc_camara_proponente;
    public String inscripcion_proponente;
    public String codigo_tipo_sociedad;
    public String desc_tipo_sociedad;
    public String codigo_organizacion_juridica;
    public String desc_organizacion_juridica;
    public String codigo_categoria_matricula;
    public String desc_categoria_matricula;
    public String codigo_estado_matricula;
    public String desc_estado_matricula;
    public String codigo_estado_proponente;
    public String desc_estado_proponente;
    public int id_registro;
    public boolean indicador_rnt;
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
