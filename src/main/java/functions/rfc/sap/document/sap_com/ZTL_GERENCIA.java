
/**
 * ZTL_GERENCIA.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package functions.rfc.sap.document.sap_com;
            

            /**
            *  ZTL_GERENCIA bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ZTL_GERENCIA
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ZTL_GERENCIA
                Namespace URI = urn:sap-com:document:sap:rfc:functions
                Namespace Prefix = ns1
                */
            

                        /**
                        * field for ID_DIRECCION
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.ID_DIRECCION_type1 localID_DIRECCION ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localID_DIRECCIONTracker = false ;

                           public boolean isID_DIRECCIONSpecified(){
                               return localID_DIRECCIONTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.ID_DIRECCION_type1
                           */
                           public  functions.rfc.sap.document.sap_com.ID_DIRECCION_type1 getID_DIRECCION(){
                               return localID_DIRECCION;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ID_DIRECCION
                               */
                               public void setID_DIRECCION(functions.rfc.sap.document.sap_com.ID_DIRECCION_type1 param){
                            localID_DIRECCIONTracker = param != null;
                                   
                                            this.localID_DIRECCION=param;
                                    

                               }
                            

                        /**
                        * field for ID_GERENCIA
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.ID_GERENCIA_type1 localID_GERENCIA ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localID_GERENCIATracker = false ;

                           public boolean isID_GERENCIASpecified(){
                               return localID_GERENCIATracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.ID_GERENCIA_type1
                           */
                           public  functions.rfc.sap.document.sap_com.ID_GERENCIA_type1 getID_GERENCIA(){
                               return localID_GERENCIA;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ID_GERENCIA
                               */
                               public void setID_GERENCIA(functions.rfc.sap.document.sap_com.ID_GERENCIA_type1 param){
                            localID_GERENCIATracker = param != null;
                                   
                                            this.localID_GERENCIA=param;
                                    

                               }
                            

                        /**
                        * field for DESC_GERENCIA
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.DESC_GERENCIA_type1 localDESC_GERENCIA ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDESC_GERENCIATracker = false ;

                           public boolean isDESC_GERENCIASpecified(){
                               return localDESC_GERENCIATracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.DESC_GERENCIA_type1
                           */
                           public  functions.rfc.sap.document.sap_com.DESC_GERENCIA_type1 getDESC_GERENCIA(){
                               return localDESC_GERENCIA;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DESC_GERENCIA
                               */
                               public void setDESC_GERENCIA(functions.rfc.sap.document.sap_com.DESC_GERENCIA_type1 param){
                            localDESC_GERENCIATracker = param != null;
                                   
                                            this.localDESC_GERENCIA=param;
                                    

                               }
                            

                        /**
                        * field for DESC_DIRECCION
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.DESC_DIRECCION_type1 localDESC_DIRECCION ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDESC_DIRECCIONTracker = false ;

                           public boolean isDESC_DIRECCIONSpecified(){
                               return localDESC_DIRECCIONTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.DESC_DIRECCION_type1
                           */
                           public  functions.rfc.sap.document.sap_com.DESC_DIRECCION_type1 getDESC_DIRECCION(){
                               return localDESC_DIRECCION;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DESC_DIRECCION
                               */
                               public void setDESC_DIRECCION(functions.rfc.sap.document.sap_com.DESC_DIRECCION_type1 param){
                            localDESC_DIRECCIONTracker = param != null;
                                   
                                            this.localDESC_DIRECCION=param;
                                    

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
                       new org.apache.axis2.databinding.ADBDataSource(this,parentQName);
               return factory.createOMElement(dataSource,parentQName);
            
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
                           namespacePrefix+":ZTL_GERENCIA",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ZTL_GERENCIA",
                           xmlWriter);
                   }

               
                   }
                if (localID_DIRECCIONTracker){
                                            if (localID_DIRECCION==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ID_DIRECCION cannot be null!!");
                                            }
                                           localID_DIRECCION.serialize(new javax.xml.namespace.QName("","ID_DIRECCION"),
                                               xmlWriter);
                                        } if (localID_GERENCIATracker){
                                            if (localID_GERENCIA==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ID_GERENCIA cannot be null!!");
                                            }
                                           localID_GERENCIA.serialize(new javax.xml.namespace.QName("","ID_GERENCIA"),
                                               xmlWriter);
                                        } if (localDESC_GERENCIATracker){
                                            if (localDESC_GERENCIA==null){
                                                 throw new org.apache.axis2.databinding.ADBException("DESC_GERENCIA cannot be null!!");
                                            }
                                           localDESC_GERENCIA.serialize(new javax.xml.namespace.QName("","DESC_GERENCIA"),
                                               xmlWriter);
                                        } if (localDESC_DIRECCIONTracker){
                                            if (localDESC_DIRECCION==null){
                                                 throw new org.apache.axis2.databinding.ADBException("DESC_DIRECCION cannot be null!!");
                                            }
                                           localDESC_DIRECCION.serialize(new javax.xml.namespace.QName("","DESC_DIRECCION"),
                                               xmlWriter);
                                        }
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

                 if (localID_DIRECCIONTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ID_DIRECCION"));
                            
                            
                                    if (localID_DIRECCION==null){
                                         throw new org.apache.axis2.databinding.ADBException("ID_DIRECCION cannot be null!!");
                                    }
                                    elementList.add(localID_DIRECCION);
                                } if (localID_GERENCIATracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ID_GERENCIA"));
                            
                            
                                    if (localID_GERENCIA==null){
                                         throw new org.apache.axis2.databinding.ADBException("ID_GERENCIA cannot be null!!");
                                    }
                                    elementList.add(localID_GERENCIA);
                                } if (localDESC_GERENCIATracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "DESC_GERENCIA"));
                            
                            
                                    if (localDESC_GERENCIA==null){
                                         throw new org.apache.axis2.databinding.ADBException("DESC_GERENCIA cannot be null!!");
                                    }
                                    elementList.add(localDESC_GERENCIA);
                                } if (localDESC_DIRECCIONTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "DESC_DIRECCION"));
                            
                            
                                    if (localDESC_DIRECCION==null){
                                         throw new org.apache.axis2.databinding.ADBException("DESC_DIRECCION cannot be null!!");
                                    }
                                    elementList.add(localDESC_DIRECCION);
                                }

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
        public static ZTL_GERENCIA parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ZTL_GERENCIA object =
                new ZTL_GERENCIA();

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
                    
                            if (!"ZTL_GERENCIA".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ZTL_GERENCIA)functions.rfc.sap.document.sap_com.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ID_DIRECCION").equals(reader.getName())){
                                
                                                object.setID_DIRECCION(functions.rfc.sap.document.sap_com.ID_DIRECCION_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ID_GERENCIA").equals(reader.getName())){
                                
                                                object.setID_GERENCIA(functions.rfc.sap.document.sap_com.ID_GERENCIA_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DESC_GERENCIA").equals(reader.getName())){
                                
                                                object.setDESC_GERENCIA(functions.rfc.sap.document.sap_com.DESC_GERENCIA_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DESC_DIRECCION").equals(reader.getName())){
                                
                                                object.setDESC_DIRECCION(functions.rfc.sap.document.sap_com.DESC_DIRECCION_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                  
                            while (!reader.isStartElement() && !reader.isEndElement())
                                reader.next();
                            
                                if (reader.isStartElement())
                                // A start element we are not expecting indicates a trailing invalid property
                                throw new org.apache.axis2.databinding.ADBException("Unexpected subelement " + reader.getName());
                            



            } catch (javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

        }//end of factory class

        

        }
           
    