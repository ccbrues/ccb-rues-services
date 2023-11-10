package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoProponenteInfoDTO implements Serializable{

	public String numero_interno;
    public String usuario;
    public String nit_proponente;
    public String dv_proponente;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
