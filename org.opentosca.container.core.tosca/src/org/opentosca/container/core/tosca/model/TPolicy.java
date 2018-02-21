//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB)
// Reference Implementation, v2.2.4-2
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source
// schema.
// Generated on: 2013.07.10 at 12:45:26 PM CEST
//
// TOSCA version: TOSCA-v1.0-cs02.xsd
//

package org.opentosca.container.core.tosca.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;

/**
 * <p>
 * Java class for tPolicy complex type.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="tPolicy">
 *   &lt;complexContent>
 *     &lt;extension base="{http://docs.oasis-open.org/tosca/ns/2011/12}tExtensibleElements">
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="policyType" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;attribute name="policyRef" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tPolicy")
public class TPolicy extends TExtensibleElements {

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "policyType", required = true)
    protected QName policyType;
    @XmlAttribute(name = "policyRef")
    protected QName policyRef;


    /**
     * Gets the value of the name property.
     *
     * @return possible object is {@link String }
     *
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setName(final String value) {
        this.name = value;
    }

    /**
     * Gets the value of the policyType property.
     *
     * @return possible object is {@link QName }
     *
     */
    public QName getPolicyType() {
        return this.policyType;
    }

    /**
     * Sets the value of the policyType property.
     *
     * @param value allowed object is {@link QName }
     *
     */
    public void setPolicyType(final QName value) {
        this.policyType = value;
    }

    /**
     * Gets the value of the policyRef property.
     *
     * @return possible object is {@link QName }
     *
     */
    public QName getPolicyRef() {
        return this.policyRef;
    }

    /**
     * Sets the value of the policyRef property.
     *
     * @param value allowed object is {@link QName }
     *
     */
    public void setPolicyRef(final QName value) {
        this.policyRef = value;
    }

}
