
/**
 * Z_FI_GET_TIPO_SERVICIOResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package functions.rfc.sap.document.sap_com;
            

            /**
            *  Z_FI_GET_TIPO_SERVICIOResponse bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class Z_FI_GET_TIPO_SERVICIOResponse
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "Z_FI_GET_TIPO_SERVICIO.Response",
                "ns1");

            

                        /**
                        * field for EV_ID
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.EV_ID_type1 localEV_ID ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEV_IDTracker = false ;

                           public boolean isEV_IDSpecified(){
                               return localEV_IDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.EV_ID_type1
                           */
                           public  functions.rfc.sap.document.sap_com.EV_ID_type1 getEV_ID(){
                               return localEV_ID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EV_ID
                               */
                               public void setEV_ID(functions.rfc.sap.document.sap_com.EV_ID_type1 param){
                            localEV_IDTracker = param != null;
                                   
                                            this.localEV_ID=param;
                                    

                               }
                            

                        /**
                        * field for EV_MESSAGE
                        */

                        
                                    protected java.lang.String localEV_MESSAGE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEV_MESSAGETracker = false ;

                           public boolean isEV_MESSAGESpecified(){
                               return localEV_MESSAGETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getEV_MESSAGE(){
                               return localEV_MESSAGE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EV_MESSAGE
                               */
                               public void setEV_MESSAGE(java.lang.String param){
                            localEV_MESSAGETracker = param != null;
                                   
                                            this.localEV_MESSAGE=param;
                                    

                               }
                            

                        /**
                        * field for EV_TYPE
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.EV_TYPE_type1 localEV_TYPE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localEV_TYPETracker = false ;

                           public boolean isEV_TYPESpecified(){
                               return localEV_TYPETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.EV_TYPE_type1
                           */
                           public  functions.rfc.sap.document.sap_com.EV_TYPE_type1 getEV_TYPE(){
                               return localEV_TYPE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param EV_TYPE
                               */
                               public void setEV_TYPE(functions.rfc.sap.document.sap_com.EV_TYPE_type1 param){
                            localEV_TYPETracker = param != null;
                                   
                                            this.localEV_TYPE=param;
                                    

                               }
                            

                        /**
                        * field for ET_TIPO_SERVICIO
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.ET_TIPO_SERVICIO_type1 localET_TIPO_SERVICIO ;
                                

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.ET_TIPO_SERVICIO_type1
                           */
                           public  functions.rfc.sap.document.sap_com.ET_TIPO_SERVICIO_type1 getET_TIPO_SERVICIO(){
                               return localET_TIPO_SERVICIO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ET_TIPO_SERVICIO
                               */
                               public void setET_TIPO_SERVICIO(functions.rfc.sap.document.sap_com.ET_TIPO_SERVICIO_type1 param){
                            
                                            this.localET_TIPO_SERVICIO=param;
                                    

                               }
                            

     
     
        /**
        *
        * @param parentQName
        * @param factory
        * @return org.apache.axiom.om.OMElement
        */
       public org.apache.axiom.om.OMElement getOMElement (
               final javax.xml.namespace.QName parentQName,
               final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException{


        
               org.apache.axiom.om.OMDataSource dataSource =
                       new org.apache.axis2.databinding.ADBDataSource(this,MY_QNAME);
               return factory.createOMElement(dataSource,MY_QNAME);
            
        }

         public void serialize(final javax.xml.namespace.QName parentQName,
                                       javax.xml.stream.XMLStreamWriter xmlWriter)
                                throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
                           serialize(parentQName,xmlWriter,false);
         }

         public void serialize(final javax.xml.namespace.QName parentQName,
                               javax.xml.stream.XMLStreamWriter xmlWriter,
                               boolean serializeType)
            throws javax.xml.stream.XMLStreamException, org.apache.axis2.databinding.ADBException{
            
                


                java.lang.String prefix = null;
                java.lang.String namespace = null;
                

                    prefix = parentQName.getPrefix();
                    namespace = parentQName.getNamespaceURI();
                    writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);
                
                  if (serializeType){
               

                   java.lang.String namespacePrefix = registerPrefix(xmlWriter,"urn:sap-com:document:sap:rfc:functions");
                   if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)){
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           namespacePrefix+":Z_FI_GET_TIPO_SERVICIO.Response",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "Z_FI_GET_TIPO_SERVICIO.Response",
                           xmlWriter);
                   }

               
                   }
                if (localEV_IDTracker){
                                            if (localEV_ID==null){
                                                 throw new org.apache.axis2.databinding.ADBException("EV_ID cannot be null!!");
                                            }
                                           localEV_ID.serialize(new javax.xml.namespace.QName("","EV_ID"),
                                               xmlWriter);
                                        } if (localEV_MESSAGETracker){
                                    namespace = "";
                                    writeStartElement(null, namespace, "EV_MESSAGE", xmlWriter);
                             

                                          if (localEV_MESSAGE==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("EV_MESSAGE cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localEV_MESSAGE);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             } if (localEV_TYPETracker){
                                            if (localEV_TYPE==null){
                                                 throw new org.apache.axis2.databinding.ADBException("EV_TYPE cannot be null!!");
                                            }
                                           localEV_TYPE.serialize(new javax.xml.namespace.QName("","EV_TYPE"),
                                               xmlWriter);
                                        }
                                            if (localET_TIPO_SERVICIO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ET_TIPO_SERVICIO cannot be null!!");
                                            }
                                           localET_TIPO_SERVICIO.serialize(new javax.xml.namespace.QName("","ET_TIPO_SERVICIO"),
                                               xmlWriter);
                                        
                    xmlWriter.writeEndElement();
               

        }

        private static java.lang.String generatePrefix(java.lang.String namespace) {
            if(namespace.equals("urn:sap-com:document:sap:rfc:functions")){
                return "ns1";
            }
            return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }

        /**
         * Utility method to write an element start tag.
         */
        private void writeStartElement(java.lang.String prefix, java.lang.String namespace, java.lang.String localPart,
                                       javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(namespace, localPart);
            } else {
                if (namespace.length() == 0) {
                    prefix = "";
                } else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }
        
        /**
         * Util method to write an attribute with the ns prefix
         */
        private void writeAttribute(java.lang.String prefix,java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (xmlWriter.getPrefix(namespace) == null) {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            xmlWriter.writeAttribute(namespace,attName,attValue);
        }

        /**
         * Util method to write an attribute without the ns prefix
         */
        private void writeAttribute(java.lang.String namespace,java.lang.String attName,
                                    java.lang.String attValue,javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException{
            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName,attValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(namespace,attName,attValue);
            }
        }


           /**
             * Util method to write an attribute without the ns prefix
             */
            private void writeQNameAttribute(java.lang.String namespace, java.lang.String attName,
                                             javax.xml.namespace.QName qname, javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

                java.lang.String attributeNamespace = qname.getNamespaceURI();
                java.lang.String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
                if (attributePrefix == null) {
                    attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
                }
                java.lang.String attributeValue;
                if (attributePrefix.trim().length() > 0) {
                    attributeValue = attributePrefix + ":" + qname.getLocalPart();
                } else {
                    attributeValue = qname.getLocalPart();
                }

                if (namespace.equals("")) {
                    xmlWriter.writeAttribute(attName, attributeValue);
                } else {
                    registerPrefix(xmlWriter, namespace);
                    xmlWriter.writeAttribute(namespace, attName, attributeValue);
                }
            }
        /**
         *  method to handle Qnames
         */

        private void writeQName(javax.xml.namespace.QName qname,
                                javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
            java.lang.String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix,namespaceURI);
                }

                if (prefix.trim().length() > 0){
                    xmlWriter.writeCharacters(prefix + ":" + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                } else {
                    // i.e this is the default namespace
                    xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
                }

            } else {
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(javax.xml.namespace.QName[] qnames,
                                 javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

            if (qnames != null) {
                // we have to store this data until last moment since it is not possible to write any
                // namespace data after writing the charactor data
                java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
                java.lang.String namespaceURI = null;
                java.lang.String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix,namespaceURI);
                        }

                        if (prefix.trim().length() > 0){
                            stringToWrite.append(prefix).append(":").append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        } else {
                            stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                        }
                    } else {
                        stringToWrite.append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }

        }


        /**
         * Register a namespace prefix
         */
        private java.lang.String registerPrefix(javax.xml.stream.XMLStreamWriter xmlWriter, java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
            java.lang.String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    java.lang.String uri = nsContext.getNamespaceURI(prefix);
                    if (uri == null || uri.length() == 0) {
                        break;
                    }
                    prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }


  
        /**
        * databinding method to get an XML representation of this object
        *
        */
        public javax.xml.stream.XMLStreamReader getPullParser(javax.xml.namespace.QName qName)
                    throws org.apache.axis2.databinding.ADBException{


        
                 java.util.ArrayList elementList = new java.util.ArrayList();
                 java.util.ArrayList attribList = new java.util.ArrayList();

                 if (localEV_IDTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "EV_ID"));
                            
                            
                                    if (localEV_ID==null){
                                         throw new org.apache.axis2.databinding.ADBException("EV_ID cannot be null!!");
                                    }
                                    elementList.add(localEV_ID);
                                } if (localEV_MESSAGETracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "EV_MESSAGE"));
                                 
                                        if (localEV_MESSAGE != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localEV_MESSAGE));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("EV_MESSAGE cannot be null!!");
                                        }
                                    } if (localEV_TYPETracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "EV_TYPE"));
                            
                            
                                    if (localEV_TYPE==null){
                                         throw new org.apache.axis2.databinding.ADBException("EV_TYPE cannot be null!!");
                                    }
                                    elementList.add(localEV_TYPE);
                                }
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ET_TIPO_SERVICIO"));
                            
                            
                                    if (localET_TIPO_SERVICIO==null){
                                         throw new org.apache.axis2.databinding.ADBException("ET_TIPO_SERVICIO cannot be null!!");
                                    }
                                    elementList.add(localET_TIPO_SERVICIO);
                                

                return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(), attribList.toArray());
            
            

        }

  

     /**
      *  Factory class that keeps the parse method
      */
    public static class Factory{

        
        

        /**
        * static method to create the object
        * Precondition:  If this object is an element, the current or next start element starts this object and any intervening reader events are ignorable
        *                If this object is not an element, it is a complex type and the reader is at the event just after the outer start element
        * Postcondition: If this object is an element, the reader is positioned at its end element
        *                If this object is a complex type, the reader is positioned at the end element of its outer element
        */
        public static Z_FI_GET_TIPO_SERVICIOResponse parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Z_FI_GET_TIPO_SERVICIOResponse object =
                new Z_FI_GET_TIPO_SERVICIOResponse();

            int event;
            java.lang.String nillableValue = null;
            java.lang.String prefix ="";
            java.lang.String namespaceuri ="";
            try {
                
                while (!reader.isStartElement() && !reader.isEndElement())
                    reader.next();

                
                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","type")!=null){
                  java.lang.String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance",
                        "type");
                  if (fullTypeName!=null){
                    java.lang.String nsPrefix = null;
                    if (fullTypeName.indexOf(":") > -1){
                        nsPrefix = fullTypeName.substring(0,fullTypeName.indexOf(":"));
                    }
                    nsPrefix = nsPrefix==null?"":nsPrefix;

                    java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":")+1);
                    
                            if (!"Z_FI_GET_TIPO_SERVICIO.Response".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Z_FI_GET_TIPO_SERVICIOResponse)functions.rfc.sap.document.sap_com.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                   
                while(!reader.isEndElement()) {
                    if (reader.isStartElement() ){
                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","EV_ID").equals(reader.getName())){
                                
                                                object.setEV_ID(functions.rfc.sap.document.sap_com.EV_ID_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","EV_MESSAGE").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"EV_MESSAGE" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setEV_MESSAGE(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","EV_TYPE").equals(reader.getName())){
                                
                                                object.setEV_TYPE(functions.rfc.sap.document.sap_com.EV_TYPE_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ET_TIPO_SERVICIO").equals(reader.getName())){
                                
                                                object.setET_TIPO_SERVICIO(functions.rfc.sap.document.sap_com.ET_TIPO_SERVICIO_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                             else{
                                        // A start element we are not expecting indicates an invalid parameter was passed
                                        throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                             }
                          
                             } else {
                                reader.next();
                             }  
                           }  // end of while loop
                        



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
    