package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoCiiuInfoDTO implements Serializable{

	public String codigo_ciiu;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
