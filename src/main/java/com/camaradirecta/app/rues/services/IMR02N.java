package com.camaradirecta.app.rues.services;

import org.springframework.http.ResponseEntity;

import com.camaradirecta.app.rues.dtos.RadicacionInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;

public interface IMR02N {

	ResponseEntity<ResponseDto> solicitudRadicacion(RadicacionInfoDTO radicacionInfoDTO);

}
