package com.camaradirecta.app.rues.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camaradirecta.app.rues.dtos.HomonimiaInfoDTO;
import com.camaradirecta.app.rues.dtos.IdentificacionInfoDTO;
import com.camaradirecta.app.rues.dtos.MatriculaInfoDTO;
import com.camaradirecta.app.rues.dtos.NombreInfoDTO;
import com.camaradirecta.app.rues.dtos.PalabraClaveInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.services.IRR18N;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/RR18N")
@RequiredArgsConstructor
public class RR18NController {
	
	@NonNull
	private final IRR18N RR18NService;
	
	@Operation(summary = "Servicio que permite generar consultar un comercio por palabra clave", description = "Retorna un mensaje", responses = {
			@ApiResponse(responseCode = "200", description = "Operación Exitosa", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
			@ApiResponse(responseCode = "401", description = "datos invalidos"),
			@ApiResponse(responseCode = "404", description = "No existe mensaje"),
			@ApiResponse(responseCode = "409", description = "Mensaje de error no controlado") })
	@PostMapping(path = "/consultarPalabraClave")
	public ResponseEntity<ResponseDto> consultarPalabraClave(@RequestBody PalabraClaveInfoDTO palabraClaveDto) {
		return this.RR18NService.consultarPalabraClave(palabraClaveDto);
	}
	
	@Operation(summary = "Servicio que permite generar consultar un comercio por nombre o razon social", description = "Retorna un mensaje", responses = {
			@ApiResponse(responseCode = "200", description = "Operación Exitosa", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
			@ApiResponse(responseCode = "401", description = "datos invalidos"),
			@ApiResponse(responseCode = "404", description = "No existe mensaje"),
			@ApiResponse(responseCode = "409", description = "Mensaje de error no controlado") })
	@PostMapping(path = "/consultarNombre")
	public ResponseEntity<ResponseDto> consultarNombre(@RequestBody NombreInfoDTO nombreInfoDTO) {
		return this.RR18NService.consultarNombre(nombreInfoDTO);
	}
	
	@Operation(summary = "Servicio que permite generar consultar un comercio por matricula y camara", description = "Retorna un mensaje", responses = {
			@ApiResponse(responseCode = "200", description = "Operación Exitosa", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
			@ApiResponse(responseCode = "401", description = "datos invalidos"),
			@ApiResponse(responseCode = "404", description = "No existe mensaje"),
			@ApiResponse(responseCode = "409", description = "Mensaje de error no controlado") })
	@PostMapping(path = "/consultarMatricula")
	public ResponseEntity<ResponseDto> consultarMatricula(@RequestBody MatriculaInfoDTO matriculaInfoDTO) {
		return this.RR18NService.consultarMatricula(matriculaInfoDTO);
	}
	
	@Operation(summary = "Servicio que permite generar consultar la homonimia", description = "Retorna un mensaje", responses = {
			@ApiResponse(responseCode = "200", description = "Operación Exitosa", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
			@ApiResponse(responseCode = "401", description = "datos invalidos"),
			@ApiResponse(responseCode = "404", description = "No existe mensaje"),
			@ApiResponse(responseCode = "409", description = "Mensaje de error no controlado") })
	@PostMapping(path = "/consultarHomonimia")
	public ResponseEntity<ResponseDto> consultarHomonimia(@RequestBody HomonimiaInfoDTO homonimiaInfoDTO) {
		return this.RR18NService.consultarHomonimia(homonimiaInfoDTO);
	}
	
	@Operation(summary = "Servicio que permite generar consultar por numero de identificacion", description = "Retorna un mensaje", responses = {
			@ApiResponse(responseCode = "200", description = "Operación Exitosa", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
			@ApiResponse(responseCode = "401", description = "datos invalidos"),
			@ApiResponse(responseCode = "404", description = "No existe mensaje"),
			@ApiResponse(responseCode = "409", description = "Mensaje de error no controlado") })
	@PostMapping(path = "/consultarNumeroIdentificacion")
	public ResponseEntity<ResponseDto> consultarNumeroIdentificacion(@RequestBody IdentificacionInfoDTO identificacionInfoDTO) {
		return this.RR18NService.consultarNumeroIdentificacion(identificacionInfoDTO);
	}
	
	

}
