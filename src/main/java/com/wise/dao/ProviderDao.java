package com.wise.dao;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.stereotype.Repository;

import com.wise.Constants;
import com.wise.model.ConsignacionRequestDto;
import com.wise.model.PeriodDto;

import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_AREA_RESPServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_CAMBIO_PSWD_PROVServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_CONFIRMA_ESTADO_CUENTAServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_CONTADOR_AVISOS_NLEServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_DATOS_PROVEEDORServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_DET_FACT_CONSIGServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_ENVIO_TOKENServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_ESTADO_CUENTAServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_ESTATUS_PORTALServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_LISTA_FACServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_OBTIENE_AVISOSServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_OBTIENE_DAT_ACCT_PROVServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_OBTIENE_PERIODO_CONSIGServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_ORDEN_FACTURAServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_RAZON_SOCIALServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_UPDATE_LECTURA_AVISOServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_VALIDA_TOKENServiceStub;
import functions.rfc.sap.document.sap_com.BAPISFLDRA;
import functions.rfc.sap.document.sap_com.CERRADO_type1;
import functions.rfc.sap.document.sap_com.Char1;
import functions.rfc.sap.document.sap_com.Char10;
import functions.rfc.sap.document.sap_com.Char16;
import functions.rfc.sap.document.sap_com.Char2;
import functions.rfc.sap.document.sap_com.Char20;
import functions.rfc.sap.document.sap_com.Char241;
import functions.rfc.sap.document.sap_com.Char4;
import functions.rfc.sap.document.sap_com.Cuky5;
import functions.rfc.sap.document.sap_com.Date;
import functions.rfc.sap.document.sap_com.Date10;
import functions.rfc.sap.document.sap_com.GJAHR_type1;
import functions.rfc.sap.document.sap_com.GenericDate;
import functions.rfc.sap.document.sap_com.I_AVISOID_type1;
import functions.rfc.sap.document.sap_com.I_BUKRS_type1;
import functions.rfc.sap.document.sap_com.I_EBELN_type1;
import functions.rfc.sap.document.sap_com.I_EKORG_type1;
import functions.rfc.sap.document.sap_com.I_ESTADO_type1;
import functions.rfc.sap.document.sap_com.I_ESTATUS_type1;
import functions.rfc.sap.document.sap_com.I_EVENTO_type1;
import functions.rfc.sap.document.sap_com.I_FLAG_type1;
import functions.rfc.sap.document.sap_com.I_FOLIO_type1;
import functions.rfc.sap.document.sap_com.I_IDIOMA_type1;
import functions.rfc.sap.document.sap_com.I_LIFNR_type1;
import functions.rfc.sap.document.sap_com.I_MAIL_type1;
import functions.rfc.sap.document.sap_com.I_PERIODO_type0;
import functions.rfc.sap.document.sap_com.I_PSW_ANTIGUO_type1;
import functions.rfc.sap.document.sap_com.I_PSW_CONF_type1;
import functions.rfc.sap.document.sap_com.I_PSW_NUEVO_type1;
import functions.rfc.sap.document.sap_com.I_TIPO_AVISO_type1;
import functions.rfc.sap.document.sap_com.I_TIPO_PRINT_type1;
import functions.rfc.sap.document.sap_com.I_TIPO_type1;
import functions.rfc.sap.document.sap_com.I_TOKEN_type1;
import functions.rfc.sap.document.sap_com.I_WAERS_type1;
import functions.rfc.sap.document.sap_com.I_WERKS_type1;
import functions.rfc.sap.document.sap_com.MONAT_type1;
import functions.rfc.sap.document.sap_com.Numeric10;
import functions.rfc.sap.document.sap_com.OPTION_type1;
import functions.rfc.sap.document.sap_com.SIGN_type1;
import functions.rfc.sap.document.sap_com.ZST_PERIODO;
import functions.rfc.sap.document.sap_com.ZWS_AREA_RESPStub;
import functions.rfc.sap.document.sap_com.ZWS_CAMBIO_PSWD_PROVStub;
import functions.rfc.sap.document.sap_com.ZWS_CONFIRMA_ESTADO_CUENTAStub;
import functions.rfc.sap.document.sap_com.ZWS_CONTADOR_AVISOS_NLEStub;
import functions.rfc.sap.document.sap_com.ZWS_DATOS_PROVEEDORStub;
import functions.rfc.sap.document.sap_com.ZWS_ENVIO_TOKEN;
import functions.rfc.sap.document.sap_com.ZWS_ENVIO_TOKENStub;
import functions.rfc.sap.document.sap_com.ZWS_ESTADO_CUENTAStub;
import functions.rfc.sap.document.sap_com.ZWS_ESTATUS_PORTALStub;
import functions.rfc.sap.document.sap_com.ZWS_LISTA_DIVISIONStub;
import functions.rfc.sap.document.sap_com.ZWS_LISTA_FACStub;
import functions.rfc.sap.document.sap_com.ZWS_OBTIENE_AVISOSStub;
import functions.rfc.sap.document.sap_com.ZWS_ORDEN_FACTURAStub;
import functions.rfc.sap.document.sap_com.ZWS_RAZON_SOCIALStub;
import functions.rfc.sap.document.sap_com.ZWS_UPDATE_LECTURA_AVISOStub;
import functions.rfc.sap.document.sap_com.ZWS_VALIDA_TOKENStub;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AREA_RESP;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AREA_RESPResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_CAMBIO_PSWD_PROV;
import functions.rfc.sap.document.sap_com.Z_FE_FM_CAMBIO_PSWD_PROVResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_CONFIRMA_ESTADO_CUENTA;
import functions.rfc.sap.document.sap_com.Z_FE_FM_CONFIRMA_ESTADO_CUENTAResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_CONTADOR_AVISOS_NLE;
import functions.rfc.sap.document.sap_com.Z_FE_FM_CONTADOR_AVISOS_NLEResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_DATOS_PROVEEDOR;
import functions.rfc.sap.document.sap_com.Z_FE_FM_DATOS_PROVEEDORResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_DET_FACT_CONSIG;
import functions.rfc.sap.document.sap_com.Z_FE_FM_DET_FACT_CONSIGResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_DIVISION;
import functions.rfc.sap.document.sap_com.Z_FE_FM_DIVISIONResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_ENVIO_TOKEN;
import functions.rfc.sap.document.sap_com.Z_FE_FM_ENVIO_TOKENResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_ESTADO_CUENTA;
import functions.rfc.sap.document.sap_com.Z_FE_FM_ESTADO_CUENTAResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_ESTATUS_PORTAL;
import functions.rfc.sap.document.sap_com.Z_FE_FM_ESTATUS_PORTALResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_LISTA_FAC;
import functions.rfc.sap.document.sap_com.Z_FE_FM_LISTA_FACResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_AVISOS;
import functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_AVISOSResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_DAT_ACCT_PROV;
import functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_DAT_ACCT_PROVResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_PERIODO_CONSIG;
import functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_PERIODO_CONSIGResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_ORDEN_FACTURA;
import functions.rfc.sap.document.sap_com.Z_FE_FM_ORDEN_FACTURAResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_RAZON_SOCIAL;
import functions.rfc.sap.document.sap_com.Z_FE_FM_RAZON_SOCIALResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_UPDATE_LECTURA_AVISO;
import functions.rfc.sap.document.sap_com.Z_FE_FM_UPDATE_LECTURA_AVISOResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_VALIDACION_TOKEN;
import functions.rfc.sap.document.sap_com.Z_FE_FM_VALIDACION_TOKENResponse;

