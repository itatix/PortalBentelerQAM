package com.wise.controller;

import java.math.BigInteger;
import java.rmi.RemoteException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.axis2.AxisFault;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wise.model.MenusDto;
import com.wise.model.UserDto;
import com.wise.security.CustomWebAuthenticationDetails;
import com.wise.service.ProviderService;
import com.wise.service.UserService;

import functions.rfc.sap.document.sap_com.E_LISTAPROV_type0;
import functions.rfc.sap.document.sap_com.E_LISTAPROV_type1;
import functions.rfc.sap.document.sap_com.E_LISTGENERAL_type0;
import functions.rfc.sap.document.sap_com.E_LISTGENERAL_type1;
import functions.rfc.sap.document.sap_com.ZST_FECONFGPROV;
import functions.rfc.sap.document.sap_com.ZTT_FECONFGPROV;
import functions.rfc.sap.document.sap_com.Z_FE_FM_CONTADOR_AVISOS_NLEResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_DATOS_PROVEEDORResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_USUARIOResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_CONFIGResponse;

@Controller
public class LoginController {
	
	private static final Logger LOGGER = LogManager.getLogger(LoginController.class);
	
	@Autowired
	private ProviderService providerService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/Login", method = RequestMethod.GET)
    public String login(ModelMap model, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		Enumeration<String> atttributes = request.getAttributeNames();
		return "login";
    }
	
	@RequestMapping(value="/LoginEmp", method = RequestMethod.GET)
    public String loginEmp(ModelMap model, HttpServletRequest request, HttpServletResponse response) {			
		return "loginEmp";
    }
	
	@RequestMapping(value="/Login", method = RequestMethod.GET, params = "error")
    public String loginError(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("error","true");
		return "login";
    }
	
