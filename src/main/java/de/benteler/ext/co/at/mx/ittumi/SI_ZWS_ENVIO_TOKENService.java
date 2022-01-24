

/**
 * SI_ZWS_ENVIO_TOKENService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_ENVIO_TOKENService java interface
     */

    public interface SI_ZWS_ENVIO_TOKENService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FE_FM_ENVIO_TOKEN0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FE_FM_ENVIO_TOKENResponse sI_ZWS_ENVIO_TOKEN(

                        functions.rfc.sap.document.sap_com.Z_FE_FM_ENVIO_TOKEN z_FE_FM_ENVIO_TOKEN0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FE_FM_ENVIO_TOKEN0
            
          */
        public void startsI_ZWS_ENVIO_TOKEN(

            functions.rfc.sap.document.sap_com.Z_FE_FM_ENVIO_TOKEN z_FE_FM_ENVIO_TOKEN0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_ENVIO_TOKENServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    