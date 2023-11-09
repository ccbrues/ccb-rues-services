package com.camaradirecta.app.rues.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;



public class ProcessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5580463001451993423L;
	protected HttpStatus status = null;
	protected final DataHeaderResponse dataHeaderResponse;
	protected final List<MessageResponse> erroresResponse;

	public ProcessException(String message) {
		super(message);
		this.dataHeaderResponse=new DataHeaderResponse();
		this.erroresResponse=new ArrayList<>();
	}
	
	public ProcessException(String message, Throwable cause, DataHeaderResponse dataHeaderResponse,
			List<MessageResponse> erroresResponse) {
		super(message,cause);
		this.dataHeaderResponse = dataHeaderResponse;
		this.erroresResponse = erroresResponse;
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
	
	public DataHeaderResponse getDataHeaderResponse() {
		return this.dataHeaderResponse;
	}
	
	public List<MessageResponse> getErroresResponse(){
		return this.erroresResponse;
	}

}

