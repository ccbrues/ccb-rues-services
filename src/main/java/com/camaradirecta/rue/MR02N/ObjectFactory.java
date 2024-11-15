
package com.camaradirecta.rue.MR02N;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.camaradirecta.rue.MR02N package. 
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

    private final static QName _SolicitudRadicacion_QNAME = new QName("urn:RUE:RUE_WebService", "solicitudRadicacion");
    private final static QName _SolicitudRadicacionResponse_QNAME = new QName("urn:RUE:RUE_WebService", "solicitudRadicacionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.camaradirecta.rue.MR02N
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SolicitudRadicacion }
     * 
     */
    public SolicitudRadicacion createSolicitudRadicacion() {
        return new SolicitudRadicacion();
    }

    /**
     * Create an instance of {@link SolicitudRadicacionResponse }
     * 
     */
    public SolicitudRadicacionResponse createSolicitudRadicacionResponse() {
        return new SolicitudRadicacionResponse();
    }

    /**
     * Create an instance of {@link RueRadicacionBC }
     * 
     */
    public RueRadicacionBC createRueRadicacionBC() {
        return new RueRadicacionBC();
    }

    /**
     * Create an instance of {@link RueDetallesLiquidacionBC }
     * 
     */
    public RueDetallesLiquidacionBC createRueDetallesLiquidacionBC() {
        return new RueDetallesLiquidacionBC();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitudRadicacion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:RUE:RUE_WebService", name = "solicitudRadicacion")
    public JAXBElement<SolicitudRadicacion> createSolicitudRadicacion(SolicitudRadicacion value) {
        return new JAXBElement<SolicitudRadicacion>(_SolicitudRadicacion_QNAME, SolicitudRadicacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitudRadicacionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:RUE:RUE_WebService", name = "solicitudRadicacionResponse")
    public JAXBElement<SolicitudRadicacionResponse> createSolicitudRadicacionResponse(SolicitudRadicacionResponse value) {
        return new JAXBElement<SolicitudRadicacionResponse>(_SolicitudRadicacionResponse_QNAME, SolicitudRadicacionResponse.class, null, value);
    }

}
