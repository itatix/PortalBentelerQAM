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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.wise.Util;
import com.wise.model.FreightDto;
import com.wise.model.MenusDto;
import com.wise.model.ServiceType;
import com.wise.model.TicketDto;
import com.wise.model.UnidadTipoDto;
import com.wise.model.UserDto;
import com.wise.service.NationalInboxService;

import functions.rfc.sap.document.sap_com.ET_TICKETS_type0;
import functions.rfc.sap.document.sap_com.ZFIST_REFER_EMBAR_FLE;
import functions.rfc.sap.document.sap_com.ZFIST_TICKETS_FLE;
import functions.rfc.sap.document.sap_com.ZFIST_TIPO_SERVICIO_FLE;
import functions.rfc.sap.document.sap_com.ZFIST_UNIDAD_TIPO_FLE;
import functions.rfc.sap.document.sap_com.Z_FI_AGREGAR_BUZON_FLETESResponse;
import functions.rfc.sap.document.sap_com.Z_FI_GET_REFER_EMBARResponse;
import functions.rfc.sap.document.sap_com.Z_FI_GET_TICKETSResponse;
import functions.rfc.sap.document.sap_com.Z_FI_GET_TIPO_SERVICIOResponse;
import functions.rfc.sap.document.sap_com.Z_FI_GET_UNIDAD_TIPOResponse;

@Controller
@RequestMapping(value = "/freight")
public class NationalInboxController extends BaseController {
	
	@Autowired
	private NationalInboxService nationalInboxService;
	
	@RequestMapping(value ="/getTickets.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getTickets(String bukrs,
										 HttpSession session,
										 HttpServletRequest request,
										 HttpServletResponse responseServlet
			) {
		
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		if(bukrs == null || bukrs.length() <= 0)
			return getModelMapError("Error - No bukrs selected");
		
		if(user != null) {
			try {
				Z_FI_GET_TICKETSResponse response = nationalInboxService.getTickets(user.getI_LIFNR(),bukrs);
				if(response != null) {
					if("S".equals(response.getEV_TYPE().toString().toUpperCase())) {
						List<TicketDto> dtos = new ArrayList<TicketDto>();
						final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						ZFIST_TICKETS_FLE[] tickets = response.getET_TICKETS().getItem();
						if(tickets != null && tickets.length > 0) {
							for(ZFIST_TICKETS_FLE ticket : tickets) {
								Date fecha = (Date) ticket.getFECHA().getObject();
								final TicketDto dto = new TicketDto(sdf.format(fecha),
															  ticket.getTICKET().toString(),
															  ticket.getLIFNR().toString());
								dtos.add(dto);
							}
							return getResponseMap(dtos);
						} else {
							return getResponseMap(dtos);
						}
					} else {
						return getModelMapError("Error getting tickets:" + response.getEV_MESSAGE());
					}
				} else {
					return getModelMapError("Error getting response");
				}
			} catch (Exception e) {
				e.printStackTrace();
				return getModelMapError("Error exception || " + e.getMessage());
			}
		} else {
			return getModelMapError("Error de sesión, consulte al administrador");
		}
	}

	@RequestMapping(value = "/getServiceTypes.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getServiceTypes(HttpSession session,
											  String type,
											  HttpServletRequest request
			) {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		
		if(user == null) {
			return getModelMapError("Error de sesión");
		}
		
		try {
			Z_FI_GET_TIPO_SERVICIOResponse response = nationalInboxService.getServiceType(type, locale.getLanguage().toUpperCase());
			if(response == null)
				return getModelMapError("No response");
			if(!"S".equals(response.getEV_TYPE().toString().toUpperCase())) 
				return getModelMapError("Error" + response.getEV_MESSAGE());
			List<ServiceType> services = new ArrayList<ServiceType>();
			ZFIST_TIPO_SERVICIO_FLE[] values = response.getET_TIPO_SERVICIO().getItem();
			if(values == null || values.length == 0)
				return getResponseMap(services);
			for(ZFIST_TIPO_SERVICIO_FLE value: values) {
				ServiceType serviceType = new ServiceType(value.getTRANS().toString(), 
														 value.getCLAVE().toString(),
														 value.getSPRAS().toString(),
														 value.getTEXTO().toString());
				services.add(serviceType);
			}
			return getResponseMap(services);
		} catch (Exception e) {
			e.printStackTrace();
			return getModelMapError("Errorr getting types" + e.getMessage());
		}
	}
	
