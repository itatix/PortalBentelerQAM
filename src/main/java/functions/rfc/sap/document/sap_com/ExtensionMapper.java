
/**
 * ExtensionMapper.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:34:40 IST)
 */

        
            package functions.rfc.sap.document.sap_com;
        
            /**
            *  ExtensionMapper class
            */
            @SuppressWarnings({"unchecked","unused"})
        
        public  class ExtensionMapper{

          public static java.lang.Object getTypeObject(java.lang.String namespaceURI,
                                                       java.lang.String typeName,
                                                       javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception{

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "IV_LIFNR_type1".equals(typeName)){
                   
                            return  functions.rfc.sap.document.sap_com.IV_LIFNR_type1.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "EV_ID_type1".equals(typeName)){
                   
                            return  functions.rfc.sap.document.sap_com.EV_ID_type1.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "IV_BUKRS_type1".equals(typeName)){
                   
                            return  functions.rfc.sap.document.sap_com.IV_BUKRS_type1.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "IV_LIFNR_type1".equals(typeName)){
                   
                            return  functions.rfc.sap.document.sap_com.IV_LIFNR_type1.Factory.parse(reader);
                        

                  }

              
                  if (
                  "urn:sap-com:document:sap:rfc:functions".equals(namespaceURI) &&
                  "EV_TYPE_type1".equals(typeName)){
                   
                            return  functions.rfc.sap.document.sap_com.EV_TYPE_type1.Factory.parse(reader);
                        

                  }

              
             throw new org.apache.axis2.databinding.ADBException("Unsupported type " + namespaceURI + " " + typeName);
          }

        }
    