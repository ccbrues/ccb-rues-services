package com.camaradirecta.app.rues.services.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.camaradirecta.app.rues.dtos.ContratoInfoDTO;
import com.camaradirecta.app.rues.dtos.HistoricoProponenteInfoDTO;
import com.camaradirecta.app.rues.dtos.MultaInfoDTO;
import com.camaradirecta.app.rues.dtos.ProponenteExperienciaDTO;
import com.camaradirecta.app.rues.dtos.ProponenteKardexDTO;
import com.camaradirecta.app.rues.dtos.ProponenteSancionesDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.dtos.SancionesInfoDTO;
import com.camaradirecta.app.rues.exceptions.ProcessException;
import com.camaradirecta.app.rues.response.ActualizarProponenteExperienciaResponse;
import com.camaradirecta.app.rues.response.ActualizarProponenteKardexResponse;
import com.camaradirecta.app.rues.response.ActualizarProponenteSancionesResponse;
import com.camaradirecta.app.rues.response.ContratoInfoResponse;
import com.camaradirecta.app.rues.response.HistoricoProponenteInfoResponse;
import com.camaradirecta.app.rues.response.MultaInfoResponse;
import com.camaradirecta.app.rues.response.ResponseGeneral;
import com.camaradirecta.app.rues.response.SancionesInfoResponse;
import com.camaradirecta.app.rues.services.IRR31N;
import com.camaradirecta.app.rues.util.Constantes;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RR31NServiceImpl implements IRR31N{
	
	private String strContenttype = "application/json";
	
	@Value("${com.camaradirecta.app.rues.RR31N.url-reporte-contratos}")
	private String urlReporteContratos;
	
	@Value("${com.camaradirecta.app.rues.RR31N.url-reporte-multas}")
	private String urlReporteMultas;
	
	@Value("${com.camaradirecta.app.rues.RR31N.url-reporte-sanciones}")
	private String urlReporteSanciones;
	
	@Value("${com.camaradirecta.app.rues.RR31N.url-historico-proponente}")
	private String urlHistoricoProponente;
	
	@Value("${com.camaradirecta.app.rues.RR31N.url-actualizar-experiencia}")
	private String urlActualizarExperiencia;
	
	@Value("${com.camaradirecta.app.rues.RR31N.url-actualizar-kardex}")
	private String urlActualizarKardex;
	
	@Value("${com.camaradirecta.app.rues.RR31N.url-actualizar-san-dis}")
	private String urlActualizarSanciones;
	
	@NonNull
	RestTemplate restTemplate = new RestTemplate();
	
	@NonNull
	TokenServiceImpl tokenServiceImpl;
	
	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<ResponseDto> reporteContratos(ContratoInfoDTO contratoInfoDTO) {
		log.info("Inicio metodo reporteContratos {}", new Gson().toJson(contratoInfoDTO));
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<ContratoInfoDTO> httpEntity = new HttpEntity<>(contratoInfoDTO, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlReporteContratos, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			ContratoInfoResponse contratoInfoResponse = mapper.convertValue(resp.getRespuesta(), ContratoInfoResponse.class);
			log.info("Fin metodo reporteContratos {}", mapper.writeValueAsString(contratoInfoResponse));
			return new ResponseEntity<>(ResponseDto.builder().response(contratoInfoResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		}catch (RestClientResponseException e) {
			log.error("Error reporteContratos {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()) , HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error reporteContratos {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error reporteContratos {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<ResponseDto> reporteMultas(MultaInfoDTO multaInfoDTO) {
		log.info("Inicio metodo reporteMultas {}", multaInfoDTO.getNumero_interno());
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<MultaInfoDTO> httpEntity = new HttpEntity<>(multaInfoDTO, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlReporteMultas, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			MultaInfoResponse multaInfoResponse = mapper.convertValue(resp.getRespuesta(), MultaInfoResponse.class);
			log.info("Fin metodo reporteMultas {}", mapper.writeValueAsString(multaInfoResponse));
			return new ResponseEntity<>(ResponseDto.builder().response(multaInfoResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		}catch (RestClientResponseException e) {
			log.error("Error reporteMultas {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()) , HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error reporteMultas {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error reporteMultas {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<ResponseDto> reporteSanciones(SancionesInfoDTO sancionesInfoDTO) {
		log.info("Inicio metodo reporteMultas {}", sancionesInfoDTO.getNumero_interno());
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<SancionesInfoDTO> httpEntity = new HttpEntity<>(sancionesInfoDTO, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlReporteSanciones, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			SancionesInfoResponse sancionesInfoResponse = mapper.convertValue(resp.getRespuesta(), SancionesInfoResponse.class);
			log.info("Fin metodo reporteMultas {}", mapper.writeValueAsString(sancionesInfoResponse));
			return new ResponseEntity<>(ResponseDto.builder().response(sancionesInfoResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		}catch (RestClientResponseException e) {
			log.error("Error reporteMultas {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()) , HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error reporteMultas {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error reporteMultas {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<ResponseDto> consultaHistoriaProponente(HistoricoProponenteInfoDTO historicoProponenteInfoDTO) {
		log.info("Inicio metodo consultaHistoriaProponente {}", historicoProponenteInfoDTO.getNumero_interno());
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<HistoricoProponenteInfoDTO> httpEntity = new HttpEntity<>(historicoProponenteInfoDTO, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlHistoricoProponente, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			HistoricoProponenteInfoResponse historicoProponenteInfoResponse = mapper.convertValue(resp.getRespuesta(), HistoricoProponenteInfoResponse.class);
			log.info("Fin metodo consultaHistoriaProponente {}", mapper.writeValueAsString(historicoProponenteInfoResponse));
			return new ResponseEntity<>(ResponseDto.builder().response(historicoProponenteInfoResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		}catch (RestClientResponseException e) {
			log.error("Error consultaHistoriaProponente {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()) , HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error consultaHistoriaProponente {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error consultaHistoriaProponente {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<ResponseDto> actualizarExperiencia(ProponenteExperienciaDTO proponenteExperienciaDTO) {
		log.info("Inicio metodo actualizarExperiencia {}", proponenteExperienciaDTO.getNumero_interno());
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<ProponenteExperienciaDTO> httpEntity = new HttpEntity<>(proponenteExperienciaDTO, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlActualizarExperiencia, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			ActualizarProponenteExperienciaResponse actualizarExperienciaResponse = mapper.convertValue(resp.getRespuesta(), ActualizarProponenteExperienciaResponse.class);
			log.info("Fin metodo actualizarExperiencia {}", mapper.writeValueAsString(actualizarExperienciaResponse));
			return new ResponseEntity<>(ResponseDto.builder().response(actualizarExperienciaResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		}catch (RestClientResponseException e) {
			log.error("Error actualizarExperiencia {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()) , HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error actualizarExperiencia {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error actualizarExperiencia {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<ResponseDto> actualizarKardex(ProponenteKardexDTO proponenteKardexDTO) {
		log.info("Inicio metodo actualizarKardex {}", proponenteKardexDTO.getNumero_interno());
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<ProponenteKardexDTO> httpEntity = new HttpEntity<>(proponenteKardexDTO, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlActualizarKardex, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			ActualizarProponenteKardexResponse actualizarKardexResponse = mapper.convertValue(resp.getRespuesta(), ActualizarProponenteKardexResponse.class);
			log.info("Fin metodo actualizarKardex {}", mapper.writeValueAsString(actualizarKardexResponse));
			return new ResponseEntity<>(ResponseDto.builder().response(actualizarKardexResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		}catch (RestClientResponseException e) {
			log.error("Error actualizarKardex {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()) , HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error actualizarKardex {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error actualizarKardex {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<ResponseDto> actualizarSanciones(ProponenteSancionesDTO proponenteSancionesDTO) {
		log.info("Inicio metodo actualizarSanciones {}", proponenteSancionesDTO.getNumero_interno());
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<ProponenteSancionesDTO> httpEntity = new HttpEntity<>(proponenteSancionesDTO, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlActualizarSanciones, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			ActualizarProponenteSancionesResponse actualizarSancionesResponse = mapper.convertValue(resp.getRespuesta(), ActualizarProponenteSancionesResponse.class);
			log.info("Fin metodo actualizarSanciones {}", mapper.writeValueAsString(actualizarSancionesResponse));
			return new ResponseEntity<>(ResponseDto.builder().response(actualizarSancionesResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		}catch (RestClientResponseException e) {
			log.error("Error actualizarSanciones {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()) , HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error actualizarSanciones {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error actualizarSanciones {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	/**
	 * @return
	 */
	private String getToken() {
		log.info("Inicio metodo getToken ");
		try {
			ResponseDto responseDto = tokenServiceImpl.getToken().getBody();
			String token = (String) responseDto.getResponse();
			log.info("Fin metodo getToken {}", token );
			return Constantes.BEARER + " " + token;
		} catch (Exception e) {
			log.error(Constantes.ERROR + "consultarPalabraClave {} ", e.getLocalizedMessage());
			throw new ProcessException(Constantes.ERROR+e.getMessage());
		}
	}




}
