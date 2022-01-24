

/**
 * SI_ZWS_BORRAR_BUZONService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_BORRAR_BUZONService java interface
     */

    public interface SI_ZWS_BORRAR_BUZONService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FE_FM_BORRAR_BUZON0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FE_FM_BORRAR_BUZONResponse sI_ZWS_BORRAR_BUZON(

                        functions.rfc.sap.document.sap_com.Z_FE_FM_BORRAR_BUZON z_FE_FM_BORRAR_BUZON0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FE_FM_BORRAR_BUZON0
            
          */
        public void startsI_ZWS_BORRAR_BUZON(

            functions.rfc.sap.document.sap_com.Z_FE_FM_BORRAR_BUZON z_FE_FM_BORRAR_BUZON0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_BORRAR_BUZONServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    