package com.wise.dao;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.wise.Constants;
import com.wise.model.ConsignacionRequestDto;
import com.wise.model.PeriodDto;

import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_AGREGAR_CONSIG_ORDERServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_DET_FACT_CONSIGServiceStub;
import functions.rfc.sap.document.sap_com.BAPISFLDRA;
import functions.rfc.sap.document.sap_com.BSTME_type1;
import functions.rfc.sap.document.sap_com.BSTMG_type1;
import functions.rfc.sap.document.sap_com.CERRADO_type1;
import functions.rfc.sap.document.sap_com.Date;
import functions.rfc.sap.document.sap_com.GJAHR_type1;
import functions.rfc.sap.document.sap_com.GenericDate;
import functions.rfc.sap.document.sap_com.I_BUKRS_type1;
import functions.rfc.sap.document.sap_com.I_IDIOMA_type1;
import functions.rfc.sap.document.sap_com.I_LIFNR_type1;
import functions.rfc.sap.document.sap_com.I_MATERIAL_DET_type0;
import functions.rfc.sap.document.sap_com.I_PERIODO_type0;
import functions.rfc.sap.document.sap_com.I_WAERS_type1;
import functions.rfc.sap.document.sap_com.I_WERKS_type1;
import functions.rfc.sap.document.sap_com.I_XBLNR_type1;
import functions.rfc.sap.document.sap_com.MAKTX_type1;
import functions.rfc.sap.document.sap_com.MATNR_type1;
import functions.rfc.sap.document.sap_com.MBLNR_type1;
import functions.rfc.sap.document.sap_com.MONAT_type1;
import functions.rfc.sap.document.sap_com.NETPR_type1;
import functions.rfc.sap.document.sap_com.NETWR_type1;
import functions.rfc.sap.document.sap_com.OPTION_type1;
import functions.rfc.sap.document.sap_com.SIGN_type1;
import functions.rfc.sap.document.sap_com.WAERS_type1;
import functions.rfc.sap.document.sap_com.ZSEM_type1;
import functions.rfc.sap.document.sap_com.ZST_MATERIAL_DET;
import functions.rfc.sap.document.sap_com.ZST_PERIODO;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_CONSIG_ORDER;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_CONSIG_ORDERResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_DET_FACT_CONSIG;
import functions.rfc.sap.document.sap_com.Z_FE_FM_DET_FACT_CONSIGResponse;

@Repository
public class ConsignacionDao {
	
	private static final Logger LOGGER = LogManager.getLogger(ConsignacionDao.class);
	
