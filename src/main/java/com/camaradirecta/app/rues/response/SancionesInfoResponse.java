package com.camaradirecta.app.rues.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SancionesInfoResponse implements Serializable{
	
	public String numero_interno;
    public String usuario;
    public String cod_indicador_envio;
    public String nit_proponente;
    public String dv_proponente;
    public String nit_entidad;
    public String dv_entidad;
    public String municipio_entidad;
    public String numero_contrato;
    public String nombre_entidad;
    public String nombre_proponente;
    public String seccional_entidad;
    public String numero_acto_administrativo;
    public String fecha_acto_administrativo;
    public String numero_acto_ejecutoria;
    public String fecha_ejecutoria;
    public String descripcion_sancion;
    public String vigencia_sancion;
    public String fundamento_legal;
    public String condicion_incumplimiento;
    public String cod_estado;
    public String numero_acto_suspension;
    public String fecha_acto_suspension;
    public String numero_acto_confirmacion;
    public String fecha_acto_confirmacion;
    public String numero_acto_revocacion;
    public String fecha_acto_revocacion;
    public String observaciones;
    public String codigo_camara;
    public String codigo_libro_registro;
    public String numero_inscripcion_libro;
    public String fecha_inscripcion_camara;
    public String numero_contrato_secop;
    public Integer numero_radicacion_rue;
    public String fecha_radicacion_rue;
    public String hora_radicacion_rue;
    public String fecha_registro_inicial_rue;
    public String codigo_error;
    public String mensaje_error;
    public String fecha_respuesta;
    public String hora_respuesta;
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
