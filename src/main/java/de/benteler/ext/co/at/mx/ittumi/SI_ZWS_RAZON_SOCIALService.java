

/**
 * SI_ZWS_RAZON_SOCIALService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_RAZON_SOCIALService java interface
     */

    public interface SI_ZWS_RAZON_SOCIALService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FE_FM_RAZON_SOCIAL0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FE_FM_RAZON_SOCIALResponse sI_ZWS_RAZON_SOCIAL(

                        functions.rfc.sap.document.sap_com.Z_FE_FM_RAZON_SOCIAL z_FE_FM_RAZON_SOCIAL0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FE_FM_RAZON_SOCIAL0
            
          */
        public void startsI_ZWS_RAZON_SOCIAL(

            functions.rfc.sap.document.sap_com.Z_FE_FM_RAZON_SOCIAL z_FE_FM_RAZON_SOCIAL0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_RAZON_SOCIALServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    