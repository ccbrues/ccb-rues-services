package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProponenteNitInfoDTO implements Serializable{

	public String numero_interno;
    public String usuario;
    public String cantidad_registros_out;
    public String numero_identificacion_consulta;
    public String digito_verificacion_consulta;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