	public Z_FE_FM_AGREGAR_CONSIG_ORDERResponse addConsignacion(String cmbRazonSocial,MultipartFile[] file,String lifnr, JSONArray invoices, 
																String language, String factura, String lowDate, String highDate,
																String gjahrVal, String inicioVal, String finVal, String cerradoVal, 
																String monatVal) throws IOException, JSONException, AxisFault, RemoteException {
		int timeOutInMilliSeconds = 5 * 60 * 1000; // Three minutes
		SI_ZWS_AGREGAR_CONSIG_ORDERServiceStub stub = new SI_ZWS_AGREGAR_CONSIG_ORDERServiceStub();
//		ZWS_AGREGAR_CONSIG_ORDERStub stub = new ZWS_AGREGAR_CONSIG_ORDERStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_AGREGAR_CONSIG_ORDER order = new Z_FE_FM_AGREGAR_CONSIG_ORDER();
//		Char4 i_bukrs = new Char4();
		I_BUKRS_type1 i_bukrs = new I_BUKRS_type1();
//		Char10 i_lifnr = new Char10();
		I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
//		Char2 i_idioma = new Char2();
		I_IDIOMA_type1 i_idioma = new I_IDIOMA_type1();
//		Char4 i_werks = new Char4();
		I_WERKS_type1 i_werks = new I_WERKS_type1();
//		Char16 i_xblnr = new Char16();
		I_XBLNR_type1 i_xblrn = new I_XBLNR_type1();
//		Char1 sign1 = new Char1();
		SIGN_type1 sign1 = new SIGN_type1();
//		Char2 option1 = new Char2();
		OPTION_type1 option1 = new OPTION_type1();
//		Date lowDateVal = new Date();
//		Date highDateVal = new Date();
//		BAPISFLDRA i_date = new BAPISFLDRA();
		I_PERIODO_type0 i_periodo = new I_PERIODO_type0();
		
		MultipartFile file1 = file[1]; //PDF
		MultipartFile file2 = file[0]; //XML
				
        // Create the file on server
        File serverFileXML = multipartToFile(file2);
        File serverFilePDF = multipartToFile(file1);
        
        
        LOGGER.info("Server PDF File Location=" + serverFilePDF.getAbsolutePath());
        LOGGER.info("Server XML File Location=" + serverFileXML.getAbsolutePath());
//        LOGGER.info("Server Other PDF File Location=" + serverFileOtherPDF != null ? serverFileOtherPDF.getAbsolutePath() : "No file received");
        FileDataSource fdsXML = new FileDataSource(serverFileXML);
        FileDataSource fdsPDF = new FileDataSource(serverFilePDF);
        
		DataHandler pdfHandler = new DataHandler(fdsPDF);
		DataHandler xmlHandler = new DataHandler(fdsXML);        
		I_MATERIAL_DET_type0 i_material_det = new I_MATERIAL_DET_type0();
		
//		ZTT_NETWR netwr = new ZTT_NETWR();
		ZST_MATERIAL_DET[] netwrs = new ZST_MATERIAL_DET[invoices.length()];
//		ZTL_NETWR[] netwrs = new ZTL_NETWR[invoices.length()];
		for(int i = 0; i < invoices.length(); i++) {
			JSONObject obj = invoices.getJSONObject(i);
			ZST_MATERIAL_DET ztlNetwr = new ZST_MATERIAL_DET();
//			ZTL_NETWR ztlNetwr = new ZTL_NETWR();
//			Curr152 netwrval = new Curr152();
			NETWR_type1 netwrval = new NETWR_type1();
			BAPISFLDRA rango_sem = new BAPISFLDRA();
			Date high = new Date();
			Date low = new Date();
//			Cuky5 waers = new Cuky5();
			WAERS_type1 waers = new WAERS_type1();
//			Numeric2 zsem = new Numeric2();
			ZSEM_type1 zsem = new ZSEM_type1();
//			Char1 sign = new Char1();
			SIGN_type1 sign = new SIGN_type1();
//			Char2 option = new Char2();
			OPTION_type1 option = new OPTION_type1();
//			Char10 mblnr = new Char10();
			MBLNR_type1 mblnr = new MBLNR_type1();
//			Unit3 bstme = new Unit3();
			BSTME_type1 bstme = new BSTME_type1();
//			Quantum133 bstmg = new Quantum133();
			BSTMG_type1 bstmg = new BSTMG_type1();
//			Char40 maktx = new Char40();
			MAKTX_type1 maktx = new MAKTX_type1();
//			Char18 matnr = new Char18();
			MATNR_type1 matnr = new MATNR_type1();
//			Curr112 netpr = new Curr112();
			NETPR_type1 netpr = new NETPR_type1();
			
			netwrval.setNETWR_type0(obj.isNull("netwr") ? "0.0" : obj.getString("netwr"));
			high.setObject(new GenericDate(obj.isNull("high") ? "0000-00-00" : obj.getString("high")));
			low.setObject(new GenericDate(obj.isNull("low") ? "0000-00-00" : obj.getString("low")));
			sign.setSIGN_type0("I");
			option.setOPTION_type0("BT");
			rango_sem.setHIGH(high);
			rango_sem.setLOW(low);
			rango_sem.setSIGN(sign);
			rango_sem.setOPTION(option);
			waers.setWAERS_type0(obj.isNull("waers") ? "" : obj.getString("waers"));
			zsem.setZSEM_type0(obj.isNull("zsem") ? "" : obj.getString("zsem"));
			mblnr.setMBLNR_type0(obj.isNull("mblnr") ? "" : obj.getString("mblnr"));
			bstme.setBSTME_type0(obj.isNull("bstme") ? "" : obj.getString("bstme"));
			bstmg.setBSTMG_type0(new BigDecimal(obj.isNull("bstmg") ? "0.0" : obj.getString("bstmg")));
			maktx.setMAKTX_type0(obj.isNull("maktx") ? "" : obj.getString("maktx"));
			matnr.setMATNR_type0(obj.isNull("matnr") ? "" : obj.getString("matnr"));
			netpr.setNETPR_type0(new BigDecimal(obj.isNull("netpr") ? "0.0" : obj.getString("netpr")));
			
			ztlNetwr.setNETWR(netwrval);
			ztlNetwr.setRANGO_SEM(rango_sem);
			ztlNetwr.setWAERS(waers);
			ztlNetwr.setZSEM(zsem);
			ztlNetwr.setMBLNR(mblnr);
			ztlNetwr.setBSTME(bstme);
			ztlNetwr.setBSTMG(bstmg);
			ztlNetwr.setMAKTX(maktx);
			ztlNetwr.setMATNR(matnr);
			ztlNetwr.setNETPR(netpr);
			
			netwrs[i] = ztlNetwr;
		}
//		netwr.setItem(netwrs);
		
		i_material_det.setItem(netwrs);
		i_idioma.setI_IDIOMA_type0(language.toUpperCase());
		i_werks.setI_WERKS_type0("");
		
		GJAHR_type1 gjahr = new GJAHR_type1();
		CERRADO_type1 cerrado = new CERRADO_type1();
		Date fin = new Date();
		Date inicio = new Date();
		MONAT_type1 monat = new MONAT_type1();
		
		gjahr.setGJAHR_type0(gjahrVal);
		cerrado.setCERRADO_type0(cerradoVal);
		fin.setObject(new GenericDate(finVal));
		inicio.setObject(new GenericDate(inicioVal));
		monat.setMONAT_type0(monatVal);
		
		ZST_PERIODO zst_periodo = new ZST_PERIODO();
		zst_periodo.setCERRADO(cerrado);
		zst_periodo.setFIN(fin);
		zst_periodo.setGJAHR(gjahr);
		zst_periodo.setINICIO(inicio);
		zst_periodo.setMONAT(monat);
		i_periodo.addItem(zst_periodo);
		i_bukrs.setI_BUKRS_type0(cmbRazonSocial);
		i_lifnr.setI_LIFNR_type0(lifnr);
		i_xblrn.setI_XBLNR_type0(factura);
		sign1.setSIGN_type0("I");
		option1.setOPTION_type0("BT");
//		lowDateVal.setObject(new GenericDate(lowDate)); // setDate(lowDate);
//		highDateVal.setObject(new GenericDate(highDate));
//		i_date.setOPTION(option1);
//		i_date.setSIGN(sign1);
//		i_date.setLOW(lowDateVal);
//		i_date.setHIGH(highDateVal);
		
		order.setI_BUKRS(i_bukrs);
		order.setI_LIFNR(i_lifnr);
//		order.setI_NETWR(netwr);
		order.setI_MATERIAL_DET(i_material_det);
		order.setI_IDIOMA(i_idioma);
		order.setI_PDF(pdfHandler);
		order.setI_XML(xmlHandler);
		order.setI_WERKS(i_werks);
		order.setI_XBLNR(i_xblrn);
		
		order.setI_PERIODO(i_periodo);
//		order.setI_DATE(i_date);
		
		stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);
		Z_FE_FM_AGREGAR_CONSIG_ORDERResponse response = stub.sI_ZWS_AGREGAR_CONSIG_ORDER(order);
		
