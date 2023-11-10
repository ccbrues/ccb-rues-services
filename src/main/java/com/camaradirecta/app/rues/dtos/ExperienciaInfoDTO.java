package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExperienciaInfoDTO implements Serializable{

	public String secuencia_contrato;
    public String celebrado_por;
    public String nombre_contratista;
    public String nombre_contratante;
    public double valor_smmlv;
    public int porcentaje_participacion;
    public String clasificaciones;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
