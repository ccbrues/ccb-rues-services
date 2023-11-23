package com.camaradirecta.app.rues.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camaradirecta.app.rues.dtos.RadicacionInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.services.IMR02N;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/MR02N")
@RequiredArgsConstructor
public class MR02NController {
	
	@NonNull
	private final IMR02N serviceIMR02N;
	

	@PostMapping(path = "/solicitudRadicacion")
	public ResponseEntity<ResponseDto> solicitudRadicacion(@RequestBody RadicacionInfoDTO radicacionInfoDTO) {
		return this.serviceIMR02N.solicitudRadicacion(radicacionInfoDTO);
	}

}
