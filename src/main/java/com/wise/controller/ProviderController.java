package com.wise.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.axis2.AxisFault;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.wise.model.Account;
import com.wise.model.AreaDto;
import com.wise.model.CentroDeCostoDto;
import com.wise.model.ConsignacionRequestDto;
import com.wise.model.CuentaMayorDto;
import com.wise.model.CuentasDto;
import com.wise.model.DivisionDto;
import com.wise.model.EstadoCuentaDto;
import com.wise.model.EstatusIntegracionDto;
import com.wise.model.ListFacturaDto;
import com.wise.model.MaterialDto;
import com.wise.model.NotificationDto;
import com.wise.model.PendingOrdersDto;
import com.wise.model.PeriodDto;
import com.wise.model.RazonSocialDto;
import com.wise.model.ResponsableDto;
import com.wise.model.UserDto;
import com.wise.service.ProviderService;
import com.wise.viewResolver.AccountStatusView;
import com.wise.viewResolver.ListInvoiceStatusView;
import com.wise.viewResolver.ListInvoiceView;
import com.wise.viewResolver.PurchaseWOInvoiceView;

import functions.rfc.sap.document.sap_com.E_BUKRSLIST_type0;
import functions.rfc.sap.document.sap_com.E_GERENCIA_type0;
import functions.rfc.sap.document.sap_com.E_INVOICE_LIST_type0;
import functions.rfc.sap.document.sap_com.E_INVOICE_LIST_type1;
import functions.rfc.sap.document.sap_com.E_LISTAPROV_type0;
import functions.rfc.sap.document.sap_com.E_LISTA_P_ABIERTA_type0;
import functions.rfc.sap.document.sap_com.E_LISTA_P_COMPENSADA_type0;
import functions.rfc.sap.document.sap_com.E_LISTGENERAL_type0;
import functions.rfc.sap.document.sap_com.E_PO_type0;
import functions.rfc.sap.document.sap_com.ZST_ACCOUNTING;
import functions.rfc.sap.document.sap_com.ZST_AVISO;
import functions.rfc.sap.document.sap_com.ZST_CTA_MAYOR;
import functions.rfc.sap.document.sap_com.ZST_DIV_LIST;
import functions.rfc.sap.document.sap_com.ZST_ESTADO_CUENTA;
import functions.rfc.sap.document.sap_com.ZST_MATERIAL_DET;
import functions.rfc.sap.document.sap_com.ZST_PERIODO;
import functions.rfc.sap.document.sap_com.ZTL_BUKRS_LIST;
import functions.rfc.sap.document.sap_com.ZTL_ESTATUS_PORTAL;
import functions.rfc.sap.document.sap_com.ZTL_GERENCIA;
import functions.rfc.sap.document.sap_com.ZTL_LISTA_FAC;
import functions.rfc.sap.document.sap_com.ZTL_ORDER_FAC;
import functions.rfc.sap.document.sap_com.ZTT_AVISO;
import functions.rfc.sap.document.sap_com.ZTT_BUKRS_LIST;
import functions.rfc.sap.document.sap_com.ZTT_DIV_LIST;
import functions.rfc.sap.document.sap_com.ZTT_ESTADO_CUENTA;
import functions.rfc.sap.document.sap_com.ZTT_ESTATUS_PORTAL;
import functions.rfc.sap.document.sap_com.ZTT_GERENCIA;
import functions.rfc.sap.document.sap_com.ZTT_LISTA_FAC;
import functions.rfc.sap.document.sap_com.ZTT_ORDER_FAC;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AREA_RESPResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_CAMBIO_PSWD_PROVResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_CONFIRMA_ESTADO_CUENTAResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_CONTADOR_AVISOS_NLE;
import functions.rfc.sap.document.sap_com.Z_FE_FM_CONTADOR_AVISOS_NLEResponse;
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

@Controller
@RequestMapping("/provider")
public class ProviderController extends BaseController{
	
	private static final Logger LOGGER = LogManager.getLogger(ProviderController.class);
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private ListInvoiceView listInvoiceView;
	
	@Autowired
	private PurchaseWOInvoiceView purchaseWOInvoiceView;
	
	@Autowired
	private AccountStatusView accountStatusView;
	
