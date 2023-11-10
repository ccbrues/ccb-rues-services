package com.camaradirecta.app.rues.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NombreDetailResponse implements Serializable {
	
	public String codigo_clase_identificacion;
    public String desc_clase_identificacion;
    public String numero_identificacion;
    public String digito_verificacion;
    public String razon_social;
    public String sigla;
    public String codigo_camara;
    public String desc_camara;
    public String matricula;
    public String codigo_camara_proponente;
    public String desc_camara_proponente;
    public String inscripcion_proponente;
    public String codigo_tipo_sociedad;
    public String desc_tipo_sociedad;
    public String codigo_organizacion_juridica;
    public String desc_organizacion_juridica;
    public String codigo_categoria_matricula;
    public String desc_categoria_matricula;
    public String codigo_estado_matricula;
    public String desc_estado_matricula;
    public String codigo_estado_proponente;
    public String desc_estado_proponente;
    public int id_registro;
    public boolean indicador_rnt;
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getCodigo_clase_identificacion() {
		return codigo_clase_identificacion;
	}

	public void setCodigo_clase_identificacion(String codigo_clase_identificacion) {
		this.codigo_clase_identificacion = codigo_clase_identificacion;
	}

	public String getDesc_clase_identificacion() {
		return desc_clase_identificacion;
	}

	public void setDesc_clase_identificacion(String desc_clase_identificacion) {
		this.desc_clase_identificacion = desc_clase_identificacion;
	}

	public String getNumero_identificacion() {
		return numero_identificacion;
	}

	public void setNumero_identificacion(String numero_identificacion) {
		this.numero_identificacion = numero_identificacion;
	}

	public String getDigito_verificacion() {
		return digito_verificacion;
	}

	public void setDigito_verificacion(String digito_verificacion) {
		this.digito_verificacion = digito_verificacion;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCodigo_camara() {
		return codigo_camara;
	}

	public void setCodigo_camara(String codigo_camara) {
		this.codigo_camara = codigo_camara;
	}

	public String getDesc_camara() {
		return desc_camara;
	}

	public void setDesc_camara(String desc_camara) {
		this.desc_camara = desc_camara;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCodigo_camara_proponente() {
		return codigo_camara_proponente;
	}

	public void setCodigo_camara_proponente(String codigo_camara_proponente) {
		this.codigo_camara_proponente = codigo_camara_proponente;
	}

	public String getDesc_camara_proponente() {
		return desc_camara_proponente;
	}

	public void setDesc_camara_proponente(String desc_camara_proponente) {
		this.desc_camara_proponente = desc_camara_proponente;
	}

	public String getInscripcion_proponente() {
		return inscripcion_proponente;
	}

	public void setInscripcion_proponente(String inscripcion_proponente) {
		this.inscripcion_proponente = inscripcion_proponente;
	}

	public String getCodigo_tipo_sociedad() {
		return codigo_tipo_sociedad;
	}

	public void setCodigo_tipo_sociedad(String codigo_tipo_sociedad) {
		this.codigo_tipo_sociedad = codigo_tipo_sociedad;
	}

	public String getDesc_tipo_sociedad() {
		return desc_tipo_sociedad;
	}

	public void setDesc_tipo_sociedad(String desc_tipo_sociedad) {
		this.desc_tipo_sociedad = desc_tipo_sociedad;
	}

	public String getCodigo_organizacion_juridica() {
		return codigo_organizacion_juridica;
	}

	public void setCodigo_organizacion_juridica(String codigo_organizacion_juridica) {
		this.codigo_organizacion_juridica = codigo_organizacion_juridica;
	}

	public String getDesc_organizacion_juridica() {
		return desc_organizacion_juridica;
	}

	public void setDesc_organizacion_juridica(String desc_organizacion_juridica) {
		this.desc_organizacion_juridica = desc_organizacion_juridica;
	}

	public String getCodigo_categoria_matricula() {
		return codigo_categoria_matricula;
	}

	public void setCodigo_categoria_matricula(String codigo_categoria_matricula) {
		this.codigo_categoria_matricula = codigo_categoria_matricula;
	}

	public String getDesc_categoria_matricula() {
		return desc_categoria_matricula;
	}

	public void setDesc_categoria_matricula(String desc_categoria_matricula) {
		this.desc_categoria_matricula = desc_categoria_matricula;
	}

	public String getCodigo_estado_matricula() {
		return codigo_estado_matricula;
	}

	public void setCodigo_estado_matricula(String codigo_estado_matricula) {
		this.codigo_estado_matricula = codigo_estado_matricula;
	}

	public String getDesc_estado_matricula() {
		return desc_estado_matricula;
	}

	public void setDesc_estado_matricula(String desc_estado_matricula) {
		this.desc_estado_matricula = desc_estado_matricula;
	}

	public String getCodigo_estado_proponente() {
		return codigo_estado_proponente;
	}

	public void setCodigo_estado_proponente(String codigo_estado_proponente) {
		this.codigo_estado_proponente = codigo_estado_proponente;
	}

	public String getDesc_estado_proponente() {
		return desc_estado_proponente;
	}

	public void setDesc_estado_proponente(String desc_estado_proponente) {
		this.desc_estado_proponente = desc_estado_proponente;
	}

	public int getId_registro() {
		return id_registro;
	}

	public void setId_registro(int id_registro) {
		this.id_registro = id_registro;
	}

	public boolean isIndicador_rnt() {
		return indicador_rnt;
	}

	public void setIndicador_rnt(boolean indicador_rnt) {
		this.indicador_rnt = indicador_rnt;
	}

	
}
