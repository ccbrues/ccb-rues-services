
package com.camaradirecta.rue.MR03N;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for solicitudActualizacionEstado complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="solicitudActualizacionEstado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{urn:RUE:RUE_WebService}rueActualizacionEstadoBC" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solicitudActualizacionEstado", propOrder = {
    "arg0"
})
public class SolicitudActualizacionEstado {

    protected RueActualizacionEstadoBC arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link RueActualizacionEstadoBC }
     *     
     */
    public RueActualizacionEstadoBC getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link RueActualizacionEstadoBC }
     *     
     */
    public void setArg0(RueActualizacionEstadoBC value) {
        this.arg0 = value;
    }

}
