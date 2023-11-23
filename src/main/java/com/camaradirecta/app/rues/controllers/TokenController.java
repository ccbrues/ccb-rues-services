package com.camaradirecta.app.rues.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.services.ITokenService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/token")
@RequiredArgsConstructor
public class TokenController {
	
	@NonNull
	private final ITokenService tokenService;
	

	@GetMapping(path = "/get")
	public ResponseEntity<ResponseDto> getToken() {
		return this.tokenService.getToken();
	}

}
