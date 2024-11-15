
package com.camaradirecta.rue.RR04N;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rueCertificadoBC complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rueCertificadoBC">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="camara_receptora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="camara_responsable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="caracteres_por_linea" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="clase_identificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigo_error" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigo_servicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desc_camara" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="digito_verificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha_generado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha_pago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha_respuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firma_digital" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firma_mecanica" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="forma_pago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hora_generado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hora_respuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mensaje_error" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numero_factura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numero_identificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numero_interno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referencia_operacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="texto_certificado" type="{urn:RUE:RUE_WebService}textoCertificado" minOccurs="0"/>
 *         &lt;element name="total_pagado" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rueCertificadoBC", propOrder = {
    "camaraReceptora",
    "camaraResponsable",
    "caracteresPorLinea",
    "claseIdentificacion",
    "codigoError",
    "codigoServicio",
    "descCamara",
    "digitoVerificacion",
    "fechaGenerado",
    "fechaPago",
    "fechaRespuesta",
    "firmaDigital",
    "firmaMecanica",
    "formaPago",
    "horaGenerado",
    "horaRespuesta",
    "mensajeError",
    "numeroFactura",
    "numeroIdentificacion",
    "numeroInterno",
    "referenciaOperacion",
    "textoCertificado",
    "totalPagado",
    "usuario"
})
public class RueCertificadoBC {

    @XmlElement(name = "camara_receptora")
    protected String camaraReceptora;
    @XmlElement(name = "camara_responsable")
    protected String camaraResponsable;
    @XmlElement(name = "caracteres_por_linea")
    protected int caracteresPorLinea;
    @XmlElement(name = "clase_identificacion")
    protected String claseIdentificacion;
    @XmlElement(name = "codigo_error")
    protected String codigoError;
    @XmlElement(name = "codigo_servicio")
    protected String codigoServicio;
    @XmlElement(name = "desc_camara")
    protected String descCamara;
    @XmlElement(name = "digito_verificacion")
    protected String digitoVerificacion;
    @XmlElement(name = "fecha_generado")
    protected String fechaGenerado;
    @XmlElement(name = "fecha_pago")
    protected String fechaPago;
    @XmlElement(name = "fecha_respuesta")
    protected String fechaRespuesta;
    @XmlElement(name = "firma_digital")
    protected String firmaDigital;
    @XmlElement(name = "firma_mecanica")
    protected String firmaMecanica;
    @XmlElement(name = "forma_pago")
    protected String formaPago;
    @XmlElement(name = "hora_generado")
    protected String horaGenerado;
    @XmlElement(name = "hora_respuesta")
    protected String horaRespuesta;
    @XmlElement(name = "mensaje_error")
    protected String mensajeError;
    @XmlElement(name = "numero_factura")
    protected String numeroFactura;
    @XmlElement(name = "numero_identificacion")
    protected String numeroIdentificacion;
    @XmlElement(name = "numero_interno")
    protected String numeroInterno;
    @XmlElement(name = "referencia_operacion")
    protected String referenciaOperacion;
    @XmlElement(name = "texto_certificado")
    protected TextoCertificado textoCertificado;
    @XmlElement(name = "total_pagado")
    protected BigDecimal totalPagado;
    protected String usuario;

    /**
     * Gets the value of the camaraReceptora property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCamaraReceptora() {
        return camaraReceptora;
    }

    /**
     * Sets the value of the camaraReceptora property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCamaraReceptora(String value) {
        this.camaraReceptora = value;
    }

    /**
     * Gets the value of the camaraResponsable property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCamaraResponsable() {
        return camaraResponsable;
    }

    /**
     * Sets the value of the camaraResponsable property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCamaraResponsable(String value) {
        this.camaraResponsable = value;
    }

    /**
     * Gets the value of the caracteresPorLinea property.
     * 
     */
    public int getCaracteresPorLinea() {
        return caracteresPorLinea;
    }

    /**
     * Sets the value of the caracteresPorLinea property.
     * 
     */
    public void setCaracteresPorLinea(int value) {
        this.caracteresPorLinea = value;
    }

