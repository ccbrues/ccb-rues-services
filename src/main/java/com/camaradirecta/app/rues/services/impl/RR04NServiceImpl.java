package com.camaradirecta.app.rues.services.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.camaradirecta.app.rues.dtos.CertificadoInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.exceptions.ProcessException;
import com.camaradirecta.app.rues.response.CertificadoBasicResponse;
import com.camaradirecta.app.rues.response.ResponseGeneral;
import com.camaradirecta.app.rues.services.IRR04N;
import com.camaradirecta.app.rues.util.Constantes;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class RR04NServiceImpl implements IRR04N {
	
	private String strContenttype = "application/json";
	
	@Value("${com.camaradirecta.app.rues.RR04N.url-solicitud-certificado}")
	private String urlSolicitudCertificado;
	
	@Value("${com.camaradirecta.app.ubicacion.certificados}")
	private String ubicacionCertificado;
	
	@NonNull
	RestTemplate restTemplate = new RestTemplate();
	
	@NonNull
	TokenServiceImpl tokenServiceImpl;

	@Override
	@SuppressWarnings("rawtypes")
	public ResponseEntity<ResponseDto> solicitudCertificado(CertificadoInfoDTO certificadoInfoDTO) {
		log.info("Inicio metodo solicitudCertificado {}", new Gson().toJson(certificadoInfoDTO));
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.add(Constantes.CONTENTTYPE, strContenttype);
			headers.set(Constantes.AUTHORIZATION, this.getToken());
			HttpEntity<CertificadoInfoDTO> httpEntity = new HttpEntity<>(certificadoInfoDTO, headers);
			ResponseGeneral resp = restTemplate.postForObject(urlSolicitudCertificado, httpEntity, ResponseGeneral.class);
			ObjectMapper mapper = new ObjectMapper();
			CertificadoBasicResponse certificadoBasicResponse = mapper.convertValue(resp.getRespuesta(), CertificadoBasicResponse.class);
			validateCertificadoLink(certificadoBasicResponse);
			log.info("Fin metodo solicitudCertificado {}", mapper.writeValueAsString(certificadoBasicResponse));
			return new ResponseEntity<>(ResponseDto.builder().response(certificadoBasicResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		}catch (RestClientResponseException e) {
			log.error("Error solicitudCertificado {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()) , HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error solicitudCertificado {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error solicitudCertificado {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * @param certificadoBasicResponse
	 * @throws IOException
	 */
	private void validateCertificadoLink(CertificadoBasicResponse certificadoBasicResponse) throws IOException {
		log.info("Inicio metodo validateCertificadoLink {}", certificadoBasicResponse.getNumero_factura());
		if(Objects.nonNull(certificadoBasicResponse.getLink_certificado()) && Objects.isNull(certificadoBasicResponse.getTexto_certificado())) {
			String pathFile = ubicacionCertificado + "certificado-"+ certificadoBasicResponse.getReferencia_operacion() +  ".pdf";
			Path path = Paths.get(pathFile);
			String urlFile = certificadoBasicResponse.getLink_certificado().get(0).trim();
			log.info("urlFile {}", urlFile);
			try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
				HttpGet httpGet = new HttpGet(urlFile);
				httpClient.execute(httpGet, classicHttpResponse -> {
					int code = classicHttpResponse.getCode();
					if (code == 200) {
						org.apache.hc.core5.http.HttpEntity entity = classicHttpResponse.getEntity();
						if (entity != null) {
							try (InputStream inputStream = entity.getContent();
									FileOutputStream fileOutputStream = new FileOutputStream(pathFile)) {
								byte[] dataBuffer = new byte[1024];
								int bytesRead;
								while ((bytesRead = inputStream.read(dataBuffer)) != -1) {
									fileOutputStream.write(dataBuffer, 0, bytesRead);
								}
							}
						}
						EntityUtils.consume(entity);
					}
					return classicHttpResponse;
				});
				byte[] inFileBytes = Files.readAllBytes(path);
				byte[] encoded = org.apache.commons.codec.binary.Base64.encodeBase64(inFileBytes);
				certificadoBasicResponse.setTexto_certificado(new ArrayList<>(Arrays.asList(new String(encoded))));
				log.info("encoded: {}" , new String(encoded));
			}
		}
		log.info("Fin metodo validateCertificadoLink {}", certificadoBasicResponse.getNumero_factura());
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
