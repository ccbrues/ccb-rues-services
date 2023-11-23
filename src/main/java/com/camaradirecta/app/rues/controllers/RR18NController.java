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

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/RR18N")
@RequiredArgsConstructor
public class RR18NController {
	
	@NonNull
	private final IRR18N serviceRR18N;
	

	@PostMapping(path = "/consultarPalabraClave")
	public ResponseEntity<ResponseDto> consultarPalabraClave(@RequestBody PalabraClaveInfoDTO palabraClaveDto) {
		return this.serviceRR18N.consultarPalabraClave(palabraClaveDto);
	}
	

	@PostMapping(path = "/consultarNombre")
	public ResponseEntity<ResponseDto> consultarNombre(@RequestBody NombreInfoDTO nombreInfoDTO) {
		return this.serviceRR18N.consultarNombre(nombreInfoDTO);
	}
	

	@PostMapping(path = "/consultarMatricula")
	public ResponseEntity<ResponseDto> consultarMatricula(@RequestBody MatriculaInfoDTO matriculaInfoDTO) {
		return this.serviceRR18N.consultarMatricula(matriculaInfoDTO);
	}
	

	@PostMapping(path = "/consultarHomonimia")
	public ResponseEntity<ResponseDto> consultarHomonimia(@RequestBody HomonimiaInfoDTO homonimiaInfoDTO) {
		return this.serviceRR18N.consultarHomonimia(homonimiaInfoDTO);
	}
	

	@PostMapping(path = "/consultarNumeroIdentificacion")
	public ResponseEntity<ResponseDto> consultarNumeroIdentificacion(@RequestBody IdentificacionInfoDTO identificacionInfoDTO) {
		return this.serviceRR18N.consultarNumeroIdentificacion(identificacionInfoDTO);
	}
	
	

}