	@Autowired
	private ListInvoiceStatusView listInvoiceStatusView;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value= "/razonSocial.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getRazonSocial(HttpSession session) throws Exception {
		LOGGER.info("Getting razon social");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		if(user != null){
			Z_FE_FM_RAZON_SOCIALResponse response = providerService.getRazonSocial(user.getI_LIFNR());
			E_BUKRSLIST_type0 list = response.getE_BUKRSLIST();
			ZTL_BUKRS_LIST[] data = list.getItem();
			List json = new ArrayList();
			
			for(ZTL_BUKRS_LIST item : data){
				RazonSocialDto razonSocialDto = new RazonSocialDto();
				razonSocialDto.setBukrs(item.getBUKRS().toString());
				razonSocialDto.setButxt(item.getBUTXT().toString());
				json.add(razonSocialDto);				
			}
			return getResponseMap(json);
		}else {
			return getModelMapError("ERROR");
		}		
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value= "/list.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getListInvoice(HttpServletRequest request, HttpSession session,String cmbRazonSocial, String fechaIni, String fechaFin,String cmbEstado, String ekorg) throws Exception {
		LOGGER.info("Getting Invoice list");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		
		if(user != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Z_FE_FM_LISTA_FACResponse response = providerService.getListaFactura(cmbRazonSocial, fechaIni, fechaFin, cmbEstado, user.getI_LIFNR(), locale.getLanguage(), ekorg);
			if(response.getE_TYPE().toString().equals("E")){
				return getModelMapError(response.getE_MSG().toString());
			}else {
				E_INVOICE_LIST_type1 listaFac = response.getE_INVOICE_LIST();
				ZTL_LISTA_FAC[] data = listaFac.getItem(); // duplicated type for response
				List jsonResponse = new ArrayList();
				
				for(ZTL_LISTA_FAC item : data) {
					ListFacturaDto factura = new ListFacturaDto();
					factura.setBELN(item.getBELNR().toString());
					factura.setESTATUS(item.getESTATUS().toString());
					factura.setFPAGO(item.getFPAGO().getObject() instanceof Date ? sdf.format((Date)item.getFPAGO().getObject()) :
																				   item.getFPAGO().getObject().toString());
					factura.setFVENC(item.getFVENC().getObject() instanceof Date ? sdf.format((Date)item.getFVENC().getObject()) :
																				   item.getFVENC().getObject().toString());
					factura.setNETO(item.getNETO().toString());
					factura.setWAERS(item.getWAERS().toString());
					factura.setXBLNR(item.getXBLNR().toString());
					jsonResponse.add(factura);
				}
				return getResponseMap(jsonResponse);
			}
		} else{
			return getModelMapError("ERROR");
		}				
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value= "/status.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getStatus(HttpServletRequest request ,HttpSession session,String cmbRazonSocial , String fechaIni, String fechaFin) throws Exception {
		LOGGER.info("Getting Integration status");
		Locale locale = RequestContextUtils.getLocale(request);
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		if(user != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Z_FE_FM_ESTATUS_PORTALResponse response = providerService.getEstatusIntegracion(cmbRazonSocial, fechaIni, fechaFin, user.getI_LIFNR(), locale.getLanguage());
			if(response.getE_TYPE().toString().equals("E")) {
				return getModelMapError(response.getE_MSG().toString());
			}else {
				E_INVOICE_LIST_type0 statusInt = response.getE_INVOICE_LIST();
				ZTL_ESTATUS_PORTAL[] data = statusInt.getItem();
				List jsonResponse = new ArrayList();
				
				for(ZTL_ESTATUS_PORTAL item : data) {
					EstatusIntegracionDto factura = new EstatusIntegracionDto();
					factura.setERDAT(item.getERDAT().getObject() instanceof Date ? sdf.format((Date)item.getERDAT().getObject()) :
																				   item.getERDAT().getObject().toString());
					factura.setESTATUS(item.getESTATUS().toString());
					factura.setMESSAGE(item.getMESSAGE().toString());
					factura.setXBLNR(item.getXBLNR().toString());
					jsonResponse.add(factura);
				}
				return getResponseMap(jsonResponse);
			}
		} else {
			return getModelMapError("ERROR");
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/areas.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getArea(HttpSession session, String bukrs) throws AxisFault {
		LOGGER.info("Getting Areas using bukrs");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		if(user != null) {
			Z_FE_FM_AREA_RESPResponse response = providerService.getArea(bukrs);
			if(response.getE_TYPE().toString().equals("E")) {
				return getModelMapError(response.getE_MSG().toString());
			}else {
				E_GERENCIA_type0 ger = response.getE_GERENCIA();
				ZTL_GERENCIA[] items = ger.getItem();
				List<AreaDto> jsonResponse = new ArrayList<AreaDto>();
				List<ResponsableDto> responsables = new ArrayList<ResponsableDto>();
//				AreaDto dto = jsonResponse.isEmpty() ?  new AreaDto() : jsonResponse.get(jsonResponse.size() -1);
										
				for(ZTL_GERENCIA item : items) {
					AreaDto area = new AreaDto();
					area.setIdDireccion(item.getID_DIRECCION().toString());
					area.setDescDireccion(item.getDESC_DIRECCION().toString());
					if(!jsonResponse.contains(area)) {
						jsonResponse.add(area);
					}										
				} // filling jsonResponse with all areas;				
				ListIterator<AreaDto> listIterator = jsonResponse.listIterator();				
				while(listIterator.hasNext()) { //adding all the responsables to the areas
					AreaDto listItem = listIterator.next();
					List<ResponsableDto> resp =  new ArrayList<ResponsableDto>();// listItem.getResponsables() == null ? new ArrayList<ResponsableDto>() : listItem.getResponsables();
					for(ZTL_GERENCIA item : items) {
						if(listItem.getIdDireccion().equals(item.getID_DIRECCION().toString())){							
							ResponsableDto tmpResponsable = new ResponsableDto();
							tmpResponsable.setIdGerencia(item.getID_GERENCIA().toString());
							tmpResponsable.setDescGerencia(item.getDESC_GERENCIA().toString());
							resp.add(tmpResponsable);						
						}
					}
					listItem.setResponsables(resp);
					listIterator.set(listItem);					
				}
				return getResponseMap(jsonResponse);
			}
		} else {
			return getModelMapError("Error de login");
		}
	}
	
	@RequestMapping(value = "/listInvoiceExcel.action", method = RequestMethod.GET)
	public ModelAndView getLIstInvoiceExcel(HttpServletRequest request,HttpSession session,String cmbRazonSocial, String fechaIni, String fechaFin,String cmbEstado, String ekorg) throws Exception {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Z_FE_FM_LISTA_FACResponse response = providerService.getListaFactura(cmbRazonSocial, fechaIni, fechaFin, cmbEstado, user.getI_LIFNR(), locale.getLanguage(), ekorg);
			if(response.getE_TYPE().toString().equals("E")){
				return new ModelAndView(listInvoiceView,null);
			}else {
				E_INVOICE_LIST_type1 listaFac = response.getE_INVOICE_LIST();
				ZTL_LISTA_FAC[] data = listaFac.getItem();
				List<ListFacturaDto> jsonResponse = new ArrayList<ListFacturaDto>();
				
				for(ZTL_LISTA_FAC item : data) {
					ListFacturaDto factura = new ListFacturaDto();
					factura.setBELN(item.getBELNR().toString());
					factura.setESTATUS(item.getESTATUS().toString());
					factura.setFPAGO(item.getFPAGO().getObject() instanceof Date ? sdf.format((Date)item.getFPAGO().getObject()) :
						   														   item.getFPAGO().getObject().toString());
					factura.setFVENC(item.getFVENC().getObject() instanceof Date ? sdf.format((Date)item.getFVENC().getObject()) :
						   														   item.getFVENC().getObject().toString());
					factura.setNETO(item.getNETO().toString());
					factura.setWAERS(item.getWAERS().toString());
					factura.setXBLNR(item.getXBLNR().toString());
					jsonResponse.add(factura);
				}
				Map<String, Object> reportModel = new HashMap<String, Object>();
	            reportModel.put("data", jsonResponse);
				return new ModelAndView(listInvoiceView,reportModel);
			}
		}
		return new ModelAndView(listInvoiceView,null);
	}
	
