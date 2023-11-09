package com.camaradirecta.app.rues.exceptions;


import java.io.PrintWriter;
import java.io.StringWriter;

import com.google.gson.Gson;


/**
 * Clase creada para el manejo de respuesta de excepciones 
 * 
 * @author Jaime Andres Marino Londono
 *
 */
public class MessageResponse {
	private String code;
	private String titulo;
	private String mensaje;

	private Exception error;
	private String msgError;

	public MessageResponse() {
	}
	
	/**
	 * @param code
	 * @param titulo
	 * @param mensaje
	 * @param error
	 * @param msgError
	 */
	public MessageResponse(String code, String titulo, String mensaje, Exception error, String msgError) {
		this.code = code;
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.error = error;
		this.msgError = msgError;
	}



	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getMsgError() {
		return msgError;
	}

	public Exception getError() {
		return error;
	}

	public void setError(Exception ex) {
		if (ex instanceof ViException || ex instanceof ViGenericException) {
			error = new RuntimeException(ex.toString());
		} else {
			error = ex;
		}
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		error.printStackTrace(pw);
		setMsgError(sw.toString());
	}

	public void setMsgError(String err) {
		msgError = err;
	}

	public String toString() {
		return new Gson().toJson(this);
	}

}

