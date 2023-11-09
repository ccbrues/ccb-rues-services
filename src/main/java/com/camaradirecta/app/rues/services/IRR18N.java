package com.camaradirecta.app.rues.services;

import org.springframework.http.ResponseEntity;

import com.camaradirecta.app.rues.dtos.PalabraClaveInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;

public interface IRR18N {
	
	public ResponseEntity<ResponseDto> consultarPalabraClave(PalabraClaveInfoDTO palabraClaveDto);

}
