package com.wise.dao;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.wise.Constants;
import com.wise.model.InboxDto;

import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_AGREGAR_BUZONService;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_AGREGAR_BUZONServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_BORRAR_BUZONServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_CONSULTAR_BUZONServiceStub;
import functions.rfc.sap.document.sap_com.BAPISFLDRA;
import functions.rfc.sap.document.sap_com.Char1;
import functions.rfc.sap.document.sap_com.Char10;
import functions.rfc.sap.document.sap_com.Char16;
import functions.rfc.sap.document.sap_com.Char2;
import functions.rfc.sap.document.sap_com.Char4;
import functions.rfc.sap.document.sap_com.Curr152;
import functions.rfc.sap.document.sap_com.Date;
import functions.rfc.sap.document.sap_com.Date10;
import functions.rfc.sap.document.sap_com.EBELN_type1;
import functions.rfc.sap.document.sap_com.GenericDate;
import functions.rfc.sap.document.sap_com.I_BUKRS_type1;
import functions.rfc.sap.document.sap_com.I_EBELN_type0;
import functions.rfc.sap.document.sap_com.I_EBELN_type1;
import functions.rfc.sap.document.sap_com.I_EKORG_type1;
import functions.rfc.sap.document.sap_com.I_FLAG_type1;
import functions.rfc.sap.document.sap_com.I_IDIOMA_type1;
import functions.rfc.sap.document.sap_com.I_IMPORTACION_type0;
import functions.rfc.sap.document.sap_com.I_LIFNR_type1;
import functions.rfc.sap.document.sap_com.I_REFER_type0;
import functions.rfc.sap.document.sap_com.I_TAX_type1;
import functions.rfc.sap.document.sap_com.I_TIPO_RECEP_type1;
import functions.rfc.sap.document.sap_com.I_XBLNR_type1;
import functions.rfc.sap.document.sap_com.OPTION_type1;
import functions.rfc.sap.document.sap_com.SIGN_type1;
import functions.rfc.sap.document.sap_com.XBLNR_type1;
import functions.rfc.sap.document.sap_com.ZEIMPORTACION_type1;
import functions.rfc.sap.document.sap_com.ZST_IMPORTACION;
import functions.rfc.sap.document.sap_com.ZST_ORDENCOMPRA;
import functions.rfc.sap.document.sap_com.ZST_REFER;
import functions.rfc.sap.document.sap_com.ZTT_IMPORTACION;
import functions.rfc.sap.document.sap_com.ZTT_ORDENCOMPRA;
import functions.rfc.sap.document.sap_com.ZTT_REFER;
import functions.rfc.sap.document.sap_com.ZWS_AGREGAR_BUZONStub;
import functions.rfc.sap.document.sap_com.ZWS_BORRAR_BUZONStub;
import functions.rfc.sap.document.sap_com.ZWS_CONSULTAR_BUZONStub;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_BUZON;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_BUZONResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_BORRAR_BUZON;
import functions.rfc.sap.document.sap_com.Z_FE_FM_BORRAR_BUZONResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_CONSULTAR_BUZON;
import functions.rfc.sap.document.sap_com.Z_FE_FM_CONSULTAR_BUZONResponse;

@Repository
public class InboxDao {
	
	private Logger LOGGER = LogManager.getLogger(InboxDao.class);
	
