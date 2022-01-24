
/**
 * ZST_ESTADO_CUENTA.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package functions.rfc.sap.document.sap_com;
            

            /**
            *  ZST_ESTADO_CUENTA bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ZST_ESTADO_CUENTA
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ZST_ESTADO_CUENTA
                Namespace URI = urn:sap-com:document:sap:rfc:functions
                Namespace Prefix = ns1
                */
            

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
                        * field for BLART
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.BLART_type1 localBLART ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBLARTTracker = false ;

                           public boolean isBLARTSpecified(){
                               return localBLARTTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.BLART_type1
                           */
                           public  functions.rfc.sap.document.sap_com.BLART_type1 getBLART(){
                               return localBLART;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BLART
                               */
                               public void setBLART(functions.rfc.sap.document.sap_com.BLART_type1 param){
                            localBLARTTracker = param != null;
                                   
                                            this.localBLART=param;
                                    

                               }
                            

                        /**
                        * field for BUDAT
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.Date localBUDAT ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBUDATTracker = false ;

                           public boolean isBUDATSpecified(){
                               return localBUDATTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.Date
                           */
                           public  functions.rfc.sap.document.sap_com.Date getBUDAT(){
                               return localBUDAT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BUDAT
                               */
                               public void setBUDAT(functions.rfc.sap.document.sap_com.Date param){
                            localBUDATTracker = param != null;
                                   
                                            this.localBUDAT=param;
                                    

                               }
                            

                        /**
                        * field for ZFBDT
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.Date localZFBDT ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localZFBDTTracker = false ;

                           public boolean isZFBDTSpecified(){
                               return localZFBDTTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.Date
                           */
                           public  functions.rfc.sap.document.sap_com.Date getZFBDT(){
                               return localZFBDT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ZFBDT
                               */
                               public void setZFBDT(functions.rfc.sap.document.sap_com.Date param){
                            localZFBDTTracker = param != null;
                                   
                                            this.localZFBDT=param;
                                    

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
                        * field for WRBTR
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.WRBTR_type1 localWRBTR ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localWRBTRTracker = false ;

                           public boolean isWRBTRSpecified(){
                               return localWRBTRTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.WRBTR_type1
                           */
                           public  functions.rfc.sap.document.sap_com.WRBTR_type1 getWRBTR(){
                               return localWRBTR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param WRBTR
                               */
                               public void setWRBTR(functions.rfc.sap.document.sap_com.WRBTR_type1 param){
                            localWRBTRTracker = param != null;
                                   
                                            this.localWRBTR=param;
                                    

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
                        * field for AUGBL
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.AUGBL_type1 localAUGBL ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAUGBLTracker = false ;

                           public boolean isAUGBLSpecified(){
                               return localAUGBLTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.AUGBL_type1
                           */
                           public  functions.rfc.sap.document.sap_com.AUGBL_type1 getAUGBL(){
                               return localAUGBL;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AUGBL
                               */
                               public void setAUGBL(functions.rfc.sap.document.sap_com.AUGBL_type1 param){
                            localAUGBLTracker = param != null;
                                   
                                            this.localAUGBL=param;
                                    

                               }
                            

                        /**
                        * field for AUGDT
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.Date localAUGDT ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localAUGDTTracker = false ;

                           public boolean isAUGDTSpecified(){
                               return localAUGDTTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.Date
                           */
                           public  functions.rfc.sap.document.sap_com.Date getAUGDT(){
                               return localAUGDT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param AUGDT
                               */
                               public void setAUGDT(functions.rfc.sap.document.sap_com.Date param){
                            localAUGDTTracker = param != null;
                                   
                                            this.localAUGDT=param;
                                    

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
                           namespacePrefix+":ZST_ESTADO_CUENTA",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ZST_ESTADO_CUENTA",
                           xmlWriter);
                   }

               
                   }
                if (localBELNRTracker){
                                            if (localBELNR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("BELNR cannot be null!!");
                                            }
                                           localBELNR.serialize(new javax.xml.namespace.QName("","BELNR"),
                                               xmlWriter);
                                        } if (localBLARTTracker){
                                            if (localBLART==null){
                                                 throw new org.apache.axis2.databinding.ADBException("BLART cannot be null!!");
                                            }
                                           localBLART.serialize(new javax.xml.namespace.QName("","BLART"),
                                               xmlWriter);
                                        } if (localBUDATTracker){
                                            if (localBUDAT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("BUDAT cannot be null!!");
                                            }
                                           localBUDAT.serialize(new javax.xml.namespace.QName("","BUDAT"),
                                               xmlWriter);
                                        } if (localZFBDTTracker){
                                            if (localZFBDT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ZFBDT cannot be null!!");
                                            }
                                           localZFBDT.serialize(new javax.xml.namespace.QName("","ZFBDT"),
                                               xmlWriter);
                                        } if (localXBLNRTracker){
                                            if (localXBLNR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("XBLNR cannot be null!!");
                                            }
                                           localXBLNR.serialize(new javax.xml.namespace.QName("","XBLNR"),
                                               xmlWriter);
                                        } if (localWRBTRTracker){
                                            if (localWRBTR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("WRBTR cannot be null!!");
                                            }
                                           localWRBTR.serialize(new javax.xml.namespace.QName("","WRBTR"),
                                               xmlWriter);
                                        } if (localWAERSTracker){
                                            if (localWAERS==null){
                                                 throw new org.apache.axis2.databinding.ADBException("WAERS cannot be null!!");
                                            }
                                           localWAERS.serialize(new javax.xml.namespace.QName("","WAERS"),
                                               xmlWriter);
                                        } if (localAUGBLTracker){
                                            if (localAUGBL==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AUGBL cannot be null!!");
                                            }
                                           localAUGBL.serialize(new javax.xml.namespace.QName("","AUGBL"),
                                               xmlWriter);
                                        } if (localAUGDTTracker){
                                            if (localAUGDT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("AUGDT cannot be null!!");
                                            }
                                           localAUGDT.serialize(new javax.xml.namespace.QName("","AUGDT"),
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

                 if (localBELNRTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "BELNR"));
                            
                            
                                    if (localBELNR==null){
                                         throw new org.apache.axis2.databinding.ADBException("BELNR cannot be null!!");
                                    }
                                    elementList.add(localBELNR);
                                } if (localBLARTTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "BLART"));
                            
                            
                                    if (localBLART==null){
                                         throw new org.apache.axis2.databinding.ADBException("BLART cannot be null!!");
                                    }
                                    elementList.add(localBLART);
                                } if (localBUDATTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "BUDAT"));
                            
                            
                                    if (localBUDAT==null){
                                         throw new org.apache.axis2.databinding.ADBException("BUDAT cannot be null!!");
                                    }
                                    elementList.add(localBUDAT);
                                } if (localZFBDTTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ZFBDT"));
                            
                            
                                    if (localZFBDT==null){
                                         throw new org.apache.axis2.databinding.ADBException("ZFBDT cannot be null!!");
                                    }
                                    elementList.add(localZFBDT);
                                } if (localXBLNRTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "XBLNR"));
                            
                            
                                    if (localXBLNR==null){
                                         throw new org.apache.axis2.databinding.ADBException("XBLNR cannot be null!!");
                                    }
                                    elementList.add(localXBLNR);
                                } if (localWRBTRTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "WRBTR"));
                            
                            
                                    if (localWRBTR==null){
                                         throw new org.apache.axis2.databinding.ADBException("WRBTR cannot be null!!");
                                    }
                                    elementList.add(localWRBTR);
                                } if (localWAERSTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "WAERS"));
                            
                            
                                    if (localWAERS==null){
                                         throw new org.apache.axis2.databinding.ADBException("WAERS cannot be null!!");
                                    }
                                    elementList.add(localWAERS);
                                } if (localAUGBLTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "AUGBL"));
                            
                            
                                    if (localAUGBL==null){
                                         throw new org.apache.axis2.databinding.ADBException("AUGBL cannot be null!!");
                                    }
                                    elementList.add(localAUGBL);
                                } if (localAUGDTTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "AUGDT"));
                            
                            
                                    if (localAUGDT==null){
                                         throw new org.apache.axis2.databinding.ADBException("AUGDT cannot be null!!");
                                    }
                                    elementList.add(localAUGDT);
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
        public static ZST_ESTADO_CUENTA parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ZST_ESTADO_CUENTA object =
                new ZST_ESTADO_CUENTA();

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
                    
                            if (!"ZST_ESTADO_CUENTA".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ZST_ESTADO_CUENTA)functions.rfc.sap.document.sap_com.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","BELNR").equals(reader.getName())){
                                
                                                object.setBELNR(functions.rfc.sap.document.sap_com.BELNR_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","BLART").equals(reader.getName())){
                                
                                                object.setBLART(functions.rfc.sap.document.sap_com.BLART_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","BUDAT").equals(reader.getName())){
                                
                                                object.setBUDAT(functions.rfc.sap.document.sap_com.Date.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ZFBDT").equals(reader.getName())){
                                
                                                object.setZFBDT(functions.rfc.sap.document.sap_com.Date.Factory.parse(reader));
                                              
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","WRBTR").equals(reader.getName())){
                                
                                                object.setWRBTR(functions.rfc.sap.document.sap_com.WRBTR_type1.Factory.parse(reader));
                                              
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
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","AUGBL").equals(reader.getName())){
                                
                                                object.setAUGBL(functions.rfc.sap.document.sap_com.AUGBL_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","AUGDT").equals(reader.getName())){
                                
                                                object.setAUGDT(functions.rfc.sap.document.sap_com.Date.Factory.parse(reader));
                                              
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
           
    