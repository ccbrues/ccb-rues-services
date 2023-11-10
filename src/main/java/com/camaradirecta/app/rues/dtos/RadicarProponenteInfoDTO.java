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
    public int codigo_camara_proponente;
    public String inscripcion_proponente;
    public String matricula;
    public String razon_social;
    public String nit;
    public Object primer_apellido;
    public Object segundo_apellido;
    public Object primer_nombre;
    public Object segundo_nombre;
    public Object sigla;
    public String codigo_clase_identificacion;
    public String numero_identificacion;
    public String digito_verificacion;
    public String nacionalidad;
    public String autorizacion_datos;
    public String municipio_comercial;
    public String direccion_comercial;
    public String telefono_comercial;
    public Object telefono_comercial2;
    public Object telefono_comercial3;
    public Object fax_comercial;
    public Object apartado_aereo_comercial;
    public String correo_electronico_comercial;
    public String municipio_fiscal;
    public String direccion_fiscal;
    public String telefono_fiscal;
    public Object telefono_fiscal2;
    public Object telefono_fiscal3;
    public Object fax_fiscal;
    public Object apartado_aereo_fiscal;
    public String correo_electronico;
    public String codigo_estado_proponente;
    public String fecha_inscripcion;
    public String fecha_renovacion;
    public String fecha_cancelacion;
    public String multas;
    public String sanciones;
    public String codigo_tamano_empresa;
    public String facultades;
    @JsonProperty("InformacionFinanciera") 
    public InformacionFinancieraInfoDTO informacionFinanciera;
    @JsonProperty("RepresentatesLegales") 
    public ArrayList<RepresentatesLegalesInfoDTO> representatesLegales;
    @JsonProperty("EmpresarialSituacionesControl") 
    public ArrayList<SituacionesControlInfoDTO> empresarialSituacionesControl;
    @JsonProperty("Experiencia") 
    public ArrayList<ExperienciaInfoDTO> experiencia;
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
