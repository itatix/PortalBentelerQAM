package com.wise.security;

import org.apache.axis2.client.Options;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.transport.http.HttpTransportProperties;








import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_BORRAR_BUZONServiceStub;
import de.benteler.ext.co.at.mx.ittumi.SI_ZWS_LOGIN_USUARIOServiceStub;
import functions.rfc.sap.document.sap_com.Char16;
import functions.rfc.sap.document.sap_com.I_PWD_type1;
import functions.rfc.sap.document.sap_com.I_USER_type1;
import functions.rfc.sap.document.sap_com.ZWS_LOGIN_USUARIOStub;
import functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_USUARIO;
import functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_USUARIOResponse;

public class WSTest {
	
	public static void main(String[] args) throws Exception {
//		ZWS_LOGIN_USUARIOStub stub = new ZWS_LOGIN_USUARIOStub();
		SI_ZWS_LOGIN_USUARIOServiceStub stub = new SI_ZWS_LOGIN_USUARIOServiceStub();
		Options options = stub._getServiceClient().getOptions();
		HttpTransportProperties.Authenticator auth = new HttpTransportProperties.Authenticator();
		auth.setPreemptiveAuthentication(true);
		auth.setUsername("E_AMONDONEDO");
		auth.setPassword("amondonedom13");
		options.setProperty(HTTPConstants.AUTHENTICATE,auth);
		Z_FE_FM_LOGIN_USUARIO user = new Z_FE_FM_LOGIN_USUARIO();
//		Char16 username = new Char16();
		I_USER_type1 username = new I_USER_type1();
//		Char16 passwd = new Char16();
		I_PWD_type1 passwd = new I_PWD_type1();
		username.setI_USER_type0("10002");
		passwd.setI_PWD_type0("10001");
		user.setI_USER(username);
		user.setI_PWD(passwd);
		Z_FE_FM_LOGIN_USUARIOResponse response = stub.sI_ZWS_LOGIN_USUARIO(user);
		
		System.out.println("ResponseMSG: " + response.getE_MSG());
		System.out.println("ResponseLIFNR: " + response.getE_LIFNR());
		System.out.println("ResponseID: " + response.getE_ID());
		System.out.println("ResponseType: " + response.getE_TYPE());
	}

}
