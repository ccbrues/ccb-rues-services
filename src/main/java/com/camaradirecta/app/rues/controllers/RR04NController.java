package com.camaradirecta.app.rues.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camaradirecta.app.rues.dtos.CertificadoInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.services.IRR04N;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/RR04N")
@RequiredArgsConstructor
public class RR04NController {
	
	@NonNull
	private final IRR04N serviceIRR04N;
	

	@PostMapping(path = "/solicitudCertificado")
	public ResponseEntity<ResponseDto> solicitudCertificado(@RequestBody CertificadoInfoDTO certificadoInfoDTO) {
		return this.serviceIRR04N.solicitudCertificado(certificadoInfoDTO);
	}

}
