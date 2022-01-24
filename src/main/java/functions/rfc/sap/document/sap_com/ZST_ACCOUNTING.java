
/**
 * ZST_ACCOUNTING.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

            
                package functions.rfc.sap.document.sap_com;
            

            /**
            *  ZST_ACCOUNTING bean class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ZST_ACCOUNTING
        implements org.apache.axis2.databinding.ADBBean{
        /* This type was generated from the piece of schema that had
                name = ZST_ACCOUNTING
                Namespace URI = urn:sap-com:document:sap:rfc:functions
                Namespace Prefix = ns1
                */
            

                        /**
                        * field for INVOICE_DOC_ITEM
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.INVOICE_DOC_ITEM_type1 localINVOICE_DOC_ITEM ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localINVOICE_DOC_ITEMTracker = false ;

                           public boolean isINVOICE_DOC_ITEMSpecified(){
                               return localINVOICE_DOC_ITEMTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.INVOICE_DOC_ITEM_type1
                           */
                           public  functions.rfc.sap.document.sap_com.INVOICE_DOC_ITEM_type1 getINVOICE_DOC_ITEM(){
                               return localINVOICE_DOC_ITEM;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param INVOICE_DOC_ITEM
                               */
                               public void setINVOICE_DOC_ITEM(functions.rfc.sap.document.sap_com.INVOICE_DOC_ITEM_type1 param){
                            localINVOICE_DOC_ITEMTracker = param != null;
                                   
                                            this.localINVOICE_DOC_ITEM=param;
                                    

                               }
                            

                        /**
                        * field for GL_ACCOUNT
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.GL_ACCOUNT_type1 localGL_ACCOUNT ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGL_ACCOUNTTracker = false ;

                           public boolean isGL_ACCOUNTSpecified(){
                               return localGL_ACCOUNTTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.GL_ACCOUNT_type1
                           */
                           public  functions.rfc.sap.document.sap_com.GL_ACCOUNT_type1 getGL_ACCOUNT(){
                               return localGL_ACCOUNT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GL_ACCOUNT
                               */
                               public void setGL_ACCOUNT(functions.rfc.sap.document.sap_com.GL_ACCOUNT_type1 param){
                            localGL_ACCOUNTTracker = param != null;
                                   
                                            this.localGL_ACCOUNT=param;
                                    

                               }
                            

                        /**
                        * field for ITEM_AMOUNT
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.ITEM_AMOUNT_type1 localITEM_AMOUNT ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localITEM_AMOUNTTracker = false ;

                           public boolean isITEM_AMOUNTSpecified(){
                               return localITEM_AMOUNTTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.ITEM_AMOUNT_type1
                           */
                           public  functions.rfc.sap.document.sap_com.ITEM_AMOUNT_type1 getITEM_AMOUNT(){
                               return localITEM_AMOUNT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ITEM_AMOUNT
                               */
                               public void setITEM_AMOUNT(functions.rfc.sap.document.sap_com.ITEM_AMOUNT_type1 param){
                            localITEM_AMOUNTTracker = param != null;
                                   
                                            this.localITEM_AMOUNT=param;
                                    

                               }
                            

                        /**
                        * field for DB_CR_IND
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.DB_CR_IND_type1 localDB_CR_IND ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localDB_CR_INDTracker = false ;

                           public boolean isDB_CR_INDSpecified(){
                               return localDB_CR_INDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.DB_CR_IND_type1
                           */
                           public  functions.rfc.sap.document.sap_com.DB_CR_IND_type1 getDB_CR_IND(){
                               return localDB_CR_IND;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param DB_CR_IND
                               */
                               public void setDB_CR_IND(functions.rfc.sap.document.sap_com.DB_CR_IND_type1 param){
                            localDB_CR_INDTracker = param != null;
                                   
                                            this.localDB_CR_IND=param;
                                    

                               }
                            

                        /**
                        * field for NEG_POSTNG
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.NEG_POSTNG_type1 localNEG_POSTNG ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNEG_POSTNGTracker = false ;

                           public boolean isNEG_POSTNGSpecified(){
                               return localNEG_POSTNGTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.NEG_POSTNG_type1
                           */
                           public  functions.rfc.sap.document.sap_com.NEG_POSTNG_type1 getNEG_POSTNG(){
                               return localNEG_POSTNG;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NEG_POSTNG
                               */
                               public void setNEG_POSTNG(functions.rfc.sap.document.sap_com.NEG_POSTNG_type1 param){
                            localNEG_POSTNGTracker = param != null;
                                   
                                            this.localNEG_POSTNG=param;
                                    

                               }
                            

                        /**
                        * field for COMP_CODE
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.COMP_CODE_type1 localCOMP_CODE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCOMP_CODETracker = false ;

                           public boolean isCOMP_CODESpecified(){
                               return localCOMP_CODETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.COMP_CODE_type1
                           */
                           public  functions.rfc.sap.document.sap_com.COMP_CODE_type1 getCOMP_CODE(){
                               return localCOMP_CODE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param COMP_CODE
                               */
                               public void setCOMP_CODE(functions.rfc.sap.document.sap_com.COMP_CODE_type1 param){
                            localCOMP_CODETracker = param != null;
                                   
                                            this.localCOMP_CODE=param;
                                    

                               }
                            

                        /**
                        * field for TAX_CODE
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.TAX_CODE_type1 localTAX_CODE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTAX_CODETracker = false ;

                           public boolean isTAX_CODESpecified(){
                               return localTAX_CODETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.TAX_CODE_type1
                           */
                           public  functions.rfc.sap.document.sap_com.TAX_CODE_type1 getTAX_CODE(){
                               return localTAX_CODE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TAX_CODE
                               */
                               public void setTAX_CODE(functions.rfc.sap.document.sap_com.TAX_CODE_type1 param){
                            localTAX_CODETracker = param != null;
                                   
                                            this.localTAX_CODE=param;
                                    

                               }
                            

                        /**
                        * field for TAXJURCODE
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.TAXJURCODE_type1 localTAXJURCODE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTAXJURCODETracker = false ;

                           public boolean isTAXJURCODESpecified(){
                               return localTAXJURCODETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.TAXJURCODE_type1
                           */
                           public  functions.rfc.sap.document.sap_com.TAXJURCODE_type1 getTAXJURCODE(){
                               return localTAXJURCODE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TAXJURCODE
                               */
                               public void setTAXJURCODE(functions.rfc.sap.document.sap_com.TAXJURCODE_type1 param){
                            localTAXJURCODETracker = param != null;
                                   
                                            this.localTAXJURCODE=param;
                                    

                               }
                            

                        /**
                        * field for ITEM_TEXT
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.ITEM_TEXT_type1 localITEM_TEXT ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localITEM_TEXTTracker = false ;

                           public boolean isITEM_TEXTSpecified(){
                               return localITEM_TEXTTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.ITEM_TEXT_type1
                           */
                           public  functions.rfc.sap.document.sap_com.ITEM_TEXT_type1 getITEM_TEXT(){
                               return localITEM_TEXT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ITEM_TEXT
                               */
                               public void setITEM_TEXT(functions.rfc.sap.document.sap_com.ITEM_TEXT_type1 param){
                            localITEM_TEXTTracker = param != null;
                                   
                                            this.localITEM_TEXT=param;
                                    

                               }
                            

                        /**
                        * field for COSTCENTER
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.COSTCENTER_type1 localCOSTCENTER ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCOSTCENTERTracker = false ;

                           public boolean isCOSTCENTERSpecified(){
                               return localCOSTCENTERTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.COSTCENTER_type1
                           */
                           public  functions.rfc.sap.document.sap_com.COSTCENTER_type1 getCOSTCENTER(){
                               return localCOSTCENTER;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param COSTCENTER
                               */
                               public void setCOSTCENTER(functions.rfc.sap.document.sap_com.COSTCENTER_type1 param){
                            localCOSTCENTERTracker = param != null;
                                   
                                            this.localCOSTCENTER=param;
                                    

                               }
                            

                        /**
                        * field for SD_DOC
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.SD_DOC_type1 localSD_DOC ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSD_DOCTracker = false ;

                           public boolean isSD_DOCSpecified(){
                               return localSD_DOCTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.SD_DOC_type1
                           */
                           public  functions.rfc.sap.document.sap_com.SD_DOC_type1 getSD_DOC(){
                               return localSD_DOC;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SD_DOC
                               */
                               public void setSD_DOC(functions.rfc.sap.document.sap_com.SD_DOC_type1 param){
                            localSD_DOCTracker = param != null;
                                   
                                            this.localSD_DOC=param;
                                    

                               }
                            

                        /**
                        * field for SDOC_ITEM
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.SDOC_ITEM_type1 localSDOC_ITEM ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localSDOC_ITEMTracker = false ;

                           public boolean isSDOC_ITEMSpecified(){
                               return localSDOC_ITEMTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.SDOC_ITEM_type1
                           */
                           public  functions.rfc.sap.document.sap_com.SDOC_ITEM_type1 getSDOC_ITEM(){
                               return localSDOC_ITEM;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param SDOC_ITEM
                               */
                               public void setSDOC_ITEM(functions.rfc.sap.document.sap_com.SDOC_ITEM_type1 param){
                            localSDOC_ITEMTracker = param != null;
                                   
                                            this.localSDOC_ITEM=param;
                                    

                               }
                            

                        /**
                        * field for ORDERID
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.ORDERID_type1 localORDERID ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localORDERIDTracker = false ;

                           public boolean isORDERIDSpecified(){
                               return localORDERIDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.ORDERID_type1
                           */
                           public  functions.rfc.sap.document.sap_com.ORDERID_type1 getORDERID(){
                               return localORDERID;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ORDERID
                               */
                               public void setORDERID(functions.rfc.sap.document.sap_com.ORDERID_type1 param){
                            localORDERIDTracker = param != null;
                                   
                                            this.localORDERID=param;
                                    

                               }
                            

                        /**
                        * field for REF_DATE
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.Date localREF_DATE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localREF_DATETracker = false ;

                           public boolean isREF_DATESpecified(){
                               return localREF_DATETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.Date
                           */
                           public  functions.rfc.sap.document.sap_com.Date getREF_DATE(){
                               return localREF_DATE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param REF_DATE
                               */
                               public void setREF_DATE(functions.rfc.sap.document.sap_com.Date param){
                            localREF_DATETracker = param != null;
                                   
                                            this.localREF_DATE=param;
                                    

                               }
                            

                        /**
                        * field for CMMT_ITEM
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.CMMT_ITEM_type1 localCMMT_ITEM ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCMMT_ITEMTracker = false ;

                           public boolean isCMMT_ITEMSpecified(){
                               return localCMMT_ITEMTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.CMMT_ITEM_type1
                           */
                           public  functions.rfc.sap.document.sap_com.CMMT_ITEM_type1 getCMMT_ITEM(){
                               return localCMMT_ITEM;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CMMT_ITEM
                               */
                               public void setCMMT_ITEM(functions.rfc.sap.document.sap_com.CMMT_ITEM_type1 param){
                            localCMMT_ITEMTracker = param != null;
                                   
                                            this.localCMMT_ITEM=param;
                                    

                               }
                            

                        /**
                        * field for FUNDS_CTR
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.FUNDS_CTR_type1 localFUNDS_CTR ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFUNDS_CTRTracker = false ;

                           public boolean isFUNDS_CTRSpecified(){
                               return localFUNDS_CTRTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.FUNDS_CTR_type1
                           */
                           public  functions.rfc.sap.document.sap_com.FUNDS_CTR_type1 getFUNDS_CTR(){
                               return localFUNDS_CTR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FUNDS_CTR
                               */
                               public void setFUNDS_CTR(functions.rfc.sap.document.sap_com.FUNDS_CTR_type1 param){
                            localFUNDS_CTRTracker = param != null;
                                   
                                            this.localFUNDS_CTR=param;
                                    

                               }
                            

                        /**
                        * field for FUNC_AREA
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.FUNC_AREA_type1 localFUNC_AREA ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFUNC_AREATracker = false ;

                           public boolean isFUNC_AREASpecified(){
                               return localFUNC_AREATracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.FUNC_AREA_type1
                           */
                           public  functions.rfc.sap.document.sap_com.FUNC_AREA_type1 getFUNC_AREA(){
                               return localFUNC_AREA;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FUNC_AREA
                               */
                               public void setFUNC_AREA(functions.rfc.sap.document.sap_com.FUNC_AREA_type1 param){
                            localFUNC_AREATracker = param != null;
                                   
                                            this.localFUNC_AREA=param;
                                    

                               }
                            

                        /**
                        * field for PROFIT_CTR
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.PROFIT_CTR_type1 localPROFIT_CTR ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPROFIT_CTRTracker = false ;

                           public boolean isPROFIT_CTRSpecified(){
                               return localPROFIT_CTRTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.PROFIT_CTR_type1
                           */
                           public  functions.rfc.sap.document.sap_com.PROFIT_CTR_type1 getPROFIT_CTR(){
                               return localPROFIT_CTR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PROFIT_CTR
                               */
                               public void setPROFIT_CTR(functions.rfc.sap.document.sap_com.PROFIT_CTR_type1 param){
                            localPROFIT_CTRTracker = param != null;
                                   
                                            this.localPROFIT_CTR=param;
                                    

                               }
                            

                        /**
                        * field for FUND
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.FUND_type1 localFUND ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFUNDTracker = false ;

                           public boolean isFUNDSpecified(){
                               return localFUNDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.FUND_type1
                           */
                           public  functions.rfc.sap.document.sap_com.FUND_type1 getFUND(){
                               return localFUND;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FUND
                               */
                               public void setFUND(functions.rfc.sap.document.sap_com.FUND_type1 param){
                            localFUNDTracker = param != null;
                                   
                                            this.localFUND=param;
                                    

                               }
                            

                        /**
                        * field for BUS_AREA
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.BUS_AREA_type1 localBUS_AREA ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBUS_AREATracker = false ;

                           public boolean isBUS_AREASpecified(){
                               return localBUS_AREATracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.BUS_AREA_type1
                           */
                           public  functions.rfc.sap.document.sap_com.BUS_AREA_type1 getBUS_AREA(){
                               return localBUS_AREA;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BUS_AREA
                               */
                               public void setBUS_AREA(functions.rfc.sap.document.sap_com.BUS_AREA_type1 param){
                            localBUS_AREATracker = param != null;
                                   
                                            this.localBUS_AREA=param;
                                    

                               }
                            

                        /**
                        * field for TR_PART_BA
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.TR_PART_BA_type1 localTR_PART_BA ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTR_PART_BATracker = false ;

                           public boolean isTR_PART_BASpecified(){
                               return localTR_PART_BATracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.TR_PART_BA_type1
                           */
                           public  functions.rfc.sap.document.sap_com.TR_PART_BA_type1 getTR_PART_BA(){
                               return localTR_PART_BA;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TR_PART_BA
                               */
                               public void setTR_PART_BA(functions.rfc.sap.document.sap_com.TR_PART_BA_type1 param){
                            localTR_PART_BATracker = param != null;
                                   
                                            this.localTR_PART_BA=param;
                                    

                               }
                            

                        /**
                        * field for COSTOBJECT
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.COSTOBJECT_type1 localCOSTOBJECT ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCOSTOBJECTTracker = false ;

                           public boolean isCOSTOBJECTSpecified(){
                               return localCOSTOBJECTTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.COSTOBJECT_type1
                           */
                           public  functions.rfc.sap.document.sap_com.COSTOBJECT_type1 getCOSTOBJECT(){
                               return localCOSTOBJECT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param COSTOBJECT
                               */
                               public void setCOSTOBJECT(functions.rfc.sap.document.sap_com.COSTOBJECT_type1 param){
                            localCOSTOBJECTTracker = param != null;
                                   
                                            this.localCOSTOBJECT=param;
                                    

                               }
                            

                        /**
                        * field for NETWORK
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.NETWORK_type1 localNETWORK ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localNETWORKTracker = false ;

                           public boolean isNETWORKSpecified(){
                               return localNETWORKTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.NETWORK_type1
                           */
                           public  functions.rfc.sap.document.sap_com.NETWORK_type1 getNETWORK(){
                               return localNETWORK;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param NETWORK
                               */
                               public void setNETWORK(functions.rfc.sap.document.sap_com.NETWORK_type1 param){
                            localNETWORKTracker = param != null;
                                   
                                            this.localNETWORK=param;
                                    

                               }
                            

                        /**
                        * field for ACTIVITY
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.ACTIVITY_type1 localACTIVITY ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localACTIVITYTracker = false ;

                           public boolean isACTIVITYSpecified(){
                               return localACTIVITYTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.ACTIVITY_type1
                           */
                           public  functions.rfc.sap.document.sap_com.ACTIVITY_type1 getACTIVITY(){
                               return localACTIVITY;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ACTIVITY
                               */
                               public void setACTIVITY(functions.rfc.sap.document.sap_com.ACTIVITY_type1 param){
                            localACTIVITYTracker = param != null;
                                   
                                            this.localACTIVITY=param;
                                    

                               }
                            

                        /**
                        * field for WBS_ELEM
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.WBS_ELEM_type1 localWBS_ELEM ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localWBS_ELEMTracker = false ;

                           public boolean isWBS_ELEMSpecified(){
                               return localWBS_ELEMTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.WBS_ELEM_type1
                           */
                           public  functions.rfc.sap.document.sap_com.WBS_ELEM_type1 getWBS_ELEM(){
                               return localWBS_ELEM;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param WBS_ELEM
                               */
                               public void setWBS_ELEM(functions.rfc.sap.document.sap_com.WBS_ELEM_type1 param){
                            localWBS_ELEMTracker = param != null;
                                   
                                            this.localWBS_ELEM=param;
                                    

                               }
                            

                        /**
                        * field for ACTTYPE
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.ACTTYPE_type1 localACTTYPE ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localACTTYPETracker = false ;

                           public boolean isACTTYPESpecified(){
                               return localACTTYPETracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.ACTTYPE_type1
                           */
                           public  functions.rfc.sap.document.sap_com.ACTTYPE_type1 getACTTYPE(){
                               return localACTTYPE;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ACTTYPE
                               */
                               public void setACTTYPE(functions.rfc.sap.document.sap_com.ACTTYPE_type1 param){
                            localACTTYPETracker = param != null;
                                   
                                            this.localACTTYPE=param;
                                    

                               }
                            

                        /**
                        * field for RL_EST_KEY
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.RL_EST_KEY_type1 localRL_EST_KEY ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localRL_EST_KEYTracker = false ;

                           public boolean isRL_EST_KEYSpecified(){
                               return localRL_EST_KEYTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.RL_EST_KEY_type1
                           */
                           public  functions.rfc.sap.document.sap_com.RL_EST_KEY_type1 getRL_EST_KEY(){
                               return localRL_EST_KEY;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param RL_EST_KEY
                               */
                               public void setRL_EST_KEY(functions.rfc.sap.document.sap_com.RL_EST_KEY_type1 param){
                            localRL_EST_KEYTracker = param != null;
                                   
                                            this.localRL_EST_KEY=param;
                                    

                               }
                            

                        /**
                        * field for PERSON_NO
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.PERSON_NO_type1 localPERSON_NO ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPERSON_NOTracker = false ;

                           public boolean isPERSON_NOSpecified(){
                               return localPERSON_NOTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.PERSON_NO_type1
                           */
                           public  functions.rfc.sap.document.sap_com.PERSON_NO_type1 getPERSON_NO(){
                               return localPERSON_NO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PERSON_NO
                               */
                               public void setPERSON_NO(functions.rfc.sap.document.sap_com.PERSON_NO_type1 param){
                            localPERSON_NOTracker = param != null;
                                   
                                            this.localPERSON_NO=param;
                                    

                               }
                            

                        /**
                        * field for CO_BUSPROC
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.CO_BUSPROC_type1 localCO_BUSPROC ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCO_BUSPROCTracker = false ;

                           public boolean isCO_BUSPROCSpecified(){
                               return localCO_BUSPROCTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.CO_BUSPROC_type1
                           */
                           public  functions.rfc.sap.document.sap_com.CO_BUSPROC_type1 getCO_BUSPROC(){
                               return localCO_BUSPROC;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CO_BUSPROC
                               */
                               public void setCO_BUSPROC(functions.rfc.sap.document.sap_com.CO_BUSPROC_type1 param){
                            localCO_BUSPROCTracker = param != null;
                                   
                                            this.localCO_BUSPROC=param;
                                    

                               }
                            

                        /**
                        * field for GRANT_NBR
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.GRANT_NBR_type1 localGRANT_NBR ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localGRANT_NBRTracker = false ;

                           public boolean isGRANT_NBRSpecified(){
                               return localGRANT_NBRTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.GRANT_NBR_type1
                           */
                           public  functions.rfc.sap.document.sap_com.GRANT_NBR_type1 getGRANT_NBR(){
                               return localGRANT_NBR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param GRANT_NBR
                               */
                               public void setGRANT_NBR(functions.rfc.sap.document.sap_com.GRANT_NBR_type1 param){
                            localGRANT_NBRTracker = param != null;
                                   
                                            this.localGRANT_NBR=param;
                                    

                               }
                            

                        /**
                        * field for CMMT_ITEM_LONG
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.CMMT_ITEM_LONG_type1 localCMMT_ITEM_LONG ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCMMT_ITEM_LONGTracker = false ;

                           public boolean isCMMT_ITEM_LONGSpecified(){
                               return localCMMT_ITEM_LONGTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.CMMT_ITEM_LONG_type1
                           */
                           public  functions.rfc.sap.document.sap_com.CMMT_ITEM_LONG_type1 getCMMT_ITEM_LONG(){
                               return localCMMT_ITEM_LONG;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CMMT_ITEM_LONG
                               */
                               public void setCMMT_ITEM_LONG(functions.rfc.sap.document.sap_com.CMMT_ITEM_LONG_type1 param){
                            localCMMT_ITEM_LONGTracker = param != null;
                                   
                                            this.localCMMT_ITEM_LONG=param;
                                    

                               }
                            

                        /**
                        * field for FUNC_AREA_LONG
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.FUNC_AREA_LONG_type1 localFUNC_AREA_LONG ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localFUNC_AREA_LONGTracker = false ;

                           public boolean isFUNC_AREA_LONGSpecified(){
                               return localFUNC_AREA_LONGTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.FUNC_AREA_LONG_type1
                           */
                           public  functions.rfc.sap.document.sap_com.FUNC_AREA_LONG_type1 getFUNC_AREA_LONG(){
                               return localFUNC_AREA_LONG;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param FUNC_AREA_LONG
                               */
                               public void setFUNC_AREA_LONG(functions.rfc.sap.document.sap_com.FUNC_AREA_LONG_type1 param){
                            localFUNC_AREA_LONGTracker = param != null;
                                   
                                            this.localFUNC_AREA_LONG=param;
                                    

                               }
                            

                        /**
                        * field for QUANTITY
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.QUANTITY_type1 localQUANTITY ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localQUANTITYTracker = false ;

                           public boolean isQUANTITYSpecified(){
                               return localQUANTITYTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.QUANTITY_type1
                           */
                           public  functions.rfc.sap.document.sap_com.QUANTITY_type1 getQUANTITY(){
                               return localQUANTITY;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param QUANTITY
                               */
                               public void setQUANTITY(functions.rfc.sap.document.sap_com.QUANTITY_type1 param){
                            localQUANTITYTracker = param != null;
                                   
                                            this.localQUANTITY=param;
                                    

                               }
                            

                        /**
                        * field for BASE_UOM
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.BASE_UOM_type1 localBASE_UOM ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBASE_UOMTracker = false ;

                           public boolean isBASE_UOMSpecified(){
                               return localBASE_UOMTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.BASE_UOM_type1
                           */
                           public  functions.rfc.sap.document.sap_com.BASE_UOM_type1 getBASE_UOM(){
                               return localBASE_UOM;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BASE_UOM
                               */
                               public void setBASE_UOM(functions.rfc.sap.document.sap_com.BASE_UOM_type1 param){
                            localBASE_UOMTracker = param != null;
                                   
                                            this.localBASE_UOM=param;
                                    

                               }
                            

                        /**
                        * field for ALLOC_NMBR
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.ALLOC_NMBR_type1 localALLOC_NMBR ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localALLOC_NMBRTracker = false ;

                           public boolean isALLOC_NMBRSpecified(){
                               return localALLOC_NMBRTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.ALLOC_NMBR_type1
                           */
                           public  functions.rfc.sap.document.sap_com.ALLOC_NMBR_type1 getALLOC_NMBR(){
                               return localALLOC_NMBR;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param ALLOC_NMBR
                               */
                               public void setALLOC_NMBR(functions.rfc.sap.document.sap_com.ALLOC_NMBR_type1 param){
                            localALLOC_NMBRTracker = param != null;
                                   
                                            this.localALLOC_NMBR=param;
                                    

                               }
                            

                        /**
                        * field for CSHDIS_IND
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.CSHDIS_IND_type1 localCSHDIS_IND ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localCSHDIS_INDTracker = false ;

                           public boolean isCSHDIS_INDSpecified(){
                               return localCSHDIS_INDTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.CSHDIS_IND_type1
                           */
                           public  functions.rfc.sap.document.sap_com.CSHDIS_IND_type1 getCSHDIS_IND(){
                               return localCSHDIS_IND;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param CSHDIS_IND
                               */
                               public void setCSHDIS_IND(functions.rfc.sap.document.sap_com.CSHDIS_IND_type1 param){
                            localCSHDIS_INDTracker = param != null;
                                   
                                            this.localCSHDIS_IND=param;
                                    

                               }
                            

                        /**
                        * field for TAX_BASE_AMOUNT
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.TAX_BASE_AMOUNT_type1 localTAX_BASE_AMOUNT ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localTAX_BASE_AMOUNTTracker = false ;

                           public boolean isTAX_BASE_AMOUNTSpecified(){
                               return localTAX_BASE_AMOUNTTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.TAX_BASE_AMOUNT_type1
                           */
                           public  functions.rfc.sap.document.sap_com.TAX_BASE_AMOUNT_type1 getTAX_BASE_AMOUNT(){
                               return localTAX_BASE_AMOUNT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param TAX_BASE_AMOUNT
                               */
                               public void setTAX_BASE_AMOUNT(functions.rfc.sap.document.sap_com.TAX_BASE_AMOUNT_type1 param){
                            localTAX_BASE_AMOUNTTracker = param != null;
                                   
                                            this.localTAX_BASE_AMOUNT=param;
                                    

                               }
                            

                        /**
                        * field for PROFIT_SEGM_NO
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.PROFIT_SEGM_NO_type1 localPROFIT_SEGM_NO ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPROFIT_SEGM_NOTracker = false ;

                           public boolean isPROFIT_SEGM_NOSpecified(){
                               return localPROFIT_SEGM_NOTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.PROFIT_SEGM_NO_type1
                           */
                           public  functions.rfc.sap.document.sap_com.PROFIT_SEGM_NO_type1 getPROFIT_SEGM_NO(){
                               return localPROFIT_SEGM_NO;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PROFIT_SEGM_NO
                               */
                               public void setPROFIT_SEGM_NO(functions.rfc.sap.document.sap_com.PROFIT_SEGM_NO_type1 param){
                            localPROFIT_SEGM_NOTracker = param != null;
                                   
                                            this.localPROFIT_SEGM_NO=param;
                                    

                               }
                            

                        /**
                        * field for PLANT
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.PLANT_type1 localPLANT ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localPLANTTracker = false ;

                           public boolean isPLANTSpecified(){
                               return localPLANTTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.PLANT_type1
                           */
                           public  functions.rfc.sap.document.sap_com.PLANT_type1 getPLANT(){
                               return localPLANT;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param PLANT
                               */
                               public void setPLANT(functions.rfc.sap.document.sap_com.PLANT_type1 param){
                            localPLANTTracker = param != null;
                                   
                                            this.localPLANT=param;
                                    

                               }
                            

                        /**
                        * field for BUDGET_PERIOD
                        */

                        
                                    protected functions.rfc.sap.document.sap_com.BUDGET_PERIOD_type1 localBUDGET_PERIOD ;
                                
                           /*  This tracker boolean wil be used to detect whether the user called the set method
                          *   for this attribute. It will be used to determine whether to include this field
                           *   in the serialized XML
                           */
                           protected boolean localBUDGET_PERIODTracker = false ;

                           public boolean isBUDGET_PERIODSpecified(){
                               return localBUDGET_PERIODTracker;
                           }

                           

                           /**
                           * Auto generated getter method
                           * @return functions.rfc.sap.document.sap_com.BUDGET_PERIOD_type1
                           */
                           public  functions.rfc.sap.document.sap_com.BUDGET_PERIOD_type1 getBUDGET_PERIOD(){
                               return localBUDGET_PERIOD;
                           }

                           
                        
                            /**
                               * Auto generated setter method
                               * @param param BUDGET_PERIOD
                               */
                               public void setBUDGET_PERIOD(functions.rfc.sap.document.sap_com.BUDGET_PERIOD_type1 param){
                            localBUDGET_PERIODTracker = param != null;
                                   
                                            this.localBUDGET_PERIOD=param;
                                    

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
                           namespacePrefix+":ZST_ACCOUNTING",
                           xmlWriter);
                   } else {
                       writeAttribute("xsi","http://www.w3.org/2001/XMLSchema-instance","type",
                           "ZST_ACCOUNTING",
                           xmlWriter);
                   }

               
                   }
                if (localINVOICE_DOC_ITEMTracker){
                                            if (localINVOICE_DOC_ITEM==null){
                                                 throw new org.apache.axis2.databinding.ADBException("INVOICE_DOC_ITEM cannot be null!!");
                                            }
                                           localINVOICE_DOC_ITEM.serialize(new javax.xml.namespace.QName("","INVOICE_DOC_ITEM"),
                                               xmlWriter);
                                        } if (localGL_ACCOUNTTracker){
                                            if (localGL_ACCOUNT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("GL_ACCOUNT cannot be null!!");
                                            }
                                           localGL_ACCOUNT.serialize(new javax.xml.namespace.QName("","GL_ACCOUNT"),
                                               xmlWriter);
                                        } if (localITEM_AMOUNTTracker){
                                            if (localITEM_AMOUNT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ITEM_AMOUNT cannot be null!!");
                                            }
                                           localITEM_AMOUNT.serialize(new javax.xml.namespace.QName("","ITEM_AMOUNT"),
                                               xmlWriter);
                                        } if (localDB_CR_INDTracker){
                                            if (localDB_CR_IND==null){
                                                 throw new org.apache.axis2.databinding.ADBException("DB_CR_IND cannot be null!!");
                                            }
                                           localDB_CR_IND.serialize(new javax.xml.namespace.QName("","DB_CR_IND"),
                                               xmlWriter);
                                        } if (localNEG_POSTNGTracker){
                                            if (localNEG_POSTNG==null){
                                                 throw new org.apache.axis2.databinding.ADBException("NEG_POSTNG cannot be null!!");
                                            }
                                           localNEG_POSTNG.serialize(new javax.xml.namespace.QName("","NEG_POSTNG"),
                                               xmlWriter);
                                        } if (localCOMP_CODETracker){
                                            if (localCOMP_CODE==null){
                                                 throw new org.apache.axis2.databinding.ADBException("COMP_CODE cannot be null!!");
                                            }
                                           localCOMP_CODE.serialize(new javax.xml.namespace.QName("","COMP_CODE"),
                                               xmlWriter);
                                        } if (localTAX_CODETracker){
                                            if (localTAX_CODE==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TAX_CODE cannot be null!!");
                                            }
                                           localTAX_CODE.serialize(new javax.xml.namespace.QName("","TAX_CODE"),
                                               xmlWriter);
                                        } if (localTAXJURCODETracker){
                                            if (localTAXJURCODE==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TAXJURCODE cannot be null!!");
                                            }
                                           localTAXJURCODE.serialize(new javax.xml.namespace.QName("","TAXJURCODE"),
                                               xmlWriter);
                                        } if (localITEM_TEXTTracker){
                                            if (localITEM_TEXT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ITEM_TEXT cannot be null!!");
                                            }
                                           localITEM_TEXT.serialize(new javax.xml.namespace.QName("","ITEM_TEXT"),
                                               xmlWriter);
                                        } if (localCOSTCENTERTracker){
                                            if (localCOSTCENTER==null){
                                                 throw new org.apache.axis2.databinding.ADBException("COSTCENTER cannot be null!!");
                                            }
                                           localCOSTCENTER.serialize(new javax.xml.namespace.QName("","COSTCENTER"),
                                               xmlWriter);
                                        } if (localSD_DOCTracker){
                                            if (localSD_DOC==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SD_DOC cannot be null!!");
                                            }
                                           localSD_DOC.serialize(new javax.xml.namespace.QName("","SD_DOC"),
                                               xmlWriter);
                                        } if (localSDOC_ITEMTracker){
                                            if (localSDOC_ITEM==null){
                                                 throw new org.apache.axis2.databinding.ADBException("SDOC_ITEM cannot be null!!");
                                            }
                                           localSDOC_ITEM.serialize(new javax.xml.namespace.QName("","SDOC_ITEM"),
                                               xmlWriter);
                                        } if (localORDERIDTracker){
                                            if (localORDERID==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ORDERID cannot be null!!");
                                            }
                                           localORDERID.serialize(new javax.xml.namespace.QName("","ORDERID"),
                                               xmlWriter);
                                        } if (localREF_DATETracker){
                                            if (localREF_DATE==null){
                                                 throw new org.apache.axis2.databinding.ADBException("REF_DATE cannot be null!!");
                                            }
                                           localREF_DATE.serialize(new javax.xml.namespace.QName("","REF_DATE"),
                                               xmlWriter);
                                        } if (localCMMT_ITEMTracker){
                                            if (localCMMT_ITEM==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CMMT_ITEM cannot be null!!");
                                            }
                                           localCMMT_ITEM.serialize(new javax.xml.namespace.QName("","CMMT_ITEM"),
                                               xmlWriter);
                                        } if (localFUNDS_CTRTracker){
                                            if (localFUNDS_CTR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FUNDS_CTR cannot be null!!");
                                            }
                                           localFUNDS_CTR.serialize(new javax.xml.namespace.QName("","FUNDS_CTR"),
                                               xmlWriter);
                                        } if (localFUNC_AREATracker){
                                            if (localFUNC_AREA==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FUNC_AREA cannot be null!!");
                                            }
                                           localFUNC_AREA.serialize(new javax.xml.namespace.QName("","FUNC_AREA"),
                                               xmlWriter);
                                        } if (localPROFIT_CTRTracker){
                                            if (localPROFIT_CTR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PROFIT_CTR cannot be null!!");
                                            }
                                           localPROFIT_CTR.serialize(new javax.xml.namespace.QName("","PROFIT_CTR"),
                                               xmlWriter);
                                        } if (localFUNDTracker){
                                            if (localFUND==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FUND cannot be null!!");
                                            }
                                           localFUND.serialize(new javax.xml.namespace.QName("","FUND"),
                                               xmlWriter);
                                        } if (localBUS_AREATracker){
                                            if (localBUS_AREA==null){
                                                 throw new org.apache.axis2.databinding.ADBException("BUS_AREA cannot be null!!");
                                            }
                                           localBUS_AREA.serialize(new javax.xml.namespace.QName("","BUS_AREA"),
                                               xmlWriter);
                                        } if (localTR_PART_BATracker){
                                            if (localTR_PART_BA==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TR_PART_BA cannot be null!!");
                                            }
                                           localTR_PART_BA.serialize(new javax.xml.namespace.QName("","TR_PART_BA"),
                                               xmlWriter);
                                        } if (localCOSTOBJECTTracker){
                                            if (localCOSTOBJECT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("COSTOBJECT cannot be null!!");
                                            }
                                           localCOSTOBJECT.serialize(new javax.xml.namespace.QName("","COSTOBJECT"),
                                               xmlWriter);
                                        } if (localNETWORKTracker){
                                            if (localNETWORK==null){
                                                 throw new org.apache.axis2.databinding.ADBException("NETWORK cannot be null!!");
                                            }
                                           localNETWORK.serialize(new javax.xml.namespace.QName("","NETWORK"),
                                               xmlWriter);
                                        } if (localACTIVITYTracker){
                                            if (localACTIVITY==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ACTIVITY cannot be null!!");
                                            }
                                           localACTIVITY.serialize(new javax.xml.namespace.QName("","ACTIVITY"),
                                               xmlWriter);
                                        } if (localWBS_ELEMTracker){
                                            if (localWBS_ELEM==null){
                                                 throw new org.apache.axis2.databinding.ADBException("WBS_ELEM cannot be null!!");
                                            }
                                           localWBS_ELEM.serialize(new javax.xml.namespace.QName("","WBS_ELEM"),
                                               xmlWriter);
                                        } if (localACTTYPETracker){
                                            if (localACTTYPE==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ACTTYPE cannot be null!!");
                                            }
                                           localACTTYPE.serialize(new javax.xml.namespace.QName("","ACTTYPE"),
                                               xmlWriter);
                                        } if (localRL_EST_KEYTracker){
                                            if (localRL_EST_KEY==null){
                                                 throw new org.apache.axis2.databinding.ADBException("RL_EST_KEY cannot be null!!");
                                            }
                                           localRL_EST_KEY.serialize(new javax.xml.namespace.QName("","RL_EST_KEY"),
                                               xmlWriter);
                                        } if (localPERSON_NOTracker){
                                            if (localPERSON_NO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PERSON_NO cannot be null!!");
                                            }
                                           localPERSON_NO.serialize(new javax.xml.namespace.QName("","PERSON_NO"),
                                               xmlWriter);
                                        } if (localCO_BUSPROCTracker){
                                            if (localCO_BUSPROC==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CO_BUSPROC cannot be null!!");
                                            }
                                           localCO_BUSPROC.serialize(new javax.xml.namespace.QName("","CO_BUSPROC"),
                                               xmlWriter);
                                        } if (localGRANT_NBRTracker){
                                            if (localGRANT_NBR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("GRANT_NBR cannot be null!!");
                                            }
                                           localGRANT_NBR.serialize(new javax.xml.namespace.QName("","GRANT_NBR"),
                                               xmlWriter);
                                        } if (localCMMT_ITEM_LONGTracker){
                                            if (localCMMT_ITEM_LONG==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CMMT_ITEM_LONG cannot be null!!");
                                            }
                                           localCMMT_ITEM_LONG.serialize(new javax.xml.namespace.QName("","CMMT_ITEM_LONG"),
                                               xmlWriter);
                                        } if (localFUNC_AREA_LONGTracker){
                                            if (localFUNC_AREA_LONG==null){
                                                 throw new org.apache.axis2.databinding.ADBException("FUNC_AREA_LONG cannot be null!!");
                                            }
                                           localFUNC_AREA_LONG.serialize(new javax.xml.namespace.QName("","FUNC_AREA_LONG"),
                                               xmlWriter);
                                        } if (localQUANTITYTracker){
                                            if (localQUANTITY==null){
                                                 throw new org.apache.axis2.databinding.ADBException("QUANTITY cannot be null!!");
                                            }
                                           localQUANTITY.serialize(new javax.xml.namespace.QName("","QUANTITY"),
                                               xmlWriter);
                                        } if (localBASE_UOMTracker){
                                            if (localBASE_UOM==null){
                                                 throw new org.apache.axis2.databinding.ADBException("BASE_UOM cannot be null!!");
                                            }
                                           localBASE_UOM.serialize(new javax.xml.namespace.QName("","BASE_UOM"),
                                               xmlWriter);
                                        } if (localALLOC_NMBRTracker){
                                            if (localALLOC_NMBR==null){
                                                 throw new org.apache.axis2.databinding.ADBException("ALLOC_NMBR cannot be null!!");
                                            }
                                           localALLOC_NMBR.serialize(new javax.xml.namespace.QName("","ALLOC_NMBR"),
                                               xmlWriter);
                                        } if (localCSHDIS_INDTracker){
                                            if (localCSHDIS_IND==null){
                                                 throw new org.apache.axis2.databinding.ADBException("CSHDIS_IND cannot be null!!");
                                            }
                                           localCSHDIS_IND.serialize(new javax.xml.namespace.QName("","CSHDIS_IND"),
                                               xmlWriter);
                                        } if (localTAX_BASE_AMOUNTTracker){
                                            if (localTAX_BASE_AMOUNT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("TAX_BASE_AMOUNT cannot be null!!");
                                            }
                                           localTAX_BASE_AMOUNT.serialize(new javax.xml.namespace.QName("","TAX_BASE_AMOUNT"),
                                               xmlWriter);
                                        } if (localPROFIT_SEGM_NOTracker){
                                            if (localPROFIT_SEGM_NO==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PROFIT_SEGM_NO cannot be null!!");
                                            }
                                           localPROFIT_SEGM_NO.serialize(new javax.xml.namespace.QName("","PROFIT_SEGM_NO"),
                                               xmlWriter);
                                        } if (localPLANTTracker){
                                            if (localPLANT==null){
                                                 throw new org.apache.axis2.databinding.ADBException("PLANT cannot be null!!");
                                            }
                                           localPLANT.serialize(new javax.xml.namespace.QName("","PLANT"),
                                               xmlWriter);
                                        } if (localBUDGET_PERIODTracker){
                                            if (localBUDGET_PERIOD==null){
                                                 throw new org.apache.axis2.databinding.ADBException("BUDGET_PERIOD cannot be null!!");
                                            }
                                           localBUDGET_PERIOD.serialize(new javax.xml.namespace.QName("","BUDGET_PERIOD"),
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

                 if (localINVOICE_DOC_ITEMTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "INVOICE_DOC_ITEM"));
                            
                            
                                    if (localINVOICE_DOC_ITEM==null){
                                         throw new org.apache.axis2.databinding.ADBException("INVOICE_DOC_ITEM cannot be null!!");
                                    }
                                    elementList.add(localINVOICE_DOC_ITEM);
                                } if (localGL_ACCOUNTTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "GL_ACCOUNT"));
                            
                            
                                    if (localGL_ACCOUNT==null){
                                         throw new org.apache.axis2.databinding.ADBException("GL_ACCOUNT cannot be null!!");
                                    }
                                    elementList.add(localGL_ACCOUNT);
                                } if (localITEM_AMOUNTTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ITEM_AMOUNT"));
                            
                            
                                    if (localITEM_AMOUNT==null){
                                         throw new org.apache.axis2.databinding.ADBException("ITEM_AMOUNT cannot be null!!");
                                    }
                                    elementList.add(localITEM_AMOUNT);
                                } if (localDB_CR_INDTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "DB_CR_IND"));
                            
                            
                                    if (localDB_CR_IND==null){
                                         throw new org.apache.axis2.databinding.ADBException("DB_CR_IND cannot be null!!");
                                    }
                                    elementList.add(localDB_CR_IND);
                                } if (localNEG_POSTNGTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "NEG_POSTNG"));
                            
                            
                                    if (localNEG_POSTNG==null){
                                         throw new org.apache.axis2.databinding.ADBException("NEG_POSTNG cannot be null!!");
                                    }
                                    elementList.add(localNEG_POSTNG);
                                } if (localCOMP_CODETracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "COMP_CODE"));
                            
                            
                                    if (localCOMP_CODE==null){
                                         throw new org.apache.axis2.databinding.ADBException("COMP_CODE cannot be null!!");
                                    }
                                    elementList.add(localCOMP_CODE);
                                } if (localTAX_CODETracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TAX_CODE"));
                            
                            
                                    if (localTAX_CODE==null){
                                         throw new org.apache.axis2.databinding.ADBException("TAX_CODE cannot be null!!");
                                    }
                                    elementList.add(localTAX_CODE);
                                } if (localTAXJURCODETracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TAXJURCODE"));
                            
                            
                                    if (localTAXJURCODE==null){
                                         throw new org.apache.axis2.databinding.ADBException("TAXJURCODE cannot be null!!");
                                    }
                                    elementList.add(localTAXJURCODE);
                                } if (localITEM_TEXTTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ITEM_TEXT"));
                            
                            
                                    if (localITEM_TEXT==null){
                                         throw new org.apache.axis2.databinding.ADBException("ITEM_TEXT cannot be null!!");
                                    }
                                    elementList.add(localITEM_TEXT);
                                } if (localCOSTCENTERTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "COSTCENTER"));
                            
                            
                                    if (localCOSTCENTER==null){
                                         throw new org.apache.axis2.databinding.ADBException("COSTCENTER cannot be null!!");
                                    }
                                    elementList.add(localCOSTCENTER);
                                } if (localSD_DOCTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "SD_DOC"));
                            
                            
                                    if (localSD_DOC==null){
                                         throw new org.apache.axis2.databinding.ADBException("SD_DOC cannot be null!!");
                                    }
                                    elementList.add(localSD_DOC);
                                } if (localSDOC_ITEMTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "SDOC_ITEM"));
                            
                            
                                    if (localSDOC_ITEM==null){
                                         throw new org.apache.axis2.databinding.ADBException("SDOC_ITEM cannot be null!!");
                                    }
                                    elementList.add(localSDOC_ITEM);
                                } if (localORDERIDTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ORDERID"));
                            
                            
                                    if (localORDERID==null){
                                         throw new org.apache.axis2.databinding.ADBException("ORDERID cannot be null!!");
                                    }
                                    elementList.add(localORDERID);
                                } if (localREF_DATETracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "REF_DATE"));
                            
                            
                                    if (localREF_DATE==null){
                                         throw new org.apache.axis2.databinding.ADBException("REF_DATE cannot be null!!");
                                    }
                                    elementList.add(localREF_DATE);
                                } if (localCMMT_ITEMTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CMMT_ITEM"));
                            
                            
                                    if (localCMMT_ITEM==null){
                                         throw new org.apache.axis2.databinding.ADBException("CMMT_ITEM cannot be null!!");
                                    }
                                    elementList.add(localCMMT_ITEM);
                                } if (localFUNDS_CTRTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "FUNDS_CTR"));
                            
                            
                                    if (localFUNDS_CTR==null){
                                         throw new org.apache.axis2.databinding.ADBException("FUNDS_CTR cannot be null!!");
                                    }
                                    elementList.add(localFUNDS_CTR);
                                } if (localFUNC_AREATracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "FUNC_AREA"));
                            
                            
                                    if (localFUNC_AREA==null){
                                         throw new org.apache.axis2.databinding.ADBException("FUNC_AREA cannot be null!!");
                                    }
                                    elementList.add(localFUNC_AREA);
                                } if (localPROFIT_CTRTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "PROFIT_CTR"));
                            
                            
                                    if (localPROFIT_CTR==null){
                                         throw new org.apache.axis2.databinding.ADBException("PROFIT_CTR cannot be null!!");
                                    }
                                    elementList.add(localPROFIT_CTR);
                                } if (localFUNDTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "FUND"));
                            
                            
                                    if (localFUND==null){
                                         throw new org.apache.axis2.databinding.ADBException("FUND cannot be null!!");
                                    }
                                    elementList.add(localFUND);
                                } if (localBUS_AREATracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "BUS_AREA"));
                            
                            
                                    if (localBUS_AREA==null){
                                         throw new org.apache.axis2.databinding.ADBException("BUS_AREA cannot be null!!");
                                    }
                                    elementList.add(localBUS_AREA);
                                } if (localTR_PART_BATracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TR_PART_BA"));
                            
                            
                                    if (localTR_PART_BA==null){
                                         throw new org.apache.axis2.databinding.ADBException("TR_PART_BA cannot be null!!");
                                    }
                                    elementList.add(localTR_PART_BA);
                                } if (localCOSTOBJECTTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "COSTOBJECT"));
                            
                            
                                    if (localCOSTOBJECT==null){
                                         throw new org.apache.axis2.databinding.ADBException("COSTOBJECT cannot be null!!");
                                    }
                                    elementList.add(localCOSTOBJECT);
                                } if (localNETWORKTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "NETWORK"));
                            
                            
                                    if (localNETWORK==null){
                                         throw new org.apache.axis2.databinding.ADBException("NETWORK cannot be null!!");
                                    }
                                    elementList.add(localNETWORK);
                                } if (localACTIVITYTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ACTIVITY"));
                            
                            
                                    if (localACTIVITY==null){
                                         throw new org.apache.axis2.databinding.ADBException("ACTIVITY cannot be null!!");
                                    }
                                    elementList.add(localACTIVITY);
                                } if (localWBS_ELEMTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "WBS_ELEM"));
                            
                            
                                    if (localWBS_ELEM==null){
                                         throw new org.apache.axis2.databinding.ADBException("WBS_ELEM cannot be null!!");
                                    }
                                    elementList.add(localWBS_ELEM);
                                } if (localACTTYPETracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ACTTYPE"));
                            
                            
                                    if (localACTTYPE==null){
                                         throw new org.apache.axis2.databinding.ADBException("ACTTYPE cannot be null!!");
                                    }
                                    elementList.add(localACTTYPE);
                                } if (localRL_EST_KEYTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "RL_EST_KEY"));
                            
                            
                                    if (localRL_EST_KEY==null){
                                         throw new org.apache.axis2.databinding.ADBException("RL_EST_KEY cannot be null!!");
                                    }
                                    elementList.add(localRL_EST_KEY);
                                } if (localPERSON_NOTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "PERSON_NO"));
                            
                            
                                    if (localPERSON_NO==null){
                                         throw new org.apache.axis2.databinding.ADBException("PERSON_NO cannot be null!!");
                                    }
                                    elementList.add(localPERSON_NO);
                                } if (localCO_BUSPROCTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CO_BUSPROC"));
                            
                            
                                    if (localCO_BUSPROC==null){
                                         throw new org.apache.axis2.databinding.ADBException("CO_BUSPROC cannot be null!!");
                                    }
                                    elementList.add(localCO_BUSPROC);
                                } if (localGRANT_NBRTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "GRANT_NBR"));
                            
                            
                                    if (localGRANT_NBR==null){
                                         throw new org.apache.axis2.databinding.ADBException("GRANT_NBR cannot be null!!");
                                    }
                                    elementList.add(localGRANT_NBR);
                                } if (localCMMT_ITEM_LONGTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CMMT_ITEM_LONG"));
                            
                            
                                    if (localCMMT_ITEM_LONG==null){
                                         throw new org.apache.axis2.databinding.ADBException("CMMT_ITEM_LONG cannot be null!!");
                                    }
                                    elementList.add(localCMMT_ITEM_LONG);
                                } if (localFUNC_AREA_LONGTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "FUNC_AREA_LONG"));
                            
                            
                                    if (localFUNC_AREA_LONG==null){
                                         throw new org.apache.axis2.databinding.ADBException("FUNC_AREA_LONG cannot be null!!");
                                    }
                                    elementList.add(localFUNC_AREA_LONG);
                                } if (localQUANTITYTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "QUANTITY"));
                            
                            
                                    if (localQUANTITY==null){
                                         throw new org.apache.axis2.databinding.ADBException("QUANTITY cannot be null!!");
                                    }
                                    elementList.add(localQUANTITY);
                                } if (localBASE_UOMTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "BASE_UOM"));
                            
                            
                                    if (localBASE_UOM==null){
                                         throw new org.apache.axis2.databinding.ADBException("BASE_UOM cannot be null!!");
                                    }
                                    elementList.add(localBASE_UOM);
                                } if (localALLOC_NMBRTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "ALLOC_NMBR"));
                            
                            
                                    if (localALLOC_NMBR==null){
                                         throw new org.apache.axis2.databinding.ADBException("ALLOC_NMBR cannot be null!!");
                                    }
                                    elementList.add(localALLOC_NMBR);
                                } if (localCSHDIS_INDTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "CSHDIS_IND"));
                            
                            
                                    if (localCSHDIS_IND==null){
                                         throw new org.apache.axis2.databinding.ADBException("CSHDIS_IND cannot be null!!");
                                    }
                                    elementList.add(localCSHDIS_IND);
                                } if (localTAX_BASE_AMOUNTTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "TAX_BASE_AMOUNT"));
                            
                            
                                    if (localTAX_BASE_AMOUNT==null){
                                         throw new org.apache.axis2.databinding.ADBException("TAX_BASE_AMOUNT cannot be null!!");
                                    }
                                    elementList.add(localTAX_BASE_AMOUNT);
                                } if (localPROFIT_SEGM_NOTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "PROFIT_SEGM_NO"));
                            
                            
                                    if (localPROFIT_SEGM_NO==null){
                                         throw new org.apache.axis2.databinding.ADBException("PROFIT_SEGM_NO cannot be null!!");
                                    }
                                    elementList.add(localPROFIT_SEGM_NO);
                                } if (localPLANTTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "PLANT"));
                            
                            
                                    if (localPLANT==null){
                                         throw new org.apache.axis2.databinding.ADBException("PLANT cannot be null!!");
                                    }
                                    elementList.add(localPLANT);
                                } if (localBUDGET_PERIODTracker){
                            elementList.add(new javax.xml.namespace.QName("",
                                                                      "BUDGET_PERIOD"));
                            
                            
                                    if (localBUDGET_PERIOD==null){
                                         throw new org.apache.axis2.databinding.ADBException("BUDGET_PERIOD cannot be null!!");
                                    }
                                    elementList.add(localBUDGET_PERIOD);
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
        public static ZST_ACCOUNTING parse(javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{
            ZST_ACCOUNTING object =
                new ZST_ACCOUNTING();

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
                    
                            if (!"ZST_ACCOUNTING".equals(type)){
                                //find namespace for the prefix
                                java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ZST_ACCOUNTING)functions.rfc.sap.document.sap_com.ExtensionMapper.getTypeObject(
                                     nsUri,type,reader);
                              }
                        

                  }
                

                }

                

                
                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                java.util.Vector handledAttributes = new java.util.Vector();
                

                
                    
                    reader.next();
                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","INVOICE_DOC_ITEM").equals(reader.getName())){
                                
                                                object.setINVOICE_DOC_ITEM(functions.rfc.sap.document.sap_com.INVOICE_DOC_ITEM_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","GL_ACCOUNT").equals(reader.getName())){
                                
                                                object.setGL_ACCOUNT(functions.rfc.sap.document.sap_com.GL_ACCOUNT_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ITEM_AMOUNT").equals(reader.getName())){
                                
                                                object.setITEM_AMOUNT(functions.rfc.sap.document.sap_com.ITEM_AMOUNT_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","DB_CR_IND").equals(reader.getName())){
                                
                                                object.setDB_CR_IND(functions.rfc.sap.document.sap_com.DB_CR_IND_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","NEG_POSTNG").equals(reader.getName())){
                                
                                                object.setNEG_POSTNG(functions.rfc.sap.document.sap_com.NEG_POSTNG_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","COMP_CODE").equals(reader.getName())){
                                
                                                object.setCOMP_CODE(functions.rfc.sap.document.sap_com.COMP_CODE_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TAX_CODE").equals(reader.getName())){
                                
                                                object.setTAX_CODE(functions.rfc.sap.document.sap_com.TAX_CODE_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TAXJURCODE").equals(reader.getName())){
                                
                                                object.setTAXJURCODE(functions.rfc.sap.document.sap_com.TAXJURCODE_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ITEM_TEXT").equals(reader.getName())){
                                
                                                object.setITEM_TEXT(functions.rfc.sap.document.sap_com.ITEM_TEXT_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","COSTCENTER").equals(reader.getName())){
                                
                                                object.setCOSTCENTER(functions.rfc.sap.document.sap_com.COSTCENTER_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","SD_DOC").equals(reader.getName())){
                                
                                                object.setSD_DOC(functions.rfc.sap.document.sap_com.SD_DOC_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","SDOC_ITEM").equals(reader.getName())){
                                
                                                object.setSDOC_ITEM(functions.rfc.sap.document.sap_com.SDOC_ITEM_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ORDERID").equals(reader.getName())){
                                
                                                object.setORDERID(functions.rfc.sap.document.sap_com.ORDERID_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","REF_DATE").equals(reader.getName())){
                                
                                                object.setREF_DATE(functions.rfc.sap.document.sap_com.Date.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CMMT_ITEM").equals(reader.getName())){
                                
                                                object.setCMMT_ITEM(functions.rfc.sap.document.sap_com.CMMT_ITEM_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","FUNDS_CTR").equals(reader.getName())){
                                
                                                object.setFUNDS_CTR(functions.rfc.sap.document.sap_com.FUNDS_CTR_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","FUNC_AREA").equals(reader.getName())){
                                
                                                object.setFUNC_AREA(functions.rfc.sap.document.sap_com.FUNC_AREA_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","PROFIT_CTR").equals(reader.getName())){
                                
                                                object.setPROFIT_CTR(functions.rfc.sap.document.sap_com.PROFIT_CTR_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","FUND").equals(reader.getName())){
                                
                                                object.setFUND(functions.rfc.sap.document.sap_com.FUND_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","BUS_AREA").equals(reader.getName())){
                                
                                                object.setBUS_AREA(functions.rfc.sap.document.sap_com.BUS_AREA_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TR_PART_BA").equals(reader.getName())){
                                
                                                object.setTR_PART_BA(functions.rfc.sap.document.sap_com.TR_PART_BA_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","COSTOBJECT").equals(reader.getName())){
                                
                                                object.setCOSTOBJECT(functions.rfc.sap.document.sap_com.COSTOBJECT_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","NETWORK").equals(reader.getName())){
                                
                                                object.setNETWORK(functions.rfc.sap.document.sap_com.NETWORK_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ACTIVITY").equals(reader.getName())){
                                
                                                object.setACTIVITY(functions.rfc.sap.document.sap_com.ACTIVITY_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","WBS_ELEM").equals(reader.getName())){
                                
                                                object.setWBS_ELEM(functions.rfc.sap.document.sap_com.WBS_ELEM_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ACTTYPE").equals(reader.getName())){
                                
                                                object.setACTTYPE(functions.rfc.sap.document.sap_com.ACTTYPE_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","RL_EST_KEY").equals(reader.getName())){
                                
                                                object.setRL_EST_KEY(functions.rfc.sap.document.sap_com.RL_EST_KEY_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","PERSON_NO").equals(reader.getName())){
                                
                                                object.setPERSON_NO(functions.rfc.sap.document.sap_com.PERSON_NO_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CO_BUSPROC").equals(reader.getName())){
                                
                                                object.setCO_BUSPROC(functions.rfc.sap.document.sap_com.CO_BUSPROC_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","GRANT_NBR").equals(reader.getName())){
                                
                                                object.setGRANT_NBR(functions.rfc.sap.document.sap_com.GRANT_NBR_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CMMT_ITEM_LONG").equals(reader.getName())){
                                
                                                object.setCMMT_ITEM_LONG(functions.rfc.sap.document.sap_com.CMMT_ITEM_LONG_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","FUNC_AREA_LONG").equals(reader.getName())){
                                
                                                object.setFUNC_AREA_LONG(functions.rfc.sap.document.sap_com.FUNC_AREA_LONG_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","QUANTITY").equals(reader.getName())){
                                
                                                object.setQUANTITY(functions.rfc.sap.document.sap_com.QUANTITY_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","BASE_UOM").equals(reader.getName())){
                                
                                                object.setBASE_UOM(functions.rfc.sap.document.sap_com.BASE_UOM_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","ALLOC_NMBR").equals(reader.getName())){
                                
                                                object.setALLOC_NMBR(functions.rfc.sap.document.sap_com.ALLOC_NMBR_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","CSHDIS_IND").equals(reader.getName())){
                                
                                                object.setCSHDIS_IND(functions.rfc.sap.document.sap_com.CSHDIS_IND_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","TAX_BASE_AMOUNT").equals(reader.getName())){
                                
                                                object.setTAX_BASE_AMOUNT(functions.rfc.sap.document.sap_com.TAX_BASE_AMOUNT_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","PROFIT_SEGM_NO").equals(reader.getName())){
                                
                                                object.setPROFIT_SEGM_NO(functions.rfc.sap.document.sap_com.PROFIT_SEGM_NO_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","PLANT").equals(reader.getName())){
                                
                                                object.setPLANT(functions.rfc.sap.document.sap_com.PLANT_type1.Factory.parse(reader));
                                              
                                        reader.next();
                                    
                              }  // End of if for expected property start element
                                
                                    else {
                                        
                                    }
                                
                                    
                                    while (!reader.isStartElement() && !reader.isEndElement()) reader.next();
                                
                                    if (reader.isStartElement() && new javax.xml.namespace.QName("","BUDGET_PERIOD").equals(reader.getName())){
                                
                                                object.setBUDGET_PERIOD(functions.rfc.sap.document.sap_com.BUDGET_PERIOD_type1.Factory.parse(reader));
                                              
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
           
    