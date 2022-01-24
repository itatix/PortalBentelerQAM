
/**
 * Z_FI_AGREGAR_BUZON_FLETES.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package functions.rfc.sap.document.sap_com;
            

            /**
            *  Z_FI_AGREGAR_BUZON_FLETES bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class Z_FI_AGREGAR_BUZON_FLETES
        implements org.apache.axis2.databinding.ADBBean{
        
                public static final javax.xml.namespace.QName MY_QNAME = new javax.xml.namespace.QName(
                "urn:sap-com:document:sap:rfc:functions",
                "Z_FI_AGREGAR_BUZON_FLETES",
                "ns1");

            

                        /**
                        * field for IV_BUKRS
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.IV_BUKRS_type1 localIV_BUKRS ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIV_BUKRSTracker = false ;

                           public boolean isIV_BUKRSSpecified(){
                               return localIV_BUKRSTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.IV_BUKRS_type1
                           */
                           public  functions.rfc.sap.document.sap_com.IV_BUKRS_type1 getIV_BUKRS(){
                               return localIV_BUKRS;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_BUKRS
                               */
                               public void setIV_BUKRS(functions.rfc.sap.document.sap_com.IV_BUKRS_type1 param){
                            localIV_BUKRSTracker = param != null;
                                   
                                            this.localIV_BUKRS=param;
                                    

                               }
                            

                        /**
                        * field for IV_CONCEPTO
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.IV_CONCEPTO_type1 localIV_CONCEPTO ;
                                

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.IV_CONCEPTO_type1
                           */
                           public  functions.rfc.sap.document.sap_com.IV_CONCEPTO_type1 getIV_CONCEPTO(){
                               return localIV_CONCEPTO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_CONCEPTO
                               */
                               public void setIV_CONCEPTO(functions.rfc.sap.document.sap_com.IV_CONCEPTO_type1 param){
                            
                                            this.localIV_CONCEPTO=param;
                                    

                               }
                            

                        /**
                        * field for IV_CURRENCY
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.IV_CURRENCY_type1 localIV_CURRENCY ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIV_CURRENCYTracker = false ;

                           public boolean isIV_CURRENCYSpecified(){
                               return localIV_CURRENCYTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.IV_CURRENCY_type1
                           */
                           public  functions.rfc.sap.document.sap_com.IV_CURRENCY_type1 getIV_CURRENCY(){
                               return localIV_CURRENCY;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_CURRENCY
                               */
                               public void setIV_CURRENCY(functions.rfc.sap.document.sap_com.IV_CURRENCY_type1 param){
                            localIV_CURRENCYTracker = param != null;
                                   
                                            this.localIV_CURRENCY=param;
                                    

                               }
                            

                        /**
                        * field for IV_DESTINO
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.IV_DESTINO_type1 localIV_DESTINO ;
                                

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.IV_DESTINO_type1
                           */
                           public  functions.rfc.sap.document.sap_com.IV_DESTINO_type1 getIV_DESTINO(){
                               return localIV_DESTINO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_DESTINO
                               */
                               public void setIV_DESTINO(functions.rfc.sap.document.sap_com.IV_DESTINO_type1 param){
                            
                                            this.localIV_DESTINO=param;
                                    

                               }
                            

                        /**
                        * field for IV_FECHA_EMBAR
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.Date localIV_FECHA_EMBAR ;
                                

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.Date
                           */
                           public  functions.rfc.sap.document.sap_com.Date getIV_FECHA_EMBAR(){
                               return localIV_FECHA_EMBAR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_FECHA_EMBAR
                               */
                               public void setIV_FECHA_EMBAR(functions.rfc.sap.document.sap_com.Date param){
                            
                                            this.localIV_FECHA_EMBAR=param;
                                    

                               }
                            

                        /**
                        * field for IV_INVOICE_DATE
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.Date localIV_INVOICE_DATE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIV_INVOICE_DATETracker = false ;

                           public boolean isIV_INVOICE_DATESpecified(){
                               return localIV_INVOICE_DATETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.Date
                           */
                           public  functions.rfc.sap.document.sap_com.Date getIV_INVOICE_DATE(){
                               return localIV_INVOICE_DATE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_INVOICE_DATE
                               */
                               public void setIV_INVOICE_DATE(functions.rfc.sap.document.sap_com.Date param){
                            localIV_INVOICE_DATETracker = param != null;
                                   
                                            this.localIV_INVOICE_DATE=param;
                                    

                               }
                            

                        /**
                        * field for IV_LIFNR
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.IV_LIFNR_type1 localIV_LIFNR ;
                                

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.IV_LIFNR_type1
                           */
                           public  functions.rfc.sap.document.sap_com.IV_LIFNR_type1 getIV_LIFNR(){
                               return localIV_LIFNR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_LIFNR
                               */
                               public void setIV_LIFNR(functions.rfc.sap.document.sap_com.IV_LIFNR_type1 param){
                            
                                            this.localIV_LIFNR=param;
                                    

                               }
                            

                        /**
                        * field for IV_NO_REFER
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.IV_NO_REFER_type1 localIV_NO_REFER ;
                                

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.IV_NO_REFER_type1
                           */
                           public  functions.rfc.sap.document.sap_com.IV_NO_REFER_type1 getIV_NO_REFER(){
                               return localIV_NO_REFER;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_NO_REFER
                               */
                               public void setIV_NO_REFER(functions.rfc.sap.document.sap_com.IV_NO_REFER_type1 param){
                            
                                            this.localIV_NO_REFER=param;
                                    

                               }
                            

                        /**
                        * field for IV_NO_REMISION
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.IV_NO_REMISION_type1 localIV_NO_REMISION ;
                                

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.IV_NO_REMISION_type1
                           */
                           public  functions.rfc.sap.document.sap_com.IV_NO_REMISION_type1 getIV_NO_REMISION(){
                               return localIV_NO_REMISION;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_NO_REMISION
                               */
                               public void setIV_NO_REMISION(functions.rfc.sap.document.sap_com.IV_NO_REMISION_type1 param){
                            
                                            this.localIV_NO_REMISION=param;
                                    

                               }
                            

                        /**
                        * field for IV_OBSERVACION
                        */

                        
                                    protected java.lang.String localIV_OBSERVACION ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIV_OBSERVACIONTracker = false ;

                           public boolean isIV_OBSERVACIONSpecified(){
                               return localIV_OBSERVACIONTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return java.lang.String
                           */
                           public  java.lang.String getIV_OBSERVACION(){
                               return localIV_OBSERVACION;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_OBSERVACION
                               */
                               public void setIV_OBSERVACION(java.lang.String param){
                            localIV_OBSERVACIONTracker = param != null;
                                   
                                            this.localIV_OBSERVACION=param;
                                    

                               }
                            

                        /**
                        * field for IV_ORIGEN
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.IV_ORIGEN_type1 localIV_ORIGEN ;
                                

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.IV_ORIGEN_type1
                           */
                           public  functions.rfc.sap.document.sap_com.IV_ORIGEN_type1 getIV_ORIGEN(){
                               return localIV_ORIGEN;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_ORIGEN
                               */
                               public void setIV_ORIGEN(functions.rfc.sap.document.sap_com.IV_ORIGEN_type1 param){
                            
                                            this.localIV_ORIGEN=param;
                                    

                               }
                            

                        /**
                        * field for IV_OT_PDF_ZIP
                        */

                        
                                    protected javax.activation.DataHandler localIV_OT_PDF_ZIP ;
                                

                           /**
                           * Auto generated getter method
                           * @return javax.activation.DataHandler
                           */
                           public  javax.activation.DataHandler getIV_OT_PDF_ZIP(){
                               return localIV_OT_PDF_ZIP;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_OT_PDF_ZIP
                               */
                               public void setIV_OT_PDF_ZIP(javax.activation.DataHandler param){
                            
                                            this.localIV_OT_PDF_ZIP=param;
                                    

                               }
                            

                        /**
                        * field for IV_PDF
                        */

                        
                                    protected javax.activation.DataHandler localIV_PDF ;
                                

                           /**
                           * Auto generated getter method
                           * @return javax.activation.DataHandler
                           */
                           public  javax.activation.DataHandler getIV_PDF(){
                               return localIV_PDF;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_PDF
                               */
                               public void setIV_PDF(javax.activation.DataHandler param){
                            
                                            this.localIV_PDF=param;
                                    

                               }
                            

                        /**
                        * field for IV_REFER_EMBAR
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.IV_REFER_EMBAR_type1 localIV_REFER_EMBAR ;
                                

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.IV_REFER_EMBAR_type1
                           */
                           public  functions.rfc.sap.document.sap_com.IV_REFER_EMBAR_type1 getIV_REFER_EMBAR(){
                               return localIV_REFER_EMBAR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_REFER_EMBAR
                               */
                               public void setIV_REFER_EMBAR(functions.rfc.sap.document.sap_com.IV_REFER_EMBAR_type1 param){
                            
                                            this.localIV_REFER_EMBAR=param;
                                    

                               }
                            

                        /**
                        * field for IV_SPRAS
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.IV_SPRAS_type1 localIV_SPRAS ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIV_SPRASTracker = false ;

                           public boolean isIV_SPRASSpecified(){
                               return localIV_SPRASTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.IV_SPRAS_type1
                           */
                           public  functions.rfc.sap.document.sap_com.IV_SPRAS_type1 getIV_SPRAS(){
                               return localIV_SPRAS;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_SPRAS
                               */
                               public void setIV_SPRAS(functions.rfc.sap.document.sap_com.IV_SPRAS_type1 param){
                            localIV_SPRASTracker = param != null;
                                   
                                            this.localIV_SPRAS=param;
                                    

                               }
                            

                        /**
                        * field for IV_TIPO_FAC
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.IV_TIPO_FAC_type1 localIV_TIPO_FAC ;
                                

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.IV_TIPO_FAC_type1
                           */
                           public  functions.rfc.sap.document.sap_com.IV_TIPO_FAC_type1 getIV_TIPO_FAC(){
                               return localIV_TIPO_FAC;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_TIPO_FAC
                               */
                               public void setIV_TIPO_FAC(functions.rfc.sap.document.sap_com.IV_TIPO_FAC_type1 param){
                            
                                            this.localIV_TIPO_FAC=param;
                                    

                               }
                            

                        /**
                        * field for IV_TIPO_SER
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.IV_TIPO_SER_type1 localIV_TIPO_SER ;
                                

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.IV_TIPO_SER_type1
                           */
                           public  functions.rfc.sap.document.sap_com.IV_TIPO_SER_type1 getIV_TIPO_SER(){
                               return localIV_TIPO_SER;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_TIPO_SER
                               */
                               public void setIV_TIPO_SER(functions.rfc.sap.document.sap_com.IV_TIPO_SER_type1 param){
                            
                                            this.localIV_TIPO_SER=param;
                                    

                               }
                            

                        /**
                        * field for IV_TIPO_TRANSP
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.IV_TIPO_TRANSP_type1 localIV_TIPO_TRANSP ;
                                

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.IV_TIPO_TRANSP_type1
                           */
                           public  functions.rfc.sap.document.sap_com.IV_TIPO_TRANSP_type1 getIV_TIPO_TRANSP(){
                               return localIV_TIPO_TRANSP;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_TIPO_TRANSP
                               */
                               public void setIV_TIPO_TRANSP(functions.rfc.sap.document.sap_com.IV_TIPO_TRANSP_type1 param){
                            
                                            this.localIV_TIPO_TRANSP=param;
                                    

                               }
                            

                        /**
                        * field for IV_TOTAL_INVOICE
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.IV_TOTAL_INVOICE_type1 localIV_TOTAL_INVOICE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIV_TOTAL_INVOICETracker = false ;

                           public boolean isIV_TOTAL_INVOICESpecified(){
                               return localIV_TOTAL_INVOICETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.IV_TOTAL_INVOICE_type1
                           */
                           public  functions.rfc.sap.document.sap_com.IV_TOTAL_INVOICE_type1 getIV_TOTAL_INVOICE(){
                               return localIV_TOTAL_INVOICE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_TOTAL_INVOICE
                               */
                               public void setIV_TOTAL_INVOICE(functions.rfc.sap.document.sap_com.IV_TOTAL_INVOICE_type1 param){
                            localIV_TOTAL_INVOICETracker = param != null;
                                   
                                            this.localIV_TOTAL_INVOICE=param;
                                    

                               }
                            

                        /**
                        * field for IV_UNI_TIPO
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.IV_UNI_TIPO_type1 localIV_UNI_TIPO ;
                                

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.IV_UNI_TIPO_type1
                           */
                           public  functions.rfc.sap.document.sap_com.IV_UNI_TIPO_type1 getIV_UNI_TIPO(){
                               return localIV_UNI_TIPO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_UNI_TIPO
                               */
                               public void setIV_UNI_TIPO(functions.rfc.sap.document.sap_com.IV_UNI_TIPO_type1 param){
                            
                                            this.localIV_UNI_TIPO=param;
                                    

                               }
                            

                        /**
                        * field for IV_XML
                        */

                        
                                    protected javax.activation.DataHandler localIV_XML ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIV_XMLTracker = false ;

                           public boolean isIV_XMLSpecified(){
                               return localIV_XMLTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return javax.activation.DataHandler
                           */
                           public  javax.activation.DataHandler getIV_XML(){
                               return localIV_XML;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IV_XML
                               */
                               public void setIV_XML(javax.activation.DataHandler param){
                            localIV_XMLTracker = param != null;
                                   
                                            this.localIV_XML=param;
                                    

                               }
                            

                        /**
                        * field for IT_TICKETS
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.IT_TICKETS_type1 localIT_TICKETS ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localIT_TICKETSTracker = false ;

                           public boolean isIT_TICKETSSpecified(){
                               return localIT_TICKETSTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.IT_TICKETS_type1
                           */
                           public  functions.rfc.sap.document.sap_com.IT_TICKETS_type1 getIT_TICKETS(){
                               return localIT_TICKETS;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param IT_TICKETS
                               */
                               public void setIT_TICKETS(functions.rfc.sap.document.sap_com.IT_TICKETS_type1 param){
                            localIT_TICKETSTracker = param != null;
                                   
                                            this.localIT_TICKETS=param;
                                    

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
                           namespacePrefix+":Z_FI_AGREGAR_BUZON_FLETES",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "Z_FI_AGREGAR_BUZON_FLETES",
                           xmlWriter);
                   }

               
                   }
                if (localIV_BUKRSTracker){
                                            if (localIV_BUKRS==null){
                                                 throw new org.apache.axis2.databinding.ADBException("IV_BUKRS cannot be null!!");
                                            }
                                           localIV_BUKRS.serialize(new javax.xml.namespace.QName("","IV_BUKRS"),
                                               xmlWriter);
                                        }
                                            if (localIV_CONCEPTO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("IV_CONCEPTO cannot be null!!");
                                            }
                                           localIV_CONCEPTO.serialize(new javax.xml.namespace.QName("","IV_CONCEPTO"),
                                               xmlWriter);
                                         if (localIV_CURRENCYTracker){
                                            if (localIV_CURRENCY==null){
                                                 throw new org.apache.axis2.databinding.ADBException("IV_CURRENCY cannot be null!!");
                                            }
                                           localIV_CURRENCY.serialize(new javax.xml.namespace.QName("","IV_CURRENCY"),
                                               xmlWriter);
                                        }
                                            if (localIV_DESTINO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("IV_DESTINO cannot be null!!");
                                            }
                                           localIV_DESTINO.serialize(new javax.xml.namespace.QName("","IV_DESTINO"),
                                               xmlWriter);
                                        
                                            if (localIV_FECHA_EMBAR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("IV_FECHA_EMBAR cannot be null!!");
                                            }
                                           localIV_FECHA_EMBAR.serialize(new javax.xml.namespace.QName("","IV_FECHA_EMBAR"),
                                               xmlWriter);
                                         if (localIV_INVOICE_DATETracker){
                                            if (localIV_INVOICE_DATE==null){
//                                                 throw new org.apache.axis2.databinding.ADBException("IV_INVOICE_DATE cannot be null!!");
                                            } else
                                           localIV_INVOICE_DATE.serialize(new javax.xml.namespace.QName("","IV_INVOICE_DATE"),
                                               xmlWriter);
                                        }
                                            if (localIV_LIFNR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("IV_LIFNR cannot be null!!");
                                            }
                                           localIV_LIFNR.serialize(new javax.xml.namespace.QName("","IV_LIFNR"),
                                               xmlWriter);
                                        
                                            if (localIV_NO_REFER==null){
                                                 throw new org.apache.axis2.databinding.ADBException("IV_NO_REFER cannot be null!!");
                                            }
                                           localIV_NO_REFER.serialize(new javax.xml.namespace.QName("","IV_NO_REFER"),
                                               xmlWriter);
                                        
                                            if (localIV_NO_REMISION==null){
                                                 throw new org.apache.axis2.databinding.ADBException("IV_NO_REMISION cannot be null!!");
                                            }
                                           localIV_NO_REMISION.serialize(new javax.xml.namespace.QName("","IV_NO_REMISION"),
                                               xmlWriter);
                                         if (localIV_OBSERVACIONTracker){
                                    namespace = "";
                                    writeStartElement(null, namespace, "IV_OBSERVACION", xmlWriter);
                             

                                          if (localIV_OBSERVACION==null){
                                              // write the nil attribute
                                              
                                                     throw new org.apache.axis2.databinding.ADBException("IV_OBSERVACION cannot be null!!");
                                                  
                                          }else{

                                        
                                                   xmlWriter.writeCharacters(localIV_OBSERVACION);
                                            
                                          }
                                    
                                   xmlWriter.writeEndElement();
                             }
                                            if (localIV_ORIGEN==null){
                                                 throw new org.apache.axis2.databinding.ADBException("IV_ORIGEN cannot be null!!");
                                            }
                                           localIV_ORIGEN.serialize(new javax.xml.namespace.QName("","IV_ORIGEN"),
                                               xmlWriter);
                                        
                                    namespace = "";
                                    writeStartElement(null, namespace, "IV_OT_PDF_ZIP", xmlWriter);
                             
                                        
                                    if (localIV_OT_PDF_ZIP!=null)  {
                                       try {
                                           org.apache.axiom.util.stax.XMLStreamWriterUtils.writeDataHandler(xmlWriter, localIV_OT_PDF_ZIP, null, true);
                                       } catch (java.io.IOException ex) {
                                           throw new javax.xml.stream.XMLStreamException("Unable to read data handler for IV_OT_PDF_ZIP", ex);
                                       }
                                    } else {
                                         
                                    }
                                 
                                   xmlWriter.writeEndElement();
                             
                                    namespace = "";
                                    writeStartElement(null, namespace, "IV_PDF", xmlWriter);
                             
                                        
                                    if (localIV_PDF!=null)  {
                                       try {
                                           org.apache.axiom.util.stax.XMLStreamWriterUtils.writeDataHandler(xmlWriter, localIV_PDF, null, true);
                                       } catch (java.io.IOException ex) {
                                           throw new javax.xml.stream.XMLStreamException("Unable to read data handler for IV_PDF", ex);
                                       }
                                    } else {
                                         
                                    }
                                 
                                   xmlWriter.writeEndElement();
                             
                                            if (localIV_REFER_EMBAR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("IV_REFER_EMBAR cannot be null!!");
                                            }
                                           localIV_REFER_EMBAR.serialize(new javax.xml.namespace.QName("","IV_REFER_EMBAR"),
                                               xmlWriter);
                                         if (localIV_SPRASTracker){
                                            if (localIV_SPRAS==null){
                                                 throw new org.apache.axis2.databinding.ADBException("IV_SPRAS cannot be null!!");
                                            }
                                           localIV_SPRAS.serialize(new javax.xml.namespace.QName("","IV_SPRAS"),
                                               xmlWriter);
                                        }
                                            if (localIV_TIPO_FAC==null){
//                                                 throw new org.apache.axis2.databinding.ADBException("IV_TIPO_FAC cannot be null!!");
                                            } else 
                                           localIV_TIPO_FAC.serialize(new javax.xml.namespace.QName("","IV_TIPO_FAC"),
                                               xmlWriter);
                                        
                                            if (localIV_TIPO_SER==null){
//                                                 throw new org.apache.axis2.databinding.ADBException("IV_TIPO_SER cannot be null!!");
                                            } else 
                                           localIV_TIPO_SER.serialize(new javax.xml.namespace.QName("","IV_TIPO_SER"),
                                               xmlWriter);
                                        
                                            if (localIV_TIPO_TRANSP==null){
//                                                 throw new org.apache.axis2.databinding.ADBException("IV_TIPO_TRANSP cannot be null!!");
                                            } else 
                                           localIV_TIPO_TRANSP.serialize(new javax.xml.namespace.QName("","IV_TIPO_TRANSP"),
                                               xmlWriter);
                                         if (localIV_TOTAL_INVOICETracker){
                                            if (localIV_TOTAL_INVOICE==null){
//                                                 throw new org.apache.axis2.databinding.ADBException("IV_TOTAL_INVOICE cannot be null!!");
                                            } else 
                                           localIV_TOTAL_INVOICE.serialize(new javax.xml.namespace.QName("","IV_TOTAL_INVOICE"),
                                               xmlWriter);
                                        }
                                            if (localIV_UNI_TIPO==null){
//                                                 throw new org.apache.axis2.databinding.ADBException("IV_UNI_TIPO cannot be null!!");
                                            } else 
                                           localIV_UNI_TIPO.serialize(new javax.xml.namespace.QName("","IV_UNI_TIPO"),
                                               xmlWriter);
                                         if (localIV_XMLTracker){
                                    namespace = "";
                                    writeStartElement(null, namespace, "IV_XML", xmlWriter);
                             
                                        
                                    if (localIV_XML!=null)  {
                                       try {
                                           org.apache.axiom.util.stax.XMLStreamWriterUtils.writeDataHandler(xmlWriter, localIV_XML, null, true);
                                       } catch (java.io.IOException ex) {
                                           throw new javax.xml.stream.XMLStreamException("Unable to read data handler for IV_XML", ex);
                                       }
                                    } else {
                                         
                                    }
                                 
                                   xmlWriter.writeEndElement();
                             } if (localIT_TICKETSTracker){
                                            if (localIT_TICKETS==null){
//                                                 throw new org.apache.axis2.databinding.ADBException("IT_TICKETS cannot be null!!");
                                            } else 
                                           localIT_TICKETS.serialize(new javax.xml.namespace.QName("","IT_TICKETS"),
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

                 if (localIV_BUKRSTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_BUKRS"));
                            
                            
                                    if (localIV_BUKRS==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_BUKRS cannot be null!!");
                                    }
                                    elementList.add(localIV_BUKRS);
                                }
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_CONCEPTO"));
                            
                            
                                    if (localIV_CONCEPTO==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_CONCEPTO cannot be null!!");
                                    }
                                    elementList.add(localIV_CONCEPTO);
                                 if (localIV_CURRENCYTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_CURRENCY"));
                            
                            
                                    if (localIV_CURRENCY==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_CURRENCY cannot be null!!");
                                    }
                                    elementList.add(localIV_CURRENCY);
                                }
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_DESTINO"));
                            
                            
                                    if (localIV_DESTINO==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_DESTINO cannot be null!!");
                                    }
                                    elementList.add(localIV_DESTINO);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_FECHA_EMBAR"));
                            
                            
                                    if (localIV_FECHA_EMBAR==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_FECHA_EMBAR cannot be null!!");
                                    }
                                    elementList.add(localIV_FECHA_EMBAR);
                                 if (localIV_INVOICE_DATETracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_INVOICE_DATE"));
                            
                            
                                    if (localIV_INVOICE_DATE==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_INVOICE_DATE cannot be null!!");
                                    }
                                    elementList.add(localIV_INVOICE_DATE);
                                }
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_LIFNR"));
                            
                            
                                    if (localIV_LIFNR==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_LIFNR cannot be null!!");
                                    }
                                    elementList.add(localIV_LIFNR);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_NO_REFER"));
                            
                            
                                    if (localIV_NO_REFER==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_NO_REFER cannot be null!!");
                                    }
                                    elementList.add(localIV_NO_REFER);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_NO_REMISION"));
                            
                            
                                    if (localIV_NO_REMISION==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_NO_REMISION cannot be null!!");
                                    }
                                    elementList.add(localIV_NO_REMISION);
                                 if (localIV_OBSERVACIONTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_OBSERVACION"));
                                 
                                        if (localIV_OBSERVACION != null){
                                            elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(localIV_OBSERVACION));
                                        } else {
                                           throw new org.apache.axis2.databinding.ADBException("IV_OBSERVACION cannot be null!!");
                                        }
                                    }
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_ORIGEN"));
                            
                            
                                    if (localIV_ORIGEN==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_ORIGEN cannot be null!!");
                                    }
                                    elementList.add(localIV_ORIGEN);
                                
                                      elementList.add(new javax.xml.namespace.QName("",
                                        "IV_OT_PDF_ZIP"));
                                
                            elementList.add(localIV_OT_PDF_ZIP);
                        
                                      elementList.add(new javax.xml.namespace.QName("",
                                        "IV_PDF"));
                                
                            elementList.add(localIV_PDF);
                        
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_REFER_EMBAR"));
                            
                            
                                    if (localIV_REFER_EMBAR==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_REFER_EMBAR cannot be null!!");
                                    }
                                    elementList.add(localIV_REFER_EMBAR);
                                 if (localIV_SPRASTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_SPRAS"));
                            
                            
                                    if (localIV_SPRAS==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_SPRAS cannot be null!!");
                                    }
                                    elementList.add(localIV_SPRAS);
                                }
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_TIPO_FAC"));
                            
                            
                                    if (localIV_TIPO_FAC==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_TIPO_FAC cannot be null!!");
                                    }
                                    elementList.add(localIV_TIPO_FAC);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_TIPO_SER"));
                            
                            
                                    if (localIV_TIPO_SER==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_TIPO_SER cannot be null!!");
                                    }
                                    elementList.add(localIV_TIPO_SER);
                                
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_TIPO_TRANSP"));
                            
                            
                                    if (localIV_TIPO_TRANSP==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_TIPO_TRANSP cannot be null!!");
                                    }
                                    elementList.add(localIV_TIPO_TRANSP);
                                 if (localIV_TOTAL_INVOICETracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_TOTAL_INVOICE"));
                            
                            
                                    if (localIV_TOTAL_INVOICE==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_TOTAL_INVOICE cannot be null!!");
                                    }
                                    elementList.add(localIV_TOTAL_INVOICE);
                                }
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IV_UNI_TIPO"));
                            
                            
                                    if (localIV_UNI_TIPO==null){
                                         throw new org.apache.axis2.databinding.ADBException("IV_UNI_TIPO cannot be null!!");
                                    }
                                    elementList.add(localIV_UNI_TIPO);
                                 if (localIV_XMLTracker){
                                      elementList.add(new javax.xml.namespace.QName("",
                                        "IV_XML"));
                                
                            elementList.add(localIV_XML);
                        } if (localIT_TICKETSTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "IT_TICKETS"));
                            
                            
                                    if (localIT_TICKETS==null){
                                         throw new org.apache.axis2.databinding.ADBException("IT_TICKETS cannot be null!!");
                                    }
                                    elementList.add(localIT_TICKETS);
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
        public static Z_FI_AGREGAR_BUZON_FLETES parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            Z_FI_AGREGAR_BUZON_FLETES object =
                new Z_FI_AGREGAR_BUZON_FLETES();

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
                    
                            if (!"Z_FI_AGREGAR_BUZON_FLETES".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (Z_FI_AGREGAR_BUZON_FLETES)functions.rfc.sap.document.sap_com.ExtensionMapper.getTypeObject(
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
                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_BUKRS").equals(reader.getName())){
                                
                                                object.setIV_BUKRS(functions.rfc.sap.document.sap_com.IV_BUKRS_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_CONCEPTO").equals(reader.getName())){
                                
                                                object.setIV_CONCEPTO(functions.rfc.sap.document.sap_com.IV_CONCEPTO_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_CURRENCY").equals(reader.getName())){
                                
                                                object.setIV_CURRENCY(functions.rfc.sap.document.sap_com.IV_CURRENCY_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_DESTINO").equals(reader.getName())){
                                
                                                object.setIV_DESTINO(functions.rfc.sap.document.sap_com.IV_DESTINO_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_FECHA_EMBAR").equals(reader.getName())){
                                
                                                object.setIV_FECHA_EMBAR(functions.rfc.sap.document.sap_com.Date.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_INVOICE_DATE").equals(reader.getName())){
                                
                                                object.setIV_INVOICE_DATE(functions.rfc.sap.document.sap_com.Date.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_LIFNR").equals(reader.getName())){
                                
                                                object.setIV_LIFNR(functions.rfc.sap.document.sap_com.IV_LIFNR_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_NO_REFER").equals(reader.getName())){
                                
                                                object.setIV_NO_REFER(functions.rfc.sap.document.sap_com.IV_NO_REFER_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_NO_REMISION").equals(reader.getName())){
                                
                                                object.setIV_NO_REMISION(functions.rfc.sap.document.sap_com.IV_NO_REMISION_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_OBSERVACION").equals(reader.getName())){
                                
                                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance","nil");
                                    if ("true".equals(nillableValue) || "1".equals(nillableValue)){
                                        throw new org.apache.axis2.databinding.ADBException("The element: "+"IV_OBSERVACION" +"  cannot be null");
                                    }
                                    

                                    java.lang.String content = reader.getElementText();
                                    
                                              object.setIV_OBSERVACION(
                                                    org.apache.axis2.databinding.utils.ConverterUtil.convertToString(content));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_ORIGEN").equals(reader.getName())){
                                
                                                object.setIV_ORIGEN(functions.rfc.sap.document.sap_com.IV_ORIGEN_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_OT_PDF_ZIP").equals(reader.getName())){
                                
                                            object.setIV_OT_PDF_ZIP(org.apache.axiom.util.stax.XMLStreamReaderUtils.getDataHandlerFromElement(reader));
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_PDF").equals(reader.getName())){
                                
                                            object.setIV_PDF(org.apache.axiom.util.stax.XMLStreamReaderUtils.getDataHandlerFromElement(reader));
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_REFER_EMBAR").equals(reader.getName())){
                                
                                                object.setIV_REFER_EMBAR(functions.rfc.sap.document.sap_com.IV_REFER_EMBAR_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_SPRAS").equals(reader.getName())){
                                
                                                object.setIV_SPRAS(functions.rfc.sap.document.sap_com.IV_SPRAS_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_TIPO_FAC").equals(reader.getName())){
                                
                                                object.setIV_TIPO_FAC(functions.rfc.sap.document.sap_com.IV_TIPO_FAC_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_TIPO_SER").equals(reader.getName())){
                                
                                                object.setIV_TIPO_SER(functions.rfc.sap.document.sap_com.IV_TIPO_SER_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_TIPO_TRANSP").equals(reader.getName())){
                                
                                                object.setIV_TIPO_TRANSP(functions.rfc.sap.document.sap_com.IV_TIPO_TRANSP_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_TOTAL_INVOICE").equals(reader.getName())){
                                
                                                object.setIV_TOTAL_INVOICE(functions.rfc.sap.document.sap_com.IV_TOTAL_INVOICE_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_UNI_TIPO").equals(reader.getName())){
                                
                                                object.setIV_UNI_TIPO(functions.rfc.sap.document.sap_com.IV_UNI_TIPO_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IV_XML").equals(reader.getName())){
                                
                                            object.setIV_XML(org.apache.axiom.util.stax.XMLStreamReaderUtils.getDataHandlerFromElement(reader));
                                      
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                        else
                                    
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","IT_TICKETS").equals(reader.getName())){
                                
                                                object.setIT_TICKETS(functions.rfc.sap.document.sap_com.IT_TICKETS_type1.Factory.parse(reader));
                                              
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
           
    