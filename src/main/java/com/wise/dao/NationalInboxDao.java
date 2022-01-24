package com.wise.dao;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.wise.Constants;
import com.wise.model.FreightDto;

import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_AGREGAR_BUZON_FLETESServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_GET_REFER_EMBARServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_GET_TICKETSService;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_GET_TICKETSServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_GET_TIPO_SERVICIOServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_GET_UNIDAD_TIPOServiceStub;
import functions.rfc.sap.document.sap_com.Date;
import functions.rfc.sap.document.sap_com.GenericDate;
import functions.rfc.sap.document.sap_com.IT_TICKETS_type1;
import functions.rfc.sap.document.sap_com.IV_BUKRS_type1;
import functions.rfc.sap.document.sap_com.IV_CONCEPTO_type1;
import functions.rfc.sap.document.sap_com.IV_CURRENCY_type1;
import functions.rfc.sap.document.sap_com.IV_DESTINO_type1;
import functions.rfc.sap.document.sap_com.IV_LIFNR_type1;
import functions.rfc.sap.document.sap_com.IV_NO_REFER_type1;
import functions.rfc.sap.document.sap_com.IV_NO_REMISION_type1;
import functions.rfc.sap.document.sap_com.IV_ORIGEN_type1;
import functions.rfc.sap.document.sap_com.IV_REFER_EMBAR_type1;
import functions.rfc.sap.document.sap_com.IV_SPRAS_type1;
import functions.rfc.sap.document.sap_com.IV_TIPO_FAC_type1;
import functions.rfc.sap.document.sap_com.IV_TIPO_SER_type1;
import functions.rfc.sap.document.sap_com.IV_TIPO_TRANSP_type1;
import functions.rfc.sap.document.sap_com.IV_TOTAL_INVOICE_type1;
import functions.rfc.sap.document.sap_com.IV_TRANS_type1;
import functions.rfc.sap.document.sap_com.IV_UNI_TIPO_type1;
import functions.rfc.sap.document.sap_com.LIFNR_type1;
import functions.rfc.sap.document.sap_com.TICKET_type1;
import functions.rfc.sap.document.sap_com.ZFIST_TICKETS_FLE;
import functions.rfc.sap.document.sap_com.Z_FI_AGREGAR_BUZON_FLETES;
import functions.rfc.sap.document.sap_com.Z_FI_AGREGAR_BUZON_FLETESResponse;
import functions.rfc.sap.document.sap_com.Z_FI_GET_REFER_EMBAR;
import functions.rfc.sap.document.sap_com.Z_FI_GET_REFER_EMBARResponse;
import functions.rfc.sap.document.sap_com.Z_FI_GET_TICKETS;
import functions.rfc.sap.document.sap_com.Z_FI_GET_TICKETSResponse;
import functions.rfc.sap.document.sap_com.Z_FI_GET_TIPO_SERVICIO;
import functions.rfc.sap.document.sap_com.Z_FI_GET_TIPO_SERVICIOResponse;
import functions.rfc.sap.document.sap_com.Z_FI_GET_UNIDAD_TIPO;
import functions.rfc.sap.document.sap_com.Z_FI_GET_UNIDAD_TIPOResponse;

@Repository
public class NationalInboxDao {
	
	private static final Logger LOGGER = LogManager.getLogger(NationalInboxDao.class);
	
	public Z_FI_GET_TICKETSResponse findTickets(String lifnr, String bukrs) throws RemoteException {
		int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes	
		SI_ZWS_GET_TICKETSServiceStub stub = new SI_ZWS_GET_TICKETSServiceStub();
		Options options = stub._getServiceClient().getOptions();
		options.setTimeOutInMilliSeconds(timeOutInMilliSeconds);
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		
		Z_FI_GET_TICKETS ticket = new Z_FI_GET_TICKETS();
		IV_LIFNR_type1 iv_lifnr = new IV_LIFNR_type1();
		iv_lifnr.setIV_LIFNR_type0(lifnr);
		ticket.setIV_LIFNR(iv_lifnr);
		IV_BUKRS_type1 iv_bukrs = new IV_BUKRS_type1();
		iv_bukrs.setIV_BUKRS_type0(bukrs);
		ticket.setIV_BUKRS(iv_bukrs );
		return stub.sI_ZWS_GET_TICKETS(ticket);
	}
	
