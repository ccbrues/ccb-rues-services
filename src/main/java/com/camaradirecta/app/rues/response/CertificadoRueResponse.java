package com.camaradirecta.app.rues.response;


import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificadoRueResponse implements Serializable{
    
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		public RueCertificadoResponse respuesta;

}