    /**
     * Gets the value of the claseIdentificacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClaseIdentificacion() {
        return claseIdentificacion;
    }

    /**
     * Sets the value of the claseIdentificacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClaseIdentificacion(String value) {
        this.claseIdentificacion = value;
    }

    /**
     * Gets the value of the codigoError property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoError() {
        return codigoError;
    }

    /**
     * Sets the value of the codigoError property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoError(String value) {
        this.codigoError = value;
    }

    /**
     * Gets the value of the codigoServicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoServicio() {
        return codigoServicio;
    }

    /**
     * Sets the value of the codigoServicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoServicio(String value) {
        this.codigoServicio = value;
    }

    /**
     * Gets the value of the descCamara property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescCamara() {
        return descCamara;
    }

    /**
     * Sets the value of the descCamara property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescCamara(String value) {
        this.descCamara = value;
    }

    /**
     * Gets the value of the digitoVerificacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDigitoVerificacion() {
        return digitoVerificacion;
    }

    /**
     * Sets the value of the digitoVerificacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDigitoVerificacion(String value) {
        this.digitoVerificacion = value;
    }

    /**
     * Gets the value of the fechaGenerado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaGenerado() {
        return fechaGenerado;
    }

    /**
     * Sets the value of the fechaGenerado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaGenerado(String value) {
        this.fechaGenerado = value;
    }

    /**
     * Gets the value of the fechaPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaPago() {
        return fechaPago;
    }

    /**
     * Sets the value of the fechaPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaPago(String value) {
        this.fechaPago = value;
    }

    /**
     * Gets the value of the fechaRespuesta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaRespuesta() {
        return fechaRespuesta;
    }

    /**
     * Sets the value of the fechaRespuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaRespuesta(String value) {
        this.fechaRespuesta = value;
    }

    /**
     * Gets the value of the firmaDigital property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirmaDigital() {
        return firmaDigital;
    }

    /**
     * Sets the value of the firmaDigital property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirmaDigital(String value) {
        this.firmaDigital = value;
    }

    /**
     * Gets the value of the firmaMecanica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirmaMecanica() {
        return firmaMecanica;
    }

    /**
     * Sets the value of the firmaMecanica property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirmaMecanica(String value) {
        this.firmaMecanica = value;
    }

    /**
     * Gets the value of the formaPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Sets the value of the formaPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormaPago(String value) {
        this.formaPago = value;
    }

    /**
     * Gets the value of the horaGenerado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoraGenerado() {
        return horaGenerado;
    }

    /**
     * Sets the value of the horaGenerado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoraGenerado(String value) {
        this.horaGenerado = value;
    }

    /**
     * Gets the value of the horaRespuesta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoraRespuesta() {
        return horaRespuesta;
    }

    /**
     * Sets the value of the horaRespuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoraRespuesta(String value) {
        this.horaRespuesta = value;
    }

    /**
     * Gets the value of the mensajeError property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensajeError() {
        return mensajeError;
    }

    /**
     * Sets the value of the mensajeError property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensajeError(String value) {
        this.mensajeError = value;
    }

    /**
     * Gets the value of the numeroFactura property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroFactura() {
        return numeroFactura;
    }

    /**
     * Sets the value of the numeroFactura property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroFactura(String value) {
        this.numeroFactura = value;
    }

    /**
     * Gets the value of the numeroIdentificacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    /**
     * Sets the value of the numeroIdentificacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroIdentificacion(String value) {
        this.numeroIdentificacion = value;
    }

    /**
     * Gets the value of the numeroInterno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroInterno() {
        return numeroInterno;
    }

    /**
     * Sets the value of the numeroInterno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroInterno(String value) {
        this.numeroInterno = value;
    }

    /**
     * Gets the value of the referenciaOperacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenciaOperacion() {
        return referenciaOperacion;
    }

    /**
     * Sets the value of the referenciaOperacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenciaOperacion(String value) {
        this.referenciaOperacion = value;
    }

    /**
     * Gets the value of the textoCertificado property.
     * 
     * @return
     *     possible object is
     *     {@link TextoCertificado }
     *     
     */
    public TextoCertificado getTextoCertificado() {
        return textoCertificado;
    }

    /**
     * Sets the value of the textoCertificado property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextoCertificado }
     *     
     */
    public void setTextoCertificado(TextoCertificado value) {
        this.textoCertificado = value;
    }

    /**
     * Gets the value of the totalPagado property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTotalPagado() {
        return totalPagado;
    }

    /**
     * Sets the value of the totalPagado property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTotalPagado(BigDecimal value) {
        this.totalPagado = value;
    }

    /**
     * Gets the value of the usuario property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Sets the value of the usuario property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

}
