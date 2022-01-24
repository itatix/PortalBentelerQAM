package com.wise.service;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wise.dao.ProviderDao;
import com.wise.model.ConsignacionRequestDto;

import functions.rfc.sap.document.sap_com.Z_FE_FM_AREA_RESPResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_CAMBIO_PSWD_PROVResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_CONFIRMA_ESTADO_CUENTAResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_CONTADOR_AVISOS_NLEResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_DATOS_PROVEEDORResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_DET_FACT_CONSIGResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_DIVISIONResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_ENVIO_TOKEN;
import functions.rfc.sap.document.sap_com.Z_FE_FM_ENVIO_TOKENResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_ESTADO_CUENTAResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_ESTATUS_PORTALResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_LISTA_FACResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_AVISOSResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_DAT_ACCT_PROVResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_PERIODO_CONSIGResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_ORDEN_FACTURAResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_RAZON_SOCIALResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_UPDATE_LECTURA_AVISOResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_VALIDACION_TOKENResponse;

@Service
public class ProviderService {
	
	@Autowired
	private ProviderDao providerDao;
	
	@Transactional(readOnly = true)
	public Z_FE_FM_DATOS_PROVEEDORResponse getProvider(String provider) throws RemoteException {
		return providerDao.findProvider(provider);
	}
	
	@Transactional(readOnly = true)
	public Z_FE_FM_RAZON_SOCIALResponse getRazonSocial(String lifnr) throws AxisFault {
		return providerDao.findRazonSocial(lifnr);
	}
	
	@Transactional(readOnly = true)
	public Z_FE_FM_LISTA_FACResponse getListaFactura(String cmbRazonSocial, String fechaIni, String fechaFin,String cmbEstado,String lifnr, String language, String ekorg) throws AxisFault {
		return providerDao.findFacturas(cmbRazonSocial, fechaIni, fechaFin, cmbEstado, lifnr, language, ekorg);
	}
	
	@Transactional(readOnly = true)
	public Z_FE_FM_ESTATUS_PORTALResponse getEstatusIntegracion(String cmbRazonSocial, String fechaIni, String fechaFin,String lifnr, String language) throws AxisFault {
		return providerDao.findInvoiceStatus(cmbRazonSocial, fechaIni, fechaFin, lifnr, language);
	}
	
	@Transactional(readOnly = true)
	public Z_FE_FM_AREA_RESPResponse getArea(String bukrs) throws AxisFault {
		return providerDao.findGerencia(bukrs);
	}
	
	@Transactional(readOnly = true)
	public Z_FE_FM_DIVISIONResponse getDivision(String bukrs) throws AxisFault {
		return providerDao.findDivision(bukrs);
	}

	public Z_FE_FM_ORDEN_FACTURAResponse getPendingInvoices(String bukrs, String ekorg, String lifnr, String fechaIni, String fechaFin, String ebeln, String language, Integer receptionType, String currency) throws AxisFault {		
		return providerDao.findPendingInvoices(bukrs, ekorg, lifnr, fechaIni, fechaFin, ebeln, language, receptionType, currency);
	}
	
	public Z_FE_FM_ESTADO_CUENTAResponse getAccountStatus(String lifnr, String bukrs, String language) throws Exception, RemoteException {
		return providerDao.findAccountStatus(lifnr, bukrs, language);
	}
	
	public Z_FE_FM_CONFIRMA_ESTADO_CUENTAResponse setAccountStatus(String lifnr, String bukrs, String language, String estado) throws Exception, RemoteException {
		return providerDao.setAccountStatus(lifnr, bukrs, language, estado);
	}

	public Z_FE_FM_CAMBIO_PSWD_PROVResponse changePassword(String lifnr,
			String oldPass, String newPass, String newPassReview,
			String language, String email) throws AxisFault, RemoteException {
		
		return providerDao.changePassword(lifnr, oldPass, newPass, newPassReview, language, email);
	}
	
	public Z_FE_FM_OBTIENE_AVISOSResponse getNotifications(String lifnr, String bukrs, String language, String tipoAviso) throws AxisFault,RemoteException {
		return providerDao.getNotifications(lifnr, bukrs, language, tipoAviso);
	}
	
	public Z_FE_FM_ENVIO_TOKENResponse getToken(String lifnr, String email) throws AxisFault,RemoteException {
		return providerDao.findToken(lifnr, email);
	}
	
	public Z_FE_FM_VALIDACION_TOKENResponse validaToken(String lifnr, String email, String token) throws AxisFault, RemoteException {
		return providerDao.validateToken(lifnr, email, token);
	}
	
	public Z_FE_FM_CONTADOR_AVISOS_NLEResponse getUnreadNotificationsNumber(String lifnr) throws AxisFault, RemoteException {
		return providerDao.findUnreadNotificationsNumber(lifnr);
	}
	
	public Z_FE_FM_UPDATE_LECTURA_AVISOResponse setNotificationStatus(String lifrn, String bukrs, String idaviso, String evento) throws AxisFault, RemoteException {
		return providerDao.setNotificationStatus(lifrn, bukrs, idaviso, evento);
	}
	
	public Z_FE_FM_OBTIENE_PERIODO_CONSIGResponse getPeriods(String lifnr, String bukrs) throws RemoteException {
		return providerDao.findPeriods(lifnr, bukrs);
	}
	
	public Z_FE_FM_DET_FACT_CONSIGResponse getConsignacion(ConsignacionRequestDto requestDto) throws RemoteException {
		return providerDao.findConsignaciones(requestDto);
	}
	
	@Transactional(readOnly = true)
	public Z_FE_FM_OBTIENE_DAT_ACCT_PROVResponse getAccounts(String lifrn, String bukrs, String language) throws RemoteException {
		return providerDao.findAccounts(lifrn, bukrs, language);
	}

}
