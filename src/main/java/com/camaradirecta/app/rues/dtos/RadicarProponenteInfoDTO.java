package com.camaradirecta.app.rues.dtos;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RadicarProponenteInfoDTO implements Serializable{

	public String numero_interno;
    public String usuario;
    public String codigo_camara_proponente;
    public String inscripcion_proponente;
    public String codigo_camara_matricula;
    public String matricula;
    public String razon_social;
    public String nit;
    public String primer_apellido;
    public String segundo_apellido;
    public String primer_nombre;
    public String segundo_nombre;
    public String sigla;
    public String codigo_clase_identificacion;
    public String numero_identificacion;
    public String digito_verificacion;
    public String nacionalidad;
    public String autorizacion_datos;
    public String codigo_organizacion_juridica;
    public String municipio_comercial;
    public String direccion_comercial;
    public String telefono_comercial;
    public String telefono_comercial2;
    public String telefono_comercial3;
    public String apartado_aereo_comercial;
    public String correo_electronico_comercial;
    public String municipio_fiscal;
    public String direccion_fiscal;
    public String telefono_fiscal;
    public String telefono_fiscal2;
    public String telefono_fiscal3;
    public String apartado_aereo_fiscal;
    public String correo_electronico;
    public String codigo_estado_proponente;
    public String fecha_inscripcion;
    public String fecha_renovacion;
    public String fecha_cancelacion;
    public String tipo_documento_personeria_juridica;
    public String numero_documento_personeria_juridica;
    public String fecha_documento_personeria_juridica;
    public String origen_documento_personeria_juridica;
    public String fecha_constitucion;
    public String fecha_vencimiento;
    public String ubicacion_comercial;
    public String barrio_comercial;
    public String zona_comercial;
    public String direccion_notificacion;
    public String barrio_notificacion;
    public String municipio_notificacion;
    public String zona_notificacion;
    public String tipo_sede;
    public String codigo_tamano_empresa;
    public String facultades;
    
    @JsonProperty("representacion_legal") 
    public ArrayList<RepresentatesLegalesInfoDTO> representatesLegales;
    
    @JsonProperty("situaciones_control") 
    public ArrayList<SituacionesControlRUPDto> situacionesControl;
    
    @JsonProperty("informacion_financiera") 
    public InformacionFinancieraInfoDTO informacionFinanciera;
    
    @JsonProperty("clasificacion_unspsc")
    public ArrayList<String> clasificacion_unspsc;
    
    @JsonProperty("experiencia") 
    public ArrayList<ExperienciaInfoDTO> experiencia;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
