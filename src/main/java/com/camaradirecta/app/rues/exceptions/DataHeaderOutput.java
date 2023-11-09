package com.camaradirecta.app.rues.exceptions;


import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.google.gson.Gson;

/**
 * @author felipegarcia
 *
 */

public class DataHeaderOutput implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 533857580609092550L;
	
	
	@Id
	private String id;
	private String nombreOperacion;
	private String total;
	private String caracterAceptacion;
	private String ultimoMensaje;
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
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}

	/**
	 * @return the caracterAceptacion
	 */
	public String getCaracterAceptacion() {
		return caracterAceptacion;
	}

	/**
	 * @param caracterAceptacion the caracterAceptacion to set
	 */
	public void setCaracterAceptacion(String caracterAceptacion) {
		this.caracterAceptacion = caracterAceptacion;
	}

	/**
	 * @return the ultimoMensaje
	 */
	public String getUltimoMensaje() {
		return ultimoMensaje;
	}

	/**
	 * @param ultimoMensaje the ultimoMensaje to set
	 */
	public void setUltimoMensaje(String ultimoMensaje) {
		this.ultimoMensaje = ultimoMensaje;
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
	
	public String toString()
	{  return new Gson().toJson(this); 
	}
	
	

}

