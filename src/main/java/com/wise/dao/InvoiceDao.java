package com.wise.dao;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;
import org.apache.commons.io.FilenameUtils;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.wise.Constants;
import com.wise.Util;
import com.wise.model.InvoiceDto;
import com.wise.model.MenusDto;

import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_AGREGAR_FAC_ORDERServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_AGREGAR_FAC_ORDER_VIServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_AGREGAR_FAC_SIN_ORDERServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_RECEIVE_PAYMENT_INVOICEServiceStub;
import functions.rfc.sap.document.sap_com.COMP_CODE_type1;
import functions.rfc.sap.document.sap_com.COND_TYPE_type1;
import functions.rfc.sap.document.sap_com.COSTCENTER_type1;
import functions.rfc.sap.document.sap_com.Date;
import functions.rfc.sap.document.sap_com.Date10;
import functions.rfc.sap.document.sap_com.EBELN_type1;
import functions.rfc.sap.document.sap_com.EBELP_type1;
import functions.rfc.sap.document.sap_com.GL_ACCOUNT_type1;
import functions.rfc.sap.document.sap_com.GenericDate;
import functions.rfc.sap.document.sap_com.INVOICE_DOC_ITEM_type1;
import functions.rfc.sap.document.sap_com.ITEM_AMOUNT_type1;
import functions.rfc.sap.document.sap_com.IV_BUKRS_type1;
import functions.rfc.sap.document.sap_com.IV_LIFNR_type1;
import functions.rfc.sap.document.sap_com.I_ACCOUNTING_type0;
import functions.rfc.sap.document.sap_com.I_AREA_type1;
import functions.rfc.sap.document.sap_com.I_BUKRS_type1;
import functions.rfc.sap.document.sap_com.I_CONCEP_type1;
import functions.rfc.sap.document.sap_com.I_EKORG_type1;
import functions.rfc.sap.document.sap_com.I_FACTURA_type1;
import functions.rfc.sap.document.sap_com.I_FLAG_ZIP_type1;
import functions.rfc.sap.document.sap_com.I_FLAG_type1;
import functions.rfc.sap.document.sap_com.I_IDIOMA_type1;
import functions.rfc.sap.document.sap_com.I_KIDNO_type1;
import functions.rfc.sap.document.sap_com.I_LIFNR_type1;
import functions.rfc.sap.document.sap_com.I_PEDIDO_type0;
import functions.rfc.sap.document.sap_com.I_REFER_type0;
import functions.rfc.sap.document.sap_com.I_RESPONSABLE_type1;
import functions.rfc.sap.document.sap_com.I_RETEN_type1;
import functions.rfc.sap.document.sap_com.I_SUBTOTAL_type1;
import functions.rfc.sap.document.sap_com.I_SUBTO_type1;
import functions.rfc.sap.document.sap_com.I_TAX_type1;
import functions.rfc.sap.document.sap_com.I_TIPO_type1;
import functions.rfc.sap.document.sap_com.I_TOTAL_type1;
import functions.rfc.sap.document.sap_com.I_WAERS_type1;
import functions.rfc.sap.document.sap_com.I_XBLNR_type1;
import functions.rfc.sap.document.sap_com.MBLNR_type1;
import functions.rfc.sap.document.sap_com.MENGE_type1;
import functions.rfc.sap.document.sap_com.NETWR_type1;
import functions.rfc.sap.document.sap_com.ORDERID_type1;
import functions.rfc.sap.document.sap_com.PO_ITEM_type1;
import functions.rfc.sap.document.sap_com.PO_NUMBER_type1;
import functions.rfc.sap.document.sap_com.PO_PR_QNT_type1;
import functions.rfc.sap.document.sap_com.PO_PR_UOM_type1;
import functions.rfc.sap.document.sap_com.PO_UNIT_type1;
import functions.rfc.sap.document.sap_com.QUANTITY_type1;
import functions.rfc.sap.document.sap_com.REF_DOC_IT_type1;
import functions.rfc.sap.document.sap_com.REF_DOC_YEAR_type1;
import functions.rfc.sap.document.sap_com.REF_DOC_type1;
import functions.rfc.sap.document.sap_com.SHEET_ITEM_type1;
import functions.rfc.sap.document.sap_com.SHEET_NO_type1;
import functions.rfc.sap.document.sap_com.TAX_BASE_AMOUNT_type1;
import functions.rfc.sap.document.sap_com.WAERS_type1;
import functions.rfc.sap.document.sap_com.WBS_ELEM_type1;
import functions.rfc.sap.document.sap_com.XBLNR_type1;
import functions.rfc.sap.document.sap_com.ZST_ACCOUNTING;
import functions.rfc.sap.document.sap_com.ZST_EBELN;
import functions.rfc.sap.document.sap_com.ZST_REFER;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_ORDER;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_ORDERResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_ORDER_VI;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_ORDER_VIResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_SIN_ORDER;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse;
import functions.rfc.sap.document.sap_com.Z_FI_RECEIVE_PAYMENT_INVOICE;
import functions.rfc.sap.document.sap_com.Z_FI_RECEIVE_PAYMENT_INVOICEResponse;

/**
 * @author ferroblesh
 *
 */
@Repository
public class InvoiceDao {
	
	private static final Logger LOGGER = LogManager.getLogger(InvoiceDao.class);
	
	public Z_FE_FM_AGREGAR_FAC_ORDERResponse addCFDI(String cmbRazonSocial,MultipartFile[] file,String lifnr, String invoices, String referencia, String language, String hdnDivision) throws IOException, JSONException {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
		String[] invoiceVals = invoices.split(",");		
						
//		ZWS_AGREGAR_FAC_ORDERStub stub = new ZWS_AGREGAR_FAC_ORDERStub();
		SI_ZWS_AGREGAR_FAC_ORDERServiceStub stub = new SI_ZWS_AGREGAR_FAC_ORDERServiceStub(); 
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_AGREGAR_FAC_ORDER invoice = new Z_FE_FM_AGREGAR_FAC_ORDER();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date10 date = new Date10();
//		Char4 bukrs = new Char4();
		I_BUKRS_type1 bukrs = new I_BUKRS_type1();
//		Char1 flag = new Char1();
		I_FLAG_type1 flag = new I_FLAG_type1();
//		Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//		Char4 i_ekorg = new Char4();
		I_EKORG_type1 i_ekorg = new I_EKORG_type1();
//		Char30 i_kidno = new Char30();
		I_KIDNO_type1 i_kidno = new I_KIDNO_type1();
		MultipartFile file1 = file[1]; //PDF
		MultipartFile file2 = file[0]; //XML
		
		MultipartFile file3 = file[2]; //otherPDF
        // Create the file on server
        File serverFileXML = multipartToFile(file2);
        File serverFilePDF = multipartToFile(file1);
        File serverFileOtherPDF = file3.isEmpty() ? null : multipartToFile(file3);
        
        LOGGER.info("Server PDF File Location=" + serverFilePDF.getAbsolutePath());
        LOGGER.info("Server XML File Location=" + serverFileXML.getAbsolutePath());
//        LOGGER.info("Server Other PDF File Location=" + serverFileOtherPDF != null ? serverFileOtherPDF.getAbsolutePath() : "No file received");
        FileDataSource fdsXML = new FileDataSource(serverFileXML);
        FileDataSource fdsPDF = new FileDataSource(serverFilePDF);
        FileDataSource fdsOtherPDF = new FileDataSource(serverFileOtherPDF);
        		
		DataHandler pdfHandler = new DataHandler(fdsPDF);
		DataHandler xmlHandler = new DataHandler(fdsXML);		
		DataHandler otherPDFHandler = new DataHandler(fdsOtherPDF);
//		ZTT_REFER facs = new ZTT_REFER();
		I_REFER_type0 facs = new I_REFER_type0();
		for(String invoiceVal : invoiceVals) {
			ZST_REFER fac = new ZST_REFER();			
//			Char16 facInfo = new Char16();
//			facInfo.setChar16(invoiceVal);
			XBLNR_type1 facInfo = new XBLNR_type1();
			facInfo.setXBLNR_type0(invoiceVal);
			fac.setXBLNR(facInfo);
			facs.addItem(fac);
		}			
//		i_lifnr.setChar10(lifnr);
		i_lifnr.setI_LIFNR_type0(lifnr);
//		i_idioma.setChar2(language.toUpperCase());
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());
		if(hdnDivision != null && hdnDivision.length() > 0)
			i_ekorg.setI_EKORG_type0(hdnDivision);
//			i_ekorg.setChar4(hdnDivision);
//		flag.setChar1("1");
		flag.setI_FLAG_type0("1");
		date.setDate10(sdf.format(new java.util.Date()));
//		bukrs.setChar4(cmbRazonSocial);
		bukrs.setI_BUKRS_type0(cmbRazonSocial);
		if(referencia != null && referencia.length() > 0)
			i_kidno.setI_KIDNO_type0(referencia);
//			i_kidno.setChar30(referencia);
		
		invoice.setI_BUKRS(bukrs);
		invoice.setI_FLAG(flag);
		invoice.setI_LIFNR(i_lifnr);
		invoice.setI_PDF(pdfHandler);
		invoice.setI_XML(xmlHandler);
		if(serverFileOtherPDF != null)
			invoice.setI_OPDF(otherPDFHandler);
		invoice.setI_REFER(facs);
		if(referencia != null && referencia.length() > 0)
			invoice.setI_KIDNO(i_kidno);
		invoice.setI_IDIOMA(i_idioma);
		if(hdnDivision != null && hdnDivision.length() > 0)
			invoice.setI_EKORG(i_ekorg);	
		
		Z_FE_FM_AGREGAR_FAC_ORDERResponse response = null;
		try {
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
			response = stub.sI_ZWS_AGREGAR_FAC_ORDER(invoice);
//			response = stub.z_FE_FM_AGREGAR_FAC_ORDER(invoice);			
		} catch (RemoteException e) {
			LOGGER.error("Error with addCFDI:", e);
			return null;
		} catch(Exception e) {
			LOGGER.error("Error with addCFDI:", e);
			return null;
		} finally {
			serverFilePDF.delete();
			serverFileXML.delete();			
			if(serverFileOtherPDF != null)
				serverFileOtherPDF.delete();
		}
		
