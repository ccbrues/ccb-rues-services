package com.camaradirecta.app.rues.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camaradirecta.app.rues.dtos.ContratoInfoDTO;
import com.camaradirecta.app.rues.dtos.MultaInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.dtos.SancionesInfoDTO;
import com.camaradirecta.app.rues.services.IRR31N;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/RR31N")
@RequiredArgsConstructor
public class RR31NController {
	
	@NonNull
	private final IRR31N serviceIRR31N;
	
	@Operation(summary = "Servicio que permite radicar contratos reportados por el REE para un proponente", description = "Retorna un mensaje", responses = {
			@ApiResponse(responseCode = "200", description = "Operación Exitosa", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
			@ApiResponse(responseCode = "401", description = "datos invalidos"),
			@ApiResponse(responseCode = "404", description = "No existe mensaje"),
			@ApiResponse(responseCode = "409", description = "Mensaje de error no controlado") })
	@PostMapping(path = "/reporteContratos")
	public ResponseEntity<ResponseDto> reporteContratos(@RequestBody ContratoInfoDTO contratoInfoDTO) {
		return this.serviceIRR31N.reporteContratos(contratoInfoDTO);
	}
	
	@Operation(summary = "Servicio que permite radicar Multas  reportadas por el REE para un proponente", description = "Retorna un mensaje", responses = {
			@ApiResponse(responseCode = "200", description = "Operación Exitosa", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
			@ApiResponse(responseCode = "401", description = "datos invalidos"),
			@ApiResponse(responseCode = "404", description = "No existe mensaje"),
			@ApiResponse(responseCode = "409", description = "Mensaje de error no controlado") })
	@PostMapping(path = "/reporteMultas")
	public ResponseEntity<ResponseDto> reporteMultas(@RequestBody MultaInfoDTO multaInfoDTO) {
		return this.serviceIRR31N.reporteMultas(multaInfoDTO);
	}
	
	@Operation(summary = "Servicio que permite radicar Multas  reportadas por el REE para un proponente", description = "Retorna un mensaje", responses = {
			@ApiResponse(responseCode = "200", description = "Operación Exitosa", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
			@ApiResponse(responseCode = "401", description = "datos invalidos"),
			@ApiResponse(responseCode = "404", description = "No existe mensaje"),
			@ApiResponse(responseCode = "409", description = "Mensaje de error no controlado") })
	@PostMapping(path = "/reporteSanciones")
	public ResponseEntity<ResponseDto> reporteSanciones(@RequestBody SancionesInfoDTO sancionesInfoDTO) {
		return this.serviceIRR31N.reporteSanciones(sancionesInfoDTO);
	}

}
