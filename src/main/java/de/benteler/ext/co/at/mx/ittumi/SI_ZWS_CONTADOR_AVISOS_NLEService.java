

/**
 * SI_ZWS_CONTADOR_AVISOS_NLEService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_CONTADOR_AVISOS_NLEService java interface
     */

    public interface SI_ZWS_CONTADOR_AVISOS_NLEService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FE_FM_CONTADOR_AVISOS_NLE0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FE_FM_CONTADOR_AVISOS_NLEResponse sI_ZWS_CONTADOR_AVISOS_NLE(

                        functions.rfc.sap.document.sap_com.Z_FE_FM_CONTADOR_AVISOS_NLE z_FE_FM_CONTADOR_AVISOS_NLE0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FE_FM_CONTADOR_AVISOS_NLE0
            
          */
        public void startsI_ZWS_CONTADOR_AVISOS_NLE(

            functions.rfc.sap.document.sap_com.Z_FE_FM_CONTADOR_AVISOS_NLE z_FE_FM_CONTADOR_AVISOS_NLE0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_CONTADOR_AVISOS_NLEServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    