		return response;
	}
	
	public Z_FE_FM_AGREGAR_FAC_ORDER_VIResponse addCFDIVI(String cmbRazonSocial,MultipartFile[] file,String lifnr, JSONArray invoices, String referencia, 
														  String language, String hdnDivision, String subto, String receptionType, String moneda, MenusDto menus) throws IOException, JSONException {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes					
		
//		ZWS_AGREGAR_FAC_ORDER_VIStub stub = new ZWS_AGREGAR_FAC_ORDER_VIStub();
		SI_ZWS_AGREGAR_FAC_ORDER_VIServiceStub stub = new SI_ZWS_AGREGAR_FAC_ORDER_VIServiceStub();
		
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_AGREGAR_FAC_ORDER_VI invoice = new Z_FE_FM_AGREGAR_FAC_ORDER_VI();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date10 date = new Date10();
//		Char4 bukrs = new Char4();
		I_BUKRS_type1 bukrs = new I_BUKRS_type1();
//		Char1 flag = new Char1();
		I_FLAG_type1 flag = new I_FLAG_type1();
//		Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//		Char4 i_ekorg = new Char4();
		I_EKORG_type1 i_ekorg = new I_EKORG_type1();
//		Curr152 i_subto = new Curr152();
		I_SUBTO_type1 i_subto = new I_SUBTO_type1();
//		Char30 i_kidno = new Char30();
		I_KIDNO_type1 i_kidno = new I_KIDNO_type1();
//		Cuky5 i_waers = new Cuky5();
		I_WAERS_type1 i_waers = new I_WAERS_type1();
//		Char1 i_tipo = new Char1();
		I_TIPO_type1 i_tipo = new I_TIPO_type1();
		MultipartFile file1 = file[1]; //PDF
		MultipartFile file2 = file[0]; //XML
		MultipartFile file3 = null;
		if(file.length > 2)
			file3 = file[2]; //otherPDF
		File serverFileOPDF = null;
				
        // Create the file on server
        File serverFileXML = multipartToFile(file2);
        File serverFilePDF = multipartToFile(file1);
        if(menus.getOpdf() && file3 != null) {
        		serverFileOPDF = multipartToFile(file3);
        		if(serverFileOPDF != null) {
            		String extension = FilenameUtils.getExtension(serverFileOPDF.getName());
            		LOGGER.info("Other pdf extension: " + extension);
            		extension = extension.toLowerCase();
            		if("zip".equals(extension)) {
            			
            			I_FLAG_ZIP_type1 i_flag_zip = new I_FLAG_ZIP_type1();
            			i_flag_zip.setI_FLAG_ZIP_type0("X");
					invoice.setI_FLAG_ZIP(i_flag_zip);
            		}
            }
        }
        	
        
        
        LOGGER.info("Server PDF File Location=" + serverFilePDF.getAbsolutePath());
        LOGGER.info("Server XML File Location=" + serverFileXML.getAbsolutePath());
//        LOGGER.info("Server Other PDF File Location=" + serverFileOtherPDF != null ? serverFileOtherPDF.getAbsolutePath() : "No file received");
        FileDataSource fdsXML = new FileDataSource(serverFileXML);
        FileDataSource fdsPDF = new FileDataSource(serverFilePDF);
        FileDataSource fdsOPDF = null;
        if(menus.getOpdf() && file3 != null) {        	
			fdsOPDF = new FileDataSource(serverFileOPDF);
        }
        
        
		DataHandler pdfHandler = new DataHandler(fdsPDF);
		DataHandler xmlHandler = new DataHandler(fdsXML);
		DataHandler otherPDFHandler = null;
		if(menus.getOpdf() && file3 != null) 
			otherPDFHandler = new DataHandler(fdsOPDF);
		
//		ZTT_EBELN ztt_ebeln = new ZTT_EBELN();
		I_PEDIDO_type0 ztt_ebeln = new I_PEDIDO_type0();
		for(int i = 0; i < invoices.length(); i ++){
			JSONObject item = invoices.getJSONObject(i);
			ZST_EBELN zst_ebeln = new ZST_EBELN();
//			Char10 ebeln = new Char10();
			EBELN_type1 ebeln = new EBELN_type1();
//			Numeric5 ebelp = new Numeric5();
			EBELP_type1 ebelp = new EBELP_type1();
//			Char10 mblnr = new Char10();
			MBLNR_type1 mblnr = new MBLNR_type1();
//			Quantum133 menge = new Quantum133();
			MENGE_type1 menge = new MENGE_type1();
//			Curr152 netwr = new Curr152();
			NETWR_type1 netwr = new NETWR_type1();
//			Cuky5 waers = new Cuky5();
			WAERS_type1 waers = new WAERS_type1();
//			Char16 xblnr = new Char16();
			XBLNR_type1 xblnr = new XBLNR_type1();
//			Numeric6 invoiceDocItem = new Numeric6();
			INVOICE_DOC_ITEM_type1 invoiceDocItem = new INVOICE_DOC_ITEM_type1();
//			Char10 poNumber = new Char10();
			PO_NUMBER_type1 poNumber = new PO_NUMBER_type1();
//			Numeric5 poItem = new Numeric5();
			PO_ITEM_type1 poItem = new PO_ITEM_type1();
//			Char10 refDoc = new Char10();
			REF_DOC_type1 refDoc = new REF_DOC_type1();
//			Numeric4 refDocYear = new Numeric4();
			REF_DOC_YEAR_type1 refDocYear = new REF_DOC_YEAR_type1();
//			Numeric4 refDocIt = new Numeric4();
			REF_DOC_IT_type1 refDocIt = new REF_DOC_IT_type1();
//			Decimal234 itemAmount = new Decimal234();
			ITEM_AMOUNT_type1 itemAmount = new ITEM_AMOUNT_type1();
//			Unit3 poUnit = new Unit3();
			PO_UNIT_type1 poUnit = new PO_UNIT_type1();
//			Quantum133 poPrQnt = new Quantum133();
			PO_PR_QNT_type1 poPrQnt = new PO_PR_QNT_type1();
//			Quantum133 quantity = new Quantum133();
			QUANTITY_type1 quantity = new QUANTITY_type1();
//			Unit3 poPrUom = new Unit3();
			PO_PR_UOM_type1 poPrUom = new PO_PR_UOM_type1();
//			Char4 condType = new Char4();
			COND_TYPE_type1 condType = new COND_TYPE_type1();
//			Char10 sheetNo = new Char10();
			SHEET_NO_type1 sheetNo = new SHEET_NO_type1();
//			Numeric10 sheetItem = new Numeric10();
			SHEET_ITEM_type1 sheetItem = new SHEET_ITEM_type1();
			
//			ebeln.setChar10(!item.isNull("ebeln") ? item.getString("ebeln") : "");
			ebeln.setEBELN_type0(!item.isNull("ebeln") ? item.getString("ebeln") : "");
//			ebelp.setNumeric5(!item.isNull("ebelp") ? item.getString("ebelp") : "");
			ebelp.setEBELP_type0(!item.isNull("ebelp") ? item.getString("ebelp") : "");
//			mblnr.setChar10(!item.isNull("mblnr") ? item.getString("mblnr") : "");
			mblnr.setMBLNR_type0(!item.isNull("mblnr") ? item.getString("mblnr") : "");			
//			menge.setQuantum133(!item.isNull("zmenge") ? new BigDecimal(item.getString("zmenge")) : null);
			menge.setMENGE_type0(!item.isNull("zmenge") ? new BigDecimal(item.getString("zmenge")) : null);
//			netwr.setCurr152(!item.isNull("netwr") ? new BigDecimal(item.getString("netwr")) : null);
			netwr.setNETWR_type0(!item.isNull("netwr") ? item.getString("netwr") : null);
//			waers.setCuky5(!item.isNull("waers") ? item.getString("waers") : "");
			waers.setWAERS_type0(!item.isNull("waers") ? item.getString("waers") : "");
//			xblnr.setChar16(!item.isNull("xblnr") ? item.getString("xblnr") : "");
			xblnr.setXBLNR_type0(!item.isNull("xblnr") ? item.getString("xblnr") : "");
//			invoiceDocItem.setNumeric6(!item.isNull("invoiceDocItem") ? item.getString("invoiceDocItem") : "");
			invoiceDocItem.setINVOICE_DOC_ITEM_type0(!item.isNull("invoiceDocItem") ? item.getString("invoiceDocItem") : "");
//			poNumber.setChar10(!item.isNull("poNumber") ? item.getString("poNumber") : "");
			poNumber.setPO_NUMBER_type0(!item.isNull("poNumber") ? item.getString("poNumber") : "");
//			poItem.setNumeric5(!item.isNull("poItem") ? item.getString("poItem") : "");
			poItem.setPO_ITEM_type0(!item.isNull("poItem") ? item.getString("poItem") : "");
//			refDoc.setChar10(!item.isNull("refDoc") ? item.getString("refDoc") : "");
			refDoc.setREF_DOC_type0(!item.isNull("refDoc") ? item.getString("refDoc") : "");
//			refDocYear.setNumeric4(!item.isNull("refDocYear") ? item.getString("refDocYear") : "");
			refDocYear.setREF_DOC_YEAR_type0(!item.isNull("refDocYear") ? item.getString("refDocYear") : "");			
//			refDocIt.setNumeric4(!item.isNull("refDocIt") ? item.getString("refDocIt") : "");
			refDocIt.setREF_DOC_IT_type0(!item.isNull("refDocIt") ? item.getString("refDocIt") : "");
//			itemAmount.setDecimal234(!item.isNull("itemAmount") ? new BigDecimal(item.getString("itemAmount"))  : null);
			itemAmount.setITEM_AMOUNT_type0(!item.isNull("itemAmount") ? new BigDecimal(item.getString("itemAmount"))  : null);
//			quantity.setQuantum133(!item.isNull("quantity") ? new BigDecimal(item.getString("quantity")) : null);
			quantity.setQUANTITY_type0(!item.isNull("quantity") ? new BigDecimal(item.getString("quantity")) : null);
//			poUnit.setUnit3(!item.isNull("poUnit") ?  item.getString("poUnit") : "");
			poUnit.setPO_UNIT_type0(!item.isNull("poUnit") ?  item.getString("poUnit") : "");
//			poPrQnt.setQuantum133(!item.isNull("poPrQnt") ? new BigDecimal(item.getString("poPrQnt")) : null);
			poPrQnt.setPO_PR_QNT_type0(!item.isNull("poPrQnt") ? new BigDecimal(item.getString("poPrQnt")) : null);
//			poPrUom.setUnit3(!item.isNull("poPrUom") ? item.getString("poPrUom") : "");
			poPrUom.setPO_PR_UOM_type0(!item.isNull("poPrUom") ? item.getString("poPrUom") : "");
//			condType.setChar4(!item.isNull("condType") ? item.getString("condType") : "");
			condType.setCOND_TYPE_type0(!item.isNull("condType") ? item.getString("condType") : "");
//			sheetNo.setChar10(!item.isNull("sheetNo") ? item.getString("sheetNo") : "");
			sheetNo.setSHEET_NO_type0(!item.isNull("sheetNo") ? item.getString("sheetNo") : "");
//			sheetItem.setNumeric10(!item.isNull("sheetItem") ? item.getString("sheetItem") : "");
			sheetItem.setSHEET_ITEM_type0(!item.isNull("sheetItem") ? item.getString("sheetItem") : "");
			
			zst_ebeln.setEBELN(ebeln);
			zst_ebeln.setEBELP(ebelp);
			zst_ebeln.setMBLNR(mblnr);
			zst_ebeln.setMENGE(menge);
			zst_ebeln.setNETWR(netwr);
			zst_ebeln.setWAERS(waers);
			zst_ebeln.setXBLNR(xblnr);
			zst_ebeln.setINVOICE_DOC_ITEM(invoiceDocItem);
			zst_ebeln.setPO_NUMBER(poNumber);
			zst_ebeln.setPO_ITEM(poItem);
			zst_ebeln.setREF_DOC(refDoc);
			zst_ebeln.setREF_DOC_YEAR(refDocYear);
			zst_ebeln.setREF_DOC_IT(refDocIt);
			zst_ebeln.setITEM_AMOUNT(itemAmount);
			zst_ebeln.setQUANTITY(quantity);
			zst_ebeln.setPO_UNIT(poUnit);
			zst_ebeln.setPO_PR_QNT(poPrQnt);
			zst_ebeln.setPO_PR_UOM(poPrUom);
			zst_ebeln.setCOND_TYPE(condType);
			zst_ebeln.setSHEET_NO(sheetNo);
			zst_ebeln.setSHEET_ITEM(sheetItem);
			
			ztt_ebeln.addItem(zst_ebeln);
		}
		
		
		
		
					
//		i_lifnr.setChar10(lifnr);
		i_lifnr.setI_LIFNR_type0(lifnr);
		if(moneda != null && moneda.length() > 0)
			i_waers.setI_WAERS_type0(moneda);
//			i_waers.setCuky5(moneda);
//		i_idioma.setChar2(language.toUpperCase());
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());
		if(hdnDivision != null && hdnDivision.length() > 0)
			i_ekorg.setI_EKORG_type0(hdnDivision);
