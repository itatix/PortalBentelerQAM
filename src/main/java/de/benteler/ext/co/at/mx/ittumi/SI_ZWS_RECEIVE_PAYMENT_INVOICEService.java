

/**
 * SI_ZWS_RECEIVE_PAYMENT_INVOICEService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package de.benteler.ext.co.at.mx.ittumi;

    /*
     *  SI_ZWS_RECEIVE_PAYMENT_INVOICEService java interface
     */

    public interface SI_ZWS_RECEIVE_PAYMENT_INVOICEService {
          

        /**
          * Auto generated method signature
          * 
                    * @param z_FI_RECEIVE_PAYMENT_INVOICE0
                
         */

         
                     public functions.rfc.sap.document.sap_com.Z_FI_RECEIVE_PAYMENT_INVOICEResponse sI_ZWS_RECEIVE_PAYMENT_INVOICE(

                        functions.rfc.sap.document.sap_com.Z_FI_RECEIVE_PAYMENT_INVOICE z_FI_RECEIVE_PAYMENT_INVOICE0)
                        throws java.rmi.RemoteException
             ;

        
         /**
            * Auto generated method signature for Asynchronous Invocations
            * 
                * @param z_FI_RECEIVE_PAYMENT_INVOICE0
            
          */
        public void startsI_ZWS_RECEIVE_PAYMENT_INVOICE(

            functions.rfc.sap.document.sap_com.Z_FI_RECEIVE_PAYMENT_INVOICE z_FI_RECEIVE_PAYMENT_INVOICE0,

            final de.benteler.ext.co.at.mx.ittumi.SI_ZWS_RECEIVE_PAYMENT_INVOICEServiceCallbackHandler callback)

            throws java.rmi.RemoteException;

     

        
       //
       }
    