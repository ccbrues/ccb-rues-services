package com.camaradirecta.app.rues.services;

import org.springframework.http.ResponseEntity;

import com.camaradirecta.app.rues.dtos.LiquidacionInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;

public interface IMR01D {

	ResponseEntity<ResponseDto> solicitudLiquidacion(LiquidacionInfoDTO liquidacionInfoDTO);

}
