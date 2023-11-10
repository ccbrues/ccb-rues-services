package com.camaradirecta.app.rues.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.camaradirecta.app.rues.dtos.RadicarProponenteInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.services.IRR30N;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/RR30N")
@RequiredArgsConstructor
public class RR30NController {

	@NonNull
	private final IRR30N serviceRR30N;
	
	@Operation(summary = "Servicio que permite radicar el registro de un proponente", description = "Retorna un mensaje", responses = {
			@ApiResponse(responseCode = "200", description = "Operación Exitosa", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
			@ApiResponse(responseCode = "401", description = "datos invalidos"),
			@ApiResponse(responseCode = "404", description = "No existe mensaje"),
			@ApiResponse(responseCode = "409", description = "Mensaje de error no controlado") })
	@PostMapping(path = "/radicarRegistroProponente")
	public ResponseEntity<ResponseDto> radicarRegistroProponente(@RequestBody RadicarProponenteInfoDTO radicarProponenteInfo) {
		return this.serviceRR30N.radicarRegistroProponente(radicarProponenteInfo);
	}
	
}
