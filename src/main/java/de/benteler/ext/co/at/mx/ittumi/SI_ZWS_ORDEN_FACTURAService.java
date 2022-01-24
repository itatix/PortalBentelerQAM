

/**
 * SI_ZWS_ORDEN_FACTURAService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_ORDEN_FACTURAService java interface
     */

    public interface SI_ZWS_ORDEN_FACTURAService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FE_FM_ORDEN_FACTURA0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FE_FM_ORDEN_FACTURAResponse sI_ZWS_ORDEN_FACTURA(

                        functions.rfc.sap.document.sap_com.Z_FE_FM_ORDEN_FACTURA z_FE_FM_ORDEN_FACTURA0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FE_FM_ORDEN_FACTURA0
            
          */
        public void startsI_ZWS_ORDEN_FACTURA(

            functions.rfc.sap.document.sap_com.Z_FE_FM_ORDEN_FACTURA z_FE_FM_ORDEN_FACTURA0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_ORDEN_FACTURAServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    