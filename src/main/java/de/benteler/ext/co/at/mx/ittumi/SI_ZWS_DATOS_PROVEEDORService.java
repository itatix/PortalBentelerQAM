

/**
 * SI_ZWS_DATOS_PROVEEDORService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_DATOS_PROVEEDORService java interface
     */

    public interface SI_ZWS_DATOS_PROVEEDORService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FE_FM_DATOS_PROVEEDOR0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FE_FM_DATOS_PROVEEDORResponse sI_ZWS_DATOS_PROVEEDOR(

                        functions.rfc.sap.document.sap_com.Z_FE_FM_DATOS_PROVEEDOR z_FE_FM_DATOS_PROVEEDOR0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FE_FM_DATOS_PROVEEDOR0
            
          */
        public void startsI_ZWS_DATOS_PROVEEDOR(

            functions.rfc.sap.document.sap_com.Z_FE_FM_DATOS_PROVEEDOR z_FE_FM_DATOS_PROVEEDOR0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_DATOS_PROVEEDORServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    