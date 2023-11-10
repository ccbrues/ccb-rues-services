package com.camaradirecta.app.rues.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camaradirecta.app.rues.dtos.NoticiaProponenteInfoDTO;
import com.camaradirecta.app.rues.dtos.PalabraClaveInfoDTO;
import com.camaradirecta.app.rues.dtos.ProponenteNitInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.services.IRR09N;
import com.camaradirecta.app.rues.services.IRR18N;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/RR09N")
@RequiredArgsConstructor
public class RR09NController {

	@NonNull
	private final IRR09N RR09nService;
	
	@Operation(summary = "Servicio que permite consultar un proponente por nit", description = "Retorna un mensaje", responses = {
			@ApiResponse(responseCode = "200", description = "Operación Exitosa", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
			@ApiResponse(responseCode = "401", description = "datos invalidos"),
			@ApiResponse(responseCode = "404", description = "No existe mensaje"),
			@ApiResponse(responseCode = "409", description = "Mensaje de error no controlado") })
	@PostMapping(path = "/consultarProponenteNit")
	public ResponseEntity<ResponseDto> consultarProponenteNit(@RequestBody ProponenteNitInfoDTO proponenteNitInfo) {
		return this.RR09nService.consultarProponenteNit(proponenteNitInfo);
	}
	
	@Operation(summary = "Servicio que permite radicar la noticia de un proponente", description = "Retorna un mensaje", responses = {
			@ApiResponse(responseCode = "200", description = "Operación Exitosa", content = @Content(schema = @Schema(implementation = ResponseDto.class))),
			@ApiResponse(responseCode = "401", description = "datos invalidos"),
			@ApiResponse(responseCode = "404", description = "No existe mensaje"),
			@ApiResponse(responseCode = "409", description = "Mensaje de error no controlado") })
	@PostMapping(path = "/radicarNoticiaProponente")
	public ResponseEntity<ResponseDto> radicarNoticiaProponente(@RequestBody NoticiaProponenteInfoDTO noticiaProponenteInfo) {
		return this.RR09nService.radicarNoticiaProponente(noticiaProponenteInfo);
	}
	
}
