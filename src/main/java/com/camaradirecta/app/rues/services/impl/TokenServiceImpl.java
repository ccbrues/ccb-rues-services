package com.camaradirecta.app.rues.services.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.services.ITokenService;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class TokenServiceImpl implements ITokenService{
	
	private static final String CONTENTTYPE = "Content-Type";
	
	@Value("${com.camaradirecta.app.rues.token.username}")
	private String username;
	
	@Value("${com.camaradirecta.app.rues.token.password}")
	private String password;
	
	@Value("${com.camaradirecta.app.rues.token.grant_type}")
	private String grantType;
	
	@Value("${com.camaradirecta.app.rues.token.url}")
	private String urlToken;
	
	private String strContenttype = "application/x-www-form-urlencoded";
	
	@NonNull
	RestTemplate restTemplate = new RestTemplate();

	@Override
	@SuppressWarnings("unchecked")
	public ResponseEntity<ResponseDto> getToken() {
		log.info("Inicio metodo getToken ");
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(CONTENTTYPE, strContenttype);
			
			MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
			params.add("username", this.username);
			params.add("password", this.password);
			params.add("grant_type", this.grantType);
			log.info("objeto {}" ,params);
			HttpEntity<Object> httpEntity = new HttpEntity<>(params, headers);
			Map<String, Object> resp = (Map<String, Object>) restTemplate.postForObject(urlToken, httpEntity, Object.class);
			String tokenResponse = (String) resp.get("access_token");
			log.info("Fin metodo getToken {}",tokenResponse );
			return new ResponseEntity<>(ResponseDto.builder().response(tokenResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		}catch (RestClientResponseException e) {
			log.error("Error getToken {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()) , HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error getToken {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error getToken {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
