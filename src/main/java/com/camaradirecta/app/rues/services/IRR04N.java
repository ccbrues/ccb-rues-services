package com.camaradirecta.app.rues.services;

import org.springframework.http.ResponseEntity;

import com.camaradirecta.app.rues.dtos.CertificadoInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;

public interface IRR04N {

	ResponseEntity<ResponseDto> solicitudCertificado(CertificadoInfoDTO certificadoInfoDTO);

}
