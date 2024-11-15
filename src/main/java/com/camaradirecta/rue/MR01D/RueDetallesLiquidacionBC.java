
package com.camaradirecta.rue.MR01D;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rueDetallesLiquidacionBC complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rueDetallesLiquidacionBC">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ano_renovacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cantidad_servicio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="codigo_servicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcion_servicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indicador_base" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indicador_renovacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="matricula_servicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombre_base" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nombre_matriculado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="orden_servicio" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="orden_servicio_asociado" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="valor_activos_sin_ajustes" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="valor_base" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="valor_liquidacion" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rueDetallesLiquidacionBC", propOrder = {
    "anoRenovacion",
    "cantidadServicio",
    "codigoServicio",
    "descripcionServicio",
    "indicadorBase",
    "indicadorRenovacion",
    "matriculaServicio",
    "nombreBase",
    "nombreMatriculado",
    "ordenServicio",
    "ordenServicioAsociado",
    "valorActivosSinAjustes",
    "valorBase",
    "valorLiquidacion"
})
public class RueDetallesLiquidacionBC {

    @XmlElement(name = "ano_renovacion")
    protected String anoRenovacion;
    @XmlElement(name = "cantidad_servicio")
    protected int cantidadServicio;
    @XmlElement(name = "codigo_servicio")
    protected String codigoServicio;
    @XmlElement(name = "descripcion_servicio")
    protected String descripcionServicio;
    @XmlElement(name = "indicador_base")
    protected String indicadorBase;
    @XmlElement(name = "indicador_renovacion")
    protected String indicadorRenovacion;
    @XmlElement(name = "matricula_servicio")
    protected String matriculaServicio;
    @XmlElement(name = "nombre_base")
    protected String nombreBase;
    @XmlElement(name = "nombre_matriculado")
    protected String nombreMatriculado;
    @XmlElement(name = "orden_servicio")
    protected int ordenServicio;
    @XmlElement(name = "orden_servicio_asociado")
    protected int ordenServicioAsociado;
    @XmlElement(name = "valor_activos_sin_ajustes")
    protected BigDecimal valorActivosSinAjustes;
    @XmlElement(name = "valor_base")
    protected BigDecimal valorBase;
    @XmlElement(name = "valor_liquidacion")
    protected BigDecimal valorLiquidacion;

    /**
     * Gets the value of the anoRenovacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAnoRenovacion() {
        return anoRenovacion;
    }

    /**
     * Sets the value of the anoRenovacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAnoRenovacion(String value) {
        this.anoRenovacion = value;
    }

    /**
     * Gets the value of the cantidadServicio property.
     * 
     */
    public int getCantidadServicio() {
        return cantidadServicio;
    }

    /**
     * Sets the value of the cantidadServicio property.
     * 
     */
    public void setCantidadServicio(int value) {
        this.cantidadServicio = value;
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
     * Gets the value of the descripcionServicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcionServicio() {
        return descripcionServicio;
    }

    /**
     * Sets the value of the descripcionServicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcionServicio(String value) {
        this.descripcionServicio = value;
    }

    /**
     * Gets the value of the indicadorBase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicadorBase() {
        return indicadorBase;
    }

    /**
     * Sets the value of the indicadorBase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicadorBase(String value) {
        this.indicadorBase = value;
    }

    /**
     * Gets the value of the indicadorRenovacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndicadorRenovacion() {
        return indicadorRenovacion;
    }

    /**
     * Sets the value of the indicadorRenovacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndicadorRenovacion(String value) {
        this.indicadorRenovacion = value;
    }

    /**
     * Gets the value of the matriculaServicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatriculaServicio() {
        return matriculaServicio;
    }

    /**
     * Sets the value of the matriculaServicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatriculaServicio(String value) {
        this.matriculaServicio = value;
    }

    /**
     * Gets the value of the nombreBase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreBase() {
        return nombreBase;
    }

    /**
     * Sets the value of the nombreBase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreBase(String value) {
        this.nombreBase = value;
    }

    /**
     * Gets the value of the nombreMatriculado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreMatriculado() {
        return nombreMatriculado;
    }

    /**
     * Sets the value of the nombreMatriculado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreMatriculado(String value) {
        this.nombreMatriculado = value;
    }

    /**
     * Gets the value of the ordenServicio property.
     * 
     */
    public int getOrdenServicio() {
        return ordenServicio;
    }

    /**
     * Sets the value of the ordenServicio property.
     * 
     */
    public void setOrdenServicio(int value) {
        this.ordenServicio = value;
    }

    /**
     * Gets the value of the ordenServicioAsociado property.
     * 
     */
    public int getOrdenServicioAsociado() {
        return ordenServicioAsociado;
    }

    /**
     * Sets the value of the ordenServicioAsociado property.
     * 
     */
    public void setOrdenServicioAsociado(int value) {
        this.ordenServicioAsociado = value;
    }

    /**
     * Gets the value of the valorActivosSinAjustes property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorActivosSinAjustes() {
        return valorActivosSinAjustes;
    }

    /**
     * Sets the value of the valorActivosSinAjustes property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorActivosSinAjustes(BigDecimal value) {
        this.valorActivosSinAjustes = value;
    }

    /**
     * Gets the value of the valorBase property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorBase() {
        return valorBase;
    }

    /**
     * Sets the value of the valorBase property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorBase(BigDecimal value) {
        this.valorBase = value;
    }

    /**
     * Gets the value of the valorLiquidacion property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorLiquidacion() {
        return valorLiquidacion;
    }

    /**
     * Sets the value of the valorLiquidacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorLiquidacion(BigDecimal value) {
        this.valorLiquidacion = value;
    }

}