//			i_ekorg.setChar4(hdnDivision);
//		flag.setChar1("1");
		flag.setI_FLAG_type0("1");
		date.setDate10(sdf.format(new java.util.Date()));
//		bukrs.setChar4(cmbRazonSocial);
		bukrs.setI_BUKRS_type0(cmbRazonSocial);
		if(receptionType != null && receptionType.length() > 0)
			i_tipo.setI_TIPO_type0(receptionType);
//			i_tipo.setChar1(receptionType);
//		i_subto.setCurr152(new BigDecimal(subto));
		i_subto.setI_SUBTO_type0(new BigDecimal(subto));
		if(referencia != null && referencia.length() > 0)
			i_kidno.setI_KIDNO_type0(referencia);
//			i_kidno.setChar30(referencia);
		
		invoice.setI_BUKRS(bukrs);
		invoice.setI_FLAG(flag);
		invoice.setI_LIFNR(i_lifnr);
		invoice.setI_PDF(pdfHandler);
		if(file3 != null )
			invoice.setI_OPDF(otherPDFHandler);
		if(moneda != null && moneda.length() > 0)
			invoice.setI_WAERS(i_waers);		
		invoice.setI_XML(xmlHandler);	
		if(hdnDivision != null && hdnDivision.length() > 0)
			invoice.setI_EKORG(i_ekorg);
		invoice.setI_PEDIDO(ztt_ebeln);
		invoice.setI_SUBTO(i_subto);
		if(receptionType != null && receptionType.length() > 0)
			invoice.setI_TIPO(i_tipo);
		invoice.setI_IDIOMA(i_idioma);
		if(referencia != null && referencia.length() > 0)
			invoice.setI_KIDNO(i_kidno);
		
		Z_FE_FM_AGREGAR_FAC_ORDER_VIResponse response = null;
		try {
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);			
//			response = stub.z_FE_FM_AGREGAR_FAC_ORDER_VI(invoice);			
			response = stub.sI_ZWS_AGREGAR_FAC_ORDER_VI(invoice);
		} catch (RemoteException e) {
			LOGGER.error("Error with addCFDIVI:", e);
			return null;
		} catch(Exception e) {
			LOGGER.error("Error with addCFDIVI:", e);
			return null;
		} finally {
			serverFilePDF.delete();
			serverFileXML.delete();	
			if(menus.getOpdf() && file3 != null)
				serverFileOPDF.delete();
			
		}
		
		return response;
	}
	
	public Z_FE_FM_AGREGAR_FAC_ORDERResponse addCBB(String cmbRazonSocial,MultipartFile[] files,String lifnr, String invoices, String invoiceDate, String tax, String reten, String moneda, String referencia, String subtotal, String invoiceData, String language, String hdnDivision) throws IOException {
		String[] invoiceVals = invoices.split(",");
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
		
//		ZWS_AGREGAR_FAC_ORDERStub stub = new ZWS_AGREGAR_FAC_ORDERStub();
		SI_ZWS_AGREGAR_FAC_ORDERServiceStub stub = new SI_ZWS_AGREGAR_FAC_ORDERServiceStub();
		
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_AGREGAR_FAC_ORDER invoice = new Z_FE_FM_AGREGAR_FAC_ORDER();
//		Char4 bukrs = new Char4();
		I_BUKRS_type1 bukrs = new I_BUKRS_type1();
//		Char4 i_ekorg = new Char4();
		I_EKORG_type1 i_ekorg = new I_EKORG_type1();
//		ZTT_REFER facs = new ZTT_REFER();
		I_REFER_type0 facs = new I_REFER_type0();
		for(String invoiceVal : invoiceVals) {
			ZST_REFER fac = new ZST_REFER();
//			Char16 facInfo = new Char16();
			XBLNR_type1 facInfo = new XBLNR_type1();
//			facInfo.setChar16(invoiceVal);
			facInfo.setXBLNR_type0(invoiceVal);
			fac.setXBLNR(facInfo);
			facs.addItem(fac);
		}
//		Date10 date = new Date10();
		Date date = new Date();
//		Curr132 taxVal = new Curr132();
		I_TAX_type1 taxVal = new I_TAX_type1();
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//		Char1 flag = new Char1();
		I_FLAG_type1 flag = new I_FLAG_type1();
//		Char16 ixblnr = new Char16();
		I_XBLNR_type1 ixblnr = new I_XBLNR_type1();
//		Cuky5 currency = new Cuky5();
		I_WAERS_type1 currency = new I_WAERS_type1();
		
		BigDecimal taxDecimal = new BigDecimal(tax);
//		Char30 i_kidno = new Char30();
		I_KIDNO_type1 i_kidno = new I_KIDNO_type1();
        // Create the file on server
		MultipartFile pdf = files[0]; //PDF
		MultipartFile opdf = files[1]; //XML
        File serverPDFFile = multipartToFile(pdf);
        File serverOPDFFile = opdf.isEmpty() ? null : multipartToFile(opdf);
        LOGGER.info("Server PDF File Location=" + serverPDFFile.getAbsolutePath());
//        LOGGER.info("Server Other PDF File Location=" + serverOPDFFile.getAbsolutePath());
        FileDataSource fds = new FileDataSource(serverPDFFile);
        FileDataSource ofds = new FileDataSource(serverOPDFFile);
		DataHandler dhpdf = new DataHandler(fds);
		DataHandler dhopdf = new DataHandler(ofds);
//		Curr152 subVal = new Curr152();
		I_SUBTOTAL_type1 subVal = new I_SUBTOTAL_type1();
//		Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
//		bukrs.setChar4(cmbRazonSocial);
		bukrs.setI_BUKRS_type0(cmbRazonSocial);
		GenericDate genericDate = new GenericDate();
		genericDate.setGenericDate(invoiceDate);
		date.setObject(genericDate);
		
//		taxVal.setCurr132(taxDecimal);
		taxVal.setI_TAX_type0(taxDecimal);
//		flag.setChar1("2");
		flag.setI_FLAG_type0("2");
		if(referencia != null && referencia.length() > 0)		
			i_kidno.setI_KIDNO_type0(referencia);
//			i_kidno.setChar30(referencia);
				
//		ixblnr.setChar16(invoiceData);
		ixblnr.setI_XBLNR_type0(invoiceData);
//		i_lifnr.setChar10(lifnr);
		i_lifnr.setI_LIFNR_type0(lifnr);
//		currency.setCuky5(moneda);
		currency.setI_WAERS_type0(moneda);
//		subVal.setCurr152(new BigDecimal(subtotal));
		subVal.setI_SUBTOTAL_type0(new BigDecimal(subtotal));
//		i_idioma.setChar2(language.toUpperCase());
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());
		if(hdnDivision != null && hdnDivision.length() > 0)
			i_ekorg.setI_EKORG_type0(hdnDivision);
