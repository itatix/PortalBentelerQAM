

/**
 * ZWS_ENVIO_TOKEN.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package functions.rfc.sap.document.sap_com;

    /*
     *  ZWS_ENVIO_TOKEN java interface
     */

    public interface ZWS_ENVIO_TOKEN {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FE_FM_ENVIO_TOKEN0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FE_FM_ENVIO_TOKENResponse z_FE_FM_ENVIO_TOKEN(

                        functions.rfc.sap.document.sap_com.Z_FE_FM_ENVIO_TOKEN z_FE_FM_ENVIO_TOKEN0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FE_FM_ENVIO_TOKEN0
            
          */
        public void startz_FE_FM_ENVIO_TOKEN(

            functions.rfc.sap.document.sap_com.Z_FE_FM_ENVIO_TOKEN z_FE_FM_ENVIO_TOKEN0,

            final functions.rfc.sap.document.sap_com.ZWS_ENVIO_TOKENCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    