

/**
 * SI_ZWS_LOGIN_USUARIOService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_LOGIN_USUARIOService java interface
     */

    public interface SI_ZWS_LOGIN_USUARIOService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FE_FM_LOGIN_USUARIO0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_USUARIOResponse sI_ZWS_LOGIN_USUARIO(

                        functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_USUARIO z_FE_FM_LOGIN_USUARIO0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FE_FM_LOGIN_USUARIO0
            
          */
        public void startsI_ZWS_LOGIN_USUARIO(

            functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_USUARIO z_FE_FM_LOGIN_USUARIO0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_LOGIN_USUARIOServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    