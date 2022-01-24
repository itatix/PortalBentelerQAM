package com.wise.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.wise.Util;
import com.wise.model.ConsignacionRequestDto;
import com.wise.model.MaterialDto;
import com.wise.model.UserDto;
import com.wise.service.ConsignacionService;

import functions.rfc.sap.document.sap_com.ZST_MATERIAL_DET;
import functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_CONSIG_ORDERResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_DET_FACT_CONSIGResponse;

@Controller
@RequestMapping("/consignacion")
public class ConsignacionController extends BaseController {
	
	private static final Logger LOGGER = LogManager.getLogger(ConsignacionController.class);
	
	@Autowired
	private ConsignacionService consignacionService;
	
	@RequestMapping(value = "/getDoctos.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> getDoctos(ConsignacionRequestDto consignacionRequestDto, HttpServletRequest request, HttpSession session) {
		LOGGER.info("Getting Consignacion Documents");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			try {
				consignacionRequestDto.setLifnr(user.getI_LIFNR());
				consignacionRequestDto.setIdioma(locale.getLanguage().toUpperCase());
				Z_FE_FM_DET_FACT_CONSIGResponse response = consignacionService.getConsignacion(consignacionRequestDto);
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
	
	@RequestMapping(value = "/addConsignacion.action", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addConsignacion(@RequestParam("file") MultipartFile[] files, String cmbRazonSocial, String invoice, HttpSession session, 
											   String hdnRazonSocial, HttpServletResponse responseServlet, String hdnFacturas, 
											   HttpServletRequest request, String factura, String lowDate, String highDate, String gjahr, String inicio, String fin, String cerrado, String monat) throws IOException {
		LOGGER.info("Adding consignacion");
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(responseServlet);
		wrapper.setContentType("text/html;charset=UTF-8");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		if(user != null) {
			try {
				if(Util.isJSONValid(hdnFacturas)) {
					Z_FE_FM_AGREGAR_CONSIG_ORDERResponse response = consignacionService.addConsignacion(hdnRazonSocial, files, user.getI_LIFNR(), 
																	new JSONArray(hdnFacturas), locale.getLanguage().toUpperCase(), factura, lowDate, highDate, gjahr, inicio, fin, cerrado, monat);
					if(response.getE_TYPE().toString().equals("E")) {
						wrapper.getWriter().write("{success:false,msg:'"+response.getE_MSG().toString().replace("'", "\"") +"'}");
						return null;
					} else {
						wrapper.getWriter().write("{success:true,msg:'"+response.getE_MSG().toString().replace("'", "\"") +"'}");
						return null;
					}
				} else {
					wrapper.getWriter().write("{success:false,msg:'No documentos'}");
					return null;
				}
			} catch (Exception e) {
				LOGGER.error("Error adding consignacion:",e);
				wrapper.getWriter().write("{success:false,msg:'Excepcion: "+ e.getMessage() +"'}");
				return null;
			}
		}		
		wrapper.getWriter().write("{success:false,msg:'No sesion'}");
		return null;
	}

}
