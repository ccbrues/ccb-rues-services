package com.camaradirecta.app.rues.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camaradirecta.app.rues.dtos.ActualizacionEstadoInfoDTO;
import com.camaradirecta.app.rues.dtos.CertificadoInfoDTO;
import com.camaradirecta.app.rues.dtos.LiquidacionInfoRueDTO;
import com.camaradirecta.app.rues.dtos.RadicacionInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.response.LiquidacionInfoResponse;
import com.camaradirecta.app.rues.response.RadicacionInfoResponse;
import com.camaradirecta.app.rues.response.RueCertificadoResponse;
import com.camaradirecta.app.rues.services.IClienteRue;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class ClienteRueController {
	
	@NonNull
	private final IClienteRue clienteRue;
	
	@GetMapping(path = "/SOLCAESTAD")
	public ResponseEntity<ResponseDto> solicitudRUEActualizacionEstado() {
		return new ResponseEntity<>(ResponseDto.builder().success(true)
				.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
	}
	
	@PostMapping(path = "/SOLCAESTAD")
	public ResponseEntity<ResponseDto> solicitudRUEActualizacionEstado(@RequestBody ActualizacionEstadoInfoDTO actualizacionEstadoInfoDTO) {
		return this.clienteRue.solicitudRUEActualizacionEstado(actualizacionEstadoInfoDTO);
	}
	
	@GetMapping(path = "/SOLIQ")
	public ResponseEntity<ResponseDto> solicitudRUELiquidacion() {
		return new ResponseEntity<>(ResponseDto.builder().success(true)
				.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
	}
	
	@PostMapping(path = "/SOLIQ")
	public ResponseEntity<LiquidacionInfoResponse> solicitudRUELiquidacion(@RequestBody LiquidacionInfoRueDTO liquidacionInfoRueDTO) {
		return this.clienteRue.solicitudRUELiquidacion(liquidacionInfoRueDTO);
	}
	
	@GetMapping(path = "/SOLRADIC")
	public ResponseEntity<ResponseDto> solicitudRUERadicacion() {
		return new ResponseEntity<>(ResponseDto.builder().success(true)
				.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
	}
	
	@PostMapping(path = "/SOLRADIC")
	public ResponseEntity<RadicacionInfoResponse> solicitudRUERadicacion(@RequestBody RadicacionInfoDTO radicacionInfoDTO) {
		return this.clienteRue.solicitudRUERadicacion(radicacionInfoDTO);
	}
	
	@GetMapping(path = "/SOLCERT")
	public ResponseEntity<ResponseDto> solicitudRUECertificado() {
		return new ResponseEntity<>(ResponseDto.builder().success(true)
				.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
	}
	
	@PostMapping(path = "/SOLCERT")
	public ResponseEntity<RueCertificadoResponse> solicitudRUECertificado(@RequestBody CertificadoInfoDTO certificadoInfoDTO) {
		return this.clienteRue.solicitudRUECertificado(certificadoInfoDTO);
	}

}
