package com.camaradirecta.app.rues.services;

import org.springframework.http.ResponseEntity;

import com.camaradirecta.app.rues.dtos.ActualizacionEstadoInfoDTO;
import com.camaradirecta.app.rues.dtos.CertificadoInfoDTO;
import com.camaradirecta.app.rues.dtos.LiquidacionInfoRueDTO;
import com.camaradirecta.app.rues.dtos.RadicacionInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.response.LiquidacionInfoResponse;
import com.camaradirecta.app.rues.response.RadicacionInfoResponse;
import com.camaradirecta.app.rues.response.RueCertificadoResponse;

public interface IClienteRue {
	
	ResponseEntity<ResponseDto> solicitudRUEActualizacionEstado(ActualizacionEstadoInfoDTO actualizacionEstadoInfoDTO);
	
	ResponseEntity<LiquidacionInfoResponse> solicitudRUELiquidacion(LiquidacionInfoRueDTO liquidacionInfoRueDTO);
	
	ResponseEntity<RadicacionInfoResponse> solicitudRUERadicacion(RadicacionInfoDTO radicacionInfoDTO);
	
	ResponseEntity<RueCertificadoResponse> solicitudRUECertificado(CertificadoInfoDTO certificadoInfoDTO);

}