	@RequestMapping(value="/Inicio", method = RequestMethod.GET)
	public String inicio(HttpSession session){
		UserDto userDTO = new UserDto();
		MenusDto menusDto = new MenusDto();
		 
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		userDTO.setUsername(auth.getName());
		 try {
//			Z_FE_FM_LOGIN_USUARIOResponse loginUsuario =  userService.getUserFromWS(auth);
			Z_FE_FM_DATOS_PROVEEDORResponse response = providerService.getProvider(userDTO.getUsername());
			CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) auth.getDetails();
			Z_FE_FM_OBTIENE_CONFIGResponse configResponse = userService.getMenuConfig(userDTO.getUsername());
			E_LISTGENERAL_type1 listGeneral = configResponse.getE_LISTGENERAL();
			E_LISTAPROV_type1 listAprov = configResponse.getE_LISTAPROV();
			userDTO.setRfc(response.getE_RFC().toString());
			userDTO.setProviderName(response.getE_NAME1() + " " + response.getE_NAME2() + " " + response.getE_NAME3() + " " + response.getE_NAME4());
			userDTO.setI_LIFNR(userDTO.getUsername());
			userDTO.seteLand(response.getE_LAND1() == null ? "" : response.getE_LAND1().toString());
			ZST_FECONFGPROV[] itemTmp = listAprov.getItem();
			if(itemTmp == null) {
				ZST_FECONFGPROV[] item = listGeneral.getItem();
				menusDto.setListFac("X".equals(item[0].getFLAG_LIST_FAC().toString().toUpperCase()) ? true : false);
				menusDto.setOcCFDIC("X".equals(item[0].getFLG_C_OC_CFDI_C().toString().toUpperCase()) ? true : false);
				menusDto.setOcCFDIV("X".equals(item[0].getFLG_C_OC_CFDI_V().toString().toUpperCase()) ? true : false);
				menusDto.setOcCFDIVP("X".equals(item[0].getFLG_C_OC_CFDI_VP().toString().toUpperCase()) ? true : false);
				menusDto.setOcCBBC("X".equals(item[0].getFLG_C_OC_CBB_C().toString().toUpperCase()) ? true: false);
				menusDto.setOcCBBV("X".equals(item[0].getFLG_C_OC_CBB_V().toString().toUpperCase()) ? true: false);
				menusDto.setOcCBBVP("X".equals(item[0].getFLG_C_OC_CBB_VP().toString().toUpperCase()) ? true : false);
				menusDto.setSocCBB("X".equals(item[0].getFLG_S_OC_CBB().toString().toUpperCase()) ? true : false);
				menusDto.setSocCFDI("X".equals(item[0].getFLG_S_OC_CFDI().toString().toUpperCase()) ? true : false);
				menusDto.setEstatusRecepcion("X".equals(item[0].getFLG_ESTATUS_RE().toString().toUpperCase()) ? true : false);
				menusDto.setListaOC("X".equals(item[0].getFLG_LISTA_OC().toString().toUpperCase()) ? true : false);
//				menusDto.setBuzonAgregar("X".equals(item[0].getFLG_BZ_AGR().toString().toUpperCase()) ? true : false);
				menusDto.setBuzonConsultar("X".equals(item[0].getFLG_BZ_CON().toString().toUpperCase()) ? true : false);
				menusDto.setEstadoCuenta("X".equals(item[0].getFLG_ESTADO_CTA().toString().toUpperCase()) ? true : false);
				menusDto.setDivision("X".equals(item[0].getFLG_LISTA_DIV().toString().toUpperCase()) ? true : false);
				menusDto.setPassword("X".equals(item[0].getFLG_PASSWORD().toString().toUpperCase()) ? true : false);
				menusDto.setAvisos("X".equals(item[0].getFLG_AVISOS().toString().toUpperCase()) ? true : false);
				menusDto.setOcCFDICI("X".equals(item[0].getFLG_C_OC_CICFDI().toString().toUpperCase()) ? true : false);
				menusDto.setOcCBBCI("X".equals(item[0].getFLG_C_OC_CISCFDI().toString().toUpperCase()) ? true : false);
				menusDto.setOpdf("X".equals(item[0].getFLG_OPDF().toString().toUpperCase()) ? true : false);
				menusDto.setBuzonAgregarCFDI("X".equals(item[0].getFLG_BZ_AGR_C_CFI().toString().toUpperCase()) ? true : false);
				menusDto.setBuzonAgregarSCFDI("X".equals(item[0].getFLG_BZ_AGR_S_CFI().toString().toUpperCase()) ? true : false);
				if(item[0].getFLG_CONSIGNA() != null)
					menusDto.setConsignacion("X".equals(item[0].getFLG_CONSIGNA().toString().toUpperCase()) ? true: false);
				else
					menusDto.setConsignacion(false);
				menusDto.setSocCFDIAgencias("X".equals(item[0].getFLG_CCFDI_AV().toString().toUpperCase()) ? true: false);
				menusDto.setSocCBBAgencias("X".equals(item[0].getFLG_SCFDI_AV().toString().toUpperCase()) ? true : false);
				menusDto.setSocCFDIFletes("X".equals(item[0].getFLG_CCFDI_FLE().toString().toUpperCase()) ? true : false);
				menusDto.setSocCBBFletes("X".equals(item[0].getFLG_SCFDI_FLE().toString().toUpperCase()) ? true: false);
			} else {
				ZST_FECONFGPROV[] item = listAprov.getItem();
				menusDto.setListFac("X".equals(item[0].getFLAG_LIST_FAC().toString().toUpperCase()) ? true : false);
				menusDto.setOcCFDIC("X".equals(item[0].getFLG_C_OC_CFDI_C().toString().toUpperCase()) ? true : false);
				menusDto.setOcCFDIV("X".equals(item[0].getFLG_C_OC_CFDI_V().toString().toUpperCase()) ? true : false);
				menusDto.setOcCFDIVP("X".equals(item[0].getFLG_C_OC_CFDI_VP().toString().toUpperCase()) ? true : false);
				menusDto.setOcCBBC("X".equals(item[0].getFLG_C_OC_CBB_C().toString().toUpperCase()) ? true: false);
				menusDto.setOcCBBV("X".equals(item[0].getFLG_C_OC_CBB_V().toString().toUpperCase()) ? true: false);
				menusDto.setOcCBBVP("X".equals(item[0].getFLG_C_OC_CBB_VP().toString().toUpperCase()) ? true : false);
				menusDto.setSocCBB("X".equals(item[0].getFLG_S_OC_CBB().toString().toUpperCase()) ? true : false);
				menusDto.setSocCFDI("X".equals(item[0].getFLG_S_OC_CFDI().toString().toUpperCase()) ? true : false);
				menusDto.setEstatusRecepcion("X".equals(item[0].getFLG_ESTATUS_RE().toString().toUpperCase()) ? true : false);
				menusDto.setListaOC("X".equals(item[0].getFLG_LISTA_OC().toString().toUpperCase()) ? true : false);
//				menusDto.setBuzonAgregar("X".equals(item[0].getFLG_BZ_AGR().toString().toUpperCase()) ? true : false);
				menusDto.setBuzonConsultar("X".equals(item[0].getFLG_BZ_CON().toString().toUpperCase()) ? true : false);
				menusDto.setEstadoCuenta("X".equals(item[0].getFLG_ESTADO_CTA().toString().toUpperCase()) ? true : false);
				menusDto.setDivision("X".equals(item[0].getFLG_LISTA_DIV().toString().toUpperCase()) ? true : false);
				menusDto.setPassword("X".equals(item[0].getFLG_PASSWORD().toString().toUpperCase()) ? true : false);
				menusDto.setAvisos("X".equals(item[0].getFLG_AVISOS().toString().toUpperCase()) ? true : false);
				menusDto.setOcCFDICI("X".equals(item[0].getFLG_C_OC_CICFDI().toString().toUpperCase()) ? true : false);
				menusDto.setOcCBBCI("X".equals(item[0].getFLG_C_OC_CISCFDI().toString().toUpperCase()) ? true : false);
				menusDto.setOpdf("X".equals(item[0].getFLG_OPDF().toString().toUpperCase()) ? true : false);
				menusDto.setBuzonAgregarCFDI("X".equals(item[0].getFLG_BZ_AGR_C_CFI().toString().toUpperCase()) ? true : false);
				menusDto.setBuzonAgregarSCFDI("X".equals(item[0].getFLG_BZ_AGR_S_CFI().toString().toUpperCase()) ? true : false);
				if(item[0].getFLG_CONSIGNA() != null)
					menusDto.setConsignacion("X".equals(item[0].getFLG_CONSIGNA().toString().toUpperCase()) ? true: false);
				else
					menusDto.setConsignacion(false);
				menusDto.setSocCFDIAgencias("X".equals(item[0].getFLG_CCFDI_AV().toString().toUpperCase()) ? true: false);
				menusDto.setSocCBBAgencias("X".equals(item[0].getFLG_SCFDI_AV().toString().toUpperCase()) ? true : false);
				menusDto.setSocCFDIFletes("X".equals(item[0].getFLG_CCFDI_FLE().toString().toUpperCase()) ? true : false);
				menusDto.setSocCBBFletes("X".equals(item[0].getFLG_SCFDI_FLE().toString().toUpperCase()) ? true: false);
			}			
			Z_FE_FM_CONTADOR_AVISOS_NLEResponse res = providerService.getUnreadNotificationsNumber(userDTO.getI_LIFNR());
			BigInteger counter = new BigInteger("0");
			if(!res.getE_TYPE().toString().toUpperCase().equals("E"))
				counter = res.getE_VALOR();	
			session.setAttribute("UserDetails", userDTO);
			session.setAttribute("expired", details.getIsExpired());
			session.setAttribute("menusDto", menusDto);
			session.setAttribute("unreadNotifications", counter.intValue());
		} catch (AxisFault e) {
			LOGGER.error("Error datos proveedor",e);
		} catch (RemoteException e) {
			LOGGER.error("Error datos proveedor",e);
		}
		return menusDto.getListaOC() ? "OCSinFacturar" : "inicio";
	}
}
