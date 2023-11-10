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

import com.camaradirecta.app.rues.dtos.HomonimiaInfoDTO;
import com.camaradirecta.app.rues.dtos.IdentificacionInfoDTO;
import com.camaradirecta.app.rues.dtos.MatriculaInfoDTO;
import com.camaradirecta.app.rues.dtos.NombreInfoDTO;
import com.camaradirecta.app.rues.dtos.PalabraClaveInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.exceptions.ProcessException;
import com.camaradirecta.app.rues.response.HomonimiaInfoResponse;
import com.camaradirecta.app.rues.response.IdentificacionBasicResponse;
import com.camaradirecta.app.rues.response.MatriculaInfoResponse;
import com.camaradirecta.app.rues.response.NombreBasicResponse;
import com.camaradirecta.app.rues.response.PalabraClaveInfoResponse;
import com.camaradirecta.app.rues.response.ResponseGeneral;
import com.camaradirecta.app.rues.services.IRR18N;
import com.camaradirecta.app.rues.util.Constantes;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RR18NServiceImpl implements IRR18N{
	
	private String strContenttype = "application/json";
	
	@Value("${com.camaradirecta.app.rues.RR18N.url-palabra-clave}")
	private String urlPalabraClave;
	
	@Value("${com.camaradirecta.app.rues.RR18N.url-consultar-nombre}")
	private String urlConsultarNombre;
	
	@Value("${com.camaradirecta.app.rues.RR18N.url-consultar-matricula}")
	private String urlConsultarMatricula;
	
	@Value("${com.camaradirecta.app.rues.RR18N.url-consultar-homonimia}")
	private String urlConsultarHomonimia;
	
	@Value("${com.camaradirecta.app.rues.RR18N.url-consultar-numero-identificacion}")
	private String urlConsultarNumeroIdentificacion;
	
	@NonNull
	RestTemplate restTemplate = new RestTemplate();
	
	@NonNull
	TokenServiceImpl tokenServiceImpl;

	/**
	 *
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<ResponseDto> consultarPalabraClave(PalabraClaveInfoDTO palabraClaveDto) {
		log.info("Inicio metodo consultarPalabraClave {}", palabraClaveDto.numero_interno);
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<PalabraClaveInfoDTO> httpEntity = new HttpEntity<>(palabraClaveDto, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlPalabraClave, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			PalabraClaveInfoResponse palabraClaveInfoResponse = mapper.convertValue(resp.getRespuesta(), PalabraClaveInfoResponse.class);
			log.info("Fin metodo consultarPalabraClave {}", mapper.writeValueAsString(palabraClaveInfoResponse));
			return new ResponseEntity<>(ResponseDto.builder().response(palabraClaveInfoResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		}catch (RestClientResponseException e) {
			log.error("Error consultarPalabraClave {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()) , HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error consultarPalabraClave {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error consultarPalabraClave {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 *
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<ResponseDto> consultarNombre(NombreInfoDTO nombreInfoDTO) {
		log.info("Inicio metodo consultarPalabraClave {}", nombreInfoDTO.getNumero_interno());
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<NombreInfoDTO> httpEntity = new HttpEntity<>(nombreInfoDTO, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlConsultarNombre, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			NombreBasicResponse nombreBasicResponse = mapper.convertValue(resp.getRegistros(), NombreBasicResponse.class);
			log.info("Fin metodo consultarNombre {}", mapper.writeValueAsString(nombreBasicResponse));
			return new ResponseEntity<>(ResponseDto.builder().response(nombreBasicResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		}catch (RestClientResponseException e) {
			log.error("Error consultarNombre {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()) , HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error consultarNombre {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error consultarNombre {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 *
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<ResponseDto> consultarMatricula(MatriculaInfoDTO matriculaInfoDTO) {
		log.info("Inicio metodo consultarMatricula {}", matriculaInfoDTO.getNumero_interno());
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<MatriculaInfoDTO> httpEntity = new HttpEntity<>(matriculaInfoDTO, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlConsultarMatricula, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			MatriculaInfoResponse matriculaInfoResponse = mapper.convertValue(resp.getRespuesta(), MatriculaInfoResponse.class);
			log.info("Fin metodo consultarMatricula: {} ", mapper.writeValueAsString(matriculaInfoResponse));
			return new ResponseEntity<>(ResponseDto.builder().response(matriculaInfoResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		}catch (RestClientResponseException e) {
			log.error("Error consultarMatricula {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()) , HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error consultarMatricula {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error consultarMatricula {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 *
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<ResponseDto> consultarHomonimia(HomonimiaInfoDTO homonimiaInfoDTO) {
		log.info("Inicio metodo consultarHomonimia {}", homonimiaInfoDTO.getNumero_interno());
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<HomonimiaInfoDTO> httpEntity = new HttpEntity<>(homonimiaInfoDTO, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlConsultarHomonimia, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			HomonimiaInfoResponse homonimiaInfoResponse = mapper.convertValue(resp.getRespuesta(), HomonimiaInfoResponse.class);
			log.info("Fin metodo consultarHomonimia: {} ", mapper.writeValueAsString(homonimiaInfoResponse));
			return new ResponseEntity<>(ResponseDto.builder().response(homonimiaInfoResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		}catch (RestClientResponseException e) {
			log.error("Error consultarHomonimia {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()) , HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error consultarHomonimia {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error consultarHomonimia {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 *
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<ResponseDto> consultarNumeroIdentificacion(IdentificacionInfoDTO identificacionInfoDTO) {
		log.info("Inicio metodo consultarNumeroIdentificacion {}", identificacionInfoDTO.getNumero_interno());
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<IdentificacionInfoDTO> httpEntity = new HttpEntity<>(identificacionInfoDTO, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlConsultarNumeroIdentificacion, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			IdentificacionBasicResponse identificacionBasicResponse = mapper.convertValue(resp.getRespuesta(), IdentificacionBasicResponse.class);
			log.info("Fin metodo consultarNumeroIdentificacion: {} ", mapper.writeValueAsString(identificacionBasicResponse));
			return new ResponseEntity<>(ResponseDto.builder().response(identificacionBasicResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		}catch (RestClientResponseException e) {
			log.error("Error consultarNumeroIdentificacion {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()) , HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error consultarNumeroIdentificacion {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error consultarNumeroIdentificacion {} ", e.getLocalizedMessage());
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
