package com.camaradirecta.app.rues.services;

import org.springframework.http.ResponseEntity;

import com.camaradirecta.app.rues.dtos.NoticiaProponenteInfoDTO;
import com.camaradirecta.app.rues.dtos.ProponenteNitInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;

public interface IRR09N {

	public ResponseEntity<ResponseDto> consultarProponenteNit(ProponenteNitInfoDTO proponenteNitInfo);
	
	public ResponseEntity<ResponseDto> radicarNoticiaProponente(NoticiaProponenteInfoDTO noticiaProponenteInfo);
	
}