	public Z_FI_GET_TIPO_SERVICIOResponse findServiceTypes(String type, String language) throws RemoteException {
		final int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
		SI_ZWS_GET_TIPO_SERVICIOServiceStub stub = new SI_ZWS_GET_TIPO_SERVICIOServiceStub();
		Options options = stub._getServiceClient().getOptions();
		options.setTimeOutInMilliSeconds(timeOutInMilliSeconds);
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		
		Z_FI_GET_TIPO_SERVICIO typeService = new Z_FI_GET_TIPO_SERVICIO();
		
		IV_SPRAS_type1 iv_spras = new IV_SPRAS_type1();
		IV_TRANS_type1 iv_trans = new IV_TRANS_type1();
		language = "ES".equals(language.toUpperCase()) ? "S" : "E";
		iv_spras.setIV_SPRAS_type0(language);
		iv_trans.setIV_TRANS_type0(type);
		
		typeService.setIV_SPRAS(iv_spras );
		typeService.setIV_TRANS(iv_trans);
		
		return stub.sI_ZWS_GET_TIPO_SERVICIO(typeService);
	}
	
	public Z_FI_GET_UNIDAD_TIPOResponse getUnidadTipo(String type, String language) throws RemoteException {
		final int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
		SI_ZWS_GET_UNIDAD_TIPOServiceStub stub = new SI_ZWS_GET_UNIDAD_TIPOServiceStub();
		Options options = stub._getServiceClient().getOptions();
		options.setTimeOutInMilliSeconds(timeOutInMilliSeconds);
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		
		Z_FI_GET_UNIDAD_TIPO unidadTipo = new Z_FI_GET_UNIDAD_TIPO();
		
		IV_TRANS_type1 iv_trans = new IV_TRANS_type1();
		IV_SPRAS_type1 iv_spras = new IV_SPRAS_type1();
		iv_trans.setIV_TRANS_type0(type);
		language = "ES".equals(language.toUpperCase()) ? "S" : "E";
		iv_spras.setIV_SPRAS_type0(language);
		
		unidadTipo.setIV_TRANS(iv_trans);
		unidadTipo.setIV_SPRAS(iv_spras);
		return stub.sI_ZWS_GET_UNIDAD_TIPO(unidadTipo );
	}
	
	public Z_FI_GET_REFER_EMBARResponse getReferEmbarques(String type, String language) throws RemoteException {
		final int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
		SI_ZWS_GET_REFER_EMBARServiceStub stub = new SI_ZWS_GET_REFER_EMBARServiceStub();
		Options options = stub._getServiceClient().getOptions();
		options.setTimeOutInMilliSeconds(timeOutInMilliSeconds);
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		
		Z_FI_GET_REFER_EMBAR refer = new Z_FI_GET_REFER_EMBAR();
		
		IV_TRANS_type1 iv_trans = new IV_TRANS_type1();
		IV_SPRAS_type1 iv_spras = new IV_SPRAS_type1();
		
		iv_trans.setIV_TRANS_type0(type);
		language = "ES".equals(language.toUpperCase()) ? "S" : "E";
		iv_spras.setIV_SPRAS_type0(language);
		
		refer.setIV_TRANS(iv_trans );
		refer.setIV_SPRAS(iv_spras);
		
		return stub.sI_ZWS_GET_REFER_EMBAR(refer);
	}
	
