

/**
 * SI_ZWS_ESTATUS_PORTALService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_ESTATUS_PORTALService java interface
     */

    public interface SI_ZWS_ESTATUS_PORTALService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FE_FM_ESTATUS_PORTAL0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FE_FM_ESTATUS_PORTALResponse sI_ZWS_ESTATUS_PORTAL(

                        functions.rfc.sap.document.sap_com.Z_FE_FM_ESTATUS_PORTAL z_FE_FM_ESTATUS_PORTAL0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FE_FM_ESTATUS_PORTAL0
            
          */
        public void startsI_ZWS_ESTATUS_PORTAL(

            functions.rfc.sap.document.sap_com.Z_FE_FM_ESTATUS_PORTAL z_FE_FM_ESTATUS_PORTAL0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_ESTATUS_PORTALServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    