//			i_ekorg.setChar4(hdnDivision);
		
		invoice.setI_BUKRS(bukrs);
		invoice.setI_PDF(dhpdf);
		if(serverOPDFFile != null)
			invoice.setI_OPDF(dhopdf);
		invoice.setI_REFER(facs);
		invoice.setI_DATE(date);
		invoice.setI_TAX(taxVal);
		invoice.setI_LIFNR(i_lifnr);
		invoice.setI_FLAG(flag);
		invoice.setI_XBLNR(ixblnr);
		invoice.setI_WAERS(currency);
		invoice.setI_SUBTOTAL(subVal);
		invoice.setI_IDIOMA(i_idioma);
		if(referencia != null && referencia.length() > 0)
			invoice.setI_KIDNO(i_kidno);
		if(hdnDivision != null && hdnDivision.length() > 0)
			invoice.setI_EKORG(i_ekorg);
		
		
		Z_FE_FM_AGREGAR_FAC_ORDERResponse response = null;
		try {
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
//			response = stub.z_FE_FM_AGREGAR_FAC_ORDER(invoice);
			response = stub.sI_ZWS_AGREGAR_FAC_ORDER(invoice);
		} catch (Exception e) {
			LOGGER.error("Error with addCBB:", e);
			return null;
		} finally {
			serverPDFFile.delete();
			if(serverOPDFFile != null)
				serverOPDFFile.delete();
		}
		return response;
	}
	
	public Z_FE_FM_AGREGAR_FAC_ORDER_VIResponse addCBBVI(String cmbRazonSocial,MultipartFile[] files,String lifnr, JSONArray invoices, String invoiceDate, String tax, String reten, String moneda, String referencia, String subtotal, String invoiceData, String language, String hdnDivision, String subto, String receptionType, String currencys) throws IOException, JSONException {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
		
//		ZWS_AGREGAR_FAC_ORDER_VIStub stub = new ZWS_AGREGAR_FAC_ORDER_VIStub();
		SI_ZWS_AGREGAR_FAC_ORDER_VIServiceStub stub = new SI_ZWS_AGREGAR_FAC_ORDER_VIServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_AGREGAR_FAC_ORDER_VI invoice = new Z_FE_FM_AGREGAR_FAC_ORDER_VI();
//		Char4 bukrs = new Char4();
		I_BUKRS_type1 bukrs = new I_BUKRS_type1();
//		Char4 i_ekorg = new Char4();
		I_EKORG_type1 i_ekorg = new I_EKORG_type1();
//		ZTT_EBELN ztt_ebeln = new ZTT_EBELN();
		I_PEDIDO_type0 ztt_ebeln = new I_PEDIDO_type0();
		for(int i=0; i < invoices.length(); i++) {
			JSONObject item = invoices.getJSONObject(i);
			ZST_EBELN zst_ebeln = new ZST_EBELN();
			
//			Char10 ebeln = new Char10();
			EBELN_type1 ebeln = new EBELN_type1();
//			Numeric5 ebelp = new Numeric5();
			EBELP_type1 ebelp = new EBELP_type1();
//			Char10 mblnr = new Char10();
			MBLNR_type1 mblnr = new MBLNR_type1();
//			Quantum133 menge = new Quantum133();
			MENGE_type1 menge = new MENGE_type1();
//			Curr152 netwr = new Curr152();
			NETWR_type1 netwr = new NETWR_type1();
//			Cuky5 waers = new Cuky5();
			WAERS_type1 waers = new WAERS_type1();
//			Char16 xblnr = new Char16();
			XBLNR_type1 xblnr = new XBLNR_type1();
//			Numeric6 invoiceDocItem = new Numeric6();
			INVOICE_DOC_ITEM_type1 invoiceDocItem = new INVOICE_DOC_ITEM_type1();
//			Char10 poNumber = new Char10();
			PO_NUMBER_type1 poNumber = new PO_NUMBER_type1();
//			Numeric5 poItem = new Numeric5();
			PO_ITEM_type1 poItem = new PO_ITEM_type1();
//			Char10 refDoc = new Char10();
			REF_DOC_type1 refDoc = new REF_DOC_type1();
//			Numeric4 refDocYear = new Numeric4();
			REF_DOC_YEAR_type1 refDocYear = new REF_DOC_YEAR_type1();
//			Numeric4 refDocIt = new Numeric4();
			REF_DOC_IT_type1 refDocIt = new REF_DOC_IT_type1();
//			Decimal234 itemAmount = new Decimal234();
			ITEM_AMOUNT_type1 itemAmount = new ITEM_AMOUNT_type1();
//			Unit3 poUnit = new Unit3();
			PO_UNIT_type1 poUnit = new PO_UNIT_type1();
//			Quantum133 poPrQnt = new Quantum133();
			PO_PR_QNT_type1 poPrQnt = new PO_PR_QNT_type1();
//			Quantum133 quantity = new Quantum133();
			QUANTITY_type1 quantity = new QUANTITY_type1();
//			Unit3 poPrUom = new Unit3();
			PO_PR_UOM_type1 poPrUom = new PO_PR_UOM_type1();
//			Char4 condType = new Char4();
			COND_TYPE_type1 condType = new COND_TYPE_type1();
//			Char10 sheetNo = new Char10();
			SHEET_NO_type1 sheetNo = new SHEET_NO_type1();
//			Numeric10 sheetItem = new Numeric10();
			SHEET_ITEM_type1 sheetItem = new SHEET_ITEM_type1();

//			ebeln.setChar10(!item.isNull("ebeln") ? item.getString("ebeln") : "");
			ebeln.setEBELN_type0(!item.isNull("ebeln") ? item.getString("ebeln") : "");
//			ebelp.setNumeric5(!item.isNull("ebelp") ? item.getString("ebelp") : "");
			ebelp.setEBELP_type0(!item.isNull("ebelp") ? item.getString("ebelp") : "");
//			mblnr.setChar10(!item.isNull("mblnr") ? item.getString("mblnr") : "");
			mblnr.setMBLNR_type0(!item.isNull("mblnr") ? item.getString("mblnr") : "");			
//			menge.setQuantum133(!item.isNull("zmenge") ? new BigDecimal(item.getString("zmenge")) : null);
			menge.setMENGE_type0(!item.isNull("zmenge") ? new BigDecimal(item.getString("zmenge")) : null);
//			netwr.setCurr152(!item.isNull("netwr") ? new BigDecimal(item.getString("netwr")) : null);
			netwr.setNETWR_type0(!item.isNull("netwr") ? item.getString("netwr") : null);
//			waers.setCuky5(!item.isNull("waers") ? item.getString("waers") : "");
			waers.setWAERS_type0(!item.isNull("waers") ? item.getString("waers") : "");
//			xblnr.setChar16(!item.isNull("xblnr") ? item.getString("xblnr") : "");
			xblnr.setXBLNR_type0(!item.isNull("xblnr") ? item.getString("xblnr") : "");
//			invoiceDocItem.setNumeric6(!item.isNull("invoiceDocItem") ? item.getString("invoiceDocItem") : "");
			invoiceDocItem.setINVOICE_DOC_ITEM_type0(!item.isNull("invoiceDocItem") ? item.getString("invoiceDocItem") : "");
//			poNumber.setChar10(!item.isNull("poNumber") ? item.getString("poNumber") : "");
			poNumber.setPO_NUMBER_type0(!item.isNull("poNumber") ? item.getString("poNumber") : "");
//			poItem.setNumeric5(!item.isNull("poItem") ? item.getString("poItem") : "");
			poItem.setPO_ITEM_type0(!item.isNull("poItem") ? item.getString("poItem") : "");
//			refDoc.setChar10(!item.isNull("refDoc") ? item.getString("refDoc") : "");
			refDoc.setREF_DOC_type0(!item.isNull("refDoc") ? item.getString("refDoc") : "");
//			refDocYear.setNumeric4(!item.isNull("refDocYear") ? item.getString("refDocYear") : "");
			refDocYear.setREF_DOC_YEAR_type0(!item.isNull("refDocYear") ? item.getString("refDocYear") : "");			
//			refDocIt.setNumeric4(!item.isNull("refDocIt") ? item.getString("refDocIt") : "");
			refDocIt.setREF_DOC_IT_type0(!item.isNull("refDocIt") ? item.getString("refDocIt") : "");
//			itemAmount.setDecimal234(!item.isNull("itemAmount") ? new BigDecimal(item.getString("itemAmount"))  : null);
			itemAmount.setITEM_AMOUNT_type0(!item.isNull("itemAmount") ? new BigDecimal(item.getString("itemAmount"))  : null);
//			quantity.setQuantum133(!item.isNull("quantity") ? new BigDecimal(item.getString("quantity")) : null);
			quantity.setQUANTITY_type0(!item.isNull("quantity") ? new BigDecimal(item.getString("quantity")) : null);
//			poUnit.setUnit3(!item.isNull("poUnit") ?  item.getString("poUnit") : "");
			poUnit.setPO_UNIT_type0(!item.isNull("poUnit") ?  item.getString("poUnit") : "");
//			poPrQnt.setQuantum133(!item.isNull("poPrQnt") ? new BigDecimal(item.getString("poPrQnt")) : null);
			poPrQnt.setPO_PR_QNT_type0(!item.isNull("poPrQnt") ? new BigDecimal(item.getString("poPrQnt")) : null);
//			poPrUom.setUnit3(!item.isNull("poPrUom") ? item.getString("poPrUom") : "");
			poPrUom.setPO_PR_UOM_type0(!item.isNull("poPrUom") ? item.getString("poPrUom") : "");
//			condType.setChar4(!item.isNull("condType") ? item.getString("condType") : "");
			condType.setCOND_TYPE_type0(!item.isNull("condType") ? item.getString("condType") : "");
//			sheetNo.setChar10(!item.isNull("sheetNo") ? item.getString("sheetNo") : "");
			sheetNo.setSHEET_NO_type0(!item.isNull("sheetNo") ? item.getString("sheetNo") : "");
//			sheetItem.setNumeric10(!item.isNull("sheetItem") ? item.getString("sheetItem") : "");
			sheetItem.setSHEET_ITEM_type0(!item.isNull("sheetItem") ? item.getString("sheetItem") : "");
			
			zst_ebeln.setEBELN(ebeln);
			zst_ebeln.setEBELP(ebelp);
			zst_ebeln.setMBLNR(mblnr);
			zst_ebeln.setMENGE(menge);
			zst_ebeln.setNETWR(netwr);
			zst_ebeln.setWAERS(waers);
			zst_ebeln.setXBLNR(xblnr);
			zst_ebeln.setINVOICE_DOC_ITEM(invoiceDocItem);
			zst_ebeln.setPO_NUMBER(poNumber);
			zst_ebeln.setPO_ITEM(poItem);
			zst_ebeln.setREF_DOC(refDoc);
			zst_ebeln.setREF_DOC_YEAR(refDocYear);
			zst_ebeln.setREF_DOC_IT(refDocIt);
			zst_ebeln.setITEM_AMOUNT(itemAmount);
			zst_ebeln.setQUANTITY(quantity);
			zst_ebeln.setPO_UNIT(poUnit);
			zst_ebeln.setPO_PR_QNT(poPrQnt);
			zst_ebeln.setPO_PR_UOM(poPrUom);
			zst_ebeln.setCOND_TYPE(condType);
			zst_ebeln.setSHEET_NO(sheetNo);
			zst_ebeln.setSHEET_ITEM(sheetItem);
			
			ztt_ebeln.addItem(zst_ebeln);
		}		
		
		Date date = new Date();
//		Curr152 taxVal = new Curr152();		
		I_TAX_type1 taxVal = new I_TAX_type1();
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//		Char1 flag = new Char1();
		I_FLAG_type1 flag = new I_FLAG_type1();
//		Char16 ixblnr = new Char16();
		I_XBLNR_type1 ixblnr = new I_XBLNR_type1();
//		Cuky5 currency = new Cuky5();
		I_WAERS_type1 currency = new I_WAERS_type1();
//		Char1 i_tipo = new Char1();
		I_TIPO_type1 i_tipo = new I_TIPO_type1();
		BigDecimal taxDecimal = new BigDecimal(tax);
//		Char30 i_kidno = new Char30();
		I_KIDNO_type1 i_kidno = new I_KIDNO_type1();
        // Create the file on server
		MultipartFile pdf = files[0]; //PDF		
        File serverPDFFile = multipartToFile(pdf);
        
        LOGGER.info("Server PDF File Location=" + serverPDFFile.getAbsolutePath());
        
        FileDataSource fds = new FileDataSource(serverPDFFile);        
		DataHandler dhpdf = new DataHandler(fds);
		
//		Curr152 i_subto = new Curr152();
		I_SUBTO_type1 i_subto = new I_SUBTO_type1();
//		Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
//		Cuky5 i_waers = new Cuky5();
		I_WAERS_type1 i_waers = new I_WAERS_type1();
//		bukrs.setChar4(cmbRazonSocial);
		bukrs.setI_BUKRS_type0(cmbRazonSocial);
		GenericDate genericDate = new GenericDate();
		genericDate.setGenericDate(invoiceDate);
		
		date.setObject(genericDate);
//		taxVal.setCurr152(taxDecimal);
		taxVal.setI_TAX_type0(taxDecimal);
//		flag.setChar1("2");
		flag.setI_FLAG_type0("2");
		if(referencia != null && referencia.length() > 0)
			i_kidno.setI_KIDNO_type0(referencia);
//			i_kidno.setChar30(referencia);
				
//		ixblnr.setChar16(invoiceData);
		ixblnr.setI_XBLNR_type0(invoiceData);
//		i_lifnr.setChar10(lifnr);
		i_lifnr.setI_LIFNR_type0(lifnr);
//		currency.setCuky5(moneda);
		currency.setI_WAERS_type0(moneda);
//		i_subto.setCurr152(new BigDecimal(subto));
		i_subto.setI_SUBTO_type0(new BigDecimal(subto));
//		i_idioma.setChar2(language.toUpperCase());
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());
		if(receptionType != null && receptionType.length() > 0)
			i_tipo.setI_TIPO_type0(receptionType);
