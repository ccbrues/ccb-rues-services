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

import com.camaradirecta.app.rues.dtos.NoticiaProponenteInfoDTO;
import com.camaradirecta.app.rues.dtos.ProponenteNitInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.exceptions.ProcessException;
import com.camaradirecta.app.rues.response.NoticiaProponenteInfoResponse;
import com.camaradirecta.app.rues.response.ProponenteNitInfoResponse;
import com.camaradirecta.app.rues.response.ResponseGeneral;
import com.camaradirecta.app.rues.services.IRR09N;
import com.camaradirecta.app.rues.util.Constantes;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RR09NServiceImpl implements IRR09N {

	private String strContenttype = "application/json";
	
	@Value("${com.camaradirecta.app.rues.RR18N.url-proponente-nit}")
	private String urlProponenteNit;
	
	@Value("${com.camaradirecta.app.rues.RR18N.url-radicar-noticia-proponente}")
	private String urlRadicarNoticia;
	
	@NonNull
	RestTemplate restTemplate = new RestTemplate();
	
	@NonNull
	TokenServiceImpl tokenServiceImpl;

	@Override
	public ResponseEntity<ResponseDto> consultarProponenteNit(ProponenteNitInfoDTO proponenteNitInfo) {
		log.info("Inicio metodo consultarProponenteNit ");
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<ProponenteNitInfoDTO> httpEntity = new HttpEntity<>(proponenteNitInfo, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlProponenteNit, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			ProponenteNitInfoResponse proponenteNitInfoResponse = mapper.convertValue(resp.getRespuesta(), ProponenteNitInfoResponse.class);
			log.info("Fin metodo consultarPalabraClave ");
			return new ResponseEntity<>(ResponseDto.builder().response(proponenteNitInfoResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		}catch (RestClientResponseException e) {
			log.error("Error consultarProponenteNit {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()) , HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error consultarProponenteNit {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error consultarProponenteNit {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@Override
	public ResponseEntity<ResponseDto> radicarNoticiaProponente(NoticiaProponenteInfoDTO noticiaProponenteInfo) {
		log.info("Inicio metodo radicarNoticiaProponente ");
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<NoticiaProponenteInfoDTO> httpEntity = new HttpEntity<>(noticiaProponenteInfo, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlRadicarNoticia, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			NoticiaProponenteInfoResponse noticiaProponenteInfoResponse = mapper.convertValue(resp.getRespuesta(), NoticiaProponenteInfoResponse.class);
			log.info("Fin metodo radicarNoticiaProponente ");
			return new ResponseEntity<>(ResponseDto.builder().response(noticiaProponenteInfoResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		}catch (RestClientResponseException e) {
			log.error("Error radicarNoticiaProponente {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()) , HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error radicarNoticiaProponente {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error radicarNoticiaProponente {} ", e.getLocalizedMessage());
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