	public Z_FI_AGREGAR_BUZON_FLETESResponse saveFreight(FreightDto dto, String lifnr, String language) throws IllegalStateException, IOException, ParseException, JSONException {
		JSONArray tickets = null;
		if(dto.getTickets() != null && dto.getTickets().length() > 0)
			tickets = new JSONArray(dto.getTickets());
		final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		final SimpleDateFormat sdfTicket = new SimpleDateFormat("yyyy-MM-dd");
		final int timeOutInMilliSeconds = 3 * 60 * 1000; // Three minutes
		SI_ZWS_AGREGAR_BUZON_FLETESServiceStub stub = new SI_ZWS_AGREGAR_BUZON_FLETESServiceStub();
		Options options = stub._getServiceClient().getOptions();
		options.setTimeOutInMilliSeconds(timeOutInMilliSeconds);
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername(Constants.WISE_WSDL_USER);
		auth.setPassword(Constants.WISE_WSDL_PASS);
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		MultipartFile file2 = null;
		
		MultipartFile file1 = dto.getFile()[dto.getTipoFac().equals("2") ? 0 : 1]; //PDF
		
		if("1".equals(dto.getTipoFac()))
			file2 = dto.getFile()[0]; //XML
		
		MultipartFile file3 = dto.getFile()[ dto.getTipoFac().equals("2") ? 1 : 2]; //otherPDF
		File serverFileXML = null;
		// Create the file on server
		if("1".equals(dto.getTipoFac()))
			serverFileXML = multipartToFile(file2);
        File serverFilePDF = multipartToFile(file1);
        File serverFileOtherPDF = null;
        if(file3 != null)
        		serverFileOtherPDF = file3.isEmpty() ? null : multipartToFile(file3);
		
		FileDataSource fdsXML = new FileDataSource(serverFileXML);
        FileDataSource fdsPDF = new FileDataSource(serverFilePDF);
        FileDataSource fdsOtherPDF = null;
        if(serverFileOtherPDF != null)
        		fdsOtherPDF = new FileDataSource(serverFileOtherPDF);
		
		Z_FI_AGREGAR_BUZON_FLETES flete = new Z_FI_AGREGAR_BUZON_FLETES();
		IT_TICKETS_type1 it_tickets = new IT_TICKETS_type1();
		IV_BUKRS_type1 iv_bukrs = new IV_BUKRS_type1();
		IV_CONCEPTO_type1 iv_concepto = new IV_CONCEPTO_type1();
		IV_CURRENCY_type1 iv_currency = new IV_CURRENCY_type1();
		IV_DESTINO_type1 iv_destino = new IV_DESTINO_type1();
		Date iv_fecha_embar = new Date();
		Date iv_invoice_date = new Date();
		IV_LIFNR_type1 iv_lifnr = new IV_LIFNR_type1();
		IV_NO_REFER_type1 iv_no_refer = new IV_NO_REFER_type1();
		IV_NO_REMISION_type1 iv_no_remision = new IV_NO_REMISION_type1();
		String iv_observacion = new String();
		IV_ORIGEN_type1 iv_origen = new IV_ORIGEN_type1();
		DataHandler ot_pdf_zip = null;
		if(fdsOtherPDF != null)
			ot_pdf_zip = new DataHandler(fdsOtherPDF);
		DataHandler iv_pdf = new DataHandler(fdsPDF);
		IV_REFER_EMBAR_type1 iv_refer_embar = new IV_REFER_EMBAR_type1();
		IV_SPRAS_type1 iv_spras = new IV_SPRAS_type1();
		IV_TIPO_FAC_type1 iv_tipo_fac = new IV_TIPO_FAC_type1();
		IV_TIPO_SER_type1 iv_tipo_ser = new IV_TIPO_SER_type1();
		IV_TIPO_TRANSP_type1 iv_tipo_transp = new IV_TIPO_TRANSP_type1();
		IV_TOTAL_INVOICE_type1 iv_total_invoice = new IV_TOTAL_INVOICE_type1();
		IV_UNI_TIPO_type1 iv_uni_tipo = new IV_UNI_TIPO_type1();
		DataHandler iv_xml = null;
		if(dto.getTipoFac().equals("1"));
			iv_xml = new DataHandler(fdsXML);
		
		iv_bukrs.setIV_BUKRS_type0(dto.getBukrs());
		
		iv_concepto.setIV_CONCEPTO_type0(dto.getConcepto());
		iv_destino.setIV_DESTINO_type0(dto.getDestino());
		
//		iv_invoice_date.setObject(new GenericDate(dto.getInvoiceDate()));
		iv_lifnr.setIV_LIFNR_type0(lifnr);
		iv_no_refer.setIV_NO_REFER_type0(dto.getNoRefer());
		
		iv_observacion = dto.getObservacion();
		iv_origen.setIV_ORIGEN_type0(dto.getOrigen());
		iv_refer_embar.setIV_REFER_EMBAR_type0(dto.getRefer());
		language = "ES".equals(language.toUpperCase()) ? "S" : "E";
		iv_spras.setIV_SPRAS_type0(language);
		iv_tipo_fac.setIV_TIPO_FAC_type0(dto.getTipoFac());
		iv_tipo_ser.setIV_TIPO_SER_type0(dto.getTipoSer());
		iv_tipo_transp.setIV_TIPO_TRANSP_type0(dto.getTipoTrans());
		if(dto.getTipoFac().equals("1")) {
			iv_total_invoice.setIV_TOTAL_INVOICE_type0(new BigDecimal(0));
			iv_currency.setIV_CURRENCY_type0("");
			iv_fecha_embar.setObject(sdf.parse(dto.getFechaEmbarque()));
		}
		else {
			LOGGER.info("Fecha embarque: " + dto.getFechaEmbarque());
			java.util.Date fechaEmbarque = sdf.parse(dto.getFechaEmbarque());
			LOGGER.info("Fecha embarque parsed: " + fechaEmbarque.toString());
			iv_total_invoice.setIV_TOTAL_INVOICE_type0(new BigDecimal(dto.getTotalInvoice()));
			iv_currency.setIV_CURRENCY_type0(dto.getCurrency());
			iv_fecha_embar.setObject(sdf.parse(dto.getFechaEmbarque()));
			iv_invoice_date.setObject(sdf.parse(dto.getInvoiceDate()));
			iv_no_remision.setIV_NO_REMISION_type0(dto.getNoRemision());
		}
		iv_uni_tipo.setIV_UNI_TIPO_type0(dto.getUniTipo());
		if(tickets != null && tickets.length() > 0)
			for(int i=0; i < tickets.length(); i++) {
				ZFIST_TICKETS_FLE item = new ZFIST_TICKETS_FLE();
				final Date fecha = new Date();
				fecha.setObject(sdfTicket.parse(tickets.getJSONObject(i).getString("fecha")));
				item.setFECHA(fecha);
				LIFNR_type1 lifnr1 = new LIFNR_type1();
				lifnr1.setLIFNR_type0(tickets.getJSONObject(i).getString("lifnr"));
				item.setLIFNR(lifnr1);
				TICKET_type1 ticket = new TICKET_type1();
				ticket.setTICKET_type0(tickets.getJSONObject(i).getString("ticket"));
				item.setTICKET(ticket );
				
				it_tickets.addItem(item );
			}
		
		flete.setIT_TICKETS(it_tickets);
		flete.setIV_CONCEPTO(iv_concepto);
		flete.setIV_BUKRS(iv_bukrs);
		flete.setIV_CURRENCY(iv_currency);
		flete.setIV_DESTINO(iv_destino);
		flete.setIV_FECHA_EMBAR(iv_fecha_embar);
		if(dto.getTipoFac().equals("2"))
			flete.setIV_INVOICE_DATE(iv_invoice_date);
		flete.setIV_LIFNR(iv_lifnr);
		flete.setIV_NO_REFER(iv_no_refer);
		flete.setIV_NO_REMISION(iv_no_remision);
		flete.setIV_OBSERVACION(iv_observacion);
		flete.setIV_ORIGEN(iv_origen);
		if(ot_pdf_zip != null)
			flete.setIV_OT_PDF_ZIP(ot_pdf_zip);
		flete.setIV_PDF(iv_pdf);
		flete.setIV_REFER_EMBAR(iv_refer_embar);
		flete.setIV_SPRAS(iv_spras);
		flete.setIV_TIPO_FAC(iv_tipo_fac);
		flete.setIV_TIPO_SER(iv_tipo_ser);
		flete.setIV_TIPO_TRANSP(iv_tipo_transp);
		flete.setIV_TOTAL_INVOICE(iv_total_invoice);
		flete.setIV_UNI_TIPO(iv_uni_tipo);
		
		flete.setIV_XML(dto.getTipoFac().equals("2") ? null : iv_xml);
		LOGGER.info("iv_xml is null?:");
		LOGGER.info(iv_xml == null ? "True": "false");
		return stub.sI_ZWS_AGREGAR_BUZON_FLETES(flete );
	}
	
	private File multipartToFile(MultipartFile multipart) throws IllegalStateException, IOException {
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