@Repository
public class ProviderDao {
	
	public final static Logger LOGGER = LogManager.getLogger(ProviderDao.class);
	
	public Z_FE_FM_DATOS_PROVEEDORResponse findProvider(String provider) throws RemoteException{
		SI_ZWS_DATOS_PROVEEDORServiceStub stub = new SI_ZWS_DATOS_PROVEEDORServiceStub();
//		ZWS_DATOS_PROVEEDORStub stub = new ZWS_DATOS_PROVEEDORStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
//		Char10 providerChar = new Char10();
		I_LIFNR_type1 providerChar = new I_LIFNR_type1();
		providerChar.setI_LIFNR_type0(provider);
		Z_FE_FM_DATOS_PROVEEDOR provedor = new Z_FE_FM_DATOS_PROVEEDOR();
		provedor.setI_LIFNR(providerChar);
		
		Z_FE_FM_DATOS_PROVEEDORResponse response = stub.sI_ZWS_DATOS_PROVEEDOR(provedor);
		LOGGER.info("Datos Provedor: " + response.getE_NAME1() + " " + response.getE_NAME2() + " " + response.getE_NAME3());
		return response;
		
	}
	
	public Z_FE_FM_RAZON_SOCIALResponse findRazonSocial(String lifnr) throws AxisFault {
		SI_ZWS_RAZON_SOCIALServiceStub stub = new SI_ZWS_RAZON_SOCIALServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
		i_lifnr.setI_LIFNR_type0(lifnr);
		Z_FE_FM_RAZON_SOCIAL razonSocial = new Z_FE_FM_RAZON_SOCIAL();
		razonSocial.setI_LIFNR(i_lifnr);
		try {
			Z_FE_FM_RAZON_SOCIALResponse response = stub.sI_ZWS_RAZON_SOCIAL(razonSocial);
			LOGGER.info("RazonSocial data: " + response);
			return response;
		} catch (Exception e) {
			LOGGER.error("Error Razon Social:",e);
			return null;
		}
	}
	
