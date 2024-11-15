package com.camaradirecta.app.rues.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirmaDigitalResponse implements Serializable{
	

		public String cantidadcertificados;
		public String libroactas;
		public String libroasociados;
		public String municipio;
	    
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
	}
