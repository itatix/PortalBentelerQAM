
/**
 * ZWS_LOGIN_EMPLStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */
        package functions.rfc.sap.document.sap_com;

        

        /*
        *  ZWS_LOGIN_EMPLStub java implementation
        */

        
        public class ZWS_LOGIN_EMPLStub extends org.apache.axis2.client.Stub
        implements ZWS_LOGIN_EMPL{
        protected org.apache.axis2.description.AxisOperation[] _operations;

        //hashmaps to keep the fault mapping
        private java.util.HashMap faultExceptionNameMap = new java.util.HashMap();
        private java.util.HashMap faultExceptionClassNameMap = new java.util.HashMap();
        private java.util.HashMap faultMessageMap = new java.util.HashMap();

        private static int counter = 0;

        private static synchronized java.lang.String getUniqueSuffix(){
            // reset the counter if it is greater than 99999
            if (counter > 99999){
                counter = 0;
            }
            counter = counter + 1; 
            return java.lang.Long.toString(java.lang.System.currentTimeMillis()) + "_" + counter;
        }

    
    private void populateAxisService() throws org.apache.axis2.AxisFault {

     //creating the Service with a unique name
     _service = new org.apache.axis2.description.AxisService("ZWS_LOGIN_EMPL" + getUniqueSuffix());
     addAnonymousOperations();

        //creating the operations
        org.apache.axis2.description.AxisOperation __operation;

        _operations = new org.apache.axis2.description.AxisOperation[1];
        
                   __operation = new org.apache.axis2.description.OutInAxisOperation();
                

            __operation.setName(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions", "z_FE_FM_LOGIN_EMPL"));
	    _service.addOperation(__operation);
	    

	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_OUT_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"ef7083fdbfbb05987b790ff8c8cb9d8bbd4d3932f1b84877\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><saptrnbnd:OptimizedXMLTransfer wsp:Optional=\"true\" xmlns:saptrnbnd=\"http://www.sap.com/webas/710/soap/features/transportbinding/\" uri=\"http://xml.sap.com/2006/11/esi/esp/binxml\"></saptrnbnd:OptimizedXMLTransfer><saptrnbnd:OptimizedMimeSerialization wsp:Optional=\"true\" xmlns:saptrnbnd=\"http://schemas.xmlsoap.org/ws/2004/09/policy/optimizedmimeserialization\"></saptrnbnd:OptimizedMimeSerialization><sp:TransportBinding xmlns:sp=\"http://docs.oasis-open.org/ws-sx/ws-securitypolicy/200702\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpBasicAuthentication/></wsp:Policy></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic128Rsa15/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding><wsaw:UsingAddressing wsp:Optional=\"true\" xmlns:wsaw=\"http://www.w3.org/2006/05/addressing/wsdl\"></wsaw:UsingAddressing></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    (__operation).getMessage(org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE).getPolicySubject().attachPolicy(getPolicy("<wsp:Policy wsu:Id=\"ef7083fdbfbb05987b790ff8c8cb9d8bbd4d3932f1b84877\" xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\"><wsp:ExactlyOne><wsp:All><saptrnbnd:OptimizedXMLTransfer wsp:Optional=\"true\" xmlns:saptrnbnd=\"http://www.sap.com/webas/710/soap/features/transportbinding/\" uri=\"http://xml.sap.com/2006/11/esi/esp/binxml\"></saptrnbnd:OptimizedXMLTransfer><saptrnbnd:OptimizedMimeSerialization wsp:Optional=\"true\" xmlns:saptrnbnd=\"http://schemas.xmlsoap.org/ws/2004/09/policy/optimizedmimeserialization\"></saptrnbnd:OptimizedMimeSerialization><sp:TransportBinding xmlns:sp=\"http://docs.oasis-open.org/ws-sx/ws-securitypolicy/200702\"><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:TransportToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpsToken><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:HttpBasicAuthentication/></wsp:Policy></sp:HttpsToken></wsp:Policy></sp:TransportToken><sp:AlgorithmSuite><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Basic128Rsa15/></wsp:Policy></sp:AlgorithmSuite><sp:Layout><wsp:Policy xmlns:wsp=\"http://schemas.xmlsoap.org/ws/2004/09/policy\"><sp:Strict/></wsp:Policy></sp:Layout></wsp:Policy></sp:TransportBinding><wsaw:UsingAddressing wsp:Optional=\"true\" xmlns:wsaw=\"http://www.w3.org/2006/05/addressing/wsdl\"></wsaw:UsingAddressing></wsp:All></wsp:ExactlyOne></wsp:Policy>"));
	    
	    
            _operations[0]=__operation;
            
        
        }

    //populates the faults
    private void populateFaults(){
         


    }

    /**
      *Constructor that takes in a configContext
      */

    public ZWS_LOGIN_EMPLStub(org.apache.axis2.context.ConfigurationContext configurationContext,
       java.lang.String targetEndpoint)
       throws org.apache.axis2.AxisFault {
         this(configurationContext,targetEndpoint,false);
   }


   /**
     * Constructor that takes in a configContext  and useseperate listner
     */
   public ZWS_LOGIN_EMPLStub(org.apache.axis2.context.ConfigurationContext configurationContext,
        java.lang.String targetEndpoint, boolean useSeparateListener)
        throws org.apache.axis2.AxisFault {
         //To populate AxisService
         populateAxisService();
         populateFaults();

        _serviceClient = new org.apache.axis2.client.ServiceClient(configurationContext,_service);
        
        _service.applyPolicy();
        
	
        _serviceClient.getOptions().setTo(new org.apache.axis2.addressing.EndpointReference(
                targetEndpoint));
        _serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
        
            //Set the soap version
            _serviceClient.getOptions().setSoapVersionURI(org.apache.axiom.soap.SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);
        
    
    }

    /**
     * Default Constructor
     */
    public ZWS_LOGIN_EMPLStub(org.apache.axis2.context.ConfigurationContext configurationContext) throws org.apache.axis2.AxisFault {
        
                    this(configurationContext,"http://zapdev.fordzapata.com.mx:8001/sap/bc/srt/rfc/sap/zws_login_empl/100/zws_login_empl/zws_login_empl" );
                
    }

    /**
     * Default Constructor
     */
    public ZWS_LOGIN_EMPLStub() throws org.apache.axis2.AxisFault {
        
                    this("http://zapdev.fordzapata.com.mx:8001/sap/bc/srt/rfc/sap/zws_login_empl/100/zws_login_empl/zws_login_empl" );
                
    }

    /**
     * Constructor taking the target endpoint
     */
    public ZWS_LOGIN_EMPLStub(java.lang.String targetEndpoint) throws org.apache.axis2.AxisFault {
        this(null,targetEndpoint);
    }



        
                    /**
                     * Auto generated method signature
                     * 
                     * @see functions.rfc.sap.document.sap_com.ZWS_LOGIN_EMPL#z_FE_FM_LOGIN_EMPL
                     * @param z_FE_FM_LOGIN_EMPL2
                    
                     */

                    

                            public  functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPLResponse z_FE_FM_LOGIN_EMPL(

                            functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPL z_FE_FM_LOGIN_EMPL2)
                        

                    throws java.rmi.RemoteException
                    
                    {
              org.apache.axis2.context.MessageContext _messageContext = null;
              try{
               org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
              _operationClient.getOptions().setAction("urn:sap-com:document:sap:rfc:functions:ZWS_LOGIN_EMPL:Z_FE_FM_LOGIN_EMPLRequest");
              _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              

              // create a message context
              _messageContext = new org.apache.axis2.context.MessageContext();

              

              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env = null;
                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    z_FE_FM_LOGIN_EMPL2,
                                                    optimizeContent(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions",
                                                    "z_FE_FM_LOGIN_EMPL")), new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions",
                                                    "z_FE_FM_LOGIN_EMPL"));
                                                
        //adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        _operationClient.addMessageContext(_messageContext);

        //execute the operation client
        _operationClient.execute(true);

         
               org.apache.axis2.context.MessageContext _returnMessageContext = _operationClient.getMessageContext(
                                           org.apache.axis2.wsdl.WSDLConstants.MESSAGE_LABEL_IN_VALUE);
                org.apache.axiom.soap.SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();
                
                
                                java.lang.Object object = fromOM(
                                             _returnEnv.getBody().getFirstElement() ,
                                             functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPLResponse.class,
                                              getEnvelopeNamespaces(_returnEnv));

                               
                                        return (functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPLResponse)object;
                                   
         }catch(org.apache.axis2.AxisFault f){

            org.apache.axiom.om.OMElement faultElt = f.getDetail();
            if (faultElt!=null){
                if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"Z_FE_FM_LOGIN_EMPL"))){
                    //make the fault by reflection
                    try{
                        java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"Z_FE_FM_LOGIN_EMPL"));
                        java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
                        java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                        java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
                        //message class
                        java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"Z_FE_FM_LOGIN_EMPL"));
                        java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
                        java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
                        java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
                                   new java.lang.Class[]{messageClass});
                        m.invoke(ex,new java.lang.Object[]{messageObject});
                        

                        throw new java.rmi.RemoteException(ex.getMessage(), ex);
                    }catch(java.lang.ClassCastException e){
                       // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.ClassNotFoundException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }catch (java.lang.NoSuchMethodException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    } catch (java.lang.reflect.InvocationTargetException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }  catch (java.lang.IllegalAccessException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }   catch (java.lang.InstantiationException e) {
                        // we cannot intantiate the class - throw the original Axis fault
                        throw f;
                    }
                }else{
                    throw f;
                }
            }else{
                throw f;
            }
            } finally {
                if (_messageContext.getTransportOut() != null) {
                      _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                }
            }
        }
            
                /**
                * Auto generated method signature for Asynchronous Invocations
                * 
                * @see functions.rfc.sap.document.sap_com.ZWS_LOGIN_EMPL#startz_FE_FM_LOGIN_EMPL
                    * @param z_FE_FM_LOGIN_EMPL2
                
                */
                public  void startz_FE_FM_LOGIN_EMPL(

                 functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPL z_FE_FM_LOGIN_EMPL2,

                  final functions.rfc.sap.document.sap_com.ZWS_LOGIN_EMPLCallbackHandler callback)

                throws java.rmi.RemoteException{

              org.apache.axis2.client.OperationClient _operationClient = _serviceClient.createClient(_operations[0].getName());
             _operationClient.getOptions().setAction("urn:sap-com:document:sap:rfc:functions:ZWS_LOGIN_EMPL:Z_FE_FM_LOGIN_EMPLRequest");
             _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

              
              
                  addPropertyToOperationClient(_operationClient,org.apache.axis2.description.WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR,"&");
              


              // create SOAP envelope with that payload
              org.apache.axiom.soap.SOAPEnvelope env=null;
              final org.apache.axis2.context.MessageContext _messageContext = new org.apache.axis2.context.MessageContext();

                    
                                    //Style is Doc.
                                    
                                                    
                                                    env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()),
                                                    z_FE_FM_LOGIN_EMPL2,
                                                    optimizeContent(new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions",
                                                    "z_FE_FM_LOGIN_EMPL")), new javax.xml.namespace.QName("urn:sap-com:document:sap:rfc:functions",
                                                    "z_FE_FM_LOGIN_EMPL"));
                                                
        // adding SOAP soap_headers
         _serviceClient.addHeadersToEnvelope(env);
        // create message context with that soap envelope
        _messageContext.setEnvelope(env);

        // add the message context to the operation client
        _operationClient.addMessageContext(_messageContext);


                    
                        _operationClient.setCallback(new org.apache.axis2.client.async.AxisCallback() {
                            public void onMessage(org.apache.axis2.context.MessageContext resultContext) {
                            try {
                                org.apache.axiom.soap.SOAPEnvelope resultEnv = resultContext.getEnvelope();
                                
                                        java.lang.Object object = fromOM(resultEnv.getBody().getFirstElement(),
                                                                         functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPLResponse.class,
                                                                         getEnvelopeNamespaces(resultEnv));
                                        callback.receiveResultz_FE_FM_LOGIN_EMPL(
                                        (functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPLResponse)object);
                                        
                            } catch (org.apache.axis2.AxisFault e) {
                                callback.receiveErrorz_FE_FM_LOGIN_EMPL(e);
                            }
                            }

                            public void onError(java.lang.Exception error) {
								if (error instanceof org.apache.axis2.AxisFault) {
									org.apache.axis2.AxisFault f = (org.apache.axis2.AxisFault) error;
									org.apache.axiom.om.OMElement faultElt = f.getDetail();
									if (faultElt!=null){
										if (faultExceptionNameMap.containsKey(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"Z_FE_FM_LOGIN_EMPL"))){
											//make the fault by reflection
											try{
													java.lang.String exceptionClassName = (java.lang.String)faultExceptionClassNameMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"Z_FE_FM_LOGIN_EMPL"));
													java.lang.Class exceptionClass = java.lang.Class.forName(exceptionClassName);
													java.lang.reflect.Constructor constructor = exceptionClass.getConstructor(String.class);
                                                    java.lang.Exception ex = (java.lang.Exception) constructor.newInstance(f.getMessage());
													//message class
													java.lang.String messageClassName = (java.lang.String)faultMessageMap.get(new org.apache.axis2.client.FaultMapKey(faultElt.getQName(),"Z_FE_FM_LOGIN_EMPL"));
														java.lang.Class messageClass = java.lang.Class.forName(messageClassName);
													java.lang.Object messageObject = fromOM(faultElt,messageClass,null);
													java.lang.reflect.Method m = exceptionClass.getMethod("setFaultMessage",
															new java.lang.Class[]{messageClass});
													m.invoke(ex,new java.lang.Object[]{messageObject});
													
					
										            callback.receiveErrorz_FE_FM_LOGIN_EMPL(new java.rmi.RemoteException(ex.getMessage(), ex));
                                            } catch(java.lang.ClassCastException e){
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorz_FE_FM_LOGIN_EMPL(f);
                                            } catch (java.lang.ClassNotFoundException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorz_FE_FM_LOGIN_EMPL(f);
                                            } catch (java.lang.NoSuchMethodException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorz_FE_FM_LOGIN_EMPL(f);
                                            } catch (java.lang.reflect.InvocationTargetException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorz_FE_FM_LOGIN_EMPL(f);
                                            } catch (java.lang.IllegalAccessException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorz_FE_FM_LOGIN_EMPL(f);
                                            } catch (java.lang.InstantiationException e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorz_FE_FM_LOGIN_EMPL(f);
                                            } catch (org.apache.axis2.AxisFault e) {
                                                // we cannot intantiate the class - throw the original Axis fault
                                                callback.receiveErrorz_FE_FM_LOGIN_EMPL(f);
                                            }
									    } else {
										    callback.receiveErrorz_FE_FM_LOGIN_EMPL(f);
									    }
									} else {
									    callback.receiveErrorz_FE_FM_LOGIN_EMPL(f);
									}
								} else {
								    callback.receiveErrorz_FE_FM_LOGIN_EMPL(error);
								}
                            }

                            public void onFault(org.apache.axis2.context.MessageContext faultContext) {
                                org.apache.axis2.AxisFault fault = org.apache.axis2.util.Utils.getInboundFaultFromMessageContext(faultContext);
                                onError(fault);
                            }

                            public void onComplete() {
                                try {
                                    _messageContext.getTransportOut().getSender().cleanup(_messageContext);
                                } catch (org.apache.axis2.AxisFault axisFault) {
                                    callback.receiveErrorz_FE_FM_LOGIN_EMPL(axisFault);
                                }
                            }
                });
                        

          org.apache.axis2.util.CallbackReceiver _callbackReceiver = null;
        if ( _operations[0].getMessageReceiver()==null &&  _operationClient.getOptions().isUseSeparateListener()) {
           _callbackReceiver = new org.apache.axis2.util.CallbackReceiver();
          _operations[0].setMessageReceiver(
                    _callbackReceiver);
        }

           //execute the operation client
           _operationClient.execute(false);

                    }
                


       /**
        *  A utility method that copies the namepaces from the SOAPEnvelope
        */
       private java.util.Map getEnvelopeNamespaces(org.apache.axiom.soap.SOAPEnvelope env){
        java.util.Map returnMap = new java.util.HashMap();
        java.util.Iterator namespaceIterator = env.getAllDeclaredNamespaces();
        while (namespaceIterator.hasNext()) {
            org.apache.axiom.om.OMNamespace ns = (org.apache.axiom.om.OMNamespace) namespaceIterator.next();
            returnMap.put(ns.getPrefix(),ns.getNamespaceURI());
        }
       return returnMap;
    }

    
    ////////////////////////////////////////////////////////////////////////
    
    private static org.apache.neethi.Policy getPolicy (java.lang.String policyString) {
    	return org.apache.neethi.PolicyEngine.getPolicy(org.apache.axiom.om.OMXMLBuilderFactory.createOMBuilder(
    	        new java.io.StringReader(policyString)).getDocument().getXMLStreamReader(false));
    }
    
    /////////////////////////////////////////////////////////////////////////

    
    
    private javax.xml.namespace.QName[] opNameArray = null;
    private boolean optimizeContent(javax.xml.namespace.QName opName) {
        

        if (opNameArray == null) {
            return false;
        }
        for (int i = 0; i < opNameArray.length; i++) {
            if (opName.equals(opNameArray[i])) {
                return true;   
            }
        }
        return false;
    }
     //http://zapdev.fordzapata.com.mx:8001/sap/bc/srt/rfc/sap/zws_login_empl/100/zws_login_empl/zws_login_empl
            private  org.apache.axiom.om.OMElement  toOM(functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPL param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPL.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
            private  org.apache.axiom.om.OMElement  toOM(functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPLResponse param, boolean optimizeContent)
            throws org.apache.axis2.AxisFault {

            
                        try{
                             return param.getOMElement(functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPLResponse.MY_QNAME,
                                          org.apache.axiom.om.OMAbstractFactory.getOMFactory());
                        } catch(org.apache.axis2.databinding.ADBException e){
                            throw org.apache.axis2.AxisFault.makeFault(e);
                        }
                    

            }
        
                                    
                                        private  org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory, functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPL param, boolean optimizeContent, javax.xml.namespace.QName methodQName)
                                        throws org.apache.axis2.AxisFault{

                                             
                                                    try{

                                                            org.apache.axiom.soap.SOAPEnvelope emptyEnvelope = factory.getDefaultEnvelope();
                                                            emptyEnvelope.getBody().addChild(param.getOMElement(functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPL.MY_QNAME,factory));
                                                            return emptyEnvelope;
                                                        } catch(org.apache.axis2.databinding.ADBException e){
                                                            throw org.apache.axis2.AxisFault.makeFault(e);
                                                        }
                                                

                                        }
                                
                             
                             /* methods to provide back word compatibility */

                             


        /**
        *  get the default envelope
        */
        private org.apache.axiom.soap.SOAPEnvelope toEnvelope(org.apache.axiom.soap.SOAPFactory factory){
        return factory.getDefaultEnvelope();
        }


        private  java.lang.Object fromOM(
        org.apache.axiom.om.OMElement param,
        java.lang.Class type,
        java.util.Map extraNamespaces) throws org.apache.axis2.AxisFault{

        try {
        
                if (functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPL.class.equals(type)){
                
                           return functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPL.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
                if (functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPLResponse.class.equals(type)){
                
                           return functions.rfc.sap.document.sap_com.Z_FE_FM_LOGIN_EMPLResponse.Factory.parse(param.getXMLStreamReaderWithoutCaching());
                    

                }
           
        } catch (java.lang.Exception e) {
        throw org.apache.axis2.AxisFault.makeFault(e);
        }
           return null;
        }



    
   }
   