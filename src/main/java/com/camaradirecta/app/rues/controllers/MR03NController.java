package com.camaradirecta.app.rues.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camaradirecta.app.rues.dtos.ActualizacionEstadoInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.services.IMR03N;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/MR03N")
@RequiredArgsConstructor
public class MR03NController {
	
	@NonNull
	private final IMR03N serviceIMR03N;
	
	@Operation(summary = "Servicio que permite actualizar el estado de un tramite que se encuentre radicado en el rues ", description = "Retorna un mensaje", responses = {
			@ApiResponse(responseCode = "200", description = "Operación Exitosa", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
			@ApiResponse(responseCode = "401", description = "datos invalidos"),
			@ApiResponse(responseCode = "404", description = "No existe mensaje"),
			@ApiResponse(responseCode = "409", description = "Mensaje de error no controlado") })
	@PostMapping(path = "/solicitudActualizacionEstado")
	public ResponseEntity<ResponseDto> solicitudActualizacionEstado(@RequestBody ActualizacionEstadoInfoDTO actualizacionEstadoInfoDTO) {
		return this.serviceIMR03N.solicitudActualizacionEstado(actualizacionEstadoInfoDTO);
	}

}
