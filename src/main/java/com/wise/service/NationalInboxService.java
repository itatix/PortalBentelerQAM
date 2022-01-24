package com.wise.service;

import java.io.IOException;
import java.rmi.RemoteException;
import java.text.ParseException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wise.dao.NationalInboxDao;
import com.wise.model.FreightDto;

import functions.rfc.sap.document.sap_com.Z_FI_AGREGAR_BUZON_FLETESResponse;
import functions.rfc.sap.document.sap_com.Z_FI_GET_REFER_EMBARResponse;
import functions.rfc.sap.document.sap_com.Z_FI_GET_TICKETSResponse;
import functions.rfc.sap.document.sap_com.Z_FI_GET_TIPO_SERVICIOResponse;
import functions.rfc.sap.document.sap_com.Z_FI_GET_UNIDAD_TIPOResponse;

@Service
public class NationalInboxService {
	
	@Autowired
	private NationalInboxDao nationalInboxDao;
	
	@Transactional(readOnly = true)
	public Z_FI_GET_TICKETSResponse getTickets(String lifnr, String bukrs) throws RemoteException {
		return nationalInboxDao.findTickets(lifnr,bukrs);
	}
	
	@Transactional(readOnly = true)
	public Z_FI_GET_TIPO_SERVICIOResponse getServiceType(String type, String language) throws RemoteException {
		return nationalInboxDao.findServiceTypes(type, language);
	}
	
	@Transactional(readOnly = true)
	public Z_FI_GET_UNIDAD_TIPOResponse getUnidadTipo(String type, String language) throws RemoteException {
		return nationalInboxDao.getUnidadTipo(type, language);
	}
	
	@Transactional(readOnly = true)
	public Z_FI_GET_REFER_EMBARResponse getRefer(String type, String language) throws RemoteException {
		return nationalInboxDao.getReferEmbarques(type, language);
	}
	
	@Transactional(readOnly = false)
	public Z_FI_AGREGAR_BUZON_FLETESResponse saveFreight(FreightDto dto, String lifnr, String language) throws IllegalStateException, IOException, ParseException, JSONException {
		return nationalInboxDao.saveFreight(dto, lifnr, language);
	}

}
