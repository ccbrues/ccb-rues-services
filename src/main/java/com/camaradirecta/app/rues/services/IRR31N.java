package com.camaradirecta.app.rues.services;

import org.springframework.http.ResponseEntity;

import com.camaradirecta.app.rues.dtos.ContratoInfoDTO;
import com.camaradirecta.app.rues.dtos.HistoricoProponenteInfoDTO;
import com.camaradirecta.app.rues.dtos.MultaInfoDTO;
import com.camaradirecta.app.rues.dtos.ProponenteExperienciaDTO;
import com.camaradirecta.app.rues.dtos.ProponenteKardexDTO;
import com.camaradirecta.app.rues.dtos.ProponenteSancionesDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.dtos.SancionesInfoDTO;

public interface IRR31N {

	ResponseEntity<ResponseDto> reporteContratos(ContratoInfoDTO contratoInfoDTO);

	ResponseEntity<ResponseDto> reporteMultas(MultaInfoDTO multaInfoDTO);

	ResponseEntity<ResponseDto> reporteSanciones(SancionesInfoDTO sancionesInfoDTO);

	ResponseEntity<ResponseDto> consultaHistoriaProponente(HistoricoProponenteInfoDTO historicoProponenteInfoDTO);

	ResponseEntity<ResponseDto> actualizarExperiencia(ProponenteExperienciaDTO proponenteExperienciaDTO);

	ResponseEntity<ResponseDto> actualizarKardex(ProponenteKardexDTO proponenteKardexDTO);

	ResponseEntity<ResponseDto> actualizarSanciones(ProponenteSancionesDTO proponenteSancionesDTO);

}
