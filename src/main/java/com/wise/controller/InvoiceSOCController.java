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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.wise.model.UserDto;
import com.wise.service.InvoiceService;

import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_ORDERResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse;

@Controller
@RequestMapping("/soc")
public class InvoiceSOCController extends BaseController {
	private static final Logger LOGGER = LogManager.getLogger(InvoiceSOCController.class);
	
	@Autowired
	private InvoiceService invoiceService;
	
	
	@RequestMapping(value = "/addCFDI.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addCFDI(@RequestParam("file") MultipartFile[] files, String invoice, HttpSession session, String hdnRazonSocial, String hdnArea, String hdnResponsable, String concept, HttpServletResponse responseServlet, HttpServletRequest request, String hdnDivision, String referencia) throws IOException {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(responseServlet);
		wrapper.setContentType("text/html;charset=UTF-8");
		if(user != null) {
			try {
				Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse response = invoiceService.addCFDISOC(hdnRazonSocial, files, user.getI_LIFNR(), invoice, concept, hdnArea, hdnResponsable, locale.getLanguage(), hdnDivision, referencia);
				if(response != null) {
					if(response.getE_TYPE().toString().equals("E")){
						wrapper.getWriter().write("{success:false,msg:'"+response.getE_MSG().toString().replace("'", "\"") +"'}");
						return null;
					}else {
						wrapper.getWriter().write("{success:true,msg:'"+response.getE_MSG().toString().replace("'", "\"") +"'}");
						return null;
						
					}
				}
			} catch (Exception e) {
				LOGGER.error("ERROR CFDISOC:",e);
				wrapper.getWriter().write("{success:false,msg:'Server Error'}");
				return null;
			}
		}
		wrapper.getWriter().write("{success:false,msg:'Server Error'}");
		return null;
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
															String total, 
															String concepto,
															String hdnArea,
															String hdnResponsable,
															String referencia,
															HttpServletResponse responseServlet,
															HttpServletRequest request,
															HttpSession session,
															String hdnDivision) throws IOException {
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(responseServlet);
		wrapper.setContentType("text/html;charset=UTF-8");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			try {
				Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse response = invoiceService.addCBBSOC(hdnRazonSocial, files, user.getI_LIFNR(), invoice, concepto, hdnArea, hdnResponsable, total, subtotal, fechaInvoice, hdnIva, retenciones, hdnMoneda, locale.getLanguage(), hdnDivision, referencia);				
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
			} catch (IOException e) {
				LOGGER.error("Error addCBBSOC:", e);
				wrapper.getWriter().write("{success:false,msg:'"+e.getMessage() +"'}");
				return null;
			}
			
		} else {
			wrapper.getWriter().write("{success:false,msg:'Error de sesión'}");
			return null;
		}
				
	}
	
	@RequestMapping(value = "/addCFDIAgencias.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addCFDIAgencias(@RequestParam("file") MultipartFile[] files, 
											  String invoice, HttpSession session, 
											  String hdnRazonSocial, String hdnArea, 
											  String hdnResponsable, String concept, 
											  HttpServletResponse responseServlet, 
											  HttpServletRequest request, 
											  String hdnDivision, String referencia, 
											  String accounting) throws IOException {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(responseServlet);
		wrapper.setContentType("text/html;charset=UTF-8");
		if(user != null) {
			try {
				Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse response = invoiceService.addCFDISOCAgencias(hdnRazonSocial, files, user.getI_LIFNR(), invoice, concept, hdnArea, hdnResponsable, locale.getLanguage(), hdnDivision, referencia, accounting);
				if(response != null) {
					if(response.getE_TYPE().toString().equals("E")){
						wrapper.getWriter().write("{success:false,msg:'"+response.getE_MSG().toString().replace("'", "\"") +"'}");
						return null;
					}else {
						wrapper.getWriter().write("{success:true,msg:'"+response.getE_MSG().toString().replace("'", "\"") +"'}");
						return null;
						
					}
				}
			} catch (Exception e) {
				LOGGER.error("ERROR CFDISOC:",e);
				wrapper.getWriter().write("{success:false,msg:'Server Error'}");
				return null;
			}
		}
		wrapper.getWriter().write("{success:false,msg:'Server Error'}");
		return null;
	}
	
	@RequestMapping(value = "/addCBBAgencias.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addCBBAgentes(@RequestParam("file") MultipartFile[] files,
															String invoice, 															
															String hdnRazonSocial, 
															String fechaInvoice, 
															String hdnIva, 
															String hdnMoneda, 
															String retenciones, 
															String subtotal, 
															String total, 
															String concepto,
															String hdnArea,
															String hdnResponsable,
															String account,
															String costCenter,
															String accounting,
															HttpServletResponse responseServlet,
															HttpServletRequest request,
															HttpSession session) throws IOException {
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(responseServlet);
		wrapper.setContentType("text/html;charset=UTF-8");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			try {
				Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse response = invoiceService.addCBBSOCAgencias(hdnRazonSocial, files, user.getI_LIFNR(), invoice, concepto, hdnArea, 
						hdnResponsable, total, subtotal, fechaInvoice, hdnIva, retenciones, hdnMoneda, locale.getLanguage(), new JSONArray(accounting));				
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
			} catch (IOException e) {
				LOGGER.error("Error addCBBSOCAgentes:", e);
				wrapper.getWriter().write("{success:false,msg:'"+e.getMessage() +"'}");
				return null;
			} catch (JSONException e) {
				LOGGER.error("Error addCBBSOCAgentes:", e);
				wrapper.getWriter().write("{success:false,msg:'"+e.getMessage() +"'}");
				return getModelMapError("Error:" + e.getMessage());
			}
			
		} else {
			wrapper.getWriter().write("{success:false,msg:'Error de sesión'}");
			return null;
		}
	}
	
	@RequestMapping(value = "/addCFDIFletes.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addCFDIFletes(@RequestParam("file") MultipartFile[] files, 
											  String invoice, HttpSession session, 
											  String hdnRazonSocial, String hdnArea, 
											  String hdnResponsable, String concept, 
											  HttpServletResponse responseServlet, 
											  HttpServletRequest request, 
											  String hdnDivision, String referencia, 
											  String accounting) throws IOException {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(responseServlet);
		wrapper.setContentType("text/html;charset=UTF-8");
		if(user != null) {
			try {
				Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse response = invoiceService.addCFDISOCFletes(hdnRazonSocial, files, user.getI_LIFNR(), invoice, concept, hdnArea, hdnResponsable, locale.getLanguage(), hdnDivision, referencia, accounting);
				if(response != null) {
					if(response.getE_TYPE().toString().equals("E")){
						wrapper.getWriter().write("{success:false,msg:'"+response.getE_MSG().toString().replace("'", "\"") +"'}");
						return null;
					}else {
						wrapper.getWriter().write("{success:true,msg:'"+response.getE_MSG().toString().replace("'", "\"") +"'}");
						return null;
						
					}
				}
			} catch (Exception e) {
				LOGGER.error("ERROR CFDISOCFletes:",e);
				wrapper.getWriter().write("{success:false,msg:'Server Error'}");
				return null;
			}
		}
		wrapper.getWriter().write("{success:false,msg:'Server Error'}");
		return null;
	}
	
	@RequestMapping(value = "/addCBBFletes.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addCBBFletes(@RequestParam("file") MultipartFile[] files,
															String invoice, 															
															String hdnRazonSocial, 
															String fechaInvoice, 
															String hdnIva, 
															String hdnMoneda, 
															String retenciones, 
															String subtotal, 
															String total, 
															String concepto,
															String hdnArea,
															String hdnResponsable,
															String account,
															String costCenter,
															String accounting,
															HttpServletResponse responseServlet,
															HttpServletRequest request,
															HttpSession session) throws IOException {
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(responseServlet);
		wrapper.setContentType("text/html;charset=UTF-8");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			try {
				Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse response = invoiceService.addCBBSOCFletes(hdnRazonSocial, files, user.getI_LIFNR(), invoice, concepto, hdnArea, 
						hdnResponsable, total, subtotal, fechaInvoice, hdnIva, retenciones, hdnMoneda, locale.getLanguage(), new JSONArray(accounting));				
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
			} catch (IOException e) {
				LOGGER.error("Error addCBBSOCFletes:", e);
				wrapper.getWriter().write("{success:false,msg:'"+e.getMessage() +"'}");
				return null;
			} catch (JSONException e) {
				LOGGER.error("Error addCBBSOCFletes:", e);
				wrapper.getWriter().write("{success:false,msg:'"+e.getMessage() +"'}");
				return getModelMapError("Error:" + e.getMessage());
			}
			
		} else {
			wrapper.getWriter().write("{success:false,msg:'Error de sesión'}");
			return null;
		}
				
	}
}
