

/**
 * SI_ZWS_AGREGAR_FAC_SIN_ORDERService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_AGREGAR_FAC_SIN_ORDERService java interface
     */

    public interface SI_ZWS_AGREGAR_FAC_SIN_ORDERService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FE_FM_AGREGAR_FAC_SIN_ORDER0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_SIN_ORDERResponse sI_ZWS_AGREGAR_FAC_SIN_ORDER(

                        functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_SIN_ORDER z_FE_FM_AGREGAR_FAC_SIN_ORDER0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FE_FM_AGREGAR_FAC_SIN_ORDER0
            
          */
        public void startsI_ZWS_AGREGAR_FAC_SIN_ORDER(

            functions.rfc.sap.document.sap_com.Z_FE_FM_AGREGAR_FAC_SIN_ORDER z_FE_FM_AGREGAR_FAC_SIN_ORDER0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_AGREGAR_FAC_SIN_ORDERServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    