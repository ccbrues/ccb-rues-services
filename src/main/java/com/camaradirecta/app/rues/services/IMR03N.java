package com.camaradirecta.app.rues.services;

import org.springframework.http.ResponseEntity;

import com.camaradirecta.app.rues.dtos.ActualizacionEstadoInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;

public interface IMR03N {

	ResponseEntity<ResponseDto> solicitudActualizacionEstado(ActualizacionEstadoInfoDTO actualizacionEstadoInfoDTO);

}
