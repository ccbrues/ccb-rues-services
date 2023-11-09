package com.camaradirecta.app.rues.services.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.camaradirecta.app.rues.dtos.PalabraClaveInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.exceptions.ProcessException;
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
		log.info("Inicio metodo consultarPalabraClave ");
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<PalabraClaveInfoDTO> httpEntity = new HttpEntity<>(palabraClaveDto, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlPalabraClave, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			PalabraClaveInfoResponse PalabraClaveInfoResponse = mapper.convertValue(resp.getRespuesta(), PalabraClaveInfoResponse.class);
			log.info("Fin metodo consultarPalabraClave ");
			return new ResponseEntity<>(ResponseDto.builder().response(PalabraClaveInfoResponse).success(true)
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
