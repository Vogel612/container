/**
 * TScopeStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.apache.www.ode.pmapi.types._2006._08._02;

public class TScopeStatus implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected TScopeStatus(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _ACTIVE = "ACTIVE";
    public static final java.lang.String _COMPLETED = "COMPLETED";
    public static final java.lang.String _FAULTED = "FAULTED";
    public static final java.lang.String _FAULTHANDLING = "FAULTHANDLING";
    public static final java.lang.String _COMPENSATING = "COMPENSATING";
    public static final java.lang.String _COMPENSATED = "COMPENSATED";
    public static final TScopeStatus ACTIVE = new TScopeStatus(_ACTIVE);
    public static final TScopeStatus COMPLETED = new TScopeStatus(_COMPLETED);
    public static final TScopeStatus FAULTED = new TScopeStatus(_FAULTED);
    public static final TScopeStatus FAULTHANDLING = new TScopeStatus(_FAULTHANDLING);
    public static final TScopeStatus COMPENSATING = new TScopeStatus(_COMPENSATING);
    public static final TScopeStatus COMPENSATED = new TScopeStatus(_COMPENSATED);
    public java.lang.String getValue() { return _value_;}
    public static TScopeStatus fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        TScopeStatus enumeration = (TScopeStatus)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static TScopeStatus fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TScopeStatus.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.apache.org/ode/pmapi/types/2006/08/02/", "tScopeStatus"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