//			i_tipo.setChar1(receptionType);
		if(hdnDivision != null && hdnDivision.length() > 0)
			i_ekorg.setI_EKORG_type0(hdnDivision);
//			i_ekorg.setChar4(hdnDivision);
		if(currencys != null && currencys.length() > 0)
			i_waers.setI_WAERS_type0(currencys);
//			i_waers.setCuky5(currencys);
		
		invoice.setI_BUKRS(bukrs);
		invoice.setI_PDF(dhpdf);				
		invoice.setI_DATE(date);		
		invoice.setI_LIFNR(i_lifnr);
		invoice.setI_FLAG(flag);
		invoice.setI_XBLNR(ixblnr);				
		invoice.setI_IDIOMA(i_idioma);
		if(hdnDivision != null && hdnDivision.length() > 0)
			invoice.setI_EKORG(i_ekorg);
		invoice.setI_PEDIDO(ztt_ebeln);
		invoice.setI_TAX(taxVal);
		if(receptionType != null && receptionType.length() > 0)
			invoice.setI_TIPO(i_tipo);
		invoice.setI_SUBTO(i_subto);
		if(currencys != null && currencys.length() > 0)
			invoice.setI_WAERS(i_waers);
		if(referencia != null && referencia.length() > 0)			
			invoice.setI_KIDNO(i_kidno);
		
		Z_FE_FM_AGREGAR_FAC_ORDER_VIResponse response = null;
		try {
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
//			response = stub.z_FE_FM_AGREGAR_FAC_ORDER_VI(invoice);
			response = stub.sI_ZWS_AGREGAR_FAC_ORDER_VI(invoice);
		} catch (Exception e) {
			LOGGER.error("Error with addCBB:", e);
			return null;
		} finally {
			serverPDFFile.delete();			
		}
		return response;
	}
	
	public Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse addCFDISOC(String cmbRazonSocial, String area, String responsable, String factura, String concepto, MultipartFile[] file, String lifnr, String language, String hdnDivision, String referencia) throws IOException {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
//		ZWS_AGREGAR_FAC_SIN_ORDERStub stub = new ZWS_AGREGAR_FAC_SIN_ORDERStub();
		SI_ZWS_AGREGAR_FAC_SIN_ORDERServiceStub stub = new SI_ZWS_AGREGAR_FAC_SIN_ORDERServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
				
		Z_FE_FM_AGREGAR_FAC_SIN_ORDER invoice = new Z_FE_FM_AGREGAR_FAC_SIN_ORDER();
		
//		Char4 bukrs = new Char4();
		I_BUKRS_type1 bukrs = new I_BUKRS_type1();
//		Char4 i_ekorg = new Char4();
		I_EKORG_type1 i_ekorg = new I_EKORG_type1();
//		bukrs.setChar4(cmbRazonSocial);
		bukrs.setI_BUKRS_type0(cmbRazonSocial);
		if(hdnDivision != null && hdnDivision.length() > 0)
			i_ekorg.setI_EKORG_type0(hdnDivision);
//			i_ekorg.setChar4(hdnDivision);
//		Char10 i_area = new Char10();
		I_AREA_type1 i_area = new I_AREA_type1();
//		i_area.setChar10(area);
		i_area.setI_AREA_type0(area);
//		Char10 i_responsable = new Char10();
		I_RESPONSABLE_type1 i_responsable = new I_RESPONSABLE_type1();
//		i_responsable.setChar10(responsable);
		i_responsable.setI_RESPONSABLE_type0(responsable);
//		Char16 fac = new Char16();
		I_FACTURA_type1 fac = new I_FACTURA_type1();
//		fac.setChar16(factura);
		fac.setI_FACTURA_type0(factura);
//		Char25 concept = new Char25();
		I_CONCEP_type1 concept = new I_CONCEP_type1();
//		Char30 i_kidno = new Char30();
		I_KIDNO_type1 i_kidno = new I_KIDNO_type1();
//		concept.setChar25(concepto);
		concept.setI_CONCEP_type0(concepto);
		MultipartFile file1 = file[0]; //xml
		MultipartFile file2 = file[1];
		MultipartFile file3 = file[2];
		File serverFileXML = multipartToFile(file1);
		File serverFilePDF = multipartToFile(file2);
		File serverFileOtherPDF = file3.isEmpty() ? null : multipartToFile(file3);
        LOGGER.info("Server XML File Location=" + serverFileXML.getAbsolutePath());
        LOGGER.info("Server PDF File Location=" + serverFilePDF.getAbsolutePath());
//        LOGGER.info("Server Other PDF File Location=" + serverFilePDF.getAbsolutePath());
        FileDataSource fdsXML = new FileDataSource(serverFileXML);
        FileDataSource fdsPDF = new FileDataSource(serverFilePDF);
        FileDataSource fdsOPDF = new FileDataSource(serverFileOtherPDF);
		DataHandler xml = new DataHandler(fdsXML);
		DataHandler pdf = new DataHandler(fdsPDF);
		DataHandler opdf = new DataHandler(fdsOPDF);
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//		i_lifnr.setChar10(lifnr);
		i_lifnr.setI_LIFNR_type0(lifnr);
//		Char1 flag = new Char1();
		I_FLAG_type1 flag = new I_FLAG_type1();
//		Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
//		flag.setChar1("1");
		flag.setI_FLAG_type0("1");
//		i_idioma.setChar2(language.toUpperCase());
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());
		if(referencia != null && referencia.length() > 0)
			i_kidno.setI_KIDNO_type0(referencia);