	public Z_FE_FM_AGREGAR_BUZONResponse addInboxCFDI(String cmbRazonSocial, MultipartFile[] file, String lifnr, String hdnOrders, 
			  String hdnImportaciones, String cmbReceptionTypeField, String language) throws IOException, AxisFault, RemoteException {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes		
		String[] orders = hdnOrders.split(",");
		String[] imp = hdnImportaciones.split(",");
//		ZWS_AGREGAR_BUZONStub stub = new ZWS_AGREGAR_BUZONStub();
		SI_ZWS_AGREGAR_BUZONServiceStub stub = new SI_ZWS_AGREGAR_BUZONServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_AGREGAR_BUZON inbox = new Z_FE_FM_AGREGAR_BUZON();

		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//Date10 date = new Date10();
//		Char4 bukrs = new Char4();
		I_BUKRS_type1 bukrs = new I_BUKRS_type1();
//		Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
		//Char4 i_ekorg = new Char4();
//		Char1 i_tipo_recep = new Char1();
		I_TIPO_RECEP_type1 i_tipo_recep = new I_TIPO_RECEP_type1();
//		Char1 i_flag = new Char1();
		I_FLAG_type1 i_flag = new I_FLAG_type1();
//		ZTT_ORDENCOMPRA i_ebeln = new ZTT_ORDENCOMPRA();//purchase order
		I_EBELN_type0 i_ebeln = new I_EBELN_type0();
//		ZTT_IMPORTACION i_importacion = new ZTT_IMPORTACION();
		I_IMPORTACION_type0 i_importacion = new I_IMPORTACION_type0();
//		ZTT_REFER i_refer = new ZTT_REFER();
		I_REFER_type0 i_refer = new I_REFER_type0();
		ZST_REFER zst_refer = new ZST_REFER();
//		Char16 xblnr = new Char16();
		XBLNR_type1 xblnr = new XBLNR_type1();
		MultipartFile file1 = file[1]; //PDF
		MultipartFile file2 = file[0]; //XML
		
		File serverFileXML = multipartToFile(file2);
		File serverFilePDF = multipartToFile(file1);
		LOGGER.info("Server PDF File Location=" + serverFilePDF.getAbsolutePath());
		LOGGER.info("Server XML File Location=" + serverFileXML.getAbsolutePath());
		FileDataSource fdsXML = new FileDataSource(serverFileXML);
		FileDataSource fdsPDF = new FileDataSource(serverFilePDF);
		DataHandler pdfHandler = new DataHandler(fdsPDF);
		DataHandler xmlHandler = new DataHandler(fdsXML);					
		for(String order : orders) {
			ZST_ORDENCOMPRA item = new ZST_ORDENCOMPRA();
//			Char10 ebelnInfo = new Char10();
			EBELN_type1 ebelnInfo = new EBELN_type1();
			ebelnInfo.setEBELN_type0(order);	
			item.setEBELN(ebelnInfo);
			i_ebeln.addItem(item);
		}
		for(String importacion : imp) {
			ZST_IMPORTACION param = new ZST_IMPORTACION();
//			Char10 zeimportacion = new Char10();
			ZEIMPORTACION_type1 zeimportacion = new ZEIMPORTACION_type1();
			zeimportacion.setZEIMPORTACION_type0(importacion);			
			param.setZEIMPORTACION(zeimportacion);
			i_importacion.addItem(param);
		}

		i_lifnr.setI_LIFNR_type0(lifnr);
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());
		bukrs.setI_BUKRS_type0(cmbRazonSocial);		
		i_tipo_recep.setI_TIPO_RECEP_type0(cmbReceptionTypeField);
		i_flag.setI_FLAG_type0("1");
		xblnr.setXBLNR_type0("1");
		zst_refer.setXBLNR(xblnr);
		i_refer.addItem(zst_refer);
		
		inbox.setI_BUKRS(bukrs);
		inbox.setI_IDIOMA(i_idioma);
		inbox.setI_LIFNR(i_lifnr);
		inbox.setI_PDF(pdfHandler);
		inbox.setI_XML(xmlHandler);
		inbox.setI_TIPO_RECEP(i_tipo_recep);
		//inbox.setI_REFER(facs);
		inbox.setI_REFER(i_refer);
		inbox.setI_EBELN(i_ebeln);
		inbox.setI_IMPORTACION(i_importacion);
		inbox.setI_FLAG(i_flag);
		
		stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
		return stub.sI_ZWS_AGREGAR_BUZON(inbox);		
	}

	public Z_FE_FM_AGREGAR_BUZONResponse addInboxSCFDI(String cmbRazonSocial,MultipartFile file,String lifnr, String invoice, String invoiceDate, String iva, 
			   String hdnOrders, String hdnImportaciones, String cmbReceptionTypeField, String language) throws IOException, AxisFault, RemoteException {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes		
	String[] orders = hdnOrders.split(",");
	String[] imp = hdnImportaciones.split(",");
//	ZWS_AGREGAR_BUZONStub stub = new ZWS_AGREGAR_BUZONStub();
	SI_ZWS_AGREGAR_BUZONServiceStub stub = new SI_ZWS_AGREGAR_BUZONServiceStub();
	Options options = stub._getServiceClient().getOptions();
	HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
	auth.setPreemptiveAuthentication(true);
	auth.setUsername(Constants.WISE_WSDL_USER);
	auth.setPassword(Constants.WISE_WSDL_PASS);
	options.setProperty(HTTPConstants.AUTHENTICATE,auth);
	Z_FE_FM_AGREGAR_BUZON inbox = new Z_FE_FM_AGREGAR_BUZON();
	
//	Char4 bukrs = new Char4();	
	I_BUKRS_type1 bukrs = new I_BUKRS_type1();
//	Char2 i_idioma = new Char2();
	I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
//	Char10 i_lifnr = new Char10();
	I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//	Char1 i_tipo_recep = new Char1();
	I_TIPO_RECEP_type1 i_tipo_recep = new I_TIPO_RECEP_type1();
//	Char1 i_flag = new Char1();
	I_FLAG_type1 i_flag = new I_FLAG_type1();
//	Curr152 i_tax = new Curr152();
	I_TAX_type1 i_tax = new I_TAX_type1();
	Date i_date = new Date();
//	Char16 xblrn = new Char16();
	XBLNR_type1 xblrn = new XBLNR_type1();
//	Char16 i_xblrn = new Char16();
	I_XBLNR_type1 i_xblrn = new I_XBLNR_type1();
	
//	ZTT_ORDENCOMPRA i_ebeln = new ZTT_ORDENCOMPRA();//purchase order
	I_EBELN_type0 i_ebeln = new I_EBELN_type0();
//	ZTT_IMPORTACION i_importacion = new ZTT_IMPORTACION();
	I_IMPORTACION_type0 i_importacion = new I_IMPORTACION_type0();
//	ZTT_REFER i_refer = new ZTT_REFER();
	I_REFER_type0 i_refer = new I_REFER_type0();
	ZST_REFER zst_refer = new ZST_REFER();
	MultipartFile file1 = file; //PDF		
	
	File serverFilePDF = multipartToFile(file1);
	LOGGER.info("Server PDF File Location=" + serverFilePDF.getAbsolutePath());        
	FileDataSource fdsPDF = new FileDataSource(serverFilePDF);
	DataHandler pdfHandler = new DataHandler(fdsPDF);
	
	for(String order : orders) {
		ZST_ORDENCOMPRA item = new ZST_ORDENCOMPRA();
//		Char10 ebelnInfo = new Char10();
		EBELN_type1 ebelnInfo = new EBELN_type1();
		ebelnInfo.setEBELN_type0(order);	
		item.setEBELN(ebelnInfo);
		i_ebeln.addItem(item);
	}
	for(String importacion : imp) {
		ZST_IMPORTACION param = new ZST_IMPORTACION();
//		Char10 zeimportacion = new Char10();
		ZEIMPORTACION_type1 zeimportacion = new ZEIMPORTACION_type1();
		zeimportacion.setZEIMPORTACION_type0(importacion);			
		param.setZEIMPORTACION(zeimportacion);
		i_importacion.addItem(param);
	}
	LOGGER.info("lifnr:" + lifnr);
	i_lifnr.setI_LIFNR_type0(lifnr);
	language = language == null ? "ES" : language;
	LOGGER.info("Language:" + language.toUpperCase());
	i_idioma.setI_IDIOMA_type0(language.toUpperCase());
	bukrs.setI_BUKRS_type0(cmbRazonSocial);		
	LOGGER.info("i_tipo_recep:" + cmbReceptionTypeField);
	i_tipo_recep.setI_TIPO_RECEP_type0(cmbReceptionTypeField);
	i_flag.setI_FLAG_type0("2");
	i_tax.setI_TAX_type0(new BigDecimal(iva));
	GenericDate genericDate = new GenericDate();
	genericDate.setGenericDate(invoiceDate);
	i_date.setObject(genericDate);
	xblrn.setXBLNR_type0("1");
	zst_refer.setXBLNR(xblrn);
	i_refer.addItem(zst_refer);
	i_xblrn.setI_XBLNR_type0(invoice);
	
	inbox.setI_BUKRS(bukrs);
	inbox.setI_IDIOMA(i_idioma);
	inbox.setI_LIFNR(i_lifnr);
	inbox.setI_PDF(pdfHandler);		
	inbox.setI_TIPO_RECEP(i_tipo_recep);
	inbox.setI_EBELN(i_ebeln);
	inbox.setI_IMPORTACION(i_importacion);
	inbox.setI_FLAG(i_flag);
	inbox.setI_TAX(i_tax);
	inbox.setI_DATE(i_date);
	inbox.setI_REFER(i_refer);
	inbox.setI_XBLNR(i_xblrn);
	
	stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
	return stub.sI_ZWS_AGREGAR_BUZON(inbox);		
}
	

	
	public Z_FE_FM_CONSULTAR_BUZONResponse findInbox(String cmbRazonSocial, String fechaIni, String fechaFin,String lifnr, String language, String ekorg) throws AxisFault {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
//		ZWS_CONSULTAR_BUZONStub stub = new ZWS_CONSULTAR_BUZONStub();
		SI_ZWS_CONSULTAR_BUZONServiceStub stub = new SI_ZWS_CONSULTAR_BUZONServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_CONSULTAR_BUZON inbox = new Z_FE_FM_CONSULTAR_BUZON();
//		Char1 sign = new Char1();
		SIGN_type1 sign = new SIGN_type1();
//		Char2 option = new Char2();
		OPTION_type1 option = new OPTION_type1();
		Date dateHigh = new Date();
		Date dateLow = new Date();
//		Char4 razonSocial = new Char4();		
		I_BUKRS_type1 razonSocial = new I_BUKRS_type1();		
//		Char4 i_ekorg = new Char4();
		I_EKORG_type1 i_ekorg = new I_EKORG_type1();
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
		if(ekorg != null && ekorg.length() > 0)
			i_ekorg.setI_EKORG_type0(ekorg);
		
		inbox.setI_BUKRS(razonSocial);
		inbox.setI_FECHA(bldat);
		inbox.setI_IDIOMA(i_idioma);
		inbox.setI_LIFNR(i_lifnr);
		inbox.setI_EKORG(i_ekorg);
		
		try {
			stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
			Z_FE_FM_CONSULTAR_BUZONResponse response = stub.sI_ZWS_CONSULTAR_BUZON(inbox);
			LOGGER.info("Find Inbox data: " + response);
			return response;
		} catch (Exception e) {
			LOGGER.error("Error Consulta Inbox:",e);
			return null;
		}
	}
	
	public Map<String,Object> deleteInbox(InboxDto[] invoices, String language) throws AxisFault {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
		Map<String, Object> result = new HashMap<String, Object>();
//		ZWS_BORRAR_BUZONStub stub = new ZWS_BORRAR_BUZONStub();
		SI_ZWS_BORRAR_BUZONServiceStub stub = new SI_ZWS_BORRAR_BUZONServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_BORRAR_BUZON inbox = new Z_FE_FM_BORRAR_BUZON();
		
		for(InboxDto item : invoices) {
//			Char4 i_bukrs = new Char4();
			I_BUKRS_type1 i_bukrs = new I_BUKRS_type1();
//			Char10 i_ebeln = new Char10();
			I_EBELN_type1 i_ebeln = new I_EBELN_type1();
//			Char2 i_idioma = new Char2();
			I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
//			Char10 i_lifnr = new Char10();
			I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//			Char16 i_xblnr = new Char16();
			I_XBLNR_type1 i_xblnr = new I_XBLNR_type1();
			
			i_ebeln.setI_EBELN_type0(item.getEbeln());
			i_idioma.setI_IDIOMA_type0(language.toUpperCase());
			i_lifnr.setI_LIFNR_type0(item.getLifnr());
			i_xblnr.setI_XBLNR_type0(item.getXblnr());
			i_bukrs.setI_BUKRS_type0(item.getBukrs());
					
			inbox.setI_EBELN(i_ebeln);
			inbox.setI_IDIOMA(i_idioma);
			inbox.setI_LIFNR(i_lifnr);
			inbox.setI_XBLNR(i_xblnr);
			inbox.setI_BUKRS(i_bukrs);
			
			try {
				stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
				Z_FE_FM_BORRAR_BUZONResponse response = stub.sI_ZWS_BORRAR_BUZON(inbox);
				LOGGER.info("Inbox deleted xblnr:" + item.getXblnr());
				result.put(item.getXblnr(), response);
			} catch (Exception e) {
				LOGGER.error("Error deleting inbox", e);
				result.put(item.getXblnr(), null);
			}
			
			
		}
		
		return result;
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
