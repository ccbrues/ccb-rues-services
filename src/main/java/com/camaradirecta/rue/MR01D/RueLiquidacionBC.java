
package com.camaradirecta.rue.MR01D;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rueLiquidacionBC complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rueLiquidacionBC">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="camara_destino" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="camara_receptora" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigo_error" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="empleados" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha_documento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha_respuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firma_digital" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hora_respuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indicador_beneficio" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="indicador_origen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inscripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="matricula" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mensaje_error" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numero_interno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="origen_documento" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="servicios" type="{urn:RUE:RUE_WebService}rueDetallesLiquidacionBC" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "rueLiquidacionBC", propOrder = {
    "camaraDestino",
    "camaraReceptora",
    "codigoError",
    "empleados",
    "estado",
    "fechaDocumento",
    "fechaRespuesta",
    "firmaDigital",
    "horaRespuesta",
    "indicadorBeneficio",
    "indicadorOrigen",
    "inscripcion",
    "matricula",
    "mensajeError",
    "numeroInterno",
    "origenDocumento",
    "servicios",
    "usuario"
})
public class RueLiquidacionBC {

    @XmlElement(name = "camara_destino")
    protected String camaraDestino;
    @XmlElement(name = "camara_receptora")
    protected String camaraReceptora;
    @XmlElement(name = "codigo_error")
    protected String codigoError;
    protected Integer empleados;
    protected String estado;
    @XmlElement(name = "fecha_documento")
    protected String fechaDocumento;
    @XmlElement(name = "fecha_respuesta")
    protected String fechaRespuesta;
    @XmlElement(name = "firma_digital")
    protected String firmaDigital;
    @XmlElement(name = "hora_respuesta")
    protected String horaRespuesta;
    @XmlElement(name = "indicador_beneficio")
    protected Integer indicadorBeneficio;
    @XmlElement(name = "indicador_origen")
    protected String indicadorOrigen;
    protected String inscripcion;
    protected String matricula;
    @XmlElement(name = "mensaje_error")
    protected String mensajeError;
    @XmlElement(name = "numero_interno")
    protected String numeroInterno;
    @XmlElement(name = "origen_documento")
    protected String origenDocumento;
    @XmlElement(nillable = true)
    protected List<RueDetallesLiquidacionBC> servicios;
    protected String usuario;

    /**
     * Gets the value of the camaraDestino property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCamaraDestino() {
        return camaraDestino;
    }

    /**
     * Sets the value of the camaraDestino property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCamaraDestino(String value) {
        this.camaraDestino = value;
    }

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
     * Gets the value of the empleados property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getEmpleados() {
        return empleados;
    }

    /**
     * Sets the value of the empleados property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setEmpleados(Integer value) {
        this.empleados = value;
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
     * Gets the value of the fechaDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaDocumento() {
        return fechaDocumento;
    }

    /**
     * Sets the value of the fechaDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaDocumento(String value) {
        this.fechaDocumento = value;
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
     * Gets the value of the indicadorBeneficio property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIndicadorBeneficio() {
        return indicadorBeneficio;
    }

    /**
     * Sets the value of the indicadorBeneficio property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIndicadorBeneficio(Integer value) {
        this.indicadorBeneficio = value;
    }

    /**
     * Gets the value of the indicadorOrigen property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicadorOrigen() {
        return indicadorOrigen;
    }

    /**
     * Sets the value of the indicadorOrigen property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicadorOrigen(String value) {
        this.indicadorOrigen = value;
    }

    /**
     * Gets the value of the inscripcion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInscripcion() {
        return inscripcion;
    }

    /**
     * Sets the value of the inscripcion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInscripcion(String value) {
        this.inscripcion = value;
    }

    /**
     * Gets the value of the matricula property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Sets the value of the matricula property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatricula(String value) {
        this.matricula = value;
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
     * Gets the value of the origenDocumento property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigenDocumento() {
        return origenDocumento;
    }

    /**
     * Sets the value of the origenDocumento property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigenDocumento(String value) {
        this.origenDocumento = value;
    }

    /**
     * Gets the value of the servicios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the servicios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServicios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RueDetallesLiquidacionBC }
     * 
     * 
     */
    public List<RueDetallesLiquidacionBC> getServicios() {
        if (servicios == null) {
            servicios = new ArrayList<RueDetallesLiquidacionBC>();
        }
        return this.servicios;
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
