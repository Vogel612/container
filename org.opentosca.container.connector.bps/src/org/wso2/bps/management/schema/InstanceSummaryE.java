
/**
 * InstanceSummaryE.java
 *
 * This file was auto-generated from WSDL by the Apache Axis2 version: SNAPSHOT Built on : Nov 10,
 * 2010 (06:34:21 UTC)
 */


package org.wso2.bps.management.schema;


/**
 * InstanceSummaryE bean class
 */

public class InstanceSummaryE implements org.apache.axis2.databinding.ADBBean {

    /**
     *
     */
    private static final long serialVersionUID = -2180644006560462909L;



    public static final javax.xml.namespace.QName MY_QNAME =
        new javax.xml.namespace.QName("http://wso2.org/bps/management/schema", "instanceSummary", "ns1");



    /**
     * field for Active
     */


    protected int localActive;


    /**
     * Auto generated getter method
     *
     * @return int
     */
    public int getActive() {
        return this.localActive;
    }



    /**
     * Auto generated setter method
     *
     * @param param Active
     */
    public void setActive(final int param) {

        this.localActive = param;


    }


    /**
     * field for Completed
     */


    protected int localCompleted;


    /**
     * Auto generated getter method
     *
     * @return int
     */
    public int getCompleted() {
        return this.localCompleted;
    }



    /**
     * Auto generated setter method
     *
     * @param param Completed
     */
    public void setCompleted(final int param) {

        this.localCompleted = param;


    }


    /**
     * field for Terminated
     */


    protected int localTerminated;


    /**
     * Auto generated getter method
     *
     * @return int
     */
    public int getTerminated() {
        return this.localTerminated;
    }



    /**
     * Auto generated setter method
     *
     * @param param Terminated
     */
    public void setTerminated(final int param) {

        this.localTerminated = param;


    }


    /**
     * field for Failed
     */


    protected int localFailed;


    /**
     * Auto generated getter method
     *
     * @return int
     */
    public int getFailed() {
        return this.localFailed;
    }



    /**
     * Auto generated setter method
     *
     * @param param Failed
     */
    public void setFailed(final int param) {

        this.localFailed = param;


    }


    /**
     * field for Suspended
     */


    protected int localSuspended;


    /**
     * Auto generated getter method
     *
     * @return int
     */
    public int getSuspended() {
        return this.localSuspended;
    }



    /**
     * Auto generated setter method
     *
     * @param param Suspended
     */
    public void setSuspended(final int param) {

        this.localSuspended = param;


    }



