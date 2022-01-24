package com.wise.dao;

import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Repository;

import com.wise.Constants;

import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_LOGIN_USUARIOServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_OBTIENE_CONFIGServiceStub;
import functions.rfc.sap.document.sap_com.Char1;
import functions.rfc.sap.document.sap_com.Char10;
import functions.rfc.sap.document.sap_com.Char16;
import functions.rfc.sap.document.sap_com.I_FLAG_type1;
import functions.rfc.sap.document.sap_com.I_LIFNR_type1;
import functions.rfc.sap.document.sap_com.I_PWD_type1;
import functions.rfc.sap.document.sap_com.I_USER_type1;
import functions.rfc.sap.document.sap_com.ZWS_LOGIN_USUARIOStub;
import functions.rfc.sap.document.sap_com.ZWS_OBTIENE_CONFIGStub;
import functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_USUARIO;
import functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_USUARIOResponse;
import functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_CONFIG;
import functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_CONFIGResponse;

@Repository
public class UserDao {
	
	public final static Logger LOGGER = LogManager.getLogger(UserDao.class);
	
	public Z_FE_FM_LOGIN_USUARIOResponse findUserFromWS(Authentication authentication) {
		try {
//			ZWS_LOGIN_USUARIOStub stub = new ZWS_LOGIN_USUARIOStub();
			SI_ZWS_LOGIN_USUARIOServiceStub stub = new SI_ZWS_LOGIN_USUARIOServiceStub();
			Options options = stub._getServiceClient().getOptions();
			HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
			auth.setPreemptiveAuthentication(true);
			auth.setUsername(Constants.WISE_WSDL_USER);
			auth.setPassword(Constants.WISE_WSDL_PASS);
			options.setProperty(HTTPConstants.AUTHENTICATE,auth);
			Z_FE_FM_LOGIN_USUARIO user = new Z_FE_FM_LOGIN_USUARIO();
//			Char16 username = new Char16();
			I_USER_type1 username = new I_USER_type1();
//			Char16 passwd = new Char16();
			I_PWD_type1 passwd = new I_PWD_type1();
//			Char1 i_flag = new Char1();
			I_FLAG_type1 i_flag = new I_FLAG_type1();
			username.setI_USER_type0(authentication.getName());
			passwd.setI_PWD_type0((String)authentication.getCredentials());
			i_flag.setI_FLAG_type0("1");
			user.setI_USER(username);
			user.setI_PWD(passwd);
			user.setI_FLAG(i_flag);
			Z_FE_FM_LOGIN_USUARIOResponse response = stub.sI_ZWS_LOGIN_USUARIO(user);
			
			return response;
			
		} catch (Exception e) {
			LOGGER.error("ERROR AL AUTENTICAR ",e);
			return null;
		}
		
	}

	public Z_FE_FM_OBTIENE_CONFIGResponse findMenuConfig(String lifnr) {
		try {
//			ZWS_OBTIENE_CONFIGStub stub = new ZWS_OBTIENE_CONFIGStub();
			SI_ZWS_OBTIENE_CONFIGServiceStub stub = new SI_ZWS_OBTIENE_CONFIGServiceStub();
			Options options = stub._getServiceClient().getOptions();
			HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
			auth.setPreemptiveAuthentication(true);
			auth.setUsername(Constants.WISE_WSDL_USER);
			auth.setPassword(Constants.WISE_WSDL_PASS);
			options.setProperty(HTTPConstants.AUTHENTICATE,auth);
			Z_FE_FM_OBTIENE_CONFIG config = new Z_FE_FM_OBTIENE_CONFIG();
//			Char10 i_lifnr = new Char10();
			I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
			i_lifnr.setI_LIFNR_type0(lifnr);
			
			config.setI_LIFNR(i_lifnr);
			Z_FE_FM_OBTIENE_CONFIGResponse response = stub.sI_ZWS_OBTIENE_CONFIG(config);
			
			return response;
		} catch (Exception e) {
			LOGGER.error("ERROR getting OBTIENE CONFIG",e);
			return null;
		}
	}
}
