

/**
 * SI_ZWS_OBTIENE_CONFIGService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_OBTIENE_CONFIGService java interface
     */

    public interface SI_ZWS_OBTIENE_CONFIGService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FE_FM_OBTIENE_CONFIG0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_CONFIGResponse sI_ZWS_OBTIENE_CONFIG(

                        functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_CONFIG z_FE_FM_OBTIENE_CONFIG0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FE_FM_OBTIENE_CONFIG0
            
          */
        public void startsI_ZWS_OBTIENE_CONFIG(

            functions.rfc.sap.document.sap_com.Z_FE_FM_OBTIENE_CONFIG z_FE_FM_OBTIENE_CONFIG0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_OBTIENE_CONFIGServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    