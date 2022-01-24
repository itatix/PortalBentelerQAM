package com.wise.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.wise.dao.InvoiceDao;
import com.wise.model.InvoiceDto;
import com.wise.model.MenusDto;

import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_ORDERResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_ORDER_VI;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_ORDER_VIResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse;
import functions.rfc.sap.document.sap_com.Z_FI_RECEIVE_PAYMENT_INVOICEResponse;

@Service
public class InvoiceService {

//	private static final Logger LOGGER = Logger.getLogger(InvoiceService.class);
	
	@Autowired
	private InvoiceDao invoiceDao;
	
	@Transactional(readOnly = false)
	public Z_FE_FM_AGREGAR_FAC_ORDERResponse addCFDI(String cmbRazonSocial,MultipartFile[] file,String lifnr, String invoices, String referencia, String language, String hdnDivision) throws IOException, JSONException{
		return invoiceDao.addCFDI(cmbRazonSocial, file, lifnr, invoices, referencia, language, hdnDivision);
	}
	
	@Transactional(readOnly = false)
	public Z_FE_FM_AGREGAR_FAC_ORDER_VIResponse addCFDI(String cmbRazonSocial,MultipartFile[] file,String lifnr, JSONArray invoices, String referencia, String language, String hdnDivision, String subto, String receptionType, String moneda, MenusDto menus) throws IOException, JSONException {
		return invoiceDao.addCFDIVI(cmbRazonSocial, file, lifnr, invoices, referencia, language, hdnDivision, subto, receptionType, moneda, menus);
	}
	
	@Transactional(readOnly = false)
	public Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse addCFDISOC(String cmbRazonSocial,MultipartFile[] file,String lifnr, String invoices, String concept, String area, String responsable, String language, String hdnDivision, String referencia) throws IOException {
		return invoiceDao.addCFDISOC(cmbRazonSocial, area, responsable, invoices, concept, file, lifnr, language, hdnDivision, referencia);
	}
	
	@Transactional(readOnly = false)
	public Z_FE_FM_AGREGAR_FAC_ORDERResponse addCBB(MultipartFile[] files,String invoice, String hdnRazonSocial, String fechaInvoice, String hdnIva, String hdnMoneda, String retenciones, String subtotal, String lifnr, String moneda, String referencia, String invoiceData, String language, String hdnDivision) throws IOException {
		return invoiceDao.addCBB(hdnRazonSocial, files, lifnr, invoice, fechaInvoice, hdnIva, retenciones, moneda, referencia, subtotal, invoiceData,language, hdnDivision);
	}
	
	@Transactional(readOnly = false)
	public Z_FE_FM_AGREGAR_FAC_ORDER_VIResponse addCBB(MultipartFile[] files,JSONArray invoice, String hdnRazonSocial, String fechaInvoice, String hdnIva, String hdnMoneda, String retenciones, String subtotal, String lifnr, String moneda, String referencia, String invoiceData, String language, String hdnDivision, String subto, String receptionType, String currency) throws IOException, JSONException{
		return invoiceDao.addCBBVI(hdnRazonSocial, files, lifnr, invoice, fechaInvoice, hdnIva, retenciones, moneda, referencia, subtotal, invoiceData, language, hdnDivision, subto, receptionType, currency);
	}
	
	@Transactional(readOnly = false)
	public Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse addCBBSOC(String cmbRazonSocial,MultipartFile[] files,String lifnr, String invoices, String concept, String area, String responsable, String total, String subtotal, String fechaFactura, String tax, String reten, String moneda, String language, String hdnDivision, String referencia) throws IOException {
		return invoiceDao.addCBBSOC(cmbRazonSocial, area, responsable, invoices, concept, files, lifnr, total, subtotal, fechaFactura, tax, reten, moneda, language, hdnDivision, referencia);
	}
	
	@Transactional(readOnly = false)
	public Z_FI_RECEIVE_PAYMENT_INVOICEResponse addPaymentSupplement(InvoiceDto invoiceDto) throws IllegalStateException, IOException {
		return invoiceDao.addPaymentSupplement(invoiceDto);
	}

	public Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse addCFDISOCAgencias(
			String cmbRazonSocial, MultipartFile[] file, String lifnr,
			String invoices, String concept, String area,
			String responsable, String language, String hdnDivision,
			String referencia, String accounting) throws Exception {
		
		return invoiceDao.addCFDIAgencias(cmbRazonSocial, area, responsable, invoices, concept, file, lifnr, language, hdnDivision, referencia, accounting);
	}

	public Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse addCBBSOCAgencias(
			String hdnRazonSocial, MultipartFile[] files, String lifnr,
			String invoice, String concepto, String hdnArea,
			String hdnResponsable, String total, String subtotal,
			String fechaInvoice, String hdnIva, String retenciones,
			String hdnMoneda, String language, JSONArray jsonArray) throws IllegalStateException, IOException, JSONException {
		return invoiceDao.addCBBAgencias(hdnRazonSocial,hdnArea, hdnResponsable, invoice,concepto,files, lifnr, total, subtotal, fechaInvoice, hdnIva, retenciones, hdnMoneda, language, jsonArray);
	}
	
	public Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse addCFDISOCFletes(
			String cmbRazonSocial, MultipartFile[] file, String lifnr,
			String invoices, String concept, String area,
			String responsable, String language, String hdnDivision,
			String referencia, String accounting) throws Exception {
		
		return invoiceDao.addCFDIFletes(cmbRazonSocial, area, responsable, invoices, concept, file, lifnr, language, hdnDivision, referencia, accounting);
	}

	public Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse addCBBSOCFletes(
			String hdnRazonSocial, MultipartFile[] files, String lifnr,
			String invoice, String concepto, String hdnArea,
			String hdnResponsable, String total, String subtotal,
			String fechaInvoice, String hdnIva, String retenciones,
			String hdnMoneda, String language, JSONArray jsonArray) throws IllegalStateException, IOException, JSONException {
		return invoiceDao.addCBBFletes(hdnRazonSocial,hdnArea, hdnResponsable, invoice,concepto,files, lifnr, total, subtotal, fechaInvoice, hdnIva, retenciones, hdnMoneda, language, jsonArray);
	}
	
}
