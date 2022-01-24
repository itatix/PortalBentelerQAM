
/**
 * Z_FE_FM_AGREGAR_CONSIG_ORDER.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package functions.rfc.sap.document.sap_com;
            

            /**
            *  Z_FE_FM_AGREGAR_CONSIG_ORDER bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class Z_FE_FM_AGREGAR_CONSIG_ORDER
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "Z_FE_FM_AGREGAR_CONSIG_ORDER",
                "ns1");

            

                        /**
                        * field for I_BUKRS
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.I_BUKRS_type1 localI_BUKRS ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localI_BUKRSTracker = false ;

                           public boolean isI_BUKRSSpecified(){
                               return localI_BUKRSTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.I_BUKRS_type1
                           */
                           public  functions.rfc.sap.document.sap_com.I_BUKRS_type1 getI_BUKRS(){
                               return localI_BUKRS;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param I_BUKRS
                               */
                               public void setI_BUKRS(functions.rfc.sap.document.sap_com.I_BUKRS_type1 param){
                            localI_BUKRSTracker = param != null;
                                   
                                            this.localI_BUKRS=param;
                                    

                               }
                            

                        /**
                        * field for I_IDIOMA
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.I_IDIOMA_type1 localI_IDIOMA ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localI_IDIOMATracker = false ;

                           public boolean isI_IDIOMASpecified(){
                               return localI_IDIOMATracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.I_IDIOMA_type1
                           */
                           public  functions.rfc.sap.document.sap_com.I_IDIOMA_type1 getI_IDIOMA(){
                               return localI_IDIOMA;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param I_IDIOMA
                               */
                               public void setI_IDIOMA(functions.rfc.sap.document.sap_com.I_IDIOMA_type1 param){
                            localI_IDIOMATracker = param != null;
                                   
                                            this.localI_IDIOMA=param;
                                    

                               }
                            

                        /**
                        * field for I_LIFNR
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.I_LIFNR_type1 localI_LIFNR ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localI_LIFNRTracker = false ;

                           public boolean isI_LIFNRSpecified(){
                               return localI_LIFNRTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.I_LIFNR_type1
                           */
                           public  functions.rfc.sap.document.sap_com.I_LIFNR_type1 getI_LIFNR(){
                               return localI_LIFNR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param I_LIFNR
                               */
                               public void setI_LIFNR(functions.rfc.sap.document.sap_com.I_LIFNR_type1 param){
                            localI_LIFNRTracker = param != null;
                                   
                                            this.localI_LIFNR=param;
                                    

                               }
                            

                        /**
                        * field for I_MATERIAL_DET
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.I_MATERIAL_DET_type0 localI_MATERIAL_DET ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localI_MATERIAL_DETTracker = false ;

                           public boolean isI_MATERIAL_DETSpecified(){
                               return localI_MATERIAL_DETTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.I_MATERIAL_DET_type0
                           */
                           public  functions.rfc.sap.document.sap_com.I_MATERIAL_DET_type0 getI_MATERIAL_DET(){
                               return localI_MATERIAL_DET;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param I_MATERIAL_DET
                               */
                               public void setI_MATERIAL_DET(functions.rfc.sap.document.sap_com.I_MATERIAL_DET_type0 param){
                            localI_MATERIAL_DETTracker = param != null;
                                   
                                            this.localI_MATERIAL_DET=param;
                                    

                               }
                            

                        /**
                        * field for I_PDF
                        */

                        
                                    protected javax.activation.DataHandler localI_PDF ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localI_PDFTracker = false ;

                           public boolean isI_PDFSpecified(){
                               return localI_PDFTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return javax.activation.DataHandler
                           */
                           public  javax.activation.DataHandler getI_PDF(){
                               return localI_PDF;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param I_PDF
                               */
                               public void setI_PDF(javax.activation.DataHandler param){
                            localI_PDFTracker = param != null;
                                   
                                            this.localI_PDF=param;
                                    

                               }
                            

                        /**
                        * field for I_PERIODO
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.I_PERIODO_type0 localI_PERIODO ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localI_PERIODOTracker = false ;

                           public boolean isI_PERIODOSpecified(){
                               return localI_PERIODOTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.I_PERIODO_type0
                           */
                           public  functions.rfc.sap.document.sap_com.I_PERIODO_type0 getI_PERIODO(){
                               return localI_PERIODO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param I_PERIODO
                               */
                               public void setI_PERIODO(functions.rfc.sap.document.sap_com.I_PERIODO_type0 param){
                            localI_PERIODOTracker = param != null;
                                   
                                            this.localI_PERIODO=param;
                                    

                               }
                            

                        /**
                        * field for I_WERKS
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.I_WERKS_type1 localI_WERKS ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localI_WERKSTracker = false ;

                           public boolean isI_WERKSSpecified(){
                               return localI_WERKSTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.I_WERKS_type1
                           */
                           public  functions.rfc.sap.document.sap_com.I_WERKS_type1 getI_WERKS(){
                               return localI_WERKS;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param I_WERKS
                               */
                               public void setI_WERKS(functions.rfc.sap.document.sap_com.I_WERKS_type1 param){
                            localI_WERKSTracker = param != null;
                                   
                                            this.localI_WERKS=param;
                                    

                               }
                            

                        /**
                        * field for I_XBLNR
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.I_XBLNR_type1 localI_XBLNR ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localI_XBLNRTracker = false ;

                           public boolean isI_XBLNRSpecified(){
                               return localI_XBLNRTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.I_XBLNR_type1
                           */
                           public  functions.rfc.sap.document.sap_com.I_XBLNR_type1 getI_XBLNR(){
                               return localI_XBLNR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param I_XBLNR
                               */
                               public void setI_XBLNR(functions.rfc.sap.document.sap_com.I_XBLNR_type1 param){
                            localI_XBLNRTracker = param != null;
                                   
                                            this.localI_XBLNR=param;
                                    

                               }
                            

                        /**
                        * field for I_XML
                        */

                        
                                    protected javax.activation.DataHandler localI_XML ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localI_XMLTracker = false ;

                           public boolean isI_XMLSpecified(){
                               return localI_XMLTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return javax.activation.DataHandler
                           */
                           public  javax.activation.DataHandler getI_XML(){
                               return localI_XML;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param I_XML
                               */
                               public void setI_XML(javax.activation.DataHandler param){
                            localI_XMLTracker = param != null;
                                   
                                            this.localI_XML=param;
                                    

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
                           namespacePrefix+":Z_FE_FM_AGREGAR_CONSIG_ORDER",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "Z_FE_FM_AGREGAR_CONSIG_ORDER",
                           xmlWriter);
                   }

               
                   }
                if (localI_BUKRSTracker){
                                            if (localI_BUKRS==null){
                                                 throw new org.apache.axis2.databinding.ADBException("I_BUKRS cannot be null!!");
                                            }
                                           localI_BUKRS.serialize(new javax.xml.namespace.QName("","I_BUKRS"),
                                               xmlWriter);
                                        } if (localI_IDIOMATracker){
                                            if (localI_IDIOMA==null){
                                                 throw new org.apache.axis2.databinding.ADBException("I_IDIOMA cannot be null!!");
                                            }
                                           localI_IDIOMA.serialize(new javax.xml.namespace.QName("","I_IDIOMA"),
                                               xmlWriter);
                                        } if (localI_LIFNRTracker){
                                            if (localI_LIFNR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("I_LIFNR cannot be null!!");
                                            }
                                           localI_LIFNR.serialize(new javax.xml.namespace.QName("","I_LIFNR"),
                                               xmlWriter);
                                        } if (localI_MATERIAL_DETTracker){
                                            if (localI_MATERIAL_DET==null){
                                                 throw new org.apache.axis2.databinding.ADBException("I_MATERIAL_DET cannot be null!!");
                                            }
                                           localI_MATERIAL_DET.serialize(new javax.xml.namespace.QName("","I_MATERIAL_DET"),
                                               xmlWriter);
                                        } if (localI_PDFTracker){
                                    namespace = "";
                                    writeStartElement(null, namespace, "I_PDF", xmlWriter);
                             
                                        
                                    if (localI_PDF!=null)  {
                                       try {
                                           org.apache.axiom.util.stax.XMLStreamWriterUtils.writeDataHandler(xmlWriter, localI_PDF, null, true);
                                       } catch (java.io.IOException ex) {
                                           throw new javax.xml.stream.XMLStreamException("Unable to read data handler for I_PDF", ex);
                                       }
                                    } else {
                                         
                                    }
                                 
                                   xmlWriter.writeEndElement();
                             } if (localI_PERIODOTracker){
                                            if (localI_PERIODO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("I_PERIODO cannot be null!!");
                                            }
                                           localI_PERIODO.serialize(new javax.xml.namespace.QName("","I_PERIODO"),
                                               xmlWriter);
                                        } if (localI_WERKSTracker){
                                            if (localI_WERKS==null){
                                                 throw new org.apache.axis2.databinding.ADBException("I_WERKS cannot be null!!");
                                            }
                                           localI_WERKS.serialize(new javax.xml.namespace.QName("","I_WERKS"),
                                               xmlWriter);
                                        } if (localI_XBLNRTracker){
                                            if (localI_XBLNR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("I_XBLNR cannot be null!!");
                                            }
                                           localI_XBLNR.serialize(new javax.xml.namespace.QName("","I_XBLNR"),
                                               xmlWriter);
                                        } if (localI_XMLTracker){
                                    namespace = "";
                                    writeStartElement(null, namespace, "I_XML", xmlWriter);
                             
                                        
                                    if (localI_XML!=null)  {
                                       try {
                                           org.apache.axiom.util.stax.XMLStreamWriterUtils.writeDataHandler(xmlWriter, localI_XML, null, true);
                                       } catch (java.io.IOException ex) {
                                           throw new javax.xml.stream.XMLStreamException("Unable to read data handler for I_XML", ex);
                                       }
                                    } else {
                                         
                                    }
                                 
                                   xmlWriter.writeEndElement();
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

                 if (localI_BUKRSTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "I_BUKRS"));
                            
                            
                                    if (localI_BUKRS==null){
                                         throw new org.apache.axis2.databinding.ADBException("I_BUKRS cannot be null!!");
                                    }
                                    elementList.add(localI_BUKRS);
                                } if (localI_IDIOMATracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "I_IDIOMA"));
                            
                            
                                    if (localI_IDIOMA==null){
                                         throw new org.apache.axis2.databinding.ADBException("I_IDIOMA cannot be null!!");
                                    }
                                    elementList.add(localI_IDIOMA);
                                } if (localI_LIFNRTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "I_LIFNR"));
                            
                            
                                    if (localI_LIFNR==null){
                                         throw new org.apache.axis2.databinding.ADBException("I_LIFNR cannot be null!!");
                                    }
                                    elementList.add(localI_LIFNR);
                                } if (localI_MATERIAL_DETTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "I_MATERIAL_DET"));
                            
                            
                                    if (localI_MATERIAL_DET==null){
                                         throw new org.apache.axis2.databinding.ADBException("I_MATERIAL_DET cannot be null!!");
                                    }
                                    elementList.add(localI_MATERIAL_DET);
                                } if (localI_PDFTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                        "I_PDF"));
                                
                            elementList.add(localI_PDF);
                        } if (localI_PERIODOTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "I_PERIODO"));
                            
                            
                                    if (localI_PERIODO==null){
                                         throw new org.apache.axis2.databinding.ADBException("I_PERIODO cannot be null!!");
                                    }
                                    elementList.add(localI_PERIODO);
                                } if (localI_WERKSTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "I_WERKS"));
                            
                            
                                    if (localI_WERKS==null){
                                         throw new org.apache.axis2.databinding.ADBException("I_WERKS cannot be null!!");
                                    }
                                    elementList.add(localI_WERKS);
                                } if (localI_XBLNRTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "I_XBLNR"));
                            
                            
                                    if (localI_XBLNR==null){
                                         throw new org.apache.axis2.databinding.ADBException("I_XBLNR cannot be null!!");
                                    }
                                    elementList.add(localI_XBLNR);
                                } if (localI_XMLTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                        "I_XML"));
                                
                            elementList.add(localI_XML);
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
        public static Z_FE_FM_AGREGAR_CONSIG_ORDER parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Z_FE_FM_AGREGAR_CONSIG_ORDER object =
                new Z_FE_FM_AGREGAR_CONSIG_ORDER();

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
                    
                            if (!"Z_FE_FM_AGREGAR_CONSIG_ORDER".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Z_FE_FM_AGREGAR_CONSIG_ORDER)functions.rfc.sap.document.sap_com.ExtensionMapper.getTypeObject(
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
                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","I_BUKRS").equals(reader.getName())){
                                
                                                object.setI_BUKRS(functions.rfc.sap.document.sap_com.I_BUKRS_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","I_IDIOMA").equals(reader.getName())){
                                
                                                object.setI_IDIOMA(functions.rfc.sap.document.sap_com.I_IDIOMA_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","I_LIFNR").equals(reader.getName())){
                                
                                                object.setI_LIFNR(functions.rfc.sap.document.sap_com.I_LIFNR_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","I_MATERIAL_DET").equals(reader.getName())){
                                
                                                object.setI_MATERIAL_DET(functions.rfc.sap.document.sap_com.I_MATERIAL_DET_type0.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","I_PDF").equals(reader.getName())){
                                
                                            object.setI_PDF(org.apache.axiom.util.stax.XMLStreamReaderUtils.getDataHandlerFromElement(reader));
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","I_PERIODO").equals(reader.getName())){
                                
                                                object.setI_PERIODO(functions.rfc.sap.document.sap_com.I_PERIODO_type0.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","I_WERKS").equals(reader.getName())){
                                
                                                object.setI_WERKS(functions.rfc.sap.document.sap_com.I_WERKS_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","I_XBLNR").equals(reader.getName())){
                                
                                                object.setI_XBLNR(functions.rfc.sap.document.sap_com.I_XBLNR_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","I_XML").equals(reader.getName())){
                                
                                            object.setI_XML(org.apache.axiom.util.stax.XMLStreamReaderUtils.getDataHandlerFromElement(reader));
                                      
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
           
    