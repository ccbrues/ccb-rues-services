package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SituacionesControlInfoDTO implements Serializable{

	public String nit;
    public String nombre;
    public String domicilio;
    public String ge_matriz;
    public int sc_controlante;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