		return response;
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
		I_WAERS_type1 i_waers = new I_WAERS_type1();
		
		CERRADO_type1 cerrado = new CERRADO_type1();
		Date fin = new Date();
		GJAHR_type1 gjahr = new GJAHR_type1();
		Date inicio = new Date();
		MONAT_type1 monat = new MONAT_type1();
		
		i_bukrs.setI_BUKRS_type0(consignacionRequestDto.getBukrs());
		i_werks.setI_WERKS_type0(consignacionRequestDto.getWerks());
		i_idioma.setI_IDIOMA_type0(consignacionRequestDto.getIdioma());
		i_lifnr.setI_LIFNR_type0(consignacionRequestDto.getLifnr());
		i_waers.setI_WAERS_type0(consignacionRequestDto.getWaers());
		
		
		cerrado.setCERRADO_type0(consignacionRequestDto.getCerrado());
		fin.setObject(new GenericDate(consignacionRequestDto.getFin()));
		gjahr.setGJAHR_type0(consignacionRequestDto.getGjahr());
		inicio.setObject(new GenericDate(consignacionRequestDto.getInicio()));
		monat.setMONAT_type0(consignacionRequestDto.getMonat());
		
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
		consignacion.setI_WAERS(i_waers);
		
		stub._getServiceClient().getOptions().setTimeOutInMilliSeconds(timeOutInMilliSeconds);

		return stub.sI_ZWS_DET_FACT_CONSIG(consignacion); 
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
