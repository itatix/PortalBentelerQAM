package com.wise;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.axis2.AxisFault;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.wise.model.NotificationDto;
import com.wise.service.ServiceRegistry;

import functions.rfc.sap.document.sap_com.E_LISTAPROV_type0;
import functions.rfc.sap.document.sap_com.E_LISTGENERAL_type0;
import functions.rfc.sap.document.sap_com.ZST_AVISO;
import functions.rfc.sap.document.sap_com.ZST_FECONFGPROV;
import functions.rfc.sap.document.sap_com.ZTT_AVISO;
import functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_AVISOSResponse;

public class Util {
	
	private static final Logger LOGGER = LogManager.getLogger(Util.class);
	
	public static boolean isJSONValid(String test) {
	    try {
	        new JSONObject(test);
	    } catch (JSONException ex) {
	        // e.g. in case JSONArray is valid as well...
	        try {
	            new JSONArray(test);
	        } catch (JSONException ex1) {
	            return false;
	        }
	    }
	    return true;
	}
	
	public static List<NotificationDto> getBannerNotifications(String lifnr, HttpServletRequest request) throws AxisFault, RemoteException {
		Locale locale = RequestContextUtils.getLocale(request);
		
		Z_FE_FM_OBTIENE_AVISOSResponse response = ServiceRegistry.getProviderService().getNotifications(lifnr, null, locale.getLanguage().toUpperCase(), "2");
		if(response.getE_TYPE().toString().toUpperCase().equals("E")) {
			LOGGER.info("No banner message: " + response.getE_MSG().toString());
			return null;
		}
		LOGGER.info("Banner message: " + response.getE_MSG().toString() + "---" + response.getE_LISTAPROV().getItem().length + "aviso(s)");
	    E_LISTAPROV_type0 tmp = response.getE_LISTAPROV();
	    
	    ZST_AVISO[] notifications = tmp.getItem();
	    List<NotificationDto> jsonResponse = new ArrayList<NotificationDto>();
	    if(notifications != null && notifications.length > 0) {	
	    	final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
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
	    		dto.setCuerpo(dto.getCuerpo().replaceAll("#", "<br/>"));
	    		jsonResponse.add(dto);
	    	}
	    }
	    E_LISTGENERAL_type0 tmp2 = response.getE_LISTGENERAL();	    
	    notifications = tmp2.getItem();
	    if(notifications != null && notifications.length > 0) {
	    	final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
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
	    		dto.setCuerpo(dto.getCuerpo().replaceAll("#", "<br/>"));
	    		jsonResponse.add(dto);
	    	}
	    }
	    LOGGER.info("List of notifications size:" + jsonResponse.size());
	    return jsonResponse;	
	}

}
