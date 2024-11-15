
package com.camaradirecta.rue.MR01D;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.camaradirecta.rue.MR01D package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SolicitudLiquidacion_QNAME = new QName("urn:RUE:RUE_WebService", "solicitudLiquidacion");
    private final static QName _SolicitudLiquidacionResponse_QNAME = new QName("urn:RUE:RUE_WebService", "solicitudLiquidacionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.camaradirecta.rue.MR01D
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SolicitudLiquidacion }
     * 
     */
    public SolicitudLiquidacion createSolicitudLiquidacion() {
        return new SolicitudLiquidacion();
    }

    /**
     * Create an instance of {@link SolicitudLiquidacionResponse }
     * 
     */
    public SolicitudLiquidacionResponse createSolicitudLiquidacionResponse() {
        return new SolicitudLiquidacionResponse();
    }

    /**
     * Create an instance of {@link RueLiquidacionBC }
     * 
     */
    public RueLiquidacionBC createRueLiquidacionBC() {
        return new RueLiquidacionBC();
    }

    /**
     * Create an instance of {@link RueDetallesLiquidacionBC }
     * 
     */
    public RueDetallesLiquidacionBC createRueDetallesLiquidacionBC() {
        return new RueDetallesLiquidacionBC();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitudLiquidacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:RUE:RUE_WebService", name = "solicitudLiquidacion")
    public JAXBElement<SolicitudLiquidacion> createSolicitudLiquidacion(SolicitudLiquidacion value) {
        return new JAXBElement<SolicitudLiquidacion>(_SolicitudLiquidacion_QNAME, SolicitudLiquidacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitudLiquidacionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:RUE:RUE_WebService", name = "solicitudLiquidacionResponse")
    public JAXBElement<SolicitudLiquidacionResponse> createSolicitudLiquidacionResponse(SolicitudLiquidacionResponse value) {
        return new JAXBElement<SolicitudLiquidacionResponse>(_SolicitudLiquidacionResponse_QNAME, SolicitudLiquidacionResponse.class, null, value);
    }

}
