

/**
 * SI_ZWS_CAMBIO_PSWD_PROVService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_CAMBIO_PSWD_PROVService java interface
     */

    public interface SI_ZWS_CAMBIO_PSWD_PROVService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FE_FM_CAMBIO_PSWD_PROV0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FE_FM_CAMBIO_PSWD_PROVResponse sI_ZWS_CAMBIO_PSWD_PROV(

                        functions.rfc.sap.document.sap_com.Z_FE_FM_CAMBIO_PSWD_PROV z_FE_FM_CAMBIO_PSWD_PROV0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FE_FM_CAMBIO_PSWD_PROV0
            
          */
        public void startsI_ZWS_CAMBIO_PSWD_PROV(

            functions.rfc.sap.document.sap_com.Z_FE_FM_CAMBIO_PSWD_PROV z_FE_FM_CAMBIO_PSWD_PROV0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_CAMBIO_PSWD_PROVServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    