

/**
 * SI_ZWS_CONFIRMA_ESTADO_CUENTAService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_CONFIRMA_ESTADO_CUENTAService java interface
     */

    public interface SI_ZWS_CONFIRMA_ESTADO_CUENTAService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FE_FM_CONFIRMA_ESTADO_CUENTA0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FE_FM_CONFIRMA_ESTADO_CUENTAResponse sI_ZWS_CONFIRMA_ESTADO_CUENTA(

                        functions.rfc.sap.document.sap_com.Z_FE_FM_CONFIRMA_ESTADO_CUENTA z_FE_FM_CONFIRMA_ESTADO_CUENTA0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FE_FM_CONFIRMA_ESTADO_CUENTA0
            
          */
        public void startsI_ZWS_CONFIRMA_ESTADO_CUENTA(

            functions.rfc.sap.document.sap_com.Z_FE_FM_CONFIRMA_ESTADO_CUENTA z_FE_FM_CONFIRMA_ESTADO_CUENTA0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_CONFIRMA_ESTADO_CUENTAServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    