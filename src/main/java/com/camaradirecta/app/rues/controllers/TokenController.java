package com.camaradirecta.app.rues.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.services.ITokenService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/token")
@RequiredArgsConstructor
public class TokenController {
	
	@NonNull
	private final ITokenService tokenService;
	
	@Operation(summary = "Servicio que permite generar pin", description = "Retorna un mensaje", responses = {
			@ApiResponse(responseCode = "200", description = "Operación Exitosa", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
			@ApiResponse(responseCode = "401", description = "token invalido"),
			@ApiResponse(responseCode = "404", description = "No existe mensaje"),
			@ApiResponse(responseCode = "409", description = "Mensaje de error no controlado") })
	@GetMapping(path = "/get")
	public ResponseEntity<ResponseDto> getToken(@RequestHeader("ipRemota") String ipRemote) {
		return this.tokenService.getToken();
	}

}
