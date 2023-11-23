package com.camaradirecta.app.rues.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camaradirecta.app.rues.dtos.LiquidacionInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.services.IMR01D;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/MR01D")
@RequiredArgsConstructor
public class MR01DController {
	
	@NonNull
	private final IMR01D serviceIMR01D;
	

	@PostMapping(path = "/solicitudLiquidacion")
	public ResponseEntity<ResponseDto> solicitudLiquidacion(@RequestBody LiquidacionInfoDTO liquidacionInfoDTO) {
		return this.serviceIMR01D.solicitudLiquidacion(liquidacionInfoDTO);
	}

}
