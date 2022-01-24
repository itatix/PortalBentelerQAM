
/**
 * ZTL_LISTA_FAC.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package functions.rfc.sap.document.sap_com;
            

            /**
            *  ZTL_LISTA_FAC bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ZTL_LISTA_FAC
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ZTL_LISTA_FAC
                Namespace URI = urn:sap-com:document:sap:rfc:functions
                Namespace Prefix = ns1
                */
            

                        /**
                        * field for BLDAT
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.Date localBLDAT ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBLDATTracker = false ;

                           public boolean isBLDATSpecified(){
                               return localBLDATTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.Date
                           */
                           public  functions.rfc.sap.document.sap_com.Date getBLDAT(){
                               return localBLDAT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BLDAT
                               */
                               public void setBLDAT(functions.rfc.sap.document.sap_com.Date param){
                            localBLDATTracker = param != null;
                                   
                                            this.localBLDAT=param;
                                    

                               }
                            

                        /**
                        * field for XBLNR
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.XBLNR_type1 localXBLNR ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localXBLNRTracker = false ;

                           public boolean isXBLNRSpecified(){
                               return localXBLNRTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.XBLNR_type1
                           */
                           public  functions.rfc.sap.document.sap_com.XBLNR_type1 getXBLNR(){
                               return localXBLNR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param XBLNR
                               */
                               public void setXBLNR(functions.rfc.sap.document.sap_com.XBLNR_type1 param){
                            localXBLNRTracker = param != null;
                                   
                                            this.localXBLNR=param;
                                    

                               }
                            

                        /**
                        * field for BELNR
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.BELNR_type1 localBELNR ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBELNRTracker = false ;

                           public boolean isBELNRSpecified(){
                               return localBELNRTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.BELNR_type1
                           */
                           public  functions.rfc.sap.document.sap_com.BELNR_type1 getBELNR(){
                               return localBELNR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BELNR
                               */
                               public void setBELNR(functions.rfc.sap.document.sap_com.BELNR_type1 param){
                            localBELNRTracker = param != null;
                                   
                                            this.localBELNR=param;
                                    

                               }
                            

                        /**
                        * field for NETO
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.NETO_type1 localNETO ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNETOTracker = false ;

                           public boolean isNETOSpecified(){
                               return localNETOTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.NETO_type1
                           */
                           public  functions.rfc.sap.document.sap_com.NETO_type1 getNETO(){
                               return localNETO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NETO
                               */
                               public void setNETO(functions.rfc.sap.document.sap_com.NETO_type1 param){
                            localNETOTracker = param != null;
                                   
                                            this.localNETO=param;
                                    

                               }
                            

                        /**
                        * field for WAERS
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.WAERS_type1 localWAERS ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localWAERSTracker = false ;

                           public boolean isWAERSSpecified(){
                               return localWAERSTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.WAERS_type1
                           */
                           public  functions.rfc.sap.document.sap_com.WAERS_type1 getWAERS(){
                               return localWAERS;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param WAERS
                               */
                               public void setWAERS(functions.rfc.sap.document.sap_com.WAERS_type1 param){
                            localWAERSTracker = param != null;
                                   
                                            this.localWAERS=param;
                                    

                               }
                            

                        /**
                        * field for FVENC
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.Date localFVENC ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFVENCTracker = false ;

                           public boolean isFVENCSpecified(){
                               return localFVENCTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.Date
                           */
                           public  functions.rfc.sap.document.sap_com.Date getFVENC(){
                               return localFVENC;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FVENC
                               */
                               public void setFVENC(functions.rfc.sap.document.sap_com.Date param){
                            localFVENCTracker = param != null;
                                   
                                            this.localFVENC=param;
                                    

                               }
                            

                        /**
                        * field for FPAGO
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.Date localFPAGO ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFPAGOTracker = false ;

                           public boolean isFPAGOSpecified(){
                               return localFPAGOTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.Date
                           */
                           public  functions.rfc.sap.document.sap_com.Date getFPAGO(){
                               return localFPAGO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FPAGO
                               */
                               public void setFPAGO(functions.rfc.sap.document.sap_com.Date param){
                            localFPAGOTracker = param != null;
                                   
                                            this.localFPAGO=param;
                                    

                               }
                            

                        /**
                        * field for ESTATUS
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.ESTATUS_type1 localESTATUS ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localESTATUSTracker = false ;

                           public boolean isESTATUSSpecified(){
                               return localESTATUSTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.ESTATUS_type1
                           */
                           public  functions.rfc.sap.document.sap_com.ESTATUS_type1 getESTATUS(){
                               return localESTATUS;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ESTATUS
                               */
                               public void setESTATUS(functions.rfc.sap.document.sap_com.ESTATUS_type1 param){
                            localESTATUSTracker = param != null;
                                   
                                            this.localESTATUS=param;
                                    

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
                           namespacePrefix+":ZTL_LISTA_FAC",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ZTL_LISTA_FAC",
                           xmlWriter);
                   }

               
                   }
                if (localBLDATTracker){
                                            if (localBLDAT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("BLDAT cannot be null!!");
                                            }
                                           localBLDAT.serialize(new javax.xml.namespace.QName("","BLDAT"),
                                               xmlWriter);
                                        } if (localXBLNRTracker){
                                            if (localXBLNR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("XBLNR cannot be null!!");
                                            }
                                           localXBLNR.serialize(new javax.xml.namespace.QName("","XBLNR"),
                                               xmlWriter);
                                        } if (localBELNRTracker){
                                            if (localBELNR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("BELNR cannot be null!!");
                                            }
                                           localBELNR.serialize(new javax.xml.namespace.QName("","BELNR"),
                                               xmlWriter);
                                        } if (localNETOTracker){
                                            if (localNETO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("NETO cannot be null!!");
                                            }
                                           localNETO.serialize(new javax.xml.namespace.QName("","NETO"),
                                               xmlWriter);
                                        } if (localWAERSTracker){
                                            if (localWAERS==null){
                                                 throw new org.apache.axis2.databinding.ADBException("WAERS cannot be null!!");
                                            }
                                           localWAERS.serialize(new javax.xml.namespace.QName("","WAERS"),
                                               xmlWriter);
                                        } if (localFVENCTracker){
                                            if (localFVENC==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FVENC cannot be null!!");
                                            }
                                           localFVENC.serialize(new javax.xml.namespace.QName("","FVENC"),
                                               xmlWriter);
                                        } if (localFPAGOTracker){
                                            if (localFPAGO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FPAGO cannot be null!!");
                                            }
                                           localFPAGO.serialize(new javax.xml.namespace.QName("","FPAGO"),
                                               xmlWriter);
                                        } if (localESTATUSTracker){
                                            if (localESTATUS==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ESTATUS cannot be null!!");
                                            }
                                           localESTATUS.serialize(new javax.xml.namespace.QName("","ESTATUS"),
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

                 if (localBLDATTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "BLDAT"));
                            
                            
                                    if (localBLDAT==null){
                                         throw new org.apache.axis2.databinding.ADBException("BLDAT cannot be null!!");
                                    }
                                    elementList.add(localBLDAT);
                                } if (localXBLNRTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "XBLNR"));
                            
                            
                                    if (localXBLNR==null){
                                         throw new org.apache.axis2.databinding.ADBException("XBLNR cannot be null!!");
                                    }
                                    elementList.add(localXBLNR);
                                } if (localBELNRTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "BELNR"));
                            
                            
                                    if (localBELNR==null){
                                         throw new org.apache.axis2.databinding.ADBException("BELNR cannot be null!!");
                                    }
                                    elementList.add(localBELNR);
                                } if (localNETOTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "NETO"));
                            
                            
                                    if (localNETO==null){
                                         throw new org.apache.axis2.databinding.ADBException("NETO cannot be null!!");
                                    }
                                    elementList.add(localNETO);
                                } if (localWAERSTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "WAERS"));
                            
                            
                                    if (localWAERS==null){
                                         throw new org.apache.axis2.databinding.ADBException("WAERS cannot be null!!");
                                    }
                                    elementList.add(localWAERS);
                                } if (localFVENCTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "FVENC"));
                            
                            
                                    if (localFVENC==null){
                                         throw new org.apache.axis2.databinding.ADBException("FVENC cannot be null!!");
                                    }
                                    elementList.add(localFVENC);
                                } if (localFPAGOTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "FPAGO"));
                            
                            
                                    if (localFPAGO==null){
                                         throw new org.apache.axis2.databinding.ADBException("FPAGO cannot be null!!");
                                    }
                                    elementList.add(localFPAGO);
                                } if (localESTATUSTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ESTATUS"));
                            
                            
                                    if (localESTATUS==null){
                                         throw new org.apache.axis2.databinding.ADBException("ESTATUS cannot be null!!");
                                    }
                                    elementList.add(localESTATUS);
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
        public static ZTL_LISTA_FAC parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ZTL_LISTA_FAC object =
                new ZTL_LISTA_FAC();

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
                    
                            if (!"ZTL_LISTA_FAC".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ZTL_LISTA_FAC)functions.rfc.sap.document.sap_com.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","BLDAT").equals(reader.getName())){
                                
                                                object.setBLDAT(functions.rfc.sap.document.sap_com.Date.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","XBLNR").equals(reader.getName())){
                                
                                                object.setXBLNR(functions.rfc.sap.document.sap_com.XBLNR_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","BELNR").equals(reader.getName())){
                                
                                                object.setBELNR(functions.rfc.sap.document.sap_com.BELNR_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","NETO").equals(reader.getName())){
                                
                                                object.setNETO(functions.rfc.sap.document.sap_com.NETO_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","WAERS").equals(reader.getName())){
                                
                                                object.setWAERS(functions.rfc.sap.document.sap_com.WAERS_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","FVENC").equals(reader.getName())){
                                
                                                object.setFVENC(functions.rfc.sap.document.sap_com.Date.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","FPAGO").equals(reader.getName())){
                                
                                                object.setFPAGO(functions.rfc.sap.document.sap_com.Date.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ESTATUS").equals(reader.getName())){
                                
                                                object.setESTATUS(functions.rfc.sap.document.sap_com.ESTATUS_type1.Factory.parse(reader));
                                              
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
           
    