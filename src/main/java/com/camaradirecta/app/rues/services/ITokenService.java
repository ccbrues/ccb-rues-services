package com.camaradirecta.app.rues.services;

import org.springframework.http.ResponseEntity;

import com.camaradirecta.app.rues.dtos.ResponseDto;

public interface ITokenService {

	public ResponseEntity<ResponseDto> getToken();
}
