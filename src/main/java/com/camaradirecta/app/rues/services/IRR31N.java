package com.camaradirecta.app.rues.services;

import org.springframework.http.ResponseEntity;

import com.camaradirecta.app.rues.dtos.ContratoInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;

public interface IRR31N {

	ResponseEntity<ResponseDto> reporteContratos(ContratoInfoDTO contratoInfoDTO);

}
