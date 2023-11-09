package com.camaradirecta.app.rues.exceptions;


import java.util.List;

import org.springframework.http.HttpStatus;


/**
 * Clase de excepciones generales que extiende de la clase {@link Exception}
 * @author Jaime Andres Marino Londono
 *
 */
public class ViException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5030557451956825606L;
	
	protected final DataHeaderResponse dataHeaderResponse;
	protected final List<MessageResponse> erroresResponse;
	protected HttpStatus status = null;
	
	public ViException(String message, Throwable cause, DataHeaderResponse dataHeaderResponse, List<MessageResponse> erroresResponse) {
		super(message, cause);
		this.dataHeaderResponse = dataHeaderResponse;
		this.erroresResponse = erroresResponse;
	}

	/**
	 * @return the dataHeaderResponse
	 */
	public DataHeaderResponse getDataHeaderResponse() {
		return dataHeaderResponse;
	}

	/**
	 * @return the erroresResponse
	 */
	public List<MessageResponse> getErroresResponse() {
		return erroresResponse;
	}
	
	public HttpStatus getStatus() {
		return this.status;
	}
	
	public Integer getStatusCode() {
		return this.status.value();
	}
	
	public String getStatusMessage() {
		return this.status.name();
	}
}

