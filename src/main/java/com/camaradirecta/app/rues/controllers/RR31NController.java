package com.camaradirecta.app.rues.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.camaradirecta.app.rues.dtos.ContratoInfoDTO;
import com.camaradirecta.app.rues.dtos.HistoricoProponenteInfoDTO;
import com.camaradirecta.app.rues.dtos.MultaInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.dtos.SancionesInfoDTO;
import com.camaradirecta.app.rues.services.IRR31N;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/RR31N")
@RequiredArgsConstructor
public class RR31NController {
	
	@NonNull
	private final IRR31N serviceIRR31N;
	

	@PostMapping(path = "/reporteContratos")
	public ResponseEntity<ResponseDto> reporteContratos(@RequestBody ContratoInfoDTO contratoInfoDTO) {
		return this.serviceIRR31N.reporteContratos(contratoInfoDTO);
	}
	

	@PostMapping(path = "/reporteMultas")
	public ResponseEntity<ResponseDto> reporteMultas(@RequestBody MultaInfoDTO multaInfoDTO) {
		return this.serviceIRR31N.reporteMultas(multaInfoDTO);
	}
	

	@PostMapping(path = "/reporteSanciones")
	public ResponseEntity<ResponseDto> reporteSanciones(@RequestBody SancionesInfoDTO sancionesInfoDTO) {
		return this.serviceIRR31N.reporteSanciones(sancionesInfoDTO);
	}
	
	@PostMapping(path = "/consultaHistoriaProponente")
	public ResponseEntity<ResponseDto> consultaHistoriaProponente(@RequestBody HistoricoProponenteInfoDTO historicoProponenteInfoDTO) {
		return this.serviceIRR31N.consultaHistoriaProponente(historicoProponenteInfoDTO);
	}

}