	@RequestMapping(value="/getUnidadTipo.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getUnidadTipo(String type,
											HttpSession session,
											HttpServletRequest request
			) {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		
		if(user == null)
			return getModelMapError("Error de sesión");
		
		try {
			Z_FI_GET_UNIDAD_TIPOResponse response = nationalInboxService.getUnidadTipo(type, locale.getLanguage());
			if(response == null)
				return getModelMapError("No response");
			if(!"S".equals(response.getEV_TYPE().toString().toUpperCase())) 
				return getModelMapError("Error" + response.getEV_MESSAGE());
			ZFIST_UNIDAD_TIPO_FLE[] values = response.getET_UNIDAD_TIPO().getItem();
			List<UnidadTipoDto> unidades = new ArrayList<UnidadTipoDto>();
			if(values == null || values.length == 0)
				return getResponseMap(unidades);
			for(ZFIST_UNIDAD_TIPO_FLE unidad : values) {
				final UnidadTipoDto dto = new UnidadTipoDto(unidad.getTRANS().toString(), 
														   unidad.getCLAVE().toString(),
														   unidad.getTEXTO().toString());
				unidades.add(dto);
			}
			return getResponseMap(unidades);
		} catch (Exception e) {
			e.printStackTrace();
			return getModelMapError("Error getting units:" + e.getMessage());
		}
	}
	
	@RequestMapping(value = "/getRefer.action", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getRefer(String type,HttpServletRequest request, HttpSession session) {
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		
		if(user == null)
			return getModelMapError("Error de sesión");
		
		try {
			Z_FI_GET_REFER_EMBARResponse response = nationalInboxService.getRefer(type, locale.getLanguage());
			if(response == null)
				return getModelMapError("No response");
			if(!"S".equals(response.getEV_TYPE().toString().toUpperCase())) 
				return getModelMapError("Error" + response.getEV_MESSAGE());
			ZFIST_REFER_EMBAR_FLE[] values = response.getET_REFER_EMBAR().getItem();
			List<UnidadTipoDto> dtos = new ArrayList<UnidadTipoDto>();
			if(values == null || values.length == 0)
				return getResponseMap(dtos);
			for(ZFIST_REFER_EMBAR_FLE value : values) {
				UnidadTipoDto dto = new UnidadTipoDto(value.getTRANS().toString(),
													 value.getCLAVE().toString(),
													 value.getTEXTO().toString());
				dtos.add(dto);
			}
			return getResponseMap(dtos);
		} catch (Exception e) {
			e.printStackTrace();
			return getModelMapError("Error getting refer:" + e.getMessage());
		}
	}
	
	@RequestMapping(value = "/saveFreight.action", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveFreight(FreightDto dto,
										  HttpSession session,
										  HttpServletRequest request,
										  HttpServletResponse responseServlet
			) {
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper(responseServlet);
		wrapper.setContentType("text/html;charset=UTF-8");
		UserDto user = (UserDto) session.getAttribute("UserDetails");
		Locale locale = RequestContextUtils.getLocale(request);
		System.out.println(dto.toString());
		if(user == null)
			return getModelMapError("Error de sesión");
		try {
			if(!Util.isJSONValid(dto.getTickets()) && "1".equals(dto.getTipoFac())) {
				wrapper.getWriter().write("{success:false,msg:'"+ locale.getLanguage().toUpperCase() == "ES" ? 
								"Se necesita al menus un ticket" : "Ticket was not selected"  +"'}");
				return null;
			}
			Z_FI_AGREGAR_BUZON_FLETESResponse response = nationalInboxService.saveFreight(dto, user.getI_LIFNR(), locale.getLanguage().toUpperCase());
			if(response == null) {
				wrapper.getWriter().write("{success:false,msg:'No Response'}");
				return null;
			}
			if(!"S".equals(response.getEV_TYPE().toString().toUpperCase())) {
				wrapper.getWriter().write("{success:false,msg:'"+response.getEV_MESSAGE().toString().replace("'", "\"") +"'}");
				return null;
			}
			wrapper.getWriter().write("{success:true,msg:'"+response.getEV_MESSAGE().toString().replace("'", "\"") +"'}");
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				wrapper.getWriter().write("{success:false,msg:'"+e.getMessage()+"'}");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return null;
		}
	}
	
}
