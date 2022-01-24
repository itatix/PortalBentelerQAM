

/**
 * SI_ZWS_LISTA_FACService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_LISTA_FACService java interface
     */

    public interface SI_ZWS_LISTA_FACService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FE_FM_LISTA_FAC0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FE_FM_LISTA_FACResponse sI_ZWS_LISTA_FAC(

                        functions.rfc.sap.document.sap_com.Z_FE_FM_LISTA_FAC z_FE_FM_LISTA_FAC0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FE_FM_LISTA_FAC0
            
          */
        public void startsI_ZWS_LISTA_FAC(

            functions.rfc.sap.document.sap_com.Z_FE_FM_LISTA_FAC z_FE_FM_LISTA_FAC0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_LISTA_FACServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    