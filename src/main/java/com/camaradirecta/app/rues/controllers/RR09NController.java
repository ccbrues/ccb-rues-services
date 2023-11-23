package com.camaradirecta.app.rues.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camaradirecta.app.rues.dtos.NoticiaProponenteInfoDTO;
import com.camaradirecta.app.rues.dtos.ProponenteNitInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.services.IRR09N;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/RR09N")
@RequiredArgsConstructor
public class RR09NController {

	@NonNull
	private final IRR09N RR09nService;
	

	@PostMapping(path = "/consultarProponenteNit")
	public ResponseEntity<ResponseDto> consultarProponenteNit(@RequestBody ProponenteNitInfoDTO proponenteNitInfo) {
		return this.RR09nService.consultarProponenteNit(proponenteNitInfo);
	}
	

	@PostMapping(path = "/radicarNoticiaProponente")
	public ResponseEntity<ResponseDto> radicarNoticiaProponente(@RequestBody NoticiaProponenteInfoDTO noticiaProponenteInfo) {
		return this.RR09nService.radicarNoticiaProponente(noticiaProponenteInfo);
	}
	
}
