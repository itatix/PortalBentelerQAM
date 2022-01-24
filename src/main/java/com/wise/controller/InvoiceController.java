package com.wise.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.wise.Util;
import com.wise.model.InvoiceDto;
import com.wise.model.MenusDto;
import com.wise.model.PendingOrdersDto;
import com.wise.model.UserDto;
import com.wise.service.InvoiceService;

import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_ORDERResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_ORDER_VI;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_ORDER_VIResponse;
import functions.rfc.sap.document.sap_com.Z_FI_RECEIVE_PAYMENT_INVOICEResponse;

@Controller
@RequestMapping("/oc")
public class InvoiceController extends BaseController{
	private static final Logger LOGGER = LogManager.getLogger(InvoiceController.class);
	
	@Autowired
	private InvoiceService invoiceService;
	
	@RequestMapping(value = "/addCFDI.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addCFDI(@RequestParam("file") MultipartFile[] files, String cmbRazonSocial, String invoice, HttpSession session, String hdnRazonSocial, HttpServletResponse responseServlet, String hdnFacturas, String referencia, HttpServletRequest request, String hdnDivision, String subto, String receptionType, String moneda) throws IOException {
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(responseServlet);
		wrapper.setContentType("text/html;charset=UTF-8");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		MenusDto menus = (MenusDto) session.getAttribute("menusDto");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			try {
				if(Util.isJSONValid(hdnFacturas)){
					Z_FE_FM_AGREGAR_FAC_ORDER_VIResponse response = invoiceService.addCFDI(hdnRazonSocial, files, user.getI_LIFNR(), new JSONArray(hdnFacturas), referencia, locale.getLanguage(), hdnDivision, subto, receptionType, moneda, menus);
					if(response != null){
						if(response.getE_TYPE().toString().equals("E")) {
							wrapper.getWriter().write("{success:false,msg:'"+response.getE_MSG().toString().replace("'", "\"") +"'}");
							return null;
						} else {
							wrapper.getWriter().write("{success:true,msg:'"+response.getE_MSG().toString().replace("'", "\"") +"'}");
							return null;
						}
					} else {
						wrapper.getWriter().write("{success:false,msg:'Server Error'}");
						return null;
					}
				} else {
					Z_FE_FM_AGREGAR_FAC_ORDERResponse response = invoiceService.addCFDI(hdnRazonSocial, files, user.getI_LIFNR(), hdnFacturas, referencia, locale.getLanguage(), hdnDivision);
					if(response != null){
						if(response.getE_TYPE().toString().equals("E")) {
							wrapper.getWriter().write("{success:false,msg:'"+response.getE_MSG().toString().replace("'", "\"") +"'}");
							return null;
						}else {
							wrapper.getWriter().write("{success:true,msg:'"+response.getE_MSG().toString().replace("'", "\"") +"'}");
							return null;
						}
					} else {
						wrapper.getWriter().write("{success:false,msg:'Server Error'}");
						return null;
					}
				}
				
			} catch (IOException e) {
				LOGGER.error("Error addCFDI:", e);
				wrapper.getWriter().write("{success:false,msg:'"+e.getMessage() +"'}");
				return null;
			} catch (JSONException e) {
				LOGGER.error("Error addCFDI:", e);
				wrapper.getWriter().write("{success:false,msg:'"+e.getMessage() +"'}");
				return null;
			}
			
		} else {
			wrapper.getWriter().write("{success:false,msg:'Error de sesión'}");
			return null;
		}		
				
	}
	
	@RequestMapping(value = "/addCBB.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addCBB(@RequestParam("file") MultipartFile[] files,
															String invoice, 															
															String hdnRazonSocial, 															 
															String fechaInvoice, 
															String hdnIva, 
															String hdnMoneda, 
															String retenciones, 
															String subtotal, 
															String referencia,
															String hdnFacturas,
															String subto,
															HttpServletResponse responseServlet,
															HttpServletRequest request,
															HttpSession session,
															String receptionType,
															String moneda,
															String hdnDivision) throws IOException {
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(responseServlet);
		wrapper.setContentType("text/html;charset=UTF-8");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			try {
				if(Util.isJSONValid(hdnFacturas)){
					Z_FE_FM_AGREGAR_FAC_ORDER_VIResponse response = invoiceService.addCBB(files, new JSONArray(hdnFacturas), hdnRazonSocial, fechaInvoice, hdnIva, hdnMoneda, retenciones, subtotal, user.getI_LIFNR(), hdnMoneda, referencia, invoice, locale.getLanguage(), hdnDivision, subto, receptionType, moneda);
					if(response != null){
						if(response.getE_TYPE().toString().equals("E")) {
							wrapper.getWriter().write("{success:false,msg:'"+response.getE_MSG().toString().replace("'", "\"") +"'}");
							return null;
						}else {
							wrapper.getWriter().write("{success:true,msg:'"+response.getE_MSG().toString().replace("'", "\"") +"'}");
							return null;
						}
					} else {
						wrapper.getWriter().write("{success:false,msg:'Server Error'}");
						return null;
					}
				} else {
					Z_FE_FM_AGREGAR_FAC_ORDERResponse response = invoiceService.addCBB(files, hdnFacturas, hdnRazonSocial, fechaInvoice, hdnIva, hdnMoneda, retenciones, subtotal, user.getI_LIFNR(), hdnMoneda, referencia, invoice, locale.getLanguage(), hdnDivision);				
					if(response != null){
						if(response.getE_TYPE().toString().equals("E")) {
							wrapper.getWriter().write("{success:false,msg:'"+response.getE_MSG().toString().replace("'", "\"") +"'}");
							return null;
						}else {
							wrapper.getWriter().write("{success:true,msg:'"+response.getE_MSG().toString().replace("'", "\"") +"'}");
							return null;
						}
					} else {
						wrapper.getWriter().write("{success:false,msg:'Server Error'}");
						return null;
					}					
				}
				
			} catch (IOException e) {
				LOGGER.error("Error addCBB:", e);
				wrapper.getWriter().write("{success:false,msg:'"+e.getMessage() +"'}");
				return null;
			} catch (JSONException e) {
				LOGGER.error("Error addCBB:", e);
				wrapper.getWriter().write("{success:false,msg:'"+e.getMessage() +"'}");
				return null;
			}
			
		} else {
			wrapper.getWriter().write("{success:false,msg:'Error de sesión'}");
			return null;
		}		
				
	}
	
	@RequestMapping(value = "/addPaymentSupplement.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addPaymentSupplement( @RequestParam("file") MultipartFile[] files,
													InvoiceDto invoiceDto,
													HttpServletResponse responseServlet,
													HttpServletRequest request,
													HttpSession session) throws IOException {
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(responseServlet);
		wrapper.setContentType("text/html;charset=UTF-8");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		invoiceDto.setLifnr(user.getI_LIFNR());
		invoiceDto.setFiles(files);
		if(user != null) {
			Z_FI_RECEIVE_PAYMENT_INVOICEResponse response = invoiceService.addPaymentSupplement(invoiceDto);
			if(response != null){
				if(response.getEV_TYPE().toString().equals("E")) {
					wrapper.getWriter().write("{success:false,msg:'"+response.getEV_MESSAGE().toString().replace("'", "\"") +"'}");
					return null;
				}else {
					wrapper.getWriter().write("{success:true,msg:'"+response.getEV_MESSAGE().toString().replace("'", "\"") +"'}");
					return null;
				}
			} else {
				wrapper.getWriter().write("{success:false,msg:'Server Error'}");
				return null;
			}
		} else {
			try {
				wrapper.getWriter().write("{success:false,msg:'Error de sesión'}");
			} catch (IOException e) {
				e.printStackTrace();
				wrapper.getWriter().write("{success:false,msg:'Error de sesión'}");
			}
			return null;
		}	
	}
}
