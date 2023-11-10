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
import com.camaradirecta.app.rues.dtos.RadicarProponenteInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.exceptions.ProcessException;
import com.camaradirecta.app.rues.response.RadicarProponenteInfoResponse;
import com.camaradirecta.app.rues.response.ResponseGeneral;
import com.camaradirecta.app.rues.services.IRR30N;
import com.camaradirecta.app.rues.util.Constantes;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RR30NServiceImpl implements IRR30N {
	
	private String strContenttype = "application/json";
	
	@Value("${com.camaradirecta.app.rues.RR30N.url-radicar-registro-proponente}")
	private String urlRegistroProponente;
	
	@NonNull
	RestTemplate restTemplate = new RestTemplate();
	
	@NonNull
	TokenServiceImpl tokenServiceImpl;
	
	@Override
	public ResponseEntity<ResponseDto> radicarRegistroProponente(RadicarProponenteInfoDTO radicarProponenteInfo) {
		log.info("Inicio metodo radicarRegistroProponente {}", radicarProponenteInfo.numero_interno);
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<RadicarProponenteInfoDTO> httpEntity = new HttpEntity<>(radicarProponenteInfo, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlRegistroProponente, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			RadicarProponenteInfoResponse radicarProponenteInfoResponse = mapper.convertValue(resp.getRespuesta(), RadicarProponenteInfoResponse.class);
			log.info("Fin metodo consultarPalabraClave {}", mapper.writeValueAsString(radicarProponenteInfoResponse));
			return new ResponseEntity<>(ResponseDto.builder().response(radicarProponenteInfoResponse).success(true)
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
