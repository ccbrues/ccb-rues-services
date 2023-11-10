package com.camaradirecta.app.rues.services;

import org.springframework.http.ResponseEntity;
import com.camaradirecta.app.rues.dtos.RadicarProponenteInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;

public interface IRR30N {

	public ResponseEntity<ResponseDto> radicarRegistroProponente(RadicarProponenteInfoDTO radicarProponenteInfo);
	
}
