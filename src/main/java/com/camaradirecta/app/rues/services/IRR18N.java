package com.camaradirecta.app.rues.services;

import org.springframework.http.ResponseEntity;

import com.camaradirecta.app.rues.dtos.HomonimiaInfoDTO;
import com.camaradirecta.app.rues.dtos.IdentificacionInfoDTO;
import com.camaradirecta.app.rues.dtos.MatriculaInfoDTO;
import com.camaradirecta.app.rues.dtos.NombreInfoDTO;
import com.camaradirecta.app.rues.dtos.PalabraClaveInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;

public interface IRR18N {
	
	public ResponseEntity<ResponseDto> consultarPalabraClave(PalabraClaveInfoDTO palabraClaveDto);

	public ResponseEntity<ResponseDto> consultarNombre(NombreInfoDTO nombreInfoDTO);

	public ResponseEntity<ResponseDto> consultarMatricula(MatriculaInfoDTO matriculaInfoDTO);

	public ResponseEntity<ResponseDto> consultarHomonimia(HomonimiaInfoDTO homonimiaInfoDTO);

	public ResponseEntity<ResponseDto> consultarNumeroIdentificacion(IdentificacionInfoDTO identificacionInfoDTO);

}
