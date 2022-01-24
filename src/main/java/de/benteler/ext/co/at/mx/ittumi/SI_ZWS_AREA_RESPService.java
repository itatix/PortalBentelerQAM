

/**
 * SI_ZWS_AREA_RESPService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_AREA_RESPService java interface
     */

    public interface SI_ZWS_AREA_RESPService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FE_FM_AREA_RESP0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FE_FM_AREA_RESPResponse sI_ZWS_AREA_RESP(

                        functions.rfc.sap.document.sap_com.Z_FE_FM_AREA_RESP z_FE_FM_AREA_RESP0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FE_FM_AREA_RESP0
            
          */
        public void startsI_ZWS_AREA_RESP(

            functions.rfc.sap.document.sap_com.Z_FE_FM_AREA_RESP z_FE_FM_AREA_RESP0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_AREA_RESPServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    