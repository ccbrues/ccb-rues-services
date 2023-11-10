package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoUnspscInfoDTO implements Serializable{

	public String codigo_unspsc;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