//			i_kidno.setChar30(referencia);
		
		invoice.setI_BUKRS(bukrs);
		invoice.setI_AREA(i_area);
		invoice.setI_RESPONSABLE(i_responsable);
		invoice.setI_FACTURA(fac);
		invoice.setI_CONCEP(concept);
		invoice.setI_XML(xml);
		invoice.setI_PDF(pdf);
		if(serverFileOtherPDF != null)
			invoice.setI_OPDF(opdf);
		invoice.setI_LIFNR(i_lifnr);
		invoice.setI_FLAG(flag);
		invoice.setI_IDIOMA(i_idioma);
		if(referencia != null && referencia.length() > 0)
			invoice.setI_KIDNO(i_kidno);
		if(hdnDivision != null && hdnDivision.length() > 0)
			invoice.setI_EKORG(i_ekorg);
		
		
		Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse response = null;
		try {
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
//			response = stub.z_FE_FM_AGREGAR_FAC_SIN_ORDER(invoice);
			response = stub.sI_ZWS_AGREGAR_FAC_SIN_ORDER(invoice);
		} catch (Exception e) {
			LOGGER.error("Error cfdisoc: ",e);
			return null;
		} finally {
			serverFilePDF.delete();
			serverFileXML.delete();
			if(serverFileOtherPDF != null)
				serverFileOtherPDF.delete();
		}
		
		return response;
	}
	
	public Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse addCBBSOC(String cmbRazonSocial, String area, String responsable, String factura, String concepto, MultipartFile[] files, String lifnr,String total, String subtotal, String fechaFactura, String tax, String reten, String moneda, String language, String hdnDivision, String referencia) throws IOException {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes		
//		ZWS_AGREGAR_FAC_SIN_ORDERStub stub = new ZWS_AGREGAR_FAC_SIN_ORDERStub();
		SI_ZWS_AGREGAR_FAC_SIN_ORDERServiceStub stub = new SI_ZWS_AGREGAR_FAC_SIN_ORDERServiceStub();
		
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		
		Z_FE_FM_AGREGAR_FAC_SIN_ORDER order = new Z_FE_FM_AGREGAR_FAC_SIN_ORDER();
//		Char10 iarea = new Char10();
		I_AREA_type1 iarea = new I_AREA_type1();
//		Char4 ibukrs = new Char4();
		I_BUKRS_type1 ibukrs = new I_BUKRS_type1();
//		Char25 iconcep = new Char25();
		I_CONCEP_type1 iconcep = new I_CONCEP_type1();
		Date fecha = new Date();
//		Char16 invoice = new Char16();
		I_FACTURA_type1 invoice = new I_FACTURA_type1();
//		Char1 flag = new Char1();
		I_FLAG_type1 flag = new I_FLAG_type1();
//		Char10 ilifnr = new Char10();
		I_LIFNR_type1 ilifnr = new I_LIFNR_type1();
//		Char10 resp = new Char10();
		I_RESPONSABLE_type1 resp = new I_RESPONSABLE_type1();
//		Curr152 ireten = new Curr152();
		I_RETEN_type1 ireten = new I_RETEN_type1();
//		Curr152 isubtotal = new Curr152();
		I_SUBTOTAL_type1 isubtotal = new I_SUBTOTAL_type1();
//		Curr152 itax = new Curr152();
		I_TAX_type1 itax = new I_TAX_type1(); 
//		Curr152 itotal = new Curr152();
		I_TOTAL_type1 itotal = new I_TOTAL_type1();
//		Cuky5 mon = new Cuky5();
		I_WAERS_type1 mon = new I_WAERS_type1();
//		Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
//		Char4 i_ekorg = new Char4();
		I_EKORG_type1 i_ekorg = new I_EKORG_type1();
//		Char30 i_kidno = new Char30();
		I_KIDNO_type1 i_kidno = new I_KIDNO_type1();
		
        // Create the file on server
        File serverPDFFile = multipartToFile(files[0]);
        File serverOPDFFile = files[1].isEmpty() ? null : multipartToFile(files[1]);
        LOGGER.info("Server PDF File Location=" + serverPDFFile.getAbsolutePath());
//        LOGGER.info("Server Other PDF File Location=" + serverOPDFFile.getAbsolutePath());
        FileDataSource fds = new FileDataSource(serverPDFFile);
        FileDataSource ofds = new FileDataSource(serverOPDFFile);
		DataHandler pdfDH = new DataHandler(fds);
		DataHandler opdfDH = new DataHandler(ofds);
//		iarea.setChar10(area);
		iarea.setI_AREA_type0(area);
		ibukrs.setI_BUKRS_type0(cmbRazonSocial);
		iconcep.setI_CONCEP_type0(concepto);
		GenericDate gDate = new GenericDate();
		gDate.setGenericDate(fechaFactura);
		fecha.setObject(gDate);
		invoice.setI_FACTURA_type0(factura);
		flag.setI_FLAG_type0("2");
		ilifnr.setI_LIFNR_type0(lifnr);
		resp.setI_RESPONSABLE_type0(responsable);
		ireten.setI_RETEN_type0(new BigDecimal("0.0"));
		isubtotal.setI_SUBTOTAL_type0(new BigDecimal(subtotal));
		itax.setI_TAX_type0(new BigDecimal(tax));
		itotal.setI_TOTAL_type0(new BigDecimal("0.0"));
		mon.setI_WAERS_type0(moneda);
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());
		if(referencia != null && referencia.length() > 0)
			i_kidno.setI_KIDNO_type0(referencia);
		if(hdnDivision != null && hdnDivision.length() > 0)
			i_ekorg.setI_EKORG_type0(hdnDivision);
		
		
		order.setI_AREA(iarea);
		order.setI_BUKRS(ibukrs);
		order.setI_CONCEP(iconcep);
		order.setI_DATE(fecha);
		order.setI_FACTURA(invoice);
		order.setI_FLAG(flag);
		order.setI_LIFNR(ilifnr);
		order.setI_PDF(pdfDH);
		if(serverOPDFFile != null)
			order.setI_OPDF(opdfDH);
		order.setI_RESPONSABLE(resp);
		order.setI_RETEN(ireten);
		order.setI_SUBTOTAL(isubtotal);
		order.setI_TAX(itax);
		order.setI_TOTAL(itotal);
		order.setI_WAERS(mon);
		order.setI_IDIOMA(i_idioma);
		if(referencia != null && referencia.length() > 0)
			order.setI_KIDNO(i_kidno);
		if(hdnDivision != null && hdnDivision.length() > 0)
			order.setI_EKORG(i_ekorg);
		
		
		Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse response = null;
		
		try {
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
//			response = stub.z_FE_FM_AGREGAR_FAC_SIN_ORDER(order);
			response = stub.sI_ZWS_AGREGAR_FAC_SIN_ORDER(order);
		} catch (Exception e) {
			LOGGER.error("ERROR CBBSOC",e);
			serverPDFFile.delete();
			serverOPDFFile.delete();
			return null;			
		}finally {
			serverPDFFile.delete();
			if(serverOPDFFile != null)
				serverOPDFFile.delete();
		}
		
		return response;
	}
	
	public Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse addCFDIAgencias(String cmbRazonSocial, 
																String area, 
																String responsable, 
																String factura, 
																String concepto, 
																MultipartFile[] file, 
																String lifnr, 
																String language, 
																String hdnDivision, 
																String referencia,
																String accounting) throws Exception {
		
		if(!Util.isJSONValid(accounting)){
			throw new Exception("No accounting Data");
		}
			
		
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
//		ZWS_AGREGAR_FAC_SIN_ORDERStub stub = new ZWS_AGREGAR_FAC_SIN_ORDERStub();
		SI_ZWS_AGREGAR_FAC_SIN_ORDERServiceStub stub = new SI_ZWS_AGREGAR_FAC_SIN_ORDERServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
				
		Z_FE_FM_AGREGAR_FAC_SIN_ORDER invoice = new Z_FE_FM_AGREGAR_FAC_SIN_ORDER();
		
//		Char4 bukrs = new Char4();
		I_BUKRS_type1 bukrs = new I_BUKRS_type1();
//		Char4 i_ekorg = new Char4();
		I_EKORG_type1 i_ekorg = new I_EKORG_type1();
//		bukrs.setChar4(cmbRazonSocial);
		bukrs.setI_BUKRS_type0(cmbRazonSocial);
		if(hdnDivision != null && hdnDivision.length() > 0)
			i_ekorg.setI_EKORG_type0(hdnDivision);
//			i_ekorg.setChar4(hdnDivision);
//		Char10 i_area = new Char10();
		I_AREA_type1 i_area = new I_AREA_type1();
//		i_area.setChar10(area);
		i_area.setI_AREA_type0(area);
//		Char10 i_responsable = new Char10();
		I_RESPONSABLE_type1 i_responsable = new I_RESPONSABLE_type1();
//		i_responsable.setChar10(responsable);
		i_responsable.setI_RESPONSABLE_type0(responsable);
//		Char16 fac = new Char16();
		I_FACTURA_type1 fac = new I_FACTURA_type1();
//		fac.setChar16(factura);
		fac.setI_FACTURA_type0(factura);
//		Char25 concept = new Char25();
		I_CONCEP_type1 concept = new I_CONCEP_type1();
//		Char30 i_kidno = new Char30();
		I_KIDNO_type1 i_kidno = new I_KIDNO_type1();
		
		I_ACCOUNTING_type0 i_accounting = new I_ACCOUNTING_type0();
//		concept.setChar25(concepto);
		concept.setI_CONCEP_type0(concepto);
		MultipartFile file1 = file[0]; //xml
		MultipartFile file2 = file[1];
		MultipartFile file3 = file[2];
		File serverFileXML = multipartToFile(file1);
		File serverFilePDF = multipartToFile(file2);
		File serverFileOtherPDF = file3.isEmpty() ? null : multipartToFile(file3);
        LOGGER.info("Server XML File Location=" + serverFileXML.getAbsolutePath());
        LOGGER.info("Server PDF File Location=" + serverFilePDF.getAbsolutePath());
//        LOGGER.info("Server Other PDF File Location=" + serverFilePDF.getAbsolutePath());
        FileDataSource fdsXML = new FileDataSource(serverFileXML);
        FileDataSource fdsPDF = new FileDataSource(serverFilePDF);
        FileDataSource fdsOPDF = new FileDataSource(serverFileOtherPDF);
		DataHandler xml = new DataHandler(fdsXML);
		DataHandler pdf = new DataHandler(fdsPDF);
		DataHandler opdf = new DataHandler(fdsOPDF);
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//		i_lifnr.setChar10(lifnr);
		i_lifnr.setI_LIFNR_type0(lifnr);
//		Char1 flag = new Char1();
		I_FLAG_type1 flag = new I_FLAG_type1();
//		Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
//		flag.setChar1("1");
		flag.setI_FLAG_type0("3");
//		i_idioma.setChar2(language.toUpperCase());
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());
		if(referencia != null && referencia.length() > 0)
			i_kidno.setI_KIDNO_type0(referencia);
//			i_kidno.setChar30(referencia);
		
		JSONArray accounts = new JSONArray(accounting);
		for(int i=0; i < accounts.length(); i ++) {
			ZST_ACCOUNTING account = new ZST_ACCOUNTING();
			ITEM_AMOUNT_type1 item_amount = new ITEM_AMOUNT_type1();
			TAX_BASE_AMOUNT_type1 tax_base_amount = new TAX_BASE_AMOUNT_type1();
			GL_ACCOUNT_type1 gl_account = new GL_ACCOUNT_type1();
			ORDERID_type1 orderid = new ORDERID_type1();
			COSTCENTER_type1 costcenter = new COSTCENTER_type1();
			WBS_ELEM_type1 wbsElement = new WBS_ELEM_type1();
			
			JSONObject item = accounts.getJSONObject(i);
			item_amount.setITEM_AMOUNT_type0((item.isNull("itemAmount") || item.getString("itemAmount").length() == 0) ? new BigDecimal("0.0") : 
				new BigDecimal(item.getString("itemAmount")));
			tax_base_amount.setTAX_BASE_AMOUNT_type0((item.isNull("tax") || item.getString("tax").length() == 0) ? new BigDecimal("0.0") : 
				new BigDecimal(item.getString("tax")));
			gl_account.setGL_ACCOUNT_type0(item.isNull("glAccount") ? "" : item.getString("glAccount"));
			orderid.setORDERID_type0(item.isNull("orderid") ? "" : item.getString("orderid"));
			costcenter.setCOSTCENTER_type0(item.isNull("costcenter") ? "" : item.getString("costcenter"));
			wbsElement.setWBS_ELEM_type0(item.isNull("wbsElem") ? "" : item.getString("wbsElem"));
			
			account.setITEM_AMOUNT(item_amount);
			account.setTAX_BASE_AMOUNT(tax_base_amount);
			account.setGL_ACCOUNT(gl_account);
			account.setORDERID(orderid);
			account.setCOSTCENTER(costcenter);
			account.setWBS_ELEM(wbsElement);
			
			i_accounting.addItem(account);
		}
		
		
		invoice.setI_BUKRS(bukrs);
		invoice.setI_AREA(i_area);
		invoice.setI_RESPONSABLE(i_responsable);
		invoice.setI_FACTURA(fac);
		invoice.setI_CONCEP(concept);
		invoice.setI_XML(xml);
		invoice.setI_PDF(pdf);
		if(serverFileOtherPDF != null)
			invoice.setI_OPDF(opdf);
		invoice.setI_LIFNR(i_lifnr);
		invoice.setI_FLAG(flag);
		invoice.setI_IDIOMA(i_idioma);
		
		invoice.setI_ACCOUNTING(i_accounting);
		if(referencia != null && referencia.length() > 0)
			invoice.setI_KIDNO(i_kidno);
		if(hdnDivision != null && hdnDivision.length() > 0)
			invoice.setI_EKORG(i_ekorg);
		
		
		Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse response = null;
		try {
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
//			response = stub.z_FE_FM_AGREGAR_FAC_SIN_ORDER(invoice);
			response = stub.sI_ZWS_AGREGAR_FAC_SIN_ORDER(invoice);
		} catch (Exception e) {
			LOGGER.error("Error cfdisoc agencias: ",e);
			return null;
		} finally {
			serverFilePDF.delete();
			serverFileXML.delete();
			if(serverFileOtherPDF != null)
				serverFileOtherPDF.delete();
		}
		
		return response;
	}
	
	public Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse addCBBAgencias(
			String hdnRazonSocial, String hdnArea, String hdnResponsable,
			String invoice, String concepto, MultipartFile[] files,
			String lifnr, String total, String subtotal, String fechaInvoice,
			String hdnIva, String retenciones, String hdnMoneda,
			String language, JSONArray accounting) throws IllegalStateException, IOException, JSONException {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
		SI_ZWS_AGREGAR_FAC_SIN_ORDERServiceStub stub = new SI_ZWS_AGREGAR_FAC_SIN_ORDERServiceStub();
//		ZWS_AGREGAR_FAC_SIN_ORDERStub stub = new ZWS_AGREGAR_FAC_SIN_ORDERStub();		
		
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		
		Z_FE_FM_AGREGAR_FAC_SIN_ORDER order = new Z_FE_FM_AGREGAR_FAC_SIN_ORDER();
		I_AREA_type1 iarea = new I_AREA_type1();
		I_BUKRS_type1 ibukrs = new I_BUKRS_type1();
		I_CONCEP_type1 iconcep = new I_CONCEP_type1();
		Date fecha = new Date();
		I_FACTURA_type1 invoices = new I_FACTURA_type1();
		I_FLAG_type1 flag = new I_FLAG_type1();
		I_LIFNR_type1 ilifnr = new I_LIFNR_type1();
		I_RESPONSABLE_type1 resp = new I_RESPONSABLE_type1();
		I_RETEN_type1 ireten = new I_RETEN_type1();
		I_SUBTOTAL_type1 isubtotal = new I_SUBTOTAL_type1();
		I_TAX_type1 itax = new I_TAX_type1();
		I_TOTAL_type1 itotal = new I_TOTAL_type1();
		I_WAERS_type1 mon = new I_WAERS_type1();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
		
		
		// Create the file on server
		File serverPDFFile = multipartToFile(files[0]);
		File serverOPDFFile = files[1].isEmpty() ? null : multipartToFile(files[1]);
		LOGGER.info("Server PDF File Location=" + serverPDFFile.getAbsolutePath());
		//LOGGER.info("Server Other PDF File Location=" + serverOPDFFile.getAbsolutePath());
		FileDataSource fds = new FileDataSource(serverPDFFile);
		FileDataSource ofds = new FileDataSource(serverOPDFFile);
		DataHandler pdfDH = new DataHandler(fds);
		DataHandler opdfDH = new DataHandler(ofds);
		iarea.setI_AREA_type0(hdnArea);
		ibukrs.setI_BUKRS_type0(hdnRazonSocial);
		iconcep.setI_CONCEP_type0(concepto);
		fecha.setObject(new GenericDate(fechaInvoice));
		invoices.setI_FACTURA_type0(invoice);
		flag.setI_FLAG_type0("4");
		ilifnr.setI_LIFNR_type0(lifnr);
		resp.setI_RESPONSABLE_type0(hdnResponsable);
		ireten.setI_RETEN_type0(new BigDecimal("0.0"));
		isubtotal.setI_SUBTOTAL_type0(new BigDecimal(subtotal));
		itax.setI_TAX_type0(new BigDecimal(hdnIva));
		itotal.setI_TOTAL_type0(new BigDecimal("0.0"));
		mon.setI_WAERS_type0(hdnMoneda);
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());
		
		I_ACCOUNTING_type0 i_accounting = new I_ACCOUNTING_type0();
		
