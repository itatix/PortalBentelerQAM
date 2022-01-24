package com.wise.service;

import java.io.IOException;
import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.wise.dao.ConsignacionDao;
import com.wise.model.ConsignacionRequestDto;

import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_CONSIG_ORDERResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_DET_FACT_CONSIGResponse;

@Service
public class ConsignacionService {
	
	@Autowired
	private ConsignacionDao consignacionDao;

	@Transactional(readOnly = false)
	public Z_FE_FM_AGREGAR_CONSIG_ORDERResponse addConsignacion(String cmbRazonSocial, MultipartFile[] file, String lifnr, JSONArray invoices, String language, 
																String factura, String lowDate, String highDate, String gjahrVal, String inicioVal, String finVal, 
																String cerradoVal, String monatVal) throws AxisFault, RemoteException, IOException, JSONException {
		return consignacionDao.addConsignacion(cmbRazonSocial, file, lifnr, invoices, language, factura, lowDate, highDate,gjahrVal,inicioVal, finVal, cerradoVal, monatVal);
	}
	
	@Transactional(readOnly = true)
	public Z_FE_FM_DET_FACT_CONSIGResponse getConsignacion(ConsignacionRequestDto requestDto) throws RemoteException {
		return consignacionDao.findConsignaciones(requestDto);
	}

}
