
package com.camaradirecta.rue.MR03N;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rueActualizacionEstadoBC complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rueActualizacionEstadoBC">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="anexos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigo_error" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="estado_transaccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha_respuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firma_digital" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hora_respuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mensaje_error" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numero_interno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "rueActualizacionEstadoBC", propOrder = {
    "anexos",
    "codigoError",
    "estado",
    "estadoTransaccion",
    "fechaRespuesta",
    "firmaDigital",
    "horaRespuesta",
    "mensajeError",
    "numeroInterno",
    "usuario"
})
public class RueActualizacionEstadoBC {

    protected String anexos;
    @XmlElement(name = "codigo_error")
    protected String codigoError;
    protected String estado;
    @XmlElement(name = "estado_transaccion")
    protected String estadoTransaccion;
    @XmlElement(name = "fecha_respuesta")
    protected String fechaRespuesta;
    @XmlElement(name = "firma_digital")
    protected String firmaDigital;
    @XmlElement(name = "hora_respuesta")
    protected String horaRespuesta;
    @XmlElement(name = "mensaje_error")
    protected String mensajeError;
    @XmlElement(name = "numero_interno")
    protected String numeroInterno;
    protected String usuario;

    /**
     * Gets the value of the anexos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnexos() {
        return anexos;
    }

    /**
     * Sets the value of the anexos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnexos(String value) {
        this.anexos = value;
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
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstado(String value) {
        this.estado = value;
    }

    /**
     * Gets the value of the estadoTransaccion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoTransaccion() {
        return estadoTransaccion;
    }

    /**
     * Sets the value of the estadoTransaccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoTransaccion(String value) {
        this.estadoTransaccion = value;
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
