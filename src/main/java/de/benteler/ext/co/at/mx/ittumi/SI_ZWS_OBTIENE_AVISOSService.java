

/**
 * SI_ZWS_OBTIENE_AVISOSService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_OBTIENE_AVISOSService java interface
     */

    public interface SI_ZWS_OBTIENE_AVISOSService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FE_FM_OBTIENE_AVISOS0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_AVISOSResponse sI_ZWS_OBTIENE_AVISOS(

                        functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_AVISOS z_FE_FM_OBTIENE_AVISOS0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FE_FM_OBTIENE_AVISOS0
            
          */
        public void startsI_ZWS_OBTIENE_AVISOS(

            functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_AVISOS z_FE_FM_OBTIENE_AVISOS0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_OBTIENE_AVISOSServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    