package com.camaradirecta.app.rues.exceptions;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

/**
 * Clase genérica de excepciones 
 * 
 * @author Jaime Andres Marino Londono
 *
 */
@ResponseStatus(value = HttpStatus.OK)
@Slf4j
public class ViGenericException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2520508680687072923L;

	private final DataHeaderResponse dataHeaderResponse;
	private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
	protected List<MessageResponse> erroresResponse;

	public ViGenericException(DataHeaderResponse dataHeaderResponse, List<MessageResponse> erroresResponse) {
		super();
		this.dataHeaderResponse = dataHeaderResponse;
		this.erroresResponse = erroresResponse;
	}

	public ViGenericException(String message, Throwable cause, DataHeaderResponse dataHeaderResponse,
			List<MessageResponse> erroresResponse) {
		super(message, cause);
		this.dataHeaderResponse = dataHeaderResponse;
		this.erroresResponse = erroresResponse;
	}

	public ViGenericException(String message, DataHeaderResponse dataHeaderResponse,
			List<MessageResponse> erroresResponse) {
		super(message);
		this.dataHeaderResponse = dataHeaderResponse;
		this.erroresResponse = erroresResponse;
	}

	public ViGenericException(Throwable cause, DataHeaderResponse dataHeaderResponse,
			List<MessageResponse> erroresResponse) {
		super(cause);
		this.dataHeaderResponse = dataHeaderResponse;
		this.erroresResponse = erroresResponse;
	}

	public ViGenericException(DataHeaderResponse dataHeaderResponse, HttpStatus httpStatus,
			List<MessageResponse> erroresResponse) {
		super();
		this.dataHeaderResponse = dataHeaderResponse;
		this.httpStatus = httpStatus;
		this.erroresResponse = erroresResponse;
	}

	public ViGenericException(String message, Throwable cause, DataHeaderResponse dataHeaderResponse,
			HttpStatus httpStatus, List<MessageResponse> erroresResponse) {
		super(message, cause);
		this.dataHeaderResponse = dataHeaderResponse;
		this.httpStatus = httpStatus;
		this.erroresResponse = erroresResponse;
	}

	public ViGenericException(String message, DataHeaderResponse dataHeaderResponse, HttpStatus httpStatus,
			List<MessageResponse> erroresResponse) {
		super(message);
		this.dataHeaderResponse = dataHeaderResponse;
		this.httpStatus = httpStatus;
		this.erroresResponse = erroresResponse;
	}

	public ViGenericException(Throwable cause, DataHeaderResponse dataHeaderResponse, HttpStatus httpStatus,
			List<MessageResponse> erroresResponse) {
		super(cause);
		this.dataHeaderResponse = dataHeaderResponse;
		this.httpStatus = httpStatus;
		this.erroresResponse = erroresResponse;
	}

	public ViGenericException(DataHeaderResponse dataHeaderResponse) {
		super();
		this.dataHeaderResponse = dataHeaderResponse;
		this.erroresResponse = new ArrayList<>();
		mapError(dataHeaderResponse);
	}

	public ViGenericException(String message, Throwable cause, DataHeaderResponse dataHeaderResponse) {
		super(message, cause);
		this.dataHeaderResponse = dataHeaderResponse;
		this.erroresResponse = new ArrayList<>();
		mapError(dataHeaderResponse);
	}

	public ViGenericException(String message, DataHeaderResponse dataHeaderResponse) {
		super(message);
		this.dataHeaderResponse = dataHeaderResponse;
		this.erroresResponse = new ArrayList<>();
		mapError(dataHeaderResponse);
	}

	public ViGenericException(Throwable cause, DataHeaderResponse dataHeaderResponse) {
		super(cause);
		this.dataHeaderResponse = dataHeaderResponse;
		this.erroresResponse = new ArrayList<>();
		mapError(dataHeaderResponse);
	}

	public ViGenericException(DataHeaderResponse dataHeaderResponse, HttpStatus httpStatus) {
		super();
		this.dataHeaderResponse = dataHeaderResponse;
		this.erroresResponse = new ArrayList<>();
		this.httpStatus = httpStatus;
		mapError(dataHeaderResponse);
	}

	public ViGenericException(String message, Throwable cause, DataHeaderResponse dataHeaderResponse,
			HttpStatus httpStatus) {
		super(message, cause);
		this.dataHeaderResponse = dataHeaderResponse;
		this.erroresResponse = new ArrayList<>();
		this.httpStatus = httpStatus;
		mapError(dataHeaderResponse);
	}

	public ViGenericException(String message, DataHeaderResponse dataHeaderResponse, HttpStatus httpStatus) {
		super(message);
		this.dataHeaderResponse = dataHeaderResponse;
		this.erroresResponse = new ArrayList<>();
		this.httpStatus = httpStatus;
		mapError(dataHeaderResponse);
	}

	public ViGenericException(Throwable cause, DataHeaderResponse dataHeaderResponse, HttpStatus httpStatus) {
		super(cause);
		this.dataHeaderResponse = dataHeaderResponse;
		this.erroresResponse = new ArrayList<>();
		this.httpStatus = httpStatus;
		mapError(dataHeaderResponse);
	}

	public ViGenericException(String string, IncorrectResultSizeDataAccessException ex1) {
		super(ex1);
		this.dataHeaderResponse = new DataHeaderResponse();
		dataHeaderResponse.setCodMsgRespuesta("9999");
		dataHeaderResponse.setMsgRespuesta(string);
		this.erroresResponse = new ArrayList<>();
		this.erroresResponse.add(new MessageResponse("9999_General", string, ex1.getLocalizedMessage(), ex1, Arrays.toString(ex1.getStackTrace())));
		mapError(dataHeaderResponse);
	}
	
	public ViGenericException(String string, Exception ex1) {
		super(ex1);
		this.dataHeaderResponse = new DataHeaderResponse();
		dataHeaderResponse.setCodMsgRespuesta("9999");
		dataHeaderResponse.setMsgRespuesta(string);
		this.erroresResponse = new ArrayList<>();
		this.erroresResponse.add(new MessageResponse("9999_General", string, ex1.getLocalizedMessage(), ex1, Arrays.toString(ex1.getStackTrace())));
		mapError(dataHeaderResponse);
	}

	/**
	 * @return the dataHeaderResponse
	 */
	public DataHeaderResponse getDataHeaderResponse() {
		return dataHeaderResponse;
	}

	/**
	 * @return the httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @param dataHeaderResponse
	 */
	private void mapError(DataHeaderResponse dataHeaderResponse) {
		MessageResponse errorResponse = new MessageResponse();
		errorResponse.setCode(dataHeaderResponse.getCodMsgRespuesta());
		errorResponse.setMensaje(dataHeaderResponse.getMsgRespuesta());
		List<MessageResponse> errores = new ArrayList<>();
		errores.add(errorResponse);
		this.erroresResponse = errores;
		log.error((new Gson()).toJson(erroresResponse));
	}

	/**
	 * @return the erroresResponse
	 */
	public List<MessageResponse> getErroresResponse() {
		return erroresResponse;
	}

	/**
	 * @param erroresResponse the erroresResponse to set
	 */
	public void setErroresResponse(List<MessageResponse> erroresResponse) {
		this.erroresResponse = erroresResponse;
	}

	/**
	 * @param httpStatus the httpStatus to set
	 */
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}