	@RequestMapping(value = "/listInvoiceStatusExcel.action", method = RequestMethod.GET)
	public ModelAndView getLIstInvoiceStatusExcel(HttpServletRequest request,HttpSession session,String cmbRazonSocial , String fechaIni, String fechaFin) throws Exception {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			Z_FE_FM_ESTATUS_PORTALResponse response = providerService.getEstatusIntegracion(cmbRazonSocial, fechaIni, fechaFin, user.getI_LIFNR(),locale.getLanguage());
			if(response.getE_TYPE().toString().equals("E")){
				return new ModelAndView(listInvoiceView,null);
			}else {
				E_INVOICE_LIST_type0 listaFac = response.getE_INVOICE_LIST();
				ZTL_ESTATUS_PORTAL[] data = listaFac.getItem();
				List<EstatusIntegracionDto> jsonResponse = new ArrayList<EstatusIntegracionDto>();
				final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				
				for(ZTL_ESTATUS_PORTAL item : data) {
					EstatusIntegracionDto factura = new EstatusIntegracionDto();
					factura.setERDAT(item.getERDAT().getObject() instanceof Date ? sdf.format((Date)item.getERDAT().getObject()) :
						   													item.getERDAT().getObject().toString());
					factura.setESTATUS(item.getESTATUS().toString());
					factura.setMESSAGE(item.getMESSAGE().toString());
					factura.setXBLNR(item.getXBLNR().toString());
					jsonResponse.add(factura);					
				}
				Map<String, Object> reportModel = new HashMap<String, Object>();
	            reportModel.put("data", jsonResponse);
				return new ModelAndView(listInvoiceStatusView,reportModel);
			}
		}
		return new ModelAndView(listInvoiceView,null);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/division.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getDivision(HttpSession session, String bukrs) throws AxisFault {
		LOGGER.info("Getting Division using bukrs");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		if(user != null) {
			Z_FE_FM_DIVISIONResponse response = providerService.getDivision(bukrs);
			if(response.getE_TYPE().toString().equals("E")) {
				return getModelMapError(response.getE_MSG().toString());	
			} else {
				ZTT_DIV_LIST division = response.getE_DIVLIST();
				ZST_DIV_LIST[] items  = division.getItem();
				List jsonResponse = new ArrayList();
				
				for(ZST_DIV_LIST item : items) {
					DivisionDto div = new DivisionDto();
					div.setName(item.getNAME().toString());
					div.setSegment(item.getSEGMENT().toString());
					jsonResponse.add(div);
				}
				return getResponseMap(jsonResponse);
			}
		} else {
			return getModelMapError("ERROR");
		}
	}
	
