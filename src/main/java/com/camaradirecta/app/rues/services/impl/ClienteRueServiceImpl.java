package com.camaradirecta.app.rues.services.impl;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

import javax.xml.rpc.ServiceException;
import javax.xml.ws.BindingProvider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;

import com.camaradirecta.app.rues.dtos.ActualizacionEstadoInfoDTO;
import com.camaradirecta.app.rues.dtos.CertificadoInfoDTO;
import com.camaradirecta.app.rues.dtos.CertificadoServicioInfoDTO;
import com.camaradirecta.app.rues.dtos.LiquidacionInfoRueDTO;
import com.camaradirecta.app.rues.dtos.LiquidacionServicioInfoDTO;
import com.camaradirecta.app.rues.dtos.RadicacionInfoDTO;
import com.camaradirecta.app.rues.dtos.RadicacionServicioInfoDTO;
import com.camaradirecta.app.rues.dtos.ResponseDto;
import com.camaradirecta.app.rues.response.ActualizacionEstadoInfoResponse;
import com.camaradirecta.app.rues.response.CertificadoRueResponse;
import com.camaradirecta.app.rues.response.FirmaDigitalResponse;
import com.camaradirecta.app.rues.response.LiquidacionDetalleResponse;
import com.camaradirecta.app.rues.response.LiquidacionInfoResponse;
import com.camaradirecta.app.rues.response.RadicacionInfoResponse;
import com.camaradirecta.app.rues.response.RadicacionRueResponse;
import com.camaradirecta.app.rues.response.RueCertificadoResponse;
import com.camaradirecta.app.rues.services.IClienteRue;
import com.camaradirecta.rue.MR01D.MR01D;
import com.camaradirecta.rue.MR01D.MR01DDelegate;
import com.camaradirecta.rue.MR01D.RueDetallesLiquidacionBC;
import com.camaradirecta.rue.MR01D.RueLiquidacionBC;
import com.camaradirecta.rue.MR02N.MR02N;
import com.camaradirecta.rue.MR02N.MR02NDelegate;
import com.camaradirecta.rue.MR02N.RueRadicacionBC;
import com.camaradirecta.rue.MR03N.MR03N;
import com.camaradirecta.rue.MR03N.MR03NDelegate;
import com.camaradirecta.rue.MR03N.RueActualizacionEstadoBC;
import com.camaradirecta.rue.RR04N.RR04N;
import com.camaradirecta.rue.RR04N.RR04NDelegate;
import com.camaradirecta.rue.RR04N.RueCertificadoBC;
import com.camaradirecta.rue.RR04N.TextoCertificado;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteRueServiceImpl implements IClienteRue {

	@Value("${com.camaradirecta.app.rues.service.url-service-MR03N}")
	private String urlSolicitudActEstadoMR03N;

	@Value("${com.camaradirecta.app.rues.service.url-service-MR01D}")
	private String urlSolicitudLiquidacionMR01D;

	@Value("${com.camaradirecta.app.rues.service.url-service-MR02N}")
	private String urlSolicitudRadicacionMR02N;
	
	@Value("${com.camaradirecta.app.rues.service.url-service-RR04N}")
	private String urlSolicitudCertificadoRR04N;

	private String CAMARA = "05";

	@Override
	public ResponseEntity<ResponseDto> solicitudRUEActualizacionEstado(
			ActualizacionEstadoInfoDTO actualizacionEstadoInfoDTO) {
		log.info("Inicio metodo solicitudRUEActualizacionEstado {}", new Gson().toJson(actualizacionEstadoInfoDTO));
		try {
			String usuario = actualizacionEstadoInfoDTO.getUsuario();
			String nroInterno = actualizacionEstadoInfoDTO.getNumero_interno();
			String estadoTransaccion = actualizacionEstadoInfoDTO.getEstado_transaccion();
			String anexos = actualizacionEstadoInfoDTO.getAnexos();
			String[] estado = new String[1];
			String[] error = new String[2];
			RueActualizacionEstadoBC response = actualizacionEstado(usuario, nroInterno, estadoTransaccion, anexos,
					estado, urlSolicitudActEstadoMR03N, error);
			ActualizacionEstadoInfoResponse actualizacionEstadoInfoResponse = mappingActualizacionEstado(response);
			return new ResponseEntity<>(ResponseDto.builder().response(actualizacionEstadoInfoResponse).success(true)
					.message(HttpStatus.OK.name()).code(HttpStatus.OK.value()).build(), HttpStatus.OK);
		} catch (RestClientResponseException e) {
			log.error("Error solicitudRUEActualizacionEstado {},{}", e.getLocalizedMessage(),
					e.getResponseBodyAsString());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error solicitudRUEActualizacionEstado {}", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error solicitudRUEActualizacionEstado {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<LiquidacionInfoResponse> solicitudRUELiquidacion(LiquidacionInfoRueDTO liquidacionInfoRueDTO) {
		log.info("Inicio metodo solicitudRUELiquidacion {}", new Gson().toJson(liquidacionInfoRueDTO));
		try {
			String usuario = liquidacionInfoRueDTO.getUsuario();
			String nroInterno = liquidacionInfoRueDTO.getNumero_interno();
			String camaraDestino = liquidacionInfoRueDTO.getCamara_destino();
			String camaraReceptora = liquidacionInfoRueDTO.getCamara_receptora();
			String matricula = liquidacionInfoRueDTO.getMatricula();
			String registro = liquidacionInfoRueDTO.getInscripcion();
			String origenDocumento = liquidacionInfoRueDTO.getOrigen_documento();
			String fechaDocumento = liquidacionInfoRueDTO.getFecha_documento();
			String indicadorOrigen = "S";
			String empleados = (Objects.isNull(liquidacionInfoRueDTO.getEmpleados()) ? "0"
					: String.valueOf(liquidacionInfoRueDTO.getEmpleados()));
			String indicadorBeneficio = (Objects.isNull(liquidacionInfoRueDTO.getIndicador_beneficio()) ? "0"
					: String.valueOf(liquidacionInfoRueDTO.getIndicador_beneficio()));

			List<RueDetallesLiquidacionBC> servicios = mappingDetalleLiquidacion(liquidacionInfoRueDTO.getServicios());
			String estado[] = new String[1];
			String error[] = new String[2];
			estado[0] = liquidacionInfoRueDTO.getEstado();
			RueLiquidacionBC rueLiquidacion = solicitudLiquidacion(usuario, nroInterno, camaraDestino, camaraReceptora,
					matricula, registro, origenDocumento, fechaDocumento, indicadorOrigen, empleados,
					indicadorBeneficio, estado, servicios, urlSolicitudLiquidacionMR01D, error);
			LiquidacionInfoResponse liquidacionResponse = mappingLiquidacionDetalleRespose(rueLiquidacion);
			return new ResponseEntity<>(liquidacionResponse, HttpStatus.OK);
		} catch (RestClientResponseException e) {
			log.error("Error solicitudRUELiquidacion {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error solicitudRUELiquidacion {}", e.getLocalizedMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error solicitudRUELiquidacion {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 *
	 */
	@Override
	public ResponseEntity<RadicacionInfoResponse> solicitudRUERadicacion(RadicacionInfoDTO radicacionInfoDTO) {
		log.info("Inicio metodo solicitudRUERadicacion {}", new Gson().toJson(radicacionInfoDTO));
		try {
			String usuario = radicacionInfoDTO.getUsuario();
			String nroInterno = radicacionInfoDTO.getNumero_interno();
			String camaraDestino = radicacionInfoDTO.getCamara_destino();
			String matricula = radicacionInfoDTO.getMatricula();
			String registro = radicacionInfoDTO.getInscripcion();
			String nombreRegistrado = radicacionInfoDTO.getNombre_registrado();
			String claseIdentificacion = radicacionInfoDTO.getClase_identificacion();
			String nroIdentificacion = radicacionInfoDTO.getNumero_identificacion();
			String digitoVerificacion = radicacionInfoDTO.getDigito_verificacion();
			String nombrePagador = radicacionInfoDTO.getNombre_pagador();
			String origenDocumento = radicacionInfoDTO.getOrigen_documento();
			String fechaDocumento = radicacionInfoDTO.getFecha_documento();
			String numeroFactura = radicacionInfoDTO.getNumero_factura();
			String fechaPago = radicacionInfoDTO.getFecha_pago();
			String totalPagado = radicacionInfoDTO.getTotal_pagado();
			String formaPago = radicacionInfoDTO.getForma_pago();
			String empleados = String.valueOf(radicacionInfoDTO.getEmpleados());
			String indicadorBeneficio = String.valueOf(radicacionInfoDTO.getIndicador_beneficio());
			List<com.camaradirecta.rue.MR02N.RueDetallesLiquidacionBC> servicios = mappingDetalleRadicacion(
					radicacionInfoDTO.getServicios());
			String estado[] = new String[1];
			String error[] = new String[2];
			String salidas[] = new String[5];

			RueRadicacionBC response = radicarLiquidacion(usuario,
					nroInterno, camaraDestino, matricula, registro, nombreRegistrado, claseIdentificacion,
					nroIdentificacion, digitoVerificacion, nombrePagador, origenDocumento, fechaDocumento,
					numeroFactura, fechaPago, totalPagado, formaPago, empleados, indicadorBeneficio, salidas, servicios,
					urlSolicitudRadicacionMR02N, error);
			RadicacionInfoResponse liquidacionResponse = mappingLiquidacionRadicacionRespose(response);
			return new ResponseEntity<>(liquidacionResponse, HttpStatus.OK);
		} catch (RestClientResponseException e) {
			log.error("Error solicitudRUERadicacion {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error solicitudRUERadicacion {}", e.getLocalizedMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error solicitudRUERadicacion {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@Override
	public ResponseEntity<RueCertificadoResponse> solicitudRUECertificado(CertificadoInfoDTO certificadoInfoDTO) {
		log.info("Inicio metodo solicitudRUECertificado {}", new Gson().toJson(certificadoInfoDTO));
		try {
			String usuario = certificadoInfoDTO.getUsuario();
			String nroInterno = certificadoInfoDTO.getNumero_interno();
			String camaraDestino = certificadoInfoDTO.getCamara_destino();
			String matricula = certificadoInfoDTO.getMatricula();
			String registro = certificadoInfoDTO.getInscripcion();
			String nombreRegistrado = certificadoInfoDTO.getNombre_registrado();
			String claseIdentificacion = certificadoInfoDTO.getClase_identificacion();
			String nroIdentificacion = certificadoInfoDTO.getNumero_identificacion();
			String digitoVerificacion = certificadoInfoDTO.getDigito_verificacion();
			String nombrePagador = certificadoInfoDTO.getNombre_pagador();
			String origenDocumento = certificadoInfoDTO.getOrigen_documento();
			String fechaDocumento = certificadoInfoDTO.getFecha_documento();
			String numeroFactura = certificadoInfoDTO.getNumero_factura();
			String fechaPago = certificadoInfoDTO.getFecha_pago();
			String totalPagado = certificadoInfoDTO.getTotal_pagado();
			String formaPago = certificadoInfoDTO.getForma_pago();
			List<com.camaradirecta.rue.RR04N.RueDetallesLiquidacionBC> servicios =  mappingDetalleCertificado(certificadoInfoDTO.getServicios());
			String error[] = new String[2];
			String salidas[] = new String[5];
			
			RueCertificadoBC rueCertificadoBC = radicarCertificado(usuario, nroInterno, camaraDestino, matricula, registro,
					nombreRegistrado, claseIdentificacion, nroIdentificacion, digitoVerificacion, nombrePagador,
					origenDocumento, fechaDocumento, numeroFactura, fechaPago, totalPagado, formaPago, salidas,
					servicios, urlSolicitudCertificadoRR04N, error);
			
			RueCertificadoResponse response = mappingRueCertificado(rueCertificadoBC );
			CertificadoRueResponse respuesta = new CertificadoRueResponse();
			respuesta.setRespuesta(response);
			
			return new ResponseEntity<>(response, HttpStatus.OK);
			
		} catch (RestClientResponseException e) {
			log.error("Error solicitudRUECertificado {},{}", e.getLocalizedMessage(), e.getResponseBodyAsString());
			return new ResponseEntity<>(null, HttpStatus.CONFLICT);
		} catch (RestClientException e) {
			log.error("Error solicitudRUECertificado {}", e.getLocalizedMessage());
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			log.error("Error solicitudRUECertificado {} ", e.getLocalizedMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	/**
	 * @param rueCertificadoBC
	 * @return
	 */
	private RueCertificadoResponse mappingRueCertificado(RueCertificadoBC certificado) {
		RueCertificadoResponse response = new RueCertificadoResponse();
		response.setCamara_receptora(certificado.getCamaraReceptora());
		response.setCamara_responsable(certificado.getCamaraResponsable());
		response.setCaracteres_por_linea(certificado.getCaracteresPorLinea());
		response.setClase_identificacion(certificado.getClaseIdentificacion());		
		response.setCodigo_servicio(certificado.getCodigoServicio());
		response.setDesc_camara(certificado.getDescCamara());
		response.setDigito_verificacion(certificado.getDigitoVerificacion());
		response.setFecha_generado(certificado.getFechaGenerado());
		response.setFecha_pago(certificado.getFechaPago());
		response.setFirma_digital(certificado.getFirmaDigital());
		response.setFirma_mecanica(certificado.getFirmaMecanica());
		response.setForma_pago(certificado.getFormaPago());
		response.setHora_generado(certificado.getHoraGenerado());
		response.setNumero_factura(certificado.getNumeroFactura());
		response.setNumero_identificacion(certificado.getNumeroIdentificacion());
		response.setNumero_interno(certificado.getNumeroInterno());
		response.setReferencia_operacion(certificado.getReferenciaOperacion());
		List<String> texto = new ArrayList<String>();
		TextoCertificado textoCertificado = certificado.getTextoCertificado();
		for(String certificadoEncriptado : textoCertificado.getTexto()) {
			texto.add(certificadoEncriptado);
		}		
		response.setTexto_certificado(texto);
		response.setTotal_pagado(certificado.getTotalPagado());
		response.setUsuario(certificado.getUsuario());
		response.setCodigo_error(certificado.getCodigoError());
		response.setHora_respuesta(certificado.getHoraRespuesta());
		response.setMensaje_error(certificado.getMensajeError());
		response.setFecha_respuesta(certificado.getFechaRespuesta());
		response.setNumero_unico_consulta("20241341721");

		return response;
	}

	/**
	 * @param usuario
	 * @param nroInterno
	 * @param estadoTransaccion
	 * @param anexos
	 * @param estado
	 * @param endPoint
	 * @param error
	 * @return
	 * @throws MalformedURLException
	 * @throws ServiceException
	 * @throws RemoteException
	 */
	public RueActualizacionEstadoBC actualizacionEstado(String usuario, String nroInterno, String estadoTransaccion,
			String anexos, String[] estado, String endPoint, String[] error)
			throws MalformedURLException, ServiceException, RemoteException {
		if (estado == null || estado.length != 1) {
			if (error != null && error.length >= 2) {
				error[0] = "0001";
				error[1] = "Error invocando el Web Servie MR03N. Por favor revise los parametros.";
			}
			return null;
		}
		RueActualizacionEstadoBC detalle = new RueActualizacionEstadoBC();
		detalle.setUsuario(usuario);
		detalle.setNumeroInterno(nroInterno);
		detalle.setEstadoTransaccion(estadoTransaccion);
		detalle.setAnexos(anexos);
		detalle.setFechaRespuesta(getFechaCompacta(getTimestamp()));
		detalle.setHoraRespuesta(getHoraCompacta(getTimestamp()));
		detalle.setEstado("1");
		detalle.setCodigoError("0000");
		detalle.setMensajeError("");
		detalle.setFirmaDigital("");
		MR03N service = new MR03N();
		MR03NDelegate soap = service.getMR03N();
		((BindingProvider) soap).getRequestContext().put("javax.xml.ws.service.endpoint.address",
				String.valueOf(endPoint));
		detalle = soap.solicitudActualizacionEstado(detalle);
		if (isPresentaronErrores(detalle.getCodigoError(), error, detalle.getMensajeError()))
			return null;
		return detalle;
	}

	/**
	 * @param usuario
	 * @param nroInterno
	 * @param camaraDestino
	 * @param matricula
	 * @param registro
	 * @param origenDocumento
	 * @param fechaDocumento
	 * @param indicadorOrigen
	 * @param empleados
	 * @param indicadorBeneficio
	 * @param estado
	 * @param servicios
	 * @param endPoint
	 * @param error
	 * @return
	 * @throws MalformedURLException
	 * @throws ServiceException
	 * @throws RemoteException
	 */
	public RueLiquidacionBC solicitudLiquidacion(String usuario, String nroInterno, String camaraDestino, String camaraReceptora,
			String matricula, String registro, String origenDocumento, String fechaDocumento, String indicadorOrigen,
			String empleados, String indicadorBeneficio, String[] estado, List<RueDetallesLiquidacionBC> servicios,
			String endPoint, String[] error) throws MalformedURLException, ServiceException, RemoteException {
		if (estado == null || estado.length != 1 || servicios == null) {
			if (error != null && error.length >= 2) {
				error[0] = "0001";
				error[1] = "Error invocando el Web Servie MR01D. Por favor revise los parametros.";
			}
			return null;
		}
		RueLiquidacionBC detalle = new RueLiquidacionBC();
		detalle.setUsuario(usuario);
		detalle.setNumeroInterno(nroInterno);
		detalle.setCamaraReceptora(camaraReceptora);
		detalle.setCamaraDestino(camaraDestino);
		detalle.setMatricula(matricula);
		detalle.setInscripcion(registro);
		detalle.setOrigenDocumento(origenDocumento);
		detalle.setFechaDocumento(fechaDocumento);
		detalle.setIndicadorOrigen(indicadorOrigen);
		if (!vacio(empleados))
			detalle.setEmpleados(new Integer(empleados));
		if (!vacio(indicadorBeneficio))
			detalle.setIndicadorBeneficio(Integer.valueOf(indicadorBeneficio));
		detalle.setEstado(estado[0]);
		enListar(servicios, detalle.getServicios());
		detalle.setFechaRespuesta("");
		detalle.setHoraRespuesta("");
		detalle.setCodigoError("");
		detalle.setMensajeError("");
		detalle.setFirmaDigital("");
		MR01D service = new MR01D();
		MR01DDelegate soap = service.getMR01D();
		((BindingProvider) soap).getRequestContext().put("javax.xml.ws.service.endpoint.address",
				String.valueOf(endPoint));
		detalle = soap.solicitudLiquidacion(detalle);
		estado[0] = detalle.getEstado();
		sePresentaronErrores(detalle.getCodigoError(), error, detalle.getMensajeError());
		return detalle;
	}

	/**
	 * @param usuario
	 * @param nroInterno
	 * @param camaraDestino
	 * @param matricula
	 * @param registro
	 * @param nombreRegistrado
	 * @param claseIdentificacion
	 * @param nroIdentificacion
	 * @param digitoVerificacion
	 * @param nombrePagador
	 * @param origenDocumento
	 * @param fechaDocumento
	 * @param numeroFactura
	 * @param fechaPago
	 * @param totalPagado
	 * @param formaPago
	 * @param empleados
	 * @param indicadorBeneficio
	 * @param salidas
	 * @param servicios
	 * @param endPoint
	 * @param error
	 * @return
	 * @throws MalformedURLException
	 * @throws ServiceException
	 * @throws RemoteException
	 */
	public RueRadicacionBC radicarLiquidacion(String usuario,
			String nroInterno, String camaraDestino, String matricula, String registro, String nombreRegistrado,
			String claseIdentificacion, String nroIdentificacion, String digitoVerificacion, String nombrePagador,
			String origenDocumento, String fechaDocumento, String numeroFactura, String fechaPago, String totalPagado,
			String formaPago, String empleados, String indicadorBeneficio, String[] salidas,
			List<com.camaradirecta.rue.MR02N.RueDetallesLiquidacionBC> servicios, String endPoint, String[] error)
			throws MalformedURLException, ServiceException, RemoteException {
		if (salidas == null || salidas.length != 5 || servicios == null) {
			if (error != null && error.length >= 2) {
				error[0] = "0001";
				error[1] = "Error invocando el Web Servie MR02N. Por favor revise los parametros.";
			}
			return null;
		}
		RueRadicacionBC detalle = new RueRadicacionBC();
		detalle.setUsuario(usuario);
		detalle.setNumeroInterno(nroInterno);
		detalle.setCodigoServicioRadicar(
				((com.camaradirecta.rue.MR02N.RueDetallesLiquidacionBC) servicios.get(0)).getCodigoServicio());
		detalle.setCamaraReceptora(this.CAMARA);
		detalle.setCamaraDestino(camaraDestino);
		detalle.setMatricula(matricula);
		detalle.setInscripcion(registro);
		detalle.setNombreRegistrado(nombreRegistrado);
		detalle.setClaseIdentificacion(claseIdentificacion);
		detalle.setNumeroIdentificacion(nroIdentificacion);
		detalle.setDigitoVerificacion(digitoVerificacion);
		detalle.setNombrePagador(nombrePagador);
		detalle.setOrigenDocumento(origenDocumento);
		detalle.setFechaDocumento(fechaDocumento);
		detalle.setEstadoTransaccion("01");
		detalle.setFechaPago(fechaPago);
		detalle.setNumeroFactura(numeroFactura);
		detalle.setReferenciaOperacion(null);
		detalle.setTotalPagado(new BigDecimal(totalPagado));
		detalle.setFormaPago(formaPago);
		if (!vacio(empleados))
			detalle.setEmpleados(new Integer(empleados));
		if (!vacio(indicadorBeneficio))
			detalle.setIndicadorBeneficio(new Integer(indicadorBeneficio));
		enListarDetalle(servicios, detalle.getServicios());
		detalle.setFechaRespuesta(getFechaCompacta(getTimestamp()));
		detalle.setHoraRespuesta(getHoraCompacta(getTimestamp()));
		detalle.setEstado("0");
		detalle.setCodigoError("0000");
		detalle.setMensajeError("");
		detalle.setFirmaDigital("");
		MR02N service = new MR02N();
		MR02NDelegate soap = service.getMR02N();
		((BindingProvider) soap).getRequestContext().put("javax.xml.ws.service.endpoint.address",
				String.valueOf(endPoint));
		detalle = soap.solicitudRadicacion(detalle);
		salidas[0] = detalle.getEstadoTransaccion();
		salidas[1] = detalle.getReferenciaOperacion();
		salidas[2] = detalle.getNumeroUnicoConsulta();
		salidas[3] = detalle.getHoraRespuesta();
		salidas[4] = detalle.getFechaRespuesta();
		if (isPresentaronErrores(detalle.getCodigoError(), error, detalle.getMensajeError()))
			return null;
		return detalle;
	}
	
	/**
	 * @param usuario
	 * @param nroInterno
	 * @param camaraDestino
	 * @param matricula
	 * @param registro
	 * @param nombreRegistrado
	 * @param claseIdentificacion
	 * @param nroIdentificacion
	 * @param digitoVerificacion
	 * @param nombrePagador
	 * @param origenDocumento
	 * @param fechaDocumento
	 * @param numeroFactura
	 * @param fechaPago
	 * @param totalPagado
	 * @param formaPago
	 * @param salidas
	 * @param servicios
	 * @param endPoint
	 * @param error
	 * @return
	 * @throws MalformedURLException
	 * @throws ServiceException
	 * @throws RemoteException
	 */
	public RueCertificadoBC radicarCertificado(String usuario, String nroInterno, String camaraDestino,
			String matricula, String registro, String nombreRegistrado, String claseIdentificacion,
			String nroIdentificacion, String digitoVerificacion, String nombrePagador, String origenDocumento,
			String fechaDocumento, String numeroFactura, String fechaPago, String totalPagado, String formaPago,
			String[] salidas, List<com.camaradirecta.rue.RR04N.RueDetallesLiquidacionBC> servicios, String endPoint, String[] error)
			throws MalformedURLException, ServiceException, RemoteException {
		com.camaradirecta.rue.RR04N.RueRadicacionBC detalle = null;
		RueCertificadoBC certificado = null;
		detalle = new com.camaradirecta.rue.RR04N.RueRadicacionBC();
		detalle.setUsuario(usuario);
		detalle.setNumeroInterno(nroInterno);
		detalle.setCodigoServicioRadicar(((com.camaradirecta.rue.RR04N.RueDetallesLiquidacionBC) servicios.get(0)).getCodigoServicio());
		detalle.setCamaraReceptora(this.CAMARA);
		detalle.setCamaraDestino(camaraDestino);
		detalle.setMatricula(matricula);
		detalle.setInscripcion(registro);
		detalle.setNombreRegistrado(nombreRegistrado);
		detalle.setClaseIdentificacion(claseIdentificacion);
		detalle.setNumeroIdentificacion(nroIdentificacion);
		detalle.setDigitoVerificacion(digitoVerificacion);
		detalle.setNombrePagador(nombrePagador);
		detalle.setOrigenDocumento(origenDocumento);
		detalle.setFechaDocumento(fechaDocumento);
		detalle.setEstadoTransaccion("01");
		detalle.setFechaPago(fechaPago);
		detalle.setNumeroFactura(numeroFactura);
		detalle.setReferenciaOperacion(null);
		detalle.setTotalPagado(new BigDecimal(totalPagado));
		detalle.setFormaPago(formaPago);
		enListarCertificado(servicios, detalle.getServicios());
		detalle.setFechaRespuesta(getFechaCompacta(getTimestamp()));
		detalle.setHoraRespuesta(getHoraCompacta(getTimestamp()));
		detalle.setEstado("0");
		detalle.setCodigoError("0000");
		detalle.setMensajeError("");
		detalle.setFirmaDigital("");
		RR04N service = new RR04N();
		RR04NDelegate soap = service.getRR04N();
		((BindingProvider) soap).getRequestContext().put("javax.xml.ws.service.endpoint.address",
				String.valueOf(endPoint));
		certificado = soap.solicitudCertificado(detalle);
		salidas[0] = certificado.getReferenciaOperacion();
		salidas[1] = certificado.getHoraRespuesta();
		salidas[2] = certificado.getFechaRespuesta();
		sePresentaronErrores(certificado.getCodigoError(), error, certificado.getMensajeError());
		return certificado;
	}


	/**
	 * @param response
	 * @return
	 */
	private ActualizacionEstadoInfoResponse mappingActualizacionEstado(RueActualizacionEstadoBC response) {
		ActualizacionEstadoInfoResponse actualizacionEstadoInfoResponse = new ActualizacionEstadoInfoResponse();
		actualizacionEstadoInfoResponse.setAnexos(response.getAnexos());
		actualizacionEstadoInfoResponse.setCodigo_error(response.getCodigoError());
		actualizacionEstadoInfoResponse.setEstado(response.getEstado());
		actualizacionEstadoInfoResponse.setEstado_transaccion(response.getEstadoTransaccion());
		actualizacionEstadoInfoResponse.setFecha_respuesta(response.getFechaRespuesta());
		actualizacionEstadoInfoResponse.setFirma_digital(response.getFirmaDigital());
		actualizacionEstadoInfoResponse.setHora_respuesta(response.getHoraRespuesta());
		actualizacionEstadoInfoResponse.setNumero_interno(response.getNumeroInterno());
		actualizacionEstadoInfoResponse.setUsuario(response.getUsuario());
		actualizacionEstadoInfoResponse.setMensaje_error(response.getMensajeError());
		return actualizacionEstadoInfoResponse;
	}

	/**
	 * @param servicios
	 * @return
	 */
	private List<RueDetallesLiquidacionBC> mappingDetalleLiquidacion(ArrayList<LiquidacionServicioInfoDTO> servicios) {
		List<RueDetallesLiquidacionBC> serviciosLiquidacion = new ArrayList<>();
		for (LiquidacionServicioInfoDTO dto : servicios) {
			RueDetallesLiquidacionBC servicioLiquidacion = new RueDetallesLiquidacionBC();
			servicioLiquidacion.setAnoRenovacion(dto.getAno_renovacion());
			servicioLiquidacion.setCantidadServicio(dto.getCantidad_servicio());
			servicioLiquidacion.setCodigoServicio(dto.getCodigo_servicio());
			servicioLiquidacion.setDescripcionServicio(dto.getDescripcion_servicio());
			servicioLiquidacion.setIndicadorBase(dto.getIndicador_base());
			servicioLiquidacion.setIndicadorRenovacion(dto.getIndicador_renovacion());
			servicioLiquidacion.setMatriculaServicio(dto.getMatricula_servicio());
			servicioLiquidacion.setNombreBase(dto.getNombre_base());
			servicioLiquidacion.setNombreMatriculado(dto.getNombre_matriculado());
			servicioLiquidacion.setOrdenServicio(dto.getOrden_servicio());
			servicioLiquidacion.setOrdenServicioAsociado(dto.getOrden_servicio_asociado());
			servicioLiquidacion.setValorActivosSinAjustes(BigDecimal.valueOf(dto.getValor_activos_sin_ajustes()));
			servicioLiquidacion.setValorBase(BigDecimal.valueOf(dto.getValor_base()));
			servicioLiquidacion.setValorLiquidacion(BigDecimal.valueOf(dto.getValor_liquidacion()));
			serviciosLiquidacion.add(servicioLiquidacion);
		}
		return serviciosLiquidacion;
	}

	/**
	 * @param response
	 * @return
	 */
	private LiquidacionInfoResponse mappingLiquidacionDetalleRespose(RueLiquidacionBC rueLiquidacion) {
		LiquidacionInfoResponse liquidacionInfoResponse = new LiquidacionInfoResponse();
		ArrayList<LiquidacionDetalleResponse> liquidacionDetalleResponse = new ArrayList<LiquidacionDetalleResponse>();
		FirmaDigitalResponse firmaDigitalResponse = new FirmaDigitalResponse();
		liquidacionInfoResponse.setNumero_interno(rueLiquidacion.getNumeroInterno());
		liquidacionInfoResponse.setUsuario(rueLiquidacion.getUsuario());
		liquidacionInfoResponse.setCamara_receptora(rueLiquidacion.getCamaraReceptora());
		liquidacionInfoResponse.setCamara_destino(rueLiquidacion.getCamaraDestino());
		liquidacionInfoResponse.setMatricula(rueLiquidacion.getMatricula());
		liquidacionInfoResponse.setInscripcion(rueLiquidacion.getInscripcion());
		liquidacionInfoResponse.setOrigen_documento(rueLiquidacion.getOrigenDocumento());
		liquidacionInfoResponse.setFecha_documento(rueLiquidacion.getFechaDocumento());
		liquidacionInfoResponse.setEstado(rueLiquidacion.getEstado());
		liquidacionInfoResponse.setEmpleados(rueLiquidacion.getEmpleados());
		liquidacionInfoResponse.setIndicador_beneficio(rueLiquidacion.getIndicadorBeneficio());
//			FirmaDigitalResponse fimDetalle = new FirmaDigitalResponse();
//			fimDetalle.setCantidadcertificados(String.valueOf(dto.getCantidadServicio())); // validar si trae cantidad de certificados correcto
//			fimDetalle.setLibroactas(dto.);
//			fimDetalle.setLibroasociados(dto.);
//			fimDetalle.setMunicipio(dto.);
//			firmaDigitalResponse.add(fimDetalle);
		liquidacionInfoResponse.setFirma_digital(firmaDigitalResponse);
		liquidacionInfoResponse.setCodigo_error(rueLiquidacion.getCodigoError());
		liquidacionInfoResponse.setMensaje_error(rueLiquidacion.getMensajeError());
		liquidacionInfoResponse.setFecha_respuesta(rueLiquidacion.getFechaRespuesta());
		liquidacionInfoResponse.setHora_respuesta(rueLiquidacion.getHoraRespuesta());
		liquidacionInfoResponse.setIndicador_origen(rueLiquidacion.getIndicadorOrigen());
		for (RueDetallesLiquidacionBC dto : rueLiquidacion.getServicios()) {
			LiquidacionDetalleResponse liqDetalle = new LiquidacionDetalleResponse();
			liqDetalle.setAno_renovacion(dto.getAnoRenovacion());
			liqDetalle.setCantidad_servicio(dto.getCantidadServicio());
			liqDetalle.setCodigo_servicio(dto.getCodigoServicio());
			liqDetalle.setDescripcion_servicio(dto.getDescripcionServicio());
			liqDetalle.setIndicador_base(dto.getIndicadorBase());
			liqDetalle.setMatricula_servicio(dto.getMatriculaServicio());
			liqDetalle.setNombre_base(dto.getNombreBase());
			liqDetalle.setNombre_matriculado(dto.getNombreMatriculado());
			liqDetalle.setOrden_servicio(String.valueOf(dto.getOrdenServicio()));
			liqDetalle.setOrden_servicio_asociado(String.valueOf(dto.getOrdenServicioAsociado()));
			liqDetalle.setValor_activos_sin_ajustes(dto.getValorActivosSinAjustes().intValue());
			liqDetalle.setValor_base(dto.getValorBase().intValue());
			liqDetalle.setValor_liquidacion(dto.getValorLiquidacion().intValue());
			liqDetalle.setIndicador_renovacion(dto.getIndicadorRenovacion());
			liquidacionDetalleResponse.add(liqDetalle);
		}
		liquidacionInfoResponse.setServicios(liquidacionDetalleResponse);
		return liquidacionInfoResponse;
	}
	
	
	/**
	 * @param response
	 * @return
	 */
	private RadicacionInfoResponse mappingLiquidacionRadicacionRespose(
			RueRadicacionBC response) {
			RadicacionInfoResponse radicacionInfoResponse = new RadicacionInfoResponse();
			ArrayList<LiquidacionDetalleResponse> liquidacionDetalleResponse = new ArrayList<LiquidacionDetalleResponse>();
			
			for (com.camaradirecta.rue.MR02N.RueDetallesLiquidacionBC dto : response.getServicios()) {
				LiquidacionDetalleResponse liqDetalle = new LiquidacionDetalleResponse();
				liqDetalle.setAno_renovacion(dto.getAnoRenovacion());
				liqDetalle.setCantidad_servicio(dto.getCantidadServicio());
				liqDetalle.setCodigo_servicio(dto.getCodigoServicio());
				liqDetalle.setDescripcion_servicio(dto.getDescripcionServicio());
				liqDetalle.setIndicador_base(dto.getIndicadorBase());
				liqDetalle.setMatricula_servicio(dto.getMatriculaServicio());
				liqDetalle.setNombre_base(dto.getNombreBase());
				liqDetalle.setNombre_matriculado(dto.getNombreMatriculado());
				liqDetalle.setOrden_servicio(String.valueOf(dto.getOrdenServicio()));
				liqDetalle.setOrden_servicio_asociado(String.valueOf(dto.getOrdenServicioAsociado()));
				liqDetalle.setValor_activos_sin_ajustes(Integer.valueOf(dto.getValorActivosSinAjustes().toString()));
				liqDetalle.setValor_base(Integer.valueOf(dto.getValorBase().toString()));
				liqDetalle.setValor_liquidacion(Integer.valueOf(dto.getValorLiquidacion().toString()));
				liqDetalle.setIndicador_renovacion(dto.getIndicadorRenovacion() != null ? dto.getIndicadorRenovacion() : "N");
				liquidacionDetalleResponse.add(liqDetalle);
			}
			radicacionInfoResponse.setServicios(liquidacionDetalleResponse);
			radicacionInfoResponse.setNumero_interno(response.getNumeroInterno());
			radicacionInfoResponse.setUsuario(response.getUsuario());
			radicacionInfoResponse.setCamara_destino(response.getCamaraDestino());
			radicacionInfoResponse.setCamara_receptora(response.getCamaraReceptora());
			radicacionInfoResponse.setMatricula(response.getMatricula());
			radicacionInfoResponse.setInscripcion(response.getInscripcion());
			radicacionInfoResponse.setOrigen_documento(response.getOrigenDocumento());
			radicacionInfoResponse.setFecha_documento(response.getFechaDocumento());
			radicacionInfoResponse.setCodigo_servicio_radicar(response.getCodigoServicioRadicar());
			radicacionInfoResponse.setNombre_registrado(response.getNombreRegistrado());
			radicacionInfoResponse.setClase_identificacion(response.getClaseIdentificacion());
			radicacionInfoResponse.setNumero_identificacion(response.getNumeroIdentificacion());
			radicacionInfoResponse.setDigito_verificacion(response.getDigitoVerificacion());
			radicacionInfoResponse.setEstado_transaccion(response.getEstadoTransaccion());
			radicacionInfoResponse.setNombre_pagador(response.getNombrePagador());
			radicacionInfoResponse.setFecha_pago(response.getFechaPago());
			radicacionInfoResponse.setNumero_factura(response.getNumeroFactura());
			radicacionInfoResponse.setReferencia_operacion(response.getReferenciaOperacion());
			radicacionInfoResponse.setTotal_pagado(response.getTotalPagado());
			radicacionInfoResponse.setForma_pago(response.getFormaPago());
			radicacionInfoResponse.setNumero_unico_consulta(response.getNumeroUnicoConsulta() != null ? response.getNumeroUnicoConsulta() : "");
			radicacionInfoResponse.setEstado(response.getEstado());
			radicacionInfoResponse.setEmpleados(response.getEmpleados());
			radicacionInfoResponse.setIndicador_beneficio(response.getIndicadorBeneficio());
			radicacionInfoResponse.setFecha_generacion("");
			radicacionInfoResponse.setHora_generacion("");
			radicacionInfoResponse.setCaracteres_por_linea("0");
			radicacionInfoResponse.setFirma_digital("");
			radicacionInfoResponse.setTexto_certificado("");
			radicacionInfoResponse.setCodigo_error(response.getCodigoError());
			radicacionInfoResponse.setMensaje_error(response.getMensajeError());
			radicacionInfoResponse.setFecha_respuesta(response.getFechaRespuesta());
			radicacionInfoResponse.setHora_respuesta(response.getHoraRespuesta());
			

		return radicacionInfoResponse;
	}

	/**
	 * @param servicios
	 * @return
	 */
	private List<com.camaradirecta.rue.MR02N.RueDetallesLiquidacionBC> mappingDetalleRadicacion(
			ArrayList<RadicacionServicioInfoDTO> servicios) {
		List<com.camaradirecta.rue.MR02N.RueDetallesLiquidacionBC> serviciosLiquidacion = new ArrayList<>();
		for (RadicacionServicioInfoDTO dto : servicios) {
			com.camaradirecta.rue.MR02N.RueDetallesLiquidacionBC servicioLiquidacion = new com.camaradirecta.rue.MR02N.RueDetallesLiquidacionBC();
			servicioLiquidacion.setAnoRenovacion(dto.getAno_renovacion());
			servicioLiquidacion.setCantidadServicio(dto.getCantidad_servicio());
			servicioLiquidacion.setCodigoServicio(dto.getCodigo_servicio());
			servicioLiquidacion.setDescripcionServicio(dto.getDescripcion_servicio());
			servicioLiquidacion.setIndicadorBase(dto.getIndicador_base());
			servicioLiquidacion.setIndicadorRenovacion(dto.getIndicador_renovacion());
			servicioLiquidacion.setMatriculaServicio(dto.getMatricula_servicio());
			servicioLiquidacion.setNombreBase(dto.getNombre_base());
			servicioLiquidacion.setNombreMatriculado(dto.getNombre_matriculado());
			servicioLiquidacion.setOrdenServicio(dto.getOrden_servicio());
			servicioLiquidacion.setOrdenServicioAsociado(dto.getOrden_servicio_asociado());
			servicioLiquidacion.setValorActivosSinAjustes(BigDecimal.valueOf(dto.getValor_activos_sin_ajustes()));
			servicioLiquidacion.setValorBase(BigDecimal.valueOf(dto.getValor_base()));
			servicioLiquidacion.setValorLiquidacion(BigDecimal.valueOf(dto.getValor_liquidacion()));
			serviciosLiquidacion.add(servicioLiquidacion);
		}
		return serviciosLiquidacion;
	}
	
	
	/**
	 * @param servicios
	 * @return
	 */
	private List<com.camaradirecta.rue.RR04N.RueDetallesLiquidacionBC> mappingDetalleCertificado(
			ArrayList<CertificadoServicioInfoDTO> servicios) {
		List<com.camaradirecta.rue.RR04N.RueDetallesLiquidacionBC> serviciosLiquidacion = new ArrayList<>();
		for (CertificadoServicioInfoDTO dto : servicios) {
			com.camaradirecta.rue.RR04N.RueDetallesLiquidacionBC servicioLiquidacion = new com.camaradirecta.rue.RR04N.RueDetallesLiquidacionBC();
			servicioLiquidacion.setAnoRenovacion(dto.getAno_renovacion());
			servicioLiquidacion.setCantidadServicio(dto.getCantidad_servicio());
			servicioLiquidacion.setCodigoServicio(dto.getCodigo_servicio());
			servicioLiquidacion.setDescripcionServicio(dto.getDescripcion_servicio());
			servicioLiquidacion.setIndicadorBase(dto.getIndicador_base());
			servicioLiquidacion.setIndicadorRenovacion(dto.getIndicador_renovacion());
			servicioLiquidacion.setMatriculaServicio(dto.getMatricula_servicio());
			servicioLiquidacion.setNombreBase(dto.getNombre_base());
			servicioLiquidacion.setNombreMatriculado(dto.getNombre_matriculado());
			servicioLiquidacion.setOrdenServicio(dto.getOrden_servicio());
			servicioLiquidacion.setOrdenServicioAsociado(dto.getOrden_servicio_asociado());
			servicioLiquidacion.setValorActivosSinAjustes(BigDecimal.valueOf(dto.getValor_activos_sin_ajustes()));
			servicioLiquidacion.setValorBase(BigDecimal.valueOf(dto.getValor_base()));
			servicioLiquidacion.setValorLiquidacion(BigDecimal.valueOf(dto.getValor_liquidacion()));
			serviciosLiquidacion.add(servicioLiquidacion);
		}
		return serviciosLiquidacion;
	}

	/**
	 * @param codigoerror
	 * @param error
	 * @param mensjaeerror
	 * @return
	 */
	private boolean isPresentaronErrores(String codigoerror, String[] error, String mensjaeerror) {
		if (codigoerror != null && !codigoerror.equals("0000")) {
			if (error != null && error.length >= 2) {
				error[0] = codigoerror;
				error[1] = mensjaeerror;
			}
			return true;
		}
		if (error != null && error.length >= 2) {
			error[0] = "0000";
			error[1] = null;
		}
		return false;
	}

	/**
	 * @param fecha
	 * @return
	 */
	public String getFechaCompacta(String fecha) {
		return String.valueOf(fecha.substring(0, 4)) + fecha.substring(5, 7) + fecha.substring(8, 10);
	}

	/**
	 * @return
	 */
	public String getTimestamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSSSSS");
		Date now = new Date();
		sdf.setTimeZone(TimeZone.getTimeZone("GMT-05"));
		String dateString = sdf.format(now);
		return dateString;
	}

	/**
	 * @param fecha
	 * @return
	 */
	public String getHoraCompacta(String fecha) {
		return String.valueOf(fecha.substring(11, 13)) + fecha.substring(14, 16) + fecha.substring(17, 19);
	}

	/**
	 * @param cadena
	 * @return
	 */
	public boolean vacio(String cadena) {
		if (cadena == null) {
			cadena = "";
			return true;
		}
		if (cadena.length() <= 0)
			return true;
		return false;
	}

	/**
	 * @param listallena
	 * @param listavacia
	 */
	public void enListar(List<RueDetallesLiquidacionBC> listallena, List<RueDetallesLiquidacionBC> listavacia) {
		if (listallena == null || listavacia == null)
			return;
		for (RueDetallesLiquidacionBC o : listallena)
			listavacia.add(o);
	}

	/**
	 * @param listallena
	 * @param listavacia
	 */
	private void enListarDetalle(List<com.camaradirecta.rue.MR02N.RueDetallesLiquidacionBC> listallena,
			List<com.camaradirecta.rue.MR02N.RueDetallesLiquidacionBC> listavacia) {
		if (listallena == null || listavacia == null)
			return;
		for (com.camaradirecta.rue.MR02N.RueDetallesLiquidacionBC o : listallena)
			listavacia.add(o);
	}
	
	/**
	 * @param listallena
	 * @param listavacia
	 */
	private void enListarCertificado(List<com.camaradirecta.rue.RR04N.RueDetallesLiquidacionBC> listallena,
			List<com.camaradirecta.rue.RR04N.RueDetallesLiquidacionBC> listavacia) {
		if (listallena == null || listavacia == null)
			return;
		for (com.camaradirecta.rue.RR04N.RueDetallesLiquidacionBC o : listallena)
			listavacia.add(o);
		
	}

	/**
	 * @param codigoerror
	 * @param error
	 * @param mensjaeerror
	 */
	private void sePresentaronErrores(String codigoerror, String[] error, String mensjaeerror) {
		if (codigoerror != null && !codigoerror.equals("0000")) {
			if (error != null && error.length >= 2) {
				error[0] = codigoerror;
				error[1] = mensjaeerror;
			}
		} else if (error != null && error.length >= 2) {
			error[0] = "0000";
			error[1] = null;
		}
	}
	
	/**
	 * @param response
	 * @return
	 */
	private RadicacionRueResponse mappingRespuestaRue(RadicacionInfoResponse response, RueRadicacionBC respuesta) {
		RadicacionRueResponse respuestaRue = new RadicacionRueResponse();
			
			respuestaRue.setRespuesta(response);
			respuestaRue.setMensaje_error(respuesta.getMensajeError());
			respuestaRue.setCodigo_error(respuesta.getCodigoError());
			respuestaRue.setHora_respuesta(respuesta.getHoraRespuesta());
			respuestaRue.setFecha_respuesta(respuesta.getFechaRespuesta());
			

		return respuestaRue;
	}

}
