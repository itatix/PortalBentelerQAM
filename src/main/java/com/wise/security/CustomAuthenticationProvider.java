package com.wise.security;

import java.util.ArrayList;
import java.util.List;








import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import com.wise.Constants;

import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_LOGIN_USUARIOServiceStub;
import functions.rfc.sap.document.sap_com.Char1;
import functions.rfc.sap.document.sap_com.Char10;
import functions.rfc.sap.document.sap_com.Char16;
import functions.rfc.sap.document.sap_com.I_FLAG_type1;
import functions.rfc.sap.document.sap_com.I_LIFNR_type1;
import functions.rfc.sap.document.sap_com.I_PWD_type1;
import functions.rfc.sap.document.sap_com.I_USER_type1;
import functions.rfc.sap.document.sap_com.ZWS_LOGIN_USUARIOStub;
import functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_USUARIO;
import functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_USUARIOResponse;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger LOGGER = LogManager.getLogger(CustomAuthenticationProvider.class);

	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	@Override
	public Authentication authenticate(Authentication authentication){
		
		CustomWebAuthenticationDetails details = (CustomWebAuthenticationDetails) authentication.getDetails();
		LOGGER.info("User IP address =" + details.getRemoteAddress());
		
		Z_FE_FM_LOGIN_USUARIOResponse response = details.getProvider() != null && details.getProvider().length() > 0 ? loadEmpFromWS(authentication, details) :loadFromWS(authentication);
		
		if(response == null) {
			throw new BadCredentialsException("Usuario inválido");
		} else {
			if(response.getE_TYPE().toString().equals("S")) {
				details.setIsExpired(response.getE_FLG_VPSW().toString().toUpperCase().equals("X"));
				details.setPasswordExpireOn(response.getE_FECHA_VIG().toString());
				
				List<GrantedAuthority> grantedAuths = new ArrayList();
				grantedAuths.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
				AbstractAuthenticationToken auth = new UsernamePasswordAuthenticationToken(response.getE_LIFNR().toString(), authentication.getCredentials(), grantedAuths);
				auth.setDetails(details);
				return auth;	
			}else {
				String msgError = response.getE_MSG().toString().length() > 0 ? response.getE_MSG().toString() : "";
				throw new AuthenticationCredentialsNotFoundException(msgError);
			}
		}						
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
	
	public Z_FE_FM_LOGIN_USUARIOResponse loadFromWS(Authentication authentication) {
		
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
	
	public Z_FE_FM_LOGIN_USUARIOResponse loadEmpFromWS(Authentication authentication, CustomWebAuthenticationDetails details) {
		
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
//			Char10 i_lifnr = new Char10();
			I_LIFNR_type1 i_lifnr = new I_LIFNR_type1();
			username.setI_USER_type0(authentication.getName());
			passwd.setI_PWD_type0((String)authentication.getCredentials());
			i_flag.setI_FLAG_type0("2");
			i_lifnr.setI_LIFNR_type0(details.getProvider());
			user.setI_USER(username);
			user.setI_PWD(passwd);
			user.setI_FLAG(i_flag);
			user.setI_LIFNR(i_lifnr);
			Z_FE_FM_LOGIN_USUARIOResponse response = stub.sI_ZWS_LOGIN_USUARIO(user);			
			return response;			
		} catch (Exception e) {
			LOGGER.error("ERROR AL AUTENTICAR ",e);
			return null;
		}
		
	}
	
}
