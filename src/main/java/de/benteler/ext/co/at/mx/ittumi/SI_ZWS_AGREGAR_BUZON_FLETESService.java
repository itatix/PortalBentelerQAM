

/**
 * SI_ZWS_AGREGAR_BUZON_FLETESService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_AGREGAR_BUZON_FLETESService java interface
     */

    public interface SI_ZWS_AGREGAR_BUZON_FLETESService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FI_AGREGAR_BUZON_FLETES0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FI_AGREGAR_BUZON_FLETESResponse sI_ZWS_AGREGAR_BUZON_FLETES(

                        functions.rfc.sap.document.sap_com.Z_FI_AGREGAR_BUZON_FLETES z_FI_AGREGAR_BUZON_FLETES0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FI_AGREGAR_BUZON_FLETES0
            
          */
        public void startsI_ZWS_AGREGAR_BUZON_FLETES(

            functions.rfc.sap.document.sap_com.Z_FI_AGREGAR_BUZON_FLETES z_FI_AGREGAR_BUZON_FLETES0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_AGREGAR_BUZON_FLETESServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    