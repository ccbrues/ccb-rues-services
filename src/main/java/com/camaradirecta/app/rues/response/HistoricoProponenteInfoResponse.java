package com.camaradirecta.app.rues.response;

import java.io.Serializable;
import java.util.ArrayList;

public class HistoricoProponenteInfoResponse implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String numero_interno;
    public String usuario;
    public String nit_proponente;
    public String dv_proponente;
    public ArrayList<ContratoInfoResponse> contratos;
    public ArrayList<MultaInfoResponse> multas;
    public ArrayList<SancionesInfoResponse> sanciones;
    public String codigo_error;
    public String mensaje_error;
    public String fecha_respuesta;
    public String hora_respuesta;

}
