package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoricoProponenteInfoDTO implements Serializable{

	private String numero_interno;
    private String usuario;
    private String nit_proponente;
    private String dv_proponente;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