//		ZTT_ACCOUNTING i_accounting = new ZTT_ACCOUNTING();
		
		for(int i = 0; i < accounting.length(); i ++){
			JSONObject item = accounting.getJSONObject(i);
			
			ZST_ACCOUNTING zst_accounting = new ZST_ACCOUNTING();
			
			GL_ACCOUNT_type1 gl_account = new GL_ACCOUNT_type1();
			COMP_CODE_type1 comp_code = new COMP_CODE_type1();
			COSTCENTER_type1 costcenter = new COSTCENTER_type1();
			ORDERID_type1 orderid = new ORDERID_type1();
			TAX_BASE_AMOUNT_type1 tax_base_amount = new TAX_BASE_AMOUNT_type1();
			ITEM_AMOUNT_type1 item_amount = new ITEM_AMOUNT_type1();
			WBS_ELEM_type1 wbsElem = new WBS_ELEM_type1();
			
			item_amount.setITEM_AMOUNT_type0((item.isNull("itemAmount") || item.getString("itemAmount").length() == 0) ? new BigDecimal("0.0") : 
						new BigDecimal(item.getString("itemAmount")));
			tax_base_amount.setTAX_BASE_AMOUNT_type0((item.isNull("tax") || item.getString("tax").length() == 0) ? new BigDecimal("0.0") : 
						new BigDecimal(item.getString("tax")));
			gl_account.setGL_ACCOUNT_type0(item.isNull("glAccount") ? "" : item.getString("glAccount"));
			orderid.setORDERID_type0(item.isNull("orderid") ? "" : item.getString("orderid"));
			costcenter.setCOSTCENTER_type0(item.isNull("costcenter") ? "" : item.getString("costcenter"));
			wbsElem.setWBS_ELEM_type0(item.isNull("wbsElem") ? "" : item.getString("wbsElem"));
			
			
			zst_accounting.setGL_ACCOUNT(gl_account);
			zst_accounting.setCOMP_CODE(comp_code);
			zst_accounting.setCOSTCENTER(costcenter);
			zst_accounting.setORDERID(orderid);
			zst_accounting.setTAX_BASE_AMOUNT(tax_base_amount);
			zst_accounting.setITEM_AMOUNT(item_amount);
			zst_accounting.setWBS_ELEM(wbsElem);
			
			i_accounting.addItem(zst_accounting);
		}
		
		
		
		order.setI_AREA(iarea);
		order.setI_BUKRS(ibukrs);
		order.setI_CONCEP(iconcep);
		order.setI_DATE(fecha);
		order.setI_FACTURA(invoices);
		order.setI_FLAG(flag);
		order.setI_LIFNR(ilifnr);
		order.setI_PDF(pdfDH);
		if(serverOPDFFile != null)
		order.setI_OPDF(opdfDH);
		order.setI_RESPONSABLE(resp);
		order.setI_RETEN(ireten);
		order.setI_SUBTOTAL(isubtotal);
		order.setI_TAX(itax);
		order.setI_TOTAL(itotal);
		order.setI_WAERS(mon);
		order.setI_IDIOMA(i_idioma);	
		order.setI_ACCOUNTING(i_accounting);
		
		
		Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse response = null;
		
		
		stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
