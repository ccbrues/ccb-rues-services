package com.camaradirecta.app.rues.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camaradirecta.app.rues.dtos.RadicarProponenteInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.services.IRR30N;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/RR30N")
@RequiredArgsConstructor
public class RR30NController {

	@NonNull
	private final IRR30N serviceRR30N;
	

	@PostMapping(path = "/radicarRegistroProponente")
	public ResponseEntity<ResponseDto> radicarRegistroProponente(@RequestBody RadicarProponenteInfoDTO radicarProponenteInfo) {
		return this.serviceRR30N.radicarRegistroProponente(radicarProponenteInfo);
	}
	
}