	public Z_FE_FM_LISTA_FACResponse findFacturas(String cmbRazonSocial, String fechaIni, String fechaFin,String cmbEstado,String lifnr, String language, String ekorg) throws AxisFault {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
//		ZWS_LISTA_FACStub stub = new ZWS_LISTA_FACStub();
		SI_ZWS_LISTA_FACServiceStub stub = new SI_ZWS_LISTA_FACServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
//		Char1 sign = new Char1();
		SIGN_type1 sign = new SIGN_type1();
//		Char2 option = new Char2();
		OPTION_type1 option = new OPTION_type1();
		Date dateHigh = new Date();
		Date dateLow = new Date();
//		Char4 razonSocial = new Char4();
		I_BUKRS_type1 razonSocial = new I_BUKRS_type1();
//		Char1 status = new Char1();
		I_ESTATUS_type1 status = new I_ESTATUS_type1();
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//		Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
//		Char4 i_ekorg = new Char4();
		I_EKORG_type1 i_ekorg = new I_EKORG_type1();
		i_lifnr.setI_LIFNR_type0(lifnr);
		GenericDate startdt = new GenericDate();
		startdt.setGenericDate(fechaIni);
		GenericDate enddt = new GenericDate();
		enddt.setGenericDate(fechaFin);
		dateHigh.setObject(enddt);
		dateLow.setObject(startdt);
		sign.setSIGN_type0("I");
		option.setOPTION_type0("BT");		
		razonSocial.setI_BUKRS_type0(cmbRazonSocial);
		status.setI_ESTATUS_type0(cmbEstado);
		Z_FE_FM_LISTA_FAC listFac = new Z_FE_FM_LISTA_FAC();
		BAPISFLDRA bldat = new BAPISFLDRA();
		bldat.setSIGN(sign);
		bldat.setOPTION(option);
		bldat.setHIGH(dateHigh);
		bldat.setLOW(dateLow);
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());
		i_ekorg.setI_EKORG_type0(ekorg);
		
		listFac.setI_BLDAT(bldat);
		listFac.setI_BUKRS(razonSocial);
		listFac.setI_ESTATUS(status);
		listFac.setI_LIFNR(i_lifnr);
		listFac.setI_IDIOMA(i_idioma);
		listFac.setI_EKORG(i_ekorg);
				