//		response = stub.z_FE_FM_AGREGAR_FAC_SIN_ORDER(order);
		response = stub.sI_ZWS_AGREGAR_FAC_SIN_ORDER(order);
		
		return response;
	}
	
	public Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse addCFDIFletes(String cmbRazonSocial, 
			String area, 
			String responsable, 
			String factura, 
			String concepto, 
			MultipartFile[] file, 
			String lifnr, 
			String language, 
			String hdnDivision, 
			String referencia,
			String accounting) throws Exception {
		if(!Util.isJSONValid(accounting)){
			throw new Exception("No accounting Data");
		}


		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
		//ZWS_AGREGAR_FAC_SIN_ORDERStub stub = new ZWS_AGREGAR_FAC_SIN_ORDERStub();
		SI_ZWS_AGREGAR_FAC_SIN_ORDERServiceStub stub = new SI_ZWS_AGREGAR_FAC_SIN_ORDERServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);

		Z_FE_FM_AGREGAR_FAC_SIN_ORDER invoice = new Z_FE_FM_AGREGAR_FAC_SIN_ORDER();

		I_BUKRS_type1 bukrs = new I_BUKRS_type1();
		I_EKORG_type1 i_ekorg = new I_EKORG_type1();
		bukrs.setI_BUKRS_type0(cmbRazonSocial);
		if(hdnDivision != null && hdnDivision.length() > 0)
		i_ekorg.setI_EKORG_type0(hdnDivision);
		I_AREA_type1 i_area = new I_AREA_type1();
		i_area.setI_AREA_type0(area);
		I_RESPONSABLE_type1 i_responsable = new I_RESPONSABLE_type1();
		i_responsable.setI_RESPONSABLE_type0(responsable);
		I_FACTURA_type1 fac = new I_FACTURA_type1();
		fac.setI_FACTURA_type0(factura);
		I_CONCEP_type1 concept = new I_CONCEP_type1();
		I_KIDNO_type1 i_kidno = new I_KIDNO_type1();

		I_ACCOUNTING_type0 i_accounting = new I_ACCOUNTING_type0();
		concept.setI_CONCEP_type0(concepto);
		MultipartFile file1 = file[0]; //xml
		MultipartFile file2 = file[1];
		MultipartFile file3 = file[2];
		File serverFileXML = multipartToFile(file1);
		File serverFilePDF = multipartToFile(file2);
		File serverFileOtherPDF = file3.isEmpty() ? null : multipartToFile(file3);
		LOGGER.info("Server XML File Location=" + serverFileXML.getAbsolutePath());
		LOGGER.info("Server PDF File Location=" + serverFilePDF.getAbsolutePath());
		//LOGGER.info("Server Other PDF File Location=" + serverFilePDF.getAbsolutePath());
		FileDataSource fdsXML = new FileDataSource(serverFileXML);
		FileDataSource fdsPDF = new FileDataSource(serverFilePDF);
		FileDataSource fdsOPDF = new FileDataSource(serverFileOtherPDF);
		DataHandler xml = new DataHandler(fdsXML);
		DataHandler pdf = new DataHandler(fdsPDF);
		DataHandler opdf = new DataHandler(fdsOPDF);
		//Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
		//i_lifnr.setChar10(lifnr);
		i_lifnr.setI_LIFNR_type0(lifnr);
		//Char1 flag = new Char1();
		I_FLAG_type1 flag = new I_FLAG_type1();
		//Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
		//flag.setChar1("1");
		flag.setI_FLAG_type0("5");
		//i_idioma.setChar2(language.toUpperCase());
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());
		if(referencia != null && referencia.length() > 0)
		i_kidno.setI_KIDNO_type0(referencia);
		//i_kidno.setChar30(referencia);

		JSONArray accounts = new JSONArray(accounting);
		for(int i=0; i < accounts.length(); i ++) {
			ZST_ACCOUNTING account = new ZST_ACCOUNTING();
			ITEM_AMOUNT_type1 item_amount = new ITEM_AMOUNT_type1();
			TAX_BASE_AMOUNT_type1 tax_base_amount = new TAX_BASE_AMOUNT_type1();
			GL_ACCOUNT_type1 gl_account = new GL_ACCOUNT_type1();
			ORDERID_type1 orderid = new ORDERID_type1();
			COSTCENTER_type1 costcenter = new COSTCENTER_type1();
			WBS_ELEM_type1 wbsElement = new WBS_ELEM_type1();
	
			JSONObject item = accounts.getJSONObject(i);
			item_amount.setITEM_AMOUNT_type0((item.isNull("itemAmount") || item.getString("itemAmount").length() == 0) ? new BigDecimal("0.0") : 
						new BigDecimal(item.getString("itemAmount")));
			tax_base_amount.setTAX_BASE_AMOUNT_type0((item.isNull("tax") || item.getString("tax").length() == 0) ? new BigDecimal("0.0") : 
						new BigDecimal(item.getString("tax")));
			gl_account.setGL_ACCOUNT_type0(item.isNull("glAccount") ? "" : item.getString("glAccount"));
			orderid.setORDERID_type0(item.isNull("orderid") ? "" : item.getString("orderid"));
			costcenter.setCOSTCENTER_type0(item.isNull("costcenter") ? "" : item.getString("costcenter"));
			wbsElement.setWBS_ELEM_type0(item.isNull("wbsElem") ? "" : item.getString("wbsElem"));
			
			account.setITEM_AMOUNT(item_amount);
			account.setTAX_BASE_AMOUNT(tax_base_amount);
			account.setGL_ACCOUNT(gl_account);
			account.setORDERID(orderid);
			account.setCOSTCENTER(costcenter);
			account.setWBS_ELEM(wbsElement);
			
			i_accounting.addItem(account);
		}


		invoice.setI_BUKRS(bukrs);
		invoice.setI_AREA(i_area);
		invoice.setI_RESPONSABLE(i_responsable);
		invoice.setI_FACTURA(fac);
		invoice.setI_CONCEP(concept);
		invoice.setI_XML(xml);
		invoice.setI_PDF(pdf);
		if(serverFileOtherPDF != null)
		invoice.setI_OPDF(opdf);
		invoice.setI_LIFNR(i_lifnr);
		invoice.setI_FLAG(flag);
		invoice.setI_IDIOMA(i_idioma);

		invoice.setI_ACCOUNTING(i_accounting);
		if(referencia != null && referencia.length() > 0)
		invoice.setI_KIDNO(i_kidno);
		if(hdnDivision != null && hdnDivision.length() > 0)
		invoice.setI_EKORG(i_ekorg);


		Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse response = null;
		try {
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
			response = stub.sI_ZWS_AGREGAR_FAC_SIN_ORDER(invoice);
		} catch (Exception e) {
			LOGGER.error("Error cfdisoc agencias: ",e);
			return null;
		} finally {
			serverFilePDF.delete();
			serverFileXML.delete();
			if(serverFileOtherPDF != null)
				serverFileOtherPDF.delete();
		}

		return response;
	}

	public Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse addCBBFletes(
			String hdnRazonSocial, String hdnArea, String hdnResponsable,
			String invoice, String concepto, MultipartFile[] files,
			String lifnr, String total, String subtotal, String fechaInvoice,
			String hdnIva, String retenciones, String hdnMoneda,
			String language, JSONArray accounting) throws IllegalStateException, IOException, JSONException {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
		SI_ZWS_AGREGAR_FAC_SIN_ORDERServiceStub stub = new SI_ZWS_AGREGAR_FAC_SIN_ORDERServiceStub();

		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);

		Z_FE_FM_AGREGAR_FAC_SIN_ORDER order = new Z_FE_FM_AGREGAR_FAC_SIN_ORDER();
		I_AREA_type1 iarea = new I_AREA_type1();
		I_BUKRS_type1 ibukrs = new I_BUKRS_type1();
		I_CONCEP_type1 iconcep = new I_CONCEP_type1();
		Date fecha = new Date();
		I_FACTURA_type1 invoices = new I_FACTURA_type1();
		I_FLAG_type1 flag = new I_FLAG_type1();
		I_LIFNR_type1 ilifnr = new I_LIFNR_type1();
		I_RESPONSABLE_type1 resp = new I_RESPONSABLE_type1();
		I_RETEN_type1 ireten = new I_RETEN_type1();
		I_SUBTOTAL_type1 isubtotal = new I_SUBTOTAL_type1();
		I_TAX_type1 itax = new I_TAX_type1();
		I_TOTAL_type1 itotal = new I_TOTAL_type1();
		I_WAERS_type1 mon = new I_WAERS_type1();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();


		// Create the file on server
		File serverPDFFile = multipartToFile(files[0]);
		File serverOPDFFile = files[1].isEmpty() ? null : multipartToFile(files[1]);
		LOGGER.info("Server PDF File Location=" + serverPDFFile.getAbsolutePath());
		//LOGGER.info("Server Other PDF File Location=" + serverOPDFFile.getAbsolutePath());
		FileDataSource fds = new FileDataSource(serverPDFFile);
		FileDataSource ofds = new FileDataSource(serverOPDFFile);
		DataHandler pdfDH = new DataHandler(fds);
		DataHandler opdfDH = new DataHandler(ofds);
		iarea.setI_AREA_type0(hdnArea);
		ibukrs.setI_BUKRS_type0(hdnRazonSocial);
		iconcep.setI_CONCEP_type0(concepto);
		fecha.setObject(new GenericDate(fechaInvoice));
		invoices.setI_FACTURA_type0(invoice);
		flag.setI_FLAG_type0("6");
		ilifnr.setI_LIFNR_type0(lifnr);
		resp.setI_RESPONSABLE_type0(hdnResponsable);
		ireten.setI_RETEN_type0(new BigDecimal("0.0"));
		isubtotal.setI_SUBTOTAL_type0(new BigDecimal(subtotal));
		LOGGER.info("hdnIva value:" + hdnIva + "value length: " + hdnIva.length());
		hdnIva = hdnIva.replaceAll(",", "");
		LOGGER.info("new hdnIva value:" + hdnIva);
		itax.setI_TAX_type0(new BigDecimal(hdnIva == null || hdnIva.length() == 0 ? "0.0" : hdnIva));
		itotal.setI_TOTAL_type0(new BigDecimal("0.0"));
		mon.setI_WAERS_type0(hdnMoneda);
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());

		I_ACCOUNTING_type0 i_accounting = new I_ACCOUNTING_type0();


		for(int i = 0; i < accounting.length(); i ++){
			JSONObject item = accounting.getJSONObject(i);
			ZST_ACCOUNTING zst_accounting = new ZST_ACCOUNTING();

			GL_ACCOUNT_type1 gl_account = new GL_ACCOUNT_type1();
			COMP_CODE_type1 comp_code = new COMP_CODE_type1();
			COSTCENTER_type1 costcenter = new COSTCENTER_type1();
			ORDERID_type1 orderid = new ORDERID_type1();
			TAX_BASE_AMOUNT_type1 tax_base_amount = new TAX_BASE_AMOUNT_type1();
			ITEM_AMOUNT_type1 item_amount = new ITEM_AMOUNT_type1();
			WBS_ELEM_type1 wbsElement = new WBS_ELEM_type1();
			
			item_amount.setITEM_AMOUNT_type0((item.isNull("itemAmount") || item.getString("itemAmount").length() == 0) ? new BigDecimal("0.0") : 
					new BigDecimal(item.getString("itemAmount")));
			tax_base_amount.setTAX_BASE_AMOUNT_type0((item.isNull("tax") || item.getString("tax").length() == 0) ? new BigDecimal("0.0") : 
					new BigDecimal(item.getString("tax")));
			gl_account.setGL_ACCOUNT_type0(item.isNull("glAccount") ? "" : item.getString("glAccount"));
			orderid.setORDERID_type0(item.isNull("orderid") ? "" : item.getString("orderid"));
			costcenter.setCOSTCENTER_type0(item.isNull("costcenter") ? "" : item.getString("costcenter"));
			wbsElement.setWBS_ELEM_type0(item.isNull("wbsElem") ? "" : item.getString("wbsElem"));


			zst_accounting.setGL_ACCOUNT(gl_account);
			zst_accounting.setCOMP_CODE(comp_code);
			zst_accounting.setCOSTCENTER(costcenter);
			zst_accounting.setORDERID(orderid);
			zst_accounting.setTAX_BASE_AMOUNT(tax_base_amount);
			zst_accounting.setITEM_AMOUNT(item_amount);
			zst_accounting.setWBS_ELEM(wbsElement);

			i_accounting.addItem(zst_accounting);
		}

		order.setI_AREA(iarea);
		order.setI_BUKRS(ibukrs);
		order.setI_CONCEP(iconcep);
		order.setI_DATE(fecha);
		order.setI_FACTURA(invoices);
		order.setI_FLAG(flag);
		order.setI_LIFNR(ilifnr);
		order.setI_PDF(pdfDH);
		if(serverOPDFFile != null)
			order.setI_OPDF(opdfDH);
		order.setI_RESPONSABLE(resp);
		order.setI_RETEN(ireten);
		order.setI_SUBTOTAL(isubtotal);
		order.setI_TAX(itax);
		order.setI_TOTAL(itotal);
		order.setI_WAERS(mon);
		order.setI_IDIOMA(i_idioma);	
		order.setI_ACCOUNTING(i_accounting);
		
		Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse response = null;
		
		stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
		response = stub.sI_ZWS_AGREGAR_FAC_SIN_ORDER(order);

		return response;
	}
	
	public Z_FI_RECEIVE_PAYMENT_INVOICEResponse addPaymentSupplement(InvoiceDto dto) throws IllegalStateException, IOException {
		final int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
		SI_ZWS_RECEIVE_PAYMENT_INVOICEServiceStub stub = new SI_ZWS_RECEIVE_PAYMENT_INVOICEServiceStub();
		
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		options.setTimeOutInMilliSeconds(timeOutInMilliSeconds);
		
		File serverFileXML = multipartToFile(dto.getFiles()[0]);
		File serverFilePDF = dto.getFiles()[1].isEmpty() ? null : multipartToFile(dto.getFiles()[1]);
		
		FileDataSource fdsXML = new FileDataSource(serverFileXML);
		FileDataSource fdsPDF = new FileDataSource(serverFilePDF);
		
		DataHandler dhXML = new DataHandler(fdsXML);
		DataHandler dhPDF = new DataHandler(fdsPDF);
		
		Z_FI_RECEIVE_PAYMENT_INVOICE invoice = new Z_FI_RECEIVE_PAYMENT_INVOICE();
		IV_BUKRS_type1 iv_bukrs = new IV_BUKRS_type1();
		IV_LIFNR_type1 iv_lifnr = new IV_LIFNR_type1();
		
		iv_bukrs.setIV_BUKRS_type0(dto.getHdnRazonSocial());
		iv_lifnr.setIV_LIFNR_type0(dto.getLifnr());
		
		invoice.setIV_BUKRS(iv_bukrs );
		invoice.setIV_LIFNR(iv_lifnr);
		invoice.setIV_XML(dhXML);
		invoice.setIV_PDF(dhPDF);
		
		return stub.sI_ZWS_RECEIVE_PAYMENT_INVOICE(invoice);
	}
	
	public File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
		// Creating the directory to store file
        String rootPath = System.getProperty("catalina.home");
        File dir = new File(rootPath + File.separator + "tmpFiles");
        if (!dir.exists())
            dir.mkdirs();

        // Create the file on server
        
        File tmpFile = new File(dir.getAbsolutePath() + System.getProperty("file.separator") + 
                                multipart.getOriginalFilename());
        multipart.transferTo(tmpFile);
        return tmpFile;
    }
}
