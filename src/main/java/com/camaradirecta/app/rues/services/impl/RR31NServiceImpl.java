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
import com.camaradirecta.app.rues.dtos.MultaInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.dtos.SancionesInfoDTO;
import com.camaradirecta.app.rues.exceptions.ProcessException;
import com.camaradirecta.app.rues.response.ContratoInfoResponse;
import com.camaradirecta.app.rues.response.MultaInfoResponse;
import com.camaradirecta.app.rues.response.ResponseGeneral;
import com.camaradirecta.app.rues.response.SancionesInfoResponse;
import com.camaradirecta.app.rues.services.IRR31N;
import com.camaradirecta.app.rues.util.Constantes;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@NonNull
	RestTemplate restTemplate = new RestTemplate();
	
	@NonNull
	TokenServiceImpl tokenServiceImpl;
	
	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<ResponseDto> reporteContratos(ContratoInfoDTO contratoInfoDTO) {
		log.info("Inicio metodo reporteContratos {}", contratoInfoDTO.numero_interno);
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
		log.info("Inicio metodo reporteMultas {}", multaInfoDTO.numero_interno);
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
		log.info("Inicio metodo reporteMultas {}", sancionesInfoDTO.numero_interno);
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
