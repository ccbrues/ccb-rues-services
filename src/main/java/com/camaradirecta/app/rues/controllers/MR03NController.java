package com.camaradirecta.app.rues.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camaradirecta.app.rues.dtos.ActualizacionEstadoInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.services.IMR03N;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/MR03N")
@RequiredArgsConstructor
public class MR03NController {
	
	@NonNull
	private final IMR03N serviceIMR03N;
	

	@PostMapping(path = "/solicitudActualizacionEstado")
	public ResponseEntity<ResponseDto> solicitudActualizacionEstado(@RequestBody ActualizacionEstadoInfoDTO actualizacionEstadoInfoDTO) {
		return this.serviceIMR03N.solicitudActualizacionEstado(actualizacionEstadoInfoDTO);
	}

}