		try {
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
			Z_FE_FM_LISTA_FACResponse response = stub.sI_ZWS_LISTA_FAC(listFac);
			LOGGER.info("z_FE_FM_LISTA_FAC data: " + response.getE_MSG() + "/" + response.getE_TYPE().toString());
			return response;
		} catch (RemoteException e) {
			LOGGER.error("Error Lista Fac:",e);
			return null;
		}
	}
	
	public Z_FE_FM_ESTATUS_PORTALResponse findInvoiceStatus(String cmbRazonSocial, String fechaIni, String fechaFin,String lifnr, String language) throws AxisFault {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes 
//		ZWS_ESTATUS_PORTALStub stub = new ZWS_ESTATUS_PORTALStub();
		SI_ZWS_ESTATUS_PORTALServiceStub stub = new SI_ZWS_ESTATUS_PORTALServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
//		Char1 sign = new Char1();
		SIGN_type1 sign = new SIGN_type1();
//		Char2 option = new Char2();
		OPTION_type1 option = new OPTION_type1();
		Date dateHigh = new Date();
		Date dateLow = new Date();
//		Char4 razonSocial = new Char4();
		I_BUKRS_type1 razonSocial = new I_BUKRS_type1();
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//		Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
		i_lifnr.setI_LIFNR_type0(lifnr);
		GenericDate startdt = new GenericDate();
		GenericDate enddt = new GenericDate();
		startdt.setGenericDate(fechaIni);
		enddt.setGenericDate(fechaFin);
		dateHigh.setObject(enddt);
		dateLow.setObject(startdt);
		sign.setSIGN_type0("I");
		option.setOPTION_type0("BT");		
		razonSocial.setI_BUKRS_type0(cmbRazonSocial);
		BAPISFLDRA bldat = new BAPISFLDRA();
		bldat.setSIGN(sign);
		bldat.setOPTION(option);
		bldat.setHIGH(dateHigh);
		bldat.setLOW(dateLow);
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());
		
		Z_FE_FM_ESTATUS_PORTAL status = new Z_FE_FM_ESTATUS_PORTAL();
		status.setI_BLDAT(bldat);
		status.setI_BUKRS(razonSocial);
		status.setI_LIFNR(i_lifnr);
		status.setI_IDIOMA(i_idioma);
		try {
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
			Z_FE_FM_ESTATUS_PORTALResponse response = stub.sI_ZWS_ESTATUS_PORTAL(status);
			LOGGER.info("Z_FE_FM_ESTATUS_PORTALResponse:"+ response);
			return response;
		} catch (Exception e) {
			LOGGER.error("Error Estatus Integración:",e);
			return null;
		}
	}
	
	public Z_FE_FM_AREA_RESPResponse findGerencia(String bukrs) throws AxisFault {
//		ZWS_AREA_RESPStub stub = new ZWS_AREA_RESPStub();
		SI_ZWS_AREA_RESPServiceStub stub = new SI_ZWS_AREA_RESPServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_AREA_RESP area = new Z_FE_FM_AREA_RESP();		
//		Char4 i_bukrs = new Char4();
		I_BUKRS_type1 i_bukrs = new I_BUKRS_type1();
		i_bukrs.setI_BUKRS_type0(bukrs);
		area.setI_BUKRS(i_bukrs);
		
		Z_FE_FM_AREA_RESPResponse response;
		try {
			response = stub.sI_ZWS_AREA_RESP(area);
		} catch (Exception e) {
			LOGGER.error("Error al obtener area", e);
			return null;
		}
		
		return response;
		
	}
	/** this method will not be used for BENTELER **/
	public Z_FE_FM_DIVISIONResponse findDivision(String bukrs) throws AxisFault {
		ZWS_LISTA_DIVISIONStub stub = new ZWS_LISTA_DIVISIONStub();
		
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_DIVISION division = new Z_FE_FM_DIVISION();
		Char4 i_bukrs = new Char4();
		i_bukrs.setChar4(bukrs);
		division.setI_BUKRS(i_bukrs);
		
		Z_FE_FM_DIVISIONResponse response;
		try {
			response = stub.z_FE_FM_DIVISION(division);
		} catch (Exception e) {
			LOGGER.error("Error al obtener division",e);
			return null;
		}
		return response;
	}

	public Z_FE_FM_ORDEN_FACTURAResponse findPendingInvoices(String bukrs, String ekorg, String lifnr, String fechaIni, 
			String fechaFin, String ebeln, String language, Integer receptionType, String currency) throws AxisFault{
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
//		ZWS_ORDEN_FACTURAStub stub = new ZWS_ORDEN_FACTURAStub();
		SI_ZWS_ORDEN_FACTURAServiceStub stub = new SI_ZWS_ORDEN_FACTURAServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		options.setTimeOutInMilliSeconds(timeOutInMilliSeconds);
		Z_FE_FM_ORDEN_FACTURA invoice = new Z_FE_FM_ORDEN_FACTURA();
//		Char1 sign = new Char1();
		SIGN_type1 sign = new SIGN_type1();
//		Char2 option = new Char2();
		OPTION_type1 option = new OPTION_type1();
		Date dateHigh = new Date();
		Date dateLow = new Date();
//		Char4 i_bukrs = new Char4();
		I_BUKRS_type1 i_bukrs = new I_BUKRS_type1();
//		Char10 i_ebeln = new Char10();
		I_EBELN_type1 i_ebeln = new I_EBELN_type1();
//		Char4 i_ekorg = new Char4();
		I_EKORG_type1 i_ekorg = new I_EKORG_type1();
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//		Char1 i_flag = new Char1();
		I_FLAG_type1 i_flag = new I_FLAG_type1();
//		Numeric10 i_folio = new Numeric10();
		I_FOLIO_type1 i_folio = new I_FOLIO_type1();
		BAPISFLDRA bapisfldra = new BAPISFLDRA();
//		Char1 i_tipo = new Char1();
		I_TIPO_type1 i_tipo = new I_TIPO_type1();
//		Cuky5 i_waers = new Cuky5();
		I_WAERS_type1 i_waers = new I_WAERS_type1();
//		Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
		if(ebeln.length() < 10 && receptionType == 4) {
			for(int i = 10 - ebeln.length();i > 0;i--){
				ebeln = "0" + ebeln;
			}
		}
				
		i_bukrs.setI_BUKRS_type0(bukrs);
		i_ebeln.setI_EBELN_type0(ebeln == null ? "" : ebeln);
		i_ekorg.setI_EKORG_type0(ekorg);
		i_lifnr.setI_LIFNR_type0(lifnr);
		i_flag.setI_FLAG_type0("");
		i_folio.setI_FOLIO_type0("");
		sign.setSIGN_type0("I");
		option.setOPTION_type0("BT");
		GenericDate startdt = new GenericDate();
		GenericDate enddt = new GenericDate();
		startdt.setGenericDate(fechaIni);
		enddt.setGenericDate(fechaFin);
		dateLow.setObject(startdt);
		dateHigh.setObject(enddt);
		bapisfldra.setSIGN(sign);
		bapisfldra.setOPTION(option);
		bapisfldra.setHIGH(dateHigh);
		bapisfldra.setLOW(dateLow);
		i_tipo.setI_TIPO_type0(receptionType.toString());
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());
		if(currency != null && currency.length() > 0)
			i_waers.setI_WAERS_type0(currency);
		
		invoice.setI_BUKRS(i_bukrs);
		invoice.setI_EBELN(i_ebeln);
		invoice.setI_EKORG(i_ekorg);
		invoice.setI_LIFNR(i_lifnr);
		invoice.setI_FLAG(i_flag);
		invoice.setI_FOLIO(i_folio);
		invoice.setI_AEDAT(bapisfldra);
		invoice.setI_TIPO(i_tipo);
		invoice.setI_IDIOMA(i_idioma);
		if(currency != null && currency.length() > 0)
			invoice.setI_WAERS(i_waers);
		
		Z_FE_FM_ORDEN_FACTURAResponse response;
		try {
			response = stub.sI_ZWS_ORDEN_FACTURA(invoice);
		} catch (Exception e) {
			LOGGER.error("Error al obtener Lista OC sin facturar",e);
			return null;
		}
		return response;
	}
	
	public Z_FE_FM_ESTADO_CUENTAResponse findAccountStatus(String lifnr, String bukrs, String language) throws RemoteException,AxisFault {
		LOGGER.info("Finding account status with bukrs: " + bukrs + ",lifnr: " + lifnr + ",language: " + language);
//		ZWS_ESTADO_CUENTAStub stub = new ZWS_ESTADO_CUENTAStub();
		SI_ZWS_ESTADO_CUENTAServiceStub stub = new SI_ZWS_ESTADO_CUENTAServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_ESTADO_CUENTA account = new Z_FE_FM_ESTADO_CUENTA();
//		Char4 i_burks = new Char4();
		I_BUKRS_type1 i_burks = new I_BUKRS_type1();
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//		Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
		
		i_burks.setI_BUKRS_type0(bukrs);
		i_lifnr.setI_LIFNR_type0(lifnr);
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());
		
		account.setI_BUKRS(i_burks);
		account.setI_LIFNR(i_lifnr);
		account.setI_IDIOMA(i_idioma);
		
		Z_FE_FM_ESTADO_CUENTAResponse response;
		try {
			response = stub.sI_ZWS_ESTADO_CUENTA(account);
		} catch (Exception e) {
			LOGGER.error("Error al obtener Estado de cuenta",e);
			return null;
		}
		
		return response;
	}
	
	public Z_FE_FM_CONFIRMA_ESTADO_CUENTAResponse setAccountStatus(String lifnr, String bukrs, String language, String estado) throws RemoteException, AxisFault, Exception {
		LOGGER.info("Set account status parameters lifnr:" + lifnr + ", bukrs: " + bukrs + ",language: " + language);
//		ZWS_CONFIRMA_ESTADO_CUENTAStub stub = new ZWS_CONFIRMA_ESTADO_CUENTAStub();
		SI_ZWS_CONFIRMA_ESTADO_CUENTAServiceStub stub = new SI_ZWS_CONFIRMA_ESTADO_CUENTAServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_CONFIRMA_ESTADO_CUENTA account = new Z_FE_FM_CONFIRMA_ESTADO_CUENTA();
		
//		Char4 i_burks = new Char4();
		I_BUKRS_type1 i_burks = new I_BUKRS_type1();
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//		Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
//		Char1 i_estado = new Char1();
		I_ESTADO_type1 i_estado = new I_ESTADO_type1();
		
		i_burks.setI_BUKRS_type0(bukrs);
		i_lifnr.setI_LIFNR_type0(lifnr);
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());
		i_estado.setI_ESTADO_type0(estado);		
		
		account.setI_BUKRS(i_burks);
		account.setI_LIFNR(i_lifnr);
		account.setI_IDIOMA(i_idioma);
		account.setI_ESTADO(i_estado);
		
		return stub.sI_ZWS_CONFIRMA_ESTADO_CUENTA(account);
	}

	public Z_FE_FM_CAMBIO_PSWD_PROVResponse changePassword(String lifnr,
			String oldPass, String newPass, String newPassReview,
			String language, String email) throws AxisFault, RemoteException {
//		ZWS_CAMBIO_PSWD_PROVStub stub = new ZWS_CAMBIO_PSWD_PROVStub();
		SI_ZWS_CAMBIO_PSWD_PROVServiceStub stub = new SI_ZWS_CAMBIO_PSWD_PROVServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_CAMBIO_PSWD_PROV provider = new Z_FE_FM_CAMBIO_PSWD_PROV();
		
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//		Char16 i_psw_antiguo = new Char16();
		I_PSW_ANTIGUO_type1 i_psw_antiguo = new I_PSW_ANTIGUO_type1();
//		Char16 i_psw_nuevo = new Char16();
		I_PSW_NUEVO_type1 i_psw_nuevo = new I_PSW_NUEVO_type1();
//		Char16 i_psw_conf = new Char16();
		I_PSW_CONF_type1 i_psw_conf = new I_PSW_CONF_type1();
//		Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1(); 
//		Char1 i_tipo_print = new Char1();
		I_TIPO_PRINT_type1 i_tipo_print = new I_TIPO_PRINT_type1();
//		Char241 i_mail = new Char241();
		I_MAIL_type1 i_mail = new I_MAIL_type1();
		
		i_lifnr.setI_LIFNR_type0(lifnr);
		i_psw_antiguo.setI_PSW_ANTIGUO_type0(oldPass);
		i_psw_nuevo.setI_PSW_NUEVO_type0(newPass);
		i_psw_conf.setI_PSW_CONF_type0(newPassReview);
		i_idioma.setI_IDIOMA_type0(language);
		i_mail.setI_MAIL_type0(email);
		if(oldPass == null){
			i_tipo_print.setI_TIPO_PRINT_type0("2");
		}else {
			i_tipo_print.setI_TIPO_PRINT_type0("1");
		}
		
		
		provider.setI_LIFNR(i_lifnr);
		if(oldPass != null)
			provider.setI_PSW_ANTIGUO(i_psw_antiguo);
		provider.setI_PSW_NUEVO(i_psw_nuevo);
		provider.setI_PSW_CONF(i_psw_conf);
		provider.setI_IDIOMA(i_idioma);
		provider.setI_TIPO_PRINT(i_tipo_print);
		provider.setI_MAIL(i_mail);
				
		return stub.sI_ZWS_CAMBIO_PSWD_PROV(provider);
	}
	
	public Z_FE_FM_OBTIENE_AVISOSResponse getNotifications(String lifnr, String bukrs, String language, String tipoAviso) throws AxisFault,RemoteException {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
//		ZWS_OBTIENE_AVISOSStub stub = new ZWS_OBTIENE_AVISOSStub();
		SI_ZWS_OBTIENE_AVISOSServiceStub stub = new SI_ZWS_OBTIENE_AVISOSServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
		Z_FE_FM_OBTIENE_AVISOS notifications = new Z_FE_FM_OBTIENE_AVISOS();
		
//		Char4 i_bukrs = new Char4();
		I_BUKRS_type1 i_bukrs = new I_BUKRS_type1();
//		Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1(); 
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//		Char1 i_tipo_aviso = new Char1();
		I_TIPO_AVISO_type1 i_tipo_aviso = new I_TIPO_AVISO_type1();
		i_bukrs.setI_BUKRS_type0(bukrs == null ? "" : bukrs);
		i_lifnr.setI_LIFNR_type0(lifnr);
		i_idioma.setI_IDIOMA_type0(language);
		i_tipo_aviso.setI_TIPO_AVISO_type0(tipoAviso);
		
		if(bukrs != null && !bukrs.equals("")) notifications.setI_BUKRS(i_bukrs);
		notifications.setI_IDIOMA(i_idioma);
		notifications.setI_LIFNR(i_lifnr);		
		notifications.setI_TIPO_AVISO(i_tipo_aviso);
		notifications.setI_IDIOMA(i_idioma);
		return stub.sI_ZWS_OBTIENE_AVISOS(notifications);
	}
	
	public Z_FE_FM_ENVIO_TOKENResponse findToken(String lifnr, String email) throws AxisFault,RemoteException {
//		ZWS_ENVIO_TOKENStub stub = new ZWS_ENVIO_TOKENStub();
		SI_ZWS_ENVIO_TOKENServiceStub stub = new SI_ZWS_ENVIO_TOKENServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_ENVIO_TOKEN token = new Z_FE_FM_ENVIO_TOKEN();
		
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//		Char241 i_mail = new Char241();
		I_MAIL_type1 i_mail = new I_MAIL_type1();
		i_lifnr.setI_LIFNR_type0(lifnr);
		i_mail.setI_MAIL_type0(email);
		
		token.setI_LIFNR(i_lifnr);
		token.setI_MAIL(i_mail);
		
		return stub.sI_ZWS_ENVIO_TOKEN(token);
	}
	
	public Z_FE_FM_VALIDACION_TOKENResponse validateToken(String lifnr, String email, String token) throws AxisFault, RemoteException {
//		ZWS_VALIDA_TOKENStub stub = new  ZWS_VALIDA_TOKENStub();
		SI_ZWS_VALIDA_TOKENServiceStub stub = new SI_ZWS_VALIDA_TOKENServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_VALIDACION_TOKEN validaToken = new Z_FE_FM_VALIDACION_TOKEN();
		
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//		Char241 i_mail = new Char241();
		I_MAIL_type1 i_mail = new I_MAIL_type1();
//		Char20 i_token = new Char20(); 
		I_TOKEN_type1 i_token = new I_TOKEN_type1();
		i_lifnr.setI_LIFNR_type0(lifnr);
		i_mail.setI_MAIL_type0(email);
		i_token.setI_TOKEN_type0(token);
		
		validaToken.setI_LIFNR(i_lifnr);
		validaToken.setI_MAIL(i_mail);
		validaToken.setI_TOKEN(i_token);		
		
		return stub.sI_ZWS_VALIDA_TOKEN(validaToken);
	}
	
	public Z_FE_FM_CONTADOR_AVISOS_NLEResponse findUnreadNotificationsNumber(String lifrn) throws AxisFault, RemoteException {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
//		ZWS_CONTADOR_AVISOS_NLEStub stub = new ZWS_CONTADOR_AVISOS_NLEStub();
		SI_ZWS_CONTADOR_AVISOS_NLEServiceStub stub = new SI_ZWS_CONTADOR_AVISOS_NLEServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_CONTADOR_AVISOS_NLE contador = new Z_FE_FM_CONTADOR_AVISOS_NLE();
		
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
		i_lifnr.setI_LIFNR_type0(lifrn);
		contador.setI_LIFNR(i_lifnr);
		stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
		
		return stub.sI_ZWS_CONTADOR_AVISOS_NLE(contador);
	}
	
	public Z_FE_FM_UPDATE_LECTURA_AVISOResponse setNotificationStatus(String lifrn, String bukrs, String idaviso, String evento) throws AxisFault, RemoteException {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
//		ZWS_UPDATE_LECTURA_AVISOStub stub = new ZWS_UPDATE_LECTURA_AVISOStub();
		SI_ZWS_UPDATE_LECTURA_AVISOServiceStub stub = new SI_ZWS_UPDATE_LECTURA_AVISOServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_UPDATE_LECTURA_AVISO aviso = new Z_FE_FM_UPDATE_LECTURA_AVISO();
		
//		Char10 i_avisoid = new Char10();
		I_AVISOID_type1 i_avisoid = new I_AVISOID_type1();
//		Char4 i_bukrs = new Char4();
		I_BUKRS_type1 i_bukrs = new I_BUKRS_type1();
//		Char1 i_evento = new Char1();
		I_EVENTO_type1 i_evento = new I_EVENTO_type1();
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
		
		i_avisoid.setI_AVISOID_type0(idaviso);
		i_bukrs.setI_BUKRS_type0(bukrs);
		i_evento.setI_EVENTO_type0(evento);
		i_lifnr.setI_LIFNR_type0(lifrn);
		
		aviso.setI_AVISOID(i_avisoid);
		aviso.setI_BUKRS(i_bukrs);
		aviso.setI_EVENTO(i_evento);
		aviso.setI_LIFNR(i_lifnr);
		
		stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
		
		return stub.sI_ZWS_UPDATE_LECTURA_AVISO(aviso);
	}
	
	public Z_FE_FM_OBTIENE_PERIODO_CONSIGResponse findPeriods(String lifnr, String bukrs) throws RemoteException {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
		SI_ZWS_OBTIENE_PERIODO_CONSIGServiceStub stub = new SI_ZWS_OBTIENE_PERIODO_CONSIGServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_OBTIENE_PERIODO_CONSIG consig = new Z_FE_FM_OBTIENE_PERIODO_CONSIG();
		I_BUKRS_type1 i_bukrs = new I_BUKRS_type1();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
		i_bukrs.setI_BUKRS_type0(bukrs);
		i_lifnr.setI_LIFNR_type0(lifnr);
		consig.setI_BUKRS(i_bukrs);
		consig.setI_LIFNR(i_lifnr);
		
		stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
		
		return stub.sI_ZWS_OBTIENE_PERIODO_CONSIG(consig);
	}
	
	public Z_FE_FM_DET_FACT_CONSIGResponse findConsignaciones(ConsignacionRequestDto consignacionRequestDto) throws RemoteException {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
		SI_ZWS_DET_FACT_CONSIGServiceStub stub = new SI_ZWS_DET_FACT_CONSIGServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_DET_FACT_CONSIG consignacion = new Z_FE_FM_DET_FACT_CONSIG();
		
		I_BUKRS_type1 i_bukrs = new I_BUKRS_type1();
		I_WERKS_type1 i_werks = new I_WERKS_type1();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
		I_PERIODO_type0 i_periodo = new I_PERIODO_type0();
		ZST_PERIODO period = new ZST_PERIODO();
		
		CERRADO_type1 cerrado = new CERRADO_type1();
		Date fin = new Date();
		GJAHR_type1 gjahr = new GJAHR_type1();
		Date inicio = new Date();
		MONAT_type1 monat = new MONAT_type1();
		
		i_bukrs.setI_BUKRS_type0(consignacionRequestDto.getBukrs());
		i_werks.setI_WERKS_type0(consignacionRequestDto.getWerks());
		i_idioma.setI_IDIOMA_type0(consignacionRequestDto.getIdioma());
		i_lifnr.setI_LIFNR_type0(consignacionRequestDto.getLifnr());
		
		
		period.setCERRADO(cerrado);
		period.setFIN(fin);
		period.setGJAHR(gjahr);
		period.setINICIO(inicio);
		period.setMONAT(monat);
		i_periodo.addItem(period);
		
		consignacion.setI_BUKRS(i_bukrs);
		consignacion.setI_IDIOMA(i_idioma);
		consignacion.setI_LIFNR(i_lifnr);
		consignacion.setI_PERIODO(i_periodo);
		consignacion.setI_WERKS(i_werks);
		
		stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);

		return stub.sI_ZWS_DET_FACT_CONSIG(consignacion); 
	}
	
	public Z_FE_FM_OBTIENE_DAT_ACCT_PROVResponse findAccounts(String lifnr, String bukrs, String language) throws RemoteException {
		final int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
		SI_ZWS_OBTIENE_DAT_ACCT_PROVServiceStub stub = new SI_ZWS_OBTIENE_DAT_ACCT_PROVServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		
		Z_FE_FM_OBTIENE_DAT_ACCT_PROV datAccount = new Z_FE_FM_OBTIENE_DAT_ACCT_PROV();
		I_BUKRS_type1 i_bukrs = new I_BUKRS_type1();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
		
		i_bukrs.setI_BUKRS_type0(bukrs);
		i_idioma.setI_IDIOMA_type0(language);
		i_lifnr.setI_LIFNR_type0(lifnr);
		
		datAccount.setI_BUKRS(i_bukrs);
		datAccount.setI_IDIOMA(i_idioma);
		datAccount.setI_LIFNR(i_lifnr);
		
		return stub.sI_ZWS_OBTIENE_DAT_ACCT_PROV(datAccount);
	}

}
