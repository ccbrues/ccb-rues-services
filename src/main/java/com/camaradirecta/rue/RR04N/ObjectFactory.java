
package com.camaradirecta.rue.RR04N;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.camaradirecta.rue.RR04N package. 
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

    private final static QName _SolicitudCertificadoResponse_QNAME = new QName("urn:RUE:RUE_WebService", "solicitudCertificadoResponse");
    private final static QName _SolicitudCertificado_QNAME = new QName("urn:RUE:RUE_WebService", "solicitudCertificado");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.camaradirecta.rue.RR04N
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SolicitudCertificadoResponse }
     * 
     */
    public SolicitudCertificadoResponse createSolicitudCertificadoResponse() {
        return new SolicitudCertificadoResponse();
    }

    /**
     * Create an instance of {@link SolicitudCertificado }
     * 
     */
    public SolicitudCertificado createSolicitudCertificado() {
        return new SolicitudCertificado();
    }

    /**
     * Create an instance of {@link TextoCertificado }
     * 
     */
    public TextoCertificado createTextoCertificado() {
        return new TextoCertificado();
    }

    /**
     * Create an instance of {@link RueRadicacionBC }
     * 
     */
    public RueRadicacionBC createRueRadicacionBC() {
        return new RueRadicacionBC();
    }

    /**
     * Create an instance of {@link RueCertificadoBC }
     * 
     */
    public RueCertificadoBC createRueCertificadoBC() {
        return new RueCertificadoBC();
    }

    /**
     * Create an instance of {@link RueDetallesLiquidacionBC }
     * 
     */
    public RueDetallesLiquidacionBC createRueDetallesLiquidacionBC() {
        return new RueDetallesLiquidacionBC();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitudCertificadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:RUE:RUE_WebService", name = "solicitudCertificadoResponse")
    public JAXBElement<SolicitudCertificadoResponse> createSolicitudCertificadoResponse(SolicitudCertificadoResponse value) {
        return new JAXBElement<SolicitudCertificadoResponse>(_SolicitudCertificadoResponse_QNAME, SolicitudCertificadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SolicitudCertificado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "urn:RUE:RUE_WebService", name = "solicitudCertificado")
    public JAXBElement<SolicitudCertificado> createSolicitudCertificado(SolicitudCertificado value) {
        return new JAXBElement<SolicitudCertificado>(_SolicitudCertificado_QNAME, SolicitudCertificado.class, null, value);
    }

}
