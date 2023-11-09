package com.camaradirecta.app.rues.exceptions;


import java.io.Serializable;
import com.google.gson.Gson;
import lombok.Builder;

/**
 * Se crea clase estándar de respeusta para el manejo de errores
 * 
 * @author Jaime Andres Marino Londono
 *
 */
@Builder
public class DataHeaderResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 533857580609092550L;

	private String id;
	private String nombreOperacion;
	private String codMsgRespuesta;
	private String msgRespuesta;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nombreOperacion
	 */
	public String getNombreOperacion() {
		return nombreOperacion;
	}

	/**
	 * @param nombreOperacion the nombreOperacion to set
	 */
	public void setNombreOperacion(String nombreOperacion) {
		this.nombreOperacion = nombreOperacion;
	}

	/**
	 * @return the codMsgRespuesta
	 */
	public String getCodMsgRespuesta() {
		return codMsgRespuesta;
	}

	/**
	 * @param codMsgRespuesta the codMsgRespuesta to set
	 */
	public void setCodMsgRespuesta(String codMsgRespuesta) {
		this.codMsgRespuesta = codMsgRespuesta;
	}

	/**
	 * @return the msgRespuesta
	 */
	public String getMsgRespuesta() {
		return msgRespuesta;
	}

	/**
	 * @param msgRespuesta the msgRespuesta to set
	 */
	public void setMsgRespuesta(String msgRespuesta) {
		this.msgRespuesta = msgRespuesta;
	}
	
	/**
	 * Constructor genérico 
	 */
	public DataHeaderResponse() {
	}
	
	

	/**
	 * Constructor para respuestas genéricas
	 * 
	 * @param id Código del mensaje
	 * @param nombreOperacion Nombre de operación o método
	 * @param codMsgRespuesta Código de mensaje de respuesta
	 * @param msgRespuesta Mensaje de respuesta
	 */
	public DataHeaderResponse(String id, String nombreOperacion, String codMsgRespuesta, String msgRespuesta) {
		this.id = id;
		this.nombreOperacion = nombreOperacion;
		this.codMsgRespuesta = codMsgRespuesta;
		this.msgRespuesta = msgRespuesta;
	}

	public DataHeaderOutput convertToDataHeaderOutput() {
		DataHeaderOutput data = new DataHeaderOutput();
		data.setId(id);
		data.setNombreOperacion(nombreOperacion);
		data.setCodMsgRespuesta(codMsgRespuesta);
		data.setMsgRespuesta(msgRespuesta);
		return data;
	}

	public String toString() {
		return new Gson().toJson(this);
	}

}