	@RequestMapping(value = "/listPendingInvoice.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getPendingInvoices(HttpSession session, HttpServletRequest request, String bukrs, String ekorg, String lifnr, String fechaIni, String fechaFin, String ebeln, String currency, Integer receptionType) throws AxisFault{
		LOGGER.info("Getting Pending Invoices");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Z_FE_FM_ORDEN_FACTURAResponse response = providerService.getPendingInvoices(bukrs,ekorg,user.getI_LIFNR().toString(), fechaIni, fechaFin, ebeln, locale.getLanguage(), receptionType, currency);
			LOGGER.info("Response from WS[PendingInvoicesList]: " + response.getE_TYPE().toString());
			if("E".equals(response.getE_TYPE().toString().toUpperCase())) {
				return getModelMapError(response.getE_MSG().toString());
			} else {
				E_PO_type0 invoices = response.getE_PO();
				ZTL_ORDER_FAC[] data = invoices.getItem();
				List jsonResponse = new ArrayList();				
				for(ZTL_ORDER_FAC item : data) {
					
					
					PendingOrdersDto dto = new PendingOrdersDto();					
					dto.setAedat(item.getAEDAT().getObject() instanceof Date ? sdf.format((java.util.Date) item.getAEDAT().getObject()):
																			   item.getAEDAT().getObject().toString());
					dto.setBudat(item.getBUDAT().getObject() instanceof Date ? sdf.format((Date) item.getBUDAT().getObject()) :
																				item.getBUDAT().getObject().toString());
					dto.setBuzei(item.getBUZEI().toString());
					dto.setEbeln(item.getEBELN().toString());
					dto.setEbelp(item.getEBELP().toString());
					dto.setMatnr(item.getMATNR().toString());
					dto.setMblnr(item.getMBLNR().toString());
					dto.setMeins(item.getMEINS().toString());
					dto.setMenge(item.getMENGE().toString());
					dto.setNetwr(item.getNETWR().toString());
					dto.setPunit(item.getPUNIT().toString());
					dto.setTxz01(item.getTXZ01().toString());
					dto.setWaers(item.getWAERS().toString());
					dto.setXblnr(item.getXBLNR().toString());
					dto.setZmenge(item.getZMENGE().toString());
					dto.setInvoiceDocItem(item.getINVOICE_DOC_ITEM().toString());
					dto.setPoNumber(item.getPO_NUMBER().toString());
					dto.setPoItem(item.getPO_ITEM().toString());
					dto.setRefDoc(item.getREF_DOC().toString());
					dto.setRefDocYear(item.getREF_DOC_YEAR().toString());
					dto.setRefDocIt(item.getREF_DOC_IT().toString());
					dto.setItemAmount(item.getITEM_AMOUNT().toString());
					dto.setQuantity(item.getQUANTITY().toString());
					dto.setPoUnit(item.getPO_UNIT().toString());
					dto.setPoPrQnt(item.getPO_PR_QNT().toString());
					dto.setPoPrUom(item.getPO_PR_UOM().toString());
					dto.setCondType(item.getCOND_TYPE().toString());
					dto.setSheetNo(item.getSHEET_NO().toString());
					dto.setSheetItem(item.getSHEET_ITEM().toString());
					jsonResponse.add(dto);
				}
				return getResponseMap(jsonResponse);
			}					
		} else {
			return getModelMapError("ERROR");
		}
	}
	
	@RequestMapping(value= "/pendingInvoicesExcel.action", method = RequestMethod.GET)
	public ModelAndView getInvoicesExcel(HttpSession session, HttpServletRequest request, String bukrs, String ekorg, String fechaIni, String fechaFin, String ebeln, String currency, Integer receptionType) throws AxisFault {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			Z_FE_FM_ORDEN_FACTURAResponse response = providerService.getPendingInvoices(bukrs,ekorg,user.getI_LIFNR().toString(), fechaIni, fechaFin, ebeln, locale.getLanguage(), receptionType, currency);
			if(response.getE_TYPE().toString().equals("E")) {
				return new ModelAndView(purchaseWOInvoiceView,null);
			} else {
				final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				E_PO_type0 invoices = response.getE_PO();
				ZTL_ORDER_FAC[] data = invoices.getItem();
				List<PendingOrdersDto> jsonResponse = new ArrayList<PendingOrdersDto>();
				
				for(ZTL_ORDER_FAC item : data) {
					PendingOrdersDto dto = new PendingOrdersDto();
					dto.setAedat(item.getAEDAT().getObject() instanceof Date ? sdf.format((java.util.Date) item.getAEDAT().getObject()):
						   													   item.getAEDAT().getObject().toString());
					dto.setBudat(item.getBUDAT().getObject() instanceof Date ? sdf.format((Date) item.getBUDAT().getObject()) :
																			   item.getBUDAT().getObject().toString());
					dto.setBuzei(item.getBUZEI().toString());
					dto.setEbeln(item.getEBELN().toString());
					dto.setEbelp(item.getEBELP().toString());
					dto.setMatnr(item.getMATNR().toString());
					dto.setMblnr(item.getMBLNR().toString());
					dto.setMeins(item.getMEINS().toString());
					dto.setMenge(item.getMENGE().toString());
					dto.setNetwr(item.getNETWR().toString());
					dto.setPunit(item.getPUNIT().toString());
					dto.setTxz01(item.getTXZ01().toString());
					dto.setWaers(item.getWAERS().toString());
					dto.setXblnr(item.getXBLNR().toString());
					dto.setZmenge(item.getZMENGE().toString());
					jsonResponse.add(dto);
				}
				Map<String, Object> reportModel = new HashMap<String, Object>();
	            reportModel.put("data", jsonResponse);
				return new ModelAndView(purchaseWOInvoiceView,reportModel);
			}
		} else {
			return new ModelAndView(purchaseWOInvoiceView,null);
		}
	}
	
	@RequestMapping(value = "/accountStatus.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getAccountStatus(HttpSession session, HttpServletRequest request, String bukrs) {
		LOGGER.info("Getting account status");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {			
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Z_FE_FM_ESTADO_CUENTAResponse response = providerService.getAccountStatus(user.getI_LIFNR().toString(), bukrs, locale.getLanguage());
				LOGGER.info("Response type: " + response.getE_TYPE().toString() + ", response msg: " + response.getE_MSG().toString());
				if(response.getE_TYPE().toString().equals("E")) {
					return getModelMapError(response.getE_MSG().toString());
				} else {
					E_LISTA_P_ABIERTA_type0 listaAbierta = response.getE_LISTA_P_ABIERTA();
					E_LISTA_P_COMPENSADA_type0 listaCompensada = response.getE_LISTA_P_COMPENSADA();
					ZST_ESTADO_CUENTA[] data = listaAbierta.getItem();
					ZST_ESTADO_CUENTA[] dataCompensada = listaCompensada.getItem();
					
					List<EstadoCuentaDto> abierta = new ArrayList<EstadoCuentaDto>();
					List<EstadoCuentaDto> compensada = new ArrayList<EstadoCuentaDto>();
					if(data != null && data.length > 0)
					for(ZST_ESTADO_CUENTA item : data) {
						EstadoCuentaDto dto = new EstadoCuentaDto();
						dto.setAugbl(item.getAUGBL().toString());
						dto.setAugdt(item.getAUGDT().getObject() instanceof Date ? sdf.format((Date)item.getAUGDT().getObject()) :
																				   item.getAUGDT().getObject().toString());
						dto.setBelnr(item.getBELNR().toString());
						dto.setBlart(item.getBLART().toString());
						dto.setBudat(item.getBUDAT().getObject() instanceof Date ? sdf.format((Date)item.getBUDAT().getObject()) :
																				   item.getBUDAT().getObject().toString());
						dto.setWaers(item.getWAERS().toString());
						dto.setWrbtr(item.getWRBTR().toString());
						dto.setXblnr(item.getXBLNR().toString());
						dto.setZfbdt(item.getZFBDT().getObject() instanceof Date ? sdf.format((Date)item.getZFBDT().getObject()) :
																				   item.getZFBDT().getObject().toString());
						abierta.add(dto);
					}
					if(dataCompensada != null && dataCompensada.length > 0)
					for(ZST_ESTADO_CUENTA item : dataCompensada) {
						EstadoCuentaDto dto = new EstadoCuentaDto();
						dto.setAugbl(item.getAUGBL().toString());
						dto.setAugdt(item.getAUGDT().getObject() instanceof Date ? sdf.format((Date)item.getAUGDT().getObject()) :
							   													   item.getAUGDT().getObject().toString());
						dto.setBelnr(item.getBELNR().toString());
						dto.setBlart(item.getBLART().toString());
						dto.setBudat(item.getBUDAT().getObject() instanceof Date ? sdf.format((Date)item.getBUDAT().getObject()) :
							   													   item.getBUDAT().getObject().toString());
						dto.setWaers(item.getWAERS().toString());
						dto.setWrbtr(item.getWRBTR().toString());
						dto.setXblnr(item.getXBLNR().toString());
						dto.setZfbdt(item.getZFBDT().getObject() instanceof Date ? sdf.format((Date)item.getZFBDT().getObject()) :
							   													   item.getZFBDT().getObject().toString());
						compensada.add(dto);
					}
					return getTwoList(abierta, compensada);
				}
				
			} catch (Exception e) {
				LOGGER.error("Error estado de cuenta:" + e.getMessage(), e);
				return getModelMapError(e.getMessage());
			}
			
		}
		return getModelMapError("No session");
	}
	
	@RequestMapping(value = "/accountStatusExcel.action", method = RequestMethod.GET)	
	public ModelAndView getAccountStatusExcel(HttpSession session, HttpServletRequest request, String bukrs) {
		LOGGER.info("Getting account status");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Z_FE_FM_ESTADO_CUENTAResponse response = providerService.getAccountStatus(user.getI_LIFNR().toString(), bukrs, locale.getLanguage());
				LOGGER.info("Response type: " + response.getE_TYPE().toString() + ", response msg: " + response.getE_MSG().toString());
				if(response.getE_TYPE().toString().equals("E")) {
					return new ModelAndView(accountStatusView,null);
				} else {
					E_LISTA_P_ABIERTA_type0 listaAbierta = response.getE_LISTA_P_ABIERTA();
					E_LISTA_P_COMPENSADA_type0 listaCompensada = response.getE_LISTA_P_COMPENSADA();
					ZST_ESTADO_CUENTA[] data = listaAbierta.getItem();
					ZST_ESTADO_CUENTA[] dataCompensada = listaCompensada.getItem();
					
					List<EstadoCuentaDto> abierta = new ArrayList<EstadoCuentaDto>();
					List<EstadoCuentaDto> compensada = new ArrayList<EstadoCuentaDto>();
					if(data != null && data.length > 0)
					for(ZST_ESTADO_CUENTA item : data) {
						EstadoCuentaDto dto = new EstadoCuentaDto();
						dto.setAugbl(item.getAUGBL().toString());
						dto.setAugdt(item.getAUGDT().getObject() instanceof Date ? sdf.format((Date)item.getAUGDT().getObject()) :
							   													   item.getAUGDT().getObject().toString());
						dto.setBelnr(item.getBELNR().toString());
						dto.setBlart(item.getBLART().toString());
						dto.setBudat(item.getBUDAT().getObject() instanceof Date ? sdf.format((Date)item.getBUDAT().getObject()) :
							   													   item.getBUDAT().getObject().toString());
						dto.setWaers(item.getWAERS().toString());
						dto.setWrbtr(item.getWRBTR().toString());
						dto.setXblnr(item.getXBLNR().toString());
						dto.setZfbdt(item.getZFBDT().getObject() instanceof Date ? sdf.format((Date)item.getZFBDT().getObject()) :
							   													   item.getZFBDT().getObject().toString());
						abierta.add(dto);
					}
					if(dataCompensada != null && dataCompensada.length > 0)
					for(ZST_ESTADO_CUENTA item : dataCompensada) {
						EstadoCuentaDto dto = new EstadoCuentaDto();
						dto.setAugbl(item.getAUGBL().toString());
						dto.setAugdt(item.getAUGDT().getObject() instanceof Date ? sdf.format((Date)item.getAUGDT().getObject()) :
							   													   item.getAUGDT().getObject().toString());
						dto.setBelnr(item.getBELNR().toString());
						dto.setBlart(item.getBLART().toString());
						dto.setBudat(item.getBUDAT().getObject() instanceof Date ? sdf.format((Date)item.getBUDAT().getObject()) :
							   													   item.getBUDAT().getObject().toString());
						dto.setWaers(item.getWAERS().toString());
						dto.setWrbtr(item.getWRBTR().toString());
						dto.setXblnr(item.getXBLNR().toString());
						dto.setZfbdt(item.getZFBDT().getObject() instanceof Date ? sdf.format((Date)item.getZFBDT().getObject()) :
							   													   item.getZFBDT().getObject().toString());
						compensada.add(dto);
					}
					Map<String, Object> reportModel = new HashMap<String, Object>();
		            reportModel.put("dataOpen", abierta);
		            reportModel.put("dataComp", compensada);
					return new ModelAndView(accountStatusView,reportModel);
				}
				
			} catch (Exception e) {
				LOGGER.error("Error estado de cuenta:" + e.getMessage(), e);
				return new ModelAndView(accountStatusView,null);
			}
			
		}
		return new ModelAndView(accountStatusView,null);
	}
	
	@RequestMapping(value = "/confirmAccountStatus.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> confirmAccountStatus(String bukrs, String estado, HttpSession session, HttpServletRequest request) {
		LOGGER.info("Setting account status");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			try {
				Z_FE_FM_CONFIRMA_ESTADO_CUENTAResponse response = providerService.setAccountStatus(user.getI_LIFNR().toString(), bukrs, locale.getLanguage().toUpperCase(), estado);
				if(response.getE_TYPE().toString().equals("E")) {
					return getModelMapError(response.getE_MSG().toString());
				} else {
					return getModelMapSuccess(response.getE_MSG().toString());
				}
			} catch (Exception e) {
				LOGGER.error("Error setting accountStatus: " + e.getMessage(), e);
				return getModelMapError("Error: " + e.getMessage());
			}
		} else {
			return getModelMapError("Error");
		}
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/changePassword.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> changePassword(String oldPass, String newPass, String newPassReview, HttpSession session, HttpServletRequest request, String email) {
		
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		LOGGER.info("Changing password for provider: " +  user.getI_LIFNR());
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			try {
				Z_FE_FM_CAMBIO_PSWD_PROVResponse response = providerService.changePassword(user.getI_LIFNR(), oldPass, newPass, newPassReview, locale.getLanguage().toUpperCase(), email);
				if(response.getE_TYPE().toString().equals("E")) {
					return getModelMapError(response.getE_MSG().toString());
				} else {
					return getModelMapSuccess(response.getE_MSG().toString());
				}				
			} catch (Exception e) {
				LOGGER.error("Error changing password: " + e.getMessage(),e);
				return getModelMapError("Error: " + e.getMessage());
			}
		}		
		return getModelMapError("Error");
	}
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/getNotifications.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getNotifications(String bukrs, HttpSession session, HttpServletRequest request, String tipoAviso) {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		LOGGER.info("Getting notifications for provider: " + user.getI_LIFNR() + ", bukrs:" + bukrs);
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			try {
				final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Z_FE_FM_OBTIENE_AVISOSResponse response = providerService.getNotifications(user.getI_LIFNR(), bukrs, locale.getLanguage().toUpperCase(), tipoAviso);
				if(response.getE_TYPE().toString().toUpperCase().equals("E")) {
					return getModelMapError(response.getE_MSG().toString());
				} else {
				    E_LISTAPROV_type0 tmp = response.getE_LISTAPROV();
				    ZST_AVISO[] notifications = tmp.getItem();
				    List<NotificationDto> jsonResponse = new ArrayList<NotificationDto>();
				    if(notifications != null && notifications.length > 0) {				    	
				    	for(ZST_AVISO notification : notifications) {
				    		NotificationDto dto = new NotificationDto();
				    		dto.setBukrs(notification.getBUKRS().toString());
				    		dto.setCuerpo(notification.getCUERPO().toString());
				    		dto.setEstatus(notification.getESTATUS().toString());
				    		dto.setFecha(notification.getFECHA().getObject() instanceof Date ? sdf.format((Date)notification.getFECHA().getObject()):
				    																		   notification.getFECHA().getObject().toString());
				    		dto.setIdioma(notification.getIDIOMA().toString());
				    		dto.setNaviso(Short.toString(notification.getNAVISO()));
				    		dto.setTitulo(notification.getTITULO().toString());
				    		dto.setIdAviso(notification.getIDAVISO().toString());
				    		dto.setEstatusLectura(notification.getESTATUSLECTURA().toString());
				    		jsonResponse.add(dto);
				    	}
				    }
				    E_LISTGENERAL_type0 tmp2 = response.getE_LISTGENERAL();
				    notifications = tmp2.getItem();
				    if(notifications != null && notifications.length > 0) {
				    	for(ZST_AVISO notification : notifications) {
				    		NotificationDto dto = new NotificationDto();
				    		dto.setBukrs(notification.getBUKRS().toString());
				    		dto.setCuerpo(notification.getCUERPO().toString());
				    		dto.setEstatus(notification.getESTATUS().toString());
				    		dto.setFecha(notification.getFECHA().getObject() instanceof Date ? sdf.format((Date)notification.getFECHA().getObject()):
								   															   notification.getFECHA().getObject().toString());
				    		dto.setIdioma(notification.getIDIOMA().toString());
				    		dto.setNaviso(Short.toString(notification.getNAVISO()));
				    		dto.setTitulo(notification.getTITULO().toString());
				    		dto.setIdAviso(notification.getIDAVISO().toString());
				    		dto.setEstatusLectura(notification.getESTATUSLECTURA().toString());
				    		jsonResponse.add(dto);
				    	}
				    }
				    return getResponseMap(jsonResponse);
				}
			} catch (Exception e) {
				LOGGER.error("Error getting notifications:" + e.getMessage(),e);
				return getModelMapError("Error: " + e.getMessage());
			}
		} else{
			return getModelMapError("ERROR GENERAL");
		}
		
	}
	
	@RequestMapping(value = "/forgotPassword.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> forgotPassword(String email, String providerCode) {
		try {
			Z_FE_FM_ENVIO_TOKENResponse token = providerService.getToken(providerCode, email);
			if(token.getE_TYPE().toString().toUpperCase().equals("E")) {
				return getModelMapError(token.getE_MSG().toString());
			} else {
				return getModelMapSuccess(token.getE_MSG().toString());
			}
		} catch (Exception e) {
			LOGGER.error("Error getting token:" + e.getMessage(),e);
			return getModelMapError("Error: " + e.getMessage());
		}				 
	}
	
	@RequestMapping(value = "/validateToken.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> validateToken(String email, String providerCode, String token, String newPass, String newPassReview) {
		try {
			Z_FE_FM_VALIDACION_TOKENResponse validaToken = providerService.validaToken(providerCode, email, token);
			if(validaToken.getE_TYPE().toString().toUpperCase().equals("E")) {
				return getModelMapError(validaToken.getE_MSG().toString());
			} else {
				LOGGER.info("Validated token, changing password: " + validaToken.getE_MSG() + " for provider: " + validaToken.getE_LIFNR().toString());
				Z_FE_FM_CAMBIO_PSWD_PROVResponse cambioPasswd = providerService.changePassword(validaToken.getE_LIFNR().toString(), null, newPass, newPassReview, "ES", email);
				if(cambioPasswd.getE_TYPE().toString().toUpperCase().equals("E")){
					return getModelMapError(cambioPasswd.getE_MSG().toString());
				} else {
					return getModelMapSuccess(cambioPasswd.getE_MSG().toString());
				}				
			}
		} catch (Exception e) {
			LOGGER.error("Error validating token:" + e.getMessage(),e);
			return getModelMapError("Error: " + e.getMessage());
		}
	}
	
	@RequestMapping(value = "/getUnreadNotificationsNumber.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUnreadNotificationsNumber(HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		try {
			Z_FE_FM_CONTADOR_AVISOS_NLEResponse response = providerService.getUnreadNotificationsNumber(user.getI_LIFNR());
			if(response.getE_TYPE().toString().toUpperCase().equals("E")) {
				return getModelMapError("Error: " + response.getE_MSG().toString());
			} else {
				return getResponseMapFromObject(response.getE_VALOR());
			}
		} catch (Exception e) {
			LOGGER.error("Error getting UnreadNotificationsNumber:", e);
			return getModelMapError("Error:" + e.getMessage());
		}
	}
	
	@RequestMapping(value = "/setNotificationStatus.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> setNotificationStatus(HttpSession session, String bukrs, String idaviso, String evento) {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		try {
			Z_FE_FM_UPDATE_LECTURA_AVISOResponse response = providerService.setNotificationStatus(user.getI_LIFNR(), bukrs, idaviso, evento);
			if(response.getE_TYPE().toString().toUpperCase().equals("E")) {
				return getModelMapError("Error:" + response.getE_MSG().toString());
			} else {
				return getModelMapSuccess(response.getE_MSG().toString());
			}
		} catch (Exception e) {
			LOGGER.error("Error setting notification status: ", e);
			return getModelMapError("Error: " + e.getMessage());
		}
	}
	
	@RequestMapping(value = "/getCostCenter.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getCostCenter(HttpServletRequest request,HttpSession session,String bukrs) {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			try {
//				ZFE_FM_GL_ACCOUNT_COST_CENTERResponse response = providerService.getCostCenter(bukrs, user.getI_LIFNR().toString(), locale.getLanguage().toUpperCase());
//				BAPIE1RET2[] items = response.getRETURN().getItem();
//				if(items != null) {					
//					StringBuilder messages = new StringBuilder();
//					for(BAPIE1RET2 item : items) {
//						messages.append(item.getMESSAGE() + "<br/>");
//					}
//					return getModelMapError(messages.toString());
//				} else {
//					CSKT cskt[] = response.getET_CSKT().getItem();
//					SKAT skat[] = response.getET_SKAT().getItem();
//					if(cskt != null && skat != null) {
//						if(cskt.length > 0 || skat.length > 0) {
//							List<CentroDeCostoDto> jsonResponse = new ArrayList<CentroDeCostoDto>();
//							List<CuentaMayorDto> cuentas = new ArrayList<CuentaMayorDto>();
//							for(CSKT cst : cskt){
//								CentroDeCostoDto dto = new CentroDeCostoDto();
//								dto.setKostl(cst.getKOSTL().toString());
//								dto.setLtext(cst.getLTEXT().toString());
//								jsonResponse.add(dto);
//							}
//							for(SKAT sk: skat) {
//								CuentaMayorDto dto = new CuentaMayorDto();
//								dto.setSaknr(sk.getSAKNR().toString());
//								dto.setTxt50(sk.getTXT50().toString());
//								cuentas.add(dto);
//							}
//							
//							return getResponseMap(jsonResponse, cuentas);
//						} else
//							return getModelMapError(locale.getLanguage().toUpperCase().equals("ES") ? "No hay información" : "No Data available");
//					} else {
//						return getModelMapError(locale.getLanguage().toUpperCase().equals("ES") ? "Información nula" : "Null Data");
//					}
//						 
//							
//				}
			} catch (Exception e) {
				LOGGER.error("ERROR COST CENTER:",e);
				return getModelMapError("Error: " + e.getMessage());
			}
		} else {
			return getModelMapError("Login Error");
		}
		return null;
	}
	
	@RequestMapping(value = "/getCuentas.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getCuentas(String bukrs, HttpServletRequest request, HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			try {
//				Z_FE_FM_OBTIENE_DAT_ACCT_PROVResponse response = providerService.getCuentas(bukrs, user.getI_LIFNR(), locale.getLanguage().toUpperCase());
//				if(response.getE_TYPE().toString().toUpperCase().equals("E")) {
//					return getModelMapError(response.getE_MSG().toString());
//				} else {
//					ZST_CEN_COST_CTA_MAYOR[] cuentas = response.getE_ACCOUNTING().getItem();
//					List<CuentasDto> accounts = new ArrayList<CuentasDto>();
//					for(ZST_CEN_COST_CTA_MAYOR cuenta : cuentas) {
//						CuentasDto dto = new CuentasDto();
//						dto.setBukrs(cuenta.getBUKRS().toString());
//						dto.setHkont(cuenta.getHKONT().toString());
//						dto.setItemcen(cuenta.getITEMCEN().toString());
//						dto.setItemcta(cuenta.getITEMCTA().toString());
//						dto.setKokrs(cuenta.getKOKRS().toString());
//						dto.setKostl(cuenta.getKOSTL().toString());
//						dto.setKtopl(cuenta.getKTOPL().toString());
//						dto.setLifnr(cuenta.getLIFNR().toString());
//						accounts.add(dto);
//					}
//					return getResponseMap(accounts);
//				}
			} catch (Exception e) {
				LOGGER.error("ERROR getting Cuentas:", e);
				return getModelMapError("Error: " + e.getMessage());
			}
		} else {
			return getModelMapError("Login Error");
		}
		return null;
	}
	
	@RequestMapping(value = "/getPeriods.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getPeriods(String bukrs, HttpServletRequest request, HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			try {
				List<PeriodDto> jsonResponse = new ArrayList<PeriodDto>();
				Z_FE_FM_OBTIENE_PERIODO_CONSIGResponse response = providerService.getPeriods(user.getI_LIFNR(), bukrs);
				if("e".equals(response.getE_TYPE().toString().toLowerCase())){
					return getModelMapError("Error: " + response.getE_MSG());
				}else {
					ZST_PERIODO[] periods = response.getE_PERIODO().getItem();
					if(periods != null & periods.length > 0) {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						for(ZST_PERIODO period : periods) {
							if("X".equals(period.getCERRADO().toString().toUpperCase())) {
								continue;
							}
							PeriodDto periodDto = new PeriodDto();
							periodDto.setCerrado(period.getCERRADO().toString());
							periodDto.setFin(period.getFIN().getObject() instanceof Date ? sdf.format((Date)period.getFIN().getObject()) :
																						   period.getFIN().getObject().toString());
							periodDto.setGjahr(period.getGJAHR().toString());
							periodDto.setInicio(period.getINICIO().getObject() instanceof Date ? sdf.format((Date)period.getINICIO().getObject()) :
																					 period.getINICIO().getObject().toString());
							periodDto.setMonat(period.getMONAT().toString());
							jsonResponse.add(periodDto);
						}
					}
					return getResponseMap(jsonResponse);
				}
			} catch (Exception e) {
				LOGGER.error("Error getting periods",e);
				return getModelMapError("Error periods:" + e.getMessage());
			}
		}
		return getModelMapError("Sesion inválida, favor de reingresar");
	}
	
	@RequestMapping(value = "/getConsignacion.action")
	@ResponseBody
	public Map<String, Object> getConsignacion(@RequestBody ConsignacionRequestDto consignacionRequestDto, HttpServletRequest request, HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			try {
				consignacionRequestDto.setLifnr(user.getI_LIFNR());
				consignacionRequestDto.setIdioma(locale.getLanguage().toUpperCase());
				Z_FE_FM_DET_FACT_CONSIGResponse response = providerService.getConsignacion(consignacionRequestDto);
				if("E".equals(response.getE_TYPE().toString().toUpperCase())) {
					return getModelMapError("Error: " + response.getE_MSG());
				} else {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					ZST_MATERIAL_DET[] materiales = response.getE_MATERIAL().getItem();
					if(materiales != null && materiales.length > 0) {
						List<MaterialDto> jsonResponse = new ArrayList<MaterialDto>();
						for(ZST_MATERIAL_DET material : materiales) {
							MaterialDto materialDto = new MaterialDto();
							materialDto.setBstmg(material.getBSTMG().toString());
							materialDto.setBstme(material.getBSTME().toString());
							materialDto.setHigh(material.getRANGO_SEM().getHIGH().getObject() instanceof Date ?
																	sdf.format((Date)material.getRANGO_SEM().getHIGH().getObject()) :
																	material.getRANGO_SEM().getHIGH().toString());
							materialDto.setLow(material.getRANGO_SEM().getLOW().getObject() instanceof Date ? 
																	sdf.format((Date)material.getRANGO_SEM().getLOW().getObject()) :
																	material.getRANGO_SEM().getLOW().toString());
							materialDto.setMaktx(material.getMAKTX().toString());
							materialDto.setMatnr(material.getMATNR().toString());
							materialDto.setNetpr(material.getNETPR().toString());
							materialDto.setNetwr(material.getNETWR().toString());
							materialDto.setWaers(material.getWAERS().toString());
							materialDto.setZsem(material.getZSEM().toString());
							materialDto.setMblnr(material.getMBLNR().toString());
							jsonResponse.add(materialDto);							
						}
						return getResponseMap(jsonResponse);
					}
				}
				
			} catch (Exception e) {
				LOGGER.error("Error getting consignacion doctos:", e);
				return getModelMapError("Exception: " + e.getMessage());
			}
		}
		return getModelMapError("Sesion inválida, favor de reingresar");
	}
	
	@RequestMapping(value = "/getAccounts.action")
	@ResponseBody
	public Map<String, Object> getAccounts(String bukrs, HttpServletRequest request, HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			try {
				Z_FE_FM_OBTIENE_DAT_ACCT_PROVResponse response = providerService.getAccounts(user.getI_LIFNR(), bukrs, locale.getLanguage().toUpperCase());
				if(response != null && "E".equals(response.getE_TYPE().toString().toUpperCase())) {
					LOGGER.info("Error Accounts:" + response.getE_MSG());
					return getModelMapError(response.getE_MSG().toString());
				} else {
					ZST_CTA_MAYOR[] accounts = response.getE_ACCOUNTING().getItem();
					if(accounts != null && accounts.length > 0) {
						List<Account> jsonResponse = new ArrayList<Account>();
						for(ZST_CTA_MAYOR account : accounts) {
							Account acc = new Account();
							acc.setBukrs(account.getBUKRS().toString());
							acc.setHkont(account.getHKONT().toString());
							acc.setItemcta(account.getITEMCTA().toString());
							acc.setKtopl(account.getKTOPL().toString());
							acc.setLifnr(account.getLIFNR().toString());
							jsonResponse.add(acc);
						}
						return getResponseMap(jsonResponse);
					}
				}
			} catch(Exception e) {
				LOGGER.error("Error getting accounts",e);
				return getModelMapError("Error:" + e.getMessage());
			}
		}
		return getModelMapError("No sesion");
	}
	
}
