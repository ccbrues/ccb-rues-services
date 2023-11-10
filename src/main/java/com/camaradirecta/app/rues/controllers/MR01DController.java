package com.camaradirecta.app.rues.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camaradirecta.app.rues.dtos.LiquidacionInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.services.IMR01D;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/MR01D")
@RequiredArgsConstructor
public class MR01DController {
	
	@NonNull
	private final IMR01D serviceIMR01D;
	
	@Operation(summary = "Servicio que permite a través del RUES realizar la liquidación de un trámite entre cámarsa de comercio", description = "Retorna un mensaje", responses = {
			@ApiResponse(responseCode = "200", description = "Operación Exitosa", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
			@ApiResponse(responseCode = "401", description = "datos invalidos"),
			@ApiResponse(responseCode = "404", description = "No existe mensaje"),
			@ApiResponse(responseCode = "409", description = "Mensaje de error no controlado") })
	@PostMapping(path = "/solicitudLiquidacion")
	public ResponseEntity<ResponseDto> consultarPalabraClave(@RequestBody LiquidacionInfoDTO liquidacionInfoDTO) {
		return this.serviceIMR01D.solicitudLiquidacion(liquidacionInfoDTO);
	}

}