    /**
     *
     * @param parentQName
     * @param factory
     * @return org.apache.axiom.om.OMElement
     */
    @Override
    public org.apache.axiom.om.OMElement getOMElement(final javax.xml.namespace.QName parentQName,
                                                      final org.apache.axiom.om.OMFactory factory) throws org.apache.axis2.databinding.ADBException {



        final org.apache.axiom.om.OMDataSource dataSource =
            new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME);
        return new org.apache.axiom.om.impl.llom.OMSourcedElementImpl(MY_QNAME, factory, dataSource);

    }

    @Override
    public void serialize(final javax.xml.namespace.QName parentQName,
                          final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException,
                                                                            org.apache.axis2.databinding.ADBException {
        serialize(parentQName, xmlWriter, false);
    }

    @Override
    public void serialize(final javax.xml.namespace.QName parentQName, final javax.xml.stream.XMLStreamWriter xmlWriter,
                          final boolean serializeType) throws javax.xml.stream.XMLStreamException,
                                                       org.apache.axis2.databinding.ADBException {



        java.lang.String prefix = null;
        java.lang.String namespace = null;


        prefix = parentQName.getPrefix();
        namespace = parentQName.getNamespaceURI();
        writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

        if (serializeType) {


            final java.lang.String namespacePrefix = registerPrefix(xmlWriter, "http://wso2.org/bps/management/schema");
            if (namespacePrefix != null && namespacePrefix.trim().length() > 0) {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type",
                               namespacePrefix + ":instanceSummary", xmlWriter);
            } else {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "instanceSummary",
                               xmlWriter);
            }


        }

        namespace = "http://wso2.org/bps/management/schema";
        writeStartElement(null, namespace, "active", xmlWriter);

        if (this.localActive == java.lang.Integer.MIN_VALUE) {

            throw new org.apache.axis2.databinding.ADBException("active cannot be null!!");

        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(this.localActive));
        }

        xmlWriter.writeEndElement();

        namespace = "http://wso2.org/bps/management/schema";
        writeStartElement(null, namespace, "completed", xmlWriter);

        if (this.localCompleted == java.lang.Integer.MIN_VALUE) {

            throw new org.apache.axis2.databinding.ADBException("completed cannot be null!!");

        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(this.localCompleted));
        }

        xmlWriter.writeEndElement();

        namespace = "http://wso2.org/bps/management/schema";
        writeStartElement(null, namespace, "terminated", xmlWriter);

        if (this.localTerminated == java.lang.Integer.MIN_VALUE) {

            throw new org.apache.axis2.databinding.ADBException("terminated cannot be null!!");

        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(this.localTerminated));
        }

        xmlWriter.writeEndElement();

        namespace = "http://wso2.org/bps/management/schema";
        writeStartElement(null, namespace, "failed", xmlWriter);

        if (this.localFailed == java.lang.Integer.MIN_VALUE) {

            throw new org.apache.axis2.databinding.ADBException("failed cannot be null!!");

        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(this.localFailed));
        }

        xmlWriter.writeEndElement();

        namespace = "http://wso2.org/bps/management/schema";
        writeStartElement(null, namespace, "suspended", xmlWriter);

        if (this.localSuspended == java.lang.Integer.MIN_VALUE) {

            throw new org.apache.axis2.databinding.ADBException("suspended cannot be null!!");

        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(this.localSuspended));
        }

        xmlWriter.writeEndElement();

        xmlWriter.writeEndElement();


    }

    private static java.lang.String generatePrefix(final java.lang.String namespace) {
        if (namespace.equals("http://wso2.org/bps/management/schema")) {
            return "ns1";
        }
        return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /**
     * Utility method to write an element start tag.
     */
    private void writeStartElement(java.lang.String prefix, final java.lang.String namespace,
                                   final java.lang.String localPart,
                                   final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        final java.lang.String writerPrefix = xmlWriter.getPrefix(namespace);
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
    private void writeAttribute(final java.lang.String prefix, final java.lang.String namespace,
                                final java.lang.String attName, final java.lang.String attValue,
                                final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        if (xmlWriter.getPrefix(namespace) == null) {
            xmlWriter.writeNamespace(prefix, namespace);
            xmlWriter.setPrefix(prefix, namespace);
        }
        xmlWriter.writeAttribute(namespace, attName, attValue);
    }

    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeAttribute(final java.lang.String namespace, final java.lang.String attName,
                                final java.lang.String attValue,
                                final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        if (namespace.equals("")) {
            xmlWriter.writeAttribute(attName, attValue);
        } else {
            registerPrefix(xmlWriter, namespace);
            xmlWriter.writeAttribute(namespace, attName, attValue);
        }
    }


    /**
     * Util method to write an attribute without the ns prefix
     */
    private void writeQNameAttribute(final java.lang.String namespace, final java.lang.String attName,
                                     final javax.xml.namespace.QName qname,
                                     final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

        final java.lang.String attributeNamespace = qname.getNamespaceURI();
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
     * method to handle Qnames
     */

    private void writeQName(final javax.xml.namespace.QName qname,
                            final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {
        final java.lang.String namespaceURI = qname.getNamespaceURI();
        if (namespaceURI != null) {
            java.lang.String prefix = xmlWriter.getPrefix(namespaceURI);
            if (prefix == null) {
                prefix = generatePrefix(namespaceURI);
                xmlWriter.writeNamespace(prefix, namespaceURI);
                xmlWriter.setPrefix(prefix, namespaceURI);
            }

            if (prefix.trim().length() > 0) {
                xmlWriter.writeCharacters(prefix + ":"
                    + org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            } else {
                // i.e this is the default namespace
                xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
            }

        } else {
            xmlWriter.writeCharacters(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qname));
        }
    }

    private void writeQNames(final javax.xml.namespace.QName[] qnames,
                             final javax.xml.stream.XMLStreamWriter xmlWriter) throws javax.xml.stream.XMLStreamException {

        if (qnames != null) {
            // we have to store this data until last moment since it is not possible to write any
            // namespace data after writing the charactor data
            final java.lang.StringBuffer stringToWrite = new java.lang.StringBuffer();
            java.lang.String namespaceURI = null;
            java.lang.String prefix = null;

            for (int i = 0; i < qnames.length; i++) {
                if (i > 0) {
                    stringToWrite.append(" ");
                }
                namespaceURI = qnames[i].getNamespaceURI();
                if (namespaceURI != null) {
                    prefix = xmlWriter.getPrefix(namespaceURI);
                    if (prefix == null || prefix.length() == 0) {
                        prefix = generatePrefix(namespaceURI);
                        xmlWriter.writeNamespace(prefix, namespaceURI);
                        xmlWriter.setPrefix(prefix, namespaceURI);
                    }

                    if (prefix.trim().length() > 0) {
                        stringToWrite.append(prefix).append(":")
                                     .append(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(qnames[i]));
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
    private java.lang.String registerPrefix(final javax.xml.stream.XMLStreamWriter xmlWriter,
                                            final java.lang.String namespace) throws javax.xml.stream.XMLStreamException {
        java.lang.String prefix = xmlWriter.getPrefix(namespace);
        if (prefix == null) {
            prefix = generatePrefix(namespace);
            while (xmlWriter.getNamespaceContext().getNamespaceURI(prefix) != null) {
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
    @Override
    public javax.xml.stream.XMLStreamReader getPullParser(final javax.xml.namespace.QName qName) throws org.apache.axis2.databinding.ADBException {



        final java.util.ArrayList elementList = new java.util.ArrayList();
        final java.util.ArrayList attribList = new java.util.ArrayList();


        elementList.add(new javax.xml.namespace.QName("http://wso2.org/bps/management/schema", "active"));

        elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(this.localActive));

        elementList.add(new javax.xml.namespace.QName("http://wso2.org/bps/management/schema", "completed"));

        elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(this.localCompleted));

        elementList.add(new javax.xml.namespace.QName("http://wso2.org/bps/management/schema", "terminated"));

        elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(this.localTerminated));

        elementList.add(new javax.xml.namespace.QName("http://wso2.org/bps/management/schema", "failed"));

        elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(this.localFailed));

        elementList.add(new javax.xml.namespace.QName("http://wso2.org/bps/management/schema", "suspended"));

        elementList.add(org.apache.axis2.databinding.utils.ConverterUtil.convertToString(this.localSuspended));


        return new org.apache.axis2.databinding.utils.reader.ADBXMLStreamReaderImpl(qName, elementList.toArray(),
            attribList.toArray());



    }



    /**
     * Factory class that keeps the parse method
     */
    public static class Factory {



        /**
         * static method to create the object Precondition: If this object is an element, the current or
         * next start element starts this object and any intervening reader events are ignorable If this
         * object is not an element, it is a complex type and the reader is at the event just after the
         * outer start element Postcondition: If this object is an element, the reader is positioned at its
         * end element If this object is a complex type, the reader is positioned at the end element of its
         * outer element
         */
        public static InstanceSummaryE parse(final javax.xml.stream.XMLStreamReader reader) throws java.lang.Exception {
            final InstanceSummaryE object = new InstanceSummaryE();

            final int event;
            final java.lang.String nillableValue = null;
            final java.lang.String prefix = "";
            final java.lang.String namespaceuri = "";
            try {

                while (!reader.isStartElement() && !reader.isEndElement()) {
                    reader.next();
                }


                if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                    final java.lang.String fullTypeName =
                        reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");
                    if (fullTypeName != null) {
                        java.lang.String nsPrefix = null;
                        if (fullTypeName.indexOf(":") > -1) {
                            nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                        }
                        nsPrefix = nsPrefix == null ? "" : nsPrefix;

                        final java.lang.String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                        if (!"instanceSummary".equals(type)) {
                            // find namespace for the prefix
                            final java.lang.String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                            return (InstanceSummaryE) org.wso2.bps.management.wsdl.instancemanagement.ExtensionMapper.getTypeObject(nsUri,
                                                                                                                                    type,
                                                                                                                                    reader);
                        }


                    }


                }



                // Note all attributes that were handled. Used to differ normal attributes
                // from anyAttributes.
                final java.util.Vector handledAttributes = new java.util.Vector();



                reader.next();


                while (!reader.isStartElement() && !reader.isEndElement()) {
                    reader.next();
                }

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://wso2.org/bps/management/schema",
                    "active").equals(reader.getName())) {

                    final java.lang.String content = reader.getElementText();

                    object.setActive(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                    reader.next();

                } // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getLocalName());
                }


                while (!reader.isStartElement() && !reader.isEndElement()) {
                    reader.next();
                }

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://wso2.org/bps/management/schema",
                    "completed").equals(reader.getName())) {

                    final java.lang.String content = reader.getElementText();

                    object.setCompleted(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                    reader.next();

                } // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getLocalName());
                }


                while (!reader.isStartElement() && !reader.isEndElement()) {
                    reader.next();
                }

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://wso2.org/bps/management/schema",
                    "terminated").equals(reader.getName())) {

                    final java.lang.String content = reader.getElementText();

                    object.setTerminated(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                    reader.next();

                } // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getLocalName());
                }


                while (!reader.isStartElement() && !reader.isEndElement()) {
                    reader.next();
                }

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://wso2.org/bps/management/schema",
                    "failed").equals(reader.getName())) {

                    final java.lang.String content = reader.getElementText();

                    object.setFailed(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                    reader.next();

                } // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getLocalName());
                }


                while (!reader.isStartElement() && !reader.isEndElement()) {
                    reader.next();
                }

                if (reader.isStartElement() && new javax.xml.namespace.QName("http://wso2.org/bps/management/schema",
                    "suspended").equals(reader.getName())) {

                    final java.lang.String content = reader.getElementText();

                    object.setSuspended(org.apache.axis2.databinding.utils.ConverterUtil.convertToInt(content));

                    reader.next();

                } // End of if for expected property start element

                else {
                    // A start element we are not expecting indicates an invalid parameter was passed
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getLocalName());
                }

                while (!reader.isStartElement() && !reader.isEndElement()) {
                    reader.next();
                }

                if (reader.isStartElement()) {
                    // A start element we are not expecting indicates a trailing invalid
                    // property
                    throw new org.apache.axis2.databinding.ADBException(
                        "Unexpected subelement " + reader.getLocalName());
                }



            }
            catch (final javax.xml.stream.XMLStreamException e) {
                throw new java.lang.Exception(e);
            }

            return object;
        }

    }// end of factory class



